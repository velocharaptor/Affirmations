package com.example.affirmations.domain.catalog

interface CatalogRepository {
    suspend fun getCatalog(): List<CatalogModel>
}