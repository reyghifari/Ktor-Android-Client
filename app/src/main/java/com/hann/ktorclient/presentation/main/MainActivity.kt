package com.hann.ktorclient.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hann.ktorclient.R
import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.databinding.ActivityMainBinding
import com.hann.ktorclient.presentation.ui.UserAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val mainViewModel : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        mainViewModel.user.observe(this){
            when(it){
                is Resource.Loading -> {

                }
                is Resource.Error -> {
                    binding.rvUserMain.visibility = View.GONE
                    binding.viewErrorMain.root.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.rvUserMain.visibility = View.VISIBLE
                    userAdapter.setData(it.data)
                }
            }
        }
    }

    private fun initRecyclerView(){
        userAdapter = UserAdapter()
        binding.rvUserMain.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvUserMain.adapter = userAdapter
        binding.rvUserMain.setHasFixedSize(false)
        userAdapter.onItemClick = {
            Toast.makeText(this, it.login, Toast.LENGTH_SHORT).show()
        }
    }
}