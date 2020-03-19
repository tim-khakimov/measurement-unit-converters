package com.timkhakimov.measurementunitconverters.domain.interactors

import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.domain.boundary.Status
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.domain.data.source.Repository
import com.timkhakimov.measurementunitconverters.domain.data.source.Response
import com.timkhakimov.measurementunitconverters.domain.data.storage.QuantitiesDataStorage

/**
 * Created by Timur Khakimov on 18.03.2020
 * Интерактор для работы с физическими величинами
 * Скачивает данные из репозитория, сохраняет и передает во внешние модули через OutputBoundary
 */
class QuantitiesInteractor {

    lateinit var repository: Repository
    lateinit var quantitiesOutputBoundary: OutputBoundary<Resource<List<Quantity>>>
    lateinit var quantitiesDataStorage: QuantitiesDataStorage

    fun loadQuantities() {
        quantitiesDataStorage.reset()
        quantitiesOutputBoundary.sendData(Resource(Status.LOADING))
        repository.getQuantities { handleResult(it) }
    }

    private fun handleResult(response: Response<List<Quantity>>) {
        response.data?.let { setQuantities(it) } ?: quantitiesOutputBoundary.sendData(Resource(Status.ERROR, null, response.throwable))
    }

    private fun setQuantities(quantities: List<Quantity>) {
        quantitiesDataStorage.setQuantities(quantities)
        quantitiesOutputBoundary.sendData(Resource(Status.SUCCESS, quantities))
    }
}