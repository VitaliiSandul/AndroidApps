package com.example.dz_20210304_android_buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val incrementButton: Button = findViewById<Button>(R.id.incrementButton)
        val decrementButton: Button = findViewById<Button>(R.id.decrementButton)
        val tapMeButton: Button = findViewById<Button>(R.id.tapMeButton)
        val countTapsButton: Button = findViewById<Button>(R.id.countTapsButton)
        val txt: TextView = findViewById(R.id.textView)
        var numTaps: Int = 0

        incrementButton.setOnClickListener {
            var count = txt.text.toString().toInt()
            count++
            txt.text = count.toString()
        }
        decrementButton.setOnClickListener {
            var count = txt.text.toString().toInt()
            count--
            txt.text = count.toString()
        }
        tapMeButton.setOnClickListener {
            numTaps++
        }
        countTapsButton.setOnClickListener {
            Toast.makeText(this, "Number of taps: " + numTaps, Toast.LENGTH_SHORT).show()
        }

    }
}