package com.example.androidcomponentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnPlay: Button = findViewById(R.id.btn_play)
        val btnStop: Button = findViewById(R.id.btn_stop)

        btnPlay.setOnClickListener{
            //Starting the service
            var startServiceIntent = Intent(applicationContext,MyService::class.java)
            startService(startServiceIntent)
        }

        btnStop.setOnClickListener{
            var stopServiceIntent = Intent(applicationContext,MyService::class.java)
            stopService(stopServiceIntent)

        }
        
    }
}