package com.example.affirmations.catalog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.detmir.recycli.adapters.bindState
import com.example.affirmations.base.BaseFragment
import com.example.affirmations.feature.catalog.CatalogViewModel
import com.example.catalog.databinding.FragmentCatalogBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.affirmations.uikit.R as uikitR

@AndroidEntryPoint
class CatalogFragment:
    BaseFragment() {
    override val name: String = CatalogFragment::class.java.simpleName
    private var binding: FragmentCatalogBinding? = null
    private val viewModel: CatalogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(inflater)
        return binding?.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding?.recyclerCatalog?.apply {
            layoutManager = LinearLayoutManager(context)
        }

        val dividerItemDecoration = DividerItemDecoration(context, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(uikitR.drawable.divider))
        recyclerView?.addItemDecoration(dividerItemDecoration)

        viewModel.data.observe(viewLifecycleOwner){ catalogState ->
            recyclerView?.bindState(catalogState)
        }
    }
}