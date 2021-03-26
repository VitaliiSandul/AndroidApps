package com.example.dz_20210322_mymail

import android.graphics.drawable.Drawable

sealed class Model

data class Mail (val sender: String,
                 val title: String,
                 val description: String,
                 val timeReceive: String,
                 var isRead: Boolean,
                 var isImportant: Boolean) : Model()