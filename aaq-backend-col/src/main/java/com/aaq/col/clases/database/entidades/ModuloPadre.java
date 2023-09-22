package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

import com.aaq.col.clases.database.entidades.abstracto.AbstractModuloPadre;
import com.aaq.col.clases.database.servicios.interfase.ModuloPadreServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "moduloPadre")
@RequestScoped
@PrimaryKey(validation = IdValidation.NULL)
@Entity(name = "ModuloPadre")
@Access(AccessType.FIELD)
@Table(name = "modulo_padre")
public class ModuloPadre extends AbstractModuloPadre {

	private static final long serialVersionUID = -6326924874300176308L;

	public ModuloPadre() {
		super();
	}

	private static ModuloPadreServiceInterfase moduloPadreService;

	public static ModuloPadreServiceInterfase getModuloPadreService() {
		if (ModuloPadre.moduloPadreService == null) {
			ModuloPadre.moduloPadreService = JMSIICAServerServiceSingleton.getInstance().getModuloPadreService();
		}
		return ModuloPadre.moduloPadreService;
	}

	@Override
	public String toString() {
		return this.getNombre();

	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		return new JMResultadoOperacion(new Exception("Modulo del Sistema No Eliminable"));
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return ModuloPadre.getModuloPadreService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
