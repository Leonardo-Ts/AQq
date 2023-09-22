package com.aaq.col.system.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.aaq.col.clases.webservices.json.ListaAjustador;
import com.aaq.col.clases.webservices.json.ListaBase;
import com.aaq.col.clases.webservices.json.ListaEstado;
import com.aaq.col.clases.webservices.json.ListaGeocerca;
import com.aaq.col.clases.webservices.json.ListaIcono;
import com.aaq.col.clases.webservices.json.ListaMunicipio;
import com.aaq.col.clases.webservices.json.ListaPuntoInteres;
import com.aaq.col.clases.webservices.json.Reporte;
import com.aaq.col.clases.webservices.json.ResultadoOperacion;

@Path("/SIICARestWebService")
@WebService(serviceName = "SIICARestWebService", name = "SIICARestWebService", targetNamespace = "http://com.jmfg.qualitas.com")
public interface SIICARestWebServiceInterfase {

	@WebMethod
	@GET
	@Path("/listaEstado")
	ListaEstado listaEstado();

	@WebMethod
	@GET
	@Path("/listaMunicipio")
	ListaMunicipio listaMunicipio(@QueryParam("estado") String idEstado);

	@WebMethod
	@GET
	@Path("/listaBase")
	ListaBase listaBase(@QueryParam("estado") String idEstado);

	@WebMethod
	@GET
	@Path("/listaAjustador")
	ListaAjustador listaAjustador(@QueryParam("estado") String idEstado, @QueryParam("base") String idBase);

	@WebMethod
	@GET
	@Path("/ajustador")
	ListaAjustador ajustador(@QueryParam("clave") String clave);

	@WebMethod
	@GET
	@Path("/listaIcono")
	ListaIcono listaIcono();

	@WebMethod
	@GET
	@Path("/listaPuntoInteres")
	ListaPuntoInteres listaPuntoInteres(@QueryParam("estado") String idEstado);

	@WebMethod
	@GET
	@Path("/listaGeocerca")
	ListaGeocerca listaGeocerca(@QueryParam("estado") String idEstado);

	@WebMethod
	@GET
	@Path("/insertaReporte")
	ResultadoOperacion insertaReporte(@MatrixParam("") Reporte reporte);

	@WebMethod
	@GET
	@Path("/asignaReporte")
	ResultadoOperacion asignaReporte(@QueryParam("identificadorUnico") String identificadorUnico,
			@QueryParam("idAjustador") String idAjustador);

	@WebMethod
	@GET
	@Path("/reporte")
	Reporte reporte(@QueryParam("identificadorUnico") String identificadorUnico,
			@QueryParam("idReporte") String idReporte);

	@WebMethod
	@GET
	@Path("/listaAjustadorCercano")
	public ListaAjustador listaAjustadorCercano(@QueryParam("latitud") final String latitud,
			@QueryParam("longitud") final String longitud, @QueryParam("soloDisponibles") final boolean soloDisponibles);
	
	@WebMethod
	@GET
	@Path("/listaAjustadorCalor")
	public ListaAjustador listaAjustadorCalor(@QueryParam("latitud") final String latitud,
			@QueryParam("longitud") final String longitud);
	
	@WebMethod
	@GET
	@Path("/listaAjustadores")
	public ListaAjustador listaAjustadores();

}