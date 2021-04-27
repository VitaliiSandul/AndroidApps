package com.example.dz_20210311_android_viewmodel_cars

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class CarViewModel : ViewModel() {
    var carList: MutableLiveData<List<Car>> = MutableLiveData()
    var tmpListCars: ArrayList<Car> = ArrayList<Car>()

    init{
        carList.value = CarData.getCars()
        CarData.getCars().forEach { tmpListCars.add(it) }
    }

    fun getListCars() = carList

    fun refreshListCars(){
        carList.value = CarData.getCars()
    }

    fun clearList(){
        carList.value = CarData.getClearList()
        tmpListCars  = ArrayList<Car>()
    }

    fun addCar(car: Car){
        tmpListCars.add(car)
        carList.value = tmpListCars

    }

}