package com.timkhakimov.measurementunitconverters.domain.interactors

import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.domain.boundary.Status
import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.source.Repository
import com.timkhakimov.measurementunitconverters.domain.data.source.Response
import com.timkhakimov.measurementunitconverters.domain.data.storage.MeasurementUnitsDataStorage
import com.timkhakimov.measurementunitconverters.domain.entity.UnitsConverter

/**
 * Created by Timur Khakimov on 19.03.2020
 * Интерактор для работы с единицами измерения
 * 1) Скачивает ед-цы измерения из репозитория, сохраняет и передает во внешние модули через OutputBoundary
 * 2) Конвертирует значения ед-ц измерения
 */
class MeasurementUnitsInteractor {

    lateinit var repository: Repository
    lateinit var unitsOutputBoundary: OutputBoundary<Resource<List<MeasurementUnit>>>
    lateinit var unitValuesOutputBoundary: OutputBoundary<Map<Int, Double>>
    lateinit var measurementUnitsDataStorage: MeasurementUnitsDataStorage
    lateinit var unitsConverter: UnitsConverter

    fun loadMeasurementUnits(quantityId: Int) {
        measurementUnitsDataStorage.reset()
        unitsOutputBoundary.sendData(Resource(Status.LOADING))
        repository.getUnits(quantityId) { handleResult(it) }
    }

    private fun handleResult(result: Response<List<MeasurementUnit>>) {
        result.data?.let { setMeasurementUnits(it) }
            ?: unitsOutputBoundary.sendData(Resource(Status.ERROR, null, result.throwable))
    }

    private fun setMeasurementUnits(units: List<MeasurementUnit>) {
        measurementUnitsDataStorage.setMeasurementUnits(units)
        unitsOutputBoundary.sendData(Resource(Status.SUCCESS, units))
        if (units.isNotEmpty()) {
            setMeasurementUnitValue(units[0].id, 1.0)
        }
    }

    fun setMeasurementUnitValue(unitId: Int, value: Double) {
        unitValuesOutputBoundary.sendData(unitsConverter.convertUnitValue(unitId, value))
    }
}