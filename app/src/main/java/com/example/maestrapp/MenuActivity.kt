package com.example.maestrapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.maestrapp.firstApp.FirstAppActivity
import com.example.maestrapp.imcapp.CalcularIMCActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnEscribeTuNombre = findViewById<Button>(R.id.btnEscribeTuNombreApp)
        btnEscribeTuNombre.setOnClickListener {
            val intentEscribeTN = Intent(this, FirstAppActivity::class.java)
            startActivity(intentEscribeTN)
        }

        val btnImcApp = findViewById<Button>(R.id.btnIMCApp)
        btnImcApp.setOnClickListener {
            val intentIMC = Intent(this, CalcularIMCActivity::class.java)
            startActivity(intentIMC)
        }
    }
}