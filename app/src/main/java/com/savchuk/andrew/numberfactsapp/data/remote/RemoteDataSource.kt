package com.savchuk.andrew.numberfactsapp.data.remote

import com.savchuk.andrew.numberfactsapp.data.DataSource
import com.savchuk.andrew.numberfactsapp.data.NumberData

interface RemoteDataSource : DataSource {

    suspend fun getRandomFact(): NumberData
}