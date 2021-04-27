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
import com.squareup.picasso.Picasso

class MarvelAdapter(val items: ArrayList<Character>)
    : RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>() {

    class MarvelViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val itemId : TextView = view.findViewById(R.id.itemId)
        val itemName : TextView = view.findViewById(R.id.itemName)
        val itemImage : ImageView = view.findViewById(R.id.itemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.marvel_item, parent, false)

        var holder = MarvelViewHolder(view)

        view.setOnClickListener {
            Toast.makeText(parent.context, "${view.findViewById<TextView>(R.id.itemName).text} ${view.findViewById<TextView>(R.id.itemId).text}", Toast.LENGTH_LONG).show()

            Log.d("-----", "RecyclerView Click")

            val itemId = view.findViewById<TextView>(R.id.itemId).text
            val itemName = view.findViewById<TextView>(R.id.itemName).text

            val pos = holder.getAdapterPosition()
            val itemUrl: String = items[pos].imagePath

            val bundle = bundleOf("itemId" to itemId, "itemName" to itemName, "itemUrl" to itemUrl)
            it.findNavController().navigate(R.id.action_marvelListFragment_to_itemMarvelFragment, bundle)
        }

        return holder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.itemId.text = items[position].id.toString()
        holder.itemName.text = items[position].name
        Picasso.get().load(Uri.parse(items[position].imagePath))
                .into(holder.itemImage)
    }
}