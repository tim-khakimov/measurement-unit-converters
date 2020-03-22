package com.timkhakimov.measurementunitconverters.ui.fragments

import android.os.Bundle
import com.timkhakimov.measurementunitconverters.BR
import com.timkhakimov.measurementunitconverters.R
import com.timkhakimov.measurementunitconverters.databinding.FragmentQuantitiesBinding
import com.timkhakimov.measurementunitconverters.presentation.model.QuantityListItem
import com.timkhakimov.measurementunitconverters.presentation.viewmodel.QuantitiesViewModel
import com.timkhakimov.measurementunitconverters.ui.adapters.DataBindingRecyclerViewAdapter
import com.timkhakimov.measurementunitconverters.ui.adapters.DataBindingRecyclerViewHolder

/**
 * Created by Timur Khakimov on 22.03.2020
 * Список физических величин
 */
class QuantitiesFragment : BaseFragment<FragmentQuantitiesBinding>() {

    private lateinit var quantitiesViewModel: QuantitiesViewModel
    private lateinit var adapter : QuantitiesAdapter

    override fun getLayoutRes(): Int {
        return R.layout.fragment_quantities
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quantitiesViewModel = getViewModel(QuantitiesViewModel::class.java)
        adapter = QuantitiesAdapter(quantitiesViewModel)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerViewAdapter = adapter
        binding.quantitiesViewModel = quantitiesViewModel
        binding.lifecycleOwner = this
    }

    private class QuantitiesAdapter(private val quantitiesViewModel: QuantitiesViewModel) : DataBindingRecyclerViewAdapter<QuantityListItem>() {

        override fun getLayoutRes(viewType: Int): Int {
            return R.layout.view_quantity
        }

        override fun getVariableId(viewType: Int): Int {
            return BR.item
        }

        override fun onBindViewHolder(holder: DataBindingRecyclerViewHolder, position: Int) {
            super.onBindViewHolder(holder, position)
            holder.bind(BR.viewModel, quantitiesViewModel)
        }
    }
}