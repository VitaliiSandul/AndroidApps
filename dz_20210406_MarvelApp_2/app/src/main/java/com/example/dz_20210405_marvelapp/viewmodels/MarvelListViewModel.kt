package com.example.dz_20210405_marvelapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dz_20210405_marvelapp.api.RetrofitService
import com.example.dz_20210405_marvelapp.api.SizeAndArrayCharacters
import com.example.dz_20210405_marvelapp.models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarvelListViewModel : ViewModel() {
    var charactersList = MutableLiveData<ArrayList<Character>>()
    var totalHeros = 0

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        val service = RetrofitService()
            .getInstance()?.getCharacters()?.enqueue(object: Callback<SizeAndArrayCharacters> {
                override fun onFailure(call: Call<SizeAndArrayCharacters>, t: Throwable) {
                    Log.d("MARVEL", t.localizedMessage)
                }
                override fun onResponse(
                        call: Call<SizeAndArrayCharacters>,
                        response: Response<SizeAndArrayCharacters>
                ) {
                    charactersList.value = response.body()?.getListCharacters()
                    totalHeros = response.body()?.getSize()!!
                }
            })
    }


    fun loadCharactersOffset(offset: Int) {
        val service = RetrofitService()
                .getInstance()?.getCharactersOffset(offset)?.enqueue(object: Callback<SizeAndArrayCharacters> {
                    override fun onFailure(call: Call<SizeAndArrayCharacters>, t: Throwable) {
                        Log.d("MARVEL", t.localizedMessage)
                    }
                    override fun onResponse(
                            call: Call<SizeAndArrayCharacters>,
                            response: Response<SizeAndArrayCharacters>
                    ) {
                        charactersList.value = response.body()?.getListCharacters()
                    }
                })
    }
}