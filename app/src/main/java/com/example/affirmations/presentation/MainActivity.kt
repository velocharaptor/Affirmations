package com.example.affirmations.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.presentation.fragments.MainFragment
import com.example.affirmations.retrofit.ProductApi
import com.example.affirmations.utils.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.log(TAG,"onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, MainFragment.getInstance())
            .commit()
    }

    override fun onStart() {
        Log.log(TAG,"onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.log(TAG,"onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.log(TAG,"onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.log(TAG,"onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.log(TAG,"onDestroy")
        super.onDestroy()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
