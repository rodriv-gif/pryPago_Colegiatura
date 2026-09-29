package com.example.prypago_colegiatura.vista

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.prypago_colegiatura.R
import com.example.prypago_colegiatura.presentador.clsPagoColegiaturaPresenter

class MainActivity : AppCompatActivity() {

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

    private lateinit var btnCalcPromedio: Button
    private lateinit var btnEstatus: Button
    private lateinit var btnColegiatura: Button

    private lateinit var presentador: clsPagoColegiaturaPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar Presentador
        presentador = clsPagoColegiaturaPresenter(this)

        // Relacionar Vistas con XML (IDs)
        txtMatricula = findViewById(R.id.etMatricula)
        txtNombre = findViewById(R.id.etNombre)
        txtP1 = findViewById(R.id.etPromedioP1)
        txtP2 = findViewById(R.id.etPromedioP2)
        txtP3 = findViewById(R.id.etPromedioP3)
        txtColegiatura = findViewById(R.id.etCosto)

        btnCalcPromedio = findViewById(R.id.btnPromedio)
        btnEstatus = findViewById(R.id.btnEstatus)
        btnColegiatura = findViewById(R.id.btnColegiatura)

        txtMatriculaNombre = findViewById(R.id.tvMatriculaNombre)
        txtPromedioGlobal = findViewById(R.id.tvPromedioGlobal)
        txtColegiaturaActual = findViewById(R.id.tvColegiaturaActual)
        txtColegiaturaFinal = findViewById(R.id.tvColegiaturaFinal)

        // Asignar listeners
        btnCalcPromedio.setOnClickListener(this::obtenerPromedio)
        btnEstatus.setOnClickListener(this::obtenerEstatus)
        btnColegiatura.setOnClickListener(this::obtenerColegiatura)
    }

    private fun obtenerPromedio(v: View) {
        presentador.datosAlumno(txtMatricula.text.toString(), txtNombre.text.toString())
        presentador.calcular_Promedio(
            txtP1.text.toString(),
            txtP2.text.toString(),
            txtP3.text.toString()
        )
    }

    private fun obtenerEstatus(v: View) {
        presentador.datosAlumno(txtMatricula.text.toString(), txtNombre.text.toString())
        val promedio = presentador.calcular_Promedio(
            txtP1.text.toString(),
            txtP2.text.toString(),
            txtP3.text.toString()
        )
        presentador.determinarEstatus(promedio)
    }

    private fun obtenerColegiatura(v: View) {
        presentador.datosAlumno(txtMatricula.text.toString(), txtNombre.text.toString())
        // 1. Reutilizamos el return de calcular_Promedio
        val promedio = presentador.calcular_Promedio(
            txtP1.text.toString(),
            txtP2.text.toString(),
            txtP3.text.toString()
        )

        // 2. Pasamos el costo en texto y el promedio ya calculado
        presentador.calcularColegiaturaFinal(
            txtColegiatura.text.toString(),
            promedio
        )
    }

    //Métodos que llama el Presentador para actualizar los TextViews

    fun mostrarMatriculaNombre(texto: String) {
        txtMatriculaNombre.text = "Matricula y Nombre: $texto"
    }

    fun mostrarPromedioGlobal(promedio: Float) {
        txtPromedioGlobal.text = "Promedio Global: " + String.format("%.2f", promedio)
    }

    fun mostrarEstatus(estatus: String) {
        txtColegiaturaActual.text = "Estatus: $estatus"
    }

    fun mostrarResultadosColegiatura(costoBase: Float, costoFinal: Float) {
        txtColegiaturaActual.text = "Colegiatura Actual: $costoBase"
        txtColegiaturaFinal.text = "Colegiatura final: $costoFinal"
    }
}