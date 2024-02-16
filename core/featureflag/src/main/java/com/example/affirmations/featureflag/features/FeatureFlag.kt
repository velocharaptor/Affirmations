package com.example.affirmations.featureflag.features

sealed class FeatureFlag(
    val key: String,
    val title: String,
) {
    object Product : FeatureFlag(
        key = "android_product",
        title = "Product"
    )

    object Catalog : FeatureFlag(
        key = "android_catalog",
        title = "Catalog"
    )

    object PersonalAccount : FeatureFlag(
        key = "android_personal_account",
        title = "Personal Account"
    )

    object ProductList : FeatureFlag(
        key = "android_product_list",
        title = "Product List"
    )

    object Home : FeatureFlag(
        key = "android_home",
        title = "Home"
    )

    object Feature : FeatureFlag(
        key = "android_feature",
        title = "Feature"
    )

    companion object {
        fun getFeatures(): List<FeatureFlag> {
            return listOf(
                Feature,
                Product,
                Catalog,
                PersonalAccount,
                ProductList,
                Home
            )
        }
    }
}

