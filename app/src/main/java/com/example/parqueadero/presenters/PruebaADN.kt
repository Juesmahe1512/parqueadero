package com.example.parqueadero.presenters

import com.example.parqueadero.interfaces.TestADN

public class PruebaADN: TestADN {
    override fun pruebaSumaDosNumeros(sumandoUno: Int, sumandoDos: Int):Int {
        var resultado = sumandoUno + sumandoDos
        println(resultado)
        return resultado
    }

    fun sumaTresNumeros(sumandoUno: Int, sumandoDos: Int, sumandoTres:Int): Int {
        return sumandoUno + sumandoDos + sumandoTres
    }
}