package com.example.yir.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.yir.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

	private lateinit var binding: FragmentSearchBinding
	private lateinit var list: MutableList<EditText>

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentSearchBinding.inflate(inflater, container, false)

		binding.backButton.setOnClickListener {
			(activity as MainActivity)?.onNavigationItemSelected(2)
		}

		binding.pathButton.setOnClickListener {
			(activity as MainActivity)?.onNavigationItemSelected(3)
		}

		binding.searchButton.setOnClickListener {
			(activity as MainActivity)?.list.add(binding.startText.text.toString())
			(activity as MainActivity)?.list.add(binding.finishText.text.toString())
			(activity as MainActivity)?.onNavigationItemSelected(2)
		}

		return binding.root
	}
}