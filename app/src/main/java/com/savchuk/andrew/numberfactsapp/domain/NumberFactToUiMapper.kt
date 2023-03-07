package com.savchuk.andrew.numberfactsapp.domain

import com.savchuk.andrew.numberfactsapp.Mapper
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi

class NumberFactToUiMapper : Mapper<NumberFact, NumberFactUi> {
    override fun map(value: NumberFact): NumberFactUi {
        return NumberFactUi(value.number, value.fact)
    }
}