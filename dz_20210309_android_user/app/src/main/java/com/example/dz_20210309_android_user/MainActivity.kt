package com.example.dz_20210309_android_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View){
        val myToast = Toast.makeText(this, "Password should be at least 6 characters", Toast.LENGTH_SHORT)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)

        if(inputPassword.text.length < 6){
            myToast.show()
        } else{
            showSecondActivity(view)
        }
    }

    fun showSecondActivity(view: View){
        val tmpIntent = Intent(this, SecondActivity::class.java)
        val inputEmail = findViewById<EditText>(R.id.inputEmail)
        tmpIntent.putExtra(SecondActivity.USER, inputEmail.text.toString())

        startActivity(tmpIntent)
    }
}