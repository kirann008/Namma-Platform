package com.example.nammaplatform

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {

            startActivity(
                Intent(this, DashboardActivity::class.java)
            )

            finish()
        }
    }
}