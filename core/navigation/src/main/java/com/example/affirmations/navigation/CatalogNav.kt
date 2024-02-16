package com.example.affirmations.navigation

import com.example.affirmations.uikit.productitem.ProductItem

interface CatalogNav {
    fun navToProductList(categoryAlias: String)
    fun navToProductCard(productItem: ProductItem)
    companion object{
            const val CATALOG_KEY = "CATALOG_KEY"
            const val PRODUCT_KEY = "PRODUCT_KEY"
    }
}