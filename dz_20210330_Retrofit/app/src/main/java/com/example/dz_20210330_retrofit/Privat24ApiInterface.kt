package com.example.dz_20210330_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Privat24ApiInterface {
    @GET("pubinfo?json&exchange&coursid=5")
    fun getCurrencies() : Call<ArrayList<Currency>>

    @GET("pubinfo?exchange&json&coursid=11")
    fun getCashlessCurrencies() : Call<ArrayList<Currency>>
}