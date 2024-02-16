package com.example.affirmations.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.affirmations.utils.Log

abstract class BaseFragment : Fragment() {
    abstract val name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.log(name, "onCreate")
        //Log.log(name, Thread.dumpStack().toString())
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        Log.log(name, "onAttach")
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.log(name, "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.log(name, "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.log(name, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.log(name, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.log(name, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.log(name, "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.log(name, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.log(name, "onDetach")
        super.onDetach()
    }

    override fun onDestroy() {
        Log.log(name, "onDestroy")
        super.onDestroy()
    }
}