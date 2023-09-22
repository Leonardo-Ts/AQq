package com.aaq.col.system.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aaq.col.clases.pojo.conclusion.ConclusionAjustador;
import com.aaq.col.clases.pojo.notificacion.Correo;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;

@Path("/SIICANotificacionRestService")
@WebService(serviceName="SIICANotificacionRestService", name ="SIICANotificacionRestService", targetNamespace="http://com.jmfg.qualitas.com")
public interface SIICANotificacionRestServiceInterfase {


	@WebMethod
	@Path("/aviso/termino")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOperacion enviarCorreoTermino(final Correo entrada);
	
	
	@WebMethod
	@Path("/aviso/termino/expres")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOperacion enviarCorreoExpres(final ConclusionAjustador entrada);
	
	
}
