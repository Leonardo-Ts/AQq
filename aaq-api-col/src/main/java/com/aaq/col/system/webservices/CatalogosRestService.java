package com.aaq.col.system.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aaq.col.clases.database.entidades.CatalogoAccidentes;
import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.aaq.col.clases.database.entidades.CatalogoClaseVeh;
import com.aaq.col.clases.database.entidades.CatalogoCoberturas;
import com.aaq.col.clases.database.entidades.CatalogoColores;
import com.aaq.col.clases.database.entidades.CatalogoCredenciales;
import com.aaq.col.clases.database.entidades.CatalogoDependencias;
import com.aaq.col.clases.database.entidades.CatalogoFaq;
import com.aaq.col.clases.database.entidades.CatalogoGrua;
import com.aaq.col.clases.database.entidades.CatalogoHospitales;
import com.aaq.col.clases.database.entidades.CatalogoMP;
import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.aaq.col.clases.database.entidades.CatalogoMarcaTerc;
import com.aaq.col.clases.database.entidades.CatalogoPartesAuto;
import com.aaq.col.clases.database.entidades.CatalogoRCBienes;
import com.aaq.col.clases.database.entidades.CatalogoRecuperaciones;
import com.aaq.col.clases.database.entidades.CatalogoTramoCar;
import com.aaq.col.clases.database.entidades.CatalogoVehTerc;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.aaq.col.clases.database.entidades.Municipio;
import com.aaq.col.clases.database.servicios.interfase.CatalogoAccidentesServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoAseguradoraServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoClaseVehServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCoberturasServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoColoresServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCredencialesServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoDependenciasServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoFaqServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoGruaServiceInterface;
import com.aaq.col.clases.database.servicios.interfase.CatalogoHospitalesServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMPServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMarcaServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMarcaTercServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoPartesAutoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRCBienesServiceInterface;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRecuperacionesServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoTramoCarServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehTercServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.EstadoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.FormatoCatalogosServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.MunicipioServiceInterfase;
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

public class CatalogosRestService implements CatalogosRestServiceInterfase {
	
	@Autowired
	CatalogoColoresServiceInterfase catColoresService;

	@Autowired
	CatalogoMarcaServiceInterfase catMarcasService;
	
	@Autowired
	CatalogoRecuperacionesServiceInterfase catRecuperacionesService;
	
	@Autowired
	EstadoServiceInterfase edoService;
	
	@Autowired
	MunicipioServiceInterfase municipioService;
	
	@Autowired
	CatalogoAseguradoraServiceInterfase catAseguradoraService;
	
	@Autowired
	CatalogoVehTercServiceInterfase catVehTercService;
	
	@Autowired
	CatalogoTramoCarServiceInterfase catTramoCarretService;
	
	@Autowired
	CatalogoFaqServiceInterfase catFaqService;
	
	@Autowired
	CatalogoClaseVehServiceInterfase catClaseVehService;
	
	@Autowired
	CatalogoCredencialesServiceInterfase catCredencialesService;
	
	@Autowired
	CatalogoAccidentesServiceInterfase catAccidentesService;
	
	@Autowired
	CatalogoRCBienesServiceInterface catalogoRCBienesService;
	
	@Autowired
	CatalogoGruaServiceInterface catGruaService;
	
	@Autowired
	CatalogoHospitalesServiceInterfase catHospitalesService;
	
	@Autowired
	CatalogoMarcaTercServiceInterfase catMarcaTercService;
	
	@Autowired
	CatalogoPartesAutoServiceInterfase catPartesAutoService;
	
	@Autowired
	CatalogoMPServiceInterfase catMPService;
	
	@Autowired
	CatalogoCoberturasServiceInterfase catCoberturasService;
	
	@Autowired
	CatalogoDependenciasServiceInterfase catDependenciasService;
	
	@Autowired
	FormatoCatalogosServiceInterfase catFormatosService;
	
	@Override
	public List<CatalogoRequest> catColores() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<CatalogoColores> salida = this.catColoresService.listaDeCatalogoColores(null, null);
		if (salida != null) {
			for (CatalogoColores catalogoColores : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(catalogoColores.getClave());
				cat.setDescripcion(catalogoColores.getDescripcion());
				respuesta.add(cat);
			}
			}
		return respuesta;
		}

	@Override
	public List<CatalogoCRequest> catMarcas() {
		List<CatalogoCRequest>  respuesta = new ArrayList<>();
		List<CatalogoMarca> salida = this.catMarcasService.listaDeCatalogoMarca();
		if (salida != null) {
			for (CatalogoMarca catal : salida) {
				CatalogoCRequest cat = new CatalogoCRequest();
				cat.setClave(catal.getClave());
				cat.setDescripcion(catal.getDescripcion());
				cat.setNombre(catal.getNombreMarca());
				respuesta.add(cat);
			}
			}
		return respuesta;
	}
	
	@Override
	public List<CatalogoRequest> catRecuperaciones() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<CatalogoRecuperaciones> salida = this.catRecuperacionesService.listaRecuperaciones(null, null);
		if (salida != null) {
			for (CatalogoRecuperaciones cat1 : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				respuesta.add(cat);
			}
			}
		return respuesta;
		}
	
	@Override
	public List<CatalogoRequest> catDepto() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<Estado> salida = this.edoService.listaDeEstado();
		if (salida != null) {
			for (Estado cat1 : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(cat1.getClaveEntidad());
				cat.setDescripcion(cat1.getNombre());
				respuesta.add(cat);
			}
			}
		return respuesta;
		}
	
	@Override
	public List<MunicipioRequest> catMunicipio() {
		List<MunicipioRequest>  respuesta = new ArrayList<>();
		List<Municipio> salida = this.municipioService.listaDeMunicipios(null);
		if (salida != null) {
			for (Municipio cat1 : salida) {
				MunicipioRequest cat = new MunicipioRequest();
				cat.setIdEntidad(String.valueOf(cat1.getEstado().getId()));
				cat.setIdMunicipio(String.valueOf(cat1.getId()));
				cat.setDescripcion(cat1.getNombre());
				cat.setClave(cat1.getClaveEntidad());
				respuesta.add(cat);
			}
			}
		return respuesta;
		}

	@Override
	public List<CatalogoRequest> catAseguradoras() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<CatalogoAseguradora> salida = this.catAseguradoraService.listaCatalogoAseguradora(null, null);
		if (salida != null) {
			for (CatalogoAseguradora cat1 : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				respuesta.add(cat);
			}
			}
		return respuesta;
	}

	@Override
	public List<CatalogoRequest> catVehTerc() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<CatalogoVehTerc> salida = this.catVehTercService.listaDeCatalogoVehTerc(null, null);
		if (salida != null) {
			for (CatalogoVehTerc cat1 : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				respuesta.add(cat);
			}
			}
		return respuesta;
	}

	@Override
	public List<CatalogoRequest> catTramoCarretero() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<CatalogoTramoCar> salida = this.catTramoCarretService.listaDeCatalogoTramoCar(null, null);
		if (salida != null) {
			for (CatalogoTramoCar cat1 : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				respuesta.add(cat);
			}
			}
		return respuesta;
	}

	@Override
	public List<FaqRequest> catFaq() {
		List<FaqRequest>  respuesta = new ArrayList<>();
		List<CatalogoFaq> salida = this.catFaqService.listaDeCatalogoFaq(null, null);
		if (salida != null) {
			for (CatalogoFaq cat1 : salida) {
				FaqRequest cat = new FaqRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				cat.setMensaje(cat1.getMensaje());
				cat.setResponsable(cat1.getResponsable());
				respuesta.add(cat);
			}
			}
		return respuesta;
	}

	@Override
	public List<CatalogoRequest> catClaseVeh() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<CatalogoClaseVeh> salida = this.catClaseVehService.listaDeCatalogoClaseVeh(null, null);
		if (salida != null) {
			for (CatalogoClaseVeh cat1 : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<CredencialesRequest> catCredenciales() {
		List<CredencialesRequest>  respuesta = new ArrayList<>();
		List<CatalogoCredenciales> salida = this.catCredencialesService.listaDeCatalogoCredenciales(null, null, null, null);
		if (salida != null) {
			for (CatalogoCredenciales cat1 : salida) {
				CredencialesRequest cat = new CredencialesRequest();
				cat.setNombre(cat1.getNombre());
				cat.setDireccion(cat1.getDireccion());
				cat.setPwd(cat1.getPwd());
				cat.setUrl(cat1.getUrl());
				cat.setUsuario(cat1.getUsuario());
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<AccidentesRequest> catAccidentes() {
		List<AccidentesRequest>  respuesta = new ArrayList<>();
		List<CatalogoAccidentes> salida = this.catAccidentesService.listaDeCatalogoAccidentes(null, null, null);
		if (salida != null) {
			for (CatalogoAccidentes cat1 : salida) {
				AccidentesRequest cat = new AccidentesRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				cat.setCodigo(cat1.getCodigo());
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<RCBienesRequest> catRCBienes() {
		List<RCBienesRequest>  respuesta = new ArrayList<>();
		List<CatalogoRCBienes> salida = this.catalogoRCBienesService.listaCatalogoRCBienes(null, null);
		if (salida != null) {
			for (CatalogoRCBienes cat1 : salida) {
				RCBienesRequest cat = new RCBienesRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				cat.setTipoAfecta(cat1.getTipoAfecta());;
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<GruaRequest> catGua() {
		List<GruaRequest>  respuesta = new ArrayList<>();
		List<CatalogoGrua> salida = this.catGruaService.listaDeCatalogoGrua(null, null, null);
		if (salida != null) {
			for (CatalogoGrua cat1 : salida) {
				GruaRequest cat = new GruaRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				cat.setCodigo(cat1.getCodigo());
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<HospitalesRequest> catHospitales() {
		List<HospitalesRequest>  respuesta = new ArrayList<>();
		List<CatalogoHospitales> salida = this.catHospitalesService.listaDeCatalogoHospitales(null);
		if (salida != null) {
			for (CatalogoHospitales cat1 : salida) {
				HospitalesRequest cat = new HospitalesRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				cat.setDirección(cat1.getDireccion());
				cat.setTelefono(cat1.getTelefono());
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<MarcaTercRequest> catMarcaTercero() {
		List<MarcaTercRequest>  respuesta = new ArrayList<>();
		List<CatalogoMarcaTerc> salida = this.catMarcaTercService.listaDeCatalogoMarcaTerc(null, null);
		if (salida != null) {
			for (CatalogoMarcaTerc cat1 : salida) {
				MarcaTercRequest cat = new MarcaTercRequest();
				cat.setClave(cat1.getClave());
				cat.setDescripcion(cat1.getDescripcion());
				cat.setAutosYsubcompactos(cat1.getSubCompactos());
				cat.setSemipesado(cat1.getSemipesado());
				cat.setPesado(cat1.getPesado());
				cat.setMotos(cat1.getMotos());
				cat.setBlindado(cat1.getBlindado());
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<PartesAutoRequest> catPartesAuto() {
		List<PartesAutoRequest>  respuesta = new ArrayList<>();
		List<CatalogoPartesAuto> salida = this.catPartesAutoService.listaDeCatalogoPartesAuto(null, null, null);
		if (salida != null) {
			for (CatalogoPartesAuto cat1 : salida) {
				PartesAutoRequest cat = new PartesAutoRequest();
				cat.setTipoPartes(cat1.getTipoParte());
				cat.setNumParte(cat1.getNumParte());
				cat.setNombreParte(cat1.getNombreParte());
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<MPRequest> catMP() {
		List<MPRequest>  respuesta = new ArrayList<>();
		List<CatalogoMP> salida = this.catMPService.listaDeCatalogoMP(null, null);
		if (salida != null) {
			for (CatalogoMP cat1 : salida) {
				MPRequest cat = new MPRequest();
				cat.setClave(cat1.getClave());
				cat.setIdEntidad(cat1.getEntidad());
				cat.setIdMunicipio(cat1.getMunicipio());
				cat.setDescripcion(cat1.getDescripcion());
				cat.setDireccion(cat1.getDireccion());
				cat.setMunicipioLegal(cat1.getMunicipioLegal());
				cat.setEntidad(cat1.getEntidad());
				cat.setMunicipio(cat1.getMunicipio());
				respuesta.add(cat);
			}
		}
		return respuesta;
	}

	@Override
	public List<CatalogoRequest> catCoberturas() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<CatalogoCoberturas> salida = this.catCoberturasService.listaDeCatalogoCoberturas(null, null);
		if (salida != null) {
			for (CatalogoCoberturas catC : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(catC.getClave());
				cat.setDescripcion(catC.getDescripcion());
				respuesta.add(cat);
			}
			}
		return respuesta;
	}

	@Override
	public List<CatalogoRequest> catDependencias() {
		List<CatalogoRequest>  respuesta = new ArrayList<>();
		List<CatalogoDependencias> salida = this.catDependenciasService.listaDeCatalogoDependencias(null, null);
		if (salida != null) {
			for (CatalogoDependencias catC : salida) {
				CatalogoRequest cat = new CatalogoRequest();
				cat.setClave(catC.getClave());
				cat.setDescripcion(catC.getDescripcion());
				respuesta.add(cat);
			}
			}
		return respuesta;
	}

	@Override
	public List<FormatosRequest> catFormatos() {
		List<FormatosRequest>  respuesta = new ArrayList<>();
		List<FormatoCatalogos> salida = this.catFormatosService.listaDeFormatoCatalogos();
		if (salida != null) {
			for (FormatoCatalogos catC : salida) {
				FormatosRequest cat = new FormatosRequest();
				cat.setNombre(catC.getNombre());
				cat.setValores(catC.getValores());;
				respuesta.add(cat);
			}
		  }
		return respuesta;
	}
	
}
