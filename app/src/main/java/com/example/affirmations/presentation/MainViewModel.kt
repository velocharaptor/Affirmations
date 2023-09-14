package com.example.affirmations.presentation

import androidx.lifecycle.*
import com.example.affirmations.data.ProductsRepository
import com.example.affirmations.data.ProductsRepositoryImpl
import com.example.affirmations.domain.GetProductsUseCase
import com.example.affirmations.model.Data
import com.example.affirmations.retrofit.ProductRequest
import com.example.affirmations.ui.product.ProductState
import com.example.affirmations.utils.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class MainViewModel: ViewModel() {
    val data: MutableLiveData<List<Data>> = MutableLiveData(emptyList())
    private val productsUseCase = GetProductsUseCase()

    init {
        Log.log(TAG, "init")
        loadProducts()
    }

    fun loadProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            val products = productsUseCase.getProducts()

            val listData = products.map {
                Data.FirstType(
                    string = it.title ?: "Product Name",
                    image = "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"
                )

            }

            launch(Dispatchers.Main) {
                data.value = listData
            }
        }
    }

    override fun onCleared() {
        Log.log(TAG, "onClear")
        super.onCleared()
    }

    companion object {
        private const val TAG = "MainViewModel"
    }

}