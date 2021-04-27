package com.example.dz_20210405_marvelapp.api

import com.example.dz_20210405_marvelapp.models.Character

class SizeAndArrayCharacters(private var size: Int?, private var listCharacters: ArrayList<Character>) {
    fun getSize() = size
    fun getListCharacters() = listCharacters
}

