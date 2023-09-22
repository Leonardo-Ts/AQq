package com.aaq.col.system.webservices;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "SIICAExternoType", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices")
public interface SIICAExternoInterface {

	@WebMethod
	@WebResult(name = "resultado")
	public String ajustadoresIniciarSession(@WebParam(name = "usuario") String usuario,
			@WebParam(name = "passwd") String passwd);

	@WebMethod
	@WebResult(name = "resultado")
	public String ajustadoresCambiarEstatus(@WebParam(name = "usuario") String usuario,
			@WebParam(name = "passwd") String passwd, @WebParam(name = "estatus") String estatus);

	public String ajustadoresInsertarCoordenadas(@WebParam(name = "usuario") String usuario,
			@WebParam(name = "passwd") String passwd, @WebParam(name = "latitud") String latitud,
			@WebParam(name = "longitud") String longitud,
			@WebParam(name = "FechaLocalizacion") String FechaLocalizacion,
			@WebParam(name = "HoraLocalizacion") String HoraLocalizacion,
			@WebParam(name = "FechaRecepcion") String FechaRecepcion,
			@WebParam(name = "HoraRecepcion") String HoraRecepcion,
			@WebParam(name = "distanciaAlArribo") String distanciaAlArribo);

	public String ajustadoresInsertarCoordenadasConTelefono(@WebParam(name = "telefono") String telefono,
			@WebParam(name = "latitud") String latitud, @WebParam(name = "longitud") String longitud,
			@WebParam(name = "FechaLocalizacion") String FechaLocalizacion,
			@WebParam(name = "HoraLocalizacion") String HoraLocalizacion,
			@WebParam(name = "FechaRecepcion") String FechaRecepcion,
			@WebParam(name = "HoraRecepcion") String HoraRecepcion);

}