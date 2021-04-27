package com.example.dz_20210311_android_viewmodel_cars

object CarData {
    fun getCars() = listOf(
        Car("BMW Z4", 2021, "red", "Germany"),
        Car("Ford F-350", 2017, "silver", "USA"),
        Car("Jeep Wrangler", 2021, "black", "Italy"),
        Car("Lexus IS", 2014, "blue", "Japan"),
        Car("Tesla Model Y", 2020,"white", "USA"),
        Car("Volvo XC70", 2016, "brown", "Sweden"),
        Car("Mercedes-Benz G-Class", 2021, "brown", "Germany")
    )

    fun getClearList() = listOf<Car>()
}