package com.example.nextgenitestapp.data.model.productDetailResponse

import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("product_id"           ) var productId           : Int?                         = null,
    @SerializedName("sale_price"           ) var salePrice           : Float?                         = null,
    @SerializedName("base_price"           ) var basePrice           : Float?                         = null,
    @SerializedName("percent_off"          ) var percentOff          : Int?                         = null,
    @SerializedName("is_gc"                ) var isGc                : Int?                         = null,
    @SerializedName("product_slug"         ) var productSlug         : String?                      = null,
    @SerializedName("google_place_id"      ) var googlePlaceId       : String?                      = null,
    @SerializedName("is_custom_message"    ) var isCustomMessage     : Int?                         = null,
    @SerializedName("custom_question"      ) var customQuestion      : String?                      = null,
    @SerializedName("custom_title"         ) var customTitle         : String?                      = null,
    @SerializedName("is_sap"               ) var isSap               : Int?                         = null,
    @SerializedName("brand_name"           ) var brandName           : String?                      = null,
    @SerializedName("vendor_name"          ) var vendorName          : String?                      = null,
    @SerializedName("size_and_fit_image"   ) var sizeAndFitImage     : String?                      = null,
    @SerializedName("product_type"         ) var productType         : Int?                         = null,
    @SerializedName("videos"               ) var videos              : ArrayList<String>            = arrayListOf(),
    @SerializedName("thumbnail_url"        ) var thumbnailUrl        : String?                      = null,
    @SerializedName("images"               ) var images              : ArrayList<String>            = arrayListOf(),
    @SerializedName("images_low"           ) var imagesLow           : ArrayList<ImagesLow>?         = arrayListOf(),
    @SerializedName("images_web"           ) var imagesWeb           : ArrayList<String>            = arrayListOf(),
    @SerializedName("images_web_low"       ) var imagesWebLow        : ArrayList<String>            = arrayListOf(),
    @SerializedName("name"                 ) var name                : String?                      = null,
    @SerializedName("products_description" ) var productsDescription : String?                      = null,
    @SerializedName("short_description"    ) var shortDescription    : String?                      = null,
    @SerializedName("size_and_fit"         ) var sizeAndFit          : String?                      = null,
    @SerializedName("delivery"             ) var delivery            : String?                      = null,
    @SerializedName("in_wishlist"          ) var inWishlist          : Int?                         = null,
    @SerializedName("on_discount"          ) var onDiscount          : Int?                         = null,
    @SerializedName("final_price_base"     ) var finalPriceBase      : Float?                         = null,
    @SerializedName("final_price_sale"     ) var finalPriceSale      : Float?                         = null,
    @SerializedName("attributes_options"   ) var attributesOptions   : ArrayList<AttributesOptions> = arrayListOf(),
    @SerializedName("is_new"               ) var isNew               : String?                      = null,
    @SerializedName("shipping_time"        ) var shippingTime        : String?                      = null,
    @SerializedName("attributes"           ) var attributes          : ArrayList<Attributes>        = arrayListOf(),
    @SerializedName("wrapping_methods"     ) var wrappingMethods     : ArrayList<String>            = arrayListOf(),
    @SerializedName("info"                 ) var info                : ArrayList<Info>              = arrayListOf(),
    @SerializedName("experience_info"      ) var experienceInfo      : ArrayList<ExperienceInfo>    = arrayListOf(),
    @SerializedName("map_category"         ) var mapCategory         : ArrayList<MapCategory>       = arrayListOf(),
    @SerializedName("category"             ) var category            : ArrayList<String>            = arrayListOf(),
    @SerializedName("shareable_link"       ) var shareableLink       : String?                      = null,
    @SerializedName("suggested"            ) var suggested           : ArrayList<Suggested>         = arrayListOf()

)