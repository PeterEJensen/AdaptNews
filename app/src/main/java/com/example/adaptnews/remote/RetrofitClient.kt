package com.example.adaptnews.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getClient(baseUrl: String): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseUrl) //baseurl defined in NewsAdapter and is API url
                .addConverterFactory(GsonConverterFactory.create()) //serialize and deserialize objects
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //call RxJava factory to support RxJava
                .build()
    }
}
