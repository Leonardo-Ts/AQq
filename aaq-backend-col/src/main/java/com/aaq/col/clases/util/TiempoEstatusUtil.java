package com.aaq.col.clases.util;

import java.util.Date;

import javax.persistence.RollbackException;

import org.apache.commons.lang3.BooleanUtils;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;


public class TiempoEstatusUtil {
	
	private ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();


	public String estatusDisponibles(Date ultimoLocalizacionFecha, Date fechaEstatusDisponible, Base base, Estado edo) {
		
	//Validar Para CDMX
	if (edo.getNombre().contains("CDMX") || edo.getId() == 9 ) {
		if (fechaEstatusDisponible != null) {
	    	try {
				 int tiempoDisponible = this.configuracionDao.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
				 long millisTiempoD =  tiempoDisponible * 60 * 1000;
	        	  if ((ultimoLocalizacionFecha != null)  && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
	 		            return  "VPosicion";
	   	               }
	       		 } catch (ClassCastException | RollbackException e) {
	       		 }
	    	
	           return "Disponible";
	        }
	}	
	
	//Validar Para Monterrey
		if (base.getNombre().contains("MONTERREY") || base.getNombre().contains("GUADALUPE") || base.getNombre().contains("FORÁNEO") ||  base.getNombre().contains("SAN NICOLAS/ESCOBEDO")
				|| base.getNombre().contains("SANTA CATARINA") || base.getNombre().contains("SAN PEDRO GARZA GARCIA")
			||	base.getId() == 157 // Foraneo
			|| base.getId() == 25 || base.getId() == 171	 || base.getId() == 177	 || base.getId() == 172	// Monterrey, monterrey centro, monterrey poniente y sue
			|| base.getId() == 176 || base.getId() == 175 // Guadalupe Norte y Guadalupe sur 
			|| base.getId() == 178 || base.getId() == 173 || base.getId() == 174 // Para San Nicolas/Escobero, San Pedro Garza y Santa Catarina
			) {
			if (fechaEstatusDisponible != null) {
		    	try {
					 int tiempoDisponible = this.configuracionDao.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
					 long millisTiempoD =  tiempoDisponible * 60 * 1000;
		        	  if ((ultimoLocalizacionFecha != null)  && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
		 		            return  "VPosicion";
		   	               }
		       		 } catch (ClassCastException | RollbackException e) {
		       		 }
		    	
		           return "Disponible";
		        }
		}	
			
    if (base.getNombre().contains("GUADALAJARA") || base.getId() == 64 ) {
    	if (fechaEstatusDisponible != null) {
	    	try {
				 int tiempoDisponible = this.configuracionDao.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
				 long millisTiempoD =  tiempoDisponible * 60 * 1000;
	        	  if ((ultimoLocalizacionFecha != null)  && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
	 		            return  "VPosicion";
	   	               }
	       		 } catch (ClassCastException | RollbackException e) {
	       		 }
	           return "Disponible";
	        }
    }
	    if (fechaEstatusDisponible != null) {
	            if ((ultimoLocalizacionFecha != null)
	                    && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > 300000)) {
	            	return  "VPosicion";
	            }
	           return "Disponible";
	    }
	return null;
	}
	
	public String iconoEstatus(Base base, Date ultimoLocalizacionFecha, boolean moto, boolean vulnerable, Estado edo, boolean equipoPesado) {
		//Para CDMX
	     if (edo.getNombre().contains("CDMX") || edo.getId() == 9 ) {
	        	try {
	      			 int tiempoDisponible = configuracionDao
	      						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
	      			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
		        		 if ((ultimoLocalizacionFecha != null)
		                         && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
		        			 
		        				if (vulnerable) {
		    	      				return JMConstantes.ICONO_EXPRES_VPOSICION;
		    	      			}
		    	              	
		    	              	if ( BooleanUtils.isTrue(moto) ) {
		    	              		return JMConstantes.ICONO_MOTO_SIN_GPS;
		    	              	}
		    	              	
		    	              	if ( BooleanUtils.isTrue(equipoPesado) ) {
		    	            		return JMConstantes.ICONO_EQUIPO_PESADO_VPOSICION;
		    	            	}
		    	              	
		    	                  return JMConstantes.ICONO_VEHICULO_SIN_GPS;
		        			
		   	                 }
		       		 } catch (ClassCastException | RollbackException e) {
		       		 }
		        	
	        		if (vulnerable) {
    				 return JMConstantes.ICONO_EXPRES_DISPONIBLE;
	      			}
	                  
	                  if ( BooleanUtils.isTrue(moto) ) {
	              		return JMConstantes.ICONO_MOTO_DISPONIBLE;
	              	}
	                  
	                  if ( BooleanUtils.isTrue(equipoPesado) ) {
	              		return JMConstantes.ICONO_EQUIPO_PESADO_DISPONIBLE;
	              	}
	                 
	               return JMConstantes.ICONO_VEHICULO_DISPONIBLE;
	   		}
	   //Validar Para Monterrey
			if (base.getNombre().contains("MONTERREY") || base.getNombre().contains("GUADALUPE") || base.getNombre().contains("FORÁNEO") ||  base.getNombre().contains("SAN NICOLAS/ESCOBEDO")
					|| base.getNombre().contains("SANTA CATARINA") || base.getNombre().contains("SAN PEDRO GARZA GARCIA")
				||	base.getId() == 157 // Foraneo
				|| base.getId() == 25 || base.getId() == 171	 || base.getId() == 177	 || base.getId() == 172	// Monterrey, monterrey centro, monterrey poniente y sue
				|| base.getId() == 176 || base.getId() == 175 // Guadalupe Norte y Guadalupe sur 
				|| base.getId() == 178 || base.getId() == 173 || base.getId() == 174 // Para San Nicolas/Escobero, San Pedro Garza y Santa Catarina
				) {
	        	try {
	      			 int tiempoDisponible = configuracionDao
	      						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
	      			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
		        		 if ((ultimoLocalizacionFecha != null)
		                         && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
		        			 
		        			if (vulnerable) {
		 	      				return JMConstantes.ICONO_EXPRES_VPOSICION;
		 	      			}
		 	              	
		 	              	if ( BooleanUtils.isTrue(moto) ) {
		 	              		return JMConstantes.ICONO_MOTO_SIN_GPS;
		 	              	}
		 	              	
		 	              	if ( BooleanUtils.isTrue(equipoPesado) ) {
		 	           		return JMConstantes.ICONO_EQUIPO_PESADO_VPOSICION;
		 	              	}
		 	              	
		        		return JMConstantes.ICONO_VEHICULO_SIN_GPS;
		        			
		   	                 }
		       		 } catch (ClassCastException | RollbackException e) {
		       		 }
		        	
	        	 if (vulnerable) {
    				 return JMConstantes.ICONO_EXPRES_DISPONIBLE;
	      			}
	                  
	               if ( BooleanUtils.isTrue(moto) ) {
	            	return JMConstantes.ICONO_MOTO_DISPONIBLE;
	              }
	               
	               if ( BooleanUtils.isTrue(equipoPesado) ) {
	           		return JMConstantes.ICONO_EQUIPO_PESADO_DISPONIBLE;
	           		}
	               
	              return JMConstantes.ICONO_VEHICULO_DISPONIBLE;  
	   		} 
	     
        if (base.getNombre().contains("GUADALAJARA") || base.getId() == 64 ) {
        	try {
      			 int tiempoDisponible = configuracionDao
      						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
      			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
	        		 if ((ultimoLocalizacionFecha != null)
	                         && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
	        			 if (vulnerable) {
	           				return JMConstantes.ICONO_EXPRES_VPOSICION;
	           			}
	                   	
	                   	if ( BooleanUtils.isTrue(moto) ) {
	                   		return JMConstantes.ICONO_MOTO_SIN_GPS;
	                   	}
	                   	
	                   	if ( BooleanUtils.isTrue(equipoPesado) ) {
	                		return JMConstantes.ICONO_EQUIPO_PESADO_VPOSICION;
	                	}
	                   	
	                       return JMConstantes.ICONO_VEHICULO_SIN_GPS;
	   	                 }
	       		 } catch (ClassCastException | RollbackException e) {
	       		 }
	        	
        	 if (vulnerable) {
				 return JMConstantes.ICONO_EXPRES_DISPONIBLE;
     			}
                 
             if ( BooleanUtils.isTrue(moto) ) {
           		return JMConstantes.ICONO_MOTO_DISPONIBLE;
            	}
             
             if ( BooleanUtils.isTrue(equipoPesado) ) {
         		return JMConstantes.ICONO_EQUIPO_PESADO_DISPONIBLE;
         	}
             
              return JMConstantes.ICONO_VEHICULO_DISPONIBLE;
              	
   		} 
   			//Demas bases se mantienen igual
            if ((ultimoLocalizacionFecha != null)
                    && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > 300000)) {
            	
            	if (vulnerable) {
    				return JMConstantes.ICONO_EXPRES_VPOSICION;
    			}
            	
            	if ( BooleanUtils.isTrue(moto) ) {
            		return JMConstantes.ICONO_MOTO_SIN_GPS;
            	}
            	
            	if ( BooleanUtils.isTrue(equipoPesado) ) {
            		return JMConstantes.ICONO_EQUIPO_PESADO_VPOSICION;
            	}
            	
                return JMConstantes.ICONO_VEHICULO_SIN_GPS;
            }
            
            if (vulnerable) {
				 return JMConstantes.ICONO_EXPRES_DISPONIBLE;
    			}
                
            if ( BooleanUtils.isTrue(moto) ) {
          		return JMConstantes.ICONO_MOTO_DISPONIBLE;
           	}
            
            if ( BooleanUtils.isTrue(equipoPesado) ) {
        		return JMConstantes.ICONO_EQUIPO_PESADO_DISPONIBLE;
        	}
            
            return JMConstantes.ICONO_VEHICULO_DISPONIBLE;
	}
	
	public String puntoAlterno(Base base, Date ultimoLocalizacionFecha, Date fechaEstatusDisponible,Estado edo) {
		
		 if (edo.getNombre().contains("CDMX") || edo.getId() == 9 ) {
	          if (fechaEstatusDisponible != null) {
	        	try {
	    			 int tiempoDisponible = this.configuracionDao
	    						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
	    			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
		        		 if ((ultimoLocalizacionFecha != null)
		                         && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
		                     return "alt_" + JMConstantes.ICONO_VEHICULO_SIN_GPS;
		   	                 }
		       		 } catch (ClassCastException | RollbackException e) {
		       		 }
	                return "alt_" + JMConstantes.ICONO_VEHICULO_DISPONIBLE;
	             }
	        }
		//Validar Para Monterrey
			if (base.getNombre().contains("MONTERREY") || base.getNombre().contains("GUADALUPE") || base.getNombre().contains("FORÁNEO") ||  base.getNombre().contains("SAN NICOLAS/ESCOBEDO")
					|| base.getNombre().contains("SANTA CATARINA") || base.getNombre().contains("SAN PEDRO GARZA GARCIA")
				||	base.getId() == 157 // Foraneo
				|| base.getId() == 25 || base.getId() == 171	 || base.getId() == 177	 || base.getId() == 172	// Monterrey, monterrey centro, monterrey poniente y sue
				|| base.getId() == 176 || base.getId() == 175 // Guadalupe Norte y Guadalupe sur 
				|| base.getId() == 178 || base.getId() == 173 || base.getId() == 174 // Para San Nicolas/Escobero, San Pedro Garza y Santa Catarina
				) {
	            if (fechaEstatusDisponible != null) {
	          	try {
	      			 int tiempoDisponible = this.configuracionDao
	      						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
	      			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
	  	        		 if ((ultimoLocalizacionFecha != null)
	  	                         && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
	  	        			return "alt_" + JMConstantes.ICONO_VEHICULO_SIN_GPS;
	  	   	                 }
	  	       		 } catch (ClassCastException | RollbackException e) {
	  	       		 }
	                   return "alt_" + JMConstantes.ICONO_VEHICULO_DISPONIBLE;
	               }
	          }
		
        if (base.getNombre().contains("GUADALAJARA") || base.getId() == 64 ) {
          if (fechaEstatusDisponible != null) {
        	try {
    			 int tiempoDisponible = this.configuracionDao
    						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
    			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
	        		 if ((ultimoLocalizacionFecha != null)
	                         && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > millisTiempoD )) {
	        			 return "alt_" + JMConstantes.ICONO_VEHICULO_SIN_GPS;
	   	                 }
	       		 } catch (ClassCastException | RollbackException e) {
	       		 }
                 return "alt_" + JMConstantes.ICONO_VEHICULO_DISPONIBLE;
             }
        }
           if (fechaEstatusDisponible != null) {
            if ((ultimoLocalizacionFecha != null)
                    && ((System.currentTimeMillis() - ultimoLocalizacionFecha.getTime()) > 300000)) {
                return "alt_" + JMConstantes.ICONO_VEHICULO_SIN_GPS;
            }

            return "alt_" + JMConstantes.ICONO_VEHICULO_DISPONIBLE;
          
        }
		return null;
	}
	
}
