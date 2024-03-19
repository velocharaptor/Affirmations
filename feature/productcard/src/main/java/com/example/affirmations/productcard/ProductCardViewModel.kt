package com.example.affirmations.productcard


import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.detmir.recycli.adapters.RecyclerItem
import com.example.affirmations.navigation.CatalogNav
import com.example.affirmations.navigation.transportmodel.ProductItemTransport
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.containeritem.ContainerItem
import com.example.affirmations.uikit.descriptionitem.DescriptionItem
import com.example.affirmations.uikit.discountprice.DiscountPriceItem
import com.example.affirmations.uikit.headeritem.HeaderItem
import com.example.affirmations.uikit.priceitem.PriceItem
import com.example.affirmations.uikit.productcarditem.ProductCardItem
import com.example.affirmations.utils.Log
import com.example.affirmations.utils.resmanager.ResManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductCardViewModel @Inject constructor(
    private val resManager: ResManager
) : ViewModel() {
    val dataState: MutableLiveData<List<RecyclerItem>> = MutableLiveData(emptyList())

    init {
        Log.log(TAG, "init")
    }

    @Suppress("DEPRECATION")
    fun setArguments(args: Bundle) {
        args.getParcelable<ProductItemTransport>(CatalogNav.PRODUCT_KEY)?.let { productItem ->
            val list: MutableList<RecyclerItem> = mutableListOf()
            list.add(
                ContainerItem(
                    id = "image_recycler",
                    recyclerState = productItem.images.mapIndexed { index, image ->
                        ProductCardItem(
                            id = index.toString(),
                            image = image
                        )
                    }
                )
            )
            list.add(
                HeaderItem(
                    id = productItem.id,
                    title = productItem.title
                )
            )
            if(productItem.discount == null) {
                list.add(
                    PriceItem(
                        id = productItem.id,
                        text = productItem.price,
                        color = resManager.getColor(R.color.black),
                        size = "23".toFloat()
                    )
                )
            } else {
                list.add(
                    DiscountPriceItem(
                        id = productItem.id,
                        price = productItem.price,
                        newPrice = productItem.discount!!, // как нормально обернуть?? todo
                        colorPrice = resManager.getColor(R.color.black),
                        colorNewPrice = resManager.getColor(R.color.on_error),
                        sizePrice = "23".toFloat(),
                        sizeNewPrice = "35".toFloat()
                    )
                )
            }
            list.add(
                DescriptionItem(
                    id = productItem.id,
                    text = convertHtmlToPlaintextWithTags( productItem.description)
                )
            )
            list.add(
                HeaderItem(
                    id = productItem.id,
                    title = "Отзывы"
                )
            )
            dataState.value = list
        }
    }

    companion object {
        private const val TAG = "ProductCardViewModel"
    }
}

fun convertHtmlToPlaintextWithTags(html: String): String {
    var plainText = ""

    var insideTag = false
    var currentTag = ""
    var tagContent = ""

    for (char in html) {
        when {
            char == '<' -> {
                insideTag = true
                currentTag = ""
            }
            char == '>' -> {
                insideTag = false
                if (currentTag.startsWith('/')) {
                    if (tagContent.isNotEmpty()) {
                        plainText += tagContent
                    }
                } else {
                    tagContent = ""
                }
            }
            insideTag -> {
                currentTag += char
            }
            else -> {
                if (currentTag.isNotEmpty()) {
                    tagContent += char
                } else {
                    plainText += char
                }
            }
        }
    }

    return plainText
}