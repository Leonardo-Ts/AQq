package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractPuntoInteres;
import com.aaq.col.clases.database.servicios.interfase.PuntoInteresServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "puntoInteres")
@RequestScoped
@Entity(name = "PuntoInteres")
@Access(AccessType.FIELD)
@Table(name = "punto_interes")
public class PuntoInteres extends AbstractPuntoInteres {
	private static final long serialVersionUID = -3534616701222954874L;

	@Transient
	private String _idEstado;

	@Transient
	private String _idPuntoInteresTipo;

	/** default constructor */
	public PuntoInteres() {
		super();
		this.setDescripcion("Descripcion");
		this.setNombre("Nombre");
		this.setLatitud("");
		this.setLongitud("");
		this.setHabilitado(Boolean.TRUE);

	}

	public JMPuntoGeografico toJMPuntoGeografico(){
		final JMPuntoGeografico punto = new JMPuntoGeografico();

		punto.setEsArrastable(false);

		punto.setIconoNombre(this.getPuntoInteresTipo().getNombre());
		punto.setIconoArchivo(this.getPuntoInteresTipo().getIcono());

		punto.setLatitud(this.getLatitud());
		punto.setLongitud(this.getLongitud());
		punto.setDescripcionHTML(this.getDescripcion());
		punto.setEtiqueta(this.getDescripcion());

		punto.setIdentificadorUnico("interes_" + this.getId());
		return punto;
	}

	private static PuntoInteresServiceInterfase puntoInteresService;

	public static PuntoInteresServiceInterfase getPuntoInteresService() {
		if (PuntoInteres.puntoInteresService == null) {
			PuntoInteres.puntoInteresService = JMSIICAServerServiceSingleton.getInstance().getPuntoInteresService();
		}
		return PuntoInteres.puntoInteresService;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);

		try {
			return PuntoInteres.getPuntoInteresService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		if (this.getEstado() != null) {
			this.set_idEstado(Objects.toString(this.getEstado().getId(), ""));
		}
		if (this.getPuntoInteresTipo() != null) {
			this.set_idPuntoInteresTipo(Objects.toString(this.getPuntoInteresTipo().getId(), ""));
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		if (StringUtils.isNotBlank(this.get_idEstado())) {
			try {
				this.setEstado(Estado.getEstadoService().objetoEstado(this.get_idEstado()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoEstado", ex);
			}
		}

		if (StringUtils.isBlank(this.getNombre())) {
			return new JMResultadoOperacion(new Exception(
					"ERROR: Es requerido capturar el nombre del punto de interes."));
		}
		if ((this.getId() != null) && StringUtils.isBlank(this.getLatitud())) {
			return new JMResultadoOperacion(new Exception("ERROR: Es requerido capturar la coordenada X."));
		}
		if ((this.getId() != null) && StringUtils.isBlank(this.getLongitud())) {
			return new JMResultadoOperacion(new Exception("ERROR: Es requerido capturar la coordenada Y."));
		}

		if (StringUtils.isNotBlank(this.get_idPuntoInteresTipo())) {
			try {
				this.setPuntoInteresTipo(PuntoInteresTipo.getPuntoInteresTipoService().objetoPuntoInteresTipo(
						this.get_idPuntoInteresTipo()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoPuntoInteresTipo", ex);
			}
		}

		try {
			return PuntoInteres.getPuntoInteresService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] { "Nombre,nombre", "Descripcion,descripcion", "Tipo,puntoInteresTipo" }).getLista();
	}

	public String get_idEstado() {
		return this._idEstado;
	}

	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}

	public String get_idPuntoInteresTipo() {
		return this._idPuntoInteresTipo;
	}

	public void set_idPuntoInteresTipo(final String _idPuntoInteresTipo) {
		this._idPuntoInteresTipo = _idPuntoInteresTipo;
	}

}
