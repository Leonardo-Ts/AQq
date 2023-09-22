package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.exceptions.DatabaseException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractGeocerca;
import com.aaq.col.clases.database.servicios.interfase.GeocercaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPoligonoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "geocerca")
@RequestScoped
@Entity(name = "Geocerca")
@Access(AccessType.FIELD)
@Table(name = "geocerca")
public class Geocerca extends AbstractGeocerca {
	private static final long serialVersionUID = 3035933427945781531L;

	@Transient
	private String _idEstado;

	// Constructors

	/** default constructor */
	public Geocerca() {
		super();
		this.setHabilitado(Boolean.TRUE);
		this.setFecha(new Date());
		this.setColor("c0c0c0");
	}

	private static GeocercaServiceInterfase geocercaService;

	public static GeocercaServiceInterfase getGeocercaService() {
		if (Geocerca.geocercaService == null) {
			Geocerca.geocercaService = JMSIICAServerServiceSingleton.getInstance().getGeocercaService();
		}
		return Geocerca.geocercaService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Estado,estado", "Nombre,nombre", "Descripción,descripcion" })
				.getLista();

	}

	public JMPoligonoGeografico toPoligonoGeografico() {
		if (this.getId() != null) {
			final JMPoligonoGeografico poligono = new JMPoligonoGeografico();
			poligono.setColor(this.getColor());
			List<GeocercaPunto> l = null;
			try {
				l = GeocercaPunto.getGeocercaPuntoService().listaDeGeocercaPunto(this);
			} catch (final ClassCastException | RollbackException | IllegalArgumentException | DatabaseException ex) {
				JMEntidad.getLogger().error("toPoligonoGeografico => getGeocercaPuntoService => listaDeGeocercaPunto ",
						ex);
			} catch (final PersistenceException ex) {
				JMEntidad.getLogger().error("toPoligonoGeografico => getGeocercaPuntoService => listaDeGeocercaPunto ",
						ex);
			}
			if ((l != null) && (l.size() > 0)) {
				final Vector<JMPuntoGeografico> lista = new Vector<>();
				for (final GeocercaPunto punto : l) {
					final JMPuntoGeografico pgeo = new JMPuntoGeografico();
					pgeo.setLatitud(punto.getLatitud());
					pgeo.setLongitud(punto.getLongitud());
					lista.add(pgeo);
				}
				poligono.setListaDePuntos(lista);
			}
			return poligono;

		}
		return null;
	}

	public String[][] toArreglo() {
		if (this.getId() != null) {
			List<GeocercaPunto> l = null;
			try {
				l = GeocercaPunto.getGeocercaPuntoService().listaDeGeocercaPunto(this);
			} catch (final ClassCastException | IllegalArgumentException | RollbackException ex) {
				JMEntidad.getLogger().error("toArreglo => getGeocercaPuntoService => listaDeGeocercaPunto ", ex);
			}  catch (final PersistenceException ex) {
				JMEntidad.getLogger().error("toArreglo => getGeocercaPuntoService => listaDeGeocercaPunto ", ex);
			}
			if ((l != null) && (l.size() > 0)) {
				final String[][] listaRetorno = new String[l.size()][];
				int i = 0;
				for (final GeocercaPunto punto : l) {
					listaRetorno[i++] = new String[] { punto.getLongitud(), punto.getLatitud() };
				}
				return listaRetorno;
			}

		}
		return null;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);

		try {
			return Geocerca.getGeocercaService().guardarObjeto(this);
		} catch (final ClassCastException | IllegalArgumentException | RollbackException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final PersistenceException ex) {
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
			} catch (final ClassCastException | IllegalArgumentException | DatabaseException | RollbackException ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoEstado", ex);
			} catch (final PersistenceException ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoEstado", ex);
			}
		}
		try {
			return Geocerca.getGeocercaService().guardarObjeto(this);
		} catch (final ClassCastException | IllegalArgumentException | DatabaseException | RollbackException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final PersistenceException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	public String get_idEstado() {
		return this._idEstado;
	}

	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}

}
