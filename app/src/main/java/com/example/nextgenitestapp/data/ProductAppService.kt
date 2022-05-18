package com.example.nextgenitestapp.data

import com.example.nextgenitestapp.data.model.ProductListingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductAppService {
    @GET("products")
    suspend fun getProductsListingPageWise(@Query("category_id") category_id: Int, @Query("page") page_id : Int): Response<ProductListingResponse>
}
