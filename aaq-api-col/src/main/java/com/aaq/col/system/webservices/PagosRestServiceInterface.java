package com.aaq.col.system.webservices;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aaq.col.clases.pojo.pagos.ConsultarDetalles;
import com.aaq.col.clases.pojo.pagos.LinkPago;
import com.aaq.col.clases.pojo.pagos.MovilDetallesPago;
import com.aaq.col.clases.pojo.pagos.PagoReferenciado;
import com.aaq.col.clases.webservices.formatos.FormatoOdaAuto;
import com.aaq.col.clases.webservices.movil.GETMovilResultadoOperacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;


@Path("/rest/")
@WebService(serviceName="PagoRestService", name ="PagoRestService", targetNamespace="http://com.jmfg.qualitas.com")
public interface PagosRestServiceInterface {
	
	@WebMethod
	@Path("/link/pago")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOperacion obtenerLinkDePago(final LinkPago entrada);
	
	@WebMethod
	@Path("/pago/referenciado")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilResultadoOperacion pagoReferenciado(final PagoReferenciado entrada);
	
	@WebMethod
	@Path("/consulta/detalles/pago")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public MovilDetallesPago detallesPago(final ConsultarDetalles entrada);
	
	@WebMethod
	@Path("/insertarODA")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	//public GETMovilResultadoOperacion InsertarFOAD(final FormatoOdaAuto formato) throws SQLException;
	public String InsertarFOAD(final FormatoOdaAuto formato) throws SQLException;

}
