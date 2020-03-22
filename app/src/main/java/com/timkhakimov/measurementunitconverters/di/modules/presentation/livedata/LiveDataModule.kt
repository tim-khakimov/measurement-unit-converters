package com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata

import androidx.lifecycle.MutableLiveData
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module
class LiveDataModule {

    @Singleton
    @Provides
    fun getScreenSwitchQueueLiveData(): MutableLiveData<Queue<Screen>> {
        val queue = ArrayDeque<Screen>()
        val liveData = MutableLiveData<Queue<Screen>>()
        liveData.value = queue
        return liveData
    }
}