package com.example.android_xml

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_xml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var lastTime: Long = 0
    var diff : Long = System.currentTimeMillis()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentTime = System.currentTimeMillis()
        diff = currentTime - diff

        Log.d("main-activity:create", "$diff")

        lastTime = currentTime
    }

    override fun onStart() {
        super.onStart()

        val currentTime = System.currentTimeMillis()
        val diff = currentTime - lastTime

        Log.d("main-activity:start", "$diff")

        lastTime = currentTime
    }

    override fun onResume() {
        super.onResume()

        val currentTime = System.currentTimeMillis()
        val diff = currentTime - lastTime

        Log.d("main-activity:resume", "$diff")

        lastTime = currentTime
    }

    override fun onPause() {
        super.onPause()

        val currentTime = System.currentTimeMillis()
        val diff = currentTime - lastTime

        Log.d("main-activity:pause", "$diff")

        lastTime = currentTime
    }

    override fun onStop() {
        super.onStop()

        val currentTime = System.currentTimeMillis()
        val diff = currentTime - lastTime

        Log.d("main-activity:stop", "$diff")

        lastTime = currentTime
    }

    override fun onDestroy() {
        super.onDestroy()

        val currentTime = System.currentTimeMillis()
        val diff = currentTime - lastTime

        Log.d("main-activity:destroy", "$diff")

        lastTime = currentTime
    }
}