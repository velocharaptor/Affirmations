package com.example.affirmations.data.product

import com.example.affirmations.domain.product.ProductModel
import com.example.affirmations.domain.product.ProductsRepository
import com.example.affirmations.network.product.ProductApi
import com.example.affirmations.domain.product.ProductParams

class ProductsRepositoryImpl(
    private val productApi: ProductApi,
    private val mapper: ProductMapper
) : ProductsRepository {

    override suspend fun getProducts(productParams: ProductParams): List<ProductModel> {
        return mapper.map(
            productApi.getProducts(
                filter = productParams.filter,
                limit = productParams.limit,
                offset = productParams.offset
            )
        )
    }
}