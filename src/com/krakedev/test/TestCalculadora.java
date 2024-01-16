package com.krakedev.test;

import com.krakedev.evaluacion.CalculadoraAmortizacion;
import com.krakedev.evaluacion.Prestamo;

public class TestCalculadora {

	public static void main(String[] args) {
        Prestamo prestamo = new Prestamo(5000.00, 12.0, 12);

        CalculadoraAmortizacion.generarTabla(prestamo);
        CalculadoraAmortizacion.mostrarTabla(prestamo);

	}

}
