package com.timkhakimov.measurementunitconverters.domain.entity

import com.timkhakimov.measurementunitconverters.domain.data.storage.MeasurementUnitsDataStorage
import com.timkhakimov.measurementunitconverters.domain.entity.Utils.measurementUnit
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Timur Khakimov on 18.03.2020
 */
@RunWith(JUnit4::class)
class UnitsConverterTest {

    val measurementUnitsData = MeasurementUnitsDataStorage()
    val unitsConverter = UnitsConverter(measurementUnitsData)
    val first = 1
    val second = 2
    val third = 3
    val conversion1 = 1.0
    val conversion2 = 2.0
    val conversion3 = 4.0
    val unitsList = mutableListOf(
        measurementUnit(first, conversion1),
        measurementUnit(second, conversion2),
        measurementUnit(third, conversion3))

    @Before
    @Throws(Exception::class)
    fun setUp() {
        measurementUnitsData.setMeasurementUnits(unitsList)
    }

    @Test
    fun normalScenario() {
        val unitsValues = unitsConverter.convertUnitValue(first, 4.0)
        assert(unitsValues.size == 3)
        assertNotNull(unitsValues.get(first))
        assert(unitsValues.get(first) == 4.0)
        assert(unitsValues.get(second) == 2.0)
        assert(unitsValues.get(third) == 1.0)
    }

    @Test
    fun inputZeroValue() {
        val unitsValues = unitsConverter.convertUnitValue(first, 0.0)
        assert(unitsValues.size == 3)
        assertNotNull(unitsValues.get(first))
        assert(unitsValues.get(first) == 0.0)
        assert(unitsValues.get(third) == 0.0)
    }

    @Test
    fun inputWrongKey() {
        val unitsValues = unitsConverter.convertUnitValue(-1, 10.0)
        assert(unitsValues.size == 1)
        assertNotNull(unitsValues.get(-1))
        assert(unitsValues.get(-1) == 10.0)
    }

    @Test
    fun emptyUnitsData() {
        measurementUnitsData.setMeasurementUnits(listOf())
        val unitsValues = unitsConverter.convertUnitValue(first, 2.0)
        assert(unitsValues.size == 1)
        assertNotNull(unitsValues.get(first))
        assert(unitsValues.get(first) == 2.0)
    }

    @Test
    fun zeroMultiplier() {
        val zeroM = 4
        unitsList.add(measurementUnit(zeroM, 0.0))
        measurementUnitsData.setMeasurementUnits(unitsList)
        val unitsValues = unitsConverter.convertUnitValue(first, 2.0)
        assert(unitsValues.size == 4)
        assertNotNull(unitsValues.get(zeroM))
        assert(unitsValues.get(first) == 2.0)
        assert(unitsValues.get(second) == 1.0)
        assert(unitsValues.get(third) == 0.5)
        assert(unitsValues.get(zeroM) == 0.0)
    }
}