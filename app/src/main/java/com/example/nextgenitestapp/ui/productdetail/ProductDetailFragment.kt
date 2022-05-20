package com.example.nextgenitestapp.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nextgenitestapp.R
import com.example.nextgenitestapp.databinding.FrProductDetailBinding
import com.example.nextgenitestapp.databinding.FrProductListingBinding
import com.example.nextgenitestapp.ui.productlisting.ProductListingViewModel
import com.example.nextgenitestapp.util.Resource
import com.example.nextgenitestapp.util.Util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment: Fragment() {

    var product_id = 0
    lateinit var frProductDetailBinding: FrProductDetailBinding
    val productDetailViewModel: ProductDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frProductDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fr_product_detail, container, false)
        return frProductDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product_id = getArguments()?.getInt("ProductId") ?: 0

        if(product_id != 0) productDetailViewModel.fetchProduct(product_id)
        observeUI()

    }

    fun observeUI(){
        productDetailViewModel.product.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    context?.toast("Success ${it.data?.body?.name}")
                }
                is Resource.Error -> {
                    context?.toast(it.message.toString())
                }

                is Resource.Loading -> {
                    context?.toast("Loading")
                }
            }
        }
    }
}