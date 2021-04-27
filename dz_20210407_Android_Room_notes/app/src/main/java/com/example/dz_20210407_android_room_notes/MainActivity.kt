package com.example.dz_20210407_android_room_notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private lateinit var noteDao: NoteDao
    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext,
                                                    AppDatabase::class.java, "notesDB.db").build()
        noteDao = db.noteDao()

        val noteRecyclerView : RecyclerView = findViewById(R.id.noteRecyclerView)
        noteRecyclerView.layoutManager = LinearLayoutManager(this)

        doAsync {

           var notes =  noteDao.getAll() as ArrayList<Note>

            uiThread {
                noteAdapter = NoteAdapter(notes)
                noteRecyclerView.adapter = noteAdapter
                noteRecyclerView.adapter?.notifyDataSetChanged()
            }
        }

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            doAsync {
                val addNoteTitle: EditText = findViewById(R.id.addNoteTitle)
                val addNoteDescription: EditText = findViewById(R.id.addNoteDescription)

                noteDao.insertAll(Note(null,addNoteTitle.text.toString(), addNoteDescription.text.toString()))

                uiThread {
                    noteAdapter.addNewNote(Note(null,addNoteTitle.text.toString(), addNoteDescription.text.toString()))
                    noteRecyclerView.adapter?.notifyDataSetChanged()
                }
            }

        }
    }

}