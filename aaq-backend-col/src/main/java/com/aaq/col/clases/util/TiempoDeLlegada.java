package com.aaq.col.clases.util;

import java.io.IOException;
import java.io.Serializable;

import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.OverQueryLimitException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;


public class TiempoDeLlegada implements Serializable  {

	    private static final long serialVersionUID = 6642137625997924213L;
	    private final static JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);

	    public TiempoDeLlegada() {
	    }

	    public static double obtenerTiempoEntreDosCoordenadas(String coordx1, String coordy1, String coordx2, String coordy2)  {
	       
	    	GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCwNI1c--8lIeF7CWMXtzeYokjBYtlSQuM").build();
//	    			enterpriseCredentials("gme-qualitascompania", "xLxFkf_-tCX8zC7ekxS-Ct9FIOI=").build();
	    		
	    	
	    	String[] destinationAddress = {coordx1 +", " + coordy1};
	    	String[] originAddress = {coordx2 +", " + coordy2};
	    	
	    	    try {
	    	        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context); 
	    	        DistanceMatrix trix;
						trix = req.origins(destinationAddress)
						        .destinations(originAddress)
						        .mode(TravelMode.DRIVING)
						        .avoid(RouteRestriction.HIGHWAYS)
						        .await();
	    	               return new Double(trix.rows[0].elements[0].duration.inSeconds);
	    	    } catch (OverQueryLimitException  ex) {
	    	    	utileriaExcepcion.manejarExcepcion(ex, TiempoDeLlegada.class, "obtenerTiempoEntreDosCoordenadas => " + ex);
	    		}  catch (ApiException  ex) {
	    	    	utileriaExcepcion.manejarExcepcion(ex, TiempoDeLlegada.class, "obtenerTiempoEntreDosCoordenadas => " + ex);
	    		}   catch (InterruptedException | IOException e) {
	    			utileriaExcepcion.manejarExcepcion(e, TiempoDeLlegada.class, "obtenerTiempoEntreDosCoordenadas => " + e);
				}
	    	    
	    	    return new Double(1);
	    }
	    
	    
	    public static double obtenerDistanciaEntreDosCoordenadas(String coordx1, String coordy1, String coordx2, String coordy2)  {
		       
	    	GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCwNI1c--8lIeF7CWMXtzeYokjBYtlSQuM").build();
//	    			enterpriseCredentials("gme-qualitascompania", "xLxFkf_-tCX8zC7ekxS-Ct9FIOI=").build();
	    	
	    	String[] destinationAddress = {coordx1 +", " + coordy1};
	    	String[] originAddress = {coordx2 +", " + coordy2};
	    	
	    	    try {
	    	        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context); 
	    	        DistanceMatrix trix = req.origins(destinationAddress)
	    	                .destinations(originAddress)
	    	                .mode(TravelMode.DRIVING)
	    	                .avoid(RouteRestriction.HIGHWAYS)
	    	                .await();
	    	               return new Double(trix.rows[0].elements[0].distance.inMeters);
	    	    } catch (OverQueryLimitException  ex) {
	    	    	utileriaExcepcion.manejarExcepcion(ex, TiempoDeLlegada.class, "obtenerDistanciaEntreDosCoordenadas => " + ex);
	    		}  catch (ApiException  ex) {
	    			utileriaExcepcion.manejarExcepcion(ex, TiempoDeLlegada.class, "obtenerDistanciaEntreDosCoordenadas => " + ex);
	    		}   catch (InterruptedException | IOException e) {
	    			utileriaExcepcion.manejarExcepcion(e, TiempoDeLlegada.class, "obtenerDistanciaEntreDosCoordenadas => " + e);
				}
	    	    
	    	    return new Double(1);
	    }
	    
	    public static double distanciaCoordenadas(String lat1, String lng1, String lat2, String lng2) {  
	        //double radioTierra = 3958.75;//en millas  
	        double radioTierra = 6371;//en kilómetros  
	        double dLat = Math.toRadians(Double.parseDouble(lat2) - Double.parseDouble(lat1));  
	        double dLng = Math.toRadians(Double.parseDouble(lng2) - Double.parseDouble(lng1));  
	        double sindLat = Math.sin(dLat / 2);  
	        double sindLng = Math.sin(dLng / 2);  
	        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
	                * Math.cos(Math.toRadians(Double.parseDouble(lat1))) * Math.cos(Math.toRadians(Double.parseDouble(lat2)));  
	        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
	        double distancia = radioTierra * va2;  
	   
	        return distancia;  
	    }

}
