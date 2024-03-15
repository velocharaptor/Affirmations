package com.example.affirmations.home

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.detmir.recycli.adapters.RecyclerItem
import com.example.affirmations.domain.home.GetHomeUseCase
import com.example.affirmations.uikit.button.ButtonSize
import com.example.affirmations.uikit.button.ButtonItem
import com.example.affirmations.uikit.containeritem.ContainerItem
import com.example.affirmations.uikit.headeritem.HeaderItem
import com.example.affirmations.uikit.homeitem.HomeItem
import com.example.affirmations.uikit.productcarditem.ProductCardItem
import com.example.affirmations.uikit.taskitem.TaskItem
import com.example.affirmations.utils.resmanager.ResManager
import com.example.affirmations.uikit.R as uikitR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: GetHomeUseCase,
    private val resManager: ResManager
) : ViewModel() {
    val data: MutableLiveData<List<RecyclerItem>> = MutableLiveData(emptyList())

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            runCatching {
                getList()
            }.onSuccess { recyclerItem ->
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
            ContainerItem(
                id = "banner2",
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
            ContainerItem(
                id = "banner2",
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
                image = "https://delasign.com/delasignBlack.png",
                backgroundColor = resManager.getColor(uikitR.color.background)
            ),
            HomeItem(
                id = "ITEM2",
                title = "HomeItem",
                images = "https://delasign.com/delasignBlack.png"
            ),
            ContainerItem(
                id = "banner3",
                recyclerState = (0..2).map { tmp ->
                    ButtonItem(
                        id = "$tmp",
                        title = "Button$tmp",
                        action = ::click,
                        size = ButtonSize.SMALL
                    )
                }
            ),
            ButtonItem(
              id = "",
              title = "BIG BUTTON",
              action = ::click,
              size = ButtonSize.BIG
            ),
            ProductCardItem(
                id = "ITEM3",
                image = "https://delasign.com/delasignBlack.png"
            )
        )
    }

    private fun click(data: RecyclerItem) {
        resManager.showToast("boo", Toast.LENGTH_SHORT)
    }
}