package com.example.adaptnews.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsResponse {
    /*
    class used to get data from API
    initialised every call for future use
    */

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null

    @SerializedName("articles")
    @Expose
    var articles: ArrayList<Article>? = null

}
