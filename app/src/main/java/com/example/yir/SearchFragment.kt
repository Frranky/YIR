package com.example.yir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.yir.databinding.FragmentMapBinding
import com.example.yir.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

	private lateinit var binding: FragmentSearchBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentSearchBinding.inflate(inflater, container, false)

		val button = binding.backButton

		button.setOnClickListener {
			(activity as MainActivity)?.onNavigationItemSelected(2)
		}

		return binding.root
	}
}