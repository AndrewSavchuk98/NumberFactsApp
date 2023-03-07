package com.savchuk.andrew.numberfactsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.savchuk.andrew.numberfactsapp.data.local.entities.NumberFactEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberFactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNumberFact(numberFactEntity: NumberFactEntity)

    @Query("SELECT * FROM number_fact ORDER BY id DESC")
    fun getNumbersFact(): Flow<List<NumberFactEntity>>

    @Query("SELECT * FROM number_fact WHERE number LIKE :number")
    fun getNumberFact(number: String): NumberFactEntity?
}