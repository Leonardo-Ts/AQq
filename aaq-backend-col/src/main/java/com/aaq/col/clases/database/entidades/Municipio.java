 package com.aaq.col.clases.database.entidades;

import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractMunicipio;
import com.aaq.col.clases.database.servicios.interfase.MunicipioServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "municipio")
@RequestScoped
@Entity(name = "Municipio")
@Access(AccessType.FIELD)
@Table(name = "municipio")
public class Municipio extends AbstractMunicipio {
	private static final long serialVersionUID = -7502939032009491930L;

	@Transient
	private String _id_Estado;
	
	public Municipio() {
		super();
	}

	public String get_id_Estado() {
		return _id_Estado;
	}

	public void set_id_Estado(String _id_Estado) {
		this._id_Estado = _id_Estado;
	}

	private static MunicipioServiceInterfase municipioService;

	public static MunicipioServiceInterfase getMunicipioService() {
		if (Municipio.municipioService == null) {
			Municipio.municipioService = JMSIICAServerServiceSingleton.getInstance().getMunicipioService();
		}
		return Municipio.municipioService;
	}

	public String getDescripcion() {
		return this.getNombre();
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		if (this.getEstado() != null) {
			this.set_id_Estado(Objects.toString(this.getEstado().getId(), ""));
		}
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		return new JMResultadoOperacion(new Exception("Catalogo del Sistema No Eliminable"));
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		if (StringUtils.isNotBlank(this.get_id_Estado())) {
			Estado edo = Estado.getEstadoService().objetoEstado(this.get_id_Estado());
			try {
				this.setEstado(edo);
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto ===> objetoEstado => " + this.get_id_Estado(), ex);
			}
		}
		try {
			return Municipio.getMunicipioService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
