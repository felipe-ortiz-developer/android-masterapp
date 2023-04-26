package com.example.maestrapp.firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.maestrapp.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnIniciar = findViewById<AppCompatButton>(R.id.btnIniciar)
        val etUsuario = findViewById<AppCompatEditText>(R.id.etUsuario)
        btnIniciar.setOnClickListener {
            val nombre = etUsuario.text.toString()
            if(nombre.isNotEmpty()){
                Log.e("Felipe", "Se apreto el boton iniciar sesion ${nombre}")

                val dashBoardIntent = Intent(this, DashboardActivity::class.java)
                dashBoardIntent.putExtra("nombre", nombre)
                startActivity(dashBoardIntent)
            }
        }
    }
}