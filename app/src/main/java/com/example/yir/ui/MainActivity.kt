package com.example.yir.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yir.R
import com.example.yir.data.setApi

class MainActivity : AppCompatActivity() {

	val list = mutableListOf<String>()

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setApi()

		supportFragmentManager.beginTransaction().add(R.id.container, MapFragment()).commit()
	}

	fun onNavigationItemSelected(item: Int){

		when(item) {
			1 -> supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment()).commit()
			2 -> supportFragmentManager.beginTransaction().replace(R.id.container, MapFragment()).commit()
			3 -> supportFragmentManager.beginTransaction().replace(R.id.container, PathListFragment()).commit()
		}
	}
}