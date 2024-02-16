package com.example.affirmations.network.home

import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {
    @GET("recommendation/products")
    suspend fun getRecommendation(
        @Query(value = "filter", encoded = true) filter: String,
        @Query(value = "limit") limit: Int
    ) : List<HomeResponse>
}