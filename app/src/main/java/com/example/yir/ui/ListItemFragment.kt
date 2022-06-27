package com.example.yir.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yir.databinding.FragmentListItemBinding

class ListItemFragment : Fragment() {

	private lateinit var binding: FragmentListItemBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentListItemBinding.inflate(inflater, container, false)

		return binding.root
	}

}