package com.example.nextgenitestapp.ui.productdetail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nextgenitestapp.data.model.productDetailResponse.ProductDetailResponse
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
class ProductDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val product: MutableLiveData<Resource<ProductDetailResponse>> = MutableLiveData()


    fun fetchProduct(product_id: Int){
        product.postValue(Resource.Loading())

        viewModelScope.launch {
            try {
                if (hasInternetConnection(context)) {
                    val response = productRepository.fetchProductDetail(product_id)
                    if (response.isSuccessful) {
                        product.postValue(Resource.Success(response.body()!!))
                    } else{
                        product.postValue(Resource.Error(response.message()))
                    }
                }
                else{
                    product.postValue(Resource.Error("No Internet Connection"))
                }
            }catch (ex: Exception) {
                when (ex) {
                    is IOException -> product.postValue(Resource.Error("Network Failure " + ex.localizedMessage))
                    else -> product.postValue(Resource.Error(ex.message.toString()))
                }
            }
        }
    }
}