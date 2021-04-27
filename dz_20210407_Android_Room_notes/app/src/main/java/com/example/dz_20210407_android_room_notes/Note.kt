package com.example.dz_20210407_android_room_notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
    @PrimaryKey(autoGenerate = true) val nid: Int? = null,
    @ColumnInfo(name="title") val appTitle: String?,
    @ColumnInfo(name="description") val appDescription: String?
)