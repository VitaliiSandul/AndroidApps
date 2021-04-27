package com.example.dz_20210405_marvelapp.api

import com.example.dz_20210405_marvelapp.models.Comic
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {
    @GET("characters")
    fun getCharacters() : Call<SizeAndArrayCharacters>

    @GET("characters")
    fun getCharactersSize() : Call<Int>

    @GET("characters")
    fun getCharactersOffset(@Query("offset") offset: Int): Call<SizeAndArrayCharacters>


    @GET("characters/{characterId}/comics")
    fun getComics(@Path("characterId") characterId: String) : Call<ArrayList<Comic>>


}