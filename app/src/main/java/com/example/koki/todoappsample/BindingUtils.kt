package com.example.koki.todoappsample

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

object BindingUtils {
    @JvmStatic
    @BindingAdapter("app:items2")
    fun setItems(recyclerView: RecyclerView, items: List<String>) {
        val a = TasksAdapter(items)
        recyclerView.adapter = a
        recyclerView.setHasFixedSize(true)
        val lm = LinearLayoutManager(recyclerView.context)
        recyclerView.layoutManager = lm
    }
}