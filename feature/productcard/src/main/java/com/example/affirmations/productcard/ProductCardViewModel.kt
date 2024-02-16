package com.example.affirmations.feature.productcard


import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.affirmations.navigation.CatalogNav
import com.example.affirmations.uikit.productcarditem.ProductCardItem
import com.example.affirmations.uikit.productitem.ProductItem
import com.example.affirmations.utils.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductCardViewModel @Inject constructor() : ViewModel() {
    val data: MutableLiveData<ProductItem> = MutableLiveData()
    val imagesData: MutableLiveData<List<ProductCardItem>> = MutableLiveData()

    init {
        Log.log(TAG, "init")
    }

    @Suppress("DEPRECATION")
    fun setArguments(args: Bundle) {
        args.getParcelable<ProductItem>(CatalogNav.PRODUCT_KEY)?.let { productItem ->
            data.value = productItem
            updateImagesState(productItem)
        }
    }

    private fun updateImagesState(productItem: ProductItem) {
        imagesData.value = productItem.images.mapIndexed { index, item ->
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