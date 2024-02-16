package com.example.affirmations.domain.catalog

import javax.inject.Inject

class GetCatalogUseCase @Inject constructor(
    private val repository: CatalogRepository
) {
    suspend fun getCatalog(): List<CatalogModel> {
        return repository.getCatalog()
    }
}