package com.example.affirmations.feature.productlist

import com.detmir.recycli.adapters.RecyclerItem
import com.example.affirmations.domain.product.ProductModel
import com.example.affirmations.navigation.Nav
import com.example.affirmations.uikit.productitem.ProductItem
import javax.inject.Inject

class ProductItemMapper @Inject constructor(private val nav: Nav) {
    fun map(products: List<ProductModel>): List<ProductItem> {
        return products.map {
            ProductItem(
                title = it.title ?: "Product Name",
                images = it.pictures?.map { picture ->
                    picture.original
                } ?: emptyList(),
                description = it.description ?: " ",
                price = it.price?.price ?: " ",
                id = it.title ?: "Product Name",
                toProductCard = ::clickProductItem
            )
        }
    }

    private fun clickProductItem(data: ProductItem) {
        nav.navToProductCard(data)
    }
}