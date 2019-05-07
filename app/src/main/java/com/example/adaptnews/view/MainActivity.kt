package com.example.adaptnews.view

import android.graphics.Color
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.example.adaptnews.adapter.NewsAdapter

import com.example.adaptnews.viewmodel.MainActivityViewModel
import com.example.adaptnews.R
import com.example.adaptnews.adapter.FancyItem
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.single_news_view.view.*
import java.util.*


class MainActivity : AppCompatActivity() {

    internal lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)


        //test of groupie recyclerview
        val boring = generateFancyItems(6)


        val activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        activityViewModel.allArticle.observe(this, Observer { articles ->

            recyclerView.apply {
                layoutManager = GridLayoutManager(this@MainActivity, groupie.spanCount).apply {
                    spanSizeLookup = groupie.spanSizeLookup
                }
                adapter = groupie
            }

            //recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = NewsAdapter(articles!!, this@MainActivity)
        })

    }

    val groupie = GroupAdapter<ViewHolder>().apply {
        spanCount = 3
    }
/*
    recyclerView.apply {
        layoutManager = GridLayoutManager(this@MainActivity, groupie.spanCount).apply {
            spanSizeLookup = groupie.spanSizeLookup
        }
        adapter = groupie
    }
*/
    fun generateFancyItems(count: Int) : MutableList<FancyItem> {
        val rnd = Random()
        return MutableList(count) {
            val color = Color.argb(255,255,255,255)
            FancyItem(color,rnd.nextInt(100))
        }
    }



}
