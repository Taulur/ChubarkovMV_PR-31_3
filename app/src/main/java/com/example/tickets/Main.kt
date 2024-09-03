package com.example.tickets

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class Main : AppCompatActivity() {
    private var Spinner:Spinner? = null
    private var Result:TextView? = null
    private var Chosen:TextView? = null
    private var Meters:EditText? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Spinner = findViewById(R.id.spinner)
        Result = findViewById(R.id.result)
        Chosen = findViewById(R.id.chosen)
        Meters = findViewById(R.id.meters)

    }

    fun enter(view: View) {
        val choise = Spinner!!.selectedItem
        val number = Meters!!.text.toString().toInt()

        if (number >= 1)
        {
            var final = 0
            Chosen!!.text = choise.toString()

            when (choise.toString()) {
                "Однокомнатная квартира" -> final = number * 1
                "Двухкомнатная квартира" -> final = number * 2
                "Трехкомнатная квартира" -> final = number * 3
                "Четырехкомнатная квартира" -> final = number * 4

            }

            Result!!.text = final.toString() + " м"
        }





    }
}