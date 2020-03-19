package com.timkhakimov.measurementunitconverters.domain.interactors

import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.source.Repository
import com.timkhakimov.measurementunitconverters.domain.data.source.Response
import com.timkhakimov.measurementunitconverters.domain.data.storage.MeasurementUnitsDataStorage
import com.timkhakimov.measurementunitconverters.domain.entity.UnitsConverter
import com.timkhakimov.measurementunitconverters.domain.entity.Utils
import com.timkhakimov.measurementunitconverters.domain.entity.Utils.anyNonNull
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit

/**
 * Created by Timur Khakimov on 19.03.2020
 */
@RunWith(JUnit4::class)
class MeasurementUnitsInteractorTest {

    @Mock
    lateinit var repository: Repository
    @Mock
    lateinit var unitsOutputBoundary: OutputBoundary<Resource<List<MeasurementUnit>>>
    @Mock
    lateinit var unitValuesOutputBoundary: OutputBoundary<Map<Int, Double>>
    @Mock
    lateinit var measurementUnitsDataStorage: MeasurementUnitsDataStorage
    @Mock
    lateinit var unitsConverter : UnitsConverter
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()
    val unitsList: MutableList<MeasurementUnit> = mutableListOf(
        Utils.measurementUnit(1, 1.0),
        Utils.measurementUnit(2, 2.0),
        Utils.measurementUnit(3, 4.0)
    )
    var measurementUnitsInteractor = MeasurementUnitsInteractor()

    @Before
    fun setUp() {
        measurementUnitsInteractor = MeasurementUnitsInteractor()
        measurementUnitsInteractor.repository = repository
        measurementUnitsInteractor.unitsOutputBoundary = unitsOutputBoundary
        measurementUnitsInteractor.unitValuesOutputBoundary = unitValuesOutputBoundary
        measurementUnitsInteractor.measurementUnitsDataStorage = measurementUnitsDataStorage
        measurementUnitsInteractor.unitsConverter = unitsConverter
    }

    @Test
    fun checkSuccessResponse() {
        setUpSuccessResponse()
        measurementUnitsInteractor.loadMeasurementUnits(1)
        verify(measurementUnitsDataStorage).reset()
        verify(repository).getUnits(anyInt(), anyNonNull())
        verify(unitsOutputBoundary, atMost(2)).sendData(anyNonNull())
        verify(measurementUnitsDataStorage).setMeasurementUnits(unitsList)
        verify(unitsConverter).convertUnitValue(anyInt(), anyDouble())
        verify(unitValuesOutputBoundary).sendData(anyMap())
        verifyNoMoreInteractions(repository)
        verifyNoMoreInteractions(unitsOutputBoundary)
        verifyNoMoreInteractions(unitValuesOutputBoundary)
    }

    @Test
    fun checkErrorResponse() {
        setUpErrorResponse()
        measurementUnitsInteractor.loadMeasurementUnits(1)
        verify(measurementUnitsDataStorage).reset()
        verify(repository).getUnits(anyInt(), anyNonNull())
        verify(unitsOutputBoundary, atMost(2)).sendData(anyNonNull())
        verifyNoMoreInteractions(repository)
        verifyNoMoreInteractions(measurementUnitsDataStorage)
        verifyNoMoreInteractions(unitsOutputBoundary)
        verifyZeroInteractions(unitValuesOutputBoundary)
    }

    @Test
    fun checkConvertingValues() {
        measurementUnitsInteractor.setMeasurementUnitValue(1, 2.0)
        verifyZeroInteractions(repository)
        verifyZeroInteractions(unitsOutputBoundary)
        verifyZeroInteractions(measurementUnitsDataStorage)
        verify(unitsConverter).convertUnitValue(1, 2.0)
        verify(unitValuesOutputBoundary).sendData(anyMap())
    }

    private fun setUpSuccessResponse() {
        doAnswer {
            val callback = it.arguments[1] as (Response<List<MeasurementUnit>>) -> Unit
            callback.invoke(Response(unitsList, null))
            null
        }.`when`(repository).getUnits(anyInt(), anyNonNull())
    }

    private fun setUpErrorResponse() {
        doAnswer {
            val callback = it.arguments[1] as (Response<List<MeasurementUnit>>) -> Unit
            callback.invoke(Response(null, Throwable("")))
            null
        }.`when`(repository).getUnits(anyInt(), anyNonNull())
    }
}