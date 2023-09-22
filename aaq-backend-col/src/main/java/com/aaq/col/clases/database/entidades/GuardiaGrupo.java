 package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractGuardiaGrupo;
import com.aaq.col.clases.database.servicios.interfase.GuardiaGrupoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "guardiaGrupo")
@Entity(name = "GuardiaGrupo")
@Access(AccessType.FIELD)
@Table(name = "guardias_grupo")
public class GuardiaGrupo extends AbstractGuardiaGrupo {

	private static final long serialVersionUID = -6187092245337397218L;

	public GuardiaGrupo() {
		super();
	}

	private static GuardiaGrupoServiceInterfase guardiaGrupoService;

	public static GuardiaGrupoServiceInterfase getGuardiaGrupoService() {
		if (GuardiaGrupo.guardiaGrupoService == null) {
			GuardiaGrupo.guardiaGrupoService = JMSIICAServerServiceSingleton.getInstance()
					.getGuardiaGrupoService();
		}
		return GuardiaGrupo.guardiaGrupoService;
	}

	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {

		try {
			return GuardiaGrupo.getGuardiaGrupoService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return GuardiaGrupo.getGuardiaGrupoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
}
