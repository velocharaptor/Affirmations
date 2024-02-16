package com.example.affirmations.feature.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.detmir.recycli.adapters.bindState
import com.example.affirmations.base.BaseFragment
import com.example.productlist.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment :
    BaseFragment() {
    private val viewModel: ProductListViewModel by viewModels()
    private var binding: FragmentMainBinding? = null
    override val name: String = ProductListFragment::class.java.simpleName
    //private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding?.recyclerView?.apply {
            layoutManager = GridLayoutManager(
                context,
                2
            )
        }

        arguments?.let{
            viewModel.setCategoryAlias(it)
        }

        viewModel.data.observe(viewLifecycleOwner) { productState ->
            recyclerView?.bindState(productState)
        }
    }

    companion object {
        const val PRODUCT_KEY = "PRODUCT_KEY"
    }

    /*override fun onClick(data: RecyclerItem) {
        with(data as ProductItem) {
            bundle.putParcelable(PRODUCT_KEY, data)
            val controller = findNavController()
            controller.navigate(R.id.productCardFragment, bundle)
        }
    }*/
}