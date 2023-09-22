package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractHorarioGrupo;
import com.aaq.col.clases.database.servicios.interfase.HorarioGrupoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "horarioGrupo")
@Entity(name = "HorarioGrupo")
@Access(AccessType.FIELD)
@Table(name = "horario_grupos")
public class HorarioGrupo extends AbstractHorarioGrupo {

	private static final long serialVersionUID = -6187092245337397218L;

	/** default constructor */
	public HorarioGrupo() {
		super();
	}

	private static HorarioGrupoServiceInterfase horarioGrupoService;

	
	public static HorarioGrupoServiceInterfase getHorarioGrupoService() {
		if (HorarioGrupo.horarioGrupoService == null) {
			HorarioGrupo.horarioGrupoService = JMSIICAServerServiceSingleton.getInstance()
					.getHorarioGrupoService();
		}
		return HorarioGrupo.horarioGrupoService;
	}

	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

//	@Override
//	public String toString() {
//		return this.getBase() != null ? this.getBase().getEstado().getNombre() + ": " + this.getBase().getNombre()
//				: super.toString();
//	}

	/*
	 * (non-Javadoc)
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {

		try {
			return HorarioGrupo.getHorarioGrupoService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return HorarioGrupo.getHorarioGrupoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
}
