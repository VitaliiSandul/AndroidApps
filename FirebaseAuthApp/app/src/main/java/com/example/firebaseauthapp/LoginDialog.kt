package com.example.firebaseauthapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.dialog_login.*

class LoginDialog : DialogFragment(), OnCompleteListener<AuthResult>{
    protected lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.round_corner)
        return inflater.inflate(R.layout.dialog_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                editTextLogin.text.toString(),
                editTextPassword.text.toString()
            ).addOnCompleteListener(this)
        }
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onComplete(task: Task<AuthResult>) {
        if (task.isSuccessful) {
            val intent = Intent(context, MainActivity::class.java)
            context!!.startActivity(intent)
            Log.d("Login", "Start Activity")
        } else {
            Log.d("Login", "Unsuccessfull")
        }
    }
}
