package com.example.nextgenitestapp.data

import com.example.nextgenitestapp.data.model.productDetailResponse.ProductDetailResponse
import com.example.nextgenitestapp.data.model.productListingResponse.ProductListingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductAppService {
    @GET("products")
    suspend fun getProductsListingPageWise(@Query("category_id") category_id: Int, @Query("page") page_id : Int): Response<ProductListingResponse>

    @GET("product/{id}")
    suspend fun getProductDetail(@Path("id") id: Int) : Response<ProductDetailResponse>
}
