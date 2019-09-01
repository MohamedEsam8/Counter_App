package com.tawfiq.counterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginbu.setOnClickListener() {
            checkcredintials()
        }
    }

    fun checkcredintials() {
        val usermail = email.text.toString()
        val userpassword = password.text.toString()
        val emailpattern = Patterns.EMAIL_ADDRESS

        if (usermail == "" && userpassword == "") {
            Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_LONG).show()
        } else if (usermail == "" || userpassword == "") {
            Toast.makeText(this, "Please Fill all fields", Toast.LENGTH_LONG).show()
        } else if (!emailpattern.matcher(usermail).matches()) {
            Toast.makeText(this, "Please Enter Valid Email", Toast.LENGTH_LONG).show()
        } else if (userpassword.length <= 5) {
            Toast.makeText(this, "Password should be with a min of 6 characters", Toast.LENGTH_LONG)
                .show()
        } else if (userpassword.length > 10) {
            Toast.makeText(
                this,
                "Password should be with a max of 10 characters",
                Toast.LENGTH_LONG
            )
                .show()
        } else {
            startapp()
        }

    }

    fun startapp() {
        val sharedPreference = SharedPreference(this)
        if (!sharedPreference.getLoggedStatus()!!) {
            var intent = Intent(this, Home::class.java)
            startActivity(intent)
            sharedPreference.setLoggedStatus(true)
            finish()
        }
    }


}
