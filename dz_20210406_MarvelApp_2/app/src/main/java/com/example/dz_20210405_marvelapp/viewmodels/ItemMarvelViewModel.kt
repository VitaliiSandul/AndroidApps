package com.example.dz_20210405_marvelapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dz_20210405_marvelapp.api.RetrofitService
import com.example.dz_20210405_marvelapp.extensions.default
import com.example.dz_20210405_marvelapp.models.Comic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemMarvelViewModel() : ViewModel() {
    var comicsList = MutableLiveData<ArrayList<Comic>>()
    var comicsListSize = MutableLiveData<Int>().default(0)

    fun loadComicsByCharacterId(characterId: String) {
        val serviceComic = RetrofitService()
            .getInstanceComic()?.getComics(characterId)?.enqueue(object: Callback<ArrayList<Comic>> {
                override fun onFailure(call: Call<ArrayList<Comic>>, t: Throwable) {
                    Log.d("MARVEL", t.localizedMessage)
                }
                override fun onResponse(
                    call: Call<ArrayList<Comic>>,
                    response: Response<ArrayList<Comic>>
                ) {
                    comicsList.value = response.body()
                    comicsListSize.value = response.body()!!.size
                    Log.d("comicsListSize", comicsListSize.toString())

                }
            })
    }
}