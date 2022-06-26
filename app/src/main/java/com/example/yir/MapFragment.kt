package com.example.yir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yir.databinding.FragmentMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.directions.DirectionsFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MapFragment : Fragment() {

	lateinit var mapView: MapView
	private lateinit var binding: FragmentMapBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		MapKitFactory.initialize(container?.context)
		DirectionsFactory.initialize(container?.context)
		super.onCreate(savedInstanceState)

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