package com.example.nammaplatform

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class CoachLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_coach_layout)

        val backButton = findViewById<ImageButton>(R.id.backButton)

        backButton.setOnClickListener {

            finish()
        }
    }
}