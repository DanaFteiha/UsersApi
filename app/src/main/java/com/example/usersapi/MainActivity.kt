package com.example.usersapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    // You want Dagger to provide an instance of viewModel from the graph
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel : MainViewModel
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: UserAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
       // toolbar = findViewById(R.id.toolbar)
      //  val repository = Repository()

        val component = DaggerMainComponent.create().inject(this)

        //val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getUsers()
        viewModel.response.observe(this, Observer {
            viewAdapter.setData(it)
        })

    }

    private fun setupRecyclerView() {
        viewAdapter = UserAdapter(this)
        viewManager = LinearLayoutManager(this)
        recyclerView = findViewById<RecyclerView>(R.id.PersonsRecyclerView).apply {
            setHasFixedSize(true)
            // use a layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

    }
}

