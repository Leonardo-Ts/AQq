package com.aaq.col.system.beans.extensibles;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Vector;
import javax.faces.event.ActionEvent;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.entidades.CatalogoOficina;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.database.entidades.GeocercaByEstado;
import com.aaq.col.clases.database.entidades.Horarios;
import com.aaq.col.clases.database.entidades.Modulo;
import com.aaq.col.clases.database.entidades.Municipio;
import com.aaq.col.clases.database.entidades.Session;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.servicios.interfase.*;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.system.database.entidades.modelo.SessionDataModel;
import com.jmfg.jmlib.sistema.beans.JMBeanExtensibleBasico;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.web.spring.JMBeanSpringSocketServidor;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

public abstract class JMBeanExtensiblePrincipal<T extends JMEntidad> extends JMBeanExtensibleBasico<T> {
	private static final long serialVersionUID = -5763557212576757016L;

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_BEANS);

	// Campos comunes
	private String idEstado;
	private String idMunicipio;
	private String idBase;
	private String idTerminal;
	@SuppressWarnings("unused")
	private String idEstadoMonitor;
	@SuppressWarnings("unused")
	private String idEstadoFiltroTerminal;
	private String claveHorario="-9999";

	
	// Estaticos
	private static String siicaVersion;
	private static String siicaRevision;
	private static String siicaResponsableNombre;
	private static String siicaResponsableEmail;
	private static String siicaCopyRight;
	private static String siicaLogotipo;
	private static String siicaScroller;

	// Dao
	private BaseServiceInterfase baseService = JMSIICAServerServiceSingleton.getInstance().getBaseService();
	private CalleCruceServiceInterfase calleCruceService = JMSIICAServerServiceSingleton.getInstance().getCalleCruceService();
	private CalleServiceInterfase calleService = JMSIICAServerServiceSingleton.getInstance().getCalleService();
	private CalleDireccionServiceInterfase calleDireccionService = JMSIICAServerServiceSingleton.getInstance().getCalleDireccionService();
	private CarreteraServiceInterfase carreteraService = JMSIICAServerServiceSingleton.getInstance().getCarreteraService();
	private CartografiaServiceInterfase cartografiaService = JMSIICAServerServiceSingleton.getInstance().getCartografiaService();
	private CatalogoAseguradoraServiceInterfase catalogoAseguradoraService = JMSIICAServerServiceSingleton.getInstance().getCatalogoAseguradoraService();
	private CatalogoClaveDeEntidadServiceInterfase catalogoClaveDeEntidadService = JMSIICAServerServiceSingleton.getInstance().getCatalogoClaveDeEntidadService();
	private CatalogoCodigoDeCausaServiceInterfase catalogoCodigoDeCausaService = JMSIICAServerServiceSingleton.getInstance().getCatalogoCodigoDeCausaService();
	private CatalogoCodigoRespuestaBancarioServiceInterfase catalogoCodigoRespuestaBancarioService = JMSIICAServerServiceSingleton.getInstance().getCatalogoCodigoRespuestaBancarioService();
	private CatalogoMarcaServiceInterfase catalogoMarcaService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMarcaService();
	private CatalogoMarcaEstiloServiceInterfase catalogoMarcaEstiloService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMarcaEstiloService();
	private CatalogoOficinaServiceInterfase catalogoOficinaService = JMSIICAServerServiceSingleton.getInstance().getCatalogoOficinaService();
	private CatalogoProveedorAsistenciaServiceInterfase catalogoProveedorAsistenciaService = JMSIICAServerServiceSingleton.getInstance().getCatalogoProveedorAsistenciaService();
	private CatalogoProveedorAsistenciaIdentificadorServiceInterfase catalogoProveedorAsistenciaIdentificadorService = JMSIICAServerServiceSingleton.getInstance().getCatalogoProveedorAsistenciaIdentificadorService();
	private CatalogoTipoAsistenciaServiceInterfase catalogoTipoAsistenciaService = JMSIICAServerServiceSingleton.getInstance().getCatalogoTipoAsistenciaService();
	private CatalogoVehiculoTipoServiceInterfase catalogoVehiculoTipoService = JMSIICAServerServiceSingleton.getInstance().getCatalogoVehiculoTipoService();
	private CatalogoVehiculoUsoServiceInterfase catalogoVehiculoUsoService = JMSIICAServerServiceSingleton.getInstance().getCatalogoVehiculoUsoService();
	private ColoniaServiceInterfase coloniaService = JMSIICAServerServiceSingleton.getInstance().getColoniaService();
	private ComunicadoServiceInterfase comunicadoService = JMSIICAServerServiceSingleton.getInstance().getComunicadoService();
	private ConfiguracionServiceInterfase configuracionService = JMSIICAServerServiceSingleton.getInstance().getConfiguracionService();
	private EstadoServiceInterfase estadoService = JMSIICAServerServiceSingleton.getInstance().getEstadoService();
	private EncuestaAjustadorServiceInterfase encuestaAjustadorService = JMSIICAServerServiceSingleton.getInstance().getEncuestaAjustadorService();
	private FrecuenciaBaseServiceInterfase frecuenciaBaseService = JMSIICAServerServiceSingleton.getInstance().getFrecuenciaBaseService();
	private FrecuenciaServiceInterfase frecuenciaService = JMSIICAServerServiceSingleton.getInstance().getFrecuenciaService();
	private GrupoTerminalServiceInterfase grupoTerminalService = JMSIICAServerServiceSingleton.getInstance().getGrupoTerminalService();
	private HorarioGrupoServiceInterfase horarioGrupoService = JMSIICAServerServiceSingleton.getInstance().getHorarioGrupoService();
	private GrupoServiceInterfase grupoService = JMSIICAServerServiceSingleton.getInstance().getGrupoService();
	private HorariosServiceInterfase horariosService = JMSIICAServerServiceSingleton.getInstance().getHorariosService();
	private GeocercaByEstadoServiceInterfase geocercaByEstadoService = JMSIICAServerServiceSingleton.getInstance().getGeocercaByEstadoService();
	private GeocercaServiceInterfase geocercaService = JMSIICAServerServiceSingleton.getInstance().getGeocercaService();
	private GeocercaPuntoServiceInterfase geocercaPuntoService = JMSIICAServerServiceSingleton.getInstance().getGeocercaPuntoService();
	private HistoricoTerminalServiceInterfase historicoTerminalService = JMSIICAServerServiceSingleton.getInstance().getHistoricoTerminalService();
	private MensajeSmsServiceInterfase mensajeSmsService = JMSIICAServerServiceSingleton.getInstance().getMensajeSmsService();
	private ModuloServiceInterfase moduloService = JMSIICAServerServiceSingleton.getInstance().getModuloService();
	private ModuloPadreServiceInterfase moduloPadreService = JMSIICAServerServiceSingleton.getInstance().getModuloPadreService();
	private MunicipioServiceInterfase municipioService = JMSIICAServerServiceSingleton.getInstance().getMunicipioService();
	private PerfilServiceInterfase perfilService = JMSIICAServerServiceSingleton.getInstance().getPerfilService();
	private PermisoServiceInterfase permisoService = JMSIICAServerServiceSingleton.getInstance().getPermisoService();
	private PuntoInteresServiceInterfase puntoInteresService = JMSIICAServerServiceSingleton.getInstance().getPuntoInteresService();
	private PuntoInteresTipoServiceInterfase puntoInteresTipoService = JMSIICAServerServiceSingleton.getInstance().getPuntoInteresTipoService();
	private ReferenciaServiceInterfase referenciaService = JMSIICAServerServiceSingleton.getInstance().getReferenciaService();
	private ReporteAbogadoServiceInterfase reporteAbogadoService = JMSIICAServerServiceSingleton.getInstance().getReporteAbogadoService();
	private ReporteMovilServiceInterfase reporteMovilService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilService();
	private ReporteSiseServiceInterfase reporteSiseService = JMSIICAServerServiceSingleton.getInstance().getReporteSiseService();
	private ReporteSolicitadoServiceInterfase reporteSolicitadoService = JMSIICAServerServiceSingleton.getInstance().getReporteSolicitadoService();
	private SessionServiceInterfase sessionService = JMSIICAServerServiceSingleton.getInstance().getSessionService();
	private SessionExternaServiceInterfase sessionExternaService = JMSIICAServerServiceSingleton.getInstance().getSessionExternaService();
	private SiniestroServiceInterfase siniestroService = JMSIICAServerServiceSingleton.getInstance().getSiniestroService();
	private TerminalAlertaServiceInterfase terminalAlertaService = JMSIICAServerServiceSingleton.getInstance().getTerminalAlertaService();
	private TerminalServiceInterfase terminalService = JMSIICAServerServiceSingleton.getInstance().getTerminalService();
	private TerminalLogServiceInterfase terminalLogService = JMSIICAServerServiceSingleton.getInstance().getTerminalLogService();
	private TerminalReporteServiceInterfase terminalReporteService = JMSIICAServerServiceSingleton.getInstance().getTerminalReporteService();
	private TerminalReporteDocumentoServiceInterfase terminalReporteDocumentoService = JMSIICAServerServiceSingleton.getInstance().getTerminalReporteDocumentoService();
	private TerminalReporteDocumentoTipoServiceInterfase terminalReporteDocumentoTipoService = JMSIICAServerServiceSingleton.getInstance().getTerminalReporteDocumentoTipoService();
	private TransaccionServiceInterfase transaccionService = JMSIICAServerServiceSingleton.getInstance().getTransaccionService();
	private UsuarioServiceInterfase usuarioService = JMSIICAServerServiceSingleton.getInstance().getUsuarioService();
	private UsuarioFrecuenciaServiceInterfase usuarioFrecuenciaService = JMSIICAServerServiceSingleton.getInstance().getUsuarioFrecuenciaService();
	private UsuarioLogServiceInterfase usuarioLogService = JMSIICAServerServiceSingleton.getInstance().getUsuarioLogService();
	private ReporteMovilSacServiceInterfase reporteMovilSacService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilSacService();
	private SacSP_ServiceInterfase sacSP_ServiceInterfase = JMSIICAServerServiceSingleton.getInstance().getSacSP_ServiceInterfase();
	private SiseSP_ServiceInterfase siseSP_ServiceInterfase = JMSIICAServerServiceSingleton.getInstance().getSiseSP_ServiceInterfase();
	private ReporteMovilSacTercerosServiceInterfase reporteMovilSacTercerosService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilSacTercerosService();
	private ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilSacGruasService();
	private CatalogoMovilServiceInterfase catalogoMovilService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMovilService();
	private CatalogoVehiculoAjusServiceInterfase catalogoVehiculoAjusService = JMSIICAServerServiceSingleton.getInstance().getCatalogoVehiculoAjusService();
	private	TerminalComentarioServiceInterfase terminalComentarioService = JMSIICAServerServiceSingleton.getInstance().getTerminalComentarioService();
	private	HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorService = JMSIICAServerServiceSingleton.getInstance().getHistoricoResumenAjustadorService();
	private CorreoPolizaAgenteServiceInterfase correoPolizaAgenteService = JMSIICAServerServiceSingleton.getInstance().getCorreoPolizaAgenteService();
	private ExpedienteEjecutivoServiceInterfase expedienteEjecutivoService = JMSIICAServerServiceSingleton.getInstance().getExpedienteEjecutivoService();
	private NotasReporteServiceInterfase notasReporteService = JMSIICAServerServiceSingleton.getInstance().getNotasReporteService();
	private CodigoResponsabilidadEstadServiceInterfase codigoResponsabilidadEstad = JMSIICAServerServiceSingleton.getInstance().getCodigoResponsabilidadEstadService();
	private UsuarioAlertasServiceInterfase usuarioAlertasService = JMSIICAServerServiceSingleton.getInstance().getUsuarioAlertasService();
	private CodigoResponsabilidadEstadServiceInterfase codigoResponsabilidadEstService = JMSIICAServerServiceSingleton.getInstance().getCodigoResponsabilidadEstadService();
	private ControlFotografiasServiceInterfase controlFotografiasService = JMSIICAServerServiceSingleton.getInstance().getControlFotografiasService();
	private FormatoReclamacionPendienteServiceInterfase formatoReclamacionPendienteService = JMSIICAServerServiceSingleton.getInstance().getFormatoReclamacionPendienteService();
	private FormatoEncuestaServicioServiceInterfase formatoEncuestaServicioService = JMSIICAServerServiceSingleton.getInstance().getFormatoEncuestaServicioService();
	private FormatoAsistenciaVialServiceInterfase formatoAsistenciaVialService = JMSIICAServerServiceSingleton.getInstance().getFormatoAsistenciaVialService();
	private FormatoNuevosVehiculosServiceInterfase formatoNuevosVehiculosService = JMSIICAServerServiceSingleton.getInstance().getFormatoNuevosVehiculosService();
	private FormatoPaseMedicoServiceInterfase formatoPaseMedicoService = JMSIICAServerServiceSingleton.getInstance().getFormatoPaseMedicoService();
	private FormatoAsignacionAbogadoServiceInterfase formatoAsignacionAbogadoService = JMSIICAServerServiceSingleton.getInstance().getFormatoAsignacionAbogadoService();
	private FormatoAdmisionAutomovilesServiceInterfase formatoAdmisionAutomovilesService = JMSIICAServerServiceSingleton.getInstance().getFormatoAdmisionAutomovilesService();
	private FormatoAdmisionMotocicletasServiceInterfase formatoAdmisionMotocicletasService = JMSIICAServerServiceSingleton.getInstance().getFormatoAdmisionMotocicletasService();
	private FormatoGarantiaPrendariaServiceInterfase formatoGarantiaPrendaria = JMSIICAServerServiceSingleton.getInstance().getFormatoGarantiaPrendariaService();
	private FormatoReparacionBienesServiceInterfase formatoReparacionBienesService = JMSIICAServerServiceSingleton.getInstance().getFormatoReparacionBienesService();
	private FormatoValeAmbulanciaServiceInterfase  formatoValeAmbulanciaService = JMSIICAServerServiceSingleton.getInstance().getFormatoValeAmbulanciaService();
	private FormatoOrdenServicioServiceInterfase formatoOrdenServicioService = JMSIICAServerServiceSingleton.getInstance().getFormatoOrdenServicioService();
	private FormatoInspeccionPesadoServiceInterfase formatoInspeccionPesado = JMSIICAServerServiceSingleton.getInstance().getFormatoInspeccionPesadoService();
	private FormatoInspeccionMotoServiceInterfase formatoInspeccionMotoService = JMSIICAServerServiceSingleton.getInstance().getFormatoInspeccionMotoService();
	private FormatoAdmisionPesadoServiceInterfase formatoAdmisionPesadoService = JMSIICAServerServiceSingleton.getInstance().getFormatoAdmisionPesadoService();
	private FormatoInventarioAutomovilesServiceInterfase formatoInventarioService = JMSIICAServerServiceSingleton.getInstance().getFormatoInventarioAutomovilesService();
	private FormatoCuestionarioRoboServiceInterfase  formatoCuestionarioRoboService= JMSIICAServerServiceSingleton.getInstance().getFormatoCuestionarioRoboService();
	private FormatoDeclaracionUniversalServiceInterfase formatoDeclaracionUniversal = JMSIICAServerServiceSingleton.getInstance().getFormatoDeclaracionUniversalService();
	private FormatoReciboPagoDeducibleServiceInterfase formatoReciboPagoDeducible = JMSIICAServerServiceSingleton.getInstance().getFormatoReciboPagoDeducibleService();
	private FormatoReciboIngresoSiniestroServiceInterfase formatoReciboIngresoSiniestroService  = JMSIICAServerServiceSingleton.getInstance().getFormatoReciboIngresoSiniestroService();
	private FormatoSolicitudDiagnosticoServiceInterfase formatoSolicitudDiagnostico = JMSIICAServerServiceSingleton.getInstance().getFormatoSolicitudDiagnosticoService();
	private FormatoMemoriaDescriptivaServiceInterfase formatoMemoriaDescriptiva = JMSIICAServerServiceSingleton.getInstance().getFormatoMemoriaDescriptivaService();
	private FormatoCargoTarjetaCreditoServiceInterfase formatoCargoTarjetaCredito = JMSIICAServerServiceSingleton.getInstance().getFormatoCargoTarjetaCreditoService();
	private FormatoResponsabilidadCivilServiceInterfase formatoResponsabilidadCivil  = JMSIICAServerServiceSingleton.getInstance().getFormatoResponsabilidadCivilService();
	private FormatoReparacionBienesDiversosServiceInterfase formatoReparacionBienesDiversos = JMSIICAServerServiceSingleton.getInstance().getFormatoReparacionBienesDiversosService();
	private FormatoObservacionesAseguradoServiceInterfase formatoObservacionesAsegurado = JMSIICAServerServiceSingleton.getInstance().getFormatoObservacionesAseguradoService();
	private FormatoInventarioUnicoPesadoServiceInterfase formatoInventarioUnicoPesado = JMSIICAServerServiceSingleton.getInstance().getFormatoInventarioUnicoPesadoService();
	private FormatoReclamacionComprobantePeajeServiceInterfase formatoReclamacionComprobantePeaje = JMSIICAServerServiceSingleton.getInstance().getFormatoReclamacionComprobantePeajeService();
	private MetricaEDServiceInterfase metricaEDService = JMSIICAServerServiceSingleton.getInstance().getMetricaEDService();
	private CargaDatosCSVServiceInterfase cargaDatosService = JMSIICAServerServiceSingleton.getInstance().getCargaDatosService();
	private CatalogoRecuperacionesServiceInterfase catagalogoRecuperacionesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoRecuperacionesService();
	private CatalogoColoresServiceInterfase catalogoColoresService = JMSIICAServerServiceSingleton.getInstance().getCatalogoColoresService();
	private CatalogoVehTercServiceInterfase catalogoVehTercService = JMSIICAServerServiceSingleton.getInstance().getCatalogoVehTercService();
	private CatalogoDependenciasServiceInterfase catalogoDependenciasService = JMSIICAServerServiceSingleton.getInstance().getCatalogoDependenciasService();
	private CatalogoTramoCarServiceInterfase catalogoTramoCarService = JMSIICAServerServiceSingleton.getInstance().getCatalogoTramoCarService();
	private CatalogoFaqServiceInterfase catalogoFaqService = JMSIICAServerServiceSingleton.getInstance().getCatalogoFaqService();
	private CatalogoCoberturasServiceInterfase catalogoCoberturasService = JMSIICAServerServiceSingleton.getInstance().getCatalogoCoberturasService();
	private CatalogoClaseVehServiceInterfase catalogoClaseVehService = JMSIICAServerServiceSingleton.getInstance().getCatalogoClaseVehService();
	private CatalogoCredencialesServiceInterfase catalogoCredencialesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoCredencialesService();
	private CatalogoAccidentesServiceInterfase catalogoAccidentesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoAccidentesService();
	private CatalogoRCBienesServiceInterface catalogoRCBienesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoRCBienesService();
	private CatalogoGruaServiceInterface catalogoGruaService = JMSIICAServerServiceSingleton.getInstance().getCatalogoGruaService();
	private CatalogoHospitalesServiceInterfase catalogoHospitalesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoHospitalesService();
	private CatalogoMarcaTercServiceInterfase catalogoMarcaTercService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMarcaTercService();
	private CatalogoPartesAutoServiceInterfase catalogoPartesAutoService = JMSIICAServerServiceSingleton.getInstance().getCatalogoPartesAutoService(); 
	private CatalogoMPServiceInterfase catalogoMPService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMPService();
	private FormatoCatalogosServiceInterfase formatoCatalogosService = JMSIICAServerServiceSingleton.getInstance().getFormatoCatalogosService();
	
	private int paso;
	private static List<Estado> listaEstados;
	
	// Para quien ES
	private static Boolean esParaBanorte;
	private static Boolean esParaQualitas;

	// Beans de Spring
	private static JMBeanSpringSocketServidor springServidorTCP;
	private static JMBeanSpringSocketServidor springServidorUDP;
	
	private MenuModel modeloMenu;
	
	// **************************************************************//
	// Metodo inicial de esta clase
	// **************************************************************//
	/**
	 * Constructor
	 */
	public JMBeanExtensiblePrincipal() {
		super();

		// Poner en session Web
		if (this.getUsuarioActual() != null) {

			if (this.obtenerSession() != null) {
				Session session = null;
				try {
					session = this.getSessionService().objetoSessionParaIdentificador(this.obtenerSession().getId());
				} catch (final Exception ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"Constructor => objetoSessionParaIdentificador");
				}
				if (session != null) {
					session.setFechaUltimoMovimiento(new Date());
					session.setDireccionIp(this.obtenerDireccionIp());
					session.setPaginaActual(this.getNombrePagina());
					session.setUsuario(this.getUsuarioActual());
					session.guardarObjeto();
				}
			}
			

			if (StringUtils.isBlank(this.getIdEstado())) {
				this.setIdEstado(Objects.toString(this.getUsuarioActual().getEstado().getId(), ""));
				//this.setIdEstado(Objects.toString(this.getUsuarioActual().getEstado().getId(), ""));
//				this.setIdEstado(Objects.toString("33", ""));
				
			} 
			//List<Estado> estados = this.getEstadoFrecuencia();
			//this.setIdEstadoMonitor(""+estados.get(0).getId());
		}

		if (this.getTxtFechaInicio() == null) {
			this.setTxtFechaInicio(new Date());
		}
		if (this.getTxtFechaFin() == null) {
			this.setTxtFechaFin(new Date(System.currentTimeMillis() + JMUtileriaFecha.TIEMPO_1_DIA));
		}

	}
	
		
	
	public List<Base> getListaDeBases() {
		return this.obtenerListaDeBasesParaEstado(this.getIdEstado(), false);
	}

	public List<Base> getListaDeBases(final String estado) {
		if (StringUtils.isNotBlank(estado)) {
			return this.obtenerListaDeBasesParaEstado(estado, true);
		}
		return new Vector<>();
	}

	public List<Base> getListaDeBasesTodas() {
		if(getPermisoTodosEstados() && getPermisoTodosBases()){
			
			return this.obtenerListaDeBasesParaEstado(this.getIdEstado(), true);
		}else {
			return this.getListaDeBasesPorFrecuencia();
		}
	}// filtros por frecuencia catalogo terminal

	public List<Base> obtenerListaDeBasesParaEstado(final String estado, final boolean todas) {
		try {
			
			return this.getBaseService().listaDeBase(this.getEstadoService().objetoEstado(estado), todas);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"obtenerListaDeBasesParaEstado => listaDeBase");
			return new Vector<>();
		}
	}
	
	public List<CatalogoOficina> obtenerListaDeOficinaParaEstado(String estado){
		try{
			Estado est = new Estado();
			est.setId(Integer.parseInt(estado));
			return this.getCatalogoOficinaService().listaDeCatalogoOficina(est);
		}catch (Exception ex){
			return new Vector<>(); 
		}
	}
	
	public List<Municipio> getListaDeMunicipios() {
		try {
			return this.getMunicipioService().listaDeMunicipios(
					this.getEstadoService().objetoEstado(this.getIdEstado()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"getListaDeMunicipios => listaDeMunicipios");
			return new Vector<>();

		}
	}

	public List<Municipio> getListaDeMunicipios(final String estado) {
		try {
			return this.getMunicipioService().listaDeMunicipios(this.getEstadoService().objetoEstado(estado));
		} catch (final Exception ex) {

			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"getListaDeMunicipios => listaDeMunicipios");
			return new Vector<>();
		}
	}
	
	public List<GeocercaByEstado> getListaDeGeocercaByEstado(String estado) {
		if (StringUtils.isNotBlank(estado)) {

			try {
				return this.getGeocercaByEstadoService().listaDeGeocercaByEstado(estado);
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"ListaDeGeocercaByEstado => listaDeGeocercaByEstado");
				return new Vector<>();
			}
		}
		return new Vector<>();
	}

	public SessionDataModel getListaDeSessiones() {
		try {
			List<Session> sessions = this.getSessionService().listaDeSession();
			return new SessionDataModel(sessions);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeSessiones => listaDeSession");
		}
		return null;
	}

	public List<Terminal> getListaDeTerminalesParaMapa() {
		final List<Terminal> listaRetorno = new Vector<>();
				
		List<Terminal> lt = null;

		try {
			lt = this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getIdEstado()),
					this.getBaseService().objetoBase(this.getIdBase()), Boolean.TRUE);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"getListaDeTerminalesParaMapa => listaDeTerminal");
		}

		if (lt != null) {
			for (final Terminal terminal : lt) {
				if (terminal.getUltimoLocalizacionFecha() != null) {
					if ((System.currentTimeMillis() - terminal.getUltimoLocalizacionFecha().getTime()) < JMUtileriaFecha.TIEMPO_05_MINUTOS) {
						terminal.setEstaConectada(Boolean.TRUE);
					}
				}
				listaRetorno.add(terminal);
			}

		}

		return listaRetorno;
	}

	public List<Terminal> getListaDeTerminalesParaSeleccion() {
		try {
			return this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getIdEstado()),
					this.getBaseService().objetoBase(this.getIdBase()));
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"getListaDeTerminalesParaSeleccion => listaDeTerminal");
			return new Vector<>();
		}
	}
	
	public List<Terminal> getListaDeTerminalesFrecuenciaParaSeleccion() {
		try {
			return this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getIdEstado()),
					this.getBaseService().objetoBase(this.getIdBase()));
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"getListaDeTerminalesParaSeleccion => listaDeTerminal");
			return new Vector<>();
		}
	}
	
	public List<Horarios> getListaDeHorariosParaSeleccion(){
		try {
			 return this.getHorariosService().listaDeHorarios();
		} catch ( final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "getListaDeHorariosParaSeleccion");
			return new Vector<>();
		}
	}

	public List<Terminal> getListaDeTerminalesParaEstadoYBase(final String estado, final String base) {
		if (StringUtils.isNotBlank(estado) && StringUtils.isNotBlank(base)) {
			try {
				return this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(estado),
						this.getBaseService().objetoBase(base));
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"getListaDeTerminalesParaEstadoYBase => listaDeTerminal");
			}

		}
		return new Vector<>();
	}

	public List<Terminal> getListaDeTerminalesParaUsuario() {
		try {
			return this.getTerminalService().listaDeTerminal(this.getUsuarioActual().getEstado(),
					this.getUsuarioActual().getBase());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"getListaDeTerminalesParaUsuario => listaDeTerminal");
			return new Vector<>();
		}
	}

	public List<Usuario> getListaDeUsuariosEnSession() {
		List<Session> lista = null;
		try {
			lista = this.sessionService.listaDeSession();
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"getListaDeUsuariosEnSession => listaDeSession");

		}

		final List<Usuario> listaRetorno = new Vector<>();
		if (lista != null) {
			for (final Session session : lista) {
				if (session.getUsuario() != null) {
					listaRetorno.add(session.getUsuario());
				}
			}
		}
		return listaRetorno;
	}

	public List<CatalogoCodigoDeCausa> getListaDeCatalogoCodigoDeCausa() {
		try {
			return this.getCatalogoCodigoDeCausaService().listaDeCatalogoCodigoDeCausa();
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"getListaDeCatalogoCodigoDeCausa => listaDeCatalogoCodigoDeCausa");
			return new Vector<>();
		}

	}

	public String doAccionContinuar() {
		this.setObjetoABM(null);
		return null;
	}

	public boolean getPermisoABM() {
		return false;
	}

	public boolean getEsPaginaQueNoRequiereLogin() {
		final String nombre = this.getNombrePagina().replaceAll("xhtml", "siica");
		if (StringUtils.containsIgnoreCase(nombre, "firma") || StringUtils.containsIgnoreCase(nombre, "session")
				|| StringUtils.containsIgnoreCase(nombre, "externo")
				|| StringUtils.containsIgnoreCase(nombre, "denegado")
				|| StringUtils.containsIgnoreCase(nombre, "error") || StringUtils.containsIgnoreCase(nombre, "sistema")
				|| StringUtils.containsIgnoreCase(nombre, "404") || StringUtils.containsIgnoreCase(nombre, "inicio")
				|| StringUtils.containsIgnoreCase(nombre, "500")
				|| StringUtils.containsIgnoreCase(nombre, "documentacionConfirmacion")
				|| StringUtils.containsIgnoreCase(nombre, "documentacionResultado")

		) {
			return true;
		}
		return false;
	}

	/**
	 * @return el paso
	 */
	public boolean getEsPaso1() {
		return this.paso == 1;
	}

	/**
	 * @return el paso
	 */
	public boolean getEsPaso2() {
		return this.paso == 2;
	}

	/**
	 * @return el paso
	 */
	public boolean getEsPaso3() {
		return this.paso == 3;
	}

	// **************************************************************//
	// Propiedades String del componente
	// **************************************************************//

	/**
	 * @return el year
	 */
	public int getActualYear() {
//		this.listaAjustadorListaSOS();
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * @return el year
	 */
	public String getLoader() {
		if ((this.getUsuarioActual() != null) && (this.getUsuarioActual().getId() != null)) {
			final int id = this.getUsuarioActual().getId().intValue();
			final Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());

			if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
					&& ((id == 663) || (id == 708) || (id == 712) || (id == 714) || (id == 741))) {
				return "ajaxloadingbar_heart.gif";

			}
		}
		return "ajaxloadingbar.gif";
	}

	public String getLigaInicio() {

		if (this.getTieneSesion()) {
//			this.listaAjustadorListaSOS();
			return this.getPathDeServlet() + JMConstantes.PRINCIPAL_LIGA_INICIO_CON_SESSION;
		}
		return this.getPathDeServlet() + JMConstantes.PRINCIPAL_LIGA_INICIO_SIN_SESSION;
	}

	public String getListaDeIDSParaTerminales() {
		final StringBuilder builder = new StringBuilder();

		for (final Terminal terminal : this.getListaDeTerminalesParaMapa()) {
			builder.append(StringUtils.isBlank(Objects.toString(builder)) ? Objects.toString(terminal.getId(), "")
					: "," + Objects.toString(terminal.getId(), ""));
		}
		return Objects.toString(builder, "");
	}

	// **************************************************************//
	// Getters avanzados
	// **************************************************************//

	public String getIdBase() {
		if (this.idBase == null) {

			if (this.getUsuarioActual() != null) {
				this.idBase = Objects.toString(this.getUsuarioActual().getBase().getId(), "");
			} else {
				this.idBase = "-1";
			}
		}

		return this.idBase;
	}

	public String getIdEstado() {
		if (StringUtils.isBlank(this.idEstado)) {
			if (this.getUsuarioActual() != null) {
				this.idEstado = Objects.toString(this.getUsuarioActual().getEstado().getId(), "");
			}
		}
		return this.idEstado;
	}

	@SuppressWarnings("unchecked")
	public List<Modulo> getListaDeModulos(final String padre, final String pagina) {
		if (StringUtils.isNotBlank(padre) && StringUtils.isNotBlank(pagina)
				&& (this.getPaginasPermitidasParaModulo(pagina) != null)) {

			if (this.obtenerObjetoDeSession("modulo_" + padre + "_" + pagina) == null) {

				List<Modulo> lm = null;
				try {
					lm = this.getModuloService().listaDeModulo(this.getModuloPadreService().objetoModuloPadre(padre),
							StringUtils.splitPreserveAllTokens(this.getPaginasPermitidasParaModulo(pagina), ","), true);
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "getListaDeModulos => listaDeModulo");
				}
				if (lm != null) {
					this.ponerObjetoEnSession("modulo_" + padre + "_" + pagina, lm);
				}
			}
			return (List<Modulo>) this.obtenerObjetoDeSession("modulo_" + padre + "_" + pagina);

		}
		return null;
	}

	public List<Modulo> getListaDeModulosDeAplicaciones() {
		return this.getListaDeModulos("1", "Aplicacion");
	}

	public List<Modulo> getListaDeModulosDeCatalogos() {
		return this.getListaDeModulos("2", "Catalogo");
	}

	public List<Modulo> getListaDeModulosDeSIISEOR() {
		return this.getListaDeModulos("4", "SiseOR");

	}

	public List<Modulo> getListaDeModulosDeReporte() {
		return this.getListaDeModulos("5", "Reporte");
	}

	public List<Modulo> getListaDeModulosDeOperacion() {
		return this.getListaDeModulos("7", "Operacion");
	}
	
	public List<Modulo> getListaDeModulosDeCatalogosEdit() {
		return this.getListaDeModulos("8", "Catalogacion");
	}

	public List<Modulo> getListaDeModulosDeCatalogoProveedorAVQ() {
		return this.getListaDeModulos("8", "AVQ/catalogoProveedor");
	}

	public List<Modulo> getListaDeModulosDeCatalogoPolizaAVQ() {
		return this.getListaDeModulos("8", "AVQ/catalogoPoliza");
	}

	public List<Modulo> getListaDeModulosDeCatalogoServicioAVQ() {
		return this.getListaDeModulos("8", "AVQ/catalogoServicio");
	}

	public List<Modulo> getListaDeModulosDeReporteAVQ() {
		return this.getListaDeModulos("8", "AVQ/reporte");
	}

	public List<Modulo> getListaDeModulosDeServicioAVQ() {
		return this.getListaDeModulos("8", "AVQ/servicio");
	}

	public List<Modulo> getListaDeModulosDeImportacionAVQ() {
		return this.getListaDeModulos("8", "AVQ/importacion");
	}

	public boolean getPermisoTodosEstados() {
		return this
				.getTienePermisoParaPagina("/SIICAGlobal/todosLosEstados.siica");
	}

	public boolean getPermisoTodosBases() {
		return this
				.getTienePermisoParaPagina("/SIICAGlobal/todasLasBases.siica");
	}
	
	public boolean getPermisoAlarmaVisto() {
		return this
				.getTienePermisoParaPagina("/SIICAGlobal/alarmaAjustador.siica");
	}
	


	public boolean getValidarPaginaActual() {

		if (this.getEsPaginaQueNoRequiereLogin()) {
			return true;
		}
//		this.listaAjustadorListaSOS();
		return this.getTienePermisoParaPagina(this.getNombrePagina().replaceAll("xhtml", "siica"));

	}

	@SuppressWarnings("unchecked")
	public String getPaginasPermitidasParaModulo(final String modulos) {

		if ((this.getUsuarioActual() != null)
				&& (this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_PERMISO) != null)) {
			final List<String> objetoDeSession = (List<String>) this
					.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_PERMISO);

			final StringBuilder arreglo = new StringBuilder("ModuloSIICA");

			for (final String string : objetoDeSession) {
				if (StringUtils.containsIgnoreCase(string, modulos)) {
					arreglo.append("," + string);
				}

			}
			return Objects.toString(arreglo, "");
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean getTienePermisoParaModulos(final String modulos) {

		if ((this.getUsuarioActual() != null)
				&& (this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_PERMISO) != null)) {
			final List<String> objetoDeSession = (List<String>) this
					.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_PERMISO);

			for (final String string : objetoDeSession) {
				if (StringUtils.containsIgnoreCase(string, modulos)) {
					return true;
				}

			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean getTienePermisoParaPagina(final String pagina) {

		if (this.getEsPaginaQueNoRequiereLogin()) {
			return true;
		}

		if ((this.getUsuarioActual() != null)
				&& (this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_PERMISO) != null)) {
			final List<String> objetoDeSession = (List<String>) this
					.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_PERMISO);

			for (final String string : objetoDeSession) {
				final String permiso = string;
				if (StringUtils.equalsIgnoreCase(permiso, pagina)) {
					return true;
				}

			}
		}

		return false;
	}

	@Override
	public  void doAccionRegistroNuevo(final ActionEvent arg0)  {
    //nada
    }

	public boolean getPermisoSIICAAplicacionCristalesAlta() {
		return this.getTieneSesion() && this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_CRISTALES_ALTA);

	}

	public boolean getPermisoSIICAAplicacionCristalesSeguimiento() {
		return this.getTieneSesion()
				&& this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_CRISTALES_SEGUIMIENTO);

	}

	public boolean getPermisoSIICAAplicacionCristalesValidacion() {
		return this.getTieneSesion()
				&& this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_CRISTALES_VALIDACION);

	}

	public boolean getPermisoSIICAAplicaciones() {
		return this.getTieneSesion() && this.getTienePermisoParaModulos("/Aplicacion/");
	}

	public boolean getPermisoSIICAAVQ() {
		return this.getTieneSesion() && this.getTienePermisoParaModulos("AVQ");
	}

	public boolean getPermisoSIICACatalogo() {
		return this.getTieneSesion() && this.getTienePermisoParaModulos("/Catalogo/");
	}
	
	public boolean getPermisoSIICACatalogacion() {
		return this.getTieneSesion() && this.getTienePermisoParaModulos("/Catalogacion/");
	}

	public boolean getPermisoSIICAGlobalBases() {
			return this.getTieneSesion()
					&& this.getTienePermisoParaPagina(JMConstantes.MODULO_GLOBAL_PERMISO_TODOS_LAS_BASES);
	}

	public boolean getPermisoSIICAGlobalDetalleTarjeta() {
		return this.getTieneSesion()
				&& this.getTienePermisoParaPagina(JMConstantes.MODULO_GLOBAL_PERMISO_REPORTE_BANCARIO_DATOS_TARJETA);
	}

	public boolean getPermisoSIICAGlobalEstados() {
		return this.getTieneSesion()
				&& this.getTienePermisoParaPagina(JMConstantes.MODULO_GLOBAL_PERMISO_TODOS_LOS_ESTADOS);
	}

	public boolean getPermisoSIICAOperacionesInicioDeSesion() {
		return !this.getTieneSesion();
	}

	public boolean getPermisoSIICAOperacionesSalir() {
		return this.getTieneSesion();
	}

	public boolean getPermisoSIICAReportes() {
		return this.getTieneSesion() && this.getTienePermisoParaModulos("/Reporte/");
	}

	public boolean getPermisoSIICASISEOR() {
		return this.getTieneSesion() && this.getTienePermisoParaModulos("/SiseOR/");
	}

	public String getSIICACopyright() {
		if (StringUtils.isEmpty(JMBeanExtensiblePrincipal.siicaCopyRight)) {
			try {
				JMBeanExtensiblePrincipal.siicaCopyRight = this.getConfiguracionService().obtenerCadena(
						JMConstantes.CONFIGURACION_SIICA_INTERFASE_COPYRIGHT);
			} catch (final Exception ex) {
				JMBeanExtensiblePrincipal.siicaCopyRight = " ";
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getSIICACopyright");
			}
		}
		return JMBeanExtensiblePrincipal.siicaCopyRight;
	}

	public String getSIICALogo() {
		try {
			if (StringUtils.isEmpty(JMBeanExtensiblePrincipal.siicaLogotipo)) {
				JMBeanExtensiblePrincipal.siicaLogotipo = this.getConfiguracionService().obtenerCadena(
						JMConstantes.cONFIGURACION_SIICA_INTERFASE_LOGO);
			}
		} catch (final Exception ex) {
			JMBeanExtensiblePrincipal.siicaLogotipo = " ";
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getSIICALogo");
		}
		return JMBeanExtensiblePrincipal.siicaLogotipo;
	}

	public String getSIICAResponsableEmail() {
		if (StringUtils.isEmpty(JMBeanExtensiblePrincipal.siicaResponsableEmail)) {
			try {
				JMBeanExtensiblePrincipal.siicaResponsableEmail = this.getConfiguracionService().obtenerCadena(
						JMConstantes.CONFIGURACION_SIICA_INTERFASE_RESPONSABLE_EMAIL);
			} catch (final Exception ex) {
				JMBeanExtensiblePrincipal.siicaResponsableEmail = " ";
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getSIICAResponsableEmail");

			}
		}
		return JMBeanExtensiblePrincipal.siicaResponsableEmail;
	}

	public String getSIICAResponsableNombre() {
		if (StringUtils.isEmpty(JMBeanExtensiblePrincipal.siicaResponsableNombre)) {
			try {
				JMBeanExtensiblePrincipal.siicaResponsableNombre = this.getConfiguracionService().obtenerCadena(
						JMConstantes.CONFIGURACION_SIICA_INTERFASE_RESPONSABLE_NOMBRE);
			} catch (final Exception ex) {
				JMBeanExtensiblePrincipal.siicaResponsableNombre = " ";
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getSIICAResponsableNombre");
			}
		}
		return JMBeanExtensiblePrincipal.siicaResponsableNombre;

	}

	public String getSIICARevision() {
		if (StringUtils.isEmpty(JMBeanExtensiblePrincipal.siicaRevision)) {
			try {
				JMBeanExtensiblePrincipal.siicaRevision = this.getConfiguracionService().obtenerCadena(
						JMConstantes.CONFIGURACION_SIICA_INTERFASE_REVISION);
			} catch (final Exception ex) {
				JMBeanExtensiblePrincipal.siicaRevision = " ";
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getSIICARevision");
			}
		}
		return JMBeanExtensiblePrincipal.siicaRevision;
	}

	public String getSIICAScroller() {
		if (StringUtils.isEmpty(JMBeanExtensiblePrincipal.siicaScroller)) {
			try {
				JMBeanExtensiblePrincipal.siicaScroller = this.getConfiguracionService().obtenerCadena(
						JMConstantes.CONFIGURACION_SIICA_INTERFASE_SCROLLER);
			} catch (final Exception ex) {
				JMBeanExtensiblePrincipal.siicaScroller = " ";
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getSIICAScroller");
			}

		}
		return JMBeanExtensiblePrincipal.siicaScroller;
	}

	public String getSIICAVersion() {
		if (StringUtils.isEmpty(JMBeanExtensiblePrincipal.siicaVersion)) {
			try {
				JMBeanExtensiblePrincipal.siicaVersion = this.getConfiguracionService().obtenerCadena(
						JMConstantes.CONFIGURACION_SIICA_INTERFASE_VERSION);
			} catch (final Exception ex) {
				JMBeanExtensiblePrincipal.siicaVersion = " ";
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getSIICAVersion");
			}
		}
		return JMBeanExtensiblePrincipal.siicaVersion;
	}

	
	
	public boolean getTieneSesion() {
		return (this.getUsuarioActual() != null) && (this.getUsuarioActual().getId() != null);
	}

	public boolean getTieneSessionCorrectaEnPagina() {
		if (!this.getEsPaginaQueNoRequiereLogin() && !this.getTieneSesion()) {
			return false;
		}
		return true;

	}

	public Usuario getUsuarioActual() {
		return (Usuario) this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_USUARIO);
	}

	public Terminal getTerminalActual() {
		return (Terminal) this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_TERMINAL);
	}

	// **************************************************************//
	// Getters y Setters
	// **************************************************************//

	/**
	 * @return the modeloMenu
	 */
	public MenuModel getModeloMenu() {
		if (this.obtenerObjetoDeSession("menu") == null) {
			this.modeloMenu = new DefaultMenuModel();

			if (this.getPermisoSIICAAplicaciones()) {
				final DefaultSubMenu apps = new DefaultSubMenu("AQ Aplicaciones");
				for (final Modulo mod : this.getListaDeModulosDeAplicaciones()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					apps.addElement(item);
				}
				this.modeloMenu.addElement(apps);
			}
			if (this.getPermisoSIICAAVQ()) {
				final DefaultSubMenu avq = new DefaultSubMenu(
						BooleanUtils.isTrue(this.getEsParaQualitas()) ? "AQ A.V.Q." : "AQ Banorte A.V.");
				// AVQ Catalogo
				final DefaultSubMenu avqCatalogo = new DefaultSubMenu("Catalogos");
				// AVQ Catalogo -> Poliza

				final DefaultSubMenu avqCatalogoPoliza = new DefaultSubMenu("De Poliza");
				for (final Modulo mod : this.getListaDeModulosDeCatalogoPolizaAVQ()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					avqCatalogoPoliza.addElement(item);
				}
				// AVQ Catalogo -> Proveedor
				final DefaultSubMenu avqCatalogoProveedor = new DefaultSubMenu("De Proveedor");
				for (final Modulo mod : this.getListaDeModulosDeCatalogoProveedorAVQ()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					avqCatalogoProveedor.addElement(item);
					
				}
				// AVQ Catalogo -> Servicio
				final DefaultSubMenu avqCatalogoServicio = new DefaultSubMenu("De Servicio");
				for (final Modulo mod : this.getListaDeModulosDeCatalogoServicioAVQ()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					avqCatalogoServicio.addElement(item);
				}

				avqCatalogo.addElement(avqCatalogoPoliza);
				avqCatalogo.addElement(avqCatalogoProveedor);
				avqCatalogo.addElement(avqCatalogoServicio);

				avq.addElement(avqCatalogo);

				// AVQ Servicios
				final DefaultSubMenu avqServicios = new DefaultSubMenu("Servicios");

				for (final Modulo mod : this.getListaDeModulosDeServicioAVQ()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					avqServicios.addElement(item);
				}

				avq.addElement(avqServicios);

				// AVQ Servicios
				final DefaultSubMenu avqReportes = new DefaultSubMenu("Reportes");
				for (final Modulo mod : this.getListaDeModulosDeReporteAVQ()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					avqReportes.addElement(item);
				}

				avq.addElement(avqReportes);

				this.modeloMenu.addElement(avq);
			}

			if (this.getPermisoSIICACatalogo()) {
				final DefaultSubMenu siicaCatalogos = new DefaultSubMenu("AQ Catalogos");

				for (final Modulo mod : this.getListaDeModulosDeCatalogos()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					siicaCatalogos.addElement(item);
				}

				this.modeloMenu.addElement(siicaCatalogos);
			}

			if (this.getPermisoSIICASISEOR() && BooleanUtils.isTrue(this.getEsParaQualitas())) {
				final DefaultSubMenu siicaSISEOR = new DefaultSubMenu("AQ SAC/SISE");

				for (final Modulo mod : this.getListaDeModulosDeSIISEOR()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					siicaSISEOR.addElement(item);
				}

				this.modeloMenu.addElement(siicaSISEOR);
			}
			if (this.getPermisoSIICAReportes()) {
				final DefaultSubMenu siicaReportes = new DefaultSubMenu("AQ Reportes");

				for (final Modulo mod : this.getListaDeModulosDeReporte()) {
					final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(),
							mod.getPagina());
					item.setAjax(false);
					siicaReportes.addElement(item);
				}

				this.modeloMenu.addElement(siicaReportes);

			}

			final DefaultSubMenu siicaOperacion = new DefaultSubMenu("Operaciones");

			for (final Modulo mod : this.getListaDeModulosDeOperacion()) {
				final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(), mod.getPagina());
				item.setAjax(false);
				siicaOperacion.addElement(item);
			}
			

			this.modeloMenu.addElement(siicaOperacion);
			//-----------------------------------------------------------
			if (this.getPermisoSIICACatalogacion()) {
			final DefaultSubMenu cat = new DefaultSubMenu("Catalogacion");
			for (final Modulo mod : this.getListaDeModulosDeCatalogosEdit()) {
				final DefaultMenuItem item = new DefaultMenuItem(mod.getNombrecorto(), mod.getIcono(), mod.getPagina());
				item.setAjax(false);
				cat.addElement(item);
			}

			this.modeloMenu.addElement(cat);
			}
			//-----------------------------------------------------------

			this.ponerObjetoEnSession("menu", this.modeloMenu);
			return this.modeloMenu;
		}
		return (MenuModel) this.obtenerObjetoDeSession("menu");

	}
	
	
	
	

	/*******************************
	 * 
	 * Funcion para obtener Bases y Estados de la frecuencia
	 * 
	 * 
	 * *********/
	

	
	// **************************************************************//
	// Getters y setters
	// **************************************************************//
	public void setModeloMenu(final MenuModel modeloMenu) {
		this.modeloMenu = modeloMenu;
	}

	/**
	 * @return the siicaVersion
	 */
	public static String getSiicaVersion() {
		return JMBeanExtensiblePrincipal.siicaVersion;
	}

	/**
	 * @param siicaVersion
	 *            the siicaVersion to set
	 */
	public static void setSiicaVersion(final String siicaVersion) {
		JMBeanExtensiblePrincipal.siicaVersion = siicaVersion;
	}

	/**
	 * @return the siicaRevision
	 */
	public static String getSiicaRevision() {
		return JMBeanExtensiblePrincipal.siicaRevision;
	}

	/**
	 * @param siicaRevision
	 *            the siicaRevision to set
	 */
	public static void setSiicaRevision(final String siicaRevision) {
		JMBeanExtensiblePrincipal.siicaRevision = siicaRevision;
	}

	/**
	 * @return the siicaResponsableNombre
	 */
	public static String getSiicaResponsableNombre() {
		return JMBeanExtensiblePrincipal.siicaResponsableNombre;
	}

	/**
	 * @param siicaResponsableNombre
	 *            the siicaResponsableNombre to set
	 */
	public static void setSiicaResponsableNombre(final String siicaResponsableNombre) {
		JMBeanExtensiblePrincipal.siicaResponsableNombre = siicaResponsableNombre;
	}

	/**
	 * @return the siicaResponsableEmail
	 */
	public static String getSiicaResponsableEmail() {
		return JMBeanExtensiblePrincipal.siicaResponsableEmail;
	}

	/**
	 * @param siicaResponsableEmail
	 *            the siicaResponsableEmail to set
	 */
	public static void setSiicaResponsableEmail(final String siicaResponsableEmail) {
		JMBeanExtensiblePrincipal.siicaResponsableEmail = siicaResponsableEmail;
	}

	/**
	 * @return the siicaCopyRight
	 */
	public static String getSiicaCopyRight() {
		return JMBeanExtensiblePrincipal.siicaCopyRight;
	}

	/**
	 * @param siicaCopyRight
	 *            the siicaCopyRight to set
	 */
	public static void setSiicaCopyRight(final String siicaCopyRight) {
		JMBeanExtensiblePrincipal.siicaCopyRight = siicaCopyRight;
	}

	/**
	 * @return the siicaLogotipo
	 */
	public static String getSiicaLogotipo() {
		return JMBeanExtensiblePrincipal.siicaLogotipo;
	}

	/**
	 * @param siicaLogotipo
	 *            the siicaLogotipo to set
	 */
	public static void setSiicaLogotipo(final String siicaLogotipo) {
		JMBeanExtensiblePrincipal.siicaLogotipo = siicaLogotipo;
	}

	/**
	 * @return the siicaScroller
	 */
	public static String getSiicaScroller() {
		return JMBeanExtensiblePrincipal.siicaScroller;
	}

	public static void setSiicaScroller(final String siicaScroller) {
		JMBeanExtensiblePrincipal.siicaScroller = siicaScroller;
	}

	public static JMBeanSpringSocketServidor getSpringServidorTCP() {
		if (JMBeanExtensiblePrincipal.springServidorTCP == null) {
			JMBeanExtensiblePrincipal.springServidorTCP = JMBeanSpringSocketServidor
					.getInstance(JMConstantesComunes.BEAN_SERVIDOR_TCP);
		}

		return JMBeanExtensiblePrincipal.springServidorTCP;
	}

	public static JMBeanSpringSocketServidor getSpringServidorUDP() {
		if (JMBeanExtensiblePrincipal.springServidorUDP == null) {
			JMBeanExtensiblePrincipal.springServidorUDP = JMBeanSpringSocketServidor
					.getInstance(JMConstantesComunes.BEAN_SERVIDOR_UDP);
		}
		return JMBeanExtensiblePrincipal.springServidorUDP;
	}
		
	/**
	 * @return the listaEstadosFrecuencia
	 */
	
	public List<Estado> getEstadoFrecuencia(){
		List<Estado> encontrados = new ArrayList<Estado>();
		List<FrecuenciaBase> bases = this.getUsuarioActual().getFrecuencia().getFrecuenciaBases();

		boolean insertar=false;
		for(final FrecuenciaBase freq : bases){	
			if(encontrados.size()==0){
				encontrados.add(freq.getBase().getEstado());
			}else{
				for(final Estado estado : encontrados){
					
					if(freq.getBase().getEstado().getId().equals(estado.getId()) ){
						insertar=false;
						break;
					}else{
						insertar = true;
					}
				}
				if (insertar){
					encontrados.add(freq.getBase().getEstado());
				}
			}
		}
		return encontrados;
	}
	
	public List<Estado> getEstadoFrecuenciaTerm(){
		List<Estado> encontrados = new ArrayList<Estado>();
		List<FrecuenciaBase> bases = this.getUsuarioActual().getFrecuencia().getFrecuenciaBases();

		boolean insertar=false;
		for(final FrecuenciaBase freq : bases){	
			if(encontrados.size()==0){
				encontrados.add(freq.getBase().getEstado());
			}else{
				for(final Estado estado : encontrados){
					
					if(freq.getBase().getEstado().getId().equals(estado.getId()) ){
						insertar=false;
						break;
					}else{
						insertar = true;
					}
				}
				if (insertar){
					encontrados.add(freq.getBase().getEstado());
				}
			}
		}
		return encontrados;
	}
	
	public List<Estado> getEstadoFrecuenciaTermGH(){
		List<Estado> encontrados = new ArrayList<Estado>();
		List<FrecuenciaBase> bases = this.getUsuarioActual().getFrecuencia().getFrecuenciaBases();

		boolean insertar=false;
		for(final FrecuenciaBase freq : bases){	
			if(encontrados.size()==0){
				encontrados.add(freq.getBase().getEstado());
			}else{
				for(final Estado estado : encontrados){
					
					if(freq.getBase().getEstado().getId().equals(estado.getId()) ){
						insertar=false;
						break;
					}else{
						insertar = true;
					}
				}
				if (insertar){
					encontrados.add(freq.getBase().getEstado());
				}
			}
		}
		
		// Ordenar de alfabeticamente
		try {
			if(encontrados != null) {
				Collections.sort(encontrados, new Comparator<Estado>() {
				    @Override
				    public int compare(Estado o1, Estado o2) {
				        return o1.getNombre().compareToIgnoreCase(o2.getNombre());
				    }
				});
			}
		} catch ( ClassCastException | UnsupportedOperationException | IllegalArgumentException | IndexOutOfBoundsException | NoSuchElementException e) {
		} catch ( ConcurrentModificationException  ex) {
		}
		return encontrados;
	}

	public List<Base> getObtenerBasesFrecuencia(){
		
		List<Base> encontrados = new ArrayList<Base>();
		if (getPermisoTodosEstados() && getPermisoTodosBases()){
			
			for (final FrecuenciaBase freq : this.getUsuarioActual().getFrecuencia().getFrecuenciaBases() ){
				if(freq.getBase().getEstado().getId() == Integer.parseInt(this.getIdEstado())){
					encontrados.add(freq.getBase()); 
					//this.setIdBase(String.valueOf(encontrados.get(0).getId()));
				}
			}
		} else {
//			if (this.getIdEstado().equals("9999")){
//				for (final Estado estado : this.getEstadoFrecuencia()){
//					for (final FrecuenciaBase freq : this.getUsuarioActual().getFrecuencia().getFrecuenciaBases() ){
////						if(freq.getBase().getEstado().getId().equals(estado.getId())){
//							encontrados.add(freq.getBase()); 
//							//this.setIdBase(String.valueOf(encontrados.get(0).getId()));
////						}
//					}
//				}
//				
//			} else {
				for (final FrecuenciaBase freq : this.getUsuarioActual().getFrecuencia().getFrecuenciaBases() ){
					if(freq.getBase().getEstado().getId() == Integer.parseInt(this.getIdEstado())){
						encontrados.add(freq.getBase()); 
						//this.setIdBase(String.valueOf(encontrados.get(0).getId()));
					}
				}
//			}
		}
		
		return encontrados;
	}
	
	public List<Terminal> getObtenerTerminalFrecuencia(){
		List<Terminal> terminales = new ArrayList<Terminal>();

		List<Base> bases = this.getListaDeBasesPorFrecuencia();
		try {
			
			for (final Base baseFre : bases){
				for (final Terminal term : this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getIdEstado()),
						this.getBaseService().objetoBase(this.getIdBase()))){
//					if (baseFre.getId() == term.getBase().getId()){
					if (baseFre.getId().equals(term.getBase().getId()) ){
						terminales.add(term);
					}
				}
			}
			
			
			return terminales;
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"getListaDeTerminalesParaSeleccion => listaDeTerminal");
			return new Vector<>();
		}

	}
	
	public List<Terminal> getObtenerAjustadoresDispo(){
		List<Terminal> terminales = new ArrayList<Terminal>();
			try {
				terminales =  this.getTerminalService().listaDeAjustadoresTerminal(this.getEstadoService().objetoEstado(this.getIdEstado()),
						this.getBaseService().objetoBase(this.getIdBase()),"filtroAlarmaDisponible");
					
					return terminales;
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"getListaDeTerminalesParaSeleccion => listaDeTerminal");
					return new Vector<>();
				}

			}
	/**
	 * @return the listaEstados
	 */
	public List<Estado> getListaEstados() {
		if (JMBeanExtensiblePrincipal.listaEstados == null) {
			try {
				JMBeanExtensiblePrincipal.listaEstados = this.estadoService.listaDeEstado();
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaEstados");
			}
		}

		return JMBeanExtensiblePrincipal.listaEstados;
	}
	
	public List<Estado> getListaEstadosNueva() {
		if (JMBeanExtensiblePrincipal.listaEstados == null) {
			try {
				JMBeanExtensiblePrincipal.listaEstados = this.estadoService.listaDeEstado();
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaEstados");
			}
		}

		return JMBeanExtensiblePrincipal.listaEstados;
	}

	public List<Estado> getListaEstadosFrecuencia(){
		try{
			return this.getEstadoFrecuencia();
		}catch(final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaEstadosFrecuencia");
			return null;
		}
	}
	
	public List<Estado> getListaEstadosFrecuenciaTerm(){
		try{
			return this.getEstadoFrecuenciaTerm();
		}catch(final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaEstadosFrecuencia");
			return null;
		}
	}
	
	public List<Estado> getListaEstadosFrecuenciaTermGH(){
		try{
			return this.getEstadoFrecuenciaTermGH();
		}catch(final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaEstadosFrecuencia");
			return null;
		}
	}
	
	/**
	 * @return the listaEstados
	 */
	public List<Estado> getListaDeEstados() {
		if (JMBeanExtensiblePrincipal.listaEstados == null) {
			try {
				JMBeanExtensiblePrincipal.listaEstados = this.estadoService.listaDeEstado();
				this.setIdBase("0");
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeEstados");

			}
		}
		return JMBeanExtensiblePrincipal.listaEstados;
	}
	
	public List<Base> getListaDeBasesPorFrecuencia(){
		try{
			return this.getObtenerBasesFrecuencia();
		}catch(Exception ex){
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaBasesPorFrecuencia");
			return null;
		}
	}
	
	public List<Horarios> getListaDeHorarios(){
		try {
			return Horarios.getHorariosService().listaDeHorariosAgroup(StringUtils.isNotBlank(this.getIdEstado()) ? this
					.getEstadoService().objetoEstado(
							this.getIdEstado()) : null);
		} catch (Exception e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getListaDeHorarios");
		}
		return null;
	}
	
	public void setIdEstado(final String idEstadoSeleccionado) {
		this.idEstado = idEstadoSeleccionado;
	}
	
	/**
	 * @param idBaseSeleccionada
	 *            the idBaseSeleccionada to set
	 */
	public void setIdBase(final String idBaseSeleccionada) {
		this.idBase = idBaseSeleccionada;
	}

	/**
	 * @return the idTerminal
	 */
	public String getIdTerminal() {
		return this.idTerminal;
	}

	/**
	 * @param idTerminal
	 *            the idTerminal to set
	 */
	public void setIdTerminal(final String idTerminal) {
		this.idTerminal = idTerminal;
	}

	public int getPaso() {
		return this.paso;
	}

	public void setPaso(final int paso) {
		this.paso = paso;
	}

	public String getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(final String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public JMUtileriaExcepcion getUtileriaExcepcion() {
		return this.utileriaExcepcion;
	}

	public Boolean getEsParaBanorte() {
		if (JMBeanExtensiblePrincipal.esParaBanorte == null) {
			try {
				JMBeanExtensiblePrincipal.esParaBanorte = new Boolean(StringUtils.equalsIgnoreCase(this
						.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_SERVIDOR_COMPANIA),
						"Banorte"));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getEsParaBanorte");
			}
		}

		return JMBeanExtensiblePrincipal.esParaBanorte;
	}

	public Boolean getEsParaQualitas() {
		if (JMBeanExtensiblePrincipal.esParaQualitas == null) {
			try {
				JMBeanExtensiblePrincipal.esParaQualitas = StringUtils.equals(this
								.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_SERVIDOR_COMPANIA),
						"Qualitas");
			} catch (final Exception ex) {

				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getEsParaQualitas");
			}
		}

		return JMBeanExtensiblePrincipal.esParaQualitas;
	}

	public BaseServiceInterfase getBaseService() {
		return this.baseService;
	}

	public void setBaseService(final BaseServiceInterfase baseService) {
		this.baseService = baseService;
	}

	public CalleCruceServiceInterfase getCalleCruceService() {
		return this.calleCruceService;
	}

	public void setCalleCruceService(final CalleCruceServiceInterfase calleCruceService) {
		this.calleCruceService = calleCruceService;
	}

	public CalleServiceInterfase getCalleService() {
		return this.calleService;
	}

	public void setCalleService(final CalleServiceInterfase calleService) {
		this.calleService = calleService;
	}

	public CalleDireccionServiceInterfase getCalleDireccionService() {
		return this.calleDireccionService;
	}

	public void setCalleDireccionService(final CalleDireccionServiceInterfase calleDireccionService) {
		this.calleDireccionService = calleDireccionService;
	}

	public CarreteraServiceInterfase getCarreteraService() {
		return this.carreteraService;
	}

	public void setCarreteraService(final CarreteraServiceInterfase carreteraService) {
		this.carreteraService = carreteraService;
	}

	public CartografiaServiceInterfase getCartografiaService() {
		return this.cartografiaService;
	}

	public void setCartografiaService(final CartografiaServiceInterfase cartografiaService) {
		this.cartografiaService = cartografiaService;
	}

	public CatalogoAseguradoraServiceInterfase getCatalogoAseguradoraService() {
		return this.catalogoAseguradoraService;
	}

	public void setCatalogoAseguradoraService(final CatalogoAseguradoraServiceInterfase catalogoAseguradoraService) {
		this.catalogoAseguradoraService = catalogoAseguradoraService;
	}

	public CatalogoClaveDeEntidadServiceInterfase getCatalogoClaveDeEntidadService() {
		return this.catalogoClaveDeEntidadService;
	}

	public void setCatalogoClaveDeEntidadService(
			final CatalogoClaveDeEntidadServiceInterfase catalogoClaveDeEntidadService) {
		this.catalogoClaveDeEntidadService = catalogoClaveDeEntidadService;
	}

	public CatalogoCodigoDeCausaServiceInterfase getCatalogoCodigoDeCausaService() {
		return this.catalogoCodigoDeCausaService;
	}

	public void setCatalogoCodigoDeCausaService(final CatalogoCodigoDeCausaServiceInterfase catalogoCodigoDeCausaService) {
		this.catalogoCodigoDeCausaService = catalogoCodigoDeCausaService;
	}

	public CatalogoCodigoRespuestaBancarioServiceInterfase getCatalogoCodigoRespuestaBancarioService() {
		return this.catalogoCodigoRespuestaBancarioService;
	}

	public void setCatalogoCodigoRespuestaBancarioService(
			final CatalogoCodigoRespuestaBancarioServiceInterfase catalogoCodigoRespuestaBancarioService) {
		this.catalogoCodigoRespuestaBancarioService = catalogoCodigoRespuestaBancarioService;
	}

	public CatalogoMarcaServiceInterfase getCatalogoMarcaService() {
		return this.catalogoMarcaService;
	}

	public void setCatalogoMarcaService(final CatalogoMarcaServiceInterfase catalogoMarcaService) {
		this.catalogoMarcaService = catalogoMarcaService;
	}

	public CatalogoMarcaEstiloServiceInterfase getCatalogoMarcaEstiloService() {
		return this.catalogoMarcaEstiloService;
	}

	public void setCatalogoMarcaEstiloService(final CatalogoMarcaEstiloServiceInterfase catalogoMarcaEstiloService) {
		this.catalogoMarcaEstiloService = catalogoMarcaEstiloService;
	}

	public CatalogoOficinaServiceInterfase getCatalogoOficinaService() {
		return this.catalogoOficinaService;
	}
	public void setCatalogoOficinaService(final CatalogoOficinaServiceInterfase catalogoOficinaService) {
		this.catalogoOficinaService = catalogoOficinaService;
	}

	public CatalogoProveedorAsistenciaServiceInterfase getCatalogoProveedorAsistenciaService() {
		return this.catalogoProveedorAsistenciaService;
	}

	public void setCatalogoProveedorAsistenciaService(
			final CatalogoProveedorAsistenciaServiceInterfase catalogoProveedorAsistenciaService) {
		this.catalogoProveedorAsistenciaService = catalogoProveedorAsistenciaService;
	}

	public CatalogoProveedorAsistenciaIdentificadorServiceInterfase getCatalogoProveedorAsistenciaIdentificadorService() {
		return this.catalogoProveedorAsistenciaIdentificadorService;
	}

	public void setCatalogoProveedorAsistenciaIdentificadorService(
			final CatalogoProveedorAsistenciaIdentificadorServiceInterfase catalogoProveedorAsistenciaIdentificadorService) {
		this.catalogoProveedorAsistenciaIdentificadorService = catalogoProveedorAsistenciaIdentificadorService;
	}

	public CatalogoTipoAsistenciaServiceInterfase getCatalogoTipoAsistenciaService() {
		return this.catalogoTipoAsistenciaService;
	}

	public void setCatalogoTipoAsistenciaService(
			final CatalogoTipoAsistenciaServiceInterfase catalogoTipoAsistenciaService) {
		this.catalogoTipoAsistenciaService = catalogoTipoAsistenciaService;
	}

	public CatalogoVehiculoTipoServiceInterfase getCatalogoVehiculoTipoService() {
		return this.catalogoVehiculoTipoService;
	}

	public void setCatalogoVehiculoTipoService(final CatalogoVehiculoTipoServiceInterfase catalogoVehiculoTipoService) {
		this.catalogoVehiculoTipoService = catalogoVehiculoTipoService;
	}

	public CatalogoVehiculoUsoServiceInterfase getCatalogoVehiculoUsoService() {
		return this.catalogoVehiculoUsoService;
	}

	public void setCatalogoVehiculoUsoService(final CatalogoVehiculoUsoServiceInterfase catalogoVehiculoUsoService) {
		this.catalogoVehiculoUsoService = catalogoVehiculoUsoService;
	}

	public ColoniaServiceInterfase getColoniaService() {
		return this.coloniaService;
	}

	public void setColoniaService(final ColoniaServiceInterfase coloniaService) {
		this.coloniaService = coloniaService;
	}

	public ComunicadoServiceInterfase getComunicadoService() {
		return this.comunicadoService;
	}

	public void setComunicadoService(final ComunicadoServiceInterfase comunicadoService) {
		this.comunicadoService = comunicadoService;
	}

	public ConfiguracionServiceInterfase getConfiguracionService() {
		return this.configuracionService;
	}

	public void setConfiguracionService(final ConfiguracionServiceInterfase configuracionService) {
		this.configuracionService = configuracionService;
	}

	public EstadoServiceInterfase getEstadoService() {
		return this.estadoService;
	}

	public void setEstadoService(final EstadoServiceInterfase estadoService) {
		this.estadoService = estadoService;
	}

	public FrecuenciaBaseServiceInterfase getFrecuenciaBaseService() {
		return this.frecuenciaBaseService;
	}

	public void setFrecuenciaBaseService(final FrecuenciaBaseServiceInterfase frecuenciaBaseService) {
		this.frecuenciaBaseService = frecuenciaBaseService;
	}

	public GrupoTerminalServiceInterfase getGrupoTerminalService() {
		return grupoTerminalService;
	}
	public void setGrupoTerminalService(GrupoTerminalServiceInterfase grupoTerminalService) {
		this.grupoTerminalService = grupoTerminalService;
	}
	
	public HorarioGrupoServiceInterfase getHorarioGrupoService() {
		return horarioGrupoService;
	}
	public void setHorarioGrupoService(HorarioGrupoServiceInterfase horarioGrupoService) {
		this.horarioGrupoService = horarioGrupoService;
	}

	public FrecuenciaServiceInterfase getFrecuenciaService() {
		return this.frecuenciaService;
	}
	
	public GrupoServiceInterfase getGrupoService() {
		return grupoService;
	}
	public void setGrupoService(GrupoServiceInterfase grupoService) {
		this.grupoService = grupoService;
	}
	public HorariosServiceInterfase getHorariosService() {
		return horariosService;
	}
	public void setHorariosService(HorariosServiceInterfase horariosService) {
		this.horariosService = horariosService;
	}

	public void setFrecuenciaService(final FrecuenciaServiceInterfase frecuenciaService) {
		this.frecuenciaService = frecuenciaService;
	}

	public GeocercaServiceInterfase getGeocercaService() {
		return this.geocercaService;
	}

	public void setGeocercaService(final GeocercaServiceInterfase geocercaService) {
		this.geocercaService = geocercaService;
	}

	public GeocercaPuntoServiceInterfase getGeocercaPuntoService() {
		return this.geocercaPuntoService;
	}

	public void setGeocercaPuntoService(final GeocercaPuntoServiceInterfase geocercaPuntoService) {
		this.geocercaPuntoService = geocercaPuntoService;
	}

	public HistoricoTerminalServiceInterfase getHistoricoTerminalService() {
		return this.historicoTerminalService;
	}

	public void setHistoricoTerminalService(final HistoricoTerminalServiceInterfase historicoTerminalService) {
		this.historicoTerminalService = historicoTerminalService;
	}

	public MensajeSmsServiceInterfase getMensajeSmsService() {
		return this.mensajeSmsService;
	}

	public void setMensajeSmsService(final MensajeSmsServiceInterfase mensajeSmsService) {
		this.mensajeSmsService = mensajeSmsService;
	}

	public ModuloServiceInterfase getModuloService() {
		return this.moduloService;
	}

	public void setModuloService(final ModuloServiceInterfase moduloService) {
		this.moduloService = moduloService;
	}

	public ModuloPadreServiceInterfase getModuloPadreService() {
		return this.moduloPadreService;
	}

	public void setModuloPadreService(final ModuloPadreServiceInterfase moduloPadreService) {
		this.moduloPadreService = moduloPadreService;
	}

	public MunicipioServiceInterfase getMunicipioService() {
		return this.municipioService;
	}

	public void setMunicipioService(final MunicipioServiceInterfase municipioService) {
		this.municipioService = municipioService;
	}



	public EncuestaAjustadorServiceInterfase getEncuestaAjustadorService() {
		return encuestaAjustadorService;
	}



	public void setEncuestaAjustadorService(EncuestaAjustadorServiceInterfase encuestaAjustadorService) {
		this.encuestaAjustadorService = encuestaAjustadorService;
	}



	public GeocercaByEstadoServiceInterfase getGeocercaByEstadoService() {
		return geocercaByEstadoService;
	}



	public void setGeocercaByEstadoService(GeocercaByEstadoServiceInterfase geocercaByEstadoService) {
		this.geocercaByEstadoService = geocercaByEstadoService;
	}



	public PerfilServiceInterfase getPerfilService() {
		return perfilService;
	}



	public void setPerfilService(PerfilServiceInterfase perfilService) {
		this.perfilService = perfilService;
	}



	public PermisoServiceInterfase getPermisoService() {
		return permisoService;
	}



	public void setPermisoService(PermisoServiceInterfase permisoService) {
		this.permisoService = permisoService;
	}



	public PuntoInteresServiceInterfase getPuntoInteresService() {
		return puntoInteresService;
	}



	public void setPuntoInteresService(PuntoInteresServiceInterfase puntoInteresService) {
		this.puntoInteresService = puntoInteresService;
	}



	public PuntoInteresTipoServiceInterfase getPuntoInteresTipoService() {
		return puntoInteresTipoService;
	}



	public void setPuntoInteresTipoService(PuntoInteresTipoServiceInterfase puntoInteresTipoService) {
		this.puntoInteresTipoService = puntoInteresTipoService;
	}



	public ReferenciaServiceInterfase getReferenciaService() {
		return referenciaService;
	}



	public void setReferenciaService(ReferenciaServiceInterfase referenciaService) {
		this.referenciaService = referenciaService;
	}



	public ReporteAbogadoServiceInterfase getReporteAbogadoService() {
		return reporteAbogadoService;
	}



	public void setReporteAbogadoService(ReporteAbogadoServiceInterfase reporteAbogadoService) {
		this.reporteAbogadoService = reporteAbogadoService;
	}



	public ReporteMovilServiceInterfase getReporteMovilService() {
		return reporteMovilService;
	}



	public void setReporteMovilService(ReporteMovilServiceInterfase reporteMovilService) {
		this.reporteMovilService = reporteMovilService;
	}



	public ReporteSiseServiceInterfase getReporteSiseService() {
		return reporteSiseService;
	}



	public void setReporteSiseService(ReporteSiseServiceInterfase reporteSiseService) {
		this.reporteSiseService = reporteSiseService;
	}



	public ReporteSolicitadoServiceInterfase getReporteSolicitadoService() {
		return reporteSolicitadoService;
	}



	public void setReporteSolicitadoService(ReporteSolicitadoServiceInterfase reporteSolicitadoService) {
		this.reporteSolicitadoService = reporteSolicitadoService;
	}



	public SessionServiceInterfase getSessionService() {
		return sessionService;
	}



	public void setSessionService(SessionServiceInterfase sessionService) {
		this.sessionService = sessionService;
	}



	public SessionExternaServiceInterfase getSessionExternaService() {
		return sessionExternaService;
	}



	public void setSessionExternaService(SessionExternaServiceInterfase sessionExternaService) {
		this.sessionExternaService = sessionExternaService;
	}



	public SiniestroServiceInterfase getSiniestroService() {
		return siniestroService;
	}



	public void setSiniestroService(SiniestroServiceInterfase siniestroService) {
		this.siniestroService = siniestroService;
	}



	public TerminalAlertaServiceInterfase getTerminalAlertaService() {
		return terminalAlertaService;
	}



	public void setTerminalAlertaService(TerminalAlertaServiceInterfase terminalAlertaService) {
		this.terminalAlertaService = terminalAlertaService;
	}



	public TerminalServiceInterfase getTerminalService() {
		return terminalService;
	}



	public void setTerminalService(TerminalServiceInterfase terminalService) {
		this.terminalService = terminalService;
	}



	public TerminalLogServiceInterfase getTerminalLogService() {
		return terminalLogService;
	}



	public void setTerminalLogService(TerminalLogServiceInterfase terminalLogService) {
		this.terminalLogService = terminalLogService;
	}



	public TerminalReporteServiceInterfase getTerminalReporteService() {
		return terminalReporteService;
	}



	public void setTerminalReporteService(TerminalReporteServiceInterfase terminalReporteService) {
		this.terminalReporteService = terminalReporteService;
	}



	public TerminalReporteDocumentoServiceInterfase getTerminalReporteDocumentoService() {
		return terminalReporteDocumentoService;
	}



	public void setTerminalReporteDocumentoService(
			TerminalReporteDocumentoServiceInterfase terminalReporteDocumentoService) {
		this.terminalReporteDocumentoService = terminalReporteDocumentoService;
	}



	public TerminalReporteDocumentoTipoServiceInterfase getTerminalReporteDocumentoTipoService() {
		return terminalReporteDocumentoTipoService;
	}



	public void setTerminalReporteDocumentoTipoService(
			TerminalReporteDocumentoTipoServiceInterfase terminalReporteDocumentoTipoService) {
		this.terminalReporteDocumentoTipoService = terminalReporteDocumentoTipoService;
	}



	public TransaccionServiceInterfase getTransaccionService() {
		return transaccionService;
	}



	public void setTransaccionService(TransaccionServiceInterfase transaccionService) {
		this.transaccionService = transaccionService;
	}



	public UsuarioServiceInterfase getUsuarioService() {
		return usuarioService;
	}



	public void setUsuarioService(UsuarioServiceInterfase usuarioService) {
		this.usuarioService = usuarioService;
	}



	public UsuarioFrecuenciaServiceInterfase getUsuarioFrecuenciaService() {
		return usuarioFrecuenciaService;
	}



	public void setUsuarioFrecuenciaService(UsuarioFrecuenciaServiceInterfase usuarioFrecuenciaService) {
		this.usuarioFrecuenciaService = usuarioFrecuenciaService;
	}



	public UsuarioLogServiceInterfase getUsuarioLogService() {
		return usuarioLogService;
	}



	public void setUsuarioLogService(UsuarioLogServiceInterfase usuarioLogService) {
		this.usuarioLogService = usuarioLogService;
	}



	public ReporteMovilSacServiceInterfase getReporteMovilSacService() {
		return reporteMovilSacService;
	}



	public void setReporteMovilSacService(ReporteMovilSacServiceInterfase reporteMovilSacService) {
		this.reporteMovilSacService = reporteMovilSacService;
	}



	public SacSP_ServiceInterfase getSacSP_ServiceInterfase() {
		return sacSP_ServiceInterfase;
	}



	public void setSacSP_ServiceInterfase(SacSP_ServiceInterfase sacSP_ServiceInterfase) {
		this.sacSP_ServiceInterfase = sacSP_ServiceInterfase;
	}



	public SiseSP_ServiceInterfase getSiseSP_ServiceInterfase() {
		return siseSP_ServiceInterfase;
	}



	public void setSiseSP_ServiceInterfase(SiseSP_ServiceInterfase siseSP_ServiceInterfase) {
		this.siseSP_ServiceInterfase = siseSP_ServiceInterfase;
	}



	public ReporteMovilSacTercerosServiceInterfase getReporteMovilSacTercerosService() {
		return reporteMovilSacTercerosService;
	}



	public void setReporteMovilSacTercerosService(ReporteMovilSacTercerosServiceInterfase reporteMovilSacTercerosService) {
		this.reporteMovilSacTercerosService = reporteMovilSacTercerosService;
	}



	public ReporteMovilSacGruasServiceInterfase getReporteMovilSacGruasService() {
		return reporteMovilSacGruasService;
	}



	public void setReporteMovilSacGruasService(ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasService) {
		this.reporteMovilSacGruasService = reporteMovilSacGruasService;
	}



	public CatalogoMovilServiceInterfase getCatalogoMovilService() {
		return catalogoMovilService;
	}



	public void setCatalogoMovilService(CatalogoMovilServiceInterfase catalogoMovilService) {
		this.catalogoMovilService = catalogoMovilService;
	}



	public CatalogoVehiculoAjusServiceInterfase getCatalogoVehiculoAjusService() {
		return catalogoVehiculoAjusService;
	}



	public void setCatalogoVehiculoAjusService(CatalogoVehiculoAjusServiceInterfase catalogoVehiculoAjusService) {
		this.catalogoVehiculoAjusService = catalogoVehiculoAjusService;
	}



	public TerminalComentarioServiceInterfase getTerminalComentarioService() {
		return terminalComentarioService;
	}



	public void setTerminalComentarioService(TerminalComentarioServiceInterfase terminalComentarioService) {
		this.terminalComentarioService = terminalComentarioService;
	}



	public HistoricoResumenAjustadorServiceInterfase getHistoricoResumenAjustadorService() {
		return historicoResumenAjustadorService;
	}



	public void setHistoricoResumenAjustadorService(
			HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorService) {
		this.historicoResumenAjustadorService = historicoResumenAjustadorService;
	}



	public CorreoPolizaAgenteServiceInterfase getCorreoPolizaAgenteService() {
		return correoPolizaAgenteService;
	}



	public void setCorreoPolizaAgenteService(CorreoPolizaAgenteServiceInterfase correoPolizaAgenteService) {
		this.correoPolizaAgenteService = correoPolizaAgenteService;
	}



	public ExpedienteEjecutivoServiceInterfase getExpedienteEjecutivoService() {
		return expedienteEjecutivoService;
	}



	public void setExpedienteEjecutivoService(ExpedienteEjecutivoServiceInterfase expedienteEjecutivoService) {
		this.expedienteEjecutivoService = expedienteEjecutivoService;
	}



	public NotasReporteServiceInterfase getNotasReporteService() {
		return notasReporteService;
	}



	public void setNotasReporteService(NotasReporteServiceInterfase notasReporteService) {
		this.notasReporteService = notasReporteService;
	}



	public CodigoResponsabilidadEstadServiceInterfase getCodigoResponsabilidadEstad() {
		return codigoResponsabilidadEstad;
	}



	public void setCodigoResponsabilidadEstad(CodigoResponsabilidadEstadServiceInterfase codigoResponsabilidadEstad) {
		this.codigoResponsabilidadEstad = codigoResponsabilidadEstad;
	}



	public UsuarioAlertasServiceInterfase getUsuarioAlertasService() {
		return usuarioAlertasService;
	}



	public void setUsuarioAlertasService(UsuarioAlertasServiceInterfase usuarioAlertasService) {
		this.usuarioAlertasService = usuarioAlertasService;
	}



	public CodigoResponsabilidadEstadServiceInterfase getCodigoResponsabilidadEstService() {
		return codigoResponsabilidadEstService;
	}



	public void setCodigoResponsabilidadEstService(
			CodigoResponsabilidadEstadServiceInterfase codigoResponsabilidadEstService) {
		this.codigoResponsabilidadEstService = codigoResponsabilidadEstService;
	}



	public ControlFotografiasServiceInterfase getControlFotografiasService() {
		return controlFotografiasService;
	}



	public void setControlFotografiasService(ControlFotografiasServiceInterfase controlFotografiasService) {
		this.controlFotografiasService = controlFotografiasService;
	}



	public FormatoReclamacionPendienteServiceInterfase getFormatoReclamacionPendienteService() {
		return formatoReclamacionPendienteService;
	}



	public void setFormatoReclamacionPendienteService(
			FormatoReclamacionPendienteServiceInterfase formatoReclamacionPendienteService) {
		this.formatoReclamacionPendienteService = formatoReclamacionPendienteService;
	}



	public FormatoEncuestaServicioServiceInterfase getFormatoEncuestaServicioService() {
		return formatoEncuestaServicioService;
	}



	public void setFormatoEncuestaServicioService(FormatoEncuestaServicioServiceInterfase formatoEncuestaServicioService) {
		this.formatoEncuestaServicioService = formatoEncuestaServicioService;
	}



	public FormatoAsistenciaVialServiceInterfase getFormatoAsistenciaVialService() {
		return formatoAsistenciaVialService;
	}



	public void setFormatoAsistenciaVialService(FormatoAsistenciaVialServiceInterfase formatoAsistenciaVialService) {
		this.formatoAsistenciaVialService = formatoAsistenciaVialService;
	}



	public FormatoNuevosVehiculosServiceInterfase getFormatoNuevosVehiculosService() {
		return formatoNuevosVehiculosService;
	}



	public void setFormatoNuevosVehiculosService(FormatoNuevosVehiculosServiceInterfase formatoNuevosVehiculosService) {
		this.formatoNuevosVehiculosService = formatoNuevosVehiculosService;
	}



	public FormatoPaseMedicoServiceInterfase getFormatoPaseMedicoService() {
		return formatoPaseMedicoService;
	}



	public void setFormatoPaseMedicoService(FormatoPaseMedicoServiceInterfase formatoPaseMedicoService) {
		this.formatoPaseMedicoService = formatoPaseMedicoService;
	}



	public FormatoAsignacionAbogadoServiceInterfase getFormatoAsignacionAbogadoService() {
		return formatoAsignacionAbogadoService;
	}



	public void setFormatoAsignacionAbogadoService(
			FormatoAsignacionAbogadoServiceInterfase formatoAsignacionAbogadoService) {
		this.formatoAsignacionAbogadoService = formatoAsignacionAbogadoService;
	}



	public FormatoAdmisionAutomovilesServiceInterfase getFormatoAdmisionAutomovilesService() {
		return formatoAdmisionAutomovilesService;
	}



	public void setFormatoAdmisionAutomovilesService(
			FormatoAdmisionAutomovilesServiceInterfase formatoAdmisionAutomovilesService) {
		this.formatoAdmisionAutomovilesService = formatoAdmisionAutomovilesService;
	}



	public FormatoAdmisionMotocicletasServiceInterfase getFormatoAdmisionMotocicletasService() {
		return formatoAdmisionMotocicletasService;
	}



	public void setFormatoAdmisionMotocicletasService(
			FormatoAdmisionMotocicletasServiceInterfase formatoAdmisionMotocicletasService) {
		this.formatoAdmisionMotocicletasService = formatoAdmisionMotocicletasService;
	}



	public FormatoGarantiaPrendariaServiceInterfase getFormatoGarantiaPrendaria() {
		return formatoGarantiaPrendaria;
	}



	public void setFormatoGarantiaPrendaria(FormatoGarantiaPrendariaServiceInterfase formatoGarantiaPrendaria) {
		this.formatoGarantiaPrendaria = formatoGarantiaPrendaria;
	}



	public FormatoReparacionBienesServiceInterfase getFormatoReparacionBienesService() {
		return formatoReparacionBienesService;
	}



	public void setFormatoReparacionBienesService(FormatoReparacionBienesServiceInterfase formatoReparacionBienesService) {
		this.formatoReparacionBienesService = formatoReparacionBienesService;
	}



	public FormatoValeAmbulanciaServiceInterfase getFormatoValeAmbulanciaService() {
		return formatoValeAmbulanciaService;
	}



	public void setFormatoValeAmbulanciaService(FormatoValeAmbulanciaServiceInterfase formatoValeAmbulanciaService) {
		this.formatoValeAmbulanciaService = formatoValeAmbulanciaService;
	}



	public FormatoOrdenServicioServiceInterfase getFormatoOrdenServicioService() {
		return formatoOrdenServicioService;
	}



	public void setFormatoOrdenServicioService(FormatoOrdenServicioServiceInterfase formatoOrdenServicioService) {
		this.formatoOrdenServicioService = formatoOrdenServicioService;
	}



	public FormatoInspeccionPesadoServiceInterfase getFormatoInspeccionPesado() {
		return formatoInspeccionPesado;
	}



	public void setFormatoInspeccionPesado(FormatoInspeccionPesadoServiceInterfase formatoInspeccionPesado) {
		this.formatoInspeccionPesado = formatoInspeccionPesado;
	}



	public FormatoInspeccionMotoServiceInterfase getFormatoInspeccionMotoService() {
		return formatoInspeccionMotoService;
	}



	public void setFormatoInspeccionMotoService(FormatoInspeccionMotoServiceInterfase formatoInspeccionMotoService) {
		this.formatoInspeccionMotoService = formatoInspeccionMotoService;
	}



	public FormatoAdmisionPesadoServiceInterfase getFormatoAdmisionPesadoService() {
		return formatoAdmisionPesadoService;
	}



	public void setFormatoAdmisionPesadoService(FormatoAdmisionPesadoServiceInterfase formatoAdmisionPesadoService) {
		this.formatoAdmisionPesadoService = formatoAdmisionPesadoService;
	}



	public FormatoInventarioAutomovilesServiceInterfase getFormatoInventarioService() {
		return formatoInventarioService;
	}



	public void setFormatoInventarioService(FormatoInventarioAutomovilesServiceInterfase formatoInventarioService) {
		this.formatoInventarioService = formatoInventarioService;
	}



	public FormatoCuestionarioRoboServiceInterfase getFormatoCuestionarioRoboService() {
		return formatoCuestionarioRoboService;
	}



	public void setFormatoCuestionarioRoboService(FormatoCuestionarioRoboServiceInterfase formatoCuestionarioRoboService) {
		this.formatoCuestionarioRoboService = formatoCuestionarioRoboService;
	}



	public FormatoDeclaracionUniversalServiceInterfase getFormatoDeclaracionUniversal() {
		return formatoDeclaracionUniversal;
	}



	public void setFormatoDeclaracionUniversal(FormatoDeclaracionUniversalServiceInterfase formatoDeclaracionUniversal) {
		this.formatoDeclaracionUniversal = formatoDeclaracionUniversal;
	}



	public FormatoReciboPagoDeducibleServiceInterfase getFormatoReciboPagoDeducible() {
		return formatoReciboPagoDeducible;
	}



	public void setFormatoReciboPagoDeducible(FormatoReciboPagoDeducibleServiceInterfase formatoReciboPagoDeducible) {
		this.formatoReciboPagoDeducible = formatoReciboPagoDeducible;
	}



	public FormatoReciboIngresoSiniestroServiceInterfase getFormatoReciboIngresoSiniestroService() {
		return formatoReciboIngresoSiniestroService;
	}



	public void setFormatoReciboIngresoSiniestroService(
			FormatoReciboIngresoSiniestroServiceInterfase formatoReciboIngresoSiniestroService) {
		this.formatoReciboIngresoSiniestroService = formatoReciboIngresoSiniestroService;
	}



	public FormatoSolicitudDiagnosticoServiceInterfase getFormatoSolicitudDiagnostico() {
		return formatoSolicitudDiagnostico;
	}



	public void setFormatoSolicitudDiagnostico(FormatoSolicitudDiagnosticoServiceInterfase formatoSolicitudDiagnostico) {
		this.formatoSolicitudDiagnostico = formatoSolicitudDiagnostico;
	}



	public FormatoMemoriaDescriptivaServiceInterfase getFormatoMemoriaDescriptiva() {
		return formatoMemoriaDescriptiva;
	}



	public void setFormatoMemoriaDescriptiva(FormatoMemoriaDescriptivaServiceInterfase formatoMemoriaDescriptiva) {
		this.formatoMemoriaDescriptiva = formatoMemoriaDescriptiva;
	}



	public FormatoCargoTarjetaCreditoServiceInterfase getFormatoCargoTarjetaCredito() {
		return formatoCargoTarjetaCredito;
	}



	public void setFormatoCargoTarjetaCredito(FormatoCargoTarjetaCreditoServiceInterfase formatoCargoTarjetaCredito) {
		this.formatoCargoTarjetaCredito = formatoCargoTarjetaCredito;
	}



	public FormatoResponsabilidadCivilServiceInterfase getFormatoResponsabilidadCivil() {
		return formatoResponsabilidadCivil;
	}



	public void setFormatoResponsabilidadCivil(FormatoResponsabilidadCivilServiceInterfase formatoResponsabilidadCivil) {
		this.formatoResponsabilidadCivil = formatoResponsabilidadCivil;
	}



	public FormatoReparacionBienesDiversosServiceInterfase getFormatoReparacionBienesDiversos() {
		return formatoReparacionBienesDiversos;
	}



	public void setFormatoReparacionBienesDiversos(
			FormatoReparacionBienesDiversosServiceInterfase formatoReparacionBienesDiversos) {
		this.formatoReparacionBienesDiversos = formatoReparacionBienesDiversos;
	}



	public FormatoObservacionesAseguradoServiceInterfase getFormatoObservacionesAsegurado() {
		return formatoObservacionesAsegurado;
	}



	public void setFormatoObservacionesAsegurado(
			FormatoObservacionesAseguradoServiceInterfase formatoObservacionesAsegurado) {
		this.formatoObservacionesAsegurado = formatoObservacionesAsegurado;
	}



	public FormatoInventarioUnicoPesadoServiceInterfase getFormatoInventarioUnicoPesado() {
		return formatoInventarioUnicoPesado;
	}



	public void setFormatoInventarioUnicoPesado(FormatoInventarioUnicoPesadoServiceInterfase formatoInventarioUnicoPesado) {
		this.formatoInventarioUnicoPesado = formatoInventarioUnicoPesado;
	}



	public FormatoReclamacionComprobantePeajeServiceInterfase getFormatoReclamacionComprobantePeaje() {
		return formatoReclamacionComprobantePeaje;
	}



	public void setFormatoReclamacionComprobantePeaje(
			FormatoReclamacionComprobantePeajeServiceInterfase formatoReclamacionComprobantePeaje) {
		this.formatoReclamacionComprobantePeaje = formatoReclamacionComprobantePeaje;
	}



	public MetricaEDServiceInterfase getMetricaEDService() {
		return metricaEDService;
	}



	public void setMetricaEDService(MetricaEDServiceInterfase metricaEDService) {
		this.metricaEDService = metricaEDService;
	}

	public CargaDatosCSVServiceInterfase getCargaDatosService() {
		return cargaDatosService;
	}

	public void setCargaDatosService(CargaDatosCSVServiceInterfase cargaDatosService) {
		this.cargaDatosService = cargaDatosService;
	}

	public String getClaveHorario() {
		return claveHorario;
	}
	public void setClaveHorario(String claveHorario) {
		this.claveHorario = claveHorario;
	}

	public CatalogoRecuperacionesServiceInterfase getCatagalogoRecuperacionesService() {
		return catagalogoRecuperacionesService;
	}

	public void setCatagalogoRecuperacionesService(CatalogoRecuperacionesServiceInterfase catagalogoRecuperacionesService) {
		this.catagalogoRecuperacionesService = catagalogoRecuperacionesService;
	}

	public CatalogoColoresServiceInterfase getCatalogoColoresService() {
		return catalogoColoresService;
	}

	public void setCatalogoColoresService(CatalogoColoresServiceInterfase catalogoColoresService) {
		this.catalogoColoresService = catalogoColoresService;
	}

	public CatalogoVehTercServiceInterfase getCatalogoVehTercService() {
		return catalogoVehTercService;
	}

	public void setCatalogoVehTercService(CatalogoVehTercServiceInterfase catalogoVehTercService) {
		this.catalogoVehTercService = catalogoVehTercService;
	}

	public CatalogoDependenciasServiceInterfase getCatalogoDependenciasService() {
		return catalogoDependenciasService;
	}

	public void setCatalogoDependenciasService(CatalogoDependenciasServiceInterfase catalogoDependenciasService) {
		this.catalogoDependenciasService = catalogoDependenciasService;
	}

	public CatalogoTramoCarServiceInterfase getCatalogoTramoCarService() {
		return catalogoTramoCarService;
	}

	public void setCatalogoTramoCarService(CatalogoTramoCarServiceInterfase catalogoTramoCarService) {
		this.catalogoTramoCarService = catalogoTramoCarService;
	}

	public CatalogoFaqServiceInterfase getCatalogoFaqService() {
		return catalogoFaqService;
	}

	public void setCatalogoFaqService(CatalogoFaqServiceInterfase catalogoFaqService) {
		this.catalogoFaqService = catalogoFaqService;
	}

	public CatalogoCoberturasServiceInterfase getCatalogoCoberturasService() {
		return catalogoCoberturasService;
	}

	public void setCatalogoCoberturasService(CatalogoCoberturasServiceInterfase catalogoCoberturasService) {
		this.catalogoCoberturasService = catalogoCoberturasService;
	}



	public CatalogoClaseVehServiceInterfase getCatalogoClaseVehService() {
		return catalogoClaseVehService;
	}



	public void setCatalogoClaseVehService(CatalogoClaseVehServiceInterfase catalogoClaseVehService) {
		this.catalogoClaseVehService = catalogoClaseVehService;
	}

	public CatalogoCredencialesServiceInterfase getCatalogoCredencialesService() {
		return catalogoCredencialesService;
	}

	public void setCatalogoCredencialesService(CatalogoCredencialesServiceInterfase catalogoCredencialesService) {
		this.catalogoCredencialesService = catalogoCredencialesService;
	}

	public CatalogoAccidentesServiceInterfase getCatalogoAccidentesService() {
		return catalogoAccidentesService;
	}

	public void setCatalogoAccidentesService(CatalogoAccidentesServiceInterfase catalogoAccidentesService) {
		this.catalogoAccidentesService = catalogoAccidentesService;
	}

	public CatalogoRCBienesServiceInterface getCatalogoRCBienesService() {
		return catalogoRCBienesService;
	}

	public void setCatalogoRCBienesService(CatalogoRCBienesServiceInterface catalogoRCBienesService) {
		this.catalogoRCBienesService = catalogoRCBienesService;
	}

	public CatalogoGruaServiceInterface getCatalogoGruaService() {
		return catalogoGruaService;
	}

	public void setCatalogoGruaService(CatalogoGruaServiceInterface catalogoGruaService) {
		this.catalogoGruaService = catalogoGruaService;
	}

	public CatalogoHospitalesServiceInterfase getCatalogoHospitalesService() {
		return catalogoHospitalesService;
	}

	public void setCatalogoHospitalesService(CatalogoHospitalesServiceInterfase catalogoHospitalesService) {
		this.catalogoHospitalesService = catalogoHospitalesService;
	}

	public CatalogoMarcaTercServiceInterfase getCatalogoMarcaTercService() {
		return catalogoMarcaTercService;
	}

	public void setCatalogoMarcaTercService(CatalogoMarcaTercServiceInterfase catalogoMarcaTercService) {
		this.catalogoMarcaTercService = catalogoMarcaTercService;
	}

	public CatalogoPartesAutoServiceInterfase getCatalogoPartesAutoService() {
		return catalogoPartesAutoService;
	}

	public void setCatalogoPartesAutoService(CatalogoPartesAutoServiceInterfase catalogoPartesAutoService) {
		this.catalogoPartesAutoService = catalogoPartesAutoService;
	}

	public CatalogoMPServiceInterfase getCatalogoMPService() {
		return catalogoMPService;
	}

	public void setCatalogoMPService(CatalogoMPServiceInterfase catalogoMPService) {
		this.catalogoMPService = catalogoMPService;
	}

	public FormatoCatalogosServiceInterfase getFormatoCatalogosService() {
		return formatoCatalogosService;
	}

	public void setFormatoCatalogosService(FormatoCatalogosServiceInterfase formatoCatalogosService) {
		this.formatoCatalogosService = formatoCatalogosService;
	}
	
}
