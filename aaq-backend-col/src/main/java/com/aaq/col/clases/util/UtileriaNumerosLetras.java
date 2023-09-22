package com.aaq.col.clases.util;

import java.io.Serializable;

import org.apache.commons.lang3.*;
import java.text.*;


public class UtileriaNumerosLetras implements Serializable {
	
	private static final long serialVersionUID = -5941200036413835872L;

    private static final String[] Unidad;
    private static final String[] Decena;
    private static final String[] Centena;
    
    public static String toLetras(final double Numero, String tipoMoneda) {
//        final long numeroLong = (long)(Object)new Double(Numero);
    	try {
    	final long numeroLong = (new Double(Numero).longValue());
        return StringUtils.upperCase(StringUtils.replace(resolverIntervalo(numeroLong), "  ", " ")) + decimales(Numero) + "/100 " +tipoMoneda;
    	} catch (NumberFormatException | IndexOutOfBoundsException | ClassCastException e) {
		}
    	return "";
    }
    
    private static String decimales(final double Numero) {
        final StringBuffer buffer = new StringBuffer();
        NumberFormat.getCurrencyInstance().format(Numero, buffer, new FieldPosition(0));
        final String theStringNumber = new String(buffer);
        if (StringUtils.indexOf((CharSequence)theStringNumber, (CharSequence)".") > 0) {
            return StringUtils.substring(theStringNumber, StringUtils.indexOf((CharSequence)theStringNumber, (CharSequence)".") + 1, StringUtils.length((CharSequence)theStringNumber));
        }
        return "";
    }
    
    private static String getUnidad(final long Numero) {
        String aux = "";
        for (int p = 0; p <= 20; ++p) {
            if (Numero == p) {
                aux = UtileriaNumerosLetras.Unidad[p] + ' ';
                return aux;
            }
        }
        return " ";
    }
    
    private static String getDecena(final long Numero) {
        String aux = "";
        final long pf = Numero % 10L;
        final long pi = Numero / 10L;
        int p = 0;
        for (boolean sal = false; p <= 8 & !sal; ++p) {
            if (pi == p + 2) {
                aux = UtileriaNumerosLetras.Decena[p];
                sal = true;
            }
        }
        if (pf == 0L) {
            return aux + ' ';
        }
        if (Numero > 20L & Numero < 30L) {
            return aux + getUnidad(pf) + ' ';
        }
        return aux + " y " + getUnidad(pf) + ' ';
    }
    
    private static String getCentena(final long Numero) {
        String aux = "";
        String aux2 = "";
        final long pf = Numero % 100L;
        final long pi = Numero / 100L;
        int p = 0;
        for (boolean sal = false; p <= 10 & !sal; ++p) {
            if (pi == p + 1) {
                aux = UtileriaNumerosLetras.Centena[p];
                sal = true;
            }
        }
        if (pf == 0L) {
            return aux;
        }
        if (pf < 21L) {
            aux2 = getUnidad(pf);
        }
        else {
            aux2 = getDecena(pf);
        }
        if (Numero < 200L) {
            return aux + "to " + aux2 + ' ';
        }
        return aux + ' ' + aux2 + ' ';
    }
    
    private static String getMil(final long Numero) {
        String aux = "";
        final long pf = Numero % 1000L;
        final long pi = Numero / 1000L;
        if (Numero == 1000L) {
            return "MIL";
        }
        if (Numero > 1000L & Numero < 1999L) {
            aux = UtileriaNumerosLetras.Centena[9] + ' ';
        }
        else {
            aux = resolverIntervalo(pi) + UtileriaNumerosLetras.Centena[9] + ' ';
        }
        if (pf != 0L) {
            return aux + resolverIntervalo(pf) + ' ';
        }
        return aux;
    }
    
    private static String getMillon(final long Numero) {
        String aux = "";
        final long pf = Numero % 1000000L;
        final long pi = Numero / 1000000L;
        if (Numero > 1000000L & Numero < 1999999L) {
            aux = UtileriaNumerosLetras.Centena[10] + ' ';
        }
        else {
            aux = resolverIntervalo(pi) + UtileriaNumerosLetras.Centena[11] + ' ';
        }
        if (pf != 0L) {
            return aux + resolverIntervalo(pf) + ' ';
        }
        return aux;
    }
    
    private static String getBillon(final long Numero) {
        String aux = "";
        final long pf = Numero % 1000000000L;
        final long pi = Numero / 1000000000L;
        if (Numero > 1000000000L & Numero < 1999999999L) {
            aux = UtileriaNumerosLetras.Centena[12] + ' ';
        }
        else {
            aux = resolverIntervalo(pi) + UtileriaNumerosLetras.Centena[13] + ' ';
        }
        if (pf != 0L) {
            return aux + resolverIntervalo(pf) + ' ';
        }
        return aux;
    }
    
    private static String resolverIntervalo(final long Numero) {
        if (Numero >= 0L & Numero <= 20L) {
            return getUnidad(Numero);
        }
        if (Numero >= 21L & Numero <= 99L) {
            return getDecena(Numero);
        }
        if (Numero >= 100L & Numero <= 999L) {
            return getCentena(Numero);
        }
        if (Numero >= 1000L & Numero <= 999999L) {
            return getMil(Numero);
        }
        if (Numero >= 1000000L & Numero <= 999999999L) {
            return getMillon(Numero);
        }
        if (Numero >= 1000000000L & Numero <= 2000000000L) {
            return getBillon(Numero);
        }
        return "<<El numero esta fuera del rango>>";
    }
    
    static {
        Unidad = new String[] { "Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Dieciseis", "Diecisiete", "Dieciocho", "Diecinueve", "Veinte" };
        Decena = new String[] { "Venti", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa" };
        Centena = new String[] { "Cien", "Doscientos", "Trescientos", "Cuatrocientos", "Quinientos", "Seiscientos", "Setecientos", "Ochocientos", "Novecientos", "Mil", "Un Mill\u00f3n", "Millones", "Un Bill\u00f3n", "Billones" };
    }
}
