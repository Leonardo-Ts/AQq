package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractNotasReporte;
import com.aaq.col.clases.database.servicios.interfase.NotasReporteServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "notasReporte")
@RequestScoped
@Entity(name = "NotasReporte")
@Access(AccessType.FIELD)
@Table(name = "NOTAS_REPORTE")
public class NotasReporte  extends AbstractNotasReporte{

	private static final long serialVersionUID = -5499199086978174222L;
	
	private static NotasReporteServiceInterfase notasReporteService;
	
	public NotasReporte() {
		super();
		this.setFecha(new Date());
	}
	
	public static NotasReporteServiceInterfase getNotasReporteService() {
		if (NotasReporte.notasReporteService == null) {
			NotasReporte.notasReporteService = JMSIICAServerServiceSingleton.getInstance().getNotasReporteService();
		}
		return NotasReporte.notasReporteService;
	}
	
	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Reporte,reporte","Fecha,fecha,fecha", "Causa Nota,causaNota", "Notas,notas", "Usuario,usuario"})
				.getLista();
	}
	
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return NotasReporte.getNotasReporteService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
	
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return NotasReporte.getNotasReporteService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	
}
