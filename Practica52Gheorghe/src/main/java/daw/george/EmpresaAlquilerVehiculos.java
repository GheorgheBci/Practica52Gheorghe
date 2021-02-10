/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.george;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author george
 */
public class EmpresaAlquilerVehiculos {

    // Atributos de la empresa
    private String cif;
    private String nombre;
    private String paginaWeb;

    private ArrayList<Cliente> clientes;

    private ArrayList<Vehiculo> vehiculos;

    private ArrayList<VehiculoAlquilado> alquileres;

    private ArrayList<VehiculoAlquilado> alquileresTerminados;

    // Constructor parametrizado
    EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        alquileres = new ArrayList<>();
        alquileresTerminados = new ArrayList<>();
    }

    // Método que imprime las matrículas y las fechas de entrega del vehículo alquilado
    public void listarMatriculaFechaEntrega() {
        for (VehiculoAlquilado alquilere : alquileres) {
            System.out.println("Matrícula: " + alquilere.getVehiculo().getMatricula()
                    + "\t Fecha de entrega: " + alquilere.obtenerFechaEntrega(alquilere.getFechaAlquiler(), alquilere.getTotalDiasAlquiler()));
        }
    }

    // Método para añadir un nuevo cliente
    public void registrarCliente(Cliente nuevo) {
        clientes.add(nuevo);
    }

    // Método que busca un cliente a partir de su nif
    public Cliente buscarCliente(String nif) {
        for (Cliente aux : clientes) {

            if (nif.equals(aux.getNif())) {
                return aux;
            }
        }
        return null;
    }

    // Método para imprimir un cliente
    public void imprimirClientes() {
        clientes.forEach(System.out::println);
    }

    // Método para añadir un nuevo vehículo
    public void registrarVehiculo(Vehiculo nuevo) {
        vehiculos.add(nuevo);
    }

    // Método que busca un vehículo a partir de la matricula
    public Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo aux : vehiculos) {

            if (matricula.equals(aux.getMatricula())) {
                return aux;
            }
        }
        return null;
    }

    // Método para imprimir un vehículo
    public void imprimirVehiculos() {
        vehiculos.forEach(System.out::println);
    }

    // Método para alquilar un vehículo 
    public boolean alquilarVehiculo(String matricula, String nif, LocalDate fechaAlquiler, int dias) {
        // busca el cliente a partir de la posición
        Cliente cliente = buscarCliente(nif);

        // busca el vehículo a partir de la posición
        Vehiculo vehiculo = buscarVehiculo(matricula);

        if (cliente != null && vehiculo != null) {
            if (vehiculo.isDisponible()) {
                vehiculo.setDisponible(false);
                alquileres.add(new VehiculoAlquilado(cliente, vehiculo, fechaAlquiler, dias));

                return true; // El alquiler se realiza correctamente
            }
        }
        return false; // No se puede alquilar el vehiculo por el cliente
    }

    // Método para imprimir los vehículos que han sido alquilados
    public void imprimirAlquileres() {
        alquileres.forEach(System.out::println);
    }

    // Método para cambiar la disponibilidad de un vehículo para que se pueda alquilar
    public void recibirVehiculo(String matricula) {
        // busca el vehículo con la matrícula dada en el
        // array vehiculos y modifica su disponibilidad
        // para que se pueda alquilar de nuevo
        Vehiculo vehiculo = buscarVehiculo(matricula);

        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }
    }

    // Método que eliminará el alquiler que pasemos por parametros y luego ese alquiler lo 
    // guardamos en una nueva lista de alquileres terminados. A continuación cambiamos la disponibilidad 
    // del vehículo usando el método recibirVehiculo().
    public void finalizarAlquiler(VehiculoAlquilado alquiler) {
        alquileresTerminados.add(alquiler);
        alquileres.remove(alquiler);

        recibirVehiculo(alquiler.getVehiculo().getMatricula());
        
        // hacer calcular los días reales
    }

    // Método para ordenar el cliente por el nombre
    public void ordenarClienteNombre() {
        Comparator<Cliente> criterio = (c1, c2) -> c1.getNombre().compareTo(c2.getNombre());

        Collections.sort(clientes, criterio);
    }

    // Método para ordenador el cliente por el nif
    public void ordenarClienteNif() {
        Comparator<Cliente> criterio = (c1, c2) -> c1.getNif().compareTo(c2.getNif());

        Collections.sort(clientes, criterio);
    }

    // Método para ordenar un vehículo a partir de su tarifa
    public void ordenarVehiculosTarifa() {
        Comparator<Vehiculo> criterio = (v1, v2) -> v1.getTarifa().compareTo(v2.getTarifa());

        Collections.sort(vehiculos, criterio);
    }

    // Método para ordenar un vehículo a partir de su matrícula
    public void ordenarVehiculosMatricula() {
        Comparator<Vehiculo> criterio = (v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula());

        Collections.sort(vehiculos, criterio);
    }

    // Método para ordenar un alquiler a partir de fecha de alquiler
    public void ordenarAlquileresFechaAlquiler() {
        Comparator<VehiculoAlquilado> criterio = (va1, va2) -> va1.getFechaAlquiler().compareTo(va2.getFechaAlquiler());

        Collections.sort(alquileres, criterio);
    }

    // Método para ordenar un alquiler a partir del nif del cliente
    public void ordenarAlquileresNif() {
        Comparator<VehiculoAlquilado> criterio = (va1, va2) -> va1.getCliente().getNif().compareTo(va2.getCliente().getNif());

        Collections.sort(alquileres, criterio);
    }

    // Método para ordenar un alquiler a partir de la matrícula del vehículo
    public void ordenarAlquileresMatricula() {
        Comparator<VehiculoAlquilado> criterio = (va1, va2) -> va1.getVehiculo().getMatricula().compareTo(va2.getVehiculo().getMatricula());

        Collections.sort(alquileres, criterio);
    }

    // Método para buscar un cliente a partir de su nif
    public int buscarPorNif(Cliente aux) {
        Comparator<Cliente> criterio = (c1, c2) -> c1.getNif().compareTo(c2.getNif());

        int posicion = Collections.binarySearch(clientes, aux, criterio);

        return posicion;
    }
    
//    public ArrayList b(Cliente c){
//        ArrayList<VehiculoAlquilado> listaCliente = new ArrayList<>();
//    }

    // Método para buscar un vehículo a partir de su matrícula
    public int buscarPorMatricula(Vehiculo aux) {
        Comparator<Vehiculo> criterio = (v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula());

        int posicion = Collections.binarySearch(vehiculos, aux, criterio);

        return posicion;
    }

    // Método para buscar todos los alquileres que esten activos del cliente que indiquemos por parametros
    public VehiculoAlquilado buscarAlquilerCliente(String nif) {
        for (VehiculoAlquilado alquiler : alquileres) {

            if (nif.equals(alquiler.getCliente().getNif())) {
                return alquiler;
            }
        }
        return null;
    }

    // Método que imprime el nif del cliente, matrícula del vehículo, la fecha tanto del alquiler como 
    // de la fecha de entrega y las ganancias
    public void imprimirAlquilerFinalizado() {
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

        for (VehiculoAlquilado aux : alquileresTerminados) {
            System.out.println("NIF CLIENTE: " + aux.getCliente().getNif() + " MATRICULA VEHICULO: "
                    + aux.getVehiculo().getMatricula() + " Desde " + fecha.format(aux.getFechaAlquiler())
                    + " hasta " + fecha.format(aux.obtenerFechaEntrega(aux.getFechaAlquiler(), aux.getTotalDiasAlquiler()))
                    + "Ganancia: " + ((aux.getTotalDiasAlquiler() * aux.getVehiculo().getTarifa())));
        }
    }

    // Métodos getters y setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
}
