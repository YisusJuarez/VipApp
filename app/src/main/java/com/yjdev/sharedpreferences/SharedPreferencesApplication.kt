package com.yjdev.sharedpreferences

import android.app.Application

class SharedPreferencesApplication:Application() {
    // Los companion object sirven para tener variables aacesibles desde toda la app
    companion object{
        lateinit var prefs:Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}