/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.george;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author george
 */
public class Main {

    public static void main(String[] args) {

        EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive", "www.easydrive.com");

        easydrive.registrarCliente(new Cliente("X5618927C", "Juan", "González López"));
        easydrive.registrarCliente(new Cliente("Z7568991Y", "Luis", "Fernández Gómez"));
        easydrive.registrarCliente(new Cliente("S5788547M", "Miguel", "Romero Sánchez"));
        easydrive.registrarCliente(new Cliente("P73629635U", "Sara", "Carbonero"));
        easydrive.registrarCliente(new Cliente("C29943753I", "Messi", "Lionel"));

        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang", "Rojo", 150.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true));

        System.out.println("Lista de vehículos");
        easydrive.imprimirVehiculos();

        System.out.println("");

        System.out.println("Lista de clientes");
        easydrive.imprimirClientes();

        System.out.println("");

        // Vamos alquilar algunos vehículos
        easydrive.alquilarVehiculo("4060 TUR", "S5788547M", LocalDate.of(2021, Month.MARCH, 5), 15);
        easydrive.alquilarVehiculo("4090 TUR", "Z7568991Y", LocalDate.of(2021, Month.JULY, 25), 34);
        easydrive.alquilarVehiculo("4070 DEP", "X5618927C", LocalDate.of(2021, Month.FEBRUARY, 15), 3);
        easydrive.alquilarVehiculo("4080 TUR", "P73629635U", LocalDate.of(2021, Month.FEBRUARY, 7), 10);
        easydrive.alquilarVehiculo("4100 FUR", "C29943753I", LocalDate.of(2021, Month.MAY, 4), 2);

        System.out.println("Lista de alquileres");

        easydrive.imprimirAlquileres();

        System.out.println("");

        System.out.println("Lista con las matrículas y la fecha para entregar el vehículo alquilado");
        easydrive.listarMatriculaFechaEntrega();

        System.out.println("------------------");

        System.out.println("Buscamos un cliente a partir de su nif");
        System.out.println(easydrive.buscarCliente("S5788547M"));
        System.out.println("Buscamos un vehículo a partir de su matricula");
        System.out.println(easydrive.buscarVehiculo("4100 FUR"));

        System.out.println("");

        System.out.println("Ordenamos los vehículos por tarifa");

        easydrive.ordenarVehiculosTarifa();

        easydrive.imprimirVehiculos();

        System.out.println("");

        System.out.println("Ordenamos los alquileres por fecha de alquiler");

        easydrive.ordenarAlquileresFechaAlquiler();

        easydrive.imprimirAlquileres();

        System.out.println("");

        System.out.println("Buscamos los alquileres de un cliente");

        System.out.println(easydrive.buscarAlquilerCliente("C29943753I"));
    }
}
