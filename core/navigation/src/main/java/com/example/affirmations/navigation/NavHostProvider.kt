package com.example.affirmations.navigation

import java.lang.ref.WeakReference
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavHostProvider @Inject constructor() {
    private var navHostReference: WeakReference<NavHost>? = null

    fun setNavHost(navHost: NavHost) {
        navHostReference = WeakReference(navHost)
    }

    fun clearNavHost() {
        navHostReference = null
    }

    fun getNavHost(): NavHost? {
        return navHostReference?.get()
    }
}