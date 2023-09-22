package com.aaq.col.clases.util;

import com.aaq.col.clases.sac.model.DatosInsertarFormatoAdmisionAutomoviles;

public class FormatoEliminarClob {
	
		public DatosInsertarFormatoAdmisionAutomoviles eliminaFormatoAdmisionAutomoviles(DatosInsertarFormatoAdmisionAutomoviles datos) {
			if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
				datos.setFirma_Ajustador(null);
			} else {
				datos.setFirma_Ajustador("Ok");
			}
			
			if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
				datos.setFirma_Asegurado(null);
			} else {
				datos.setFirma_Asegurado("Ok");
			}
			
			if(datos.getOa_codigo_qr()==null || datos.getOa_codigo_qr().equals("")) {
				datos.setOa_codigo_qr(null);
			} else {
				datos.setOa_codigo_qr("Ok");
			}
			return datos;
		}

}
