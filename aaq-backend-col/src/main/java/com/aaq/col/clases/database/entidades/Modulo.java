package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractModulo;
import com.aaq.col.clases.database.servicios.interfase.ModuloServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.google.common.base.CaseFormat;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "modulo")
@RequestScoped
@Entity(name = "Modulo")
@Access(AccessType.FIELD)
@Table(name = "modulo")
public class Modulo extends AbstractModulo {

	private static final long serialVersionUID = -8847292243135002767L;

	public Modulo() {
		super();
	}

	private static ModuloServiceInterfase moduloService;

	public static ModuloServiceInterfase getModuloService() {
		if (Modulo.moduloService == null) {
			Modulo.moduloService = JMSIICAServerServiceSingleton.getInstance().getModuloService();
		}
		return Modulo.moduloService;
	}

	public String accion() {
		return this.getAccion();
	}

	public String getIcono() {
		return "menu_"
				+ CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
						StringUtils.substring(this.getAccion(), StringUtils.lastIndexOf(this.getAccion(), "/") + 1));
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
			return Modulo.getModuloService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
}
