package com.example.maestrapp.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.maestrapp.R

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvResultado: TextView
    private lateinit var btnRecalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        initComponent()
        initUi()

        val result : Double = intent.extras?.getDouble("result_imc") ?: -1.0
        calcularIMC(result)


        btnRecalcular.setOnClickListener {
            val volver = Intent(this, CalcularIMCActivity::class.java)
            startActivity(volver)
        }
    }

    private fun calcularIMC(result: Double) {
        tvResultado.text = result.toString()
        when(result){
            in 00.00..18.50 -> { // Bajo peso

            }
            in 18.51..24.99 -> { // Peso normal

            }
            in 25.00..29.99 -> { // Sobrepeso

            }
            in 30.00..99.00 -> { // Obesidad

            }
        }
    }

    private fun initUi() {
        TODO("Not yet implemented")
    }

    private fun initComponent() {
        btnRecalcular = findViewById(R.id.btnRecalcular)
        tvResultado = findViewById(R.id.tvResultado)
    }


}