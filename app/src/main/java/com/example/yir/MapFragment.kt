package com.example.yir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.directions.DirectionsFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.mapview.MapView

class MapFragment : Fragment() {

	private val endRoute = Point(41.275548, 69.204386) // 69.197425, 41.256773
	lateinit var mapView: MapView

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		MapKitFactory.initialize(container?.context)
		DirectionsFactory.initialize(container?.context)

		super.onCreate(savedInstanceState)
		val view = inflater.inflate(R.layout.fragment_map, container, false)

		mapView = view.findViewById(R.id.mapview)
		mapView.setOnClickListener {
			Toast.makeText(view.context, "hui", Toast.LENGTH_SHORT).show()
		}

		val button = view.findViewById<ImageButton>(R.id.wayButton)

		button.setOnClickListener {
			(activity as MainActivity)?.onNavigationItemSelected(1)
		}

		return view
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