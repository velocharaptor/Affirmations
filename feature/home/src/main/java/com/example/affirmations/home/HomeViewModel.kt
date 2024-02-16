package com.example.affirmations.feature.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.affirmations.domain.home.GetHomeUseCase
import com.example.affirmations.uikit.homeitem.HomeItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: GetHomeUseCase
) : ViewModel() {
    val data: MutableLiveData<List<HomeItem>> = MutableLiveData(emptyList())

    init {
        load()
    }

    private fun load() {
        kotlin.runCatching {
            getData()
        }.onSuccess { homeItems ->
            data.value = homeItems.map { homeItem ->
                HomeItem(
                    id = homeItem.id,
                    title = homeItem.title,
                    images = homeItem.images
                )
            }
        }
    }

    private fun getData(): List<HomeItem> {
        return listOf(
            HomeItem(
                id = "1",
                title = "boom",
                images = "https://delasign.com/delasignBlack.png"
            ),
            HomeItem(
                id = "2",
                title = "bam",
                images = "https://delasign.com/delasignBlack.png"
            ),
            HomeItem(
                id = "3",
                title = "baam",
                images = "https://delasign.com/delasignBlack.png"
            ),
            HomeItem(
                id = "4",
                title = "baaam",
                images = "https://delasign.com/delasignBlack.png"
            ),
            HomeItem(
                id = "5",
                title = "baaaam",
                images = "https://delasign.com/delasignBlack.png"
            ),
            HomeItem(
                id = "6",
                title = "baaaam",
                images = "https://delasign.com/delasignBlack.png"
            ),
            HomeItem(
                id = "7",
                title = "end",
                images = "https://delasign.com/delasignBlack.png"
            )
        )
    }
}