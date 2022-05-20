package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class ImagesLow(
    @SerializedName("high" ) var high : String? = null,
    @SerializedName("low"  ) var low  : String? = null
)
