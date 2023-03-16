package com.savchuk.andrew.numberfactsapp.domain

interface Mapper<T, R> {

    fun map(value: T): R
}