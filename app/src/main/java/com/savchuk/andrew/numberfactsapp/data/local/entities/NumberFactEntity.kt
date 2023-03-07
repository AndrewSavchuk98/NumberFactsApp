package com.savchuk.andrew.numberfactsapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number_fact")
data class NumberFactEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "fact") val fact: String
)
