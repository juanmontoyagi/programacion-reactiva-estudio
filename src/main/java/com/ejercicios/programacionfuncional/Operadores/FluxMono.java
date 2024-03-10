package com.ejercicios.programacionfuncional.Operadores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Objects;

public class FluxMono {

    private static final Logger LOGGER = LoggerFactory.getLogger(FluxMono.class);

    public static void main(String[] args) throws Exception {
        metodoFlux();
    }

    public static void metodoFlux() throws Exception {
        //Flux<String> nombres = Flux.just("Andres", "Jairo", "Diego", "Juan")
        //        .doOnNext(elemento -> System.out.println(elemento));

        Flux<String> nombres = Flux.just("Andres", "Maria","Jairo", "Diego", "Juan")
                .map(nombreEnMayuscula -> {
                    return nombreEnMayuscula.toUpperCase();
                })
                .doOnNext(elemento -> {
                    if (elemento.isEmpty()){
                        throw new RuntimeException("ERROR: Nombre vacio. ");
                    }
                    System.out.println(elemento);
                })
                // Tener presente que se ejecuta primero la impresión en consola y después se convierte en mayúscula.
                // Pero sí coloco el map arriba, se convirtirá primero a mayúscula o minúscula y después se imprime.
                .map(nombreEnMayuscula -> {
                    return nombreEnMayuscula.toLowerCase();
                });

        /**
         * El método subscribe permite observar los cambios que tenga flujo Flux y notificarnos.
         * El LOGGER::info permite imprimirlo en la consola lo que ocurre.
         */
        //nombres.subscribe(LOGGER::info);

        // Usando expresión lambda sería:
        nombres.subscribe(e -> LOGGER.info(e),
                error -> LOGGER.error(error.getLocalizedMessage()),
                new Runnable() {
                    @Override
                    public void run() {
                        // Sí hay algún nombre vacío, está parte no se ejecuta.
                        LOGGER.info("Se finalizo la ejecucion. ");
                    }
                });

        // OTRA FORMA DE SIMPLIFICAR EL CÓDIGO SERÍA:
        // System.out::println
    }

    private static void operadoresClase(){
        Flux<Usuario> nombres = Flux.just("Andres", "Maria","Jairo", "Diego", "Juan")
                .map(nombreEnMayuscula -> new Usuario(nombreEnMayuscula.toUpperCase(), null))
                .doOnNext(usuario -> {
                    if (Objects.isNull(usuario)){
                        throw new RuntimeException("ERROR: Nombre vacio. ");
                    }
                    System.out.println(usuario.getNombre());
                })
                .map(usuario -> {
                    String nombreMinuscula = usuario.getNombre().toLowerCase();
                    usuario.setNombre(nombreMinuscula);
                    return usuario;
                });

        nombres.subscribe(e -> LOGGER.info(e.getNombre()),
                error -> LOGGER.error(error.getLocalizedMessage()),
                new Runnable() {
                    @Override
                    public void run() {
                        // Sí hay algún nombre vacío, está parte no se ejecuta.
                        LOGGER.info("Se finalizo la ejecucion. ");
                    }
                });
    }
}
