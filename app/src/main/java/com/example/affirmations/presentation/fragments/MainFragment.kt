package com.example.affirmations.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.presentation.MainViewModel

interface OnSelectedButtonListener {
    fun onButtonSelected(buttonIndex: Int)
}

class MainFragment: Fragment(), View.OnClickListener {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listAdapter = ItemAdapter()
        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = listAdapter
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
        }

        viewModel.data.observe(viewLifecycleOwner){ productState ->
            listAdapter.applyData(productState)
        }
    }

    override fun onClick(p0: View?) {

    }

    companion object {
        fun getInstance(): MainFragment {
            return MainFragment()
        }
    }
}