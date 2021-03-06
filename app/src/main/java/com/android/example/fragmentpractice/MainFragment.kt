package com.android.example.fragmentpractice

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.android.example.fragmentpractice.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            activity?.finish()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.firstButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.container, FirstFragment())
                addToBackStack("Main")
                commit()
            }
        }

        binding.secondButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.container, SecondFragment())
                addToBackStack("Main")
                commit()
            }
        }

        return binding.root
    }
}