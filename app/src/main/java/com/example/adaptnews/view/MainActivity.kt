package com.example.adaptnews.view

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.example.adaptnews.adapter.NewsAdapter

import com.example.adaptnews.viewmodel.MainActivityViewModel
import com.example.adaptnews.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder

class MainActivity : AppCompatActivity() {

    internal lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)



      //  val groupie = GroupAdapter<ViewHolder>()
      // recyclerView.adapter = groupie



        val activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        activityViewModel.allArticle.observe(this, Observer { articles ->
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = NewsAdapter(articles!!, this@MainActivity)
        })

    }
}
