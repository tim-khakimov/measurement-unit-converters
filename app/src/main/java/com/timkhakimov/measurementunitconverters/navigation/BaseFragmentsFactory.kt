package com.timkhakimov.measurementunitconverters.navigation

import androidx.fragment.app.Fragment
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen
import com.timkhakimov.measurementunitconverters.ui.fragments.EmptyFragment

/**
 * Created by Timur Khakimov on 22.03.2020
 */
class BaseFragmentsFactory : FragmentsFactory {
    override fun createFragment(screen: Screen): Fragment {
        return when(screen) {
            else -> EmptyFragment()
        }
    }
}