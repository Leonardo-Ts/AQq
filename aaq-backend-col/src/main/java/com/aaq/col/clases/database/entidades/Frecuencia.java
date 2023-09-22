package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFrecuencia;
import com.aaq.col.clases.database.servicios.interfase.FrecuenciaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "frecuencia")
@RequestScoped
@Entity(name = "Frecuencia")
@Access(AccessType.FIELD)
@Table(name = "frecuencia")
public class Frecuencia extends AbstractFrecuencia {
	@Transient
	private String _idEstado;

	private static final long serialVersionUID = -7587356711371598127L;

	public Frecuencia() {
		super();
		this.setNombre("Frecuencia...");
		this.setHabilitado(Boolean.TRUE);
	}

	private static FrecuenciaServiceInterfase frecuenciaService;

	public static FrecuenciaServiceInterfase getFrecuenciaService() {
		if (Frecuencia.frecuenciaService == null) {
			Frecuencia.frecuenciaService = JMSIICAServerServiceSingleton.getInstance().getFrecuenciaService();
		}
		return Frecuencia.frecuenciaService;
	}

	@JMReporteOmitirMetodo
	public List<FrecuenciaBase> getFrecuenciaBases() {
		try {
			return FrecuenciaBase.getFrecuenciaBaseService().listaDeFrecuenciaBase(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("getFrecuenciaBases => listaDeFrecuenciaBase", ex);
			return null;
		}
	}
	
	@JMReporteOmitirMetodo
	public List<FrecuenciaBase> getFrecuenciaBasesGH() {
		try {
			return FrecuenciaBase.getFrecuenciaBaseService().listaDeFrecuenciaBase(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("getFrecuenciaBases => listaDeFrecuenciaBase", ex);
			return null;
		}
	}

	@JMReporteOmitirMetodo
	public List<Usuario> getUsuarios() {
		try {
			return Usuario.getUsuarioService().listaDeUsuarioParaFrecuencia(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("getUsuarios => listaDeUsuarioParaFrecuencia", ex);
			return null;
		}
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] { "Estado,estado", "Nombre,nombre", "Bases Que Incluye,basesIncluidas" }).getLista();

	}

	public String getBasesIncluidas() {
		final StringBuilder retorno = new StringBuilder();
		if (this.getFrecuenciaBases() != null) {
			for (final FrecuenciaBase freqz : this.getFrecuenciaBases()) {
				retorno.append("\n" + freqz.getBase().getEstado().getNombre() + ": " + freqz.getBase().getNombre());
			}

		}
		return Objects.toString(retorno, "");
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);

		for (final FrecuenciaBase f : this.getFrecuenciaBases()) {
			f.eliminarObjeto();
		}
		try {
			return Frecuencia.getFrecuenciaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		if (this.getEstado() != null) {
			this.set_idEstado(Objects.toString(this.getEstado().getId(), ""));
		}
		return null;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		if (StringUtils.isNotBlank(this.get_idEstado())) {
			try {
				this.setEstado(Estado.getEstadoService().objetoEstado(this.get_idEstado()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoEstado", ex);
			}
		}
		try {
			return Frecuencia.getFrecuenciaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	public String getDescripcion() {
		return this.getNombre();
	}

	public String get_idEstado() {
		return this._idEstado;
	}

	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}

}
