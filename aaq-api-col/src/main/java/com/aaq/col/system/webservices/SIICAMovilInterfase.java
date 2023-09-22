 package com.aaq.col.system.webservices;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.aaq.col.clases.webservices.movil.peticion.MovilCobroBancario;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosGrua;
import com.aaq.col.clases.webservices.movil.peticion.MovilInicioDeSesion;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporte;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoInicioDeSession;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilResumenAjustador;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioAbogado;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioAbogadoArribo;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioArribo;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioCoberturaEstimacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioCobroBancario;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioDiverso;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioEncuesta;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioGestion;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioReconocimiento;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioServicio;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioTermino;
import com.aaq.col.clases.webservices.movil.peticion.MovilSolicitarTicketCondiciones;

@WebService(name = "SIICAMovil", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices")
public interface SIICAMovilInterfase {

	/**
	 * @param servicioArribo
	 * @return la validacion del servicio de arribo
	 */
	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarArribo(
			@WebParam(name = "servicioArribo") final MovilServicioArribo servicioArribo);

	/**
	 * @param servicioTermino
	 * @return la validacion del servicio de termino
	 */
	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarTermino(
			@WebParam(name = "servicioTermino") final MovilServicioTermino servicioTermino);

	/**
	 * @param servicioGestion
	 * @return la validacion del servicio de gestion
	 */
	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarGestion(
			@WebParam(name = "servicioGestion") final MovilServicioGestion servicioGestion);

	/**
	 * @param servicioCoberturaEstimacion
	 * @return la validacion del servicio de cobertura estimacion
	 */
	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarCoberturaEstimacion(
			@WebParam(name = "servicioCoberturaEstimacion") final MovilServicioCoberturaEstimacion servicioCoberturaEstimacion);

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoInicioDeSession solicitarInicioDeSesion(
			@WebParam(name = "credenciales") MovilInicioDeSesion credenciales);

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion solicitarCobroBancario(
			@WebParam(name = "servicioCobroBancario") final MovilServicioCobroBancario servicioCobroBancario);

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilReporte solicitarDatosDeReporte(@WebParam(name = "credenciales") MovilInicioDeSesion credenciales);

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion solicitarServicio(
			@WebParam(name = "servicioSolicitar") final MovilServicioServicio serv);

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarAbogado(@WebParam(name = "servicioInsertarAbogado") MovilServicioAbogado serv);

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarAbogadoArribo(
			@WebParam(name = "servicioAbogadoArribo") final MovilServicioAbogadoArribo serv);

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion solicitarServiciosDiversos(
			@WebParam(name = "servicioDiverso") MovilServicioDiverso serv);

	
	@WebMethod
	@WebResult(name = "resultado")
	public String insertarEncuesta(@WebParam(name = "servicioEncuesta") MovilServicioEncuesta serv);

	
	@WebMethod
	@WebResult (name="resultado")
	public MovilResultadoOperacion guardarCobroBancario (@WebParam(name="guardarCobroBancario") MovilCobroBancario serv );
	
	@WebMethod
	@WebResult (name="resultado")
	public MovilResultadoOperacion insertarReconocimiento(@WebParam(name="servicioReconocimiento") MovilServicioReconocimiento serv);

	@WebMethod
	@WebResult(name="resultado")
	public  MovilDatosGrua solicitarDatosDeGrua(@WebParam(name="servicioDatosGrua")  MovilInicioDeSesion serv);
	
	@WebMethod
	@WebResult(name="resultado")
	public MovilResumenAjustador resumenAjustador (@WebParam(name="reporte")  String reporte);
	
	@WebMethod
	@WebResult(name="resultado")
	public MovilResultadoOperacion insertarArriboAct(@WebParam(name = "servicioArribo") final MovilServicioArribo servicioArribo);
	
	@WebMethod
	@WebResult(name="resultado")
	public MovilResultadoOperacion solicitarTicketCondiciones(@WebParam(name = "solicitarTicket") final MovilSolicitarTicketCondiciones solicitarTicket);
	
	

	
}
