package com.example.affirmations.feature.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.detmir.recycli.adapters.bindState
import com.example.affirmations.base.BaseFragment
import com.example.settings.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment :
    BaseFragment() {
    override val name: String = SettingsFragment::class.java.simpleName
    private var binding: FragmentSettingsBinding? = null
    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding?.settingList?.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        viewModel.data.observe(viewLifecycleOwner) { settings ->
            recyclerView?.bindState(settings)
        }

        viewModel.loadSettings()
    }
}