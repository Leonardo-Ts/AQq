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

import com.aaq.col.clases.database.entidades.abstracto.AbstractPerfil;
import com.aaq.col.clases.database.servicios.interfase.PerfilServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "perfil")
@RequestScoped
@Entity(name = "Perfil")
@Access(AccessType.FIELD)
@Table(name = "perfil")
public class Perfil extends AbstractPerfil {

	private static final long serialVersionUID = 1205935317148425489L;
	
	@Transient
	private String idRol;

	// **************************************************************//
	// Constructor
	// **************************************************************//

	/** default constructor */
	public Perfil() {
		super();
		this.setNombre("Perfil...");
		this.setHabilitado(Boolean.TRUE);
		this.setidRol("0");
	}

	// **************************************************************//
	// De Aplicativo
	// **************************************************************//

	private static PerfilServiceInterfase perfilService;

	public static PerfilServiceInterfase getPerfilService() {
		if (Perfil.perfilService == null) {
			Perfil.perfilService = JMSIICAServerServiceSingleton.getInstance().getPerfilService();
		}
		return Perfil.perfilService;
	}

	@JMReporteOmitirMetodo
	public List<Permiso> getPermisos() {
		try {
			return Permiso.getPermisoService().listaDePermiso(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("getPermisos => ListaDePermiso", ex);
			return null;
		}
	}

	@JMReporteOmitirMetodo
	public List<Usuario> getUsuarios() {
		try {
			return Usuario.getUsuarioService().listaDeUsuarioParaPerfil(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("getUsuarios => ListaDeUsuarioParaPerfil", ex);
			return null;
		}
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Nombre,nombre", "Rol,rol" }).getLista();
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
			return Perfil.getPerfilService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		if (this.getRol() != null) {
			this.setidRol(Objects.toString(this.getRol().getId(), ""));
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		if (StringUtils.isNotBlank(this.getidRol())) {
			try {
				if(StringUtils.equals(this.getidRol(), "0")){
					this.setRol(null);
				}else {
					this.setRol(CatalogoRoles.getCatalogoRolesService().objetoRol(this.getidRol()));					
				}
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoPerfil", ex);
			}
		}
		try {
			return Perfil.getPerfilService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
	

	public String getidRol() {
		return idRol;
	}

	public void setidRol(String _idRol) {
		this.idRol = _idRol;
	}

}
