package com.test.testkoin1.utils

import android.graphics.Rect
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.testkoin1.R
import com.test.testkoin1.adapter.RandomPagingAdapter

@BindingAdapter(value = ["imageUrl", "circleRound"], requireAll = false)
fun ImageView.setImageUrl(profileUrl: String? = "", isCircleRound: Boolean = false) {
    if (profileUrl != null && profileUrl.isNotEmpty())
        Glide
            .with(context)
            .load(profileUrl)
            .into(this)

    if (isCircleRound) {
        background = ShapeDrawable(OvalShape())
        clipToOutline = true
    }
}

@BindingAdapter("itemDecoration")
fun RecyclerView.setDecoration(isDecoration: Boolean) {
    if (isDecoration)
        addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)

                val offsetHeight = resources.getDimensionPixelSize(R.dimen.padding_small)
                val childViewPosition = parent.getChildAdapterPosition(view)

                outRect.top = offsetHeight

                /* 마지막 일 경우 하단 여유 */
                if (childViewPosition == state.itemCount - 1)
                    outRect.bottom = offsetHeight
            }
        })
}

@BindingAdapter("errorMsg")
fun setErrorMsg(view: View, errorMsg: String? = "") {
    if (errorMsg != null && errorMsg.isNotEmpty()) {
        Toast.makeText(view.context, errorMsg, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("userPagingAdapter")
fun setAdapter(view: RecyclerView, adapter: RandomPagingAdapter) =
    adapter.let { view.adapter = it }