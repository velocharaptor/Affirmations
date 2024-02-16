package com.example.affirmations.network.home

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class HomeApiModule {
    @Provides
    fun provideHomeApiModule(): HomeApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.detmir.ru/v2/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(HomeApi::class.java)
    }
}