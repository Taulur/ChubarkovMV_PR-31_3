package com.example.tickets

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class Main : AppCompatActivity() {
    private var Spinner:Spinner? = null
    private var ResultText:TextView? = null
    private var Chosen:TextView? = null
    private var Meters:EditText? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Spinner = findViewById(R.id.spinner)
        ResultText = findViewById(R.id.result)
        Chosen = findViewById(R.id.chosen)
        Meters = findViewById(R.id.meters)

    }

    fun nextScreen(result : Number,meters : Number)
    {
        val intent = Intent(this, Result::class.java)
        intent.putExtra("Result", result.toString())
        intent.putExtra("Meters", meters.toString())
        startActivity(intent)
    }

    fun enter(view: View) {
        val choise = Spinner!!.selectedItem
        val number = Meters!!.text.toString().toInt()

        if (number >= 1)
        {
            var final = 0
            Chosen!!.text = choise.toString()

            when (choise.toString()) {
                "Однокомнатная квартира" -> if (number >= 15 && number <= 30) { final = number * 1000; nextScreen(final,number) }
                "Двухкомнатная квартира" -> if (number >= 25 && number <= 50) { final = number * 2000; nextScreen(final,number) }
                "Трехкомнатная квартира" -> if (number >= 40 && number <= 80) { final = number * 3000; nextScreen(final,number) }
                "Четырехкомнатная квартира" -> if (number >= 70 && number <= 120) { final = number * 4000; nextScreen(final,number) }

            }

            ResultText!!.text = final.toString() + " руб"




        }





    }
}