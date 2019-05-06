package com.example.adaptnews.remote

import com.example.adaptnews.model.News
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
 //https://www.vogella.com/tutorials/Retrofit/article.html
interface NewsServiceApi {

    @GET
    fun getAllNews(@Url urlString: String): Observable<News> //observable = rxjava, call = retrofit




}
