package com.timkhakimov.measurementunitconverters.ui.adapters

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Timur Khakimov on 22.03.2020
 */
class DataBindingRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var binding: ViewDataBinding

    init {
        binding = DataBindingUtil.bind(view)!!
    }

    fun <M> bind(variableId: Int, model: M) {
        binding.setVariable(variableId, model)
        binding.executePendingBindings()
    }
}