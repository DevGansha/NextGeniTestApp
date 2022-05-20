package com.example.nextgenitestapp.ui.productlisting

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nextgenitestapp.data.model.ProductListingResponse
import com.example.nextgenitestapp.data.model.ResponseData
import com.example.nextgenitestapp.data.repository.ProductRepository
import com.example.nextgenitestapp.util.Resource
import com.example.nextgenitestapp.util.hasInternetConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ProductListingViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    var currentPage = 1
    var productResponse: ProductListingResponse ?= null
    val productsList: MutableLiveData<Resource<ProductListingResponse>> = MutableLiveData()

    fun fetchProducts(category_id: Int){
        productsList.postValue(Resource.Loading())

        viewModelScope.launch {
            try {
                if (hasInternetConnection(context)) {
                    val response = productRepository.fetchProducts(
                        category_id = category_id,
                        page_id = currentPage
                    )
                    if (response.isSuccessful) {
                        productsList.postValue(handleResponse(response))
                    } else{
                        productsList.postValue(Resource.Error(response.message()))
                    }
                }
                else{
                    productsList.postValue(Resource.Error("No Internet Connection"))
                }
            }catch (ex: Exception) {
                when (ex) {
                    is IOException -> productsList.postValue(Resource.Error("Network Failure " + ex.localizedMessage))
                    else -> productsList.postValue(Resource.Error("Conversion Error"))
                }
            }
        }
    }

    private fun handleResponse(response: Response<ProductListingResponse>): Resource<ProductListingResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                currentPage++
                if (productResponse == null)
                    productResponse = resultResponse
                else {
                    val oldProducts: ArrayList<ResponseData> ?= productResponse!!.body?.data
                    val newProducts: ArrayList<ResponseData>?= resultResponse.body?.data
                    oldProducts!!.addAll(newProducts!!)
                }
                return Resource.Success(productResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}