package com.example.nextgenitestapp.ui.productlisting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nextgenitestapp.data.model.ResponseData
import com.example.nextgenitestapp.databinding.LiProductBinding

class ProductsAdapter(val context: Context, val recyclerViewHome: RecyclerViewHomeClickListener) : RecyclerView.Adapter<ViewHolder>(){
    private lateinit var recyclerView: RecyclerView

    private val TAG: String = "AppDebug"

    var items: List<ResponseData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LiProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        item.let {
            holder.apply {
                bind(item, isLinearLayoutManager())
                itemView.tag = item
            }
        }

        holder.itemView.setOnClickListener {
            recyclerViewHome.clickOnItem(
                item,
                holder.itemView
            )
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(itemList: List<ResponseData>){
        //items.addAll(itemList)
        items = itemList
        notifyDataSetChanged()
    }

    private fun isLinearLayoutManager() = recyclerView.layoutManager is LinearLayoutManager
}

class ViewHolder(private val binding: LiProductBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: ResponseData, isLinearLayoutManager: Boolean) {
        binding.apply {
            product = data
            executePendingBindings()
        }
    }
}
interface RecyclerViewHomeClickListener {
    fun clickOnItem(data: ResponseData, card: View)
}
