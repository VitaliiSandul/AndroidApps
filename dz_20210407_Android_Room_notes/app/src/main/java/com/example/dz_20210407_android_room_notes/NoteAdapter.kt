package com.example.dz_20210407_android_room_notes

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(val items: ArrayList<Note>)
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle : TextView = view.findViewById(R.id.itemTitle)
        val itemDescription : TextView = view.findViewById(R.id.itemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemTitle.text = items[position].appTitle
        holder.itemDescription.text = items[position].appDescription
    }

    fun addNewNote(note: Note){
        items.add(note)
    }
}