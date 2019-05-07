package com.example.adaptnews.adapter

import androidx.annotation.ColorInt
import com.example.adaptnews.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.single_news_view.*

class FancyItem(@ColorInt private val color: Int, private val number: Int) : Item() {


    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.fancy_cardview.setCardBackgroundColor(color)

    }

    override fun getLayout(): Int = R.layout.single_news_view

    override fun getSpanSize(spanCount: Int, position: Int) = spanCount / 3
}