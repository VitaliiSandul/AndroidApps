package com.example.dz_20210405_marvelapp.adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_20210405_marvelapp.R
import com.example.dz_20210405_marvelapp.models.Character
import com.example.dz_20210405_marvelapp.models.Comic
import com.squareup.picasso.Picasso

class ComicAdapter(val items: ArrayList<Comic>)
    : RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    class ComicViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val comicTitle : TextView = view.findViewById(R.id.comicTitle)
        val comicDescription : TextView = view.findViewById(R.id.comicDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comic_item, parent, false)

        return ComicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.comicTitle.text = items[position].title.toString()
        holder.comicDescription.text = items[position].description
    }
}