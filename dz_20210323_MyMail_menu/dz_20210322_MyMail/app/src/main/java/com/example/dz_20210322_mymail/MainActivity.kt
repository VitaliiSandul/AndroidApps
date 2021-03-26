package com.example.dz_20210322_mymail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mail_item.view.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MailAdapter(createRecyclerViewItems())
        rclMails.layoutManager = LinearLayoutManager(this)
        rclMails.adapter = adapter

        val swipeHandler = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rclMails.adapter as MailAdapter

                if (direction == ItemTouchHelper.LEFT){
                    adapter.removeAt(viewHolder.adapterPosition)
                }
                else if(direction == ItemTouchHelper.RIGHT){
                    adapter.changeToUnread(viewHolder.adapterPosition)
                }
            }

            override fun onMove(recyclerView: RecyclerView,
                                viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean {
                val adapter = rclMails.adapter as MailAdapter
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                adapter.onItemMove(fromPosition, toPosition)
                return true
            }

        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rclMails)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val adapter = rclMails.adapter as MailAdapter

        when(item.itemId){
            R.id.action_clear -> adapter.removeAll()
            R.id.action_read -> adapter.readAll()
            R.id.action_unread -> adapter.unreadAll()
            else -> false

        }
        return super.onOptionsItemSelected(item)
    }

    private fun createRecyclerViewItems(): MutableList<Model> {
        return mutableListOf<Model>().apply {
            add(Mail("Sam", "Weekend adventure", "Let's go finish with Jhon and other.", "10:42am", false, true))
            add(Mail("Facebook", "James, you have 1 new notification", "a lot has happened on Facebook since", "16:04pm", false, false))
            add(Mail("Google+", "Top suggested Google+ pages for you", "Top suggested Google+ pages for yo", "18:44pm", true, true))
            add(Mail("Twitter", "Follow T-Mobile, Samsung Mobile U", "James, some people you make know", "20:04pm", false, false))
            add(Mail("Pinterest Weekly", "Pins you'll love!", "Have you seen these Pins yet? Pinterest", "09:04am", true, false))
            add(Mail("Josh", "Going lanch", "How are you doing?", "01:04am", false, true))
        }
    }

}