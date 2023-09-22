package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoVehTerc;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehTercServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoVehTerc")
@RequestScoped
@Entity(name = "CatalogoVehTerc")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_VEH_TERC")
public class CatalogoVehTerc extends AbstractCatalogoVehTerc {

	private static final long serialVersionUID = -6083486372298273412L;

	public CatalogoVehTerc() {
		super();
		this.setDescripcion("");
		this.setClave("");
	}

	private static CatalogoVehTercServiceInterfase catalogoVehTercService;

	public static CatalogoVehTercServiceInterfase getCatalogoVehTercService() {
		if (CatalogoVehTerc.catalogoVehTercService == null) {
			CatalogoVehTerc.catalogoVehTercService = JMSIICAServerServiceSingleton.getInstance().getCatalogoVehTercService();
		}
		return CatalogoVehTerc.catalogoVehTercService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Descripcion,descripcion"}).getLista();
	}
	
	@Override
	public String toString() {
		return this.getDescripcion();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return CatalogoVehTerc.getCatalogoVehTercService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoVehTerc.getCatalogoVehTercService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
