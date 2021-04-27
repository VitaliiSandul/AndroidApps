package com.example.dz_20210317_android_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rclEmployees = findViewById<RecyclerView>(R.id.rclEmployees)
        val adapter = EmployeeAdapter(createRecyclerViewItems())
        rclEmployees.layoutManager = LinearLayoutManager(this)
        rclEmployees.adapter = adapter
    }

    private fun createRecyclerViewItems(): List<Employee> {
        return mutableListOf<Employee>().apply {
            add(Employee("Bozhenko Arseniy Vitaliyovych", "Team Lead", "High", ContextCompat.getDrawable(this@MainActivity, R.drawable.user1)!!, getString(R.string.resume1)))
            add(Employee("Sandul Vitaly Nikolaevich", "Team Lead", "High", ContextCompat.getDrawable(this@MainActivity, R.drawable.user2)!!, getString(R.string.resume2)))
            add(Employee("Yarosh Sergey Sergeevich", "Team Lead", "High", ContextCompat.getDrawable(this@MainActivity, R.drawable.user3)!!, getString(R.string.resume3)))
            add(Employee("Mukharovsky Alexey Vitalyevich", "Software Engineer", "Medium", ContextCompat.getDrawable(this@MainActivity, R.drawable.user4)!!, getString(R.string.resume4)))
            add(Employee("Khomich Danilo Romanovich", "QA Engineer", "Medium", ContextCompat.getDrawable(this@MainActivity, R.drawable.user5)!!, getString(R.string.resume5)))
            add(Employee("Pospishniy Igor Vladimirovich", "Software Engineer", "High", ContextCompat.getDrawable(this@MainActivity, R.drawable.user6)!!, getString(R.string.resume6)))
            add(Employee("Petrenko Stepan Stepanovich", "Trainee", "Low", ContextCompat.getDrawable(this@MainActivity, R.drawable.user7)!!, getString(R.string.resume7)))
            add(Employee("Gaidai Dmitry Romanovich", "QA Engineer", "Medium", ContextCompat.getDrawable(this@MainActivity, R.drawable.user8)!!, getString(R.string.resume8)))
            add(Employee("Rakhimov Ramazan Kilichhuzha", "Trainee", "Low", ContextCompat.getDrawable(this@MainActivity, R.drawable.user9)!!, getString(R.string.resume9)))

        }
    }
}