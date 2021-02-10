/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.george;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author george
 */
public class VehiculoAlquilado {

    // Atributos privados de la clase VehículoAlquilado
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaAlquiler;
    private int totalDiasAlquiler;

    // Constructor parametrizado
    public VehiculoAlquilado(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler, int totalDiasAlquiler) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaAlquiler = fechaAlquiler;
        this.totalDiasAlquiler = totalDiasAlquiler;
    }

    // Método para sumar los días y asi saber cuando un cliente tiene que devolver el vehículo que ha alquilado
    public LocalDate obtenerFechaEntrega(LocalDate fecha, long dias) {
        return fecha.plusDays(dias);
    }

    // Métodos getters y setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public int getTotalDiasAlquiler() {
        return totalDiasAlquiler;
    }

    public void setTotalDiasAlquiler(int totalDiasAlquiler) {
        this.totalDiasAlquiler = totalDiasAlquiler;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.vehiculo);
        hash = 97 * hash + Objects.hashCode(this.fechaAlquiler);
        hash = 97 * hash + this.totalDiasAlquiler;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehiculoAlquilado other = (VehiculoAlquilado) obj;
        if (this.totalDiasAlquiler != other.totalDiasAlquiler) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.vehiculo, other.vehiculo)) {
            return false;
        }
        if (!Objects.equals(this.fechaAlquiler, other.fechaAlquiler)) {
            return false;
        }
        return true;
    }

    // Método toString
    @Override
    public String toString() {
        return "VehiculoAlquilado{" + "cliente=" + cliente + ", vehiculo=" + vehiculo + ", fechaAlquiler=" + fechaAlquiler + ", totalDiasAlquiler=" + totalDiasAlquiler + '}';
    }

}
