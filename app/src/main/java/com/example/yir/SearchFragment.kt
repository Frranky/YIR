package com.example.yir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class SearchFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.fragment_search, container, false)

		val button = view.findViewById<ImageButton>(R.id.backButton)

		button.setOnClickListener {
			(activity as MainActivity)?.onNavigationItemSelected(2)
		}

		return view
	}
}