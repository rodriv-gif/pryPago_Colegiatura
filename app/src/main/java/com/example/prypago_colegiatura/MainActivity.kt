package com.example.prypago_colegiatura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    private lateinit var presentador: Presenter

    private lateinit var txtMatricula: EditText
    private lateinit var txtNombre: EditText
    private lateinit var txtP1: EditText
    private lateinit var txtP2: EditText
    private lateinit var txtP3: EditText
    private lateinit var txtColegiatura: EditText
    private lateinit var txtMatriculaNombre: TextView
    private lateinit var txtPromedioGlobal: TextView
    private lateinit var txtColegiaturaActual: TextView
    private lateinit var txtColegiaturaFinal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presentador = Presenter(this)

        txtMatricula = findViewById(R.id.etMatricula)
        txtNombre = findViewById(R.id.etNombre)
        txtP1 = findViewById(R.id.etPromedioP1)
        txtP2 = findViewById(R.id.etPromedioP2)
        txtP3 = findViewById(R.id.etPromedioP3)
        txtColegiatura = findViewById(R.id.etCosto)

        val btnPromedio = findViewById<Button>(R.id.btnPromedio)
        val btnEstatus = findViewById<Button>(R.id.btnEstatus)
        val btnColegiatura = findViewById<Button>(R.id.btnColegiatura)

        txtMatriculaNombre = findViewById(R.id.tvMatriculaNombre)
        txtPromedioGlobal = findViewById(R.id.tvPromedioGlobal)
        txtColegiaturaActual = findViewById(R.id.tvColegiaturaActual)
        txtColegiaturaFinal = findViewById(R.id.tvColegiaturaFinal)
    }
}