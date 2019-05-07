package com.example.adaptnews.adapter

import android.content.Context
import android.content.Intent
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

import com.example.adaptnews.R
import com.example.adaptnews.model.Article
import com.example.adaptnews.view.WebViewActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

import java.text.SimpleDateFormat


class NewsAdapter(internal var articles: List<Article>, private val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_news_view, parent, false)
        return NewsViewHolder(view)


    }



    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.title.text = articles[position].title

        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        val date =
            dateFormat.parse(articles[position].publishedAt)//You will get date object relative to server/client timezone wherever it is parsed
        val formatter =
            SimpleDateFormat("dd-MM-yyyy - HH:mm") //If you need time just put specific format for time like 'HH:mm:ss'
        val dateStr = formatter.format(date)
        Log.d(TAG, "Date formatted: $dateStr")


        Log.d(TAG, "DATO FRA JSON: "+articles[position].publishedAt)
        holder.date.text = dateStr




        val photoUrl = articles[position].urlToImage
        Glide.with(context).load(photoUrl).into(holder.imageView) //Async the image recover?


    }
    //size of list holding articles
    override fun getItemCount(): Int {
        return articles.size
    }

    //init and setup items in recyclerview
    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var title: TextView
        internal var date: TextView
        internal var imageView: ImageView

        init {

            title = itemView.findViewById(R.id.title)
            date = itemView.findViewById(R.id.date)
            imageView = itemView.findViewById(R.id.image)

            itemView.setOnClickListener {
                //position of current click - only for testing purpose
                val position = adapterPosition
                Log.d(TAG, "position: $position")

                //store url to later use in webview
                val url = articles[position].url
                Log.d(TAG, "URL: $url")


                //pass on url
                val intent = Intent(itemView.context, WebViewActivity::class.java)
                intent.putExtra("url", url)
                itemView.context.startActivities(arrayOf(intent))
            }
        }
    }

    companion object {

        val TAG = "NewsAdapter"
    }



}

