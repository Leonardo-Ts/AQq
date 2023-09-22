package com.aaq.col.system.webservices;

import java.sql.SQLException;
//import java.text.ParseException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.aaq.col.clases.webservices.formatos.FormatoAdmisionAutomoviles;
import com.aaq.col.clases.webservices.formatos.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.webservices.formatos.FormatoAdmisionPesado;
import com.aaq.col.clases.webservices.formatos.FormatoAsignacionAbogado;
import com.aaq.col.clases.webservices.formatos.FormatoAsistenciaVial;
import com.aaq.col.clases.webservices.formatos.FormatoCargoTarjetaCredito;
import com.aaq.col.clases.webservices.formatos.FormatoCuestionarioRobo;
import com.aaq.col.clases.webservices.formatos.FormatoDeclaracionUniversal;
import com.aaq.col.clases.webservices.formatos.FormatoEncuestaServicio;
import com.aaq.col.clases.webservices.formatos.FormatoGarantiaPrendaria;
import com.aaq.col.clases.webservices.formatos.FormatoInspeccionMoto;
import com.aaq.col.clases.webservices.formatos.FormatoInspeccionPesado;
import com.aaq.col.clases.webservices.formatos.FormatoInventarioAutomoviles;
import com.aaq.col.clases.webservices.formatos.FormatoInventarioUnicoPesado;
import com.aaq.col.clases.webservices.formatos.FormatoMemoriaDescriptiva;
import com.aaq.col.clases.webservices.formatos.FormatoNuevosVehiculos;
import com.aaq.col.clases.webservices.formatos.FormatoObservacionesAsegurado;
import com.aaq.col.clases.webservices.formatos.FormatoOrdenServicio;
import com.aaq.col.clases.webservices.formatos.FormatoPaseMedico;
import com.aaq.col.clases.webservices.formatos.FormatoReciboIngresoSiniestro;
import com.aaq.col.clases.webservices.formatos.FormatoReciboPagoDeducible;
import com.aaq.col.clases.webservices.formatos.FormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.webservices.formatos.FormatoReclamacionPendiente;
import com.aaq.col.clases.webservices.formatos.FormatoReparacionBienes;
import com.aaq.col.clases.webservices.formatos.FormatoReparacionBienesDiversos;
import com.aaq.col.clases.webservices.formatos.FormatoResponsabilidadCivil;
import com.aaq.col.clases.webservices.formatos.FormatoSolicitudDiagnostico;
import com.aaq.col.clases.webservices.formatos.FormatoValeAmbulancia;
import com.aaq.col.clases.webservices.formatos.FormatoOdaAuto;
import com.aaq.col.clases.webservices.movil.GETMovilResultadoOperacion;

import javax.ws.rs.core.MediaType;


@Path("/Resource")
//@Produces("application/json")
@WebService(serviceName = "FormatosRestWebServices", name = "FormatosRestWebServices", targetNamespace = "http://com.jmfg.qualitas.com")
public interface FormatosRestWebServicesInterface {

	// WEB SERVICES INSERTAR FORMATOS
	@WebMethod
	@Path("/storeFAV")
	@POST
	//@Produces({ MediaType.APPLICATION_JSON })
	public GETMovilResultadoOperacion InsertarFAV (@FormParam("") FormatoAsistenciaVial formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFVA")
	@POST
	public GETMovilResultadoOperacion InsertarFVA (@FormParam("") FormatoValeAmbulancia formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFRP")
	@POST
	public GETMovilResultadoOperacion InsertarFRP (@FormParam("") FormatoReclamacionPendiente formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFES")
	//@Consumes("application/json")
	//@Produces("application/json")
	@POST
	public GETMovilResultadoOperacion InsertarFES (@FormParam("") FormatoEncuestaServicio formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFOS")
	@POST
	public GETMovilResultadoOperacion InsertarFOS (@FormParam("") FormatoOrdenServicio formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFGP")
	@POST
	public GETMovilResultadoOperacion InsertarFGP (@FormParam("") FormatoGarantiaPrendaria formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFNV")
	@POST
	public GETMovilResultadoOperacion InsertarFNV (@FormParam("") FormatoNuevosVehiculos formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFRB")
	@POST
	public GETMovilResultadoOperacion InsertarFRB (@FormParam("") FormatoReparacionBienes formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFPM")
	@POST
	public GETMovilResultadoOperacion InsertarFPM (@FormParam("") FormatoPaseMedico formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFIA")
	@POST
	public GETMovilResultadoOperacion InsertarFIA (@FormParam("") FormatoInventarioAutomoviles formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFIP")
	@POST
	public GETMovilResultadoOperacion InsertarFIP (@FormParam("") FormatoInspeccionPesado formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFIM")
	@POST
	public GETMovilResultadoOperacion InsertarFIM (@FormParam("") FormatoInspeccionMoto formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFAAuto")
	@POST
	public GETMovilResultadoOperacion InsertarFAAuto (@FormParam("") FormatoAdmisionAutomoviles formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFAM")
	@POST
	public GETMovilResultadoOperacion InsertarFAM (@FormParam("") FormatoAdmisionMotocicletas formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFAP")
	@POST
	public GETMovilResultadoOperacion InsertarFAP (@FormParam("") FormatoAdmisionPesado formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFAABOGADO")
	@POST
	public GETMovilResultadoOperacion InsertarFAABOGADO (@FormParam("") FormatoAsignacionAbogado formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFCR")
	@POST
	public GETMovilResultadoOperacion InsertarFCR (@FormParam("") FormatoCuestionarioRobo formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFDU")
	@POST
	public GETMovilResultadoOperacion InsertarFDU (@FormParam("") FormatoDeclaracionUniversal formato)throws SQLException;
	
	@WebMethod
	@Path("/storeFRIngreso")
	@POST
	public GETMovilResultadoOperacion InsertarFRI(@FormParam("") FormatoReciboIngresoSiniestro formato) throws SQLException;
	
	@WebMethod
	@Path("/storeFRDeducible")
	@POST
	public GETMovilResultadoOperacion InsertarFRD(@FormParam("") FormatoReciboPagoDeducible formato) throws SQLException;

	@WebMethod
	@Path("/storeFSD")
	@POST
	public GETMovilResultadoOperacion InsertarFSD(@FormParam("") FormatoSolicitudDiagnostico formato) throws SQLException;


	@WebMethod
	@Path("/storeFMD")
	@POST
	public GETMovilResultadoOperacion InsertarFMD(@FormParam("") FormatoMemoriaDescriptiva formato) throws SQLException;

	//formato cargo tarjeta
	@WebMethod
	@Path("/storeFCT")
	@POST
	// @Produces({ MediaType.APPLICATION_JSON })
	public GETMovilResultadoOperacion InsertarFCT(@FormParam("") FormatoCargoTarjetaCredito formato) throws SQLException;
	
	@WebMethod
	@Path("/storeFRC")
	@POST
	public GETMovilResultadoOperacion InsertarFRC(@FormParam("") FormatoResponsabilidadCivil formato) throws SQLException;

	
	@WebMethod
	@Path("/storeFBD")
	@POST
	public GETMovilResultadoOperacion InsertarFBD(@FormParam("") FormatoReparacionBienesDiversos formato) throws SQLException;

	@WebMethod
	@Path("/storeFOA")
	@POST
	public GETMovilResultadoOperacion InsertarFOA(@FormParam("") FormatoObservacionesAsegurado formato) throws SQLException;

	@WebMethod
	@Path("/storeFINP")
	@POST
	public GETMovilResultadoOperacion InsertarFINP(@FormParam("") FormatoInventarioUnicoPesado formato) throws SQLException;

	@WebMethod
	@Path("/storeFRCP")
	@POST
	public GETMovilResultadoOperacion InsertarFRCP(@FormParam("") FormatoReclamacionComprobantePeaje formato) throws SQLException;

	@WebMethod
	@Path("/insertarODA")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public GETMovilResultadoOperacion InsertarFOAD(final FormatoOdaAuto formato) throws SQLException;

	
}
