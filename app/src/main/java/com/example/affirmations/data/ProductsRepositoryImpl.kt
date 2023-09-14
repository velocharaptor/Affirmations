package com.example.affirmations.data

import com.example.affirmations.retrofit.ProductApi
import com.example.affirmations.retrofit.ProductRequest
import com.example.affirmations.retrofit.ProductResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsRepositoryImpl: ProductsRepository {

    private val productApi: ProductApi

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.detmir.ru/v2/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        productApi = retrofit.create(ProductApi::class.java)
    }


    override suspend fun getProducts(productRequest: ProductRequest): List<ProductResponse> {
        return productApi.getProducts(
           filter = productRequest.filter,
           limit = productRequest.limit,
           offset = productRequest.offset
        )
    }
}