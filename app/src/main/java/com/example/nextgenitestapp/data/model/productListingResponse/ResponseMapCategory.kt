package com.example.nextgenitestapp.data.model.productListingResponse

import com.google.gson.annotations.SerializedName

data class ResponseMapCategory(
    @SerializedName("category_id")
    var categoryId: Int?= null,

    @SerializedName("category_name")
    var categoryName : String? = null
)
