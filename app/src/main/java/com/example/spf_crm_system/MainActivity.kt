package com.example.spf_crm_system

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email=findViewById<EditText>(R.id.emailLogIn) as EditText
        val password=findViewById<EditText>(R.id.passwordLogIn) as EditText
        val LogInButton=findViewById<Button>(R.id.button) as Button

        mAuth = FirebaseAuth.getInstance();
        LogInButton.setOnClickListener {
            println(email.text.toString())
            println(password.text.toString())
            mAuth!!.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(
                    this
                ) { task: Task<AuthResult> ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        println("Signed In Successful")
                        val intent=Intent(this, ProductActivity::class.java)
                        startActivity(intent)

                        Toast.makeText(
                            this, "Signed In Successful",
                            Toast.LENGTH_SHORT
                        ).show()
                        Toast.makeText(this, "Signed In Successful", Toast.LENGTH_LONG).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        println("Authentication failed.")
                        Toast.makeText(
                            this, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
        }

        //FirebaseAuth.getInstance().signOut();

    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
        if(currentUser!=null){
            println("User is logged in.")
            Toast.makeText(
                this, "User is logged in.",
                Toast.LENGTH_SHORT
            ).show()
        }else{
            println("User is logged out.")
            Toast.makeText(
                this, "User is logged out.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}