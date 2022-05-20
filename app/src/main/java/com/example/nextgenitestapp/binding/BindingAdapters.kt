package com.example.nextgenitestapp.binding

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.nextgenitestapp.data.model.productDetailResponse.Info
import java.util.*


@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
    }
}
@SuppressLint("SetTextI18n")
@BindingAdapter("bindHtml")
fun bindHtmlToTextView(view: TextView, info: ArrayList<Info>?){
    var str = ""
    info?.forEach {
        str += (it.name + it.text + "<br />")
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        val spanned = HtmlCompat.fromHtml(str, HtmlCompat.FROM_HTML_MODE_COMPACT)
        view.setText(spanned)
    }else{
        val spanned = Html.fromHtml(str)
        view.setText(spanned)
    }
}
