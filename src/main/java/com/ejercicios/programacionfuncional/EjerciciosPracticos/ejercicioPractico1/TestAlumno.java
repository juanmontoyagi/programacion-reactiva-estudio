package com.ejercicios.programacionfuncional.EjerciciosPracticos.ejercicioPractico1;

import com.ejercicios.programacionfuncional.Operadores.FluxMono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TestAlumno {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestAlumno.class);
    public static void main(String[] args) {

        List<Alumno> alumnos = new ArrayList<>();

        alumnos.add(new Alumno(1, "123", "Juan", "Montoya", "Espanol", 4.8, 24));
        alumnos.add(new Alumno(2, "1234", "Andres", "Herrera", "Ingles", 3.8, 22));
        alumnos.add(new Alumno(3, "1235", "Santiago", "Quiroga", "Matematicas", 2.8, 23));
        alumnos.add(new Alumno(4, "1236", "Laura", "Velez", "Quimica", 3.1, 21));
        alumnos.add(new Alumno(4, "12367", "Maria", "Velez", "Quimica", 3.2, 21));
        alumnos.add(new Alumno(4, "12367", "Jose", "Quiroga", "Ingles", 3.2, 20));

        LOGGER.info("------------------------------------");
        // TODO: Listar todos los alumnos.
        alumnos.stream().forEach(alumno -> {
            LOGGER.info("Estudiante: "+alumno.toString());
        });

        LOGGER.info("------------------------------------");

        // TODO: Listar todos los alumnos que empiecen por J.
        alumnos.stream().filter(alumno -> alumno.getNombre().startsWith("J") || alumno.getNombre().startsWith("A"))
                .forEach(alumnoFiltrado -> {
                    LOGGER.info("Estudiante: "+alumnoFiltrado.toString());
                });

        LOGGER.info("------------------------------------");

        // TODO: Listar la cantidad de alumnos que hay.
        LOGGER.info("Cantidad de Alumnos: "+alumnos.stream().count());

        LOGGER.info("------------------------------------");
        // TODO: Listar alumno de menor edad.
        LOGGER.info("Alumno menor: "
                +alumnos.stream().min((alumno1, alumno2) -> alumno1.getEdad() - alumno2.getEdad()));

        LOGGER.info("------------------------------------");

        // TODO: Listar alumno de mayor edad.
        LOGGER.info("Alumno mayor: "
                +alumnos.stream().max((alumno1, alumno2) -> alumno1.getEdad() - alumno2.getEdad()));

        LOGGER.info("------------------------------------");

        // TODO: Listar el primer alumno.
        LOGGER.info("El primer alumno: "
                +alumnos.stream().findFirst());
        LOGGER.info("------------------------------------");

        // TODO: Listar alumnos de clase Quimica.
        alumnos.stream().filter(claseQuimica -> claseQuimica.getNombreCurso().equals("Quimica"))
                        .forEach(alumno -> {
                            LOGGER.info("Alumno de la clase: "+alumno.toString());
                        });
        LOGGER.info("------------------------------------");

        // TODO: Listar alumnos que la clase comience por I.
        alumnos.stream().filter(claseFiltrada -> claseFiltrada.getNombreCurso().startsWith("I"))
                .forEach(alumno -> {
                    LOGGER.info("Alumno de la clase: "+alumno.toString());
                });
        LOGGER.info("------------------------------------");

        // TODO: Listar alumnos que su nombre tenga mas de 7 letras..
        alumnos.stream().filter(alumno -> alumno.getNombre().length() > 7)
                .forEach(alumno -> LOGGER.info("Alumno: "+alumno.toString()));
        LOGGER.info("------------------------------------");

    }
}
