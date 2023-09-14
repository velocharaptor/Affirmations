package com.example.affirmations.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.adapter.ItemAdapter

class CellFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cell, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listAdapter = ItemAdapter()
        view.findViewById<RecyclerView>(R.id.cell_view).apply {
            adapter = listAdapter
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
        }

       /* viewModel.data.observe(viewLifecycleOwner){ productState ->
            listAdapter.applyData(productState)
        }*/
    }
}