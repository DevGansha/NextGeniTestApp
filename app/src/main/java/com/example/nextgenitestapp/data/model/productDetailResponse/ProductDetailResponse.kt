package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class ProductDetailResponse(
    @SerializedName("status")
    var status: Int?= null,
    @SerializedName("message")
    var message         : String?           = null,
    @SerializedName("body")
    var body            : Body?             = Body(),
    @SerializedName("error")
    var error           : ArrayList<String> = arrayListOf(),
    @SerializedName("exception")
    var exception       : String?           = null,
    @SerializedName("update_available")
    var updateAvailable : Int?              = null
)
