package com.sharry.demo.mvvmdemo

import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.databinding.BindingAdapter

/**
 * @author Sharry [Contact me.](SharryChooCHN@Gmail.com)
 * @version 1.0
 * @since 2019-05-20 17:22
 */
object MainBindingAdapter {

    @JvmStatic
    @BindingAdapter("itemDataSet")
    fun setItemDataSet(list: ListView, dataSet: List<String>) {
        if (list.adapter == null) {
            list.adapter = ArrayAdapter(list.context, R.layout.item_main, R.id.tv_text, dataSet)
        } else {
            (list.adapter as ArrayAdapter<String>).notifyDataSetChanged()
        }
    }

}
