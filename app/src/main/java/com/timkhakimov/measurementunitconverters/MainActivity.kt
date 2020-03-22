package com.timkhakimov.measurementunitconverters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.timkhakimov.measurementunitconverters.navigation.BaseFragmentsFactory
import com.timkhakimov.measurementunitconverters.navigation.FragmentsNavigator
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen
import com.timkhakimov.measurementunitconverters.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var navigator: FragmentsNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initState()
        observeData()
        if (savedInstanceState == null) {
            mainViewModel.switchToScreen(Screen.START)
        }
    }

    private fun initState() {
        mainViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(MainViewModel::class.java)
        navigator = FragmentsNavigator(supportFragmentManager, R.id.frameContainer, BaseFragmentsFactory())
    }

    private fun observeData() {
        mainViewModel.observeScreen(this, Observer { fragmentState -> navigator.switchToFragment(fragmentState) })
    }
}
