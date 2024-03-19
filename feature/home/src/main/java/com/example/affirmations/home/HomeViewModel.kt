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
import com.example.affirmations.uikit.discountprice.DiscountPriceItem
import com.example.affirmations.uikit.headeritem.HeaderItem
import com.example.affirmations.uikit.homeitem.HomeItem
import com.example.affirmations.uikit.priceitem.PriceItem
import com.example.affirmations.uikit.productcarditem.ProductCardItem
import com.example.affirmations.uikit.productitem.ProductItem
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
                title = "Horizontal recycler"
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
                title = "Some Items"
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
            HeaderItem(
                id = "Header_3",
                title = "Buttons"
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
            HeaderItem(
                id = "Header_4",
                title = "Prices"
            ),
            PriceItem(
                id = "Price",
                text = "2000",
                color = resManager.getColor(uikitR.color.black),
                size = "23".toFloat()
            ),
            DiscountPriceItem(
                id = "discount price",
                price = "2000",
                newPrice = "1899",
                colorPrice = resManager.getColor(uikitR.color.black),
                colorNewPrice = resManager.getColor(uikitR.color.on_error),
                sizePrice = "23".toFloat(),
                sizeNewPrice = "35".toFloat()
            ),
            HeaderItem(
                id = "Header_5",
                title = "Product Item"
            ),
            ProductItem(
                title = "Product Name",
                images = listOf("https://delasign.com/delasignBlack.png"),
                description =  " bla bla",
                price = "2000",
                id = "Product Name",
                toProductCard = ::click,
                button = ButtonItem(
                    id = "Product Name",
                    title = "toBucket",
                    size = ButtonSize.SMALL,
                    action = ::click
                ),
                priceDiscountTitle = DiscountPriceItem(
                    id = "Price name",
                    price = "2000",
                    newPrice = "1899",
                    colorPrice = resManager.getColor(uikitR.color.black),
                    colorNewPrice = resManager.getColor(uikitR.color.on_error),
                    sizePrice = "23".toFloat(),
                    sizeNewPrice = "35".toFloat()
                )

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