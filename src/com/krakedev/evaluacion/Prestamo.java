package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Prestamo {
	private Double Monto;
	private Double Interes;
	private int Plazo;
	private Cuota[] cuotas;
	private Cliente cliente;
	
	public Prestamo(Double monto, Double interes, int plazo) {
		Monto = monto;
		Interes = interes;
		Plazo = plazo;
		this.cuotas = new Cuota[plazo];
		CalculadoraAmortizacion.generarTabla(this);
	}

	public Double getMonto() {
		return Monto;
	}

	public void setMonto(Double monto) {
		Monto = monto;
	}

	public Double getInteres() {
		return Interes;
	}

	public void setInteres(Double interes) {
		Interes = interes;
	}

	public int getPlazo() {
		return Plazo;
	}

	public void setPlazo(int plazo) {
		Plazo = plazo;
	}

    public Cuota[] getCuotas() {
        return cuotas;
    }

	public Cliente getCliente() {
		return cliente;
	}
	
	
    public void mostrarPrestamo() {
        System.out.println("Número\tCuota\tInicio\tInterés\tAbono Capital\tSaldo");

    }
    
	
	
	
	
	

}
