package com.example.dz_20210315_android_databinding_likes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    private val _name = MutableLiveData("Vitalii")
    private val _lastName = MutableLiveData("Sandul")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }

    val popularity: LiveData<Popularity> = Transformations.map(_likes) { likes ->
        when {
            likes > 9 -> Popularity.STAR
            likes > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}