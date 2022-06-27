package com.example.yir.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yir.databinding.FragmentMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.directions.DirectionsFactory
import com.yandex.mapkit.geometry.BoundingBox
import com.yandex.mapkit.geometry.Geometry
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.search.Response
import com.yandex.mapkit.search.SearchFactory
import com.yandex.mapkit.search.SearchManager
import com.yandex.mapkit.search.SearchManagerType
import com.yandex.mapkit.search.SearchOptions
import com.yandex.mapkit.search.Session
import com.yandex.mapkit.search.ToponymObjectMetadata
import com.yandex.runtime.Error

class MapFragment : Fragment() {

	private lateinit var mapView: MapView
	private lateinit var binding: FragmentMapBinding
	private lateinit var searchManager: SearchManager
	private lateinit var searchSession: Session

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		MapKitFactory.initialize(container?.context)
		DirectionsFactory.initialize(container?.context)
		SearchFactory.initialize(container?.context)

		super.onCreate(savedInstanceState)

		searchManager = SearchFactory.getInstance().createSearchManager(SearchManagerType.ONLINE);
		binding = FragmentMapBinding.inflate(inflater, container,false)

		mapView = binding.mapview
		mapView.getMap().move(
			CameraPosition(Point(56.4977, 84.9744), 11.0f, 0.0f, 0.0f),
			Animation(Animation.Type.SMOOTH, 0f),
			null
		)

		binding.pathButton.setOnClickListener {
			(activity as MainActivity)?.onNavigationItemSelected(1)
		}

		binding.searchButton.setOnClickListener {
			val boundingBox = BoundingBox(Point(56.564528, 84.856325), Point(56.455565, 85.082918))
			val location = Geometry.fromBoundingBox(boundingBox)

			searchSession = searchManager!!.submit(binding.searchText.toString(), location, SearchOptions(),
				object: Session.SearchListener {
					override fun onSearchError(error: Error) {
						Toast.makeText(container?.context, "Error", Toast.LENGTH_SHORT).show()
					}

					override fun onSearchResponse(response: Response) {
						val adr = response.collection.children.firstOrNull()?.obj
							?.metadataContainer
							?.getItem(ToponymObjectMetadata::class.java)
							?.address

						Toast.makeText(
							container?.context,
							adr.toString(),
							Toast.LENGTH_SHORT).show()
					}
				}
			)
		}

		if(!(activity as MainActivity)?.list.isEmpty()) {
			var string = ""
			for(point in (activity as MainActivity)?.list)
				string += "$point "
			Toast.makeText(container?.context, string, Toast.LENGTH_SHORT).show()
			(activity as MainActivity)?.list.clear()
		}

		return binding.root
	}

	override fun onStop() {
		super.onStop()
		mapView.onStop()
		MapKitFactory.getInstance().onStop()
	}

	override fun onStart() {
		super.onStart()
		mapView.onStart()
		MapKitFactory.getInstance().onStart()
	}
}