package com.example.affirmations.network.catalog

import retrofit2.http.GET

interface CatalogApi {
    @GET("ui/siteMenu/main")
    suspend fun getCatalog(): CatalogResponse
}