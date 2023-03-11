package com.savchuk.andrew.numberfactsapp.data.remote

import com.savchuk.andrew.numberfactsapp.Mapper
import com.savchuk.andrew.numberfactsapp.data.NumberData

class ResponseMapper : Mapper<String, NumberData> {
    override fun map(value: String): NumberData {
        val response = value.split(" ", limit = 2)
        val number = response[0]
        val fact = response[1].trim()
        return NumberData(number, fact)
    }

}