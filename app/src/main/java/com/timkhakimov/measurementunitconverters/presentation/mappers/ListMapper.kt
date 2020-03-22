package com.timkhakimov.measurementunitconverters.presentation.mappers

import com.timkhakimov.measurementunitconverters.util.transformToList

/**
 * Created by Timur Khakimov on 22.03.2020
 */
class ListMapper<I, O>(private val itemMapper : Mapper<I, O>) : Mapper<List<I>, List<O>> {

    override fun map(inputData: List<I>): List<O> {
        return inputData.transformToList { itemMapper.map(it) }
    }
}