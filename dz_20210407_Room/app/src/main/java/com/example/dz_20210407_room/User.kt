package com.example.dz_20210407_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name="first_name") val firstName: String?,
    @ColumnInfo(name="last_name") val lastName: String?
)