package com.example.firebaseauthapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase

class TaskListAdapter(val context: Context, val taskList: MutableList<Task>) : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    class TaskViewHolder(row: View): RecyclerView.ViewHolder(row) {
        val desc: TextView = row.findViewById(R.id.txtTaskDesc)
        val done: CheckBox = row.findViewById(R.id.chkDone)
        val remove: ImageButton = row.findViewById(R.id.btnRemove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.task_row, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.done.isChecked = taskList[position].done ?: false
        holder.desc.text = taskList[position].taskDesc
        holder.done.setOnClickListener {
            (context as TaskRowListener).onTaskChange(
                taskList[position].taskId!!,
                holder.done.isChecked
            )
        }

        holder.remove.setOnClickListener(View.OnClickListener {
            val rowRemoveRef = FirebaseDatabase.getInstance().reference.child(Statics.FIREBASE_TASK).child(taskList[position].taskId.toString())
            rowRemoveRef.removeValue()
        })
    }
}