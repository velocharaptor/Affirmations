package com.example.affirmations.feature.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.account.databinding.FragmentAccountBinding
import com.example.affirmations.base.BaseFragment
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : BaseFragment() {
    override val name: String = AccountFragment::class.java.simpleName
    private lateinit var binding: FragmentAccountBinding
    //private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater)
        return binding.root
    }
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAuthenticationState()
    }

    private fun observeAuthenticationState() {
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            if (authenticationState == LoginViewModel.AuthenticationState.AUTHENTICATED) {

                val hello = String.format(
                    resources.getString(
                        R.string.welcome_message,
                        FirebaseAuth.getInstance().currentUser?.displayName
                    )
                )

                binding.tvWelcome.text = hello

                binding.logoutButton.setOnClickListener {
                    AuthUI.getInstance().signOut(requireContext())
                    //findNavController().popBackStack()
                }
            }
        })
    }*/
}