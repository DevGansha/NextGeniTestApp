package com.example.nextgenitestapp.ui.productdetail

import android.media.Image
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
import com.example.nextgenitestapp.ui.productlisting.ProductsAdapter
import com.example.nextgenitestapp.util.Resource
import com.example.nextgenitestapp.util.Util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment: Fragment() {

    var product_id = 0
    lateinit var frProductDetailBinding: FrProductDetailBinding
    val productDetailViewModel: ProductDetailViewModel by viewModels()
    private val imagesAdapter: ImageViewPagerAdapter by lazy { ImageViewPagerAdapter(requireContext()) }

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

        frProductDetailBinding.viewPager.apply {
            adapter = imagesAdapter
        }
        observeUI()

    }

    fun observeUI(){
        productDetailViewModel.product.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    frProductDetailBinding.apply {
                        progress.visibility= View.GONE
                        viewPager.visibility = View.VISIBLE
                        productTitle.visibility = View.VISIBLE
                        itemDescription.visibility = View.VISIBLE
                        productPrice.visibility = View.VISIBLE
                        productBrandName.visibility = View.VISIBLE
                        product = it.data?.body!!

                        imagesAdapter.submitList(product?.images!!)
                    }
                }
                is Resource.Error -> {
                    context?.toast(it.message.toString())
                }

                is Resource.Loading -> {
                    frProductDetailBinding.apply {
                        progress.visibility= View.VISIBLE
                        viewPager.visibility = View.GONE
                        productTitle.visibility = View.GONE
                        itemDescription.visibility = View.GONE
                        productPrice.visibility = View.GONE
                        productBrandName.visibility = View.GONE
                    }
//                    context?.toast("Loading")
                }
            }
        }
    }
}