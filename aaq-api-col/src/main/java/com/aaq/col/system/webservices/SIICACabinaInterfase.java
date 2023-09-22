 package com.aaq.col.system.webservices;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.aaq.col.clases.xml.webservices.DatosAjustador;
import com.aaq.col.clases.xml.webservices.DatosLocalizacion;

@WebService(name = "SIICACabinaInterfase", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices")
public interface SIICACabinaInterfase {

	@WebMethod()
	@WebResult(name = "resultado")
	public DatosLocalizacion datosDeLocalizacion(@WebParam(name = "identificador") String identificador,
			@WebParam(name = "reporte") String reporte);

	@WebMethod()
	@WebResult(name = "resultado")
	public String actualizarIdentificadorConReporte(@WebParam(name = "identificador") String identificador,
			@WebParam(name = "reporte") String reporte);

	@WebMethod()
	@WebResult(name = "resultado")
	public ArrayList<DatosAjustador> ajustadoresCercanos(@WebParam(name = "identificador") String identificador,
			@WebParam(name = "reporte") String reporte);

}
