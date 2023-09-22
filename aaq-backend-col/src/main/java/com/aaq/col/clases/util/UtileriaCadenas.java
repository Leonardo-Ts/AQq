package com.aaq.col.clases.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.RollbackException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.fasterxml.jackson.databind.ObjectMapper;

public class UtileriaCadenas {
	
	public static Log log = LogFactory.getLog(UtileriaCadenas.class);
	
	public static boolean validaJson(String cadena) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(cadena);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	
	public  boolean validarUnSoloCorreo (String correo) {

	    String sTextoBuscado = "@";
	    int contador = 0;

	    while (correo.indexOf(sTextoBuscado) > -1) {
	      correo = correo.substring(correo.indexOf(
	        sTextoBuscado)+sTextoBuscado.length(),correo.length());
	      contador++; 
	    }
 
		if (contador == 1) {
			return true;
		}
		
		return false;
		
	}
	
	public String modFechaPasado(String fecha) {
		String correcionFecha = null;
		String cambioMes = null;
		Calendar c = Calendar.getInstance();
		// Validar que la fecha contenga mes incorrecto
		if (fecha.contains("JAN") | fecha.contains("FEB") | fecha.contains("MAR") | fecha.contains("APR") |
			fecha.contains("MAY") | fecha.contains("JUN") | fecha.contains("JUL") | fecha.contains("AUG") | 
			fecha.contains("SEP") | fecha.contains("OCT") | fecha.contains("NOV") | fecha.contains("DEC")) {
		try {
			String dia = fecha.substring(0, 2);
			String mes = fecha.substring(3, 6);
			if (StringUtils.isNotBlank(mes)) {
				try {
					cambioMes = this.mesLetra(mes);
				} catch (ClassCastException e) {
					log.info("Ocurrio un RollbackException: "+e);
				}
				if (cambioMes.equals("13") || StringUtils.isBlank(cambioMes)) {
					cambioMes = Integer.toString(c.get(Calendar.MONTH));
				}
			}
			String annio = Integer.toString(c.get(Calendar.YEAR));
			correcionFecha = dia+"/"+cambioMes+"/"+annio;
//			log.info("DIA: "+dia+" MES: "+cambioMes+" ANIO: "+annio);
//			log.info("Fecha Completa ->"+correcionFecha);
			return correcionFecha;

			} catch (ClassCastException | RollbackException  e) {
				log.info("RollbackException en -> "+e);
			}
		}
		return null;

	}
	
	public String modHora(String hora) {
		String horaCambio = null;
		try {
			if (StringUtils.isNotBlank(hora)) {
				hora = hora.trim();
				if (hora.length() == 7) {
					horaCambio = hora.replace(".", ":");
					return horaCambio+"0";
				} else {
					horaCambio = hora.replace(".", ":");
					return horaCambio;
				}
				
			}
		} catch (ClassCastException e) {
			log.info("Ocurrio un RollbackException: "+e);
		}
		return horaCambio;
	}
	
	private String  mesLetra(String mes) {
		String mesRetorno = null;
		switch (mes) {
		case "JAN":
			mesRetorno = "01";
			break;
		case "FEB":
			mesRetorno = "02";
			break;
		case "MAR":	
			mesRetorno = "03";
			break;
		case "APR":
			mesRetorno = "04";
			break;
		case "MAY":
			mesRetorno = "05";		
			break;
		case "JUN":
			mesRetorno = "06";
			break;
		case "JUL":
			mesRetorno = "07";
			break;
		case "AUG":
			mesRetorno = "08";
			break;
		case "SEP":
			mesRetorno = "09";
			break;
		case "OCT":
			mesRetorno = "10";
			break;	
		case "NOV":
			mesRetorno = "11";
			break;
		case "DEC":
			mesRetorno = "12";
			break;
		 default: mesRetorno = "13";
         break;
		}
		return mesRetorno;
	}
	
	public String modFechaOcurrido(String fecha) {
		String correcionFecha = null;
		String cambioMes = null;
		Calendar c = Calendar.getInstance();
		// Validar que la fecha contenga mes incorrecto
		if (fecha.contains("JAN") | fecha.contains("FEB") | fecha.contains("MAR") | fecha.contains("APR") |
			fecha.contains("MAY") | fecha.contains("JUN") | fecha.contains("JUL") | fecha.contains("AUG") | 
			fecha.contains("SEP") | fecha.contains("OCT") | fecha.contains("NOV") | fecha.contains("DEC")) {
		try {
			String dia = fecha.substring(0, 2);
			String mes = fecha.substring(3, 6);
			if (StringUtils.isNotBlank(mes)) {
				try {
					cambioMes = this.mesLetra(mes);
				} catch (ClassCastException e) {
					log.info("Ocurrio un RollbackException: "+e);
				}
				if (cambioMes.equals("13") || StringUtils.isBlank(cambioMes)) {
					cambioMes = Integer.toString(c.get(Calendar.MONTH));
				}
			}
			String annio = Integer.toString(c.get(Calendar.YEAR));
			correcionFecha = annio+"-"+cambioMes+"-"+dia;
//			log.info("DIA: "+dia+" MES: "+cambioMes+" ANIO: "+annio);
//			log.info("Fecha Completa ->"+correcionFecha);
			return correcionFecha;

			} catch (ClassCastException | RollbackException  e) {
				log.info("RollbackException en -> "+e);
			}
		}
		return null;

	}
	
	public Date convertirFecha(String fecha, String hora) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        String dateInString = fecha.trim() + " "+hora.trim();
        Date date = new Date();
        try {

             date = formatter.parse(dateInString);
            return date;
        } catch (ParseException e) {
           log.info("Ocurrio un RollbackException en : "+e);
        }
		return date;
	}
	
	public String tipoAfectado(int afectado) {
		String resultado = null;
		if (afectado ==1) {
			resultado= "Asegurado";
			return resultado;
		}
		UtileriaNumeros utileria = new UtileriaNumeros();
		resultado = "Tercero "+utileria.Convertir(Integer.toString(afectado), false);
		return resultado;
	}
	
	public String tipoAfectadoLetra(int afectado) {
		String resultado = null;
		if (afectado == 1) {
			resultado= "A";
			return resultado;
		}
		resultado = "T"+Integer.toString(afectado-1);
		return resultado;
	}

	@SuppressWarnings("deprecation")
	public boolean validateBase64(String s) {
		boolean isBase64 = false;
		try {
			String stringToBeChecked = s; 
			isBase64 = Base64.isArrayByteBase64(stringToBeChecked.getBytes());
		}catch (IndexOutOfBoundsException | ClassCastException e) {
		}
		return isBase64;
	}
	
	public static String quitaAcentos(String texto) {
		
        try{
        	if(texto!=null){
		        String[] cAcentos = {"Á", "É", "Í", "Ó", "Ú", "á", "é", "í", "ó", "ú", "ñ", "Ñ", "|", "ÿ", "Ü", "ü", "¦","/"};
		        String[] sAcentos = {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u", "n", "N", "", "", "U", "u", "",""};
		        int cValidaciones = 0;
		        while (cValidaciones <= cAcentos.length - 1) {
		        	texto = texto.replace(cAcentos[cValidaciones], sAcentos[cValidaciones]);
		            cValidaciones += 1;
		        }
        	}
        }catch(ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e){
        	log.error("quitaAcentos en -> ",e);
        }
        return texto;
    }
	
	
}
