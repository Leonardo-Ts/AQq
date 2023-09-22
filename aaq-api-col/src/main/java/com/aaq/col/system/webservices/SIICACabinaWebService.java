package com.aaq.col.system.webservices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.jws.WebService;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaq.col.clases.database.entidades.Siniestro;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.SiniestroServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.xml.webservices.DatosAjustador;
import com.aaq.col.clases.xml.webservices.DatosLocalizacion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.fabricas.mapas.JMMotorDeMapas;

@WebService(serviceName = "SIICACabinaWebService", portName = "SIICACabinaWebServicePort", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices", endpointInterface = "com.aaq.col.system.webservices.SIICACabinaInterfase")
public class SIICACabinaWebService implements SIICACabinaInterfase {

	@Autowired
	private SiniestroServiceInterfase siniestroDao;

	@Autowired
	private TerminalServiceInterfase terminalDao;

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);

	public SIICACabinaWebService() {
		super();
	}

	@Override
	public DatosLocalizacion datosDeLocalizacion(final String identificador, final String reporte) {
		if (StringUtils.isBlank(identificador) && StringUtils.isBlank(reporte)) {
			return null;
		}

		Siniestro o = null;
		try {
			o = this.siniestroDao.objetoSiniestro(reporte, identificador);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "datosDeLocalizacion => ObjetoSiniestro");

		}
		if (o != null) {
			final Boolean cL = new Boolean(BooleanUtils.isTrue(o.getCerrarLocalizacion())
					|| (StringUtils.length(o.getLatitud()) > 4));
			final Boolean cA = new Boolean(BooleanUtils.isTrue(o.getCerrarAsignacion()) || (o.getTerminal() != null));

			return new DatosLocalizacion(o.getNumeroReporte(), o.getIdentificadorUnico(), o.getLatitud(),
					o.getLongitud(), o.getUbicacionEstado(), o.getUbicacionMunicipio(), o.getUbicacionColonia(),
					o.getUbicacionCodigoPostal(), o.getUbicacionCalle() + " " + o.getUbicacionNumero(),
					o.getUbicacionEntreCalle(), o.getUbicacionReferencia(), o.getUbicacionCarreteraNombre(),
					o.getTerminal() != null ? o.getTerminal().getNumeroproveedor() : null, o.getEstado() != null ? o
							.getEstado().getHusoHorario() : null, cL, cA, o.getFecha(), o.getIdMunSepomex(),
					o.getIdEntSepomex(), o.getUbicacionNumero(), o.getUbicacionCarreteraKilometro()

			);

		}

		return null;
	}

	@Override
	public String actualizarIdentificadorConReporte(final String identificador, final String reporte) {
		if (StringUtils.isBlank(identificador) || StringUtils.isBlank(reporte)) {
			return "ERROR: Requerido proveer identificador y reporte";
		}

		Siniestro o = null;
		try {
			o = this.siniestroDao.objetoSiniestro(null, identificador);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"actualizarIdentificadorConReporte => ObjetoSiniestro");
		}

		if (o == null) {
			return "ERROR: Identificador no existente";
		}

		o.setNumeroReporte(reporte);

		return o.guardarObjeto().getMensaje();

	}

	@Override
	public ArrayList<DatosAjustador> ajustadoresCercanos(final String identificador, final String reporte) {
		if (StringUtils.isBlank(identificador) && StringUtils.isBlank(reporte)) {
			return null;
		}

		Siniestro o = null;
		try {
			o = this.siniestroDao.objetoSiniestro(reporte, identificador);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "ajustadoresCercanos => ObjetoSiniestro");
		}

		if ((o == null) || StringUtils.isBlank(o.getLatitud()) || StringUtils.isBlank(o.getLongitud())) {
			return null;
		}

		List<Terminal> lista = null;
		try {
			lista = this.terminalDao.listaDeTerminalParaCoordenadas(o.getLatitud(), o.getLongitud(), false);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresCercanos => listaDeTerminalParaCoordenadas");
		}

		if ((lista != null) && (lista.size() > 0)) {
			final ArrayList<DatosAjustador> datos = new ArrayList<>();
			final Hashtable<Double, Terminal> tabla = new Hashtable<>();

			for (final Terminal terminal : lista) {
				if ((terminal.getFechaEstatusDisponible() != null)
						&& NumberUtils.isDigits(terminal.getNumeroproveedor())) {
					try {
						tabla.put(
								new Double(JMMotorDeMapas.obtenerDistanciaEntreDosCoordenadas(o.getLatitud(),
										o.getLongitud(), terminal.getLatitud(), terminal.getLongitud())), terminal);
					} catch (final Exception e) {
						// nada
					}
				}

			}
			final Vector<Double> v = new Vector<>(tabla.keySet());
			Collections.sort(v);
			final Iterator<Double> it = v.iterator();
			while (it.hasNext()) {
				final Double element = it.next();
				final Terminal t = tabla.get(element);
				datos.add(new DatosAjustador(t.getNumeroproveedor(), t.getFechaEstatusDisponible(), new Double(element
						.doubleValue() / 100), new Integer(t.getContadorReportesEsteDia())));
			}

			return datos;

		}

		return null;
	}
}
