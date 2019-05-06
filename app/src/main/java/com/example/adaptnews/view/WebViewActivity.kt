package com.example.adaptnews.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adaptnews.R

import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)



        //use databinding for this class to comply with mvvm?
        val url = intent.getStringExtra("url") // get url from main activity


        //enable javascript and handling of phone view
        webviewtest.settings.javaScriptEnabled = true
        webviewtest.settings.loadWithOverviewMode = true
        webviewtest.settings.useWideViewPort = true
        webviewtest.loadUrl(url)
    }
}