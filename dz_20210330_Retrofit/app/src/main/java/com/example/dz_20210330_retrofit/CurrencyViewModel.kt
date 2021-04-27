package com.example.dz_20210330_retrofit

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyViewModel: ViewModel() {
    var currencyList = MutableLiveData<ArrayList<Currency>>()

    init{
        loadCurrencies()
    }

    fun loadCurrencies() {
        val service = RetrofitService().getService()
        service?.getCurrencies()?.enqueue(object: Callback<ArrayList<Currency>> {
            override fun onFailure(call: Call<ArrayList<Currency>>, t: Throwable) {
                Log.d("PRIVAT24_CURRENCY", t.localizedMessage)
            }

            override fun onResponse(
                    call: Call<ArrayList<Currency>>,
                    response: Response<ArrayList<Currency>>) {
                currencyList.value = response.body()
            }
        })
    }

    fun loadCashlessCurrencies() {
        val service = RetrofitService().getService()
        service?.getCashlessCurrencies()?.enqueue(object: Callback<ArrayList<Currency>> {
            override fun onFailure(call: Call<ArrayList<Currency>>, t: Throwable) {
                Log.d("PRIVAT24_CURRENCY", t.localizedMessage)
            }

            override fun onResponse(
                    call: Call<ArrayList<Currency>>,
                    response: Response<ArrayList<Currency>>) {
                currencyList.value = response.body()
            }
        })
    }
}