package com.example.adaptnews.model.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.adaptnews.model.Article
import com.example.adaptnews.model.NewsResponse
import com.example.adaptnews.remote.NewsServiceApi
import com.example.adaptnews.remote.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsRepository(private val application: Application) {
    private val TAG = "Newsrepo"

    private var mutableLiveData: MutableLiveData<List<Article>>? = null
    private val articles = MutableLiveData<List<Article>>()
    private val compositeDisposable = CompositeDisposable()


    //RxJava implementation to get news async'd
    fun getMutableLiveData(): MutableLiveData<List<Article>> {
        if (mutableLiveData == null) {
            mutableLiveData = MutableLiveData()
        }
        val serviceApi = RetrofitClient.getClient("https://newsapi.org/v2/").create(NewsServiceApi::class.java)
        val disposable = serviceApi.fetchNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { newsResponse ->
                    articles.setValue(newsResponse.articles)
                },
                { throwable -> Log.d(TAG, "onStart: $throwable") }
            )

        compositeDisposable.add(disposable)

        return articles
    }

}
