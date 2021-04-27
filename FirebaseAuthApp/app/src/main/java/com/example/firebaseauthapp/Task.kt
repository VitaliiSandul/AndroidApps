package com.example.firebaseauthapp

class Task {
    companion object Factory{
        fun create(): Task = Task()
    }

    var taskId: String? = null
    var taskDesc: String? = null
    var done: Boolean? = false
    var userId: String? = null
}