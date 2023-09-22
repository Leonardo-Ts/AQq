package com.aaq.col.system.webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aaq.col.system.model.AccidentesRequest;
import com.aaq.col.system.model.CatalogoCRequest;
import com.aaq.col.system.model.CatalogoRequest;
import com.aaq.col.system.model.CredencialesRequest;
import com.aaq.col.system.model.FaqRequest;
import com.aaq.col.system.model.FormatosRequest;
import com.aaq.col.system.model.GruaRequest;
import com.aaq.col.system.model.HospitalesRequest;
import com.aaq.col.system.model.MPRequest;
import com.aaq.col.system.model.MarcaTercRequest;
import com.aaq.col.system.model.MunicipioRequest;
import com.aaq.col.system.model.PartesAutoRequest;
import com.aaq.col.system.model.RCBienesRequest;

@WebService(serviceName="CatRestService", name="CatRestService", targetNamespace="http://com.jmfg.qualitas.com")
public interface CatalogosRestServiceInterfase {

	
	@WebMethod
	@GET
	@Path("/colores")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catColores();
	
	@WebMethod
	@GET
	@Path("/marcas")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoCRequest> catMarcas();
	
	@WebMethod
	@GET
	@Path("/recuperaciones")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catRecuperaciones();
	
	@WebMethod
	@GET
	@Path("/depto")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catDepto();

	@WebMethod
	@GET
	@Path("/municipio")
	@Produces(MediaType.APPLICATION_JSON)
	List<MunicipioRequest> catMunicipio();

	@WebMethod
	@GET
	@Path("/aseguradoras")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catAseguradoras();
	
	@WebMethod
	@GET
	@Path("/vehTerc")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catVehTerc();
	
	@WebMethod
	@GET
	@Path("/tramo/carretero")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catTramoCarretero();
	
	@WebMethod
	@GET
	@Path("/faq")
	@Produces(MediaType.APPLICATION_JSON)
	List<FaqRequest> catFaq();
	
	@WebMethod
	@GET
	@Path("/clase/vehiculo")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catClaseVeh();
	
	@WebMethod
	@GET
	@Path("/credenciales")
	@Produces(MediaType.APPLICATION_JSON)
	List<CredencialesRequest> catCredenciales();
	
	@WebMethod
	@GET
	@Path("/accidentes")
	@Produces(MediaType.APPLICATION_JSON)
	List<AccidentesRequest> catAccidentes();
	
	@WebMethod
	@GET
	@Path("/rcbienes")
	@Produces(MediaType.APPLICATION_JSON)
	List<RCBienesRequest> catRCBienes();
	
	@WebMethod
	@GET
	@Path("/grua")
	@Produces(MediaType.APPLICATION_JSON)
	List<GruaRequest> catGua();
	
	@WebMethod
	@GET
	@Path("/hospitales")
	@Produces(MediaType.APPLICATION_JSON)
	List<HospitalesRequest> catHospitales();
	
	@WebMethod
	@GET
	@Path("/marca/tercero")
	@Produces(MediaType.APPLICATION_JSON)
	List<MarcaTercRequest> catMarcaTercero();
	
	@WebMethod
	@GET
	@Path("/partes/auto")
	@Produces(MediaType.APPLICATION_JSON)
	List<PartesAutoRequest> catPartesAuto();
	
	@WebMethod
	@GET
	@Path("/mp")
	@Produces(MediaType.APPLICATION_JSON)
	List<MPRequest> catMP();
	
	@WebMethod
	@GET
	@Path("/coberturas")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catCoberturas();
	
	@WebMethod
	@GET
	@Path("/dependencias")
	@Produces(MediaType.APPLICATION_JSON)
	List<CatalogoRequest> catDependencias();
	
	@WebMethod
	@GET
	@Path("/formato")
	@Produces(MediaType.APPLICATION_JSON)
	List<FormatosRequest> catFormatos() ;
	
}
