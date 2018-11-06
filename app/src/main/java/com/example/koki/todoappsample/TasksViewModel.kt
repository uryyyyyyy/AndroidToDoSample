package com.example.koki.todoappsample

import android.databinding.ObservableField
import java.util.*

class TasksViewModel(private val navigator: TasksNavigator) {
    fun addNewTask(){
//        this.navigator.addNewTask()
        this.items.set(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"))
    }

    val empty = false
    var items: ObservableField<List<String>> = ObservableField(Arrays.asList("11", "22", "3", "4", "5", "6", "7", "8", "9", "10"))
}

//baseobservable
