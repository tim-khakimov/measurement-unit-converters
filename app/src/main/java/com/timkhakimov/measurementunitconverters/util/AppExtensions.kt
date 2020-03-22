package com.timkhakimov.measurementunitconverters.util

/**
 * Created by Timur Khakimov on 22.03.2020
 */
fun <T, M> Collection<T>.transformToList(transform: (T) -> M): List<M> {
    val list = mutableListOf<M>()
    for (item in this) {
        list.add(transform.invoke(item))
    }
    return list
}