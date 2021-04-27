package com.example.dz_20210309_android_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    companion object {
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        showUser()
    }

    fun showUser(){
        val user = intent.getStringExtra(USER)
        val txt = findViewById<TextView>(R.id.textViewWelcome)
        txt.text = "Welcome, " + user
    }
}