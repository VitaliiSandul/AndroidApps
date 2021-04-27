package com.example.dz_20210329_recyclerviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_20210329_recyclerviewbinding.databinding.ActivityMainBinding

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val stringsRecyclerView = findViewById<RecyclerView>(R.id.stringsRecyclerView)
        val adapter = stringsRecyclerView.adapter as StringsAdapter

        when(item.itemId){
            R.id.action_clear -> adapter.removeAll()
            R.id.action_addrandom -> adapter.addRandom()
            else -> false
        }
        return super.onOptionsItemSelected(item)
    }

}