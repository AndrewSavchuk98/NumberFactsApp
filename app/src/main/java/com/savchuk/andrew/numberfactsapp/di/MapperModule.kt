package com.savchuk.andrew.numberfactsapp.di

import com.savchuk.andrew.numberfactsapp.Mapper
import com.savchuk.andrew.numberfactsapp.data.NumberData
import com.savchuk.andrew.numberfactsapp.data.NumberDataToDomainMapper
import com.savchuk.andrew.numberfactsapp.data.local.ToNumberDataMapper
import com.savchuk.andrew.numberfactsapp.data.local.entities.NumberFactEntity
import com.savchuk.andrew.numberfactsapp.domain.NumberFact
import com.savchuk.andrew.numberfactsapp.domain.NumberFactToUiMapper
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {
    @Provides
    @Singleton
    fun provideEntityToDataMapper(): Mapper<NumberData, NumberFactEntity> {
        return ToNumberDataMapper()
    }

    @Provides
    @Singleton
    fun provideDataToDomainMapper(): Mapper<NumberData, NumberFact> {
        return NumberDataToDomainMapper()
    }

    @Provides
    @Singleton
    fun provideDomainToUiMapper(): Mapper<NumberFact, NumberFactUi> {
        return NumberFactToUiMapper()
    }

}