package com.example.affirmations.feature.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.detmir.recycli.adapters.RecyclerItem
import com.example.affirmations.domain.home.GetHomeUseCase
import com.example.affirmations.uikit.containeritem.ContainerItem
import com.example.affirmations.uikit.headeritem.HeaderItem
import com.example.affirmations.uikit.homeitem.HomeItem
import com.example.affirmations.uikit.productcarditem.ProductCardItem
import com.example.affirmations.uikit.taskitem.TaskItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: GetHomeUseCase
) : ViewModel() {
    val data: MutableLiveData<List<RecyclerItem>> = MutableLiveData(emptyList())

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            runCatching {
                getList()
            }.onSuccess {recyclerItem->
                data.value = recyclerItem
            }
        }
       /* val list: MutableList<RecyclerItem> = mutableListOf()
        list.add(
            ContainerItem(
                id = "banner1",
                recyclerState = (0..3).map { taskItem ->
                    TaskItem(
                        id = "TASK$taskItem",
                        title = "task $taskItem",
                        text = "some text..."
                    )
                }
            )
        )
        list.add(
            HeaderItem(
                id = "Header_1",
                title = "Header 1"
            )
        )
        list.add(
            ContainerItem(id = "banner2",
                recyclerState = (0..7).map { homeItem ->
                    HomeItem(
                        id = "ID$homeItem",
                        title = "title $homeItem",
                        images = "https://delasign.com/delasignBlack.png"
                    )
                }
            )
        )
        list.add(
            HeaderItem(
                id = "Header_2",
                title = "Header 2"
            )
        )
        list.add(
            ContainerItem(id = "banner2",
                recyclerState = (0..5).map { homeItem ->
                    HomeItem(
                        id = "ID$homeItem",
                        title = "title $homeItem",
                        images = "https://delasign.com/delasignBlack.png"
                    )
                }
            )
        )
        list.add(
            ProductCardItem(
                id = "ITEM1",
                image = "https://delasign.com/delasignBlack.png"
            )
        )
        list.add(
            HomeItem(
                id = "ITEM2",
                title = "HomeItem",
                images = "https://delasign.com/delasignBlack.png"
            )
        )
        list.add(
            ProductCardItem(
                id = "ITEM3",
                image = "https://delasign.com/delasignBlack.png"
            )
        ) */
        //data.value = list
    }

    private fun getList(): List<RecyclerItem> {
        return listOf(
            ContainerItem(
                id = "banner1",
                recyclerState = (0..3).map { taskItem ->
                    TaskItem(
                        id = "TASK$taskItem",
                        title = "task $taskItem",
                        text = "some text..."
                    )
                }
            ),
            HeaderItem(
                id = "Header_1",
                title = "Header 1"
            ),
            ContainerItem(id = "banner2",
                recyclerState = (0..7).map { homeItem ->
                    HomeItem(
                        id = "ID$homeItem",
                        title = "title $homeItem",
                        images = "https://delasign.com/delasignBlack.png"
                    )
                }
            ),
            HeaderItem(
                id = "Header_2",
                title = "Header 2"
            ),
            ContainerItem(id = "banner2",
                recyclerState = (0..5).map { homeItem ->
                    HomeItem(
                        id = "ID$homeItem",
                        title = "title $homeItem",
                        images = "https://delasign.com/delasignBlack.png"
                    )
                }
            ),
            ProductCardItem(
                id = "ITEM1",
                image = "https://delasign.com/delasignBlack.png"
            ),
            HomeItem(
                id = "ITEM2",
                title = "HomeItem",
                images = "https://delasign.com/delasignBlack.png"
            ),
            ProductCardItem(
                id = "ITEM3",
                image = "https://delasign.com/delasignBlack.png"
            )
        )
    }
}