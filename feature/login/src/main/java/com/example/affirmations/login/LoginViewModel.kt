package com.example.affirmations.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }
    /*private val fireBase = FirebaseUserLiveData()

    val authenticationState =  fireBase.map { user ->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }*/
}