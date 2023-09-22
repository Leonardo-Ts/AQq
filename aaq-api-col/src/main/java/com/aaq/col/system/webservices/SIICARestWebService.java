package com.aaq.col.system.webservices;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.ws.rs.core.Context;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.Municipio;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.aaq.col.clases.database.entidades.Siniestro;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.BaseServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.EstadoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.GeocercaServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.MunicipioServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.PuntoInteresServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.PuntoInteresTipoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SiniestroServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;
import com.aaq.col.clases.webservices.json.Icono;
import com.aaq.col.clases.webservices.json.ListaAjustador;
import com.aaq.col.clases.webservices.json.ListaBase;
import com.aaq.col.clases.webservices.json.ListaEstado;
import com.aaq.col.clases.webservices.json.ListaGeocerca;
import com.aaq.col.clases.webservices.json.ListaIcono;
import com.aaq.col.clases.webservices.json.ListaMunicipio;
import com.aaq.col.clases.webservices.json.ListaPuntoInteres;
import com.aaq.col.clases.webservices.json.Reporte;
import com.aaq.col.clases.webservices.json.ResultadoOperacion;

public class SIICARestWebService implements SIICARestWebServiceInterfase {
	@Context
	private org.apache.cxf.jaxrs.ext.MessageContext mc;

	@Autowired
	private BaseServiceInterfase baseDao;

	@Autowired
	private EstadoServiceInterfase estadoDao;

	@Autowired
	private GeocercaServiceInterfase geocercaDao;

	@Autowired
	private MunicipioServiceInterfase municipioDao;

	@Autowired
	private PuntoInteresServiceInterfase puntoInteresDao;

	@Autowired
	private PuntoInteresTipoServiceInterfase puntoInteresTipoDao;

	@Autowired
	private SiniestroServiceInterfase siniestroDao;

	@Autowired
	private TerminalServiceInterfase terminalDao;

	private final String fuenteWS = "SIICA Servicios Web -> SIICA Rest Web Service -> ";

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);

	/**
	 * Constructor
	 */
	public SIICARestWebService() {
		super();

	}

	@Override
	public ListaEstado listaEstado() {
		List<Estado> listaEstado = null;

		try {
			listaEstado = this.estadoDao.listaDeEstado();
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaEstado => listaDeEstado");
		}

		if ((listaEstado == null) || (listaEstado.size() == 0)) {
			return new ListaEstado("ERROR: Lista de Estados vacia", null);
		}

		final com.aaq.col.clases.webservices.json.Estado[] l = new com.aaq.col.clases.webservices.json.Estado[listaEstado
				.size()];
		int i = 0;
		for (final Estado estado : listaEstado) {
			l[i++] = new com.aaq.col.clases.webservices.json.Estado(Objects.toString(estado.getId(),
					""), estado.getNombre());
		}
		return new ListaEstado("OK", l);

	}

	@Override
	public ListaBase listaBase(final String idEstado) {
		if (StringUtils.isBlank(idEstado)) {
			return new ListaBase("ERROR: Clave de estado nula", null);
		}

		Estado estado = null;
		try {
			estado = this.estadoDao.objetoEstado(idEstado);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaBase => ObjetoEstado");
		}

		if (estado == null) {
			return new ListaBase("ERROR: Clave de estado invalida", null);

		}

		List<Base> lista = null;
		try {
			lista = this.baseDao.listaDeBase(estado);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaBase => ListaDeBase");
		}

		if ((lista == null) || (lista.size() == 0)) {
			return new ListaBase("ERROR: El estado no contiene bases", null);
		}

		final com.aaq.col.clases.webservices.json.Base[] l = new com.aaq.col.clases.webservices.json.Base[lista
				.size()];
		int i = 0;
		for (final Base base : lista) {
			l[i++] = new com.aaq.col.clases.webservices.json.Base(Objects.toString(base.getId(), ""),
					base.getNombre());
		}
		return new ListaBase("OK", l);

	}

	@Override
	public ListaMunicipio listaMunicipio(final String idEstado) {
		if (StringUtils.isBlank(idEstado)) {
			return new ListaMunicipio("ERROR: Clave de estado nula", null);
		}

		Estado estado = null;
		try {
			estado = this.estadoDao.objetoEstado(idEstado);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaMunicipio => ObjetoEstado");
		}

		if (estado == null) {
			return new ListaMunicipio("ERROR: Clave de estado invalida", null);

		}

		List<Municipio> lista = null;
		try {
			lista = this.municipioDao.listaDeMunicipios(estado);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaMunicipio => ListaDeMunicipios");
		}

		if ((lista == null) || (lista.size() == 0)) {
			return new ListaMunicipio("ERROR: El estado no contiene municipios", null);
		}

		final com.aaq.col.clases.webservices.json.Municipio[] l = new com.aaq.col.clases.webservices.json.Municipio[lista
				.size()];
		int i = 0;
		for (final Municipio municipio : lista) {
			l[i++] = new com.aaq.col.clases.webservices.json.Municipio(municipio.getNombre(),
					municipio.getClaveEntidad());
		}
		return new ListaMunicipio("OK", l);

	}

	@Override
	public ListaAjustador ajustador(final String clave) {
		if (StringUtils.isBlank(clave)) {
			return new ListaAjustador("ERROR: El parametro clave ajustador es nulo", null);
		}

		Terminal t = null;
		try {
			t = this.terminalDao.objetoTerminal(clave);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "Ajustador => ObjetoTerminal");
		}

		if (t == null) {
			try {
				t = this.terminalDao.objetoTerminalParaNumeroProveedor(null, clave);
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"Ajustador => objetoTerminalParaNumeroProveedor");
			}
		}

		if (t == null) {
			return new ListaAjustador("ERROR:  Clave Ajustador No Encontrada", null);
		}
		final com.aaq.col.clases.webservices.json.Ajustador[] l = new com.aaq.col.clases.webservices.json.Ajustador[1];

		final com.aaq.col.clases.webservices.json.Ajustador ajustador = new com.aaq.col.clases.webservices.json.Ajustador();
		ajustador.setId(Objects.toString(t.getId(), ""));
		ajustador.setEstado(Objects.toString(t.getEstado(), ""));
		ajustador.setBase(Objects.toString(t.getBase(), ""));
		ajustador.setNombre(t.getNombre());
		ajustador.setNumeroRadio(t.getNumeroradio());
		ajustador.setNumeroProveedor(t.getNumeroproveedor());
		ajustador.setNumeroTelefono(t.getTelefono());
		ajustador.setEstatus(t.getEstatusMapa());
		ajustador.setLatitud(t.getLatitud());
		ajustador.setLongitud(t.getLongitud());
		ajustador.setMoto(t.getMoto());
		ajustador
				.setFechaLocalizacion(JMUtileriaString.quitarNoXML(Objects.toString(t.getUltimoLocalizacionFecha(), "")));
		if (t.getReporteSise() != null) {
			ajustador.setReporteAtiendiendoNumero(t.getReporteSise().getGeneralNumeroReporte());
			ajustador.setReporteAtiendiendoPlacasSerie(t.getReporteSise().getVehiculoPlacas() + ","
					+ t.getReporteSise().getVehiculoSerie());
		}
		ajustador.setDireccion(t.getUltimoLocalizacionDireccion());
		ajustador.setReporteEsteDia(t.getContadorReportesEsteDia());
		
		ajustador.setUnidadPlacas(t.getUnidadPlacas());
		
		if (t.getCatalogoVehiculoAjus() != null) {
			ajustador.setUnidadMarcaAjust(t.getCatalogoVehiculoAjus().getMarca() +" "+t.getCatalogoVehiculoAjus().getTipo());
		}

		l[0] = ajustador;

		return new ListaAjustador("OK", l);
	}

	@Override
	public ListaAjustador listaAjustador(final String idEstado, final String idBase) {
		if (StringUtils.isBlank(idEstado) && StringUtils.isBlank(idBase)) {
			return new ListaAjustador("ERROR: El parametro de estado y base son nulos", null);
		}

		Estado est = null;
		Base base = null;
		try {
			est = this.estadoDao.objetoEstado(idEstado);
			base = this.baseDao.objetoBase(idBase);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaAjustador => ObjetoEstado, ObjetoBase");

		}

		if ((base == null) && (est == null)) {
			return new ListaAjustador("ERROR: El parametro de estado y base no encontrados en la base de datos", null);
		}

		List<Terminal> lista = null;
		try {
			lista = this.terminalDao.listaDeTerminal(est, base);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaAjustador => listaDeTerminal");
		}
		if ((lista == null) || (lista.size() == 0)) {
			return new ListaAjustador("ERROR: No se encontraron ajustadores para estos parametross", null);

		}

		final com.aaq.col.clases.webservices.json.Ajustador[] l = new com.aaq.col.clases.webservices.json.Ajustador[lista
				.size()];
		int i = 0;
		for (final Terminal t : lista) {
			final com.aaq.col.clases.webservices.json.Ajustador ajustador = new com.aaq.col.clases.webservices.json.Ajustador();
			ajustador.setId(Objects.toString(t.getId(), ""));
			ajustador.setEstado(Objects.toString(t.getEstado(), ""));
			ajustador.setBase(Objects.toString(t.getBase(), ""));
			ajustador.setNombre(t.getNombre());
			ajustador.setNumeroRadio(t.getNumeroradio());
			ajustador.setNumeroProveedor(t.getNumeroproveedor());
			ajustador.setNumeroTelefono(t.getTelefono());
			ajustador.setEstatus(t.getEstatusMapa());
			ajustador.setLatitud(t.getLatitud());
			ajustador.setLongitud(t.getLongitud());
			ajustador.setMoto(t.getMoto());
			ajustador.setFechaLocalizacion(JMUtileriaString.quitarNoXML(Objects.toString(
					t.getUltimoLocalizacionFecha(), "")));
			if (t.getReporteSise() != null) {
				ajustador.setReporteAtiendiendoNumero(t.getReporteSise().getGeneralNumeroReporte());
				ajustador.setReporteAtiendiendoPlacasSerie(t.getReporteSise().getVehiculoPlacas() + ","
						+ t.getReporteSise().getVehiculoSerie());
			}
			ajustador.setDireccion(t.getUltimoLocalizacionDireccion());
			ajustador.setReporteEsteDia(t.getContadorReportesEsteDia());
			ajustador.setAv(t.getAsistenciaVial());
			ajustador.setTipoAv(t.getTipoAsistenciaVial());
			ajustador.setTiempoDeAtencion(t.getTiempoDeAtencion());

			l[i++] = ajustador;

		}
		return new ListaAjustador("OK", l);

	}

	@Override
	public ListaIcono listaIcono() {
		final String url = this.mc.getHttpServletRequest().getScheme() + "://"
				+ this.mc.getHttpServletRequest().getServerName() + ":"
				+ this.mc.getHttpServletRequest().getServerPort() + this.mc.getHttpServletRequest().getContextPath()
				+ "/diseno/imagenes/mapa/iconos/";

		List<PuntoInteresTipo> lista = null;
		try {
			lista = this.puntoInteresTipoDao.listaDePuntoInteresTipo();
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaIcono => listaDePuntoInteresTipo");
		}

		if ((lista == null) || (lista.size() == 0)) {
			return new ListaIcono("ERROR: Lista de iconos vacia", null);

		}

		final com.aaq.col.clases.webservices.json.Icono[] l = new com.aaq.col.clases.webservices.json.Icono[lista
				.size()];
		int i = 0;
		for (final PuntoInteresTipo p : lista) {
			l[i++] = new Icono(p.getNombre(), p.getDescripcion(), url + p.getIcono());
		}
		return new ListaIcono("OK", l);

	}

	@Override
	public ListaPuntoInteres listaPuntoInteres(final String idEstado) {

		if (StringUtils.isBlank(idEstado)) {
			return new ListaPuntoInteres("ERROR: Clave de estado nula", null);
		}

		Estado estado = null;
		try {
			estado = this.estadoDao.objetoEstado(idEstado);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "ListaPuntoInteres => objetoEstado");
		}

		if (estado == null) {
			return new ListaPuntoInteres("ERROR: Clave de estado invalida", null);

		}

		List<PuntoInteres> lista = null;
		try {
			lista = this.puntoInteresDao.listaDePuntoInteres(estado, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "ListaPuntoInteres => ListaDePuntoInteres");
		}

		if ((lista == null) || (lista.size() == 0)) {
			return new ListaPuntoInteres("ERROR: El estado no contiene puntos de interes", null);
		}

		final com.aaq.col.clases.webservices.json.PuntoInteres[] l = new com.aaq.col.clases.webservices.json.PuntoInteres[lista
				.size()];
		int i = 0;
		for (final PuntoInteres p : lista) {
			l[i++] = new com.aaq.col.clases.webservices.json.PuntoInteres(Objects.toString(
					p.getEstado(), ""), p.getLongitud(), p.getLatitud(), Objects.toString(p.getPuntoInteresTipo(), ""),
					p.getNombre(), p.getDescripcion());
		}
		return new ListaPuntoInteres("OK", l);

	}

	@Override
	public ListaGeocerca listaGeocerca(final String idEstado) {
		if (StringUtils.isBlank(idEstado)) {

			return new ListaGeocerca("ERROR: Clave de estado nula", null);
		}

		Estado estado = null;
		try {
			estado = this.estadoDao.objetoEstado(idEstado);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaGeocerca => objetoEstado");
		}

		if (estado == null) {
			return new ListaGeocerca("ERROR: Clave de estado invalida", null);

		}

		List<Geocerca> lista = null;
		try {
			lista = this.geocercaDao.listaDeGeocerca(estado);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "listaGeocerca => listaDeGeocerca");
		}

		if ((lista == null) || (lista.size() == 0)) {
			return new ListaGeocerca("ERROR: El estado no contiene geocercas", null);
		}

		final com.aaq.col.clases.webservices.json.Geocerca[] l = new com.aaq.col.clases.webservices.json.Geocerca[lista
				.size()];
		int i = 0;
		for (final Geocerca g : lista) {
			l[i++] = new com.aaq.col.clases.webservices.json.Geocerca(Objects.toString(g.getEstado(),
					""), g.getNombre(), g.getDescripcion(), g.getColor(), g.toArreglo());
		}
		return new ListaGeocerca("OK", l);

	}

	@Override
	public ResultadoOperacion insertaReporte(final Reporte reporte) {
		if (reporte == null) {
			return new ResultadoOperacion("ERROR: El reporte es nulo");
		}
		if (StringUtils.isBlank(reporte.getIdentificadorUnico())) {
			return new ResultadoOperacion("ERROR: El identificador unico es nulo");
		}


		Siniestro s = null;
		try {
			s = this.siniestroDao.objetoSiniestro(null, reporte.getIdentificadorUnico());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "insertaReporte => objetoSiniestro");

		}

		if (s == null) {
			s = new Siniestro();
			s.setFecha(new Date());
			s.setIdentificadorUnico(reporte.getIdentificadorUnico());
		}

		if (StringUtils.isNotBlank(reporte.getIdEstado())
				&& !StringUtils.containsIgnoreCase(reporte.getIdEstado(), "null")) {

			try {
				final Estado est = this.estadoDao.objetoEstado(reporte.getIdEstado());
				s.setEstado(est);
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "insertaReporte => objetoEstado");
			}

		}

		if (StringUtils.isNotBlank(reporte.getIdAjustador())
				&& !StringUtils.containsIgnoreCase(reporte.getIdAjustador(), "null")) {

			try {
				s.setTerminal(this.terminalDao.objetoTerminal(reporte.getIdAjustador()));
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "insertaReporte => objetoTerminal");
			}

			try {
				this.terminalDao.ejecutarFuncionTerminalAsignarProximidad(
						new Integer(NumberUtils.toInt(reporte.getIdAjustador())), JMConstantes.SOCKET_FUENTE_MAP_DATA,
						this.fuenteWS + "insertaReporte");
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"insertaReporte => ejecutarFuncionTerminalAsignarProximidad");

			}

		}

		if (StringUtils.isNotBlank(reporte.getLongitud())
				&& !StringUtils.containsIgnoreCase(reporte.getLongitud(), "null")) {
			s.setLatitud(reporte.getLongitud());

		}
		if (StringUtils.isNotBlank(reporte.getLatitud())
				&& !StringUtils.containsIgnoreCase(reporte.getLatitud(), "null")) {
			s.setLongitud(reporte.getLatitud());
		}

		s.setNumeroReporte(reporte.getNumeroReporte() != null ? reporte.getNumeroReporte() : "");

		if (BooleanUtils.isTrue(reporte.getCerrarLocalizacion())) {
			s.setCerrarLocalizacion(reporte.getCerrarLocalizacion());

		}
		if (BooleanUtils.isTrue(reporte.getCerrarAsignacion())) {
			s.setCerrarAsignacion(reporte.getCerrarAsignacion());

		}

		if (StringUtils.isNotBlank(reporte.getClaveDeEntidad())) {
			s.setClaveDeEntidad(reporte.getClaveDeEntidad());
		}
		if (StringUtils.isNotBlank(reporte.getUbCarreteraKilometro())) {
			s.setUbicacionCarreteraKilometro(reporte.getUbCarreteraKilometro());
		}
		if (StringUtils.isNotBlank(reporte.getUbCarreteraNombre())) {
			s.setUbicacionCarreteraNombre(reporte.getUbCarreteraNombre());
		}

		if (StringUtils.isNotBlank(reporte.getUbCalle())) {
			s.setUbicacionCalle(reporte.getUbCalle());
		}
		if (StringUtils.isNotBlank(reporte.getUbEntreCalle())) {
			s.setUbicacionEntreCalle(reporte.getUbEntreCalle());
		}
		if (StringUtils.isNotBlank(reporte.getUbEsquina())) {
			s.setUbicacionEsquina(reporte.getUbEsquina());
		}
		if (StringUtils.isNotBlank(reporte.getUbNumeroExterior())) {
			s.setUbicacionNumero(reporte.getUbNumeroExterior());
		}
		if (StringUtils.isNotBlank(reporte.getUbColonia())) {
			s.setUbicacionColonia(reporte.getUbColonia());
		}
		if (StringUtils.isNotBlank(reporte.getUbReferencia())) {
			s.setUbicacionReferencia(reporte.getUbReferencia());
		}
		if (StringUtils.isNotBlank(reporte.getUbMunicipio())) {
			s.setUbicacionMunicipio(reporte.getUbMunicipio());
		}
		if (StringUtils.isNotBlank(reporte.getUbEstado())) {
			s.setUbicacionEstado(reporte.getUbEstado());
		}
		if (StringUtils.isNotBlank(reporte.getUbPais())) {
			s.setUbicacionPais(reporte.getUbPais());
		}
		if (StringUtils.isNotBlank(reporte.getUbCodigoPostal())) {
			s.setUbicacionCodigoPostal(reporte.getUbCodigoPostal());
		}
		if (StringUtils.isNotBlank(reporte.getIdMunSepomex())) {
			s.setIdMunSepomex(reporte.getIdMunSepomex());
		}
		if (StringUtils.isNotBlank(reporte.getIdEntSepomex())) {
			s.setIdEntSepomex(reporte.getIdEntSepomex());
		}

		final JMResultadoOperacion r = s.guardarObjeto();

		
		if (r != null) {
			if (r.isExito()) {
				return new ResultadoOperacion("OK");
			}
			return new ResultadoOperacion("ERROR: " + r.getMensaje());

		}
		return new ResultadoOperacion("ERROR: ");

	}

	@Override
	public ResultadoOperacion asignaReporte(final String identificadorUnico, final String idAjustador) {
		if (StringUtils.isBlank(identificadorUnico)) {
			return new ResultadoOperacion("ERROR: El identificadorUnico de reporte es nulo");
		}
		if (StringUtils.isBlank(idAjustador)) {
			return new ResultadoOperacion("ERROR: El identificador de ajustador es nulo");
		}

		Siniestro reporte = null;
		try {
			reporte = this.siniestroDao.objetoSiniestro(null, identificadorUnico);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "asignaReporte => objetoSiniestro");
		}

		if (reporte == null) {
			return new ResultadoOperacion("ERROR: El identificador no se encuentra localizado en la base de datos");
		}

		try {
			this.terminalDao.ejecutarFuncionTerminalAsignarProximidad(new Integer(NumberUtils.toInt(idAjustador)),
					JMConstantes.SOCKET_FUENTE_MAP_DATA, this.fuenteWS + "asignaReporte");
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"asignaReporte => ejecutarFuncionTerminalAsignarProximidad");
		}

		Terminal t = null;
		try {
			t = this.terminalDao.objetoTerminal(idAjustador);
			reporte.setTerminal(t);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "asignaReporte => objetoTerminal");
		}

		final JMResultadoOperacion r = reporte.guardarObjeto();

		if (r != null) {
			if (r.isExito()) {
				return new ResultadoOperacion("OK");
			}
			return new ResultadoOperacion("ERROR: " + r.getMensaje());

		}
		return new ResultadoOperacion("ERROR: ");
	}

//	@Override
//	public ListaAjustador listaAjustadorCercano(final String latitud, final String longitud,
//			final boolean soloDisponibles) {
//
//		if (StringUtils.isBlank(latitud) || StringUtils.containsIgnoreCase(latitud, "null")
//				|| StringUtils.containsIgnoreCase(latitud, "undefined") || !NumberUtils.isNumber(latitud)) {
//			return new ListaAjustador("ERROR: Latitud nula", null);
//		}
//
//		if (StringUtils.isBlank(longitud) || StringUtils.containsIgnoreCase(longitud, "null")
//				|| StringUtils.containsIgnoreCase(longitud, "undefined") || !NumberUtils.isNumber(longitud)) {
//			return new ListaAjustador("ERROR: Longitud nula", null);
//		}
//
//		List<Terminal> lista = null;
//		try {
//			lista = this.terminalDao.listaDeTerminalParaCoordenadas(latitud, longitud);
//		} catch (final Exception ex) {
//			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
//					"listaAjustadorCercano => listaDeTerminalParaCoordenadas");
//
//		}
//
//		if ((lista == null) || (lista.size() == 0)) {
//			return new ListaAjustador("ERROR: No se encontraron ajustadores cercanos", null);
//		}
//
//		final com.aaq.col.clases.webservices.json.Ajustador[] l = new com.aaq.col.clases.webservices.json.Ajustador[lista
//				.size()];
//		
//		
//		
//		//-------Gestionador Excepciones  (Menos de 20 Respuesta)-------
//
//		try {
//			for (int i = 0; i < 40; i++) {
//				l[i] = lista.get(i).toAjustador(latitud, longitud);
//			}
//			
//		} catch (final ArrayIndexOutOfBoundsException e) {
//			
//		}
//		
//		//---------------------------------------------------------
////----------Antes--------------
////		for (int i=0;i<10;i++){
////			l[i] = lista.get(i).toAjustador(latitud, longitud);
////		}
//		return new ListaAjustador("OK", l);
//
//	}
	
	@Override
	public ListaAjustador listaAjustadorCercano(final String latitud, final String longitud,
			final boolean soloDisponibles) {

		if (StringUtils.isBlank(latitud) || StringUtils.containsIgnoreCase(latitud, "null")
				|| StringUtils.containsIgnoreCase(latitud, "undefined") || !NumberUtils.isNumber(latitud)) {
			return new ListaAjustador("ERROR: Latitud nula", null);
		}

		if (StringUtils.isBlank(longitud) || StringUtils.containsIgnoreCase(longitud, "null")
				|| StringUtils.containsIgnoreCase(longitud, "undefined") || !NumberUtils.isNumber(longitud)) {
			return new ListaAjustador("ERROR: Longitud nula", null);
		}

		List<Terminal> lista = null;
		try {
			lista = this.terminalDao.listaDeTerminalParaCoordenadas(latitud, longitud, soloDisponibles);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"listaAjustadorCercano => listaDeTerminalParaCoordenadas");

		}

		if ((lista == null) || (lista.size() == 0)) {
			return new ListaAjustador("ERROR: No se encontraron ajustadores cercanos", null);
		}
		
		final com.aaq.col.clases.webservices.json.Ajustador[] l = new com.aaq.col.clases.webservices.json.Ajustador[lista
				.size()];
		
		if(soloDisponibles) {
			try {
				for (int i = 0; i < 10; i++) {
					l[i] = lista.get(i).toAjustador(latitud, longitud);
				}
				
			} catch (final ArrayIndexOutOfBoundsException e) {
			}
		} else {
			try {
				for (int i = 0; i < 20; i++) {
					l[i] = lista.get(i).toAjustador(latitud, longitud);
				}
				
			} catch (final ArrayIndexOutOfBoundsException e) {
			}
		}
		
		//---------------------------------------------------------
//----------Antes--------------
//		for (int i=0;i<10;i++){
//			l[i] = lista.get(i).toAjustador(latitud, longitud);
//		}
		return new ListaAjustador("OK", l);

	}

	@Override
	public Reporte reporte(final String identificadorUnico, final String idReporte) {
		if (StringUtils.isBlank(identificadorUnico) && StringUtils.isBlank(idReporte)) {
			return null;
		}

		Siniestro o = null;
		try {
			o = this.siniestroDao.objetoSiniestro(idReporte, identificadorUnico);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reporte => objetoSiniestro");
		}

		if (o != null) {

			return new Reporte(o.getEstado() != null ? Objects.toString(o.getEstado().getId(), "") : "",
					o.getTerminal() != null ? Objects.toString(o.getTerminal().getId(), "") : "", o.getLongitud(),
					o.getLatitud(), o.getNumeroReporte(), o.getIdentificadorUnico(), o.getClaveDeEntidad(),
					o.getUbicacionCalle(), o.getUbicacionColonia(), o.getUbicacionMunicipio(),
					o.getUbicacionEntreCalle(), o.getUbicacionEsquina(), o.getUbicacionCarreteraNombre(),
					o.getUbicacionCarreteraKilometro(), null, o.getUbicacionNumero(), o.getUbicacionReferencia(),
					o.getUbicacionEstado(), o.getUbicacionPais(), o.getUbicacionCodigoPostal(),
					o.getCerrarLocalizacion(), o.getCerrarAsignacion(), o.getIdMunSepomex(), o.getIdEntSepomex());
		}

		return null;
	}

	@Override
	public ListaAjustador listaAjustadorCalor(String latitud, String longitud) {
		if (StringUtils.isBlank(latitud) || StringUtils.containsIgnoreCase(latitud, "null")
				|| StringUtils.containsIgnoreCase(latitud, "undefined") || !NumberUtils.isNumber(latitud)) {
			return new ListaAjustador("ERROR: Latitud nula", null);
		}

		if (StringUtils.isBlank(longitud) || StringUtils.containsIgnoreCase(longitud, "null")
				|| StringUtils.containsIgnoreCase(longitud, "undefined") || !NumberUtils.isNumber(longitud)) {
			return new ListaAjustador("ERROR: Longitud nula", null);
		}

		List<Terminal> lista = null;
		try {
			lista = this.terminalDao.listaDeTerminalParaCoordenadas(latitud, longitud, false);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"listaAjustadorCalor");

		}

		if ((lista == null) || (lista.size() == 0)) {
			return new ListaAjustador("ERROR: No se encontraron ajustadores cercanos", null);
		}

		final com.aaq.col.clases.webservices.json.Ajustador[] l = new com.aaq.col.clases.webservices.json.Ajustador[lista
				.size()];
		
		
		
		//-------Gestionador Excepciones  (Menos de 20 Respuesta)-------

		try {
			for (int i = 0; i < lista.size(); i++) {
				l[i] = lista.get(i).toAjustador(latitud, longitud);
			}
			
		} catch (final ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return new ListaAjustador("OK", l);
	}

	@Override
	public ListaAjustador listaAjustadores() {
		List<Terminal> lista = null;
		com.aaq.col.clases.webservices.json.Ajustador[] l = null;
		
		try {
			lista = this.terminalDao.listaTodoDeTerminal();
			l = new com.aaq.col.clases.webservices.json.Ajustador[lista.size()];

			for (int i = 0; i < lista.size(); i++) {
				l[i] = lista.get(i).toAjustador(null, null);
			}
		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"listaAjustadores");
		}
		return new ListaAjustador("OK", l);
	}
}
