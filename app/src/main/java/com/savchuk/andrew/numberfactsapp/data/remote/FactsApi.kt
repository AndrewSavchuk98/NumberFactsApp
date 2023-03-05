package com.savchuk.andrew.numberfactsapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface FactsApi {

    @GET("{number}")
    suspend fun getNumberFact(@Path("number") number: String): String

    @GET("random/math")
    suspend fun getRandomFact(): String

}