package com.example.affirmations.data.home

import com.example.affirmations.domain.home.HomeModel
import com.example.affirmations.domain.home.HomeRepository
import com.example.affirmations.network.home.HomeApi
import com.example.affirmations.domain.home.HomeParams

class HomeRepositoryImpl(
    private val homeApi: HomeApi,
    private val mapper: HomeMapper
) : HomeRepository {
    override suspend fun getRecommendation(homeParams: HomeParams): List<HomeModel> {
        return mapper.map(
            homeApi.getRecommendation(
                filter = homeParams.filter,
                limit = homeParams.limit
            )
        )
    }
}