package com.example.tickets

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class Login : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var pass: EditText
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login = findViewById(R.id.email);
        pass = findViewById(R.id.password);

        pref = getPreferences(MODE_PRIVATE)
        val ed = pref.edit()
        ed.putString("login", intent.getStringExtra("login"))
        ed.putString("password", intent.getStringExtra("password"))
        ed.apply()



    }


    fun next(view: View) {
        if (login.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
        {
            if ((pref.getString("login","") != "") && (pref.getString("password","") != ""))
            {
                if ((login.text.toString() == pref.getString("login","")) && (pass.text.toString() == pref.getString("password","")))
                {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Вход")
                        .setMessage("Данные введены успешно")
                        .setPositiveButton("Продолжить",null)
                        .create()
                        .show()

                    val intent = Intent(this,Main::class.java)
                    startActivity(intent)
                }
                else
                {
                    val hint1 = pref.getString("login","")
                    val hint2 = pref.getString("password","")

                    val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Неверный логин или пароль\n(Логин : " + hint1 + " Пароль : " + hint2 + ")")
                        .setPositiveButton("Повторить",null)
                        .create()
                        .show()
                }
            }
            else
            {
                val ed = pref.edit()
                ed.putString("login", login.text.toString())
                ed.putString("password", pass.text.toString())
                ed.apply()

                val alert = AlertDialog.Builder(this)
                    .setTitle("Вход")
                    .setMessage("Успешный вход, запомните свои данные!")
                    .setPositiveButton("Продолжить",null)
                    .create()
                    .show()

                val intent = Intent(this,Main::class.java)
                startActivity(intent)
            }

        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите логин или пароль")
                .setPositiveButton("Продолжить",null)
                .create()
                .show()

        }


    }

}