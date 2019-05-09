package com.example.adaptnews.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import com.bumptech.glide.Glide
import com.example.adaptnews.R
import com.example.adaptnews.model.Article
import com.example.adaptnews.view.WebViewActivity
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.single_news_view.*
import java.text.SimpleDateFormat

class AdapterNews(internal var articles: List<Article>, private val context: Context) : Item() {

    val TAG = "AdapterNews"

    @SuppressLint("SimpleDateFormat")
    override fun bind(viewHolder: ViewHolder, position: Int) {

        viewHolder.title.text = articles[position].title

        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX") //
        val date = dateFormat.parse(articles[position].publishedAt)

        val formatter = SimpleDateFormat("dd-MM-yyyy - HH:mm") //format for time like 'HH:mm:ss'
        val dateStr = formatter.format(date)
        Log.d(TAG, "Date formatted: $dateStr")


        Log.d(TAG, "DATO FRA JSON: " + articles[position].publishedAt)
        viewHolder.date.text = dateStr

        val photoUrl = articles[position].urlToImage
        Glide.with(context).load(photoUrl).into(viewHolder.image)



        viewHolder.itemView.setOnClickListener {
            //position of current click - only for testing purpose
            Log.d(TAG, "position: $position")

            //store url to later use in webview
            val url = articles[position].url
            Log.d(TAG, "URL: $url")


            //pass on url
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url", url)
            context.startActivities(arrayOf(intent))
        }

    }

    override fun getLayout(): Int = R.layout.single_news_view

}