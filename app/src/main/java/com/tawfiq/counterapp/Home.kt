package com.tawfiq.counterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class Home : AppCompatActivity() {
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        increasebu.setOnClickListener() {
            increasecounter()
        }

        decreasebu.setOnClickListener() {
            dcreasecounter()
        }

        logoutbu.setOnClickListener() {
            logout()
        }
    }

    fun increasecounter() {
        i++
        counter.text = "Counter = $i"
    }

    fun dcreasecounter() {
        i--
        counter.text = "Counter = $i"
    }

    fun logout() {
        val sharedPreference = SharedPreference(this)
        sharedPreference.setLoggedStatus(false)
        startActivity(Intent(this, Login::class.java))
        finish()
    }



}
