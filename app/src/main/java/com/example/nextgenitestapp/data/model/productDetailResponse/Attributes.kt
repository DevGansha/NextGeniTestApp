package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("attribute_name" ) var attributeName : String?            = null,
    @SerializedName("options"        ) var options       : ArrayList<Options> = arrayListOf()

)
