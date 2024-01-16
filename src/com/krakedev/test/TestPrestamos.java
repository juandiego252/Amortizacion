package com.krakedev.test;

import java.util.ArrayList;

import com.krakedev.evaluacion.Banco;
import com.krakedev.evaluacion.CalculadoraAmortizacion;
import com.krakedev.evaluacion.Cliente;
import com.krakedev.evaluacion.Prestamo;

public class TestPrestamos {

	public static void main(String[] args) {
		Banco banco = new Banco();

		Cliente cliente1 = new Cliente("1234567890", "Juan", "Perez");

		Cliente cliente2 = new Cliente("0987654321", "Maria", "Lopez");

		banco.getClientes().add(cliente1);
		banco.getClientes().add(cliente2);

		Prestamo prestamo1 = new Prestamo(4000.0, 12.1, 16);
		banco.asignarPrestamo("1234567890", prestamo1);
		CalculadoraAmortizacion.generarTabla(prestamo1);

		Prestamo prestamo2 = new Prestamo(50000.1, 10.0, 11);
		banco.asignarPrestamo("1234567890", prestamo2);

		Prestamo prestamo3 = new Prestamo(2000.0, 8.0, 14);
		banco.asignarPrestamo("0987654321", prestamo3);

		ArrayList<Prestamo> prestamosCliente1 = banco.buscarPrestamos("1234567890");
		for (Prestamo prestamo : prestamosCliente1) {
			cliente1.mostrarCliente();
			prestamo.mostrarPrestamo();
		}
		ArrayList<Prestamo> prestamosCliente2 = banco.buscarPrestamos("0987654321");
		for (Prestamo prestamo : prestamosCliente2) {
			cliente2.mostrarCliente();
			prestamo.mostrarPrestamo();
		}

	}

}
