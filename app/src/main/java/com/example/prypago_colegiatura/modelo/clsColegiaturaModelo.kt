package com.example.prypago_colegiatura.modelo

class clsColegiaturaModelo {
    fun calcularPromedio(promedio1:Float,promedio2:Float,promedio3:Float):Float{
        return (promedio1+promedio2+promedio3)/3
    }
    fun porcentajeDescuento(promedio:Float):Float{
        return when{
            promedio <=7.0f ->0.0f
            promedio <=9.0f ->0.3f
            else -> 0.5f
        }

    }
    fun calcularDescuento(costoColegiatura:Float,promedio: Float):Float{
        return costoColegiatura*porcentajeDescuento(promedio)
    }
    fun calcularColegiaturaTotal(costoColegiatura: Float,promedio: Float):Float{
        return costoColegiatura-calcularDescuento(costoColegiatura,promedio)
    }
    fun obtenerEstatus(promedio:Float): String{
        return when{
            promedio <7 -> "Reprobado y no tienes descuento"
            promedio <=9 -> "Aprobado tienes 30% de descuento"
            else -> "tienes 50% de descuento"
        }
    }
}