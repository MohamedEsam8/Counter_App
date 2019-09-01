package com.tawfiq.counterapp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPreference(context: Context) {

    private val mPrefs: SharedPreferences

    init {
        mPrefs = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE)
    }

    fun setLoggedStatus(stat: Boolean) {
        mPrefs.edit().putBoolean(ISLOGGEDIN, stat).apply()
    }

    fun getLoggedStatus(): Boolean? {
        return mPrefs.getBoolean(ISLOGGEDIN, false)
    }

    companion object {
        private const val ISLOGGEDIN = "isLoggedIn"
        private const val MY_PREFS = "testPref"
    }
}