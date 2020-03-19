package com.timkhakimov.measurementunitconverters.data

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.domain.data.source.Repository
import com.timkhakimov.measurementunitconverters.domain.data.source.Response
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Timur Khakimov on 19.03.2020
 * Реализация Repository
 */
class DataRepository : Repository {

    lateinit var dataSource: DataSource
    private var getUnitsDisposable: Disposable? = null
    private var getQuantitiesDisposable: Disposable? = null

    override fun getQuantities(callback: (Response<List<Quantity>>) -> Unit) {
        disposeQuantities()
        dataSource.getQuantities()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Quantity>>{

                override fun onSubscribe(d: Disposable) {
                    getQuantitiesDisposable = d
                }

                override fun onSuccess(t: List<Quantity>) {
                    getQuantitiesDisposable = null
                    callback.invoke(Response(t, null))
                }

                override fun onError(e: Throwable) {
                    getQuantitiesDisposable = null
                    callback.invoke(Response(null, e))
                }
            })
    }

    override fun getUnits(quantityId: Int, callback: (Response<List<MeasurementUnit>>) -> Unit) {
        disposeUnits()
        dataSource.getUnits(quantityId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<MeasurementUnit>> {

                override fun onSubscribe(d: Disposable) {
                    getUnitsDisposable = d
                }

                override fun onSuccess(t: List<MeasurementUnit>) {
                    getUnitsDisposable = null
                    callback.invoke(Response(t, null))
                }

                override fun onError(e: Throwable) {
                    getUnitsDisposable = null
                    callback.invoke(Response(null, e))
                }
            })
    }

    private fun disposeUnits() {
        getUnitsDisposable?.let { dispose(it) }
        getUnitsDisposable = null
    }

    private fun disposeQuantities() {
        getQuantitiesDisposable?.let { dispose(it) }
        getQuantitiesDisposable = null
    }

    private fun dispose(disposable: Disposable) {
        if(!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}