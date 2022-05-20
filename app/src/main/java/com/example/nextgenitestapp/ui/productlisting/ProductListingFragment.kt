package com.example.nextgenitestapp.ui.productlisting

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.nextgenitestapp.R
import com.example.nextgenitestapp.data.model.ResponseData
import com.example.nextgenitestapp.databinding.FrProductListingBinding
import com.example.nextgenitestapp.util.Resource
import com.example.nextgenitestapp.util.Util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductListingFragment : Fragment(), RecyclerViewHomeClickListener{

    lateinit var frProductListingBinding: FrProductListingBinding
    val productListingViewModel: ProductListingViewModel by viewModels()
    private val productsAdapter: ProductsAdapter by lazy { ProductsAdapter(requireContext(), this) }

    var totalPages = 0
    var counter = 1
    var category_id = 27  //Hardcoded, as provided in API

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frProductListingBinding = DataBindingUtil.inflate(inflater, R.layout.fr_product_listing, container, false)
        return frProductListingBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frProductListingBinding.recyclerView.apply {
            adapter = productsAdapter

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(@NonNull recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView.canScrollVertically(1)) { //1 for down
                        if(counter <= totalPages){
                            productListingViewModel.fetchProducts(category_id)
                            ++counter
                        }
                    }
                }
            })
        }
        productListingViewModel.fetchProducts(category_id)
        observeUI()
    }

//    fun getData(){
//        productListingViewModel.fetchProducts(27)
//    }

    fun observeUI(){
        productListingViewModel.productsList.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    frProductListingBinding.progress.visibility = View.GONE
                    val data = it.data?.body?.data
                    totalPages = it.data?.body?.lastPage!!
                    productsAdapter.submitList(data!!)
                }
                is Resource.Error -> {
                    frProductListingBinding.progress.visibility = View.GONE
                    it.message?.let { message ->
                        context?.toast(message)
                    }
                }

                is Resource.Loading -> {
                    frProductListingBinding.progress.visibility = View.VISIBLE
                }
            }
        }
    }
    override fun clickOnItem(data: ResponseData, card: View) {
        context?.toast(data.toString())
    }
}