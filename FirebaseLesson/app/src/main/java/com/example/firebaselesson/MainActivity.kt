package com.example.firebaselesson

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), TaskRowListener {

    lateinit var db: DatabaseReference
    lateinit var adapter: TaskListAdapter
    lateinit var taskList: MutableList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInfo.text = currentUser?.email

        db = FirebaseDatabase.getInstance().reference

        //FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        taskList = mutableListOf()

        adapter = TaskListAdapter(this, taskList)
        recyclerViewTask.layoutManager = LinearLayoutManager(this)
        recyclerViewTask.adapter = adapter


        var taskListener: ValueEventListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.w("MainActivity", "loadItem:onCancelled", error.toException())
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                loadTaskList(snapshot)
            }

        }

        db.orderByKey().addValueEventListener(taskListener)

        fab.setOnClickListener {
            showFooter()
        }
        btnAdd.setOnClickListener {
            addTask()
        }
    }

    fun loadTaskList(dataSnapshot: DataSnapshot) {
        val tasks = dataSnapshot.children.iterator()

        if (tasks.hasNext()) {
            taskList.clear()
            val listIndex = tasks.next()
            val itemsIterator = listIndex.children.iterator()

            while (itemsIterator.hasNext()) {

                val currentItem = itemsIterator.next()

                val map = currentItem.value as HashMap<String, Any>

                if(map["userId"] as String? == currentUser?.uid){
                    val task = Task.create()
                    task.taskId = currentItem.key
                    task.done = map["done"] as Boolean?
                    task.taskDesc = map["taskDesc"] as String?
                    task.userId = map["userId"] as String?
                    taskList.add(task)
                }

            }
        }

        adapter.notifyDataSetChanged()
    }

    fun addTask() {
        val task = Task.create()
        task.taskDesc = txtNewTaskDesc.text.toString()
        var newTaskRef = db.child(Statics.FIREBASE_TASK).push()
        task.taskId = newTaskRef.key
        newTaskRef.setValue(task)
        task.userId = currentUser?.uid

        footer.visibility = View.GONE
        fab.visibility = View.VISIBLE
        txtNewTaskDesc.setText("")
        Toast.makeText(this, "Task added successfully!", Toast.LENGTH_SHORT)
    }

    fun showFooter() {
        footer.visibility = View.VISIBLE
        fab.visibility = View.GONE
    }

    override fun onTaskChange(taskId: String, isDone: Boolean) {
        Log.d("AAAAA", taskId)
        db.child(Statics.FIREBASE_TASK).child(taskId).child("done").setValue(isDone)
    }

    override fun onDestroy() {
        super.onDestroy()
        FirebaseAuth.getInstance().signOut()
    }
    companion object {
        fun newInstance(context: Context) = Intent(context, MainActivity::class.java)
    }

}