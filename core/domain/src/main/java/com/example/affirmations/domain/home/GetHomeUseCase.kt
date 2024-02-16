package com.example.affirmations.domain.home

import javax.inject.Inject

class GetHomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun getHome() : List<HomeModel> {
        return homeRepository.getRecommendation(
            HomeParams(
                filter = "placement:web_main_recomendation;region.iso:RU-MOW;site:detmir",
                limit = 30
            )
        )
    }
}