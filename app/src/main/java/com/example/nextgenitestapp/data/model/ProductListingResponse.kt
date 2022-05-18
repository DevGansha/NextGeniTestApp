package com.example.nextgenitestapp.data.model

import com.google.gson.annotations.SerializedName

data class ProductListingResponse (
    @SerializedName("status")
    var status: Int? = null,

    @SerializedName("message" )
    var message: String? = null,

    @SerializedName("body" )
    var body: ResponseBody? = ResponseBody(),

    @SerializedName("error")
    var error: ArrayList<String> = arrayListOf(),

    @SerializedName("exception")
    var exception: String? = null,

    @SerializedName("update_available" )
    var updateAvailable : Int?= null
)