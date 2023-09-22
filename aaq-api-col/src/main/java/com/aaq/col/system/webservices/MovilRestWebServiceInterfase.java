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

import com.aaq.col.clases.webservices.movil.GETMovilInicioDeSesion;
import com.aaq.col.clases.webservices.movil.GETMovilReporte;
import com.aaq.col.clases.webservices.movil.GETMovilResultadoInicioDeSession;
import com.aaq.col.clases.webservices.movil.GETMovilResultadoOperacion;
import com.aaq.col.clases.webservices.movil.GETMovilServicioArribo;
import com.aaq.col.clases.webservices.movil.GETMovilServicioGestion;
import com.aaq.col.clases.webservices.movil.GETMovilServicioTermino;
import com.aaq.col.clases.webservices.movil.MovilResultadoOp;
import com.aaq.col.clases.webservices.movil.peticion.MovilCobroBancario;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosGrua;
import com.aaq.col.clases.webservices.movil.peticion.MovilIdealease;
import com.aaq.col.clases.webservices.movil.peticion.MovilInicioDeSesion;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilResumenAjustador;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioAbogado;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioAbogadoArribo;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioArribo;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioCartaCob;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioCoberturaEstimacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioCobroBancario;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioConfirmarGrua;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioDiverso;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioEncuesta;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioReconocimiento;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioServicio;
import com.aaq.col.clases.webservices.movil.peticion.MovilSolicitarTicketCondiciones;


@WebService(serviceName = "MovilRestWebService", name = "MovilRestWebService", targetNamespace = "http://com.jmfg.qualitas.com")
public interface MovilRestWebServiceInterfase {
	
		@WebMethod
		@Path("/insertar/termino")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public GETMovilResultadoOperacion insertarTermino( final GETMovilServicioTermino servicioTermino);

		@WebMethod
		@Path("/insertar/gestion")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public GETMovilResultadoOperacion insertarGestion(final GETMovilServicioGestion servicioGestion);

		@WebMethod
		@GET
		@Path("/solicitar/datos/reporte")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public GETMovilReporte solicitarDatosDeReporte(@QueryParam("") final GETMovilInicioDeSesion credenciales);
		
		@WebMethod
		@Path("/solicitar/inicio/sesion")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public GETMovilResultadoInicioDeSession solicitarInicioDeSesion(final GETMovilInicioDeSesion credenciales);

		@WebMethod
		@Path("/insertar/arribo")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public GETMovilResultadoOperacion insertarArribo(final GETMovilServicioArribo servicioArribo);

		@WebMethod
		@Path("/insertar/encuesta")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOp insertarEncuesta(final MovilServicioEncuesta serv);
		
		@WebMethod
		@Path("/insertar/cobertura/estimacion")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion insertarCoberturaEstimacion(final MovilServicioCoberturaEstimacion serv);
		
		@WebMethod
		@Path("/solicitar/cobro/bancario")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion solicitarCobroBancario(final MovilServicioCobroBancario serv) ;
		
		@WebMethod
		@Path("/insertar/abogado")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion insertarAbogado(final MovilServicioAbogado serv); 
		
		@WebMethod
		@Path("/insertar/abogado/arribo")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion insertarAbogadoArribo(final MovilServicioAbogadoArribo serv);
		
		@WebMethod
		@Path("/solicitar/servicio")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion solicitarServicio(final MovilServicioServicio serv);
		
		
		@WebMethod
		@Path("/solicitar/servicios/diversos")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion solicitarServiciosDiversos(final MovilServicioDiverso serv) ;
		
		@WebMethod
		@Path("/insertar/cartacob")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion insertarCartaCob(final MovilServicioCartaCob serv);
		
		@WebMethod
		@Path("/insertar/idealease")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion insertarIdealease(final MovilIdealease serv) ;
		
		@WebMethod
		@Path("/confirmar/grua")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion confirmarGrua( final MovilServicioConfirmarGrua confirmarGrua );
		
		@WebMethod
		@Path("/save/info/cobro")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion guardarCobroBancario(MovilCobroBancario serv);
		
		@WebMethod
		@Path("/insertar/reconocimiento")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion insertarReconocimiento( MovilServicioReconocimiento serv );
		
		@WebMethod
		@Path("/solicitar/datos/grua")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilDatosGrua solicitarDatosDeGrua(final MovilInicioDeSesion serv);
		
		@WebMethod
		@Path("/resumen/ajustador")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResumenAjustador resumenAjustador(@QueryParam("reporte") String reporte) ;
		
		@WebMethod
		@Path("/insertar/arribo/act")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion insertarArriboAct(final MovilServicioArribo serv); 
		
		@WebMethod
		@Path("/solicitar/ticket/condiciones")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes( MediaType.APPLICATION_JSON)
		public MovilResultadoOperacion solicitarTicketCondiciones(MovilSolicitarTicketCondiciones solicitarTicket) ;
}
