package com.example.yir.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yir.databinding.FragmentPathListBinding

class PathListFragment : Fragment() {

	private lateinit var binding: FragmentPathListBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentPathListBinding.inflate(inflater, container, false)



		if(!(activity as MainActivity)?.list.isEmpty()) {

		}

		return binding.root
	}
}