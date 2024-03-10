package com.ejercicios.programacionfuncional.Operadores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FluxMono {

    private static final Logger LOGGER = LoggerFactory.getLogger(FluxMono.class);

    public static void main(String[] args) throws Exception {
        //metodoFlux();
        ejemploUsuarioComentario();
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

    private static void operadoresClaseFilter(){
        Flux<Usuario> nombres = Flux.just("Andres Guzman", "Maria Becerra","Jairo Bermudez", "Diego Perez", "Juan Perez", "Bruce Willis", "Bruce Lee")
                .map(nombreEnMayuscula -> new Usuario(nombreEnMayuscula.split(" ")[0].toUpperCase(), nombreEnMayuscula.split(" ")[1].toUpperCase()))
                // Forma Corta: .filter(usuarioFiltrado -> usuarioFiltrado.getApellido().toLowerCase().equals("perez"))
                .filter(usuarioFiltrado -> {
                    return usuarioFiltrado.getApellido().toLowerCase().equals("perez");
                })
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

    private static void listIterableFlatMap(){
        List<String> usuariosList = Arrays.asList("Juan Hernandez", "Hector Leon", "Albert Galarga");
        Flux.fromIterable(usuariosList)
                .map(nombre -> new Usuario(nombre.split(" ")[0].toUpperCase(), nombre.split(" ")[1].toUpperCase()))
                .flatMap(usuario -> {
                    if (usuario.getNombre().equalsIgnoreCase("Juan")){
                        return Mono.just(usuario);
                    } else {
                        return Mono.empty();
                    }
                }).subscribe(u -> LOGGER.info(u.toString()));
        // Un flatMap básicamente aplana y une a un mismo flujo.
    }

    private static void listIterableFlatMapConvertToString(){
        List<Usuario> usuariosList = Arrays.asList(new Usuario("Juan", "Hernandez"),
                new Usuario("Dayro", "Moreno"), new Usuario("Elvert", "Galarga"));

        Flux.fromIterable(usuariosList)
                .map(usuario -> usuario.getNombre().toUpperCase().concat(" ").concat(usuario.getApellido().toUpperCase()))
                .flatMap(nombre -> {
                    if (nombre.contains("Juan".toUpperCase())){
                        return Mono.just(nombre);
                    } else {
                        return Mono.empty();
                    }
                }).subscribe(u -> LOGGER.info(u.toString()));
        // Un flatMap básicamente aplana y une a un mismo flujo.
    }

    private static void ejemploCollectList(){
        List<Usuario> usuariosList = Arrays.asList(new Usuario("Juan", "Hernandez"),
                new Usuario("Dayro", "Moreno"), new Usuario("Elvert", "Galarga"));

        Flux.fromIterable(usuariosList)
                .collectList()
                .subscribe(lista -> {
                    lista.forEach(item -> LOGGER.info(item.toString()));
                });
    }

    private static void ejemploUsuarioComentario(){

        Mono<Usuario> usuarioMono = Mono.fromCallable(() -> new Usuario("John", "Doe"));

        Mono<Comentario> comentarioMono = Mono.fromCallable(() -> {
            Comentario comentarios = new Comentario();
            comentarios.addComentario("Hola");
            comentarios.addComentario("bien");
            comentarios.addComentario("o que?");
            return comentarios;
        });

        usuarioMono.flatMap(usuario -> comentarioMono.map(comentario -> new UsuarioComentario(usuario, comentario)))
                .subscribe(usuarioComentario -> LOGGER.info(usuarioComentario.toString()));

    }
}
