package com.timkhakimov.measurementunitconverters.data.hardcode

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity

/**
 * Created by Timur Khakimov on 19.03.2020
 */
object HardcodeUtils {

    fun getQuantities() : List<Quantity> {
        val list = mutableListOf<Quantity>()
        list.add(Quantity(HardcodeConstants.Quantities.LENGTH, "Длина"))
        list.add(Quantity(HardcodeConstants.Quantities.AREA, "Площадь"))
        list.add(Quantity(HardcodeConstants.Quantities.MASS, "Масса"))
        return list
    }

    fun getUnits(quantityId : Int) : List<MeasurementUnit> {
        val builder = UnitsBuilder()
        return when(quantityId) {
            HardcodeConstants.Quantities.LENGTH -> fillLengthUnits(builder)
            HardcodeConstants.Quantities.AREA -> fillAreasUnits(builder)
            HardcodeConstants.Quantities.MASS -> fillMassUnits(builder)
            else -> mutableListOf()
        }
    }

    private fun fillLengthUnits(unitsBuilder: UnitsBuilder) : List<MeasurementUnit> {
        unitsBuilder
            .add(HardcodeConstants.Length.METER, "m", "Метры", 1.0)
            .add(HardcodeConstants.Length.FOOT, "ft", "Футы", 0.3048)
            .add(HardcodeConstants.Length.YARD, "yd", "Ярды", 0.9144)
            .add(HardcodeConstants.Length.INCH, "in", "Дюймы", 0.0254)
        return unitsBuilder.build()
    }

    private fun fillMassUnits(unitsBuilder: UnitsBuilder) : List<MeasurementUnit> {
        unitsBuilder
            .add(HardcodeConstants.MASS.KILOGRAM, "kg", "Килограммы", 1.0)
            .add(HardcodeConstants.MASS.POUND, "lbm", "Фунты", 0.4535924)
            .add(HardcodeConstants.MASS.OUNCE, "oz", "Унции", 0.02834952)
            .add(HardcodeConstants.MASS.STONE, "st", "Стоуны", 6.3502936)
        return unitsBuilder.build()
    }

    private fun fillAreasUnits(unitsBuilder: UnitsBuilder) : List<MeasurementUnit> {
        unitsBuilder
            .add(HardcodeConstants.Area.SQ_METER, "m²", "Кв. метры", 1.0)
            .add(HardcodeConstants.Area.SQ_FOOT, "sq ft", "Кв. футы", 0.09290304)
            .add(HardcodeConstants.Area.SQ_YARD, "sq yd", "Кв. ярды", 0.8361274)
            .add(HardcodeConstants.Area.ACRE, "acre", "Акры", 4046.856)
            .add(HardcodeConstants.Area.HECTARE, "ha", "Гектары", 10000.0)
        return unitsBuilder.build()
    }
}