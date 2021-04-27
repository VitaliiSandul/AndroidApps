package com.example.dz_20210311_android_viewmodel_cars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.car_item.view.*

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarHolder>() {

    private var cars: List<Car> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        return CarHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.car_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(cars[position])
    }

    override fun getItemCount() = cars.size

    fun getListCars(cars: List<Car>){
        this.cars = cars
        notifyDataSetChanged()
    }


    class CarHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(car: Car) = with(itemView){
            carTitle.text = car.title
            carYear.text = car.year.toString()
            carColor.text = car.color
            carCountry.text = car.country
        }
    }
}