package com.savchuk.andrew.numberfactsapp.data.local

import com.savchuk.andrew.numberfactsapp.Mapper
import com.savchuk.andrew.numberfactsapp.data.NumberData
import com.savchuk.andrew.numberfactsapp.data.local.entities.NumberFactEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class RoomLocalDataSource @Inject constructor(
    private val numberDao: NumberFactDao,
    private val mapper: Mapper<NumberData, NumberFactEntity>
) : LocalDataSource {

    override suspend fun saveFact(numberFact: NumberData) {
        val numberFactEntity = mapper.map(numberFact)
        numberDao.saveNumberFact(numberFactEntity)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun readNumbersFact(): Flow<List<NumberData>> {
        return numberDao.getNumbersFact()
            .mapLatest { it.map { NumberData(it.number, it.fact) } }
    }

    override suspend fun getNumberFact(number: String): NumberData {
        val numberEntity = numberDao.getNumberFact(number)
            ?: NumberFactEntity(number = "", fact = "")
        return NumberData(numberEntity.number, numberEntity.fact)
    }

    override suspend fun isContainsFact(number: String): Boolean {
        val data = numberDao.getNumberFact(number)
        return data != null
    }
}