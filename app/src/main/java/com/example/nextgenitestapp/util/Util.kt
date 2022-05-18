package com.example.nextgenitestapp.util

import android.content.Context
import android.widget.Toast

object Util {
    fun Context.toast(message:String){
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show()
    }
}