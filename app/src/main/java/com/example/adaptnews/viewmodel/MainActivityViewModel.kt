package com.example.adaptnews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.adaptnews.model.repository.NewsRepository

import com.example.adaptnews.model.Article


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    internal var newsRepository: NewsRepository

    val allArticle: LiveData<List<Article>>
        get() = newsRepository.getMutableLiveData()

    init {
        newsRepository = NewsRepository(application)
    }




}
