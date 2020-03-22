package com.timkhakimov.measurementunitconverters.presentation.livedata

import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.presentation.mappers.ResourceListMapper
import com.timkhakimov.measurementunitconverters.presentation.model.QuantityListItem

/**
 * Created by Timur Khakimov on 22.03.2020
 * LiveData для хранения элементов QuantityListItem
 */
class QuantityListItemsLiveData(resourceListMapper: ResourceListMapper<Quantity, QuantityListItem>) : MappedListItemsLiveData<Quantity, QuantityListItem>(resourceListMapper) {
}