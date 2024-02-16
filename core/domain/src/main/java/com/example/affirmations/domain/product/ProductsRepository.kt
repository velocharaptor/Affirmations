package com.example.affirmations.domain.product

interface ProductsRepository {
    suspend fun getProducts(productParams: ProductParams): List<ProductModel>
}