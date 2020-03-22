package com.timkhakimov.measurementunitconverters.navigation

import androidx.fragment.app.Fragment
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen

/**
 * Created by Timur Khakimov on 22.03.2020э
 * Интерфейс фабрики для создания экземпларов фрагментов
 */
interface FragmentsFactory {
    fun createFragment(screen: Screen) : Fragment
}