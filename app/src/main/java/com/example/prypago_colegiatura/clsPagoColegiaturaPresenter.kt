package com.example.prypago_colegiatura

class clsPagoColegiaturaPresenter(private val vista: MainActivity) {

    private val modelo = clsModelo
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
    fun calcular_Promedio(textp1: String, textp2: String, textp3: String): Float {
        val p1 = textp1.toFloatOrNull()?:0f
        val p2 = textp2.toFloatOrNull()?:0f
        val p3 = textp3.toFloatOrNull()?:0f

        val promedio = modelo.calcularPromedio(p1,p2,p3)
        vista.mostrarPromedioGlobal(promedio)
        return promedio
    }

    //Determina y manda mostrar el estatus
    fun determinarEstatus(promedio: Float) {
        val estado = modelo.obtenerEstatus(promedio)
        vista.mostrarEstatus(estado)
    }

    //Calcula y manda mostrar los costos de colegiatura
    fun calcularColegiaturaFinal(costoText: String, promedio: Float) {
        val costoBase = costoText.toFloatOrNull() ?: 0f
        val costoFinal = modelo.calcularColegiatura(costoBase, promedio.toFloat())
        vista.mostrarResultadosColegiatura(costoBase, costoFinal)
    }
}