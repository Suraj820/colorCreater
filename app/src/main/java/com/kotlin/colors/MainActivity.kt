package com.kotlin.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val colorDisplay = findViewById<TextView>(R.id.color_creator_display)
        val button = findViewById<Button>(R.id.color_creator_button)
        button?.setOnClickListener {
            var redChannelText = findViewById<TextInputEditText>(R.id.red_channel)?.text.toString()
            var greenChannelText = findViewById<TextInputEditText>(R.id.green_channel)?.text.toString()
            var blueChannelText = findViewById<TextInputEditText>(R.id.blue_channel)?.text.toString()

            if (redChannelText.isEmpty() or greenChannelText.isEmpty() or blueChannelText.isEmpty()) {
                Toast.makeText(this, "All Values are required", Toast.LENGTH_LONG).show()
            }else{
                if(redChannelText.length == 1 ) redChannelText =  redChannelText.plus(redChannelText)  // plus -> same as concatenation in java
                if(greenChannelText.length == 1 ) greenChannelText =  greenChannelText.plus(greenChannelText)
                if(blueChannelText.length == 1 ) blueChannelText =  blueChannelText.plus(blueChannelText)
                val colorToDisplay =  redChannelText.plus(greenChannelText).plus(blueChannelText)
                colorDisplay.setBackgroundColor(Color.parseColor("#".plus(colorToDisplay)))


            }
        }
    }
}