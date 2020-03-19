package com.timkhakimov.measurementunitconverters.domain.boundary

/**
 * Created by Timur Khakimov on 19.03.2020
 * Обертка для пересечения границ между domain и presentation
 */
class Resource<T>(
    val status: Status,
    val data: T? = null,
    val throwable: Throwable? = null
)

enum class Status {
    LOADING,
    ERROR,
    SUCCESS
}