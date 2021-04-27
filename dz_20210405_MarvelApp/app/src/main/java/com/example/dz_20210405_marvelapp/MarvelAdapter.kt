package com.example.dz_20210405_marvelapp

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MarvelAdapter(val items: ArrayList<Character>)
    : RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>() {


    class MarvelViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val itemName : TextView = view.findViewById(R.id.itemName)
        val itemImage : ImageView = view.findViewById(R.id.itemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.marvel_item, parent, false)
        return MarvelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.itemName.text = items[position].name
        Picasso.get().load(Uri.parse(items[position].imagePath))
                .into(holder.itemImage)
    }
}