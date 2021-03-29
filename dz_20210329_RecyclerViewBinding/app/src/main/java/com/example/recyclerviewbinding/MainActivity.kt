package com.example.recyclerviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewmodel = ViewModelProvider(this).get(StringsViewModel::class.java)
        binding.viewmodel = viewmodel

        val stringsRecyclerView = findViewById<RecyclerView>(R.id.stringsRecyclerView)
        stringsRecyclerView.layoutManager = LinearLayoutManager(this)
        stringsRecyclerView.adapter = StringsAdapter(viewmodel.strings)

    }

}