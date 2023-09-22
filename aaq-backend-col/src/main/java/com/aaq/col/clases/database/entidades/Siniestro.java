package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractSiniestro;
import com.aaq.col.clases.database.servicios.interfase.SiniestroServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "siniestro")
@RequestScoped
@Entity(name = "Siniestro")
@Access(AccessType.FIELD)
@Table(name = "siniestro")
public class Siniestro extends AbstractSiniestro {
	private static final long serialVersionUID = 8002326915613739514L;

	public Siniestro() {
		super();
		this.setFecha(new Date());
		this.setNumeroReporte("");

	}

	private static SiniestroServiceInterfase siniestroService;

	public static SiniestroServiceInterfase getSiniestroService() {
		if (Siniestro.siniestroService == null) {
			Siniestro.siniestroService = JMSIICAServerServiceSingleton.getInstance().getSiniestroService();
		}
		return Siniestro.siniestroService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Estado,estado", "Fecha,fecha,fecha",
				"Capturista,usuario", "Numero Reporte,numeroReporte", "Ajustador,terminal" }).getLista();
	}

	public String getHTML() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Siniestro");

		if (this.getNumeroReporte() != null) {
			builder.append("Reporte:" + this.getNumeroReporte());
		}
		if (this.getFecha() != null) {
			builder.append("Fecha:" + DateFormatUtils.format(this.getFecha(), "dd/mm/yyyy"));
		}

		return Objects.toString(builder, "");

	}

	public boolean getEstaLocalizado() {
		return (StringUtils.length(this.getLatitud()) > 2) && (StringUtils.length(this.getLongitud()) > 2);

	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return Siniestro.getSiniestroService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return Siniestro.getSiniestroService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
