package com.example.affirmations.data.home.module

import com.example.affirmations.data.home.HomeMapper
import com.example.affirmations.domain.home.HomeRepository
import com.example.affirmations.data.home.HomeRepositoryImpl
import com.example.affirmations.network.home.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {
    @Provides
    fun provideHomeRepository(homeApi: HomeApi, mapper: HomeMapper) : HomeRepository {
        return HomeRepositoryImpl(homeApi, mapper)
    }
}