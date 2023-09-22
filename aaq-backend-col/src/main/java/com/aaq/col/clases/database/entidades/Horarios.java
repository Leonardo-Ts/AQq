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

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

import com.aaq.col.clases.database.entidades.abstracto.AbstractHorarios;
import com.aaq.col.clases.database.servicios.interfase.HorariosServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "horarios")
@RequestScoped
@PrimaryKey(validation = IdValidation.NULL)
@Entity(name = "Horarios")
@Access(AccessType.FIELD)
@Table(name = "catalogo_horarios")
public class Horarios extends AbstractHorarios {

	@Transient
	private String _idEstado;

	// **************************************************************//
	// Constructor
	// **************************************************************//


	private static final long serialVersionUID = -7587356711371598127L;

	/** default constructor */
	public Horarios() {
		super();
		this.setClave_horario("H1...");
		this.setHora_entrada("");
		this.setHora_salida("");
		this.setDescanso(false);
	}
	
	public Horarios(String idEstado) {
		super();
		this.setClave_horario("H1...");
		this.setHora_entrada("");
		this.setHora_salida("");
		this.setDescanso(false);
		this.set_idEstado(idEstado);
	}
	

	// **************************************************************//
	// De Aplicativo
	// **************************************************************//

	private static HorariosServiceInterfase horariosService;

	public static HorariosServiceInterfase getHorariosService() {
		if (Horarios.horariosService == null) {
			Horarios.horariosService = JMSIICAServerServiceSingleton.getInstance().getHorariosService();
		}
		return Horarios.horariosService;
	}

	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] { "Estado,estado", "Nombre de Horario,clave_horario", "Día,dia_semana", "Hora Entrada,horarioEntrada", "Hora Salida,horarioSalida" }).getLista();
	}


	public String getHorarioEntrada() {
		final StringBuilder retorno = new StringBuilder();

		if (  StringUtils.isNoneBlank(this.getHora_entrada()) ) {
				if (this.getDescanso()) {
					retorno.append(this.getHora_entrada() + " / Descanso"  );
				} else {
					retorno.append(this.getHora_entrada());						
				}
		} else {
			retorno.append("Descanso");
		}
		return Objects.toString(retorno, "");
	}
	
	public String getHorarioSalida() {
		final StringBuilder retorno = new StringBuilder();

		if (  StringUtils.isNoneBlank(this.getHora_salida()) ) {
				if (this.getDescanso()) {
					retorno.append(this.getHora_salida() + " / Descanso"  );
				} else {
					retorno.append(this.getHora_salida());						
				}
		} else {
			retorno.append("Descanso");
		}
		return Objects.toString(retorno, "");
	}
	
	
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return Horarios.getHorariosService().eliminarObjeto(this);
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
			} catch (Exception e) {
				JMEntidad.getLogger().error("guardarObjete ==> objetoEstado => " + this.get_idEstado(), e);
			}
		}
		try {
			return Horarios.getHorariosService().guardarObjeto(this);

		} catch (Exception e) {
			return new JMResultadoOperacion(e);
		}
	}

	/*
	 * auto generated
	 * 
	 * @es_generated
	 */
	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}
	/**
	 * Mar 26, 2012
	 * 
	 * @return the _idEstado
	 */
	public String get_idEstado() {
		return this._idEstado;
	}

	/**
	 * Mar 26, 2012
	 * 
	 * @param _idEstado
	 *            the _idEstado to set
	 */
	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}
	
	
}
