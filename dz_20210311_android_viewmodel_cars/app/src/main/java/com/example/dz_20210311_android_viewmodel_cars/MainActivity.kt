package com.example.dz_20210311_android_viewmodel_cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val carViewModel by lazy{
        ViewModelProviders.of(this).get(CarViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.listCars -> {
                carViewModel.refreshListCars()
            }
            R.id.clearCars -> {
                carViewModel.clearList()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CarAdapter()
        carList.layoutManager = LinearLayoutManager(this)
        carList.adapter = adapter
        carViewModel.getListCars().observe(this, Observer {
            it?.let{
                adapter.getListCars(it)
            }
        })
    }

    fun addCar(view: View) {
        val Title = findViewById<EditText>(R.id.addCarTitle)
        val Year = findViewById<EditText>(R.id.addCarYear)
        val Color = findViewById<EditText>(R.id.addCarColor)
        val Country = findViewById<EditText>(R.id.addCarCountry)
        val car: Car = Car(Title.text.toString(),Year.text.toString().toInt(),Color.text.toString(),Country.text.toString())
        carViewModel.addCar(car)
    }
}