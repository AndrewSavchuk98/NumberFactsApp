package com.savchuk.andrew.numberfactsapp.data.remote

import com.savchuk.andrew.numberfactsapp.data.NumberData
import javax.inject.Inject

class RetrofitRemoteDataSource @Inject constructor(private val service: FactsApi) :
    RemoteDataSource {

    override suspend fun getNumberFact(number: String): NumberData {
        try {
            val fact = service.getNumberFact(number)
            return NumberData(number, fact)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getRandomFact(): NumberData {
        //Todo parse random number
        try {
            val response = service.getRandomFact()
            return NumberData("", response)
        } catch (e: Exception){
            throw e
        }

    }
}