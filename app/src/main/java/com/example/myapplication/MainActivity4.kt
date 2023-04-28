package com.example.myapplication

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.util.Calendar

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
    }

    fun time(view: View) {
        val calender = Calendar.getInstance()
        val hr = calender.get(Calendar.HOUR_OF_DAY)
        val min = calender.get(Calendar.MINUTE)
        val timePicker = TimePickerDialog(this, { view, hourOfDay, minute -> onTimeSet(hourOfDay, minute)}, hr, min, false)
        timePicker.show()

    }


    fun onTimeSet(hourOfDay: Int, minute: Int)
    {
        val extras = intent.extras
        val intent = Intent(this, MainActivity3::class.java)

        if (extras != null) {
            val routineName = extras.getString("routineName")

            intent.putExtra("routineName", routineName)
        }

        val currentTime = "$hourOfDay : $minute"
        intent.putExtra("date", currentTime)
        startActivity(intent)

    }


}