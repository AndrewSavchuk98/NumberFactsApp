package com.savchuk.andrew.numberfactsapp.data.local

import com.savchuk.andrew.numberfactsapp.Mapper
import com.savchuk.andrew.numberfactsapp.data.NumberData
import com.savchuk.andrew.numberfactsapp.data.local.entities.NumberFactEntity

class ToNumberDataMapper: Mapper<NumberData, NumberFactEntity> {
    override fun map(value: NumberData): NumberFactEntity {
        return NumberFactEntity(number = value.number, fact = value.fact)
    }
}