package com.aaq.col.clases.util;

import com.google.gson.Gson;

public class ToJSON {

	    public String obtenerString(final Object var) {
	        try {
	            Gson json = new Gson();
	            String salida = json.toJson(var);
	            return salida;
	        } catch (Exception e) {
	            return null;
	        }
	    }
	    
}
