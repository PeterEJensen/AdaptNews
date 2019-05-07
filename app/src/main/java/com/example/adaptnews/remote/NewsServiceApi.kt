package com.example.adaptnews.remote

import com.example.adaptnews.model.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsServiceApi {
/*
    @GET
    fun getAllNews(@Url urlString: String): Call<NewsResponse> //unused - works for retrofit without rxjava
*/

    @GET("top-headlines?country=us&apiKey=6cc3df63b27240abb750b28cd5b540af")
    abstract fun fetchNews(): Observable<NewsResponse>


}
