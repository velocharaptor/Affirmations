package com.example.affirmations.domain.product

data class ProductParams(
    val filter: String,
    val limit: Int,
    val offset: Long,
    val sortType: String? = null,
    val searchString: String? = null,
    val searchType: String? = null,
    val exclude: String? = null,
    val abSegment: String? = null,
    val expand: String? = null,
    val showPersonalPrice: Boolean? = null
)