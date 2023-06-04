package com.hann.ktorclient.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hann.ktorclient.R
import com.hann.ktorclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}