package com.aaq.col.clases.util;

import java.text.DecimalFormat;

public class DecimalFormatoUtil {

	private final DecimalFormat formatea = new DecimalFormat("###,###,###.##");

	
	public String obtenerCifra(String cifra, String tipoMoneda) {
		String resultado = null;
		try {
			 resultado = this.obtenerDecimal(cifra)+" "+tipoMoneda;
		} catch (  ArithmeticException| IllegalArgumentException e) {
		}
		return resultado;
	}
	
	 public synchronized String obtenerDecimal(String dato) {
		 String formatoC = null;
			 try {
				 formatoC =  formatea.format(Double.parseDouble(dato));
				 return formatoC;
			 } catch ( ArithmeticException| IllegalArgumentException e) {
			}
		return formatoC;
		
		}
}
