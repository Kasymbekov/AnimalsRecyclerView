package com.example.animalsrecyclerview

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadData(url: String) {
    Glide.with(this).load(url).into(this)
}