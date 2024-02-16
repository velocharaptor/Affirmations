package com.example.affirmations.domain.product

import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductsRepository
) {
    suspend fun getProducts(x: String): List<ProductModel> {
        return repository.getProducts(
            ProductParams(
                filter = "withregion:RU-MOW;categories[].alias:$x;promo:true;platform:mobile",
                limit = 20,
                offset = 0
            )
        )
    }
}