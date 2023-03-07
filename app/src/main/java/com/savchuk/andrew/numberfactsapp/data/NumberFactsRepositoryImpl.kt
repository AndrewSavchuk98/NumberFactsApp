package com.savchuk.andrew.numberfactsapp.data

import com.savchuk.andrew.numberfactsapp.Mapper
import com.savchuk.andrew.numberfactsapp.domain.NumberFactsRepository
import com.savchuk.andrew.numberfactsapp.data.local.LocalDataSource
import com.savchuk.andrew.numberfactsapp.data.remote.RemoteDataSource
import com.savchuk.andrew.numberfactsapp.domain.NumberFact
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NumberFactsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val dispatcher: CoroutineDispatcher,
    private val mapper: Mapper<NumberData, NumberFact>
) : NumberFactsRepository {


    override suspend fun getNumberFact(number: String): NumberFact = withContext(dispatcher) {
        val dataSource = if (localDataSource.isContainsFact(number)) {
            localDataSource
        } else {
            remoteDataSource
        }
        //todo remove this
        if (dataSource is RemoteDataSource) {
            localDataSource.saveFact(remoteDataSource.getNumberFact(number))
        }

        val fact = dataSource.getNumberFact(number)
        return@withContext mapper.map(fact)
    }

    override suspend fun getRandomFact(): NumberFact = withContext(dispatcher) {
        val numberData = remoteDataSource.getRandomFact()
        localDataSource.saveFact(numberData)
        return@withContext mapper.map(numberData)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    override fun readNumbersFact(): Flow<List<NumberFact>> {
        return localDataSource.readNumbersFact()
            .mapLatest { numberDataList -> numberDataList.map { NumberFact(it.number, it.fact) } }
    }

}