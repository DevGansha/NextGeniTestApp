package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class AttributesOptions(
    @SerializedName("name"    ) var name    : String?            = null,
    @SerializedName("options" ) var options : ArrayList<Options> = arrayListOf()
)
