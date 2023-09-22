package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFrecuenciaBase;
import com.aaq.col.clases.database.servicios.interfase.FrecuenciaBaseServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "frecuenciaBase")
@Entity(name = "FrecuenciaBase")
@Access(AccessType.FIELD)
@Table(name = "frecuencia_base")
public class FrecuenciaBase extends AbstractFrecuenciaBase {

	private static final long serialVersionUID = -6187092245337397218L;

	public FrecuenciaBase() {
		super();
	}

	private static FrecuenciaBaseServiceInterfase frecuenciaBaseService;

	public static FrecuenciaBaseServiceInterfase getFrecuenciaBaseService() {
		if (FrecuenciaBase.frecuenciaBaseService == null) {
			FrecuenciaBase.frecuenciaBaseService = JMSIICAServerServiceSingleton.getInstance()
					.getFrecuenciaBaseService();
		}
		return FrecuenciaBase.frecuenciaBaseService;
	}

	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

	@Override
	public String toString() {
		return this.getBase() != null ? this.getBase().getEstado().getNombre() + ": " + this.getBase().getNombre()
				: super.toString();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {

		try {
			return FrecuenciaBase.getFrecuenciaBaseService().eliminarObjeto(this);
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
			return FrecuenciaBase.getFrecuenciaBaseService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
}
