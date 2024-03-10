package com.ejercicios.programacionfuncional.Ejercicio3;

public class Alumno {

    private String nombre;

    private Escuela escuela;

    public Alumno(String nombre, Escuela escuela) {
        this.nombre = nombre;
        this.escuela = escuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuela() {
        return escuela.toString();
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
}
