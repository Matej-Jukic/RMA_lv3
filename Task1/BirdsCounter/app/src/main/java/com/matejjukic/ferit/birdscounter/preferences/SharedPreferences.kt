package com.matejjukic.ferit.birdscounter.preferences

import android.content.Context
import com.matejjukic.ferit.birdscounter.BirdsCounter
import com.matejjukic.ferit.birdscounter.R

object SharedPreferences {
    private const val FILE = "BirdCounterFile"
    private const val KEY_COUNTER = "BirdCounter"
    private const val KEY_COLOR = "Color"

    private val preferences = BirdsCounter.context.getSharedPreferences(
        FILE, Context.MODE_PRIVATE
    )

    private val editor = preferences.edit()

    fun saveCounter(counter: Int) = editor.putInt(KEY_COUNTER, counter).apply()

    fun getCounter(): Int = preferences.getInt(KEY_COUNTER, 0)

    fun saveColor(colorId: Int) = editor.putInt(KEY_COLOR, colorId).apply()

    fun getColor(): Int = preferences.getInt(KEY_COLOR, R.color.white)
}

