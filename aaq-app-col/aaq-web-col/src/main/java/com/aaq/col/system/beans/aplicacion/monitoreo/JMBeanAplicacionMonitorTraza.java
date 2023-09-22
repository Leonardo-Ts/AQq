package com.aaq.col.system.beans.aplicacion.monitoreo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalLog;
import com.aaq.col.system.beans.extensibles.JMBeanExtensibleMapa;
import com.aaq.col.system.database.entidades.modelo.TerminalLogDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@ManagedBean(name = "beanAplicacionMonitorTraza")
@SessionScoped
public class JMBeanAplicacionMonitorTraza extends JMBeanExtensibleMapa<TerminalLog> {
	private static final long serialVersionUID = -6330217221003279323L;
	private Terminal objetoTerminal;

	// **************************************************************//
	// Constructor
	// **************************************************************//
	/**
	 * Constructor
	 */
	public JMBeanAplicacionMonitorTraza() {
		this.setTxtFechaInicio(new Date());
		this.setTxtFechaFin(new Date());
		this.setMostrarGeocercas(Boolean.TRUE);
		this.setMostrarObjetosActualizables(Boolean.FALSE);
		this.setMostrarPuntosInteres(Boolean.TRUE);
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > JMUtileriaFecha.TIEMPO_7_DIAS)) {
			this.ponerMensajeAdvertencia("Este reporte esta limitado a traza de 7 dias");
			return;
		}

		if (this.getObjetoTerminal() != null) {
			final List<Terminal> l = new ArrayList<>();
			l.add(this.getObjetoTerminal());
			try {
				this.setListado(new TerminalLogDataModel(this.getTerminalLogService().listaDeTerminalLog(l,
						this.getTxtFechaInicio(), this.getTxtFechaFin(), false, true, new Integer(1000))));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
			}

		}

	}

	public String doAccionTrazarAjustador(final Terminal terminal) {
		this.setObjetoTerminal(terminal);
		return "monitorDetalle";
	}

	public String getImagenSatelital() {
		final Vector<JMPuntoGeografico> listaPuntos = new Vector<>();

		if ((this.getListado() != null) && (this.getListado().getDataSource() != null)) {
			listaPuntos.addAll(this.getListado().getDataSource().stream().map(TerminalLog::toJMPuntoGeografico).collect(Collectors.toList()));
		}

		return super.getImagenSatelital(null, listaPuntos);

	}

	public Terminal getObjetoTerminal() {
		return this.objetoTerminal;
	}

	public void setObjetoTerminal(final Terminal objetoTerminal) {
		this.objetoTerminal = objetoTerminal;
	}

}
