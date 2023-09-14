package com.example.affirmations.data

import com.example.affirmations.retrofit.ProductRequest
import com.example.affirmations.retrofit.ProductResponse

interface ProductsRepository {
    suspend fun getProducts(productRequest: ProductRequest): List<ProductResponse>
}