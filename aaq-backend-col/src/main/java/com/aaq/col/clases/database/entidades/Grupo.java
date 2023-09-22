 package com.aaq.col.clases.database.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractGrupo;
import com.aaq.col.clases.database.servicios.interfase.GrupoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "grupo")
@RequestScoped
@Entity(name = "Grupo")
@Access(AccessType.FIELD)
@Table(name = "grupos")
public class Grupo extends AbstractGrupo {

	private static final long serialVersionUID = 1205935317148425489L;
	
	@Transient
	private String _idEstado;

	public Grupo() {
		super();
		this.setNombre("Grupo...");
		this.setHabilitado(Boolean.TRUE);
	}
	
	
	/** default constructor */
	public Grupo(String idEstado) {
		super();
		this.setNombre("Grupo...");
		this.setHabilitado(Boolean.TRUE);
		this.set_idEstado(idEstado);
	}

	private static GrupoServiceInterfase grupoService;

	public static GrupoServiceInterfase getGrupoService() {
		if (Grupo.grupoService == null) {
			Grupo.grupoService = JMSIICAServerServiceSingleton.getInstance().getGrupoService();
		}
		return Grupo.grupoService;
	}



	
	@JMReporteOmitirMetodo
	public List<GrupoTerminal> getGrupoTerminal() {
		try {
			return GrupoTerminal.getGrupoTerminalService().listaDeGrupoTerminal(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("getGrupoTerminal => listaDeGrupoTerminal", ex);
			return null;
		}
	}
	
	public List<HorarioGrupo> getHorarioGrupo() {
		try {
			return HorarioGrupo.getHorarioGrupoService().listaDeHorarioGrupo(this);
		} catch (Exception e) {
			JMEntidad.getLogger().error("getHorarioGrupo => listaDeHorarioGrupo", e);
			return null;
		}
	}

	public HorarioGrupo getHorarioGrupo(Date fecha) {
		try {
			return HorarioGrupo.getHorarioGrupoService().horarioGrupoFecha(this, null); // return HorarioGrupo.getHorarioGrupoService().horarioGrupoFecha(this, fecha);
		} catch (Exception e) {
			JMEntidad.getLogger().error("getHorarioGrupo => listaDeHorarioGrupo", e);
			return null;
		}
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Estado,estado", "Grupo,nombre", "Terminales Que Incluye,terminalesIncluidas", "Horarios,horariosIncluidos" }).getLista();
	}

	public String getTerminalesIncluidas() {
		final StringBuilder retorno = new StringBuilder();
		if (this.getGrupoTerminal() != null) {
			for (final GrupoTerminal grupz : this.getGrupoTerminal()) {
				retorno.append("\n" + grupz.getTerminal().getNumeroproveedor() + " -- ");
			}

		}
		return Objects.toString(retorno, "");
	}
	
	public String getHorariosIncluidos() {
		final StringBuilder retorno = new StringBuilder();
		SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMM 'de' yyyy", new Locale("es","ES"));
//		Calendar rightNow = Calendar.getInstance();
//		if (this.getHorarioGrupo(rightNow.getTime()) != null) {
		HorarioGrupo grupz =  this.getHorarioGrupo(null); // rightNow.getTime()
		if(grupz != null) {
			retorno.append(grupz.getClaveHorario()+" -- Inicia: " + formateador.format(grupz.getFechaInicio()) + " -- Termina: " + formateador.format(grupz.getFechaFin()));
			retorno.append("\n");			
//		}
			

		}
		return Objects.toString(retorno, "");
	}

	
	public String getDescripcion() {
		return this.getNombre();
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		try {
			return Grupo.getGrupoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad #editarObjeto()
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
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		if (StringUtils.isNotBlank(this.get_idEstado())) {
			try {
				this.setEstado(Estado.getEstadoService().objetoEstado(this.get_idEstado()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto ===> objetoEstado => " + this.get_idEstado(), ex);
			}
		}
		try {
			return Grupo.getGrupoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
	
	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

	public String get_idEstado() {
		return this._idEstado;
	}

	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}


}
