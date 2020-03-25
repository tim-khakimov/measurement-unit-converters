package com.timkhakimov.measurementunitconverters.navigation

import androidx.fragment.app.Fragment
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen
import com.timkhakimov.measurementunitconverters.ui.fragments.EmptyFragment
import com.timkhakimov.measurementunitconverters.ui.fragments.QuantitiesFragment
import com.timkhakimov.measurementunitconverters.ui.fragments.SelectedQuantityFragment
import com.timkhakimov.measurementunitconverters.ui.fragments.StartFragment

/**
 * Created by Timur Khakimov on 22.03.2020
 */
class BaseFragmentsFactory : FragmentsFactory {
    override fun createFragment(screen: Screen): Fragment {
        return when(screen) {
            Screen.START -> StartFragment()
            Screen.QUANTITIES -> QuantitiesFragment()
            Screen.SELECTED_QUANTITY -> SelectedQuantityFragment()
            else -> EmptyFragment()
        }
    }
}