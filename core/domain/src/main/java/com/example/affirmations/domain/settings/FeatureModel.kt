package com.example.affirmations.domain.settings

data class FeatureModel(
    val title: String,
    val description: String,
    val key: String,
    val isEnabled: Boolean
)