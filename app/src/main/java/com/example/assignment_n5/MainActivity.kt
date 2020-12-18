package com.example.assignment_n5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

    class MainActivity : AppCompatActivity() {
        private lateinit var submitEmailEditText: EditText
        private lateinit var submitPasswordEditText: EditText
        private lateinit var submitButton: Button
        private lateinit var mAuth: FirebaseAuth

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            mAuth = FirebaseAuth.getInstance()

            submitEmailEditText = findViewById(R.id.submitEmailEditText)
            submitPasswordEditText = findViewById((R.id.submitPasswordEditText))
            submitButton = findViewById(R.id.submitButton)

            submitButton.setOnClickListener {
                val email = submitEmailEditText.text.toString()
                val password = submitPasswordEditText.text.toString()

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "მონაცემების შეყვანა აუცილებელია", Toast.LENGTH_LONG).show()
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "მომხმარებელი წარმატებულად დაემატა", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }
    }