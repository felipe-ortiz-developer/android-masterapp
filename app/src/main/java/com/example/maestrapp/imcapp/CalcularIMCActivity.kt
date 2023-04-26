package com.example.maestrapp.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.maestrapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class CalcularIMCActivity : AppCompatActivity() {
    private lateinit var cvMale : CardView
    private lateinit var cvFemale : CardView

    private lateinit var rsHeight : RangeSlider
    private lateinit var tvRangeSlider: TextView

    private lateinit var btnSumarKilo: FloatingActionButton
    private lateinit var btnRestarKilo: FloatingActionButton
    private lateinit var tvKilo: TextView

    private lateinit var btnSumarEdad: FloatingActionButton
    private lateinit var btnRestarEdad: FloatingActionButton
    private lateinit var tvEdad: TextView

    private lateinit var btnCalcular: Button

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 65
    private var currentAge: Int = 25
    private var currentHeight: Int = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_imcactivity)
        initComponents()
        initListeners()
        initUi()
    }

    private fun initUi() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun setAge() {
        val edad = currentAge.toString()
        tvEdad.text = "$edad años"
    }

    private fun setWeight() {
        val peso = currentWeight.toString()
        tvKilo.text = "$peso kg"
    }

    private fun initComponents(){
        cvMale = findViewById(R.id.cvMale)
        cvFemale = findViewById(R.id.cvFemale)
        rsHeight = findViewById(R.id.rsHeight)
        tvRangeSlider = findViewById(R.id.tvHeight)
        btnSumarKilo = findViewById(R.id.btnSumarKilo)
        btnRestarKilo = findViewById(R.id.btnRestarKilo)
        tvKilo = findViewById(R.id.tvWeight)
        btnRestarEdad = findViewById(R.id.btnRestarEdad)
        btnSumarEdad = findViewById(R.id.btnSumarEdad)
        tvEdad = findViewById(R.id.tvAge)
        btnCalcular = findViewById(R.id.btnCalcular)
    }

    private fun initListeners() {
        cvMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        cvFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvRangeSlider.text = "$currentHeight cm"
        }

        btnSumarKilo.setOnClickListener {
            currentWeight++
            setWeight()
        }
        btnRestarKilo.setOnClickListener {
            currentWeight--
            setWeight()
        }

        btnRestarEdad.setOnClickListener {
            currentAge--
            setAge()
        }

        btnSumarEdad.setOnClickListener {
            currentAge++
            setAge()
        }

        btnCalcular.setOnClickListener {
            val df = DecimalFormat("#.##")
            val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
            val resultado = df.format(imc).toDouble()
            val intentResult = Intent(this, ResultIMCActivity::class.java)
            intentResult.putExtra("result_imc", resultado)
            startActivity(intentResult)

            Log.e("currentHeight", ": $currentHeight")
            Log.e("currentWeight", ": $currentWeight")
            Log.e("IMC", ": $imc")
            Log.e("resultado", ": $resultado")
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        cvMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cvFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
            // Agrandar el tamaño del componente:  carview, icon y textview


        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

}