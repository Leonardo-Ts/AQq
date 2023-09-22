package com.aaq.col.system.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.aaq.col.clases.pojo.aaq.AjustAInsertarArriboAbog;
import com.aaq.col.clases.pojo.aaq.AjustRealizarCobro;
import com.aaq.col.clases.pojo.aaq.CambiarEstatus;
import com.aaq.col.clases.pojo.aaq.InsertarAbogAsignado;
import com.aaq.col.clases.pojo.aaq.InsertarCoordenadas;
import com.aaq.col.clases.webservices.movil.MovilResultadoOp;



@Path("/SIICARestExterno")
@WebService(serviceName = "SIICARestExterno", name = "SIICARestExterno", targetNamespace = "http://com.jmfg.qualitas.com")
public interface SIICARestExternoInterface {


	@WebMethod
	@Path("/ajustadores/insertar/coordenadas")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOp ajustadoresInsertarCoordenadas(final InsertarCoordenadas serv);

	@WebMethod
	@Path("/ajustadores/cambiar/estatus")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOp ajustadoresCambiarEstatus(final CambiarEstatus serv );
	
	@WebMethod
	@Path("/ajustadores/iniciar/sesion")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOp ajustadoresIniciarSession(final  @QueryParam("usuario") String usuario, final  @QueryParam("passwd")String passwd);

	
	@WebMethod
	@Path("/ajustadores/realizar/cobro")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOp ajustadoresRealizarCobro(final AjustRealizarCobro serv);
	

	@WebMethod
	@Path("/ajustadores/insertar/arribo/abogado")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOp ajustadoresInsertarArriboAbogado(final AjustAInsertarArriboAbog serv);
	
	@WebMethod
	@Path("/ajustadores/insertar/abogado/asignado")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOp insertarAbogadoAsignado(final InsertarAbogAsignado serv) ;

	
}