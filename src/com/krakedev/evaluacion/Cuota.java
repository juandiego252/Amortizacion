package com.krakedev.evaluacion;

public class Cuota {
	private int Numero;
	private double cuota;
	private double  Inicio;
	private double interes;
	private double abonoCapital;
	private double saldo;
	
	public Cuota(int numero) {
		Numero = numero;
	}
	public double getCuota() {
		return cuota;
	}
	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
	public double getInicio() {
		return Inicio;
	}
	public void setInicio(double inicio) {
		Inicio = inicio;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public double getAbonoCapital() {
		return abonoCapital;
	}
	public void setAbonoCapital(double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void mostrarPrestamo() {
	    System.out.println("Número\tCuota\tInicio\tInterés\tAbono Capital\tSaldo");

	    for (int i = 1; i <= Numero; i++) {
	        System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n",
	                          i, getCuota(), getInicio(), getInteres(), getAbonoCapital(), getSaldo());
	    }
	}

	
	
}
