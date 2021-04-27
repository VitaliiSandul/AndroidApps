package com.example.dz_20210322_android_recyclerview_mail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mail_item.view.*

class MailAdapter (private var items: List<Mail>) : RecyclerView.Adapter<MailAdapter.MailHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.mail_item, parent, false)
        return MailHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MailHolder, position: Int) {
        holder.bind(items[position])
    }

    fun getMailList(mails: List<Mail>){
        this.items = mails
        notifyDataSetChanged()
    }

    class MailHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(mail: Mail) = with(itemView){
            imageSender.setImageDrawable(getResources().getDrawable(R.drawable.circle_black_48dp))
            firstLetter.text = mail.sender.toUpperCase()[0].toString()
            txtSender.text = mail.sender
            txtTitle.text = mail.title
            txtDescription.text = mail.description
            txtTimeReceive.text = mail.timeReceive
        }
    }


}