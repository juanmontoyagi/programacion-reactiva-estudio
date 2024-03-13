package com.ejercicios.programacionfuncional.EjerciciosPracticos.ejercicioPractico2;

import com.ejercicios.programacionfuncional.EjerciciosPracticos.ejercicioPractico1.TestAlumno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestVehiculo {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestVehiculo.class);
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("ABC123", Modelo.AUDI, 10000));
        vehiculos.add(new Vehiculo("ABC234", Modelo.RENAULT, 20000));
        vehiculos.add(new Vehiculo("ABC345", Modelo.HONDA, 30000));
        vehiculos.add(new Vehiculo("ABC542", Modelo.CHEVROLET, 40000));
        vehiculos.add(new Vehiculo("ABC142", Modelo.BMW, 50000));
        vehiculos.add(new Vehiculo("ABC141", Modelo.KIA, 20000));
        vehiculos.add(new Vehiculo("ABC161", Modelo.BMW, 30000));
        vehiculos.add(new Vehiculo("ABC171", Modelo.AUDI, 10000));

        //TODO: Listar los kilometros de cada vehiculo y multiplicarlo por dos.
        vehiculos.stream().forEach(vehiculo -> {
            int kilometros = vehiculo.getKilometros()*2;
            vehiculo.setKilometros(kilometros);
            LOGGER.info("Vehiculo: "+vehiculo.toString());
        });

        //Otra forma:

        List<Integer> resultadoKilometros = vehiculos.stream()
                .map(vehiculo -> vehiculo.getKilometros()+2)
                .collect(Collectors.toList());
        resultadoKilometros.forEach(System.out::println);

        System.out.println("------------------------------------------");
        //TODO: Listar los kilometros de todos los vehiculos
        List<Integer> resultadosKilometros2 = vehiculos.stream()
                .map(Vehiculo::getKilometros)
                .collect(Collectors.toList());
        resultadosKilometros2.forEach(System.out::println);

        System.out.println("------------------------------------------");
        //TODO: Listar los vehiculos con modelo AUDI
        List<Vehiculo> vehiculoList = vehiculos.stream()
                .filter(vehiculo -> Modelo.AUDI.equals(vehiculo.getModelo()))
                .collect(Collectors.toList());
        vehiculoList.forEach(System.out::println);

        System.out.println("------------------------------------------");
        //TODO: Listar los vehiculos ordenados por cantidad de kilometros.
        List<Vehiculo> vehiculoListCantidadKilometros = vehiculos.stream()
                .sorted((vehiculo1, vehiculo2) -> Integer.compare(vehiculo1.getKilometros(), vehiculo2.getKilometros()))
                .collect(Collectors.toList());
        vehiculoListCantidadKilometros.forEach(System.out::println);

        System.out.println("------------------------------------------");
        //TODO: Listar los vehiculos sin que se repitan.
        List<Modelo> vehiculoListSinQueSeRepitan = vehiculos.stream()
                        .map(Vehiculo::getModelo)
                                .distinct().collect(Collectors.toList());

        vehiculoListSinQueSeRepitan.forEach(System.out::println);

        System.out.println("------------------------------------------ 20mil");
        //TODO: Listar los vehiculos con más de 20mil kilometros
        List<Vehiculo> vehiculoListMayor200milKilometros
                = vehiculos.stream().filter(vehiculo -> vehiculo.getKilometros() > 20000)
                .collect(Collectors.toList());
        vehiculoListMayor200milKilometros.forEach(System.out::println);

        System.out.println("------------------------------------------ AgrupadoModelo");
        //TODO: Listar los vehiculos agrupado por modelos
        Map<Modelo, List<Vehiculo>> vehiculoAgrupadoModelos = vehiculos.stream()
                .collect(Collectors.groupingBy(Vehiculo::getModelo));

        vehiculoAgrupadoModelos.forEach((modelo, vehiculo) -> {
            System.out.println("Modelo: "+modelo);
            vehiculo.forEach(System.out::println);
        });

        System.out.println("------------------------------------------ SumaTotalKilometros");
        //TODO: Sumar todos los kilometros
        int sumaTotal = vehiculos.stream()
                .map(vehiculo -> vehiculo.getKilometros())
                .reduce(0, Integer::sum);
        System.out.println("Suma total: "+sumaTotal);

        System.out.println("------------------------------------------ Listar2Vehiculos");
        //TODO: Listar 2 vehiculos con kilometros menores o iguales a 30000;
        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getKilometros() <= 30000)
                .map(Vehiculo::getModelo)
                .distinct()
                .limit(2)
                .forEach(System.out::println);


    }

}
