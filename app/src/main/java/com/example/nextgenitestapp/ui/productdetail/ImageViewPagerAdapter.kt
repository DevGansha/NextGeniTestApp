package com.example.nextgenitestapp.ui.productdetail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nextgenitestapp.databinding.ImageItemBinding

class ImageViewPagerAdapter(val context: Context) :
    RecyclerView.Adapter<ImageViewPagerAdapter.ViewPagerViewHolder>() {

    var images: List<String> = ArrayList()

    inner class ViewPagerViewHolder(val itemBinding: ImageItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: String){
            itemBinding.apply {
                image = data
                executePendingBindings()
            }
        }
    }

    fun submitList(imagesLst: List<String>){
        //items.addAll(itemList)
        images = imagesLst
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = images.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ImageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(images[position])
    }
}