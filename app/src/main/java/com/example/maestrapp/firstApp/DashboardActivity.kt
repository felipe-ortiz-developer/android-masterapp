package com.example.maestrapp.firstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.maestrapp.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val nombre : String = intent.extras?.getString("nombre").orEmpty()
        tvNombre.text = "Bienvenido $nombre"

    }
}