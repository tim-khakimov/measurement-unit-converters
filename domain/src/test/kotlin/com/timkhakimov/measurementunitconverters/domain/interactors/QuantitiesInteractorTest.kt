package com.timkhakimov.measurementunitconverters.domain.interactors

import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.domain.data.source.Repository
import com.timkhakimov.measurementunitconverters.domain.data.source.Response
import com.timkhakimov.measurementunitconverters.domain.data.storage.QuantitiesDataStorage
import com.timkhakimov.measurementunitconverters.domain.entity.Utils.anyNonNull
import com.timkhakimov.measurementunitconverters.domain.entity.Utils.quantity
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit

/**
 * Created by Timur Khakimov on 19.03.2020
 */
@RunWith(JUnit4::class)
class QuantitiesInteractorTest {

    @Mock
    lateinit var repository: Repository
    @Mock
    lateinit var quantitiesOutputBoundary: OutputBoundary<Resource<List<Quantity>>>
    @Mock
    lateinit var quantitiesDataStorage: QuantitiesDataStorage
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()
    private var quantitiesInteractor = QuantitiesInteractor()

    @Before
    fun setUp() {
        quantitiesInteractor.repository = repository
        quantitiesInteractor.quantitiesOutputBoundary = quantitiesOutputBoundary
        quantitiesInteractor.quantitiesDataStorage = quantitiesDataStorage
    }

    @Test
    fun testSuccessLoadingQuantities() {
        setUpSuccessResponse()
        quantitiesInteractor.loadQuantities()
        verify(quantitiesDataStorage).reset()
        verify(repository).getQuantities(anyNonNull())
        verify(quantitiesDataStorage).setQuantities(ArgumentMatchers.anyList())
        verify(quantitiesOutputBoundary, atMost(2)).sendData(anyNonNull())
        verifyNoMoreInteractions(repository)
    }

    @Test
    fun testErrorLoadingQuantities() {
        setUpErrorResponse()
        quantitiesInteractor.loadQuantities()
        verify(quantitiesDataStorage).reset()
        verify(repository).getQuantities(anyNonNull())
        verify(quantitiesOutputBoundary, atMost(2)).sendData(anyNonNull())
        verifyNoMoreInteractions(quantitiesDataStorage)
        verifyNoMoreInteractions(repository)
    }

    private fun setUpSuccessResponse() {
        doAnswer {
            val callback = it.arguments[0] as (Response<List<Quantity>>) -> Unit
            callback.invoke(Response(listOf(quantity(1), quantity(2), quantity(3)), null))
            null
        }.`when`(repository).getQuantities(anyNonNull())
    }

    private fun setUpErrorResponse() {
        doAnswer {
            val callback = it.arguments[0] as (Response<List<Quantity>>) -> Unit
            callback.invoke(Response(null, Throwable("")))
            null
        }.`when`(repository).getQuantities(anyNonNull())
    }
}