package com.example.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter


class ImageViewPagerAdapter(private val imageList: MutableList<Int>, val itemListener: ItemListener) : PagerAdapter() {

    override fun getCount() = imageList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.item_image_layout, container, false)

        val image = view.findViewById<ImageView>(R.id.ivImage)
        image.setImageResource(imageList[position])

        container.addView(view)

        image.setOnClickListener {
            itemListener.onImageClick(position)
        }

        return view
    }

    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        parent.removeView(`object` as View)
    }
}