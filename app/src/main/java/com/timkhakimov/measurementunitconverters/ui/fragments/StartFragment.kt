package com.timkhakimov.measurementunitconverters.ui.fragments

import android.os.Bundle
import com.timkhakimov.measurementunitconverters.R
import com.timkhakimov.measurementunitconverters.databinding.FragmentStartBinding
import com.timkhakimov.measurementunitconverters.presentation.viewmodel.StartViewModel

/**
 * Created by Timur Khakimov on 22.03.2020
 */
class StartFragment : BaseFragment<FragmentStartBinding>() {

    lateinit var startViewModel: StartViewModel

    override fun getLayoutRes(): Int {
        return R.layout.fragment_start
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startViewModel = getViewModel(StartViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.startViewModel = startViewModel
    }
}