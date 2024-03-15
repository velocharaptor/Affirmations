package com.example.affirmations.navigation

import com.example.affirmations.navigation.transportmodel.ProductItemTransport

interface CatalogNav {
    fun navToProductList(categoryAlias: String)
    fun navToProductCard(productItem: ProductItemTransport)
    companion object{
            const val CATALOG_KEY = "CATALOG_KEY"
            const val PRODUCT_KEY = "PRODUCT_KEY"
    }
}