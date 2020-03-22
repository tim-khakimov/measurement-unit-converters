package com.timkhakimov.measurementunitconverters.presentation.mappers

/**
 * Created by Timur Khakimov on 22.03.2020
 */
interface Mapper<I, O> {
    fun map(inputData : I) : O
}