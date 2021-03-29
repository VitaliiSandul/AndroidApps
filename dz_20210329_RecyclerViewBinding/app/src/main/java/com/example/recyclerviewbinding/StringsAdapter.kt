package com.example.recyclerviewbinding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbinding.databinding.StringItemBinding

class StringsAdapter(val items: ArrayList<String>) :
    RecyclerView.Adapter<StringsAdapter.StringViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var binding  = StringItemBinding.inflate(layoutInflater, parent, false)
        return StringViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class StringViewHolder(private val binding: StringItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String) {
            binding.stringValue = text
            binding.click = object: StringItemClickListener {

                override fun onClick(stringValue: String) {
                    Toast.makeText(binding.root.context, stringValue, Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}