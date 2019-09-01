package com.tawfiq.counterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val sharedPreference = SharedPreference(this)
        Handler().postDelayed({
            if (sharedPreference.getLoggedStatus()!!)
                startActivity(Intent(this, Home::class.java))
            else
                startActivity(Intent(this, Login::class.java))
            finish()
        }, 3000)
    }
}
