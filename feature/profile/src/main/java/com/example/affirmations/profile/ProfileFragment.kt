package com.example.affirmations.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.affirmations.base.BaseFragment
import com.example.profile.R

class ProfileFragment : BaseFragment() {
    override val name: String = ProfileFragment::class.java.simpleName

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private var viewModel: ProfileViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}