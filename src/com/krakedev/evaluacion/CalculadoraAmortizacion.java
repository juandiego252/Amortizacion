package com.krakedev.evaluacion;

public class CalculadoraAmortizacion {

	public static double calcularCuota(double monto, double interes, int plazo) {
		double tasaInteresMensual = interes / 100 / 12;

		double cuotaMensual = (monto * tasaInteresMensual) / (1 - Math.pow(1 + tasaInteresMensual, -plazo));

		return cuotaMensual;
	}
	public static void generarTabla(Prestamo prestamo) {
        double cuotaMensual = calcularCuota(prestamo.getMonto(), prestamo.getInteres(), prestamo.getPlazo());

        for (int i = 0; i < prestamo.getPlazo(); i++) {
            prestamo.getCuotas()[i] = new Cuota(i + 1);
            prestamo.getCuotas()[i].setCuota(cuotaMensual);
        }

        prestamo.getCuotas()[0].setInicio(prestamo.getMonto());

        // Calcular valores de cada cuota
        for (int i = 0; i < prestamo.getPlazo() - 1; i++) {
            calcularValoresCuota(prestamo.getInteres(), prestamo.getCuotas()[i], prestamo.getCuotas()[i + 1]);
        }

        Cuota ultimaCuota = prestamo.getCuotas()[prestamo.getPlazo() - 1];
        ultimaCuota.setSaldo(ultimaCuota.getSaldo() + ultimaCuota.getInicio());

        prestamo.getCuotas()[0].mostrarPrestamo();
    }
	

	private static void calcularValoresCuota(double interes, Cuota cuotaActual, Cuota cuotaSiguiente) {
    	// Calcular el valor del interés para la cuota actual
        double interesCuota = cuotaActual.getSaldo() * (interes / 100) / 12;

        // Calcular el abono del capital para la cuota actual
        double abonoCapital = cuotaActual.getCuota() - interesCuota;

        // Calcular el saldo para la cuota actual
        double saldoCuota = cuotaActual.getSaldo() - abonoCapital;

        // Asignar estos valores a los atributos correspondientes en el objeto Cuota
        cuotaActual.setInteres(interesCuota);
        cuotaActual.setAbonoCapital(abonoCapital);
        cuotaActual.setSaldo(saldoCuota);

        // Establecer el saldo de la cuota actual como el valor al inicio del período para la siguiente cuota
        if (cuotaSiguiente != null) {
            cuotaSiguiente.setInicio	(cuotaActual.getSaldo());
            }
	}
	
    public static void mostrarTabla(Prestamo prestamo) {
        for (Cuota cuota : prestamo.getCuotas()) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n",
                    cuota.getCuota(), cuota.getInicio(),
                    cuota.getInteres(), cuota.getAbonoCapital(), cuota.getSaldo());
        }
    }
}
