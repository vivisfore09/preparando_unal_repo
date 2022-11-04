package com.example.preparando_unal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.example.preparando_unal.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler=Handler(Looper.myLooper()!!)

        handler.postDelayed({
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)

    }


}




