package com.example.affirmations.feature.productlist

import android.os.Bundle
import androidx.lifecycle.*
import com.detmir.recycli.adapters.RecyclerItem
import com.example.affirmations.domain.product.GetProductsUseCase
import com.example.affirmations.navigation.CatalogNav
import com.example.affirmations.navigation.Nav
import com.example.affirmations.uikit.button.SettingsButton
import com.example.affirmations.uikit.productitem.ProductItem
import com.example.affirmations.utils.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
open class ProductListViewModel @Inject constructor(
    private val productsUseCase: GetProductsUseCase,
    private val nav: Nav
) : ViewModel() {
    val data: MutableLiveData<List<RecyclerItem>> = MutableLiveData(emptyList())
    private val mapper = ProductItemMapper(nav)

    init {
        Log.log(TAG, "init")
    }

    @Suppress("DEPRECATION")
    fun setCategoryAlias(args: Bundle) {
        args.getString(CatalogNav.CATALOG_KEY)?.let { categoryAlias ->
            load(categoryAlias)
        }
    }

    fun load(categoryAlias: String) {
        viewModelScope.launch {
            runCatching {
                val listData: List<ProductItem>
                withContext(Dispatchers.IO) {
                    val products = productsUseCase.getProducts(categoryAlias)
                    listData = mapper.map(products)
                }
                listData
            }.onSuccess { listData ->
                data.value = listData
            }.onFailure {
                Log.log(TAG, it.message ?: "onFailure: ")
            }
        }
    }

    override fun onCleared() {
        Log.log(TAG, "onClear")
        super.onCleared()
    }

    companion object {
        private const val TAG = "ProductListViewModel"
    }

}