package com.example.nammaplatform

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class AudioAssistantActivity : AppCompatActivity(),
    TextToSpeech.OnInitListener {

    private lateinit var textToSpeech: TextToSpeech

    private var isTtsReady = false

    private var announcementText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_audio_assistant)

        // Receive Data

        announcementText =
            intent.getStringExtra("announcement")
                ?: ""

        val trainName =
            intent.getStringExtra("train_name")
                ?: "ರೈಲು"

        // Views

        val trainTitle =
            findViewById<TextView>(R.id.trainTitle)

        val speakButton =
            findViewById<Button>(R.id.speakButton)

        trainTitle.text = trainName

        // Initialize ONLY ONCE

        textToSpeech =
            TextToSpeech(this, this)

        // Speak Button

        speakButton.setOnClickListener {

            if (!isTtsReady) {

                Toast.makeText(
                    this,
                    "Voice loading...",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (announcementText.isNotEmpty()) {

                textToSpeech.speak(
                    announcementText,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    "train_announcement"
                )

            } else {

                Toast.makeText(
                    this,
                    "Announcement Empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // TTS Ready

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {

            val result =
                textToSpeech.setLanguage(
                    Locale("en", "IN")
                )

            if (
                result != TextToSpeech.LANG_MISSING_DATA &&
                result != TextToSpeech.LANG_NOT_SUPPORTED
            ) {

                isTtsReady = true

            } else {

                Toast.makeText(
                    this,
                    "Speech not supported",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroy() {

        textToSpeech.stop()
        textToSpeech.shutdown()

        super.onDestroy()
    }
}