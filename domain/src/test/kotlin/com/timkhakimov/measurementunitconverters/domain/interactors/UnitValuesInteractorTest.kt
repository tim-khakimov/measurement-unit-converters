package com.timkhakimov.measurementunitconverters.domain.interactors

import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.entity.UnitsConverter
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyMap
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit

/**
 * Created by Timur Khakimov on 19.03.2020
 */
@RunWith(JUnit4::class)
class UnitValuesInteractorTest {

    @Mock
    lateinit var unitValuesOutputBoundary: OutputBoundary<Map<Int, Double>>
    @Mock
    lateinit var unitsConverter : UnitsConverter
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()
    var unitValuesInteractor = UnitValuesInteractor()

    @Before
    fun setUp() {
        unitValuesInteractor.unitValuesOutputBoundary = unitValuesOutputBoundary
        unitValuesInteractor.unitsConverter = unitsConverter
    }

    @Test
    fun checkConvertingValues() {
        unitValuesInteractor.setMeasurementUnitValue(1, 2.0)
        verify(unitsConverter).convertUnitValue(1, 2.0)
        verify(unitValuesOutputBoundary).sendData(anyMap())
    }
}