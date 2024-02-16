package com.example.affirmations.data.catalog

import com.example.affirmations.domain.catalog.CatalogRepository
import com.example.affirmations.domain.catalog.CatalogModel
import com.example.affirmations.network.catalog.CatalogApi

class CatalogRepositoryImpl(
    private val catalogApi: CatalogApi,
    private val mapper: CatalogMapper
) : CatalogRepository {

    override suspend fun getCatalog(): List<CatalogModel> {
        return mapper.map(catalogApi.getCatalog())
    }
}