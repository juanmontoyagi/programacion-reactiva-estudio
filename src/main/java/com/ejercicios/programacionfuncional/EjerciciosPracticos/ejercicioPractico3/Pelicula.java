package com.ejercicios.programacionfuncional.EjerciciosPracticos.ejercicioPractico3;

public class Pelicula {

    private String titulo;
    private String director;
    private int estreno;

    public Pelicula(String titulo, String director, int estreno) {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", estreno=" + estreno +
                '}';
    }
}
