package com.aaq.col.clases.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

public class UtileriaFechas {
	
	private final Log4JLogger loggerEspecial = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.especial");
	private final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat formatoCA = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static final SimpleDateFormat formatoEdoCta = new SimpleDateFormat("dd/MM/yyyy");


	public  int numeroDiasEntreDosFechas(Date fecha1, Date fecha2){
	     long startTime = fecha1.getTime();
	     long endTime = fecha2.getTime();
	     long diffTime = endTime - startTime;
	     return (int)TimeUnit.DAYS.convert(diffTime, TimeUnit.MILLISECONDS);
	}
	
	public boolean fechasIguales(Date fecha1, Date fecha2) {
		Date date1 = this.formatHoraCero(fecha1);
		Date date2 =this.formatHoraCero(fecha2);
//		 this.loggerEspecial.info("Uno-> "+date1);
//		 this.loggerEspecial.info("Dos-> "+date2);

		if (date1.equals(date2)) {
//			 this.loggerEspecial.info("Las fechas son iguales");
			 return true;
		}
		return false;
	}
	
	 public synchronized Date formatHoraCero(Date date) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.set(Calendar.HOUR_OF_DAY, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.SECOND, 0);
			 try {
				 Date startDate = cal.getTime();
				 return startDate;
			 } catch (Exception e) {
				 this.loggerEspecial.info("Ocurrio un error en formatoIncial: "+e);
			}
		return date;
		
		}

	 public String fechasParaAlarmas() {
		 synchronized(formato) {
			 Date myDate = new Date();
			 String salida = formato.format(myDate);
			 return salida ;
		 }
	 }
	 
	 
	 public  boolean validarFecha(String fecha) {
	        try {
	            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	            formatoFecha.setLenient(false);
	            formatoFecha.parse(fecha);
	        } catch (ParseException e) {
	            return false;
	        }
	        return true;
	    }
	 
	 public String fechaHoraArriboSac(String fecha, String hora) {
			 if (StringUtils.isNotBlank(fecha)) {
				 try {
				 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				 Date d = sdf.parse(fecha);
				 sdf.applyPattern("dd-MM-yy");
				return sdf.format(d);
				 } catch (ParseException e) {
					 this.loggerEspecial.error("Error al parseear fecha y hora Arribo para SAC -> "+e);
					return fecha;
				}
			}
			 if (StringUtils.isNotBlank(hora)) {
				 try {
				 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				 Date d = sdf.parse(hora);
				 sdf.applyPattern("HH:mm");
				return sdf.format(d);
				 } catch (ParseException e) {
					 this.loggerEspecial.error("Error al parseear fecha y hora Arribo para SAC -> "+e);
					return hora;
				}
			}
		
		 return null;
		
	 }
	 
	 public int diaSemana() {
		try {
		 Date date = new Date();
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		 return dayOfWeek;
		} catch (ClassCastException | IllegalArgumentException e) {
		}
		return 0;
	 }
	 
	 public String fechaHoraArriboEstimado(String fecha) {
		 Date date = new Date();
		 String formattedDateString = null;
		 if (StringUtils.isNotBlank(fecha)) {
			 try {
				 synchronized (formatoCA) {
					 date = formatoCA.parse(fecha); // En esta linea esta el error
				}
			  formattedDateString = formatoDateString(date);
			return formattedDateString;
			 } catch (ParseException e) {
				 this.loggerEspecial.error("Error al parseear fecha y hora Arribo Estimado Grua -> "+e);
				return fecha;
			}
		}
	 return null;
	
	 }
	 
	 private synchronized String formatoDateString(Date date) throws ParseException {
		String formattedDateString = null;
		formattedDateString = formatter.format(date);
		  return  formattedDateString;

	 }
	 
	 public  boolean validarFechaCorta(String fecha) {
	        try {
	            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	            formatoFecha.setLenient(false);
	            formatoFecha.parse(fecha);
	        } catch (ParseException e) {
	            return false;
	        }
	        return true;
	    }
	 
	 public Map<String, String> fechaHoraArriboSacAQ(String fechaHora, boolean sac) {
		 Map<String, String> respuesta = new HashMap<String, String>();
		 
		 if (sac) {
			 // 8/30/2022 11:20:27 a. m.
			 if (StringUtils.isNotBlank(fechaHora)) {
				 try {
				 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				 SimpleDateFormat sdfH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

				 Date d = sdf.parse(fechaHora);
				 Date hora = sdfH.parse(fechaHora);
				 sdf.applyPattern("dd-MM-yy");
				 respuesta.put("fecha", sdf.format(d));
				 //Manejo de Hora
				 sdfH.applyPattern("HH:mm");
				 respuesta.put("hora", sdfH.format(hora));
				 return respuesta;
//				return sdf.format(d);
				 } catch (ParseException e) {
					 this.loggerEspecial.error("Error al parseear fecha y hora Arribo para SAC -> "+e);
					return null;
				}
			}
		} else {
			 if (StringUtils.isNotBlank(fechaHora)) {
				 try {
				 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				 SimpleDateFormat sdfH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				 Date d = sdf.parse(fechaHora);
				 Date hora = sdfH.parse(fechaHora);
				 sdf.applyPattern("dd/MM/yyyy");
				 respuesta.put("fecha", sdf.format(d));
				 //Manejo de Hora
				 sdfH.applyPattern("HH:mm:ss");
				 respuesta.put("hora", sdfH.format(hora));
				 return respuesta;
//				return sdf.format(d);
				 } catch (ParseException e) {
					 this.loggerEspecial.error("Error al parseear fecha y hora Arribo para SAC -> "+e);
					return null;
				}
			}
		}
	 return null;
	
 }
	 
	 public Date convertirFecha(String fecha) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	        String dateInString = fecha;
	        Date date = new Date();
	        try {

	             date = formatter.parse(dateInString);
	            return date;
	        } catch (ParseException e) {
	           this.loggerEspecial.info("Ocurrio un RollbackException en : "+e);
	        }
			return date;
		}
	 
	 public synchronized String fechaOA(Date date) throws ParseException {
			String formattedDateString = null;
			formattedDateString = formato.format(date);
			return  formattedDateString;
	}
	 
	 public synchronized String formatoDateEdoCta(Date date) throws ParseException {
			String formattedDateString = null;
			formattedDateString = formatoEdoCta.format(date);
			  return  formattedDateString;
		 }
	 
}
