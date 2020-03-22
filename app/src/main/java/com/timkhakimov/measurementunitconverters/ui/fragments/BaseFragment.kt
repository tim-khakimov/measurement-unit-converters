package com.timkhakimov.measurementunitconverters.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Timur Khakimov on 22.03.2020
 * Абстрактный класс для фрагментов
 */
abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    protected lateinit var binding : B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return binding.root
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected fun <VM : ViewModel> getViewModel(viewModelClass: Class<VM>): VM {
        val provider = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
        return provider.get(viewModelClass)
    }
}