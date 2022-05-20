package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class ExperienceInfo (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("text" ) var text : String? = null
)