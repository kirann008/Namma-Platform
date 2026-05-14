package com.example.nammaplatform

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        // Selected Station

        val stationName =
            intent.getStringExtra("station_name")

        // Station Title

        val stationTitle =
            findViewById<TextView>(R.id.selectedStationText)

        stationTitle.text =
            "Selected Station: $stationName"

        // RecyclerView

        val recyclerView =
            findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        // Dynamic Train List

        val trainList = when (stationName) {

            // Mysuru

            "ಮೈಸೂರು" -> listOf(

                TrainBoard(
                    "Mysuru Express",
                    "ಮೈಸೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೨",
                    "10:30 AM",
                    "ಮೈಸೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೨ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                ),

                TrainBoard(
                    "Chamundi Express",
                    "ಚಾಮುಂಡಿ ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೧",
                    "11:15 AM",
                    "ಚಾಮುಂಡಿ ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೧ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                )
            )

            // Shivamogga

            "ಶಿವಮೊಗ್ಗ" -> listOf(

                TrainBoard(
                    "Shivamogga Express",
                    "ಶಿವಮೊಗ್ಗ ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೪",
                    "09:45 AM",
                    "ಶಿವಮೊಗ್ಗ ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೪ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                ),

                TrainBoard(
                    "Malnad Express",
                    "ಮಲೆನಾಡು ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೩",
                    "12:20 PM",
                    "ಮಲೆನಾಡು ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೩ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                )
            )

            // Hubballi

            "ಹುಬ್ಬಳ್ಳಿ" -> listOf(

                TrainBoard(
                    "Hubballi Express",
                    "ಹುಬ್ಬಳ್ಳಿ ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೬",
                    "08:15 AM",
                    "ಹುಬ್ಬಳ್ಳಿ ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೬ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                ),

                TrainBoard(
                    "Rani Chennamma",
                    "ರಾಣಿ ಚೆನ್ನಮ್ಮ",
                    "೨",
                    "01:10 PM",
                    "ರಾಣಿ ಚೆನ್ನಮ್ಮ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೨ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                )
            )

            // Mangaluru

            "ಮಂಗಳೂರು" -> listOf(

                TrainBoard(
                    "Mangaluru Express",
                    "ಮಂಗಳೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೧",
                    "07:30 AM",
                    "ಮಂಗಳೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೧ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                ),

                TrainBoard(
                    "Karavali Express",
                    "ಕರಾವಳಿ ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೫",
                    "03:00 PM",
                    "ಕರಾವಳಿ ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೫ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                )
            )

            // Karwar

            "ಕಾರವಾರ" -> listOf(

                TrainBoard(
                    "Karwar Express",
                    "ಕಾರವಾರ ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೩",
                    "06:45 PM",
                    "ಕಾರವಾರ ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೩ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                ),

                TrainBoard(
                    "West Coast Express",
                    "ವೆಸ್ಟ್ ಕೋಸ್ಟ್ ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೨",
                    "08:00 PM",
                    "ವೆಸ್ಟ್ ಕೋಸ್ಟ್ ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೨ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                )
            )

            // Bengaluru Default

            else -> listOf(

                TrainBoard(
                    "Bengaluru Express",
                    "ಬೆಂಗಳೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್",
                    "೧",
                    "10:00 AM",
                    "ಬೆಂಗಳೂರು ಎಕ್ಸ್‌ಪ್ರೆಸ್ ವೇದಿಕೆ ಸಂಖ್ಯೆ ೧ಕ್ಕೆ ಬರುತ್ತಿದೆ"
                )
            )
        }

        // LIVE TRAIN CARD

        val liveTrainName =
            findViewById<TextView>(R.id.liveTrainName)

        val livePlatform =
            findViewById<TextView>(R.id.livePlatform)

        // First Train As Live Train

        val firstTrain =
            trainList[0]

        liveTrainName.text =
            firstTrain.kannadaName

        livePlatform.text =
            "ವೇದಿಕೆ ಸಂಖ್ಯೆ : ${firstTrain.platform}"

        // Adapter

        val adapter =
            TrainAdapter(trainList)

        recyclerView.adapter =
            adapter

        // Bottom Navigation

        val bottomNavigation =
            findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> {

                    true
                }

                R.id.nav_audio -> {

                    startActivity(
                        Intent(
                            this,
                            AudioAssistantActivity::class.java
                        )
                    )

                    true
                }

                R.id.nav_station -> {

                    startActivity(
                        Intent(
                            this,
                            StationSelectionActivity::class.java
                        )
                    )

                    true
                }

                R.id.nav_profile -> {

                    startActivity(
                        Intent(
                            this,
                            ProfileActivity::class.java
                        )
                    )

                    true
                }

                else -> false
            }
        }
    }
}