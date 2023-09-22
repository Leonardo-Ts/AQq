package com.aaq.col.system.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.aaq.col.clases.xml.webservices.AjustadorWebService;

import java.util.ArrayList;

@WebService(name = "SIICAWebServiceType", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices")
public interface SIICAWebServiceInterface {

	@WebMethod
	@WebResult(name = "resultadoOperacion")
	public String nuevoReporteParaProveedor(@WebParam(name = "numeroReporte") String numeroReporte,
			@WebParam(name = "numeroProveedor") String numeroProveedor, 
			@WebParam(name = "usuario") String usuario, @WebParam(name = "fuente") String fuente, @WebParam(name = "reporteApartado") Boolean reporteApartado);

	@WebMethod
	@WebResult(name = "resultadoOperacion")
	public String cancelarReporteParaProveedor(@WebParam(name = "numeroReporte") String numeroReporte,
			@WebParam(name = "numeroProveedor") String numeroProveedor);

	@WebMethod
	@WebResult(name = "resultadoOperacion")
	public String cerrarReporteParaProveedor(@WebParam(name = "numeroReporte") String numeroReporte,
			@WebParam(name = "numeroProveedor") String numeroProveedor);

	@WebMethod
	@WebResult(name = "resultado")
	public boolean enviarSMS(@WebParam(name = "numeroOrigen") String numeroOrigen,
			@WebParam(name = "numerosDestino") ArrayList<String> numerosDestino,
			@WebParam(name = "textoLibre") String textoLibre);

	@WebMethod()
	@WebResult(name = "resultado")
	public String cambiarEstatusAjustador(@WebParam(name = "numeroProveedor") String numeroProveedor,
			@WebParam(name = "numeroReporte") String numeroReporte, @WebParam(name = "fecha") String fecha,
			@WebParam(name = "tipoEvento") String tipoEvento, @WebParam(name = "usuario") String usuario,
			@WebParam(name = "fuente") String fuente);

	@WebMethod
	@WebResult(name = "ConsultaAjustadores")
	public AjustadorWebService consultaAjustadores(@WebParam(name = "entidad") String entidad,
			@WebParam(name = "oficina") String oficina);

	@WebMethod
	@WebResult(name = "Resultado")
	public String reasignarReporteParaProveedor(@WebParam(name = "numeroReporte") String numeroReporte,
			@WebParam(name = "numeroProveedor") String numeroProveedor,
			@WebParam(name = "esReasignacion") boolean esReasignacion,
			@WebParam(name = "esSegundaAtencion") boolean esSegundaAtencion,
			@WebParam(name = "usuario") String usuario, 
			@WebParam(name = "fuente") String fuente);

	@WebMethod
	@WebResult(name = "Resultado")
	public String insertarFechaHoraParaReporteReasignado(@WebParam(name = "numeroReporte") String numeroReporte,
			@WebParam(name = "numeroProveedor") String numeroProveedor, @WebParam(name = "fecha") String fecha,
			@WebParam(name = "hora") String hora, @WebParam(name = "tipoFecha") String tipoFecha);

	@WebMethod
	@WebResult(name = "Resultado")
	public String intercambiarReporte(@WebParam(name = "numeroReporteA") String numeroReporteA,
			@WebParam(name = "numeroProveedorA") String numeroProveedorA,
			@WebParam(name = "numeroReporteB") String numeroReporteB,
			@WebParam(name = "numeroProveedorB") String numeroProveedorB,
			@WebParam(name = "usuario") String usuario, 
			@WebParam(name = "fuente") String fuente);
			

}