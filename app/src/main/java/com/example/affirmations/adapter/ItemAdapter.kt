package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
import com.example.affirmations.model.Data

class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    private var dataset: List<Data>? = null

    fun applyData(data: List<Data>){
        dataset = data
        notifyDataSetChanged()
    }

    abstract class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        abstract fun bind(data: Data)
    }

    class ItemViewHolder(private val view: View) :  MyViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)

        override fun bind(data: Data) {
            textView.text = (data as Data.FirstType).string //индификатор строкового ресурса
            Glide.with(view.context).load(data.imageResourceId).into(imageView)
        }
    }

    class ItemViewHolderSecond(private val view: View) : MyViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)

        override fun bind(data: Data) {
            Glide.with(view.context).load(data.imageResourceId).into(imageView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(dataset?.get(position)){
            is Data.FirstType -> TYPE1
            is Data.SecondType -> TYPE2
            null -> throw Exception("error dataset")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create a new view
        if (viewType == 1) {
            val adapterLayout =
                LayoutInflater.from(parent.context) // получить макет из родительского
                    .inflate(R.layout.list_item, parent, false)

            return ItemViewHolder(adapterLayout)
        } else {
            val adapterLayout =
                LayoutInflater.from(parent.context) // получить макет из родительского
                    .inflate(R.layout.list_item_second, parent, false)

            return ItemViewHolderSecond(adapterLayout)
        }

    }

    override fun getItemCount(): Int {
        //Метод getItemCount() должен возвращать размер вашего набора данных.
        // Данные вашего приложения находятся в свойстве набора данных,
        // которое вы передаете в конструктор ItemAdapter, и вы можете получить его размер с размером.
        return dataset?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // уже созданный элемент вьюхолдера,
        // и текущая позиция элемента в списке
        val item = dataset?.get(position)
        item?.let { data->
            holder.bind(data)
        }

    }

    companion object {
        const val TYPE1: Int = 1
        const val TYPE2: Int = 2
    }
}