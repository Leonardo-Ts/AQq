package com.aaq.col.system.beans.catalogo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CatalogoRoles;
import com.aaq.col.clases.database.entidades.Modulo;
import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Permiso;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRolesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.PerfilDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;

@ManagedBean(name = "beanCatalogoPerfil")
@ViewScoped
public class JMBeanCatalogoPerfil extends JMBeanExtensiblePrincipal<Perfil> {
	private static final long serialVersionUID = 840123600983585053L;

	private String idModuloSeleccionado;
	private CatalogoRolesServiceInterfase catalogoRolesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoRolesService();

	// **************************************************************//
	// Constructor
	// **************************************************************//
	
	private List<CatalogoRoles> listaRoles;
	
	public List<CatalogoRoles> getListaRoles() {
		if (this.listaRoles == null) {
			try {
				this.listaRoles = this.catalogoRolesService.listaDeRoles();
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaRoles");
			}
		}
		
		return listaRoles;
	}

	public JMBeanCatalogoPerfil() {
		super();
		this.actualizarListado();

	}
	
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Nombre,nombre", "Rol,rol" }).getLista();
	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new PerfilDataModel(this.getPerfilService().listaDePerfil()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

	public List<Permiso> getListaDePermiso() {
		if ((this.getObjetoABM() != null) && (this.getObjetoABM().getId() != null)) {
			try {
				return this.getPermisoService().listaDePermiso(this.getObjetoABM());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDePermiso");
			}
		}
		return null;
	}

	public List<Modulo> getListaDeModulosNoAgregadosAlPerfil() {

		if (this.getObjetoABM() != null) {

			final ArrayList<Integer> lista = new ArrayList<>();

			List<Permiso> lp = null;
			try {
				lp = this.getPermisoService().listaDePermiso(this.getObjetoABM());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"getListaDeModulosNoAgregadosAlPerfil => ListaDePermiso");
			}

			if (lp != null) {
				for (final Permiso permiso : lp) {
					lista.add(permiso.getModulo().getId());
				}
				try {
					return this.getModuloService().listaDeModulo(lista, null, null, null, null, false);
				} catch (final Exception ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"getListaDeModulosNoAgregadosAlPerfil => listaDeModulo");
				}

			}

		}
		return null;

	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new Perfil());
	}

	public void doAccionAgregarPermiso(final ActionEvent e) {

		if (this.getObjetoABM() != null) {
			if (this.getObjetoABM().getId() != null) {
				if (StringUtils.isNotBlank(this.idModuloSeleccionado)) {

					Modulo modulo = null;
					try {
						modulo = this.getModuloService().objetoModulo(this.getIdModuloSeleccionado());
					} catch (final Exception ex) {
						this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
								"doAccionAgregarPermiso => ObjetoModulo");
					}

					if (modulo != null) {
						final Permiso permiso = new Permiso();
						permiso.setModulo(modulo);
						permiso.setPerfil(this.getObjetoABM());
						this.ponerMensajeResultado(permiso.guardarObjeto());

					}
				}

			} else {
				this.ponerMensajeError("Es necesario guardar primero el perfil nuevo antes de agregarle permisos");
			}

		}
	}

	public void doAccionEliminarPermiso(final ActionEvent e) {

		Permiso permiso = null;
		try {
			permiso = this.getPermisoService().objetoPermiso(
					this.obtenerParametroDeRequest(JMConstantes.WEB_PARAMETRO_IDENTI));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionEliminarPermiso => ObjetoPermiso");
		}
		if (permiso != null) {
			this.ponerMensajeResultado(permiso.eliminarObjeto());
		}

	}

	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/perfilesABM.siica");

	}

	@Override
	public Perfil getObjetoABM() {
		return super.getObjetoABM();
	}

	public String getIdModuloSeleccionado() {
		return this.idModuloSeleccionado;
	}

	public void setIdModuloSeleccionado(final String idModuloSeleccionado) {
		this.idModuloSeleccionado = idModuloSeleccionado;
	}

}
