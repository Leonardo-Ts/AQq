package com.aaq.col.clases.database.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractHistoricoResumenAjustador;
import com.aaq.col.clases.database.entidades.pojo.Abogado;
import com.aaq.col.clases.database.entidades.pojo.AsignacionReporte;
import com.aaq.col.clases.database.entidades.pojo.Cobertura;
import com.aaq.col.clases.database.entidades.pojo.Cobro;
import com.aaq.col.clases.database.entidades.pojo.CobroData;
import com.aaq.col.clases.database.entidades.pojo.InsertarCobertura;
import com.aaq.col.clases.database.entidades.pojo.InsertarGestion;
import com.aaq.col.clases.database.entidades.pojo.InsertarTermino;
import com.aaq.col.clases.database.entidades.pojo.Recupero;
import com.aaq.col.clases.database.entidades.pojo.RespuetaCobro;
import com.aaq.col.clases.database.entidades.pojo.SolicitarFolio;
import com.aaq.col.clases.database.entidades.pojo.SolicitarGrua;
import com.aaq.col.clases.database.entidades.pojo.Tercero;
import com.aaq.col.clases.database.servicios.interfase.HistoricoResumenAjustadorServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.aaq.col.clases.pojo.conclusion.CoberturasL;
import com.aaq.col.clases.pojo.conclusion.Grua;
import com.aaq.col.clases.pojo.conclusion.InfoSupervisorServicio;
import com.aaq.col.clases.pojo.conclusion.InformacionAbogado;
import com.aaq.col.clases.pojo.conclusion.PaseMedico;
import com.aaq.col.clases.pojo.conclusion.Reparacion;
import com.aaq.col.clases.util.UtileriaCadenas;
import com.aaq.col.clases.webservices.movil.aex.CoberturaRA;
import com.aaq.col.clases.webservices.movil.aex.InsertarCoberturaRA;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "historicoResumenAjustador")
@RequestScoped
@Entity(name = "HistoricoResumenAjustador")
@Access(AccessType.FIELD)
@Table(name = "historico_resumen_ajustador")
public class HistoricoResumenAjustador extends AbstractHistoricoResumenAjustador {
	private static final long serialVersionUID = 7586678956091435365L;

	/** default constructor */
	public HistoricoResumenAjustador() {
		this.setFechaActividad(new Date());

	}

	private static HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorService;

	public static HistoricoResumenAjustadorServiceInterfase getHistoricoResumenAjustadorService() {
		if (HistoricoResumenAjustador.historicoResumenAjustadorService == null) {
			HistoricoResumenAjustador.historicoResumenAjustadorService = JMSIICAServerServiceSingleton.getInstance()
					.getHistoricoResumenAjustadorService();
		}
		return HistoricoResumenAjustador.historicoResumenAjustadorService;
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return HistoricoResumenAjustador.getHistoricoResumenAjustadorService().eliminarObjeto(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error(this.getClass().getSimpleName() + "==> eliminarObjeto", ex);
			return new JMResultadoOperacion(ex);
		}

	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return HistoricoResumenAjustador.getHistoricoResumenAjustadorService().guardarObjeto(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error(this.getClass().getSimpleName() + "==> guardarObjeto", ex);

			return new JMResultadoOperacion(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, List<Map<String, Object>>> getActividadObj() {
		if (UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
			Map<String, List<Map<String, Object>>> actividadMap = new HashMap<>();
			Gson gson = new Gson();
			actividadMap = gson.fromJson(this.getDescripcionActividad(), Map.class);
			return actividadMap;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, List<Map<String, Object>>> getResultadoObj() {
		if (UtileriaCadenas.validaJson(this.getResultado())) {
			Map<String, List<Map<String, Object>>> actividadMap = new HashMap<>();
			Gson gson = new Gson();
			actividadMap = gson.fromJson(this.getResultado(), Map.class);
			return actividadMap;
		} else {
			return null;
		}
	}

	public InsertarGestion getActividadInsertarGestion() {
		InsertarGestion respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Insertar Gestión") &&
				!this.getResultado().contains("ERROR")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();
					respuesta = new InsertarGestion();
					respuesta = gson.fromJson(this.getDescripcionActividad(), InsertarGestion.class);
					
					if(respuesta != null && respuesta.getRecuperos()!=null){
						for (Recupero rec : respuesta.getRecuperos()) {
							String[] terceroNumero = StringUtils.split(rec.getNumeroTercero(),"T");
							rec.setNumeroTercero(terceroNumero[0]);
							rec.setFecha(this.getFechaActividad());
						}
					}
					if(respuesta != null && respuesta.getTerceros()!=null){
						for (Tercero rec : respuesta.getTerceros()) {
							String[] terceroNumero = StringUtils.split(rec.getNumeroTercero(),"T");
							rec.setNumeroTercero(terceroNumero[0]);
							
							switch (rec.getTipoTercero()) {
							case "V":
								rec.setTipoTercero("Vehículo");
								break;
							case "P":
								rec.setTipoTercero("Persona");
								break;
							case "O":
								rec.setTipoTercero("Objeto");
								break;

							default:
								break;
							}
							
							rec.setFecha(this.getFechaActividad());
						}
					}
				}				
			}
		}
		return respuesta;
	}

	public SolicitarFolio getActividadSolicitarFolio() {
		SolicitarFolio respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Solicitar Folio")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();
					respuesta = new SolicitarFolio();
					respuesta = gson.fromJson(this.getDescripcionActividad(), SolicitarFolio.class);
					if (respuesta.getTipoAfectado().equals("A")) {
						respuesta.setTipoAfectado("Asegurado");
					} else {
						if (StringUtils.contains(respuesta.getTipoAfectado(), "T")) {
							String[] terceroNumero = StringUtils.split(respuesta.getTipoAfectado(),"T");
							respuesta.setTipoAfectado("Tercero "+terceroNumero[0]);
						}
					}
					if (StringUtils.equals(respuesta.getServicioSolicitado(), "Hospital") || StringUtils.equals(respuesta.getServicioSolicitado(), "Ambulancia")) {
						respuesta.setTag("Nombre de Lesionado:");
					}
					respuesta.setFolio(this.getResultado());
					respuesta.setFecha(this.getFechaActividad());		
					if (respuesta.getNombreProveedor() == null) {
						respuesta.setNombreProveedor(" ");
					}
				}									
			}			
		} 
		return respuesta;
	}

	public Map<String, Object> getDatosReporte() {
		Map<String, Object> respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Insertar Término")) {
			respuesta = new HashMap<String, Object>();
			respuesta.put("reporte", this.getGeneralNumeroReporte());
			respuesta.put("claveAjustador", this.getClaveAjustador());
			respuesta.put("fecha", this.getFechaActividad());
			respuesta.put("Ajustador", this.getNombreAjustador());
		}
		return respuesta;
	}
	
	public Map<String, Object> getActividadArribo() {
		Map<String, Object> respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Insertar Arribo")) {
			respuesta = new HashMap<String, Object>();
			respuesta.put("origen", this.getFuente());
			respuesta.put("fecha", this.getFechaActividad());
		}
		return respuesta;
	}

	public AsignacionReporte getActividadAsignacionReporte() {		
		AsignacionReporte respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Asignación Reporte")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {	
					Gson gson = new Gson();
					respuesta = new AsignacionReporte();
					respuesta = gson.fromJson(this.getDescripcionActividad(), AsignacionReporte.class);
					respuesta.setFecha(this.getFechaActividad());
					respuesta.setOrigen(this.getFuente());
				}				
			}
		}
		return respuesta;
	}

	public InsertarTermino getActividadTerminoReporte() {	
		InsertarTermino respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Insertar Término")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();
					respuesta = new InsertarTermino();
					respuesta = gson.fromJson(this.getDescripcionActividad(), InsertarTermino.class);
					if(respuesta.getCodigoResp() != null && respuesta.getDescCodigoResp() != null){
						respuesta.setCodigoResp(respuesta.getCodigoResp()+" - "+respuesta.getDescCodigoResp());
					}else{
						if(respuesta.getCodigoResp() != null && respuesta.getDescCodigoResp() == null){
							respuesta.setCodigoResp(respuesta.getCodigoResp());
						}
					}					
					respuesta.setFecha(this.getFechaActividad());
					respuesta.setOrigen(this.getFuente());
				}				
			}
		}
		return respuesta;
	}

	public InsertarCobertura getActividadInsertarCobertura() {	
		InsertarCobertura respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Insertar Cobertura - Estimación")) {			
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();			
					respuesta = new InsertarCobertura();
					respuesta = gson.fromJson(this.getDescripcionActividad(), InsertarCobertura.class);	
					if(respuesta.getCoberturas()!=null){
						for (Cobertura rec : respuesta.getCoberturas()) {
							rec.setFecha(this.getFechaActividad());
						}
					}
				}				
			}
		} 
		return respuesta;
	}

	public SolicitarGrua getActividadSolicitarGrua() {
		SolicitarGrua respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Solicitar Grua")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();
					respuesta = new SolicitarGrua();
					respuesta = gson.fromJson(this.getDescripcionActividad(), SolicitarGrua.class);
					if (respuesta.getTipoAfectado().equals("A")) {
						respuesta.setTipoAfectado("Asegurado");
					} else {
						if (StringUtils.contains(respuesta.getTipoAfectado(), "T")) {
							String[] terceroNumero = StringUtils.split(respuesta.getTipoAfectado(),"T");
							respuesta.setTipoAfectado("Tercero "+terceroNumero[0]);
						}
					}
					
					respuesta.setRespuestaGruasColi(this.getResultado());
					respuesta.setFecha(this.getFechaActividad());
					
					try {
						ReporteMovilSacGruas reporteGrua = ReporteMovilSacGruas.getReporteMovilSacGruasService().
								objetoReporteMovilSacGruas(this.getGeneralNumeroReporte(), this.getClaveAjustador());
						
						if ( reporteGrua == null ) {
							respuesta.setClaveProovedor(  " " );
							respuesta.setProveedorNombre( " " );
							
						} else {
							respuesta.setClaveProovedor( reporteGrua.getProveedorClave() );
							respuesta.setProveedorNombre( reporteGrua.getProveedorNombre() );
						}
						
					} catch (Exception e) {
						
					}
					
				}				
			}
		} 
		return respuesta;
	}

	public CobroData getActividadCobroBancario() {
		CobroData respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Cobro Bancario")) {
			Gson gson = new Gson();
			respuesta = new CobroData();
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {	
					Cobro cobro = new Cobro();
					cobro = gson.fromJson(this.getDescripcionActividad(), Cobro.class);
					respuesta.setTipoCobro(cobro.getTipoCobro());
					respuesta.setMonto(cobro.getMonto());
					respuesta.setMesesSinIntereses(cobro.getMesesSinIntereses());
					respuesta.setCoberturaAfectada(cobro.getCoberturaAfectada());
				}				
			}
			
			if (this.getResultado() != null) {
				if(UtileriaCadenas.validaJson(this.getResultado())) {	
					RespuetaCobro resCobro = new RespuetaCobro();
					resCobro = gson.fromJson(this.getResultado(), RespuetaCobro.class);
					respuesta.setEstatus(resCobro.getEstatus());
					respuesta.setNumeroAutorizacion(resCobro.getNumeroAutorizacion());
					respuesta.setNumeroOperacion(resCobro.getNumeroOperacion());
				}							
			}
				
			respuesta.setFecha(this.getFechaActividad());
		} 
		return respuesta;
	}

	public Abogado getActividadAbogado() {
		Abogado respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Insertar Abogado")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();
					respuesta = new Abogado();
					respuesta = gson.fromJson(this.getDescripcionActividad(), Abogado.class);
					respuesta.setFecha(this.getFechaActividad());
					respuesta.setVehiculoDetenido(respuesta.getVehiculoDetenido().equals("true")?"SI":"NO");
					respuesta.setConductorDetenido(respuesta.getConductorDetenido().equals("true")?"SI":"NO");
				}				
			}				
		} 
		return respuesta;
	}

	@Override
	public String toString() {
		return  "Actividad: " + this.getActividad() + " Descripcion: " + this.getDescripcionActividad(); 
	}

	public Date getFechaHoraArribo() {
		Date respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Insertar Arribo")) {
			respuesta =  this.getFechaActividad();
		}
		return respuesta;
	}
	
	public InsertarCoberturaRA getActividadInsertarCoberturaRA() {	
		InsertarCoberturaRA respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Insertar Cobertura - Estimación")) {			
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();			
					respuesta = new InsertarCoberturaRA();
					respuesta = gson.fromJson(this.getDescripcionActividad(), InsertarCoberturaRA.class);	
					if(respuesta.getCoberturas()!=null){
						for (CoberturaRA rec : respuesta.getCoberturas()) {
							String pattern = "dd/MM/yyyy HH:mm:ss";
							DateFormat df = new SimpleDateFormat(pattern);
					        String fecha = df.format(this.getFechaActividad());
							rec.setFecha(fecha);
						}
					}
				}				
			}
		} 
		return respuesta;
	}
	

	
	
	public Reparacion getActividadReparacionMovil() {
		Reparacion respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Solicitar Folio")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();
					respuesta = new Reparacion();
					respuesta = gson.fromJson(this.getDescripcionActividad(), Reparacion.class);
					if (StringUtils.contains(respuesta.getServicioSolicitado(), "Taller") || StringUtils.contains(respuesta.getServicioSolicitado(), "Agencia")) {
					if (respuesta.getTipoAfectado().equals("A")) {
						respuesta.setTipoAfectado("Asegurado");
					} else {
						if (StringUtils.contains(respuesta.getTipoAfectado(), "T")) {
							String[] terceroNumero = StringUtils.split(respuesta.getTipoAfectado(),"T");
							respuesta.setTipoAfectado("Tercero "+terceroNumero[0]);
						}
					}
					respuesta.setFolio(this.getResultado());
					respuesta.setFecha(this.getFechaActividad());		
					if (respuesta.getNombreProveedor() == null) {
						respuesta.setNombreProveedor(" ");
					}
					} else {
						return null;
					}
				}
			}	
		} 
		return respuesta;
	}
	
	
	public Reparacion getActividadReparacion() {
		Reparacion respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Servicio ODR Externo")) {
//			if (this.getDescripcionActividad() != null) {
//				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
//					Gson gson = new Gson();
//					respuesta = new Reparacion();
//					respuesta = gson.fromJson(this.getDescripcionActividad(), Reparacion.class);
//					if (StringUtils.contains(respuesta.getServicioSolicitado(), "Taller")) {
//						respuesta.setServicioSolicitado("Taller");
//						if (respuesta.getNombreProveedor() == null) {
//							respuesta.setNombreProveedor(" ");
//						}
//						
//						if (respuesta.getClaveProveedor() == null) {
//							respuesta.setClaveProveedor(" ");
//						}
//					} else {
//						return null;
//					}
//					
//				}									
//			}	
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();
					respuesta = new Reparacion();
					respuesta = gson.fromJson(this.getDescripcionActividad(), Reparacion.class);
					if (respuesta.getTipoAfectado().equals("A")) {
						respuesta.setTipoAfectado("Asegurado");
					} else {
						if (StringUtils.contains(respuesta.getTipoAfectado(), "T")) {
							String[] terceroNumero = StringUtils.split(respuesta.getTipoAfectado(),"T");
							respuesta.setTipoAfectado("Tercero "+terceroNumero[0]);
						}
					}
					respuesta.setFolio(this.getResultado());
					respuesta.setFecha(this.getFechaActividad());		
					if (respuesta.getNombreProveedor() == null) {
						respuesta.setNombreProveedor(" ");
					}
				}
			}	
		} 
		return respuesta;
	}
	
	public PaseMedico getActividadPaseMedico() {
		PaseMedico respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Solicitar Folio")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
				Gson gson = new Gson();
				respuesta = new PaseMedico();
				respuesta = gson.fromJson(this.getDescripcionActividad(), PaseMedico.class);
				
				if (StringUtils.equals(respuesta.getServicioSolicitado(), "Hospital") || StringUtils.equals(respuesta.getServicioSolicitado(), "Ambulancia")) {
						if (respuesta.getTipoAfectado().equals("A")) {
							respuesta.setTipoAfectado("Asegurado");
						} else {
							if (StringUtils.contains(respuesta.getTipoAfectado(), "T")) {
								String[] terceroNumero = StringUtils.split(respuesta.getTipoAfectado(),"T");
								respuesta.setTipoAfectado("Tercero "+terceroNumero[0]);
							}
						}
						if (StringUtils.equals(respuesta.getServicioSolicitado(), "Hospital") || StringUtils.equals(respuesta.getServicioSolicitado(), "Ambulancia")) {
							respuesta.setTag("Nombre de Lesionado:");
						}
						respuesta.setFolio(this.getResultado());
						respuesta.setFecha(this.getFechaActividad());		
						if (respuesta.getNombreProveedor() == null) {
							respuesta.setNombreProveedor(" ");
						}
					}  else {
						return null;
					}
					} else {
						return null;
					}
			}			
		}	
		
		return respuesta;
	}
	
	public Grua getActividadSolicitarServicioGrua() {
		Grua respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Solicitar Grua")) {
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();
					respuesta = new Grua();
					respuesta = gson.fromJson(this.getDescripcionActividad(), Grua.class);
					if (respuesta.getTipoAfectado().equals("A")) {
						respuesta.setTipoAfectado("Asegurado");
					} else {
						if (StringUtils.contains(respuesta.getTipoAfectado(), "T")) {
							String[] terceroNumero = StringUtils.split(respuesta.getTipoAfectado(),"T");
							respuesta.setTipoAfectado("Tercero "+terceroNumero[0]);
						}
					}
					
					respuesta.setRespuestaGruasColi(this.getResultado());
					respuesta.setFecha(this.getFechaActividad());
					
					try {
						ReporteMovilSacGruas reporteGrua = ReporteMovilSacGruas.getReporteMovilSacGruasService().
								objetoReporteMovilSacGruas(this.getGeneralNumeroReporte(), this.getClaveAjustador());
						
						if ( reporteGrua == null ) {
							respuesta.setClaveProveedor(  " " );
							respuesta.setProveedorNombre( " " );
							
						} else {
							respuesta.setClaveProveedor( reporteGrua.getProveedorClave() );
							respuesta.setProveedorNombre( reporteGrua.getProveedorNombre() );
						}
						
					} catch (Exception e) {
						
					}
					
				}				
			}
		} 
		return respuesta;
	}

	public com.aaq.col.clases.pojo.conclusion.Abogado getActividadSolicitarAbogado() {
		com.aaq.col.clases.pojo.conclusion.Abogado respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Insertar Abogado")) {
			if (this.getDescripcionActividad() != null) {
						if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
							Gson gson = new Gson();
							respuesta = new com.aaq.col.clases.pojo.conclusion.Abogado();
							respuesta = gson.fromJson(this.getDescripcionActividad(), com.aaq.col.clases.pojo.conclusion.Abogado.class);
							respuesta.setFecha(this.getFechaActividad());
							respuesta.setVehiculoDetenido(respuesta.getVehiculoDetenido().equals("true")?"SI":"NO");
							respuesta.setConductorDetenido(respuesta.getConductorDetenido().equals("true")?"SI":"NO");
						}				
			}				
		} 
		return respuesta;
	}
	
	public CoberturasL getActividadInsertarCoberturaN() {	
		CoberturasL respuesta = null;
		if (this.getActividad().equalsIgnoreCase("Insertar Cobertura - Estimación")) {			
			if (this.getDescripcionActividad() != null) {
				if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
					Gson gson = new Gson();			
					respuesta = new CoberturasL();
					respuesta = gson.fromJson(this.getDescripcionActividad(), CoberturasL.class);	
				}				
			}
		} 
		return respuesta;
	}

	public InformacionAbogado getActividadInfoAbogado() {
		InformacionAbogado respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Datos Abogado")) {
			if (this.getDescripcionActividad() != null) {
						if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
							Gson gson = new Gson();
							respuesta = new InformacionAbogado();
							respuesta = gson.fromJson(this.getDescripcionActividad(), InformacionAbogado.class);
						}				
			}				
		} 
		return respuesta;
	}
	
	public InfoSupervisorServicio getActividadInfoSupervServicio() {
		InfoSupervisorServicio respuesta = null;		
		if (this.getActividad().equalsIgnoreCase("Datos Supervisor Servicio")) {
			if (this.getDescripcionActividad() != null) {
						if(UtileriaCadenas.validaJson(this.getDescripcionActividad())) {
							Gson gson = new Gson();
							respuesta = new InfoSupervisorServicio();
							respuesta = gson.fromJson(this.getDescripcionActividad(), InfoSupervisorServicio.class);
						}				
			}				
		} 
		return respuesta;
	}
	
}
