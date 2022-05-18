package com.example.nextgenitestapp.ui.productlisting

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nextgenitestapp.R
import com.example.nextgenitestapp.databinding.FrProductListingBinding
import com.example.nextgenitestapp.util.Resource
import com.example.nextgenitestapp.util.Util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListingFragment : Fragment(){

    lateinit var frProductListingBinding: FrProductListingBinding
    val productListingViewModel: ProductListingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frProductListingBinding = DataBindingUtil.inflate(inflater, R.layout.fr_product_listing, container, false)
        return frProductListingBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productListingViewModel.fetchPopular(27, 1)
        observeUI()
    }

    fun observeUI(){
        productListingViewModel.productsList.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    context?.toast("Success")
                }
                is Resource.Error -> {
                    context?.toast("Error")
                }

                is Resource.Loading -> {
                    context?.toast("Loading")
                }

            }
        }
    }
}