package com.aaq.col.system.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aaq.col.clases.pojo.aaq.DatosCodigosResponsabilidad;
import com.aaq.col.clases.pojo.aaq.ExamenTEP;
import com.aaq.col.clases.pojo.aaq.FotografiasReg;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.aaq.col.system.model.ExternoHistoricoT;

@WebService(serviceName="MovilRestService", name ="MovilRestService", targetNamespace="http://com.jmfg.qualitas.com")
public interface MovilRestServiceInterfase {

	@WebMethod
	@Path("/codigo/responsabilidad/est")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOperacion estadisticaCodigoResp(final DatosCodigosResponsabilidad entrada);
	
	@WebMethod
	@Path("/examen/tep")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOperacion examenTEP(final ExamenTEP entrada);
	
	@WebMethod
	@Path("/control/fotografias")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOperacion controlFotografias(final FotografiasReg entrada);
	
	
	@WebMethod
	@Path("/historico/terminal")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOperacion historicoTerminal(final ExternoHistoricoT entrada);
	
	
}
