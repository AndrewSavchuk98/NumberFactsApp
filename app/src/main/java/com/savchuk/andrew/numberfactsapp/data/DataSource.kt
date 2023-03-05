package com.savchuk.andrew.numberfactsapp.data

interface DataSource {

    suspend fun getNumberFact(number: String): NumberData
}