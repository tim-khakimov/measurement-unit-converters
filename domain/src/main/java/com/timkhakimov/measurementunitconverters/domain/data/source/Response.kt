package com.timkhakimov.measurementunitconverters.domain.data.source

/**
 * Created by Timur Khakimov on 18.03.2020
 * Результат выполнения запросов
 * Либо данные, либо ошибка
 */
data class Response<T>(
    val data: T?,
    val throwable: Throwable?
)