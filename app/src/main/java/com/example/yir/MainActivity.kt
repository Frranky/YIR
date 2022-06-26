package com.example.yir

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.directions.DirectionsFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.ui_view.ViewProvider

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		MapKitFactory.setApiKey("52ff5c15-57b0-4dd0-b00d-5a6c50a6429b")

		supportFragmentManager.beginTransaction().add(R.id.container, MapFragment()).commit()
	}

	fun onNavigationItemSelected(item: Int){

		when(item) {
			1 -> supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment()).commit()
			2 -> supportFragmentManager.beginTransaction().replace(R.id.container, MapFragment()).commit()
		}
	}
}