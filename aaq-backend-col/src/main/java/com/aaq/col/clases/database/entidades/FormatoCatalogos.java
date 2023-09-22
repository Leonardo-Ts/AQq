package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoCatalogos;
import com.aaq.col.clases.database.servicios.interfase.FormatoCatalogosServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "formatoCatalogos")
@RequestScoped
@Entity(name = "FormatoCatalogos")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_catalogos")
public class FormatoCatalogos extends AbstractFormatoCatalogos {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoCatalogos() {
		super();
	}

	private static FormatoCatalogosServiceInterfase formatoCatalogosService;

	public static FormatoCatalogosServiceInterfase getFormatoCatalogosService() {
		if (FormatoCatalogos.formatoCatalogosService == null) {
			FormatoCatalogos.formatoCatalogosService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoCatalogosService();
		}
		return FormatoCatalogos.formatoCatalogosService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Nombre,nombre","Valores,valores"}).getLista();
	}

	
	@Override
	public String toString() {
		return this.getValores();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return FormatoCatalogos.getFormatoCatalogosService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return FormatoCatalogos.getFormatoCatalogosService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
