package com.example.affirmations.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.affirmations.base.BaseFragment
import com.example.login.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    override val name: String = LoginFragment::class.java.simpleName
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    //private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding = FragmentLoginBinding.inflate(inflater)
        binding = FragmentLoginBinding.inflate(inflater)
        binding.loginButton.setOnClickListener {
            //launchSignInFlow()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       /* navController = findNavController()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController.popBackStack(
                R.id.homeFragment,
                false
            )*/
        }

        /*viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {
                    navController.popBackStack()
                    navController.navigate(R.id.accountFragment)
                }
                LoginViewModel.AuthenticationState.INVALID_AUTHENTICATION -> Snackbar.make(
                    view,
                    "Вход не выполнен",
                    Snackbar.LENGTH_LONG
                ).show()
                else -> Log.e(
                    TAG,
                    "Authentication state that doesn't require any UI change $authenticationState"
                )
            }
        })
    }*/
/*
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       if (requestCode == SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                i(
                    TAG,
                    "Successfully signed in user " +
                            "${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
            } else {
                Log.i(TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun launchSignInFlow() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build()
        )
        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                providers
            ).build(), SIGN_IN_RESULT_CODE
        )
    }

    companion object {
        const val TAG = "LoginFragment"
        const val SIGN_IN_RESULT_CODE = 1001
    }*/
}