package com.example.adaptnews.model.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import com.example.adaptnews.BuildConfig
import com.example.adaptnews.adapter.NewsAdapter
import com.example.adaptnews.model.Article
import com.example.adaptnews.model.News
import com.example.adaptnews.remote.NewsServiceApi
import com.example.adaptnews.remote.RetrofitClient
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(private val application: Application) {
    private val TAG = "Newsrepo"

    private var mutableLiveData: MutableLiveData<List<Article>>? = null
    /*
    private var mCompositeDisposable: CompositeDisposable? = null
    private var mAndroidArrayList: ArrayList<News>? = null
    private var mAdapter: NewsAdapter? = null

*/
    private val articles: BehaviorSubject<News>? = null

    fun getMutableLiveData(): MutableLiveData<List<Article>> {
        if (mutableLiveData == null) {
            mutableLiveData = MutableLiveData()
        }
        val serviceApi = RetrofitClient.getClient(BASE_URL).create(NewsServiceApi::class.java)
        val news_url = "top-headlines?country=us&apiKey=6cc3df63b27240abb750b28cd5b540af" //better storage of this required
        serviceApi.getAllNews(news_url)
        .enqueue(object : Callback<News> {
        override fun onResponse(call: Call<News>, response: Response<News>) {

            if (response.isSuccessful) {
                val newsRes = response.body()!!
                val articleList = newsRes.articles
                mutableLiveData!!.setValue(articleList)
            }
        }


        override fun onFailure(call: Call<News>, t: Throwable) {}
    })


          /*
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<News> {

                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")


                }

                override fun onNext(t: News) {
                    Log.d(TAG, "onNext")

                    //need to put them into the adapter


                    Log.d(TAG, "List has: "+t.totalResults+ " Results") //receives the number of entries correctly
                }

                override fun onError(e: Throwable) {
                   e.localizedMessage
                }

            })

*/


        return mutableLiveData as MutableLiveData<List<Article>> //returned as MutableLiveData<list> to avoid smartcast errors in kotlin. The return func may change and therefore cannot be !!
    }




    companion object {


        private val BASE_URL = "https://newsapi.org/v2/" //api url

    }
    private fun handleError(error: Throwable) {

        Log.d(TAG, error.localizedMessage)


    }

    private fun handleResponse(newsList: List<News>) {
/*
        mAndroidArrayList = ArrayList(newsList)
        mAdapter = NewsAdapter(mAndroidArrayList!!, this)

        rv_android_list.adapter = mAdapter
*/



    }


    /*
    serviceApi.getAllNews(news_url)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(this:: handleResponse, this::handleError)
    Log.d(TAG,"RECEIVED DATA  ${serviceApi.getAllNews(news_url)}")

*/
    //Work in progress - Retrofit fetches data, but trying to get RxJava up





}
