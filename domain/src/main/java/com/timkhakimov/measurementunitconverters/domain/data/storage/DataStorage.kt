package com.timkhakimov.measurementunitconverters.domain.data.storage

/**
 * Created by Timur Khakimov on 18.03.2020
 * Хранилище данных / элементов
 */
open class DataStorage<T> {

    protected val itemsMap = mutableMapOf<Int, T>()

    protected inline fun setItems(items: Iterable<T>, keyFromItemFunction : (T) -> Int){
        itemsMap.clear()
        for (item in items) {
            itemsMap[keyFromItemFunction.invoke(item)] = item
        }
    }

    fun getItem(id : Int) : T? {
        return itemsMap[id]
    }

    open fun reset() {
        itemsMap.clear()
    }
}