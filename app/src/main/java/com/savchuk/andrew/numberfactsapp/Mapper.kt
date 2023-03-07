package com.savchuk.andrew.numberfactsapp

interface Mapper<T, R> {

    fun map(value: T): R
}