package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class MapCategory(
    @SerializedName("category_id"   ) var categoryId   : Int?    = null,
    @SerializedName("category_name" ) var categoryName : String? = null
)
