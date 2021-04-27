package com.example.dz_20210407_android_room_notes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("select * from note")
    fun getAll() : List<Note>

    @Query("select * from note where nid in (:noteIds)")
    fun loadAllByIds(noteIds: IntArray) : List<Note>

    @Query("select * from note where title like :appTitle and " +
            "description like :appDescription limit 1")
    fun findByTitle(appTitle: String, appDescription: String) : Note

    @Insert
    fun insertAll(vararg notes: Note)

    @Delete
    fun delete(note: Note)

}