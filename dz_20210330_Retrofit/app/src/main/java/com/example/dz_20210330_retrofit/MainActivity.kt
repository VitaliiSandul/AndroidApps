package com.example.dz_20210330_retrofit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_20210330_retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewCurrencies : RecyclerView
    private lateinit var binding: ActivityMainBinding
    private lateinit var currencyViewModel : CurrencyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        currencyViewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)
        binding.viewmodel = currencyViewModel

        recyclerViewCurrencies = findViewById(R.id.recyclerViewCurrencies)
        recyclerViewCurrencies.layoutManager = LinearLayoutManager(this)

        currencyViewModel.currencyList.observe(this, Observer {
            recyclerViewCurrencies.adapter = CurrencyAdapter(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_load -> {
                currencyViewModel.loadCurrencies()
                return true
            }
            R.id.action_load_cashless -> {
                currencyViewModel.loadCashlessCurrencies()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}