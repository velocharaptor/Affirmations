package com.example.affirmations.feature.catalog

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.affirmations.domain.catalog.GetCatalogUseCase
import com.example.affirmations.navigation.Nav
import com.example.affirmations.uikit.catalogitem.CatalogItem
import com.example.affirmations.utils.Log
import com.example.affirmations.utils.resmanager.ResManager
import com.example.catalog.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getCatalogUseCase: GetCatalogUseCase,
    private val resManager: ResManager,
    private val nav: Nav
) : ViewModel() {
    val data: MutableLiveData<List<CatalogItem>> = MutableLiveData(emptyList())

    init {
        Log.log(TAG, "init")
        load()
    }

    fun load() {
        viewModelScope.launch {
            runCatching {
                getCatalogUseCase.getCatalog()
            }.onSuccess { catalogModels ->
                data.value = catalogModels.map { catalogModel ->
                    CatalogItem(
                        id = catalogModel.categoryAlias,
                        name = catalogModel.title,
                        image = catalogModel.mobileIcon,
                        categoryAlias = catalogModel.categoryAlias,
                        action = ::clickCatalogItem
                    )
                }
            }.onFailure {
                resManager.showToast(R.string.error, Toast.LENGTH_SHORT)
            }
        }
    }

    private fun clickCatalogItem(categoryAlias: String) {
        nav.navToProductList(categoryAlias)
    }

    companion object {
        private const val TAG = "CatalogViewModel"
    }
}