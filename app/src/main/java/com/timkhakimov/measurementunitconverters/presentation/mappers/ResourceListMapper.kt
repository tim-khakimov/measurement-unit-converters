package com.timkhakimov.measurementunitconverters.presentation.mappers

import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.util.transformToList

/**
 * Created by Timur Khakimov on 22.03.2020
 * Маппер для преобразования списков моделей, упакованных в Resource
 */
class ResourceListMapper<I, O>(private val itemMapper: Mapper<I, O>) :
    Mapper<Resource<List<I>>, Resource<List<O>>> {

    override fun map(domainModelsResourse: Resource<List<I>>): Resource<List<O>> {
        return Resource(domainModelsResourse.status, mapList(domainModelsResourse.data), domainModelsResourse.throwable)
    }

    private fun mapList(domainModelsList: List<I>?): List<O>? {
        return domainModelsList?.let { list ->
            list.transformToList { itemMapper.map(it) }
        }
    }
}