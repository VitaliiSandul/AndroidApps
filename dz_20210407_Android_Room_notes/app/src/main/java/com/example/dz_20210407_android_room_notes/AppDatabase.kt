package com.example.dz_20210407_android_room_notes

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}