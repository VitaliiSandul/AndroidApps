package com.example.firebaseauthapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btn_login_first.setOnClickListener {
            LoginDialog().show(supportFragmentManager, "LoginDialog")
        }

        btn_register_first.setOnClickListener {
            RegisterDialog().show(supportFragmentManager, "RegisterDialog")
        }
    }
}