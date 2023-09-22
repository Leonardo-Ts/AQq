package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalLog;
import com.aaq.col.clases.database.servicios.interfase.TerminalLogServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.aaq.col.clases.siica.JMConstantes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "terminalLog")
@RequestScoped
@Entity(name = "TerminalLog")
@Access(AccessType.FIELD)
@Table(name = "terminal_log")
public class TerminalLog extends AbstractTerminalLog {

	private static final long serialVersionUID = -62197155381533243L;

	/** default constructor */
	public TerminalLog() {
		super();
	}

	private static TerminalLogServiceInterfase terminalLogService;

	public static TerminalLogServiceInterfase getTerminalLogService() {
		if (TerminalLog.terminalLogService == null) {
			TerminalLog.terminalLogService = JMSIICAServerServiceSingleton.getInstance().getTerminalLogService();
		}
		return TerminalLog.terminalLogService;
	}

	@JMReporteOmitirMetodo
	public JMPuntoGeografico toJMPuntoGeografico() {

		final JMPuntoGeografico punto = new JMPuntoGeografico();

		punto.setDescripcionHTML("Direccion: " + this.getPosicionDireccion() + " <br/>Fecha:"
				+ DateFormatUtils.format(this.getFecha(), "dd-MM-yyyy HH:mm:ss"));
		punto.setEsArrastable(false);
		punto.setIdentificadorUnico(Objects.toString(this.getId()));
		punto.setLatitud(this.getLatitud());
		punto.setLongitud(this.getLongitud());
		punto.setEtiqueta(DateFormatUtils.format(this.getFecha(), "dd-MM-yyyy HH:mm:ss"));
		return punto;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Reporte,reporteNumero",
				"Estatus,statusFormateado" }).getLista();
	}

	public ArrayList<JMColumna> getColumnasMonitor() {
		return new JMListadoColumna(new String[] { "Fecha,fecha,fecha", "Unidad,terminalNombre",
				"Velocidad,velocidadKMH", "Estatus,terminalEstatus", "Direccion,posicionDireccion" }).getLista();
	}

	public ArrayList<JMColumna> getColumnasTraza() {
		return new JMListadoColumna(new String[] { "Fecha,fecha,fecha", "Ajustador,terminal" }).getLista();
	}

	public String getTerminalNombre() {
		return this.getTerminal() != null ? this.getTerminal().getNombre() : "";
	}

	public String getTerminalEstatus() {
		return this.getTerminal() != null ? this.getTerminal().getEstatus() : "";
	}

	public String getHTML() {
		return "<b>Fecha</b>" + DateFormatUtils.format(this.getFecha(), "dd/MM/yyyy") + "<br /><b>Nombre</b>"
				+ this.getTerminal().getNombre() + "<br /><b>Estatus</b>" + this.getStatusFormateado()
				+ "<br /><b>Velocidad</b>" + this.getVelocidadKMH() + "<br /><b>Direccion</b>"
				+ this.getPosicionDireccion();

	}

	public String getTipoPunto() {

		if (this.getReporteEstatus() != null) {
			switch (this.getReporteEstatus().intValue()) {
			case JMConstantes.TERMINAL_ESTATUS_DISPONIBLE:
				return JMConstantes.ICONO_VEHICULO_DISPONIBLE;
			case JMConstantes.TERMINAL_ESTATUS_OCUPADO:
				return JMConstantes.ICONO_VEHICULO_OCUPADO;
			case JMConstantes.TERMINAL_ESTATUS_DESCONECTADO:
				return JMConstantes.ICONO_VEHICULO_DESCONECTADO;
			default:
				break;
			}
		}

		return JMConstantes.ICONO_VEHICULO_DESCONECTADO;

	}

	public String getClaseCSS() {

		if (this.getReporteEstatus() != null) {
			switch (this.getReporteEstatus().intValue()) {
			case 1:
				return "online";
			case 2:
				return "busy";
			case 3:
				return "offline";
			case 4:
				return "busy";
			case 5:
				return "offline";
			default:
				break;
			}
		}

		return "";

	}

	public String getStatusFormateado() {

		if (this.getReporteEstatus() != null) {
			switch (this.getReporteEstatus().intValue()) {
			case JMConstantes.TERMINAL_ESTATUS_DISPONIBLE:
				return "Disponible";
			case JMConstantes.TERMINAL_ESTATUS_OCUPADO:
				return "Ocupado";
			case JMConstantes.TERMINAL_ESTATUS_DESCONECTADO:
				return "Desconectado";
			case JMConstantes.TERMINAL_ESTATUS_OTROS:
				return "Hora Comida / Otros";
			case JMConstantes.TERMINAL_ESTATUS_NO_TRABAJANDO:
				return "No trabajando";
			case JMConstantes.TERMINAL_ESTATUS_NO_DEFINIDO:
				return "N/D";
			default:
				return "Sin Definicion";
			}
		}

		return "Disponible";

	}

	public boolean getEsValida() {

		if ((this.getPosicionValida() != null) && (this.getLatitud() != null) && (this.getLongitud() != null)) {
			return BooleanUtils.isTrue(this.getPosicionValida()) && !StringUtils.equals(this.getLatitud(), "-0")
					&& !StringUtils.equals(this.getLongitud(), "0");
		}

		return false;
	}

	public String getVelocidadKMH() {
		if (this.getVelocidad() != null) {
			double toKilometers = NumberUtils.toDouble(this.getVelocidad()) * 1.852;
			toKilometers = Math.round(toKilometers * 100) / 100;
			return toKilometers + " km/h";
		}
		return "0 km/h";

	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return TerminalLog.getTerminalLogService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return TerminalLog.getTerminalLogService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
