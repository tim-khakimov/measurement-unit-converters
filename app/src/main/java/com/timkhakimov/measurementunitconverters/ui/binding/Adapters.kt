package com.timkhakimov.measurementunitconverters.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timkhakimov.measurementunitconverters.ui.adapters.DataBindingRecyclerViewAdapter

/**
 * Created by Timur Khakimov on 22.03.2020
 */
object Adapters {

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setData(recyclerView: RecyclerView, data: List<T>?) {
        if (recyclerView.adapter != null) {
            (recyclerView.adapter as DataBindingRecyclerViewAdapter<T>).setItems(
                data ?: mutableListOf()
            )
        }
    }
}