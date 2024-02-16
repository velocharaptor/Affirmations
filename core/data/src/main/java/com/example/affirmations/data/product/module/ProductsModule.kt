package com.example.affirmations.data.product.module

import com.example.affirmations.data.product.ProductMapper
import com.example.affirmations.domain.product.ProductsRepository
import com.example.affirmations.data.product.ProductsRepositoryImpl
import com.example.affirmations.network.product.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ProductsModule {
    @Provides
    fun provideProductsRepository(productApi: ProductApi, mapper: ProductMapper): ProductsRepository {
        return ProductsRepositoryImpl(productApi, mapper)
    }
}