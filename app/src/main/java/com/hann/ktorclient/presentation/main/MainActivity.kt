package com.hann.ktorclient.presentation.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hann.ktorclient.R
import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.databinding.ActivityMainBinding
import com.hann.ktorclient.presentation.ui.UserAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(),  SearchView.OnQueryTextListener  {

    private lateinit var binding:ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val mainViewModel : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        mainViewModel.state.observe(this){user->
            if (user.isLoading){
                binding.loadingUser.visibility = View.VISIBLE
            }
            if (user.error.isNotBlank()){
                binding.rvUserMain.visibility = View.GONE
                binding.viewErrorMain.root.visibility = View.VISIBLE
            }
            if (user.users.isNotEmpty()){
                binding.viewErrorMain.root.visibility = View.GONE
                binding.loadingUser.visibility = View.GONE
                binding.rvUserMain.visibility = View.VISIBLE
                userAdapter.setData(user.users)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)

        val search = menu?.findItem(R.id.search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
        return true
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

    override fun onQueryTextSubmit(query: String?): Boolean {
        searchUser(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun searchUser(query: String?){
        if(query.isNullOrEmpty()) {
            return
        }
        mainViewModel.getUsers(query)
    }


}