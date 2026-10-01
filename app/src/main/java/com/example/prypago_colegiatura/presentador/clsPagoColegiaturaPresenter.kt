package com.example.prypago_colegiatura.presentador

import com.example.prypago_colegiatura.vista.MainActivity
import com.example.prypago_colegiatura.modelo.clsColegiaturaModelo

class clsPagoColegiaturaPresenter(private val vista: MainActivity) {

    private val modelo = clsColegiaturaModelo()


    //Procesa y manda mostrar la Matrícula y Nombre
    fun datosAlumno(matricula: String, nombre: String) {
        val resultado = if (matricula.isNotEmpty() || nombre.isNotEmpty()) {
            "$matricula $nombre"
        } else {
            "Sin datos"
        }
        vista.mostrarMatriculaNombre(resultado)
    }

    //Calcula y manda mostrar el promedio global
    fun calcular_Promedio(textp1: String, textp2: String, textp3: String){
        val p1 = textp1.toFloatOrNull() ?: 0f
        val p2 = textp2.toFloatOrNull() ?: 0f
        val p3 = textp3.toFloatOrNull() ?: 0f

        val promedioGeneral = modelo.calcularPromedio(p1, p2, p3)
        vista.mostrarPromedioGlobal(String.format("%.2f",promedioGeneral))
    }

    //Determina y manda mostrar el estatus usando el promedio ya guardado
    fun determinarEstatus(txtPromedioGeneral:String) {
        val promedioGeneral = txtPromedioGeneral.toFloatOrNull()?:0f
        val estado = modelo.CalcularEstatus(promedioGeneral)
        vista.mostrarEstatus(String.format("%.2f",estado))
    }

    //Calcula y manda mostrar los costos de colegiatura usando el promedio ya guardado
    fun calcularColegiaturaFinal(txtColegiatura:String, txtEstatus:String) {
        val costoBase = txtColegiatura.toFloatOrNull() ?: 0f
        val descuento = txtEstatus.toFloatOrNull()?:0f
        val costoFinal = modelo.calcularColegiaturaTotal(costoBase, descuento)
        vista.mostrarResultadosColegiatura(String.format("%.2f",costoFinal ))
    }

    fun ColegiaturaActual(txtColegiatura: String) {
        val costoBase = txtColegiatura.toFloatOrNull() ?: 0f
        vista.mostrarColegiaturaActual(String.format("%.2f", costoBase))
    }


}