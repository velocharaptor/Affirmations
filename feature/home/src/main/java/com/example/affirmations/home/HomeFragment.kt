package com.example.affirmations.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
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
    //private val viewModel by viewModels<LoginViewModel>()

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

        val recyclerView = binding?.homeRecycler?.apply {
            layoutManager = GridLayoutManager(
                context,
                2
            )
        }

        viewModel.data.observe(viewLifecycleOwner){ homeItem->
            recyclerView?.bindState(homeItem)
        }
    }

    /*private fun observeAuthenticationState() {
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {
                    binding.homeButton.setOnClickListener {
                        findNavController().navigate(R.id.accountFragment)
                    }
                }
                else -> {
                    binding.homeButton.setOnClickListener {
                        findNavController().navigate(R.id.loginFragment)
                    }
                }
            }
        })
    }*/
}