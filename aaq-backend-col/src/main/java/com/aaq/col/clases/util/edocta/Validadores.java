package com.aaq.col.clases.util.edocta;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validadores {
	

	public boolean esValidaFecha(String fecha, String formato){
		if(fecha == null){
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		sdf.setLenient(false);
		try {
			 sdf.parse(fecha);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	

}
