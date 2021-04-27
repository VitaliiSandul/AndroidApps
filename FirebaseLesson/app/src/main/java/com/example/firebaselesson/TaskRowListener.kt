package com.example.firebaselesson

interface TaskRowListener {
    fun onTaskChange(taskId: String, isDone: Boolean)
}