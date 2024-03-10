package com.ejercicios.programacionfuncional.Operadores;

import java.util.ArrayList;
import java.util.List;

public class Comentario {

    private List<String> comentarios;

    public Comentario(){
        this.comentarios = new ArrayList<>();
    }

    public void addComentario(String comentario) {
        this.comentarios.add(comentario);
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "comentarios=" + comentarios +
                '}';
    }
}
