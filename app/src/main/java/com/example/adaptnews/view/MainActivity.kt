package com.example.adaptnews.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager


import com.example.adaptnews.R
import com.example.adaptnews.adapter.AdapterNews
import com.example.adaptnews.viewmodel.MainActivityViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GroupAdapter<ViewHolder>()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        val activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        activityViewModel.allArticle.observe(this, Observer { articles ->


            //for loop to put articles in the recyclerview (groupie)
            for (i in articles ) {
                adapter.add(AdapterNews(articles, this@MainActivity))
            }

       recyclerView.adapter = adapter

        })

    }
}





