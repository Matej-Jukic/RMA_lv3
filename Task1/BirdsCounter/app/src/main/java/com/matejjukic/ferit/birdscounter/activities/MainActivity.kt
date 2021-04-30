package com.matejjukic.ferit.birdscounter.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matejjukic.ferit.birdscounter.R
import com.matejjukic.ferit.birdscounter.databinding.ActivityMainBinding
import com.matejjukic.ferit.birdscounter.preferences.SharedPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private var birdCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setup()
    }

   private fun setup(){
        mainBinding.apply {
            tvBirdCounter.text = birdCounter.toString()
            btnReset.setOnClickListener { onClick(btnReset.id) }
            btnRedBird.setOnClickListener { onClick(btnRedBird.id) }
            btnGreenBird.setOnClickListener { onClick(btnGreenBird.id) }
            btnBlueBird.setOnClickListener { onClick(btnBlueBird.id) }
            btnYellowBird.setOnClickListener { onClick(btnYellowBird.id) }
        }
    }

    private fun onClick( id: Int){
        mainBinding.apply {
            ++birdCounter
            tvBirdCounter.text = birdCounter.toString()
            when (id){
                btnReset.id -> {
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.white))
                    btnReset.setBackgroundColor(resources.getColor(R.color.sucmurasta))
                    birdCounter = 0
                    tvBirdCounter.text = birdCounter.toString()
                    SharedPreferences.saveColor(resources.getColor(R.color.white))
                }
                btnRedBird.id -> {
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.red))
                    btnReset.setBackgroundColor(resources.getColor(R.color.red))
                    SharedPreferences.saveColor(resources.getColor(R.color.red))
                }
                btnGreenBird.id -> {
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.green))
                    btnReset.setBackgroundColor(resources.getColor(R.color.green))
                    SharedPreferences.saveColor(resources.getColor(R.color.green))
                }
                btnBlueBird.id -> {
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.blue))
                    btnReset.setBackgroundColor(resources.getColor(R.color.blue))
                    SharedPreferences.saveColor(resources.getColor(R.color.blue))
                }
                btnYellowBird.id -> {
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.yellow))
                    btnReset.setBackgroundColor(resources.getColor(R.color.yellow))
                    SharedPreferences.saveColor(resources.getColor(R.color.yellow))
                }
            }
            SharedPreferences.saveCounter(birdCounter)
        }
    }

    override fun onResume() {
        super.onResume()
        mainBinding.apply {
            birdCounter = SharedPreferences.getCounter()
            tvBirdCounter.text = birdCounter.toString()
            tvBirdCounter.setBackgroundColor(SharedPreferences.getColor())
        }
    }
}