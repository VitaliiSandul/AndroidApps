package com.example.dz_20210318_recyclerview_gallery

import android.graphics.drawable.Drawable
import java.time.LocalDate

sealed class Model

class Picture(val image: Drawable, val date: LocalDate, val title: String)

data class TypeAModel(val picture1: Picture) : Model()

data class TypeBModel(val picture1: Picture, val picture2: Picture) : Model()

data class TypeCModel(val picture1: Picture, val picture2: Picture, val picture3: Picture) : Model()