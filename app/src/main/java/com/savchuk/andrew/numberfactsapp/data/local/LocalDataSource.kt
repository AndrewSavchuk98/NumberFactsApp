package com.savchuk.andrew.numberfactsapp.data.local

import com.savchuk.andrew.numberfactsapp.data.DataSource
import com.savchuk.andrew.numberfactsapp.data.NumberData
import kotlinx.coroutines.flow.Flow

interface LocalDataSource : DataSource{

    suspend fun saveFact(numberFact: NumberData)

    fun readNumbersFact(): Flow<List<NumberData>>

    suspend fun isContainsFact(number: String): Boolean

}