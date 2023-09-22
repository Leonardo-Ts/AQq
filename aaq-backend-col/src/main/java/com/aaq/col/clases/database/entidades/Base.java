package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

import com.aaq.col.clases.database.entidades.abstracto.AbstractBase;
import com.aaq.col.clases.database.servicios.interfase.BaseServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "base")
@RequestScoped
@PrimaryKey(validation = IdValidation.NULL)
@Entity(name = "Base")
@Access(AccessType.FIELD)
@Table(name = "base")
public class Base extends AbstractBase {
	@Transient
	private String _idEstado;

	private static final long serialVersionUID = -897970749401850167L;

	/** default constructor */
	public Base() {
		this.setHabilitado(Boolean.TRUE);
		this.setNombre("Base...");
		setHabilitadoEnMapa(Boolean.TRUE);
		setVulnerable(Boolean.FALSE);
	}

	private static BaseServiceInterfase baseService;

	public static BaseServiceInterfase getBaseService() {
		if (Base.baseService == null) {
			Base.baseService = JMSIICAServerServiceSingleton.getInstance().getBaseService();
		}
		return Base.baseService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Estado,estado", "Nombre,nombre","Zona,zona","Latitud,latitud","Longitud,longitud","Habilitado en Mapa,strHabilitadoEnMapa","Vulnerables,strVulnerables","Modificado Por,strDatosModificacion" }).getLista();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		this.setNombre(this.getNombre() + " Eliminada: " + new Date());

		try {
			return Base.getBaseService().guardarObjeto(this);
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
				JMEntidad.getLogger().error("guardarObjeto ==> objetoEstado => " + this.get_idEstado(), ex);
			}
		}
		try {
			return Base.getBaseService().guardarObjeto(this);
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

	@JMReporteOmitirMetodo
	public String getStrHabilitadoEnMapa(){
		return BooleanUtils.isTrue(getHabilitadoEnMapa())?"Si":"No";
	}
	
//	@JMReporteOmitirMetodo
	public String getStrVulnerables(){
		return BooleanUtils.isTrue(getVulnerable())?"Si":"No";
	}

	@JMReporteOmitirMetodo
	public String  getStrDatosModificacion(){
		if (getUsuario() != null){
			return getUsuario().getNombre() +  (getFechaModificacion()!= null? ", " + DateFormatUtils.format(getFechaModificacion(),"yyyy/MM/dd HH:mm:ss"):"");
		}
		return null;
	}

	public String get_idEstado() {
		return this._idEstado;
	}

	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}
}
