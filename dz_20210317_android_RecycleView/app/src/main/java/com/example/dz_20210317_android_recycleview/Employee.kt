package com.example.dz_20210317_android_recycleview

import android.graphics.drawable.Drawable

sealed class Model

data class Employee(
    var fullName: String,
    var position: String,
    var accessLevel: String,
    var photo: Drawable?,
    var resume: String):Model()