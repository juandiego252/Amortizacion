package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Banco {
	private ArrayList<Prestamo> prestamos;
    private ArrayList<Cliente> clientes;

    public Banco() {
        this.prestamos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }
    public void registrarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            System.out.println("El cliente ya existe.");
        }
    }
    public void asignarPrestamo(String cedulaCliente, Prestamo prestamo) {
        Cliente cliente = buscarCliente(cedulaCliente);
        if (cliente != null) {
            CalculadoraAmortizacion.generarTabla(prestamo); // Supongamos que hay un método generarTablaAmortizacion en la clase Prestamo
            agregarPrestamo(prestamo);
        } else {
            System.out.println("No es cliente del banco.");
        }
    }

    public ArrayList<Prestamo> buscarPrestamos(String cedulaCliente) {
        Cliente cliente = buscarCliente(cedulaCliente);
        if (cliente != null) {
            ArrayList<Prestamo> prestamosCliente = new ArrayList<>();
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getCliente().equals(cliente)) {
                    prestamosCliente.add(prestamo);
                }
            }
            return prestamosCliente;
        } else {
            return null;
        }
    }

}
