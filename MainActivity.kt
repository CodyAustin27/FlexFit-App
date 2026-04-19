package com.example.flexfit

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeSpinner = findViewById<Spinner>(R.id.timeSpinner)
        val equipmentSpinner = findViewById<Spinner>(R.id.equipmentSpinner)
        val goalSpinner = findViewById<Spinner>(R.id.goalSpinner)
        val startButton = findViewById<Button>(R.id.startButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        val timeOptions = arrayOf("20 min", "45 min", "60+ min")
        val equipmentOptions = arrayOf("Bodyweight", "Dumbbells", "Full Gym")
        val goalOptions = arrayOf("Strength", "Fat Loss", "Endurance")

        timeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, timeOptions)
        equipmentSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, equipmentOptions)
        goalSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, goalOptions)

        startButton.setOnClickListener {
            val time = timeSpinner.selectedItem.toString()
            val equipment = equipmentSpinner.selectedItem.toString()
            val goal = goalSpinner.selectedItem.toString()

            val workout = generateWorkout(time, equipment, goal)
            resultText.text = workout
        }
    }

    private fun generateWorkout(time: String, equipment: String, goal: String): String {

        return if (time == "20 min" && equipment == "Bodyweight") {
            "Quick Bodyweight Workout:\n\nPush-ups x15\nSquats x20\nBurpees x10\nPlank 30 sec (3 rounds)"
        }
        else if (time == "45 min" && equipment == "Dumbbells") {
            "Dumbbell Workout:\n\nDB Bench x12\nDB Rows x12\nDB Squats x15\nShoulder Press x10 (4 sets)"
        }
        else if (time == "60+ min" && equipment == "Full Gym") {
            "Full Gym Workout:\n\nBench Press 4x8\nSquat 4x8\nDeadlift 3x5\nPull-ups 3xMax\nCooldown Cardio"
        }
        else {
            "General Workout:\n\nPush-ups x10\nSquats x15\nJumping Jacks x20\nRepeat for 20-30 minutes"
        }
    }
}
