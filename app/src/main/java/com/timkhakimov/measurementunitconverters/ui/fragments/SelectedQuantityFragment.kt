package com.timkhakimov.measurementunitconverters.ui.fragments

import android.os.Bundle
import com.timkhakimov.measurementunitconverters.BR
import com.timkhakimov.measurementunitconverters.R
import com.timkhakimov.measurementunitconverters.databinding.FragmentSelectedQuantityBinding
import com.timkhakimov.measurementunitconverters.presentation.model.MeasurementUnitValue
import com.timkhakimov.measurementunitconverters.presentation.viewmodel.SelectedQuantityViewModel
import com.timkhakimov.measurementunitconverters.ui.adapters.DataBindingRecyclerViewAdapter

/**
 * Created by Timur Khakimov on 25.03.2020
 * Список единиц измерения для выбранной физической величины
 */
class SelectedQuantityFragment : BaseFragment<FragmentSelectedQuantityBinding>() {

    private lateinit var selectedQuantityViewModel: SelectedQuantityViewModel
    private lateinit var adapter : MeasurementUnitsValuesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedQuantityViewModel = getViewModel(SelectedQuantityViewModel::class.java)
        adapter = MeasurementUnitsValuesAdapter(selectedQuantityViewModel)
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_selected_quantity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerViewAdapter = adapter
        binding.selectedQuantityViewModel = selectedQuantityViewModel
        binding.lifecycleOwner = this
    }

    private class MeasurementUnitsValuesAdapter(val selectedQuantityViewModel: SelectedQuantityViewModel) : DataBindingRecyclerViewAdapter<MeasurementUnitValue>() {

        override fun getLayoutRes(viewType: Int): Int {
            return R.layout.view_measurement_unit_value
        }

        override fun getVariableId(viewType: Int): Int {
            return BR.unitValue
        }
    }
}