package com.example.dz_20210322_android_recyclerview_mail

import android.graphics.drawable.Drawable
import java.time.LocalDate

class Mail (val sender: String,
            val title: String,
            val description: String,
            val timeReceive: String,
            val isRead: Boolean,
            val isImportant: Boolean)