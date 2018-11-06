package com.example.koki.todoappsample

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

object BindingUtils {
    @JvmStatic
    @BindingAdapter("items")
    fun setItems(recyclerView: RecyclerView, items: List<String>) {
        val adapter = recyclerView.adapter as TasksAdapter?
        adapter!!.setNew(items)
    }
}