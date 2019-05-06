package com.example.adaptnews.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Source {
    /*
    class used to get data from API
    initialised every call for future use
    */

    @SerializedName("id")
    @Expose
    var id: Any? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}
