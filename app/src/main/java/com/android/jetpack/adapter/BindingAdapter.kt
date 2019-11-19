package com.android.jetpack.adapter

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/
@BindingAdapter("isGone")
fun bingIsGone(view: View, isGone: Boolean) {
    if (isGone) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}