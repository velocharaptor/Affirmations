package com.example.affirmations.data.catalog

import com.example.affirmations.domain.catalog.CatalogModel
import com.example.affirmations.network.catalog.CatalogResponse
import javax.inject.Inject

class CatalogMapper @Inject constructor() {
    fun map(catalogResponse: CatalogResponse): List<CatalogModel> {
        return catalogResponse.items?.filter {
           !it.title.isNullOrEmpty() || !it.categoryAlias.isNullOrEmpty()
        }?.map { item ->
            CatalogModel(
                title = item.title ?: "",
                mobileIcon = item.mobileIcon ?: "",
                categoryAlias = item.categoryAlias ?: ""
            )
        } ?: emptyList()
    }
}