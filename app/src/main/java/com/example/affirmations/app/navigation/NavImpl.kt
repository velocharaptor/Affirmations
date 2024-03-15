package com.example.affirmations.app.navigation

import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.affirmations.navigation.CatalogNav
import com.example.affirmations.navigation.NavHostProvider
import com.example.affirmations.R
import com.example.affirmations.navigation.Nav
import com.example.affirmations.navigation.transportmodel.ProductItemTransport
import javax.inject.Inject

class NavImpl @Inject constructor(
    private val navHostProvider: NavHostProvider
) : Nav {
    override fun navToProductList(categoryAlias: String) {
        val bundle = bundleOf(CatalogNav.CATALOG_KEY to categoryAlias)
        navigation(R.id.productListFragment, bundle)
    }

    override fun navToProductCard(productItem: ProductItemTransport) {
        val bundle = bundleOf(CatalogNav.PRODUCT_KEY to productItem)
        navigation(R.id.productCardFragment, bundle)
    }

    private fun navigation(id: Int, bundle: Bundle) {
        val controller = navHostProvider.getNavHost()?.provideNavController()
        controller?.navigate(id, bundle)
    }
}