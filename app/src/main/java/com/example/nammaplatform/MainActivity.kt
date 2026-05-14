package com.example.nammaplatform

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Open Dashboard Directly

        startActivity(
            Intent(
                this,
                DashboardActivity::class.java
            )
        )

        finish()
    }
}