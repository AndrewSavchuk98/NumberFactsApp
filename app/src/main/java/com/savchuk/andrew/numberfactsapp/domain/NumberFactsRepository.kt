package com.savchuk.andrew.numberfactsapp.domain

import kotlinx.coroutines.flow.Flow

interface NumberFactsRepository {

    suspend fun getNumberFact(number: String): NumberFact

    suspend fun getRandomFact(): NumberFact

    fun readNumbersFact(): Flow<List<NumberFact>>
}