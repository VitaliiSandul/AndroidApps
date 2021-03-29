package com.example.recyclerviewbinding

import androidx.lifecycle.ViewModel

class StringsViewModel : ViewModel() {
    var strings = arrayListOf<String>("Hello", "my", "world")
}