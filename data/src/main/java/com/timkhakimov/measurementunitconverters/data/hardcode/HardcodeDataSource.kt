package com.timkhakimov.measurementunitconverters.data.hardcode

import com.timkhakimov.measurementunitconverters.data.DataSource
import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import io.reactivex.Single
import java.util.concurrent.TimeUnit

/**
 * Created by Timur Khakimov on 19.03.2020
 */
class HardcodeDataSource : DataSource {

    override fun getQuantities(): Single<List<Quantity>> {
        return Single.just(HardcodeUtils.getQuantities()).delay(1, TimeUnit.SECONDS)
    }

    override fun getUnits(quantityId: Int): Single<List<MeasurementUnit>> {
        return Single.just(HardcodeUtils.getUnits(quantityId)).delay(1, TimeUnit.SECONDS)
    }
}