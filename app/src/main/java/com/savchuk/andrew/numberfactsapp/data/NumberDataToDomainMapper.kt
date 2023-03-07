package com.savchuk.andrew.numberfactsapp.data

import com.savchuk.andrew.numberfactsapp.Mapper
import com.savchuk.andrew.numberfactsapp.domain.NumberFact

class NumberDataToDomainMapper : Mapper<NumberData, NumberFact> {
    override fun map(value: NumberData): NumberFact {
        return NumberFact(value.number, value.fact)
    }
}