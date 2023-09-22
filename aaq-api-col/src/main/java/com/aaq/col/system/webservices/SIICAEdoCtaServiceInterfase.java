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

import com.aaq.col.system.model.EdoCtaEntry;
import com.aaq.col.system.model.EstadoCuentaRequest;
import com.aaq.col.system.model.SerieEdoCtaRequest;


@WebService(serviceName="EdoCtaRestService", name="EdoCtaRestService", targetNamespace="http://com.jmfg.qualitas.com")
public interface SIICAEdoCtaServiceInterfase {
	
	@WebMethod
	@POST
	@Path("/consulta/edo/cuenta")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	EstadoCuentaRequest consultaEdoCta(final EdoCtaEntry serv );
	
	@WebMethod
	@GET
	@Path("/act/tel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	String pruebaTelefonosSISE(@QueryParam("clave") String clave,@QueryParam("tel") String tel);

	@WebMethod
	@GET
	@Path("/consulta/serie/poliza")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	SerieEdoCtaRequest serieEdoCta(@QueryParam("serie") String serie,@QueryParam("claveProveedor") String claveProveedor);

}
