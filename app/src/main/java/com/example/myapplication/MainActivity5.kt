package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
    }

    fun back(view: View) {
        finish()
    }

    fun AddNotification(view: View) {
        var layout = findViewById<LinearLayout>(R.id.layout )

        layout.removeAllViews()

        var view = TextView(this)
        view.text = "Enter your Notification Text Here"


        view.setOnClickListener(View.OnClickListener {
            OpenDialog()
        })

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(10, 10, 10, 10)
        view.layoutParams = params

        layout.addView(view)
    }
    fun OpenDialog(){
        var builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.edit_here, null)

        val editText = dialogLayout.findViewById<EditText>(R.id.edit_here)

        with(builder){
            setTitle("Enter a value")
            setPositiveButton("Ok"){dialog, which->Route(editText.text.toString())}
            setNegativeButton("Cancel"){dialog, which-> Log.d("Main", "Clicked")}
            setView(dialogLayout)
            show()
        }
    }
    fun Route(name: String){
        val extras = intent.extras
        val intent = Intent(this, MainActivity3::class.java)

        if (extras != null) {
            val routineName = extras.getString("routineName")
            val date = extras.getString("date")

            intent.putExtra("date", date)
            intent.putExtra("routineName", routineName)
        }
        intent.putExtra("text", name)
        startActivity(intent)
    }

}