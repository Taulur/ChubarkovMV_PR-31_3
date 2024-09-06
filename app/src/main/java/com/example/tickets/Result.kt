package com.example.tickets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class Result : AppCompatActivity() {

    private lateinit var metersText : TextView
    private lateinit var resultText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var result = intent.getStringExtra("Result")
        var meters = intent.getStringExtra("Meters")

        metersText = findViewById(R.id.meters)
        resultText = findViewById(R.id.result)

        metersText.text = meters + " м"
        resultText.text = result + " руб"
    }


}