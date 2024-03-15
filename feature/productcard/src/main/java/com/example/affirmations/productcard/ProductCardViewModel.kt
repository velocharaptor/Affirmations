package com.example.affirmations.productcard


import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.affirmations.navigation.CatalogNav
import com.example.affirmations.navigation.transportmodel.ProductItemTransport
import com.example.affirmations.uikit.productcarditem.ProductCardItem
import com.example.affirmations.utils.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductCardViewModel @Inject constructor() : ViewModel() {
    val data: MutableLiveData<ProductState> = MutableLiveData()
    val imagesData: MutableLiveData<List<ProductCardItem>> = MutableLiveData()

    init {
        Log.log(TAG, "init")
    }

    @Suppress("DEPRECATION")
    fun setArguments(args: Bundle) {
        args.getParcelable<ProductItemTransport>(CatalogNav.PRODUCT_KEY)?.let { productItem ->
            data.value = ProductState(
                title = productItem.title,
                description = productItem.description,
                price = productItem.price
            )
            updateImagesState(productItem.images)
        }
    }

    private fun updateImagesState(images: List<String>) {
        imagesData.value = images.mapIndexed { index, item ->
            ProductCardItem(
                id = index.toString(),
                image = item
            )
        }
    }

    companion object {
        private const val TAG = "ProductCardViewModel"
    }
}

data class ProductState(
    val title: String,
    val description: String,
    val price: String
)