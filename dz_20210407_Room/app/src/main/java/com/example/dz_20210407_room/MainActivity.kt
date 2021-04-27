package com.example.dz_20210407_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext,
                                                    AppDatabase::class.java, "usersDB3.db").build()
        userDao = db.userDao()

//        GlobalScope.launch {
//            userDao.insertAll(User(null,"alex", "klar"))
//            userDao.getAll().forEach{
//                Log.d("RRRRR", it.firstName.toString())
//            }
//
//        }



        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            doAsync {
                userDao.insertAll(User(null,"felix", "klar"))
                val name = userDao.getAll()[1].firstName

                uiThread {
                    val textView: TextView = findViewById(R.id.textView)
                    textView.text = name
                }
            }

        }


    }
}