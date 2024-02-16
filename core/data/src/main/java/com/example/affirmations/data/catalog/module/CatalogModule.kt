package com.example.affirmations.data.catalog.module

import com.example.affirmations.data.catalog.CatalogMapper
import com.example.affirmations.domain.catalog.CatalogRepository
import com.example.affirmations.data.catalog.CatalogRepositoryImpl
import com.example.affirmations.network.catalog.CatalogApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CatalogModule {
    @Provides
    fun provideCatalogRepository(catalogApi: CatalogApi, mapper: CatalogMapper): CatalogRepository {
        return CatalogRepositoryImpl(catalogApi, mapper)
    }
}