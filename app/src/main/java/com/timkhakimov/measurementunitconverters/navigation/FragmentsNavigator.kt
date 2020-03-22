package com.timkhakimov.measurementunitconverters.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen

/**
 * Created by Timur Khakimov on 22.03.2020
 * Навигатор для переключения экранов
 */
class FragmentsNavigator(val fragmentManager: FragmentManager,
                         val containerId : Int,
                         val fragmentsFactory: FragmentsFactory) {

    fun switchToFragment(fragmentState: Screen?) {
        if (fragmentState == null) {
            return
        }
        setFragment(
            fragmentsFactory.createFragment(fragmentState), fragmentState !== Screen.START
        )
    }

    private fun setFragment(fragment: Fragment, isReplace: Boolean) {
        val transaction = fragmentManager.beginTransaction()
        if (isReplace) {
            transaction.replace(containerId, fragment)
        } else {
            transaction.add(containerId, fragment)
        }
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }
}