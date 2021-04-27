package com.example.dz_20210331_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener(){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_layout, BlankFragment1.newInstance("a","b"))
                .commit()
        }

        btn2.setOnClickListener(){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_layout, BlankFragment2.newInstance("a","b"))
                .commit()
        }
    }
}