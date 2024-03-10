package com.ejercicios.programacionfuncional.Ejercicio1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio1_Comparator {

    public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Juan", "Valeria", "Andrés");

        Comparator<String> comparatorLongitud = (o1, o2) -> o1.length() - o2.length();

        Collections.sort(nombres, comparatorLongitud);

        System.out.println(nombres);

    }
}
