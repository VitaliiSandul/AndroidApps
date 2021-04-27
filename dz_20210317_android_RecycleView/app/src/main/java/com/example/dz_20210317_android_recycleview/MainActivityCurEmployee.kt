package com.example.dz_20210317_android_recycleview

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivityCurEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cur_employee)

        val curFio = intent.getStringExtra("FULLNAME")
        val curPosition = intent.getStringExtra("POSITION")
        val curAccess = intent.getStringExtra("ACCESS")

        val byteArray = intent.getByteArrayExtra("IMAGE")
        val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)

        val curResume = intent.getStringExtra("RESUME")

        findViewById<TextView>(R.id.curFio).text = curFio
        findViewById<TextView>(R.id.curPosition).text = curPosition
        findViewById<TextView>(R.id.curAccess).text = curAccess
        findViewById<ImageView>(R.id.curPhoto).setImageBitmap(bmp)
        findViewById<TextView>(R.id.curResume).text = curResume

        findViewById<Button>(R.id.button).setOnClickListener {
            finish()
        }

    }
}