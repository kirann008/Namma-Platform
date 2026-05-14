package com.example.nammaplatform

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class StationSelectionActivity : AppCompatActivity() {

    private var isFirstSelection = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_station_selection)

        // Back Button

        val backButton =
            findViewById<ImageButton>(R.id.backButton)

        backButton.setOnClickListener {

            finish()
        }

        // Spinner

        val stationSpinner =
            findViewById<Spinner>(R.id.stationSpinner)

        // Station List

        val stations = arrayOf(

            "Select Station",

            "ಬೆಂಗಳೂರು",
            "ಮೈಸೂರು",
            "ಹುಬ್ಬಳ್ಳಿ",
            "ಶಿವಮೊಗ್ಗ",
            "ಮಂಗಳೂರು",
            "ಕಾರವಾರ"
        )

        // Adapter

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            stations
        )

        stationSpinner.adapter = adapter

        // Selection Listener

        stationSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    // Ignore first automatic selection

                    if (isFirstSelection) {

                        isFirstSelection = false
                        return
                    }

                    // Ignore "Select Station"

                    if (position == 0) {

                        return
                    }

                    val selectedStation =
                        stations[position]

                    val intent = Intent(
                        this@StationSelectionActivity,
                        DashboardActivity::class.java
                    )

                    intent.putExtra(
                        "station_name",
                        selectedStation
                    )

                    startActivity(intent)
                }

                override fun onNothingSelected(
                    parent: AdapterView<*>?
                ) {

                }
            }
    }
}