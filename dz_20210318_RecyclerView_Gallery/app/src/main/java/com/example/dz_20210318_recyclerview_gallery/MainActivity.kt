package com.example.dz_20210318_recyclerview_gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rclGallery = findViewById<RecyclerView>(R.id.rclGallery)
        val adapter = GalleryAdapter(createRecyclerViewItems())
        rclGallery.layoutManager = LinearLayoutManager(this)
        rclGallery.adapter = adapter

    }

    private fun createRecyclerViewItems(): List<Model> {
        return mutableListOf<Model>().apply {
            add(TypeAModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture1)!!, LocalDate.of(2018, 12, 31), "Picture 1")))
            add(TypeBModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture2)!!, LocalDate.of(2019, 10, 25), "Picture 2"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture3)!!, LocalDate.of(2020, 11, 17), "Picture 3")))
            add(TypeCModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture4)!!, LocalDate.of(2019, 10, 25), "Picture 4"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture5)!!, LocalDate.of(2020, 5, 10), "Picture 5"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture6)!!, LocalDate.of(2020, 1, 3), "Picture 6")))

            add(TypeAModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture7)!!, LocalDate.of(2018, 12, 31), "Picture 7")))
            add(TypeBModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture8)!!, LocalDate.of(2019, 10, 25), "Picture 8"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture9)!!, LocalDate.of(2020, 11, 17), "Picture 9")))
            add(TypeCModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture10)!!, LocalDate.of(2019, 10, 25), "Picture 10"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture11)!!, LocalDate.of(2020, 5, 10), "Picture 11"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture12)!!, LocalDate.of(2020, 1, 3), "Picture 12")))

            add(TypeAModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture13)!!, LocalDate.of(2018, 12, 31), "Picture 13")))
            add(TypeBModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture14)!!, LocalDate.of(2019, 10, 25), "Picture 14"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture15)!!, LocalDate.of(2020, 11, 17), "Picture 15")))
            add(TypeCModel(Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture16)!!, LocalDate.of(2019, 10, 25), "Picture 16"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture17)!!, LocalDate.of(2020, 5, 10), "Picture 17"),
                           Picture(ContextCompat.getDrawable(this@MainActivity, R.drawable.picture18)!!, LocalDate.of(2020, 1, 3), "Picture 18")))

        }
    }

}