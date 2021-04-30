package com.matejjukic.ferit.birdscounter

import android.app.Application
import android.content.Context

class BirdsCounter :Application() {
    companion object{
        lateinit var context: Context
        private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}