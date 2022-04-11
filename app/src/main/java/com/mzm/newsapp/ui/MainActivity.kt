package com.mzm.newsapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mzm.core.data.Resource
import com.mzm.core.util.viewBinding
import com.mzm.newsapp.R
import com.mzm.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observeCategory()
    }

    private fun observeCategory() {
        viewModel.getCategory().observe(this, { data ->
            when (data) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    Timber.d("MainActivityResponse : ${data.data}")
                }
                is Resource.Error -> {
                    Timber.d("MainActivityResponse : ${data.data}")
                }
            }
        })
    }
}