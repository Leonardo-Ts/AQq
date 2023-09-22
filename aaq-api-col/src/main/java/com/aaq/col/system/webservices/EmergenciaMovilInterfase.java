package com.aaq.col.system.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;

@WebService(name = "EmergenciaMovilType", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices")
public interface EmergenciaMovilInterfase {

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarReporte(@WebParam(name = "usuario") String usuario,
			@WebParam(name = "passwd") String passwd, @WebParam(name = "poliza") String poliza,
			@WebParam(name = "endoso") String endoso, @WebParam(name = "inciso") String inciso,
			@WebParam(name = "latitud") String latitud, @WebParam(name = "longitud") String longitud,
			@WebParam(name = "causa") String causa, @WebParam(name = "nombre") String nombre,
			@WebParam(name = "descripcion") String descripcion, @WebParam(name = "referencia") String referencia,
			@WebParam(name = "contacto") String contacto, @WebParam(name = "agent") String agente);

}
