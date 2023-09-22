package com.aaq.col.system.webservices;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.aaq.col.clases.webservices.movil.*;


@Path("/SIICAMovilRestWebService")
@WebService(serviceName = "SIICAMovilRestWebService", name = "SIICAMovilRestWebService", targetNamespace = "http://com.jmfg.qualitas.com")
public interface SIICAMovilRestWebServiceInterfase {
	@WebMethod
	@GET
	@Path("/solicitarServicio")
	public GETMovilResultadoOperacion solicitarServicio(@QueryParam("") final GETMovilServicioServicio serv);
	
	/**
	 * 
	 * @param serv
	 * @return
	 */
	@WebMethod
	@GET
	@Path("/insertarAbogadoArribo")
	public GETMovilResultadoOperacion insertarAbogadoArribo(@QueryParam("") final GETMovilServicioAbogadoArribo serv);

	/**
	 * 
	 * @param serv
	 * @return
	 */
	@WebMethod
	@GET
	@Path("/solicitarServiciosDiversos")
	public GETMovilResultadoOperacion solicitarServiciosDiversos(@QueryParam("") final GETMovilServicioDiverso serv);
	

	
	/**
	 * 
	 * @param serv
	 * @return
	 */
	@WebMethod
	@GET
	@Path("/insertarEncuesta")
	public GETMovilResultadoOperacion insertarEncuesta(@QueryParam("") final GETMovilServicioEncuesta serv);
	
	/**
	 * 
	 * @param usuario
	 * @param passwd
	 * @param latitud
	 * @param longitud
	 * @param FechaLocalizacion
	 * @param HoraLocalizacion
	 * @param FechaRecepcion
	 * @param HoraRecepcion
	 * @return
	 */
	@WebMethod
	@GET
	@Path("/ajustadoresInsertarCoordenadas")
	public GETMovilResultadoOperacion ajustadoresInsertarCoordenadas(@QueryParam("usuario") String usuario,
			@QueryParam("passwd") String passwd, 
			@QueryParam("latitud") String latitud,
			@QueryParam("longitud") String longitud, 
			@QueryParam("FechaLocalizacion") String FechaLocalizacion,
			@QueryParam("HoraLocalizacion") String HoraLocalizacion,
			@QueryParam("FechaRecepcion") String FechaRecepcion,
			@QueryParam("HoraRecepcion") String HoraRecepcion);

	
	@WebMethod
	@GET
	@Path("/QMovilServicio")
	GETMovilResultadoOperacion nuevoReporteMovilSac(@QueryParam("") final GETMovilReporteMovilSac servicioReporteMovilSac);
}
