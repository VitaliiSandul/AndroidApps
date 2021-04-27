package com.example.dz_20210318_recyclerview_gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(private val items: List<Model>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  if (viewType == 1) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.type_a_item, parent, false)
            TypeAViewHolder(view)
        } else if (viewType == 2) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.type_b_item, parent, false)
            TypeBViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.type_c_item, parent, false)
            TypeCViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TypeAViewHolder) {
            val item = items[position] as TypeAModel
            holder.image1.setImageDrawable(item.picture1.image)
            holder.txtDate1.text = item.picture1.date.toString()
            holder.txtTitle1.text = item.picture1.title
        } else if (holder is TypeBViewHolder) {
            val item = items[position] as TypeBModel
            holder.image1.setImageDrawable(item.picture1.image)
            holder.txtDate1.text = item.picture1.date.toString()
            holder.txtTitle1.text = item.picture1.title
            holder.image2.setImageDrawable(item.picture2.image)
            holder.txtDate2.text = item.picture2.date.toString()
            holder.txtTitle2.text = item.picture2.title
        } else if (holder is TypeCViewHolder) {
            val item = items[position] as TypeCModel
            holder.image1.setImageDrawable(item.picture1.image)
            holder.txtDate1.text = item.picture1.date.toString()
            holder.txtTitle1.text = item.picture1.title
            holder.image2.setImageDrawable(item.picture2.image)
            holder.txtDate2.text = item.picture2.date.toString()
            holder.txtTitle2.text = item.picture2.title
            holder.image3.setImageDrawable(item.picture3.image)
            holder.txtDate3.text = item.picture3.date.toString()
            holder.txtTitle3.text = item.picture3.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is TypeAModel -> 1
            is TypeBModel -> 2
            is TypeCModel -> 3
        }
    }

    class TypeAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image1: ImageView = itemView.findViewById(R.id.image1)
        val txtDate1: TextView = itemView.findViewById(R.id.txtDate1)
        val txtTitle1: TextView = itemView.findViewById(R.id.txtTitle1)
    }

    class TypeBViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image1: ImageView = itemView.findViewById(R.id.image1)
        val txtDate1: TextView = itemView.findViewById(R.id.txtDate1)
        val txtTitle1: TextView = itemView.findViewById(R.id.txtTitle1)
        val image2: ImageView = itemView.findViewById(R.id.image2)
        val txtDate2: TextView = itemView.findViewById(R.id.txtDate2)
        val txtTitle2: TextView = itemView.findViewById(R.id.txtTitle2)
    }

    class TypeCViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image1: ImageView = itemView.findViewById(R.id.image1)
        val txtDate1: TextView = itemView.findViewById(R.id.txtDate1)
        val txtTitle1: TextView = itemView.findViewById(R.id.txtTitle1)
        val image2: ImageView = itemView.findViewById(R.id.image2)
        val txtDate2: TextView = itemView.findViewById(R.id.txtDate2)
        val txtTitle2: TextView = itemView.findViewById(R.id.txtTitle2)
        val image3: ImageView = itemView.findViewById(R.id.image3)
        val txtDate3: TextView = itemView.findViewById(R.id.txtDate3)
        val txtTitle3: TextView = itemView.findViewById(R.id.txtTitle3)
    }

}