package com.example.affirmations.app.navigation.module

import com.example.affirmations.app.navigation.NavImpl
import com.example.affirmations.navigation.Nav
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavModule {
    @Binds
    fun bindNav(navImpl: NavImpl): Nav
}