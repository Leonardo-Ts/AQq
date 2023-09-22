package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoCuestionarioRobo;
import com.aaq.col.clases.database.servicios.interfase.FormatoCuestionarioRoboServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoCuestionarioRobo")
@RequestScoped
@Entity(name = "FormatoCuestionarioRobo")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_cuestionario_robo")
public class FormatoCuestionarioRobo extends AbstractFormatoCuestionarioRobo {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoCuestionarioRobo() {
		super();
	}

	private static FormatoCuestionarioRoboServiceInterfase formatoCuestionarioRoboService;

	public static FormatoCuestionarioRoboServiceInterfase getFormatoCuestionarioRoboService() {
		if (FormatoCuestionarioRobo.formatoCuestionarioRoboService == null) {
			FormatoCuestionarioRobo.formatoCuestionarioRoboService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoCuestionarioRoboService();
		}
		return FormatoCuestionarioRobo.formatoCuestionarioRoboService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return FormatoCuestionarioRobo.getFormatoCuestionarioRoboService().guardarObjeto(this);
	}

}
