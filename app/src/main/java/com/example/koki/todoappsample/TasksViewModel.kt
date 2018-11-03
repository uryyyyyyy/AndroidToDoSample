package com.example.koki.todoappsample

class TasksViewModel(private val navigator: TasksNavigator) {
    fun addNewTask(){
        this.navigator.addNewTask()
    }

    val empty = false
}
