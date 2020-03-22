package com.timkhakimov.measurementunitconverters.di

import com.timkhakimov.measurementunitconverters.di.modules.domain.DomainModule
import com.timkhakimov.measurementunitconverters.di.modules.presentation.PresentationModule
import com.timkhakimov.measurementunitconverters.presentation.viewmodel.MainViewModel
import com.timkhakimov.measurementunitconverters.presentation.viewmodel.QuantitiesViewModel
import com.timkhakimov.measurementunitconverters.presentation.viewmodel.StartViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Singleton
@Component(modules = arrayOf(PresentationModule::class, DomainModule::class))
interface AppComponent {
    fun inject(mainViewModel: MainViewModel)
    fun inject(startViewModel: StartViewModel)
    fun inject(quantitiesViewModel: QuantitiesViewModel)
}