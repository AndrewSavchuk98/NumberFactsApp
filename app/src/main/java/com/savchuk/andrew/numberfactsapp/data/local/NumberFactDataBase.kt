package com.savchuk.andrew.numberfactsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.savchuk.andrew.numberfactsapp.data.local.entities.NumberFactEntity

@Database(
    entities = [NumberFactEntity::class],
    version = 1
)
abstract class NumberFactDataBase : RoomDatabase() {

    abstract fun numberFactDao(): NumberFactDao
}