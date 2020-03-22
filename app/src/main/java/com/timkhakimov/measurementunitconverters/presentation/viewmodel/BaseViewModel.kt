package com.timkhakimov.measurementunitconverters.presentation.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen
import java.util.*
import javax.inject.Inject

/**
 * Created by Timur Khakimov on 22.03.2020
 * базовый класс для ViewModel
 */
open class BaseViewModel : ViewModel() {

    @Inject
    lateinit var screenSwitchQueueLiveData : MutableLiveData<Queue<Screen>>

    fun switchToScreen(screen: Screen) {
        val queue = screenSwitchQueueLiveData.value
        queue!!.add(screen)
        screenSwitchQueueLiveData.value = queue
    }

    fun observeScreen(lifecycleOwner: LifecycleOwner, observer: Observer<Screen>) {
        screenSwitchQueueLiveData.observe(lifecycleOwner, object : Observer<Queue<Screen>> {
            override fun onChanged(queue: Queue<Screen>?) {
                if (queue!!.size == 0) {
                    observer.onChanged(null)
                    return
                }
                val screen = queue.remove()
                observer.onChanged(screen)
                screenSwitchQueueLiveData.value = queue
            }
        })
    }
}