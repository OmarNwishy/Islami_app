package com.route.islami_42.ui.home.tabs.time_tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_42.databinding.FragmentTimeBinding

class TimeFragment : Fragment() {

    lateinit var  binding: FragmentTimeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimeBinding.inflate(inflater , container , false)
        return binding.root
    }

}