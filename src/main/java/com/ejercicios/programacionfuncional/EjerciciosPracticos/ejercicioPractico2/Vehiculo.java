package com.ejercicios.programacionfuncional.EjerciciosPracticos.ejercicioPractico2;

public class Vehiculo {

    private String matricula;
    private Modelo modelo;
    private int kilometros;

    public Vehiculo(String matricula, Modelo modelo, int kilometros) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.kilometros = kilometros;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", modelo=" + modelo +
                ", kilometros=" + kilometros +
                '}';
    }
}
