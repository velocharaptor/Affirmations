package com.example.affirmations.navigation

import androidx.navigation.NavController

interface NavHost {
    fun provideNavController(): NavController
}