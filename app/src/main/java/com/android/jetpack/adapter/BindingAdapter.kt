package com.android.jetpack.adapter

import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.android.jetpack.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/
@BindingAdapter("isGone")
fun bingIsGone(view: View, isGone: Boolean?) {
    if (isGone == null || isGone) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("imgFromUrl")
fun bindImageFromUrl(imageView: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(imageView.context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }
}

@BindingAdapter("fabIsGone")
fun bindIsGoneFab(view: FloatingActionButton, isGone: Boolean?) {
    if (isGone == null || isGone) {
        view.hide()
    } else {
        view.show()
    }
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(view: TextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}

@BindingAdapter("wateringText")
fun binWateringText(view: TextView, wateringInterval: Int) {
    val resources = view.context.resources
    val quantityString = resources.getQuantityString(
        R.plurals.watering_needs_suffix,
        wateringInterval,
        wateringInterval
    )
    view.text = quantityString
}
