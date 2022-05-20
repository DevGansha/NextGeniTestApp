package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class Suggested(
    @SerializedName("product_id"       ) var productId      : Int?     = null,
    @SerializedName("name"             ) var name           : String?  = null,
    @SerializedName("product_slug"     ) var productSlug    : String?  = null,
    @SerializedName("thumbnail_url"    ) var thumbnailUrl   : String?  = null,
    @SerializedName("base_price"       ) var basePrice      : Float?     = null,
    @SerializedName("sale_price"       ) var salePrice      : Float?     = null,
    @SerializedName("in_wishlist"      ) var inWishlist     : Int?     = null,
    @SerializedName("is_new"           ) var isNew          : Boolean? = null,
    @SerializedName("final_price_base" ) var finalPriceBase : Float?     = null,
    @SerializedName("final_price_sale" ) var finalPriceSale : Float?     = null
)
