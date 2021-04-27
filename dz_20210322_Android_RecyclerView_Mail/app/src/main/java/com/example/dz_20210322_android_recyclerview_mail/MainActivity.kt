package com.example.dz_20210322_android_recyclerview_mail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

//    private val mailViewModel by lazy{
//        ViewModelProviders.of(this).get(MailViewModel::class.java)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rclMails = findViewById<RecyclerView>(R.id.rclMails)
        val adapter = MailAdapter(createRecyclerViewItems())
        rclMails.layoutManager = LinearLayoutManager(this)
        rclMails.adapter = adapter

//        mailViewModel.getMailList().observe(this, Observer {
//            it?.let{
//                adapter.getMailList(it)
//            }
//        })
    }

    private fun createRecyclerViewItems(): MutableList<Mail> {
        return mutableListOf<Mail>().apply {
            add(Mail("Sam", "Weekend adventure", "Let's go finish with Jhon and other.", "10:42am", false, false))
            add(Mail("Facebook", "James, you have 1 new notification", "a lot has happened on Facebook since", "16:04pm", false, false))
            add(Mail("Google+", "Top suggested Google+ pages for you", "Top suggested Google+ pages for yo", "18:44pm", false, false))
            add(Mail("Twitter", "Follow T-Mobile, Samsung Mobile U", "James, some people you make know", "20:04pm", false, false))
            add(Mail("Pinterest Weekly", "Pins you'll love!", "Have you seen these Pins yet? Pinterest", "09:04am", false, false))
            add(Mail("Josh", "Going lanch", "How are you doing?", "01:04am", false, false))
        }
    }

}