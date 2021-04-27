package com.example.firebaseauthapp

interface TaskRowListener {
    fun onTaskChange(taskId: String, isDone: Boolean)
}