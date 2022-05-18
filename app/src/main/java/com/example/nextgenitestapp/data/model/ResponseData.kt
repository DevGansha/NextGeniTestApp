package com.example.nextgenitestapp.data.model

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("product_id")
    var productId: Int?= null,
    @SerializedName("product_slug")
    var productSlug: String?= null,
    @SerializedName("sale_price")
    var salePrice: Float?= null,
    @SerializedName("base_price")
    var basePrice: Float? = null,
    @SerializedName("percent_off")
    var percentOff: Int? = null,
    @SerializedName("is_bundle")
    var isBundle: Int? = null,
    @SerializedName("show_on_top")
    var showOnTop: Int?= null,
    @SerializedName("brand_name")
    var brandName: String? = null,
    @SerializedName("invId")
    var invId: Int?= null,
    @SerializedName("thumbnail_url")
    var thumbnailUrl: String?= null,
    @SerializedName("out_of_stock")
    var outOfStock: Int?  = null,
    @SerializedName("product_type")
    var productType: Int?= null,
    @SerializedName("name")
    var name: String?= null,
    @SerializedName("products_name")
    var productsName: String?= null,
    @SerializedName("vendor_name")
    var vendorName: String?= null,
    @SerializedName("category")
    var category: ArrayList<String> = arrayListOf(),
    @SerializedName("map_category")
    var mapCategory: ArrayList<ResponseMapCategory> = arrayListOf(),
    @SerializedName("final_price_base")
    var finalPriceBase : Float? = null,
    @SerializedName("final_price_sale")
    var finalPriceSale : Int?= null,
    @SerializedName("is_new")
    var isNew: Boolean?= null,
    @SerializedName("in_wishlist")
    var inWishlist: Int?= null,
    @SerializedName("on_discount")
    var onDiscount : Int?= null

)
