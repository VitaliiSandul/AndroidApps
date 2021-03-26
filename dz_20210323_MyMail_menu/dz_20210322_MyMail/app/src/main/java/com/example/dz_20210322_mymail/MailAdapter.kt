package com.example.dz_20210322_mymail

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mail_item.view.*
import java.util.*

class MailAdapter(private var items: MutableList<Model>) :
    RecyclerView.Adapter<MailAdapter.MailHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mail_item, parent, false)
        return MailHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MailHolder, position: Int) {
        val item  = items[position] as Mail
        holder.bind(item)

        holder.itemView.cardItem.setOnClickListener{
            val pos = holder.adapterPosition
            val item  = items[pos] as Mail
            item.isRead = !item.isRead
            notifyDataSetChanged()
        }
        holder.itemView.imageImportant.setOnClickListener{
            val curPos = holder.adapterPosition
            val item  = items[curPos] as Mail
            item.isImportant = !item.isImportant
            notifyDataSetChanged()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is Mail -> 1
        }
    }

    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun changeToUnread(position: Int) {
        val item = items[position] as Mail
        item.isRead = false
        notifyItemChanged(position)
    }

    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition..toPosition) {
                Collections.swap(items, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition) {
                Collections.swap(items, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    fun removeAll() {
        items.clear()
        notifyDataSetChanged()
    }

    fun readAll(){
        items.forEach {
            it as Mail
            it.isRead = true
        }
        notifyItemRangeChanged(0, getItemCount())
    }

    fun unreadAll(){
        items.forEach {
            it as Mail
            it.isRead = false
        }
        notifyDataSetChanged()
    }

    class MailHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(mail: Mail) = with(itemView){

            val color = getAssociatedColor(mail.sender, imageSender.context)
            ImageViewCompat.setImageTintList(imageSender, ColorStateList.valueOf(color))

            firstLetter.text = mail.sender.toUpperCase()[0].toString()
            txtSender.text = mail.sender
            txtTitle.text = mail.title
            txtDescription.text = mail.description
            txtTimeReceive.text = mail.timeReceive

            if(mail.isRead){
                txtSender.setTypeface(txtSender.getTypeface(), Typeface.NORMAL)
                txtTitle.setTypeface(txtTitle.getTypeface(), Typeface.NORMAL)
            }
            else{
                txtSender.setTypeface(txtSender.getTypeface(), Typeface.BOLD)
                txtTitle.setTypeface(txtTitle.getTypeface(), Typeface.BOLD)
            }

            imageImportant.setImageDrawable(getDrawableImportant(mail.isImportant, imageImportant.context))
        }

        private fun getAssociatedColor(sender: String, context: Context?): Int {
            if (context != null) {
                context.theme.obtainStyledAttributes(intArrayOf(android.R.attr.colorForeground)).getColor(0, 0x000000)
            }
            return when (sender.toUpperCase()[0].toString()) {
                "S" -> ContextCompat.getColor(context!!, R.color.color1)
                "F" -> ContextCompat.getColor(context!!, R.color.color2)
                "G" -> ContextCompat.getColor(context!!, R.color.color3)
                "T" -> ContextCompat.getColor(context!!, R.color.color4)
                "P" -> ContextCompat.getColor(context!!, R.color.color5)
                "J" -> ContextCompat.getColor(context!!, R.color.color6)
                else -> ContextCompat.getColor(context!!, R.color.color1)
            }
        }

        private fun getDrawableImportant(isImportant: Boolean, context: Context): Drawable? {
            return when (isImportant) {
                true -> {
                    ContextCompat.getDrawable(context, R.drawable.yellow_star)
                }
                false -> {
                    ContextCompat.getDrawable(context, R.drawable.black_star)
                }
            }
        }
    }

}