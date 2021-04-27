package com.example.dz_20210330_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private val BASE_URL = "https://api.privatbank.ua/p24api/"
    private  val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService(): Privat24ApiInterface? {
        return retrofit.create(Privat24ApiInterface::class.java)
    }

}