package com.example.affirmations.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.detmir.recycli.adapters.bindState
import com.example.affirmations.base.BaseFragment
import com.example.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment() {
    override val name: String = HomeFragment::class.java.simpleName
    private  var binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView1 = binding?.homeRecycler1?.apply {
            layoutManager = LinearLayoutManager(
                context
            )
        }

        viewModel.data.observe(viewLifecycleOwner){ homeItem->
            recyclerView1?.bindState(homeItem)
        }
    }
}