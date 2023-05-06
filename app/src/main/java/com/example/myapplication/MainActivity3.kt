package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity3 : AppCompatActivity() {

    private lateinit var eventTv: TextView
    private lateinit var actionTv: TextView
    private lateinit var routineInput: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        eventTv = findViewById<TextView>(R.id.addedEventTv)
        actionTv = findViewById<TextView>(R.id.addedAction)
        routineInput = findViewById<TextInputEditText>(R.id.routineName)






        val extras = intent.extras
        if (extras != null) {
            val date = extras.getString("date")
            val action = extras.getString("text")
            val routineName = extras.getString("routineName")


            routineInput.setText(routineName)

            if (date != null) {
                if (date.startsWith("Date and")) {
                    eventTv.text = "$date"
                } else {
                    eventTv.text = "Date and Time \n The dateTime is $date"
                    actionTv.text = "Notification \n Send Notification : $action"



                }
            }
                eventTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.access_time_filled_24, 0,R.drawable.settings,0)
                actionTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.chat_bubble_24, 0,R.drawable.settings,0)


            }


        }




    fun addEvent(view: View) {
        val intent = Intent(this, MainActivity4::class.java)
        intent.putExtra("routineName", routineInput.text.toString())
        startActivity(intent)
    }

    fun things(view: View) {
        val intent = Intent(this, MainActivity5::class.java)
        intent.putExtra("routineName", routineInput.text.toString())
        intent.putExtra("date", eventTv.text)
        startActivity(intent)
    }



}