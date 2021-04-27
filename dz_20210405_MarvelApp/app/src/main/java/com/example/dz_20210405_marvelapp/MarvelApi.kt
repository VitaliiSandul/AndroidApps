package com.example.dz_20210405_marvelapp

import retrofit2.Call
import retrofit2.http.GET

interface MarvelApi {
    @GET("characters")
    fun getCharacters() : Call<ArrayList<Character>>
}