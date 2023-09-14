package com.example.affirmations.domain

import com.example.affirmations.data.ProductsRepository
import com.example.affirmations.data.ProductsRepositoryImpl
import com.example.affirmations.retrofit.ProductRequest
import com.example.affirmations.retrofit.ProductResponse

class GetProductsUseCase {
    private val repository: ProductsRepository = ProductsRepositoryImpl()

    suspend fun getProducts(): List<ProductResponse>{
        return repository.getProducts(
            ProductRequest(
                filter = "withregion:RU-MOW;categories[].alias:;promo:true;platform:mobile",
                limit = 20,
                offset = 0
            )
        )
    }
}