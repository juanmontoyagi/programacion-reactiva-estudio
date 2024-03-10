package com.ejercicios.programacionfuncional.Ejercicio1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio1Test {

    /**
     * Ordenar los Strings de Mayor a Menor, es decir, contrario al ejemplo de la clase.
     */
    @Test()
    public void ejercicio1ComparadorTest(){
        List<String> nombres = Arrays.asList("Pedrio", "Pablo", "Jacinto", "Jose");

        Comparator<String> comparatorLongitud = (o1, o2) -> o2.length() - o1.length();

        Assert.assertNotNull("No has creado el elemento aún", comparatorLongitud);

        Collections.sort(nombres, comparatorLongitud);

        Assert.assertEquals("El primero debe ser Jacinto", nombres.get(0), "Jacinto");
        Assert.assertEquals("El segundo debe ser Pedrio", nombres.get(1), "Pedrio");
        Assert.assertEquals("El tercero debe ser Pablo", nombres.get(2), "Pablo");
        Assert.assertEquals("El cuarto debe ser Jose", nombres.get(3), "Jose");

    }
}
