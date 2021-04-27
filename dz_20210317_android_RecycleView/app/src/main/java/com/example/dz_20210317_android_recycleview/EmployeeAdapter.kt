package com.example.dz_20210317_android_recycleview

import android.R.attr.thumbnail
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.ByteArrayOutputStream


class EmployeeAdapter (private val employees: List<Employee>) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {


    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtFio = itemView.findViewById(R.id.txtFio) as TextView
        val txtPosition = itemView.findViewById(R.id.txtPosition) as TextView
        val txtAccess = itemView.findViewById(R.id.txtAccess) as TextView
        val empPhoto = itemView.findViewById(R.id.empPhoto) as ImageView
        var empResume = itemView.findViewById(R.id.empResume) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.employee_item, parent, false)

        view.setOnClickListener { v ->
            val fullName = v.findViewById<TextView>(R.id.txtFio).text
            val pos = v.findViewById<TextView>(R.id.txtPosition).text
            val access = v.findViewById<TextView>(R.id.txtAccess).text

            val photo= v.findViewById<ImageView>(R.id.empPhoto)
            val resume = v.findViewById<TextView>(R.id.empResume).text

            val intent = Intent(parent.context, MainActivityCurEmployee::class.java)
            intent.putExtra("FULLNAME", fullName)
            intent.putExtra("POSITION", pos)
            intent.putExtra("ACCESS", access)

            val bmp = (photo.getDrawable() as BitmapDrawable).bitmap
            val stream = ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()
            intent.putExtra("IMAGE", byteArray)

            intent.putExtra("RESUME", resume)

            parent.context.startActivity(intent)

        }

        return EmployeeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val element = employees[position]
        holder.txtFio.text = element.fullName
        holder.txtPosition.text = element.position
        holder.txtAccess.text = element.accessLevel
        holder.empPhoto.setImageDrawable(element.photo)
        holder.empResume.text = element.resume
    }


}