package com.ejercicios.programacionfuncional.EjerciciosPracticos.ejercicioPractico3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestPelicula {

    public static void main(String[] args) {

        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("El Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("Atarvatan", "Kevin Edy", 2018));
        peliculas.add(new Pelicula("Henry Porras", "ChanElGenio", 2014));
        peliculas.add(new Pelicula("Bananero", "El Bananero", 2017));
        peliculas.add(new Pelicula("El banano", "El Bananero", 2017));
        peliculas.add(new Pelicula("Ripia", "Elvert Galarga", 2011));

        //TODO: Obtener un listado de las películas estrenadas después o igual del 2014
        System.out.println("-------------------------------------- Despues2014");
        List<Pelicula> peliculasDespues2014 = peliculas.stream()
                .filter(pelicula -> pelicula.getEstreno() >= 2014)
                .collect(Collectors.toList());
        peliculasDespues2014.forEach(System.out::println);

        //TODO: Obtener un listado de las películas estrenadas después o igual del 2014
        System.out.println("--------------------------------------MostrarPeliculasMismoDirector");
        String peliculasMismoDirector = peliculas.stream()
                .filter(pelicula -> pelicula.getDirector().equals("El Bananero"))
                .map(t -> t.getTitulo())
                .collect(Collectors.toList()).toString();
        System.out.println(peliculasMismoDirector);


        //TODO: Obtener un listado nombres peliculas ordenados alfabeticamente
        System.out.println("--------------------------------------Orden Alfabetico");
        List<String> peliculasOrdenAlfabetico = peliculas.stream()
                        .map(pelicula -> pelicula.getTitulo())
                .sorted((peli1, peli2) -> peli1.compareTo(peli2))
                        .collect(Collectors.toList());
        peliculasOrdenAlfabetico.forEach(peli -> System.out.println(peli));


        //TODO: Mostrar pelicula recien estrenada.
        System.out.println("--------------------------------------Recién estrenada.");
        Optional<Pelicula> peliculasRecienEstrenadas = peliculas.stream()
                .max((peli1, peli2) -> Integer.compare(peli1.getEstreno(), peli2.getEstreno()));

        String peliculaEstrenada = (peliculasRecienEstrenadas.isPresent())
                ? String.valueOf(peliculasRecienEstrenadas.get()) : " No se encontró";

        System.out.println(peliculaEstrenada);
    }

}
