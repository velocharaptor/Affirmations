package com.example.affirmations.feature.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.detmir.recycli.adapters.bindState
import com.example.affirmations.base.BaseFragment
import com.example.catalog.databinding.FragmentCatalogBinding
import dagger.hilt.android.AndroidEntryPoint

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding?.recyclerCatalog?.apply {
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.data.observe(viewLifecycleOwner){ catalogState ->
            recyclerView?.bindState(catalogState)
        }
    }
}