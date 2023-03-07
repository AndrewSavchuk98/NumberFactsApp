package com.savchuk.andrew.numberfactsapp.di

import com.savchuk.andrew.numberfactsapp.domain.NumberFactsRepository
import com.savchuk.andrew.numberfactsapp.data.NumberFactsRepositoryImpl
import com.savchuk.andrew.numberfactsapp.data.local.LocalDataSource
import com.savchuk.andrew.numberfactsapp.data.local.RoomLocalDataSource
import com.savchuk.andrew.numberfactsapp.data.remote.RemoteDataSource
import com.savchuk.andrew.numberfactsapp.data.remote.RetrofitRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindRemoteRepository(
        numberFactsRepository: NumberFactsRepositoryImpl
    ): NumberFactsRepository

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        remoteDataSource: RetrofitRemoteDataSource
    ): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(
        localDataSource: RoomLocalDataSource
    ): LocalDataSource
}