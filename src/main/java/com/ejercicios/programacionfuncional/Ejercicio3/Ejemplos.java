package com.ejercicios.programacionfuncional.Ejercicio3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejemplos {

    public static void main(String[] args) {

        Persona personaJuan = new Persona();
        Persona personaAlberto = new Persona();
        Persona personaAntonio = new Persona();

        // Collections Stream()
        List<Persona> personas = Arrays.asList(personaAlberto, personaAntonio, personaJuan);
        Stream<Persona> streamUno = personas.stream();

        // Arrays.asStream()
        Persona[] personas1 = {personaJuan, personaAlberto, personaAntonio};
        Stream<Persona> stream2 = Arrays.stream(personas1);

        // Utilidades Stream
        Stream<Persona> stream3 = Stream.of(personaAntonio, personaJuan, personaAlberto);
    }

    private List<String> convertStreamVersion(List<Persona> personas){
        // Básicamente es una agrupación de elementos de los que podemos especificar operaciones.
        // el personas.stream(): Equivale la Creación del Stream
        // el map. son Operadores Intermedios
        // .collect Terminaría siendo la OperaciónTerminal.
        return personas.stream()
                //Indicamos queremos realizar una conversión sobre los string.
                .map(persona -> persona.getNombre())
                .collect(Collectors.toList());
        //Ese conjunto de pasos se refiere a StreamPipeline
    }

    private List<String> convertCollectionsVersion(List<Persona> personas){
        List<String> nombres = new ArrayList<>();
        for (Persona persona : personas){
            nombres.add(persona.getNombre());
        }
        return  nombres;
    }


    public void operacionesIntermedias(List<Persona> personas){
        // CONVERTIR
        Stream<String> nombres = personas.stream().map(persona -> persona.getNombre());

        // FILTRAR
        Stream<String> nombresConA = nombres.filter(personaConA -> personaConA.startsWith("A"));

        // ORDENACIÓN
        Stream<String> nombresOrdenados = nombres.sorted((o1, o2) -> o2.length() - o1.length());

        // REDUCE
        Stream<String> todos = Stream.of("Lucia", "José", "Antonio").reduce("", (a, b) -> a + "\n" + b).lines();

        /**
         * Saldrá así:
         * "
         * Lucia
         * José
         * Antonio
         */

        Stream<String> stream = Stream.of("a", "b", "c");

        StringBuilder sb = new StringBuilder();
        stream.forEach(s-> sb.append(s));

    }

    public void agrupaciones(){
        // ANTIGUA
        List<Alumno> alumnos = new ArrayList<>();
        Map<String, List<Alumno>> porEscuela = new HashMap<>();
        for (Alumno alumno : alumnos){
            if (!porEscuela.containsKey(alumno.getEscuela())){
                porEscuela.put(alumno.getEscuela(), new ArrayList<>());
            }
            porEscuela.get(alumno.getEscuela()).add(alumno);
        }

        // NUEVA:
        porEscuela = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getEscuela));

        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer suma = lista.stream().reduce(0, (a, b) -> a+b);
        // Suma: 55
    }
}
