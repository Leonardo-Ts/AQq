package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoGrua;
import com.aaq.col.clases.database.servicios.interfase.CatalogoGruaServiceInterface;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoGrua")
@RequestScoped
@Entity(name = "CatalogoGrua")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_GRUA")
public class CatalogoGrua extends AbstractCatalogoGrua {

	private static final long serialVersionUID = 732910835717631845L;

	public CatalogoGrua() {
		super();
		this.setDescripcion("");
		this.setClave("");
		this.setCodigo("");
	}

	private static CatalogoGruaServiceInterface catalogoGruaService;

	public static CatalogoGruaServiceInterface getCatalogoGruaService() {
		if (CatalogoGrua.catalogoGruaService == null) {
			CatalogoGrua.catalogoGruaService = JMSIICAServerServiceSingleton.getInstance().getCatalogoGruaService();
		}
		return CatalogoGrua.catalogoGruaService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Descripcion,descripcion","Codigo,codigo"}).getLista();
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
			return CatalogoGrua.getCatalogoGruaService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoGrua.getCatalogoGruaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
