package com.example.koki.todoappsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TasksAdapter(private val list: List<String>): RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tv = holder.view.findViewById<TextView>(R.id.title)
        tv.text = "my Text ${list[position]}"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    inner class TaskViewHolder(var view: View): RecyclerView.ViewHolder(view)
}