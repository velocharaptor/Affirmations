package com.example.affirmations.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {
    @GET("products")
    suspend fun getProducts(
        @Query(value = "filter", encoded = true) filter: String,
        @Query(value = "limit") limit: Int,
        @Query(value = "offset") offset: Long,
        @Query(value = "sort", encoded = true) sortType: String? = null,
        @Query(value = "search") searchString: String? = null,
        @Query(value = "searchType") searchType: String? = null,
        @Query(value = "exclude", encoded = true) exclude: String?  = null,
        @Query(value = "ab_segment") abSegment: String? = null,
        @Query(value = "expand") expand: String? = null,
        @Query(value = "show_personal_price") showPersonalPrice: Boolean? = null
    ): List<ProductResponse>
}