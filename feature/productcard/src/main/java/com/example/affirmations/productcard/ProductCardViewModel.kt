package com.example.affirmations.productcard


import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.detmir.recycli.adapters.RecyclerItem
import com.example.affirmations.navigation.CatalogNav
import com.example.affirmations.navigation.transportmodel.ProductItemTransport
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.containeritem.ContainerItem
import com.example.affirmations.uikit.divideritem.DividerItem
import com.example.affirmations.uikit.longtextitem.LongTextItem
import com.example.affirmations.uikit.priceitem.PriceItem
import com.example.affirmations.uikit.headeritem.HeaderItem
import com.example.affirmations.uikit.namedimageitem.NamedImageItem
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
                        NamedImageItem(
                            id = index.toString(),
                            title = "",
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
            list.add(
                PriceItem(
                    id = productItem.id,
                    oldPrice = productItem.price,
                    newPrice = productItem.discount!!, // как нормально обернуть?? todo
                    colorPrice = resManager.getColor(R.color.black),
                    colorNewPrice = resManager.getColor(R.color.on_error),
                    sizePrice = "23".toFloat(),
                    sizeNewPrice = "35".toFloat()
                )
            )
            list.add(
                DividerItem(
                    id = productItem.id,
                    color = null
                )
            )
            list.add(
                LongTextItem(
                    id = productItem.id,
                    text = convertHtmlToPlaintextWithTags(productItem.description)
                )
            )
            list.add(
                DividerItem(
                    id = productItem.id,
                    color = null
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