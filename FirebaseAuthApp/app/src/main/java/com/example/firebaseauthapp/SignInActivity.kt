package com.example.firebaseauthapp

import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : BaseActivity(), OnCompleteListener<AuthResult> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        login_button.setOnClickListener {
            auth.signInWithEmailAndPassword(
                email_edit_text.text.toString(),
                password_edit_text.text.toString()
            ).addOnCompleteListener(this)
        }

        register_button.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                email_edit_text.text.toString(),
                password_edit_text.text.toString()
            ).addOnCompleteListener(this)
        }
    }

    override fun onComplete(task: Task<AuthResult>) {
        if (task.isSuccessful) {
            MainActivity.newInstance(this).let(::startActivity)

        } else {
            Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
        }
    }
}