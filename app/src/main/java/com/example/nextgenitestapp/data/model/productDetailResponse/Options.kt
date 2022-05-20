package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class Options(
    @SerializedName("name"             ) var name           : String?           = null,
    @SerializedName("invsku"           ) var invsku         : String?           = null,
    @SerializedName("invId"            ) var invId          : Int?              = null,
    @SerializedName("quantity"         ) var quantity       : Int?              = null,
    @SerializedName("base_price"       ) var basePrice      : Float?              = null,
    @SerializedName("sale_price"       ) var salePrice      : Float?              = null,
    @SerializedName("images_low"       ) var imagesLow      : ArrayList<ImagesLow> = arrayListOf(),
    @SerializedName("on_discount"      ) var onDiscount     : Int?              = null,
    @SerializedName("final_price_base" ) var finalPriceBase : Float?              = null,
    @SerializedName("final_price_sale" ) var finalPriceSale : Float?              = null,
    @SerializedName("sort_order"       ) var sortOrder      : Int?              = null
)
