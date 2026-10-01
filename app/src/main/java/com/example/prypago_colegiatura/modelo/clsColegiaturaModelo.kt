package com.example.prypago_colegiatura.modelo

class clsColegiaturaModelo {
    fun calcularPromedio(parcial1:Float,parcial2:Float,parcial3:Float):Float{
        return (parcial1+parcial2+parcial3)/3
    }
    fun CalcularEstatus(promedio:Float):Float{
        return when{
            promedio <=7f -> 0.0f
            promedio <=9f -> 30.0f
            else -> 50.0f
        }
    }

    fun calcularColegiaturaTotal(costoColegiatura: Float,descuento: Float):Float{
        return costoColegiatura-(costoColegiatura * descuento / 100)
    }

}