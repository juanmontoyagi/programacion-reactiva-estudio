package com.ejercicios.programacionfuncional.Ejercicio2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ejercicio2 {

    private EjercicioLambda2 ejercicioLambda2 = new EjercicioLambda2();

    @Test
    public void test_sumador () {
        assertEquals(5, ejercicioLambda2.obtenSumador().opera(2, 3));
    }

    @Test
    public void test_devuelve5 () {
        assertEquals(5, ejercicioLambda2.devuelve5().valor());
    }

    @Test
    public void test_inicializador() {
        String[] array = new String[4];

        ejercicioLambda2.obtenInicializador().inicializa(array, "A");

        assertArrayEquals(array, new String[] {"A","A","A","A"});
    }
}
