package com.example.nextgenitestapp.data.repository

import com.example.nextgenitestapp.data.ProductAppService
import com.example.nextgenitestapp.data.model.productDetailResponse.ProductDetailResponse
import com.example.nextgenitestapp.data.model.productListingResponse.ProductListingResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val productAppService: ProductAppService) {

    suspend fun fetchProducts(category_id: Int, page_id: Int): Response<ProductListingResponse> = withContext(
        Dispatchers.IO) {
        val products = productAppService.getProductsListingPageWise(category_id, page_id)
        products
    }

    suspend fun fetchProductDetail(productId: Int): Response<ProductDetailResponse> = withContext(Dispatchers.IO){
        val product = productAppService.getProductDetail(productId)
        product
    }
}