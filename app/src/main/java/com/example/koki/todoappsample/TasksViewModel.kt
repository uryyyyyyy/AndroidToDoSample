package com.example.koki.todoappsample

import java.util.*

class TasksViewModel(private val navigator: TasksNavigator) {
    fun addNewTask(){
        this.navigator.addNewTask()
    }

    val empty = false

    val items = Arrays.asList("aa", "bb")
}
