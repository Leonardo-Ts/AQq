package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoPartesAuto;
import com.aaq.col.clases.database.servicios.interfase.CatalogoPartesAutoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoPartesAuto")
@RequestScoped
@Entity(name = "CatalogoPartesAuto")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_PARTES_AUTO")
public class CatalogoPartesAuto extends AbstractCatalogoPartesAuto {

	private static final long serialVersionUID = 6763920078591666171L;

	public CatalogoPartesAuto() {
		super();
		this.setNumParte("");
		this.setTipoParte("");
		this.setNombreParte("");
	}

	private static CatalogoPartesAutoServiceInterfase catalogoPartesAutoService;

	public static CatalogoPartesAutoServiceInterfase getCatalogoPartesAutoService() {
		if (CatalogoPartesAuto.catalogoPartesAutoService == null) {
			CatalogoPartesAuto.catalogoPartesAutoService = JMSIICAServerServiceSingleton.getInstance().getCatalogoPartesAutoService();
		}
		return CatalogoPartesAuto.catalogoPartesAutoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Tipo parte,tipoParte","Num. Parte,numParte","Nombre parte,nombreParte"}).getLista();
	}
	
	@Override
	public String toString() {
		return this.getNombreParte();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return CatalogoPartesAuto.getCatalogoPartesAutoService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoPartesAuto.getCatalogoPartesAutoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
}
