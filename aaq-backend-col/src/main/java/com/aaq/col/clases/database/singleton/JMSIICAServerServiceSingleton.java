package com.aaq.col.clases.database.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaq.col.clases.database.servicios.interfase.*;


@Service
public class JMSIICAServerServiceSingleton {
	private static JMSIICAServerServiceSingleton instance;

	public synchronized static JMSIICAServerServiceSingleton getInstance() {
		if (JMSIICAServerServiceSingleton.instance == null) {
			{
				JMSIICAServerServiceSingleton.instance = new JMSIICAServerServiceSingleton();
			}
		}
		return JMSIICAServerServiceSingleton.instance;
	}

	@Autowired
	private CargaDatosCSVServiceInterfase cargaDatosService;
	
	@Autowired
	private BaseServiceInterfase baseService;

	@Autowired
	private CalleCruceServiceInterfase calleCruceService;

	@Autowired
	private CalleServiceInterfase calleService;

	@Autowired
	private CalleDireccionServiceInterfase calleDireccionService;

	@Autowired
	private CarreteraServiceInterfase carreteraService;

	@Autowired
	private CartografiaServiceInterfase cartografiaService;

	@Autowired
	private CatalogoAseguradoraServiceInterfase catalogoAseguradoraService;

	@Autowired
	private CatalogoClaveDeEntidadServiceInterfase catalogoClaveDeEntidadService;

	@Autowired
	private CatalogoCodigoDeCausaServiceInterfase catalogoCodigoDeCausaService;

	@Autowired
	private CatalogoCodigoRespuestaBancarioServiceInterfase catalogoCodigoRespuestaBancarioService;

	@Autowired
	private CatalogoMarcaServiceInterfase catalogoMarcaService;

	@Autowired
	private CatalogoMarcaEstiloServiceInterfase catalogoMarcaEstiloService;

	@Autowired
	private CatalogoOficinaServiceInterfase catalogoOficinaService;

	@Autowired
	private CatalogoProveedorAsistenciaServiceInterfase catalogoProveedorAsistenciaService;

	@Autowired
	private CatalogoProveedorAsistenciaIdentificadorServiceInterfase catalogoProveedorAsistenciaIdentificadorService;

	@Autowired
	private CatalogoTipoAsistenciaServiceInterfase catalogoTipoAsistenciaService;

	@Autowired
	private CatalogoVehiculoTipoServiceInterfase catalogoVehiculoTipoService;

	@Autowired
	private CatalogoVehiculoUsoServiceInterfase catalogoVehiculoUsoService;

	@Autowired
	private ColoniaServiceInterfase coloniaService;

	@Autowired
	private ComunicadoServiceInterfase comunicadoService;

	@Autowired
	private ConfiguracionServiceInterfase configuracionService;
	
	@Autowired
	private CatalogoRolesServiceInterfase catalogoRolesService;
	
	@Autowired
	private EstadoServiceInterfase estadoService;
	
	@Autowired
	private EncuestaAjustadorServiceInterfase encuestaAjustadorService;

	@Autowired
	private FrecuenciaBaseServiceInterfase frecuenciaBaseService;
	
	@Autowired
	private GrupoTerminalServiceInterfase grupoTerminalService;
	
	@Autowired
	private GuardiaGrupoServiceInterfase guardiaGrupoService;
	
	@Autowired
	private HorarioGrupoServiceInterfase horarioGrupoService;
	
	@Autowired
	private FrecuenciaServiceInterfase frecuenciaService;
	
	@Autowired
	private HorariosServiceInterfase horariosService;
	
	@Autowired
	private GeocercaByEstadoServiceInterfase geocercaByEstadoService;

	@Autowired
	private GeocercaServiceInterfase geocercaService;

	@Autowired
	private GeocercaPuntoServiceInterfase geocercaPuntoService;

	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalService;
	
	@Autowired
	private MensajeSmsServiceInterfase mensajeSmsService;

	@Autowired
	private ModuloServiceInterfase moduloService;

	@Autowired
	private ModuloPadreServiceInterfase moduloPadreService;

	@Autowired
	private MunicipioServiceInterfase municipioService;

	@Autowired
	private PerfilServiceInterfase perfilService;
	
	@Autowired
	private GrupoServiceInterfase grupoService;

	@Autowired
	private PermisoServiceInterfase permisoService;

	@Autowired
	private PuntoInteresServiceInterfase puntoInteresService;

	@Autowired
	private PuntoInteresTipoServiceInterfase puntoInteresTipoService;

	@Autowired
	private ReferenciaServiceInterfase referenciaService;

	@Autowired
	private ReporteAbogadoServiceInterfase reporteAbogadoService;

	@Autowired
	private ReporteMovilServiceInterfase reporteMovilService;
	
	@Autowired
	private ReporteMovilSacServiceInterfase reporteMovilSacService;
	
	@Autowired
	private ReporteMovilSacTercerosServiceInterfase ReporteMovilSacTercerosService;
	
	@Autowired
	private ReporteMovilSacTalleresServiceInterfase reporteMovilSacTalleresService;
	
	@Autowired
	private ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasService;

	@Autowired
	private ReporteSiseServiceInterfase reporteSiseService;

	@Autowired
	private ReporteSolicitadoServiceInterfase reporteSolicitadoService;

	@Autowired
	private SessionServiceInterfase sessionService;

	@Autowired
	private SessionExternaServiceInterfase sessionExternaService;

	@Autowired
	private SiniestroServiceInterfase siniestroService;

	@Autowired
	private TerminalAlertaServiceInterfase terminalAlertaService;

	@Autowired
	private TerminalAlertaLogServiceInterfase terminalAlertaLogService;

	@Autowired
	private TerminalServiceInterfase terminalService;

	@Autowired
	private TerminalLogServiceInterfase terminalLogService;

	@Autowired
	private TerminalReporteServiceInterfase terminalReporteService;

	@Autowired
	private TerminalReporteDocumentoServiceInterfase terminalReporteDocumentoService;

	@Autowired
	private TerminalReporteDocumentoTipoServiceInterfase terminalReporteDocumentoTipoService;

	@Autowired
	private TransaccionServiceInterfase transaccionService;

	@Autowired
	private UsuarioServiceInterfase usuarioService;

	@Autowired
	private UsuarioFrecuenciaServiceInterfase usuarioFrecuenciaService;

	@Autowired
	private UsuarioLogServiceInterfase usuarioLogService;
	
	@Autowired
	private SacSP_ServiceInterfase sacSP_ServiceInterfase;
	
	@Autowired
	private SiseSP_ServiceInterfase siseSP_ServiceInterfase;
	
	@Autowired
	private OrdenPaseAmbulanciaServiceInterfase ordenPaseAmbulanciaService;
	
	@Autowired
	private OrdenPaseAdmisionServiceInterfase ordenPaseAdmisionService;
	
	@Autowired
	private OrdenPaseEquipoPesadoServiceInterfase ordenPaseEquipoPesadoService;
	
	@Autowired
	private OrdenPaseMedicoServiceInterfase ordenPaseMedicoService;
	
	@Autowired
	private OrdenPaseReclamacionServiceInterfase ordenPaseReclamacionService;
	
	@Autowired
	private TerminalComentarioServiceInterfase terminalComentarioService;
	
	@Autowired
	private CatalogoVehiculoAjusServiceInterfase catalogoVehiculoAjusService;
	
	@Autowired
	private CatalogoMovilServiceInterfase catalogoMovilService;
	
	@Autowired
	private UsuarioAlertasServiceInterfase usuarioAlertasService;

	@Autowired
	private HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorService;
	
	@Autowired
	private CatalogoRecuperacionesServiceInterfase catalogoRecuperacionesService;
	
	@Autowired
	private CatalogoCoberturasServiceInterfase catalogoCoberturasService;
	
	@Autowired
	private CatalogoCodigoResponsabilidadServiceInterfase catalogoCodigoResponsabilidadService;
	
	@Autowired
	private EntidadAbogadoCrmServiceInterfase entidadAbogadoCrmService;
	
	@Autowired
	private FormatoReclamacionPendienteServiceInterfase formatoReclamacionPendienteService;
	
	@Autowired
	private FormatoEncuestaServicioServiceInterfase formatoEncuestaServicioService;
	
	@Autowired
	private FormatoAsistenciaVialServiceInterfase formatoAsistenciaVialService;
	
	@Autowired
	private FormatoNuevosVehiculosServiceInterfase formatoNuevosVehiculosService;
	
	@Autowired
	private FormatoPaseMedicoServiceInterfase formatoPaseMedicoService;
	
	@Autowired
	private FormatoAsignacionAbogadoServiceInterfase formatoAsignacionAbogadoService;
	

	@Autowired
	private FormatoReparacionBienesServiceInterfase formatoReparacionBienesService;
	
	@Autowired
	private FormatoValeAmbulanciaServiceInterfase formatoValeAmbulanciaService;
	

	@Autowired
	private FormatoOrdenServicioServiceInterfase formatoOrdenServicioService;
	
	@Autowired
	private FormatoGarantiaPrendariaServiceInterfase formatoGarantiaPrendariaService;
	
	@Autowired
	private FormatoDeclaracionUniversalServiceInterfase formatoDeclaracionUniversalService;

	@Autowired
	private FormatoInventarioAutomovilesServiceInterfase formatoInventarioAutomovilesService;
	
	@Autowired
	private FormatoCuestionarioRoboServiceInterfase formatoCuestionarioRoboService;
	
	@Autowired
	private FormatoAdmisionAutomovilesServiceInterfase formatoAdmisionAutomovilesService;

	@Autowired
	private FormatoAdmisionMotocicletasServiceInterfase formatoAdmisionMotocicletasService;
	
	@Autowired
	private FormatoAdmisionPesadoServiceInterfase formatoAdmisionPesadoService;

	@Autowired
	private FormatoInspeccionMotoServiceInterfase formatoInspeccionMotoService;

	@Autowired
	private FormatoInspeccionPesadoServiceInterfase formatoInspeccionPesadoService;
	
	@Autowired
	private FormatoCatalogosServiceInterfase formatoCatalogosService;
	
	@Autowired
	private LogFormatosAjustadorErrorServiceInterfase logFormatosAjustadorErrorService;
	
	@Autowired
	private CorreoPolizaAgenteServiceInterfase correoPolizaAgenteService;

	@Autowired 
	private InfoReconocimientoServiceInterface  infoReconocimientoService;
	
	@Autowired
	private FormatoReciboIngresoSiniestroServiceInterfase formatoReciboIngresoSiniestroService;
	
	@Autowired
	private FormatoReciboPagoDeducibleServiceInterfase formatoReciboPagoDeducibleService;

	@Autowired
	private FormatoSolicitudDiagnosticoServiceInterfase formatoSolicitudDiagnosticoService;

	@Autowired
	private FormatoMemoriaDescriptivaServiceInterfase formatoMemoriaDescriptivaService;
	
	@Autowired
	private FormatoCargoTarjetaCreditoServiceInterfase formatoCargoTarjetaCreditoService;
	
	@Autowired
	private FormatoResponsabilidadCivilServiceInterfase formatoResponsabilidadCivilService;
	
	@Autowired
	private FormatoReparacionBienesDiversosServiceInterfase formatoReparacionBienesDiversosService;
	
	@Autowired
	private ExpedienteEjecutivoServiceInterfase expedienteEjecutivoService;
	
	@Autowired
	private FormatoObservacionesAseguradoServiceInterfase formatoObservacionesAseguradoService;
	
	@Autowired
	private NotasReporteServiceInterfase notasReporteService;
	
	@Autowired
	private FormatoInventarioUnicoPesadoServiceInterfase formatoInventarioUnicoPesadoService;

	@Autowired
	private FormatoReclamacionComprobantePeajeServiceInterfase formatoReclamacionComprobantePeajeService;
	
	@Autowired
	private CodigoResponsabilidadEstadServiceInterfase codigoResponsabilidadEstadService;
	
	@Autowired
	private ControlFotografiasServiceInterfase controlFotografiasService;
	
	@Autowired
	private MetricaEDServiceInterfase metricaEDService;
	
	@Autowired
	private HistoricoRecuperosAjustadorServiceInterfase historicoRecuperosAjustadorService;

	@Autowired
	private CatalogoColoresServiceInterfase catalogoColoresService;
	
	@Autowired
	private CatalogoVehTercServiceInterfase  catalogoVehTercService;
	
	@Autowired
	private CatalogoDependenciasServiceInterfase catalogoDependenciasService;
	
	@Autowired
	private CatalogoTramoCarServiceInterfase catalogoTramoCarService;

	@Autowired
	private CatalogoFaqServiceInterfase catalogoFaqService;
	
	@Autowired
	private CatalogoClaseVehServiceInterfase catalogoClaseVehService;
	
	@Autowired
	private CatalogoCredencialesServiceInterfase catalogoCredencialesService;
	
	@Autowired
	private CatalogoAccidentesServiceInterfase catalogoAccidentesService;
	
	@Autowired
	private CatalogoRCBienesServiceInterface catalogoRCBienesService;
	
	@Autowired
	private CatalogoGruaServiceInterface catalogoGruaService;
	
	@Autowired
	private CatalogoHospitalesServiceInterfase catalogoHospitalesService;
	
	@Autowired
	private CatalogoMarcaTercServiceInterfase catalogoMarcaTercService;
	
	@Autowired
	private CatalogoPartesAutoServiceInterfase catalogoPartesAutoService;
	
	@Autowired
	private CatalogoMPServiceInterfase catalogoMPService;
	
	
	public CargaDatosCSVServiceInterfase getCargaDatosService() {
		return cargaDatosService;
	}

	public void setCargaDatosService(CargaDatosCSVServiceInterfase cargaDatosService) {
		this.cargaDatosService = cargaDatosService;
	}

	public BaseServiceInterfase getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseServiceInterfase baseService) {
		this.baseService = baseService;
	}

	public CalleCruceServiceInterfase getCalleCruceService() {
		return calleCruceService;
	}

	public void setCalleCruceService(CalleCruceServiceInterfase calleCruceService) {
		this.calleCruceService = calleCruceService;
	}

	public CalleServiceInterfase getCalleService() {
		return calleService;
	}

	public void setCalleService(CalleServiceInterfase calleService) {
		this.calleService = calleService;
	}

	public CalleDireccionServiceInterfase getCalleDireccionService() {
		return calleDireccionService;
	}

	public void setCalleDireccionService(CalleDireccionServiceInterfase calleDireccionService) {
		this.calleDireccionService = calleDireccionService;
	}

	public CarreteraServiceInterfase getCarreteraService() {
		return carreteraService;
	}

	public void setCarreteraService(CarreteraServiceInterfase carreteraService) {
		this.carreteraService = carreteraService;
	}

	public CartografiaServiceInterfase getCartografiaService() {
		return cartografiaService;
	}

	public void setCartografiaService(CartografiaServiceInterfase cartografiaService) {
		this.cartografiaService = cartografiaService;
	}

	public CatalogoAseguradoraServiceInterfase getCatalogoAseguradoraService() {
		return catalogoAseguradoraService;
	}

	public void setCatalogoAseguradoraService(CatalogoAseguradoraServiceInterfase catalogoAseguradoraService) {
		this.catalogoAseguradoraService = catalogoAseguradoraService;
	}

	public CatalogoClaveDeEntidadServiceInterfase getCatalogoClaveDeEntidadService() {
		return catalogoClaveDeEntidadService;
	}

	public void setCatalogoClaveDeEntidadService(CatalogoClaveDeEntidadServiceInterfase catalogoClaveDeEntidadService) {
		this.catalogoClaveDeEntidadService = catalogoClaveDeEntidadService;
	}

	public CatalogoCodigoDeCausaServiceInterfase getCatalogoCodigoDeCausaService() {
		return catalogoCodigoDeCausaService;
	}

	public void setCatalogoCodigoDeCausaService(CatalogoCodigoDeCausaServiceInterfase catalogoCodigoDeCausaService) {
		this.catalogoCodigoDeCausaService = catalogoCodigoDeCausaService;
	}

	public CatalogoCodigoRespuestaBancarioServiceInterfase getCatalogoCodigoRespuestaBancarioService() {
		return catalogoCodigoRespuestaBancarioService;
	}

	public void setCatalogoCodigoRespuestaBancarioService(
			CatalogoCodigoRespuestaBancarioServiceInterfase catalogoCodigoRespuestaBancarioService) {
		this.catalogoCodigoRespuestaBancarioService = catalogoCodigoRespuestaBancarioService;
	}

	public CatalogoMarcaServiceInterfase getCatalogoMarcaService() {
		return catalogoMarcaService;
	}

	public void setCatalogoMarcaService(CatalogoMarcaServiceInterfase catalogoMarcaService) {
		this.catalogoMarcaService = catalogoMarcaService;
	}

	public CatalogoMarcaEstiloServiceInterfase getCatalogoMarcaEstiloService() {
		return catalogoMarcaEstiloService;
	}

	public void setCatalogoMarcaEstiloService(CatalogoMarcaEstiloServiceInterfase catalogoMarcaEstiloService) {
		this.catalogoMarcaEstiloService = catalogoMarcaEstiloService;
	}

	public CatalogoOficinaServiceInterfase getCatalogoOficinaService() {
		return catalogoOficinaService;
	}

	public void setCatalogoOficinaService(CatalogoOficinaServiceInterfase catalogoOficinaService) {
		this.catalogoOficinaService = catalogoOficinaService;
	}

	public CatalogoProveedorAsistenciaServiceInterfase getCatalogoProveedorAsistenciaService() {
		return catalogoProveedorAsistenciaService;
	}

	public void setCatalogoProveedorAsistenciaService(
			CatalogoProveedorAsistenciaServiceInterfase catalogoProveedorAsistenciaService) {
		this.catalogoProveedorAsistenciaService = catalogoProveedorAsistenciaService;
	}

	public CatalogoProveedorAsistenciaIdentificadorServiceInterfase getCatalogoProveedorAsistenciaIdentificadorService() {
		return catalogoProveedorAsistenciaIdentificadorService;
	}

	public void setCatalogoProveedorAsistenciaIdentificadorService(
			CatalogoProveedorAsistenciaIdentificadorServiceInterfase catalogoProveedorAsistenciaIdentificadorService) {
		this.catalogoProveedorAsistenciaIdentificadorService = catalogoProveedorAsistenciaIdentificadorService;
	}

	public CatalogoTipoAsistenciaServiceInterfase getCatalogoTipoAsistenciaService() {
		return catalogoTipoAsistenciaService;
	}

	public void setCatalogoTipoAsistenciaService(CatalogoTipoAsistenciaServiceInterfase catalogoTipoAsistenciaService) {
		this.catalogoTipoAsistenciaService = catalogoTipoAsistenciaService;
	}

	public CatalogoVehiculoTipoServiceInterfase getCatalogoVehiculoTipoService() {
		return catalogoVehiculoTipoService;
	}

	public void setCatalogoVehiculoTipoService(CatalogoVehiculoTipoServiceInterfase catalogoVehiculoTipoService) {
		this.catalogoVehiculoTipoService = catalogoVehiculoTipoService;
	}

	public CatalogoVehiculoUsoServiceInterfase getCatalogoVehiculoUsoService() {
		return catalogoVehiculoUsoService;
	}

	public void setCatalogoVehiculoUsoService(CatalogoVehiculoUsoServiceInterfase catalogoVehiculoUsoService) {
		this.catalogoVehiculoUsoService = catalogoVehiculoUsoService;
	}

	public ColoniaServiceInterfase getColoniaService() {
		return coloniaService;
	}

	public void setColoniaService(ColoniaServiceInterfase coloniaService) {
		this.coloniaService = coloniaService;
	}

	public ComunicadoServiceInterfase getComunicadoService() {
		return comunicadoService;
	}

	public void setComunicadoService(ComunicadoServiceInterfase comunicadoService) {
		this.comunicadoService = comunicadoService;
	}

	public ConfiguracionServiceInterfase getConfiguracionService() {
		return configuracionService;
	}

	public void setConfiguracionService(ConfiguracionServiceInterfase configuracionService) {
		this.configuracionService = configuracionService;
	}

	public CatalogoRolesServiceInterfase getCatalogoRolesService() {
		return catalogoRolesService;
	}

	public void setCatalogoRolesService(CatalogoRolesServiceInterfase catalogoRolesService) {
		this.catalogoRolesService = catalogoRolesService;
	}

	public EstadoServiceInterfase getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoServiceInterfase estadoService) {
		this.estadoService = estadoService;
	}

	public EncuestaAjustadorServiceInterfase getEncuestaAjustadorService() {
		return encuestaAjustadorService;
	}

	public void setEncuestaAjustadorService(EncuestaAjustadorServiceInterfase encuestaAjustadorService) {
		this.encuestaAjustadorService = encuestaAjustadorService;
	}

	public FrecuenciaBaseServiceInterfase getFrecuenciaBaseService() {
		return frecuenciaBaseService;
	}

	public void setFrecuenciaBaseService(FrecuenciaBaseServiceInterfase frecuenciaBaseService) {
		this.frecuenciaBaseService = frecuenciaBaseService;
	}

	public GrupoTerminalServiceInterfase getGrupoTerminalService() {
		return grupoTerminalService;
	}

	public void setGrupoTerminalService(GrupoTerminalServiceInterfase grupoTerminalService) {
		this.grupoTerminalService = grupoTerminalService;
	}

	public GuardiaGrupoServiceInterfase getGuardiaGrupoService() {
		return guardiaGrupoService;
	}

	public void setGuardiaGrupoService(GuardiaGrupoServiceInterfase guardiaGrupoService) {
		this.guardiaGrupoService = guardiaGrupoService;
	}

	public HorarioGrupoServiceInterfase getHorarioGrupoService() {
		return horarioGrupoService;
	}

	public void setHorarioGrupoService(HorarioGrupoServiceInterfase horarioGrupoService) {
		this.horarioGrupoService = horarioGrupoService;
	}

	public FrecuenciaServiceInterfase getFrecuenciaService() {
		return frecuenciaService;
	}

	public void setFrecuenciaService(FrecuenciaServiceInterfase frecuenciaService) {
		this.frecuenciaService = frecuenciaService;
	}

	public HorariosServiceInterfase getHorariosService() {
		return horariosService;
	}

	public void setHorariosService(HorariosServiceInterfase horariosService) {
		this.horariosService = horariosService;
	}

	public GeocercaByEstadoServiceInterfase getGeocercaByEstadoService() {
		return geocercaByEstadoService;
	}

	public void setGeocercaByEstadoService(GeocercaByEstadoServiceInterfase geocercaByEstadoService) {
		this.geocercaByEstadoService = geocercaByEstadoService;
	}

	public GeocercaServiceInterfase getGeocercaService() {
		return geocercaService;
	}

	public void setGeocercaService(GeocercaServiceInterfase geocercaService) {
		this.geocercaService = geocercaService;
	}

	public GeocercaPuntoServiceInterfase getGeocercaPuntoService() {
		return geocercaPuntoService;
	}

	public void setGeocercaPuntoService(GeocercaPuntoServiceInterfase geocercaPuntoService) {
		this.geocercaPuntoService = geocercaPuntoService;
	}

	public HistoricoTerminalServiceInterfase getHistoricoTerminalService() {
		return historicoTerminalService;
	}

	public void setHistoricoTerminalService(HistoricoTerminalServiceInterfase historicoTerminalService) {
		this.historicoTerminalService = historicoTerminalService;
	}

	public MensajeSmsServiceInterfase getMensajeSmsService() {
		return mensajeSmsService;
	}

	public void setMensajeSmsService(MensajeSmsServiceInterfase mensajeSmsService) {
		this.mensajeSmsService = mensajeSmsService;
	}

	public ModuloServiceInterfase getModuloService() {
		return moduloService;
	}

	public void setModuloService(ModuloServiceInterfase moduloService) {
		this.moduloService = moduloService;
	}

	public ModuloPadreServiceInterfase getModuloPadreService() {
		return moduloPadreService;
	}

	public void setModuloPadreService(ModuloPadreServiceInterfase moduloPadreService) {
		this.moduloPadreService = moduloPadreService;
	}

	public MunicipioServiceInterfase getMunicipioService() {
		return municipioService;
	}

	public void setMunicipioService(MunicipioServiceInterfase municipioService) {
		this.municipioService = municipioService;
	}

	public PerfilServiceInterfase getPerfilService() {
		return perfilService;
	}

	public void setPerfilService(PerfilServiceInterfase perfilService) {
		this.perfilService = perfilService;
	}

	public GrupoServiceInterfase getGrupoService() {
		return grupoService;
	}

	public void setGrupoService(GrupoServiceInterfase grupoService) {
		this.grupoService = grupoService;
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

	public ReporteMovilSacServiceInterfase getReporteMovilSacService() {
		return reporteMovilSacService;
	}

	public void setReporteMovilSacService(ReporteMovilSacServiceInterfase reporteMovilSacService) {
		this.reporteMovilSacService = reporteMovilSacService;
	}

	public ReporteMovilSacTercerosServiceInterfase getReporteMovilSacTercerosService() {
		return ReporteMovilSacTercerosService;
	}

	public void setReporteMovilSacTercerosService(ReporteMovilSacTercerosServiceInterfase reporteMovilSacTercerosService) {
		ReporteMovilSacTercerosService = reporteMovilSacTercerosService;
	}

	public ReporteMovilSacTalleresServiceInterfase getReporteMovilSacTalleresService() {
		return reporteMovilSacTalleresService;
	}

	public void setReporteMovilSacTalleresService(ReporteMovilSacTalleresServiceInterfase reporteMovilSacTalleresService) {
		this.reporteMovilSacTalleresService = reporteMovilSacTalleresService;
	}

	public ReporteMovilSacGruasServiceInterfase getReporteMovilSacGruasService() {
		return reporteMovilSacGruasService;
	}

	public void setReporteMovilSacGruasService(ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasService) {
		this.reporteMovilSacGruasService = reporteMovilSacGruasService;
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

	public TerminalAlertaLogServiceInterfase getTerminalAlertaLogService() {
		return terminalAlertaLogService;
	}

	public void setTerminalAlertaLogService(TerminalAlertaLogServiceInterfase terminalAlertaLogService) {
		this.terminalAlertaLogService = terminalAlertaLogService;
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

	public OrdenPaseAmbulanciaServiceInterfase getOrdenPaseAmbulanciaService() {
		return ordenPaseAmbulanciaService;
	}

	public void setOrdenPaseAmbulanciaService(OrdenPaseAmbulanciaServiceInterfase ordenPaseAmbulanciaService) {
		this.ordenPaseAmbulanciaService = ordenPaseAmbulanciaService;
	}

	public OrdenPaseAdmisionServiceInterfase getOrdenPaseAdmisionService() {
		return ordenPaseAdmisionService;
	}

	public void setOrdenPaseAdmisionService(OrdenPaseAdmisionServiceInterfase ordenPaseAdmisionService) {
		this.ordenPaseAdmisionService = ordenPaseAdmisionService;
	}

	public OrdenPaseEquipoPesadoServiceInterfase getOrdenPaseEquipoPesadoService() {
		return ordenPaseEquipoPesadoService;
	}

	public void setOrdenPaseEquipoPesadoService(OrdenPaseEquipoPesadoServiceInterfase ordenPaseEquipoPesadoService) {
		this.ordenPaseEquipoPesadoService = ordenPaseEquipoPesadoService;
	}

	public OrdenPaseMedicoServiceInterfase getOrdenPaseMedicoService() {
		return ordenPaseMedicoService;
	}

	public void setOrdenPaseMedicoService(OrdenPaseMedicoServiceInterfase ordenPaseMedicoService) {
		this.ordenPaseMedicoService = ordenPaseMedicoService;
	}

	public OrdenPaseReclamacionServiceInterfase getOrdenPaseReclamacionService() {
		return ordenPaseReclamacionService;
	}

	public void setOrdenPaseReclamacionService(OrdenPaseReclamacionServiceInterfase ordenPaseReclamacionService) {
		this.ordenPaseReclamacionService = ordenPaseReclamacionService;
	}

	public TerminalComentarioServiceInterfase getTerminalComentarioService() {
		return terminalComentarioService;
	}

	public void setTerminalComentarioService(TerminalComentarioServiceInterfase terminalComentarioService) {
		this.terminalComentarioService = terminalComentarioService;
	}

	public CatalogoVehiculoAjusServiceInterfase getCatalogoVehiculoAjusService() {
		return catalogoVehiculoAjusService;
	}

	public void setCatalogoVehiculoAjusService(CatalogoVehiculoAjusServiceInterfase catalogoVehiculoAjusService) {
		this.catalogoVehiculoAjusService = catalogoVehiculoAjusService;
	}

	public CatalogoMovilServiceInterfase getCatalogoMovilService() {
		return catalogoMovilService;
	}

	public void setCatalogoMovilService(CatalogoMovilServiceInterfase catalogoMovilService) {
		this.catalogoMovilService = catalogoMovilService;
	}

	public UsuarioAlertasServiceInterfase getUsuarioAlertasService() {
		return usuarioAlertasService;
	}

	public void setUsuarioAlertasService(UsuarioAlertasServiceInterfase usuarioAlertasService) {
		this.usuarioAlertasService = usuarioAlertasService;
	}

	public HistoricoResumenAjustadorServiceInterfase getHistoricoResumenAjustadorService() {
		return historicoResumenAjustadorService;
	}

	public void setHistoricoResumenAjustadorService(
			HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorService) {
		this.historicoResumenAjustadorService = historicoResumenAjustadorService;
	}

	public CatalogoRecuperacionesServiceInterfase getCatalogoRecuperacionesService() {
		return catalogoRecuperacionesService;
	}

	public void setCatalogoRecuperacionesService(CatalogoRecuperacionesServiceInterfase catalogoRecuperacionesService) {
		this.catalogoRecuperacionesService = catalogoRecuperacionesService;
	}

	public CatalogoCoberturasServiceInterfase getCatalogoCoberturasService() {
		return catalogoCoberturasService;
	}

	public void setCatalogoCoberturasService(CatalogoCoberturasServiceInterfase catalogoCoberturasService) {
		this.catalogoCoberturasService = catalogoCoberturasService;
	}

	public CatalogoCodigoResponsabilidadServiceInterfase getCatalogoCodigoResponsabilidadService() {
		return catalogoCodigoResponsabilidadService;
	}

	public void setCatalogoCodigoResponsabilidadService(
			CatalogoCodigoResponsabilidadServiceInterfase catalogoCodigoResponsabilidadService) {
		this.catalogoCodigoResponsabilidadService = catalogoCodigoResponsabilidadService;
	}

	public EntidadAbogadoCrmServiceInterfase getEntidadAbogadoCrmService() {
		return entidadAbogadoCrmService;
	}

	public void setEntidadAbogadoCrmService(EntidadAbogadoCrmServiceInterfase entidadAbogadoCrmService) {
		this.entidadAbogadoCrmService = entidadAbogadoCrmService;
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

	public FormatoGarantiaPrendariaServiceInterfase getFormatoGarantiaPrendariaService() {
		return formatoGarantiaPrendariaService;
	}

	public void setFormatoGarantiaPrendariaService(
			FormatoGarantiaPrendariaServiceInterfase formatoGarantiaPrendariaService) {
		this.formatoGarantiaPrendariaService = formatoGarantiaPrendariaService;
	}

	public FormatoDeclaracionUniversalServiceInterfase getFormatoDeclaracionUniversalService() {
		return formatoDeclaracionUniversalService;
	}

	public void setFormatoDeclaracionUniversalService(
			FormatoDeclaracionUniversalServiceInterfase formatoDeclaracionUniversalService) {
		this.formatoDeclaracionUniversalService = formatoDeclaracionUniversalService;
	}

	public FormatoInventarioAutomovilesServiceInterfase getFormatoInventarioAutomovilesService() {
		return formatoInventarioAutomovilesService;
	}

	public void setFormatoInventarioAutomovilesService(
			FormatoInventarioAutomovilesServiceInterfase formatoInventarioAutomovilesService) {
		this.formatoInventarioAutomovilesService = formatoInventarioAutomovilesService;
	}

	public FormatoCuestionarioRoboServiceInterfase getFormatoCuestionarioRoboService() {
		return formatoCuestionarioRoboService;
	}

	public void setFormatoCuestionarioRoboService(FormatoCuestionarioRoboServiceInterfase formatoCuestionarioRoboService) {
		this.formatoCuestionarioRoboService = formatoCuestionarioRoboService;
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

	public FormatoAdmisionPesadoServiceInterfase getFormatoAdmisionPesadoService() {
		return formatoAdmisionPesadoService;
	}

	public void setFormatoAdmisionPesadoService(FormatoAdmisionPesadoServiceInterfase formatoAdmisionPesadoService) {
		this.formatoAdmisionPesadoService = formatoAdmisionPesadoService;
	}

	public FormatoInspeccionMotoServiceInterfase getFormatoInspeccionMotoService() {
		return formatoInspeccionMotoService;
	}

	public void setFormatoInspeccionMotoService(FormatoInspeccionMotoServiceInterfase formatoInspeccionMotoService) {
		this.formatoInspeccionMotoService = formatoInspeccionMotoService;
	}

	public FormatoInspeccionPesadoServiceInterfase getFormatoInspeccionPesadoService() {
		return formatoInspeccionPesadoService;
	}

	public void setFormatoInspeccionPesadoService(FormatoInspeccionPesadoServiceInterfase formatoInspeccionPesadoService) {
		this.formatoInspeccionPesadoService = formatoInspeccionPesadoService;
	}

	public FormatoCatalogosServiceInterfase getFormatoCatalogosService() {
		return formatoCatalogosService;
	}

	public void setFormatoCatalogosService(FormatoCatalogosServiceInterfase formatoCatalogosService) {
		this.formatoCatalogosService = formatoCatalogosService;
	}

	public LogFormatosAjustadorErrorServiceInterfase getLogFormatosAjustadorErrorService() {
		return logFormatosAjustadorErrorService;
	}

	public void setLogFormatosAjustadorErrorService(
			LogFormatosAjustadorErrorServiceInterfase logFormatosAjustadorErrorService) {
		this.logFormatosAjustadorErrorService = logFormatosAjustadorErrorService;
	}

	public CorreoPolizaAgenteServiceInterfase getCorreoPolizaAgenteService() {
		return correoPolizaAgenteService;
	}

	public void setCorreoPolizaAgenteService(CorreoPolizaAgenteServiceInterfase correoPolizaAgenteService) {
		this.correoPolizaAgenteService = correoPolizaAgenteService;
	}

	public InfoReconocimientoServiceInterface getInfoReconocimientoService() {
		return infoReconocimientoService;
	}

	public void setInfoReconocimientoService(InfoReconocimientoServiceInterface infoReconocimientoService) {
		this.infoReconocimientoService = infoReconocimientoService;
	}

	public FormatoReciboIngresoSiniestroServiceInterfase getFormatoReciboIngresoSiniestroService() {
		return formatoReciboIngresoSiniestroService;
	}

	public void setFormatoReciboIngresoSiniestroService(
			FormatoReciboIngresoSiniestroServiceInterfase formatoReciboIngresoSiniestroService) {
		this.formatoReciboIngresoSiniestroService = formatoReciboIngresoSiniestroService;
	}

	public FormatoReciboPagoDeducibleServiceInterfase getFormatoReciboPagoDeducibleService() {
		return formatoReciboPagoDeducibleService;
	}

	public void setFormatoReciboPagoDeducibleService(
			FormatoReciboPagoDeducibleServiceInterfase formatoReciboPagoDeducibleService) {
		this.formatoReciboPagoDeducibleService = formatoReciboPagoDeducibleService;
	}

	public FormatoSolicitudDiagnosticoServiceInterfase getFormatoSolicitudDiagnosticoService() {
		return formatoSolicitudDiagnosticoService;
	}

	public void setFormatoSolicitudDiagnosticoService(
			FormatoSolicitudDiagnosticoServiceInterfase formatoSolicitudDiagnosticoService) {
		this.formatoSolicitudDiagnosticoService = formatoSolicitudDiagnosticoService;
	}

	public FormatoMemoriaDescriptivaServiceInterfase getFormatoMemoriaDescriptivaService() {
		return formatoMemoriaDescriptivaService;
	}

	public void setFormatoMemoriaDescriptivaService(
			FormatoMemoriaDescriptivaServiceInterfase formatoMemoriaDescriptivaService) {
		this.formatoMemoriaDescriptivaService = formatoMemoriaDescriptivaService;
	}

	public FormatoCargoTarjetaCreditoServiceInterfase getFormatoCargoTarjetaCreditoService() {
		return formatoCargoTarjetaCreditoService;
	}

	public void setFormatoCargoTarjetaCreditoService(
			FormatoCargoTarjetaCreditoServiceInterfase formatoCargoTarjetaCreditoService) {
		this.formatoCargoTarjetaCreditoService = formatoCargoTarjetaCreditoService;
	}

	public FormatoResponsabilidadCivilServiceInterfase getFormatoResponsabilidadCivilService() {
		return formatoResponsabilidadCivilService;
	}

	public void setFormatoResponsabilidadCivilService(
			FormatoResponsabilidadCivilServiceInterfase formatoResponsabilidadCivilService) {
		this.formatoResponsabilidadCivilService = formatoResponsabilidadCivilService;
	}

	public FormatoReparacionBienesDiversosServiceInterfase getFormatoReparacionBienesDiversosService() {
		return formatoReparacionBienesDiversosService;
	}

	public void setFormatoReparacionBienesDiversosService(
			FormatoReparacionBienesDiversosServiceInterfase formatoReparacionBienesDiversosService) {
		this.formatoReparacionBienesDiversosService = formatoReparacionBienesDiversosService;
	}

	public ExpedienteEjecutivoServiceInterfase getExpedienteEjecutivoService() {
		return expedienteEjecutivoService;
	}

	public void setExpedienteEjecutivoService(ExpedienteEjecutivoServiceInterfase expedienteEjecutivoService) {
		this.expedienteEjecutivoService = expedienteEjecutivoService;
	}

	public FormatoObservacionesAseguradoServiceInterfase getFormatoObservacionesAseguradoService() {
		return formatoObservacionesAseguradoService;
	}

	public void setFormatoObservacionesAseguradoService(
			FormatoObservacionesAseguradoServiceInterfase formatoObservacionesAseguradoService) {
		this.formatoObservacionesAseguradoService = formatoObservacionesAseguradoService;
	}

	public NotasReporteServiceInterfase getNotasReporteService() {
		return notasReporteService;
	}

	public void setNotasReporteService(NotasReporteServiceInterfase notasReporteService) {
		this.notasReporteService = notasReporteService;
	}

	public FormatoInventarioUnicoPesadoServiceInterfase getFormatoInventarioUnicoPesadoService() {
		return formatoInventarioUnicoPesadoService;
	}

	public void setFormatoInventarioUnicoPesadoService(
			FormatoInventarioUnicoPesadoServiceInterfase formatoInventarioUnicoPesadoService) {
		this.formatoInventarioUnicoPesadoService = formatoInventarioUnicoPesadoService;
	}

	public FormatoReclamacionComprobantePeajeServiceInterfase getFormatoReclamacionComprobantePeajeService() {
		return formatoReclamacionComprobantePeajeService;
	}

	public void setFormatoReclamacionComprobantePeajeService(
			FormatoReclamacionComprobantePeajeServiceInterfase formatoReclamacionComprobantePeajeService) {
		this.formatoReclamacionComprobantePeajeService = formatoReclamacionComprobantePeajeService;
	}

	public CodigoResponsabilidadEstadServiceInterfase getCodigoResponsabilidadEstadService() {
		return codigoResponsabilidadEstadService;
	}

	public void setCodigoResponsabilidadEstadService(
			CodigoResponsabilidadEstadServiceInterfase codigoResponsabilidadEstadService) {
		this.codigoResponsabilidadEstadService = codigoResponsabilidadEstadService;
	}

	public ControlFotografiasServiceInterfase getControlFotografiasService() {
		return controlFotografiasService;
	}

	public void setControlFotografiasService(ControlFotografiasServiceInterfase controlFotografiasService) {
		this.controlFotografiasService = controlFotografiasService;
	}

	public MetricaEDServiceInterfase getMetricaEDService() {
		return metricaEDService;
	}

	public void setMetricaEDService(MetricaEDServiceInterfase metricaEDService) {
		this.metricaEDService = metricaEDService;
	}

	public HistoricoRecuperosAjustadorServiceInterfase getHistoricoRecuperosAjustadorService() {
		return historicoRecuperosAjustadorService;
	}

	public void setHistoricoRecuperosAjustadorService(
			HistoricoRecuperosAjustadorServiceInterfase historicoRecuperosAjustadorService) {
		this.historicoRecuperosAjustadorService = historicoRecuperosAjustadorService;
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

	
	
}
