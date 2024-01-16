package com.krakedev.test;

import com.krakedev.evaluacion.CalculadoraAmortizacion;
import com.krakedev.evaluacion.Prestamo;

public class TestCalculadora2 {

	public static void main(String[] args) {	
        Prestamo prestamo = new Prestamo(5000.0, 12.0, 15);

        CalculadoraAmortizacion.generarTabla(prestamo);
        CalculadoraAmortizacion.mostrarTabla(prestamo);

	}

}
