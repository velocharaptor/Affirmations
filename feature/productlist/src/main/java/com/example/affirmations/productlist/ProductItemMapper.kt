package com.example.affirmations.productlist

import android.widget.Toast
import com.detmir.recycli.adapters.RecyclerItem
import com.example.affirmations.domain.product.ProductModel
import com.example.affirmations.navigation.Nav
import com.example.affirmations.navigation.transportmodel.ProductItemTransport
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.button.ButtonItem
import com.example.affirmations.uikit.button.ButtonSize
import com.example.affirmations.uikit.discountprice.DiscountPriceItem
import com.example.affirmations.uikit.productitem.ProductItem
import com.example.affirmations.utils.resmanager.ResManager
import javax.inject.Inject

class ProductItemMapper @Inject constructor(
    private val nav: Nav,
    private val resManager: ResManager
) {
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
                toProductCard = ::clickProductItem,
                button = ButtonItem(
                    id = it.title ?: "Product Name",
                    title = "toBucket",
                    size = ButtonSize.SMALL,
                    action = ::clickToBucket
                ),
                priceDiscountTitle = DiscountPriceItem(
                    id = it.title ?: "Price name",
                    price = it.price?.price ?: "error price",
                    newPrice = "2000",
                    colorPrice = resManager.getColor(R.color.black),
                    colorNewPrice = resManager.getColor(R.color.on_error),
                    sizePrice = "23".toFloat(),
                    sizeNewPrice = "35".toFloat()
                )
                /*priceTitle = PriceItem(
                        id = it.title ?: "Price name",
                        text = it.price?.price ?: "error price",
                        color = resManager.getColor(uikitR.color.black),
                        size = "23".toFloat()
                )*/
            )
        }
    }

    private fun clickProductItem(data: ProductItem) {
        nav.navToProductCard(
            ProductItemTransport(
                id = data.id,
                title = data.title,
                price = data.price,
                description = data.description,
                images = data.images,
                discount = "2000"
            )
        )
    }

    private fun clickToBucket(data: RecyclerItem) {
        resManager.showToast("toBucket", Toast.LENGTH_SHORT)
    }
}