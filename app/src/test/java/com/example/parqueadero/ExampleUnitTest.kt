package com.example.parqueadero

import com.example.parqueadero.presenters.PruebaADN
import com.example.parqueadero.presenters.TestPresenter
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun pruebaSumandosADN() {
        //Arrange
        var prueba = PruebaADN()
        var resultadoEsperado = 10

        //Act
        var resultado = prueba.pruebaSumaDosNumeros(6,5)

        //Assert
        assertEquals(resultadoEsperado,resultado)
    }

}