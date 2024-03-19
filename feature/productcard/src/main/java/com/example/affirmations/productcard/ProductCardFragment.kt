package com.example.affirmations.feature.productcard

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.detmir.recycli.adapters.bindState
import com.example.affirmations.base.BaseFragment
import com.example.affirmations.productcard.ProductCardViewModel
import com.example.productcard.databinding.FragmentCellBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductCardFragment :
    BaseFragment() {
    private val viewModel: ProductCardViewModel by viewModels()
    private var binding: FragmentCellBinding? = null
    override val name: String = ProductCardFragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCellBinding.inflate(inflater)
        return binding?.root
    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding?.productCardRecycler?.apply {
            layoutManager = LinearLayoutManager(
                context
            )
        }

        arguments?.let {
            viewModel.setArguments(it)
        }

        viewModel.dataState.observe(viewLifecycleOwner) { item->
            recyclerView?.bindState(item)
        }
    }

    companion object {
        const val PRODUCT_KEY = "PRODUCT_KEY"
    }
}