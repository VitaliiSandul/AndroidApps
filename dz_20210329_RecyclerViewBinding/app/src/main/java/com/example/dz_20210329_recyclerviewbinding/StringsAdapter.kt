package com.example.dz_20210329_recyclerviewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_20210329_recyclerviewbinding.databinding.StringItemBinding

class StringsAdapter(private val items: MutableList<String>):
    RecyclerView.Adapter<StringsAdapter.StringViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var binding = StringItemBinding.inflate(layoutInflater, parent, false)
        return StringViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun removeAll() {
        items.clear()
        notifyDataSetChanged()
    }

    fun addRandom(){
        val randNum = (0..10).random()
        items.add(randNum.toString())
        notifyDataSetChanged()
    }

    class StringViewHolder(private val binding: StringItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(text: String){
            binding.stringValue = text
            binding.click = object: StringItemClickListener{
                override fun onClick(stringValue: String) {
                    if(stringValue.toIntOrNull() != null){
                        binding.stringValue = (stringValue.toInt()*2).toString()
                    }
                }
            }
        }
    }

}