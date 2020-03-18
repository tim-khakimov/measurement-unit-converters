package com.timkhakimov.measurementunitconverters.domain.boundary

/**
 * Created by Timur Khakimov on 18.03.2020
 * Для отправки данных из domain в presentation слой
 */
interface OutputBoundary<D> {
    fun sendData(data : D)
}