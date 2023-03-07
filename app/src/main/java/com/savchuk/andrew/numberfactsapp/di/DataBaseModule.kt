package com.savchuk.andrew.numberfactsapp.di

import android.content.Context
import androidx.room.Room
import com.savchuk.andrew.numberfactsapp.data.local.NumberFactDao
import com.savchuk.andrew.numberfactsapp.data.local.NumberFactDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            NumberFactDataBase::class.java,
            NUMBER_FACT_DATABASE_NAME
        ).build()


    @Provides
    @Singleton
    fun provideNumberFactDao(dataBase: NumberFactDataBase): NumberFactDao =
        dataBase.numberFactDao()


    companion object {
        private const val NUMBER_FACT_DATABASE_NAME = "numbers_fact.db"
    }

}