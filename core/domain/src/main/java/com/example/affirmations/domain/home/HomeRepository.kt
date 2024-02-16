package com.example.affirmations.domain.home

interface HomeRepository {
    suspend fun getRecommendation(homeParams: HomeParams): List<HomeModel>
}