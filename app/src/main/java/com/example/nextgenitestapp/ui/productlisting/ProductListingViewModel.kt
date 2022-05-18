package com.example.nextgenitestapp.ui.productlisting

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nextgenitestapp.data.model.ProductListingResponse
import com.example.nextgenitestapp.data.repository.ProductRepository
import com.example.nextgenitestapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ProductListingViewModel @Inject constructor(
    private val productRepository: ProductRepository) : ViewModel() {

    val productsList: MutableLiveData<Resource<ProductListingResponse>> = MutableLiveData()

    fun fetchPopular(category_id: Int, page_id: Int){
        productsList.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
                val response = productRepository.fetchProducts(category_id = category_id, page_id = page_id)
                if(response.isSuccessful && response.body()?.body?.data?.size!! > 0){
                    productsList.postValue(Resource.Success(response.body()!!))
                } else
                    productsList.postValue(Resource.Error("No problems available"))
            } catch (ex: Exception) {
                when (ex) {
                    is IOException -> productsList.postValue(Resource.Error("Network Failure " +  ex.localizedMessage))
                    else -> productsList.postValue(Resource.Error("Conversion Error"))
                }
            }
        }
    }
}