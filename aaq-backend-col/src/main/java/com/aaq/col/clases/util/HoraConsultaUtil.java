package com.aaq.col.clases.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

public class HoraConsultaUtil {
	
	private final Log4JLogger loggerEspecial = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.especial");

	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	 public synchronized Date formatInicial(Date date) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.set(Calendar.HOUR_OF_DAY, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.SECOND, 0);
		 cal.set(Calendar.MILLISECOND, 0);
			 try {
				 Date startDate = cal.getTime();
				 return startDate;
			 } catch (Exception e) {
				 this.loggerEspecial.info("Ocurrio un error en formatoIncial: "+e);
			}
		return date;
		
		}

	
	 public synchronized Date formatFinal(Date date) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.set(Calendar.HOUR_OF_DAY, 23);
		 cal.set(Calendar.MINUTE, 59);
		 cal.set(Calendar.SECOND, 59);
		 cal.set(Calendar.MILLISECOND, 999);
			 try {
				 Date endDate = cal.getTime();
				 return endDate;
			 } catch (Exception e) {
				 this.loggerEspecial.info("Ocurrio un error en formatoIncial: "+e);
			}
		return date;
	}
	 
    public Date convertirFecha(String fecha) {
   	 synchronized(formatter) {
		     try {
		    	 String fechaCom = fecha.trim()+" 00:00:00";
		         Date date = formatter.parse(fechaCom);
		         return date;
		     } catch (ParseException e) {
		    	 this.loggerEspecial.info("Ocurrio un error en convertirFecha -> "+e);
		     }
			return null;
   	 }
    }
    
    public Date transformarFecha(String fecha) {
      	 synchronized(formatter) {
   		     try {
   		    	 String fechaCom = fecha.trim();
   		         Date date = formatter.parse(fechaCom);
   		         return date;
   		     } catch (ParseException e) {
   		    	 this.loggerEspecial.info("Ocurrio un error en transformarFecha -> "+e);
   		     }
   			return null;
      	 }
       }
    
    public Date convertirFecha(String fecha, boolean inicio) {
      	 synchronized(formatter) {
   		     try {
   		    	 if (inicio) {
   		    	 String fechaCom = fecha.trim()+" 00:00:00";
   		         Date date = formatter.parse(fechaCom);
   		         return date;
   		    	 } else {
   		    		String fechaCom = fecha.trim()+" 23:59:59";
      		         Date date = formatter.parse(fechaCom);
      		         return date;
   		    	 }
   		     } catch (ParseException e) {
   		    	 this.loggerEspecial.info("Ocurrio un error en convertirFecha -> "+e);
   		     }
   			return null;
      	 }
       }
    
}
