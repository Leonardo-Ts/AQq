package com.aaq.col.system.beans.aplicacion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Permiso;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaSHA1;

@ManagedBean(name = "beanAplicacionFirma")
@RequestScoped
public class JMBeanAplicacionFirma extends JMBeanExtensiblePrincipal<Usuario> {
	private static final long serialVersionUID = 5030655402407190772L;

	private String txtUsername;
	private String txtPasswd;
	private String _txtLog;

	// **************************************************************//
	public JMBeanAplicacionFirma() {
		super();
	}

	@Override
	public void actualizarListado() {
	}

	public String doSalirGeneral() {
        if (this.obtenerSession() != null) {
            this.obtenerSession().invalidate();
        }
        this.limpiarDatos();
        return "salir";
    }
	
	public String doAccionLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (StringUtils.isNotBlank(this.getTxtUsername()) && StringUtils.isNotBlank(this.getTxtPasswd())) {
			
			Usuario usuario = null;
			try {
				usuario = this.getUsuarioService().objetoUsuario(this.getTxtUsername(), this.getTxtPasswd());
			} catch (final  DataAccessException ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionLogin",
						this.getTxtUsername(), this.getTxtPasswd());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionLogin",
						this.getTxtUsername(), this.getTxtPasswd());
			}
			// Si el usuario fue encontrado
			if (usuario != null) {
				this.ponerUsuarioEnSession(usuario);
				// Vamos a la siguiente pagina
				return "/Sistema/sistema";
			}

			// puede que sea una terminal
			Terminal terminal = null;
			try {
				terminal = this.getTerminalService().objetoTerminalParaProveedorYPasswd(this.getTxtUsername(),
						this.getTxtPasswd());
			} catch (final DataAccessException ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionLogin",
						this.getTxtUsername(), this.getTxtPasswd());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionLogin",
						this.getTxtUsername(), this.getTxtPasswd());
			}

			// tal vez es un usuario de terminal
			Usuario usuarioterminal = null;
			try {
				usuarioterminal = this.getUsuarioService().objetoUsuario("ajustadores", null);
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionLogin",
						this.getTxtUsername(), this.getTxtPasswd());
			}

			// Si siempre si fue un usuario
			if ((terminal != null) && (usuarioterminal != null)) {
				this.ponerObjetoEnSession(JMConstantes.SESSION_WEB_OBJETO_TERMINAL, terminal);
				this.ponerObjetoEnSession(JMConstantes.SESSION_WEB_OBJETO_HASHCODE,
						JMUtileriaSHA1.returnMD5(Long.toString(System.currentTimeMillis())));

				this.ponerUsuarioEnSession(usuarioterminal);
				return "/Operacion/documentacion";
			}
			
			context.addMessage("Usuario ", new FacesMessage(FacesMessage.SEVERITY_FATAL,"Usuario o contraseña incorrecto. Por favor intente de nuevo.", "PrimeFaces"));
			this.limpiarDatos();
			return null;
		}
		this.limpiarDatos();
		return null;

	}
	
	public void limpiarDatos() {
		this.setTxtUsername(null);
		this.setTxtPasswd(null);
	}

	// **************************************************************//
	// Metodos Accesorios
	// **************************************************************//

	private void ponerUsuarioEnSession(final Usuario usuario) {
		// Objeto de usuario en sesion
		this.ponerObjetoEnSession(JMConstantes.SESSION_WEB_OBJETO_USUARIO, usuario);

		// Lista de paginas permitidas para la base de datos
		final ArrayList<String> listaDePaginasPermitidas = new ArrayList<>();

		List<Permiso> l = null;
		
		//------------- Deshabilitar Permisos -------- 
		this.setObjetoABM(usuario);
		this.getObjetoABM().setAvqPermiso_VerTodosLosReportes(null);//Deshabilitar Permiso "Ver todos los Reportes en Edicion"
		this.getObjetoABM().setCatalogoPermisoAv(false);//Deshabilitar Permiso "CatalogoPermisoAv
		this.getObjetoABM().guardarObjeto();
		//------------------------------------------------------------------------------

		try {
			l = this.getPermisoService().listaDePermiso(usuario.getPerfil());
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "ponerUsuarioEnSession", usuario);
		}
		// Llenamos un objeto de sesion con las paginas permitidas

		if (l != null) {
			for (final Permiso p : l) {
				//------------------ Nuevo Elemento Agregado ----------------------
				if (p.getModulo().getNombre().contains("Ver Reportes En Edicion")) {
					this.setObjetoABM(usuario);
					this.getObjetoABM().setAvqPermiso_VerTodosLosReportes(true);
					this.getObjetoABM().guardarObjeto();
				}
				
				if (p.getModulo().getNombre().equals("AAQ Catalogos -> Terminales -> Edicion -> Asistencia Vial")) {
					this.setObjetoABM(usuario);
					this.getObjetoABM().setCatalogoPermisoAv(true);
					this.getObjetoABM().guardarObjeto();
				}

				//-------------------------------------------------------------------	

				listaDePaginasPermitidas.add(p.getModulo().getPagina());
			}
		}

		this.ponerObjetoEnSession(JMConstantes.SESSION_WEB_OBJETO_PERMISO, listaDePaginasPermitidas);

	}

	// **************************************************************//
	// Getters y Setters
	// **************************************************************//

	/**
	 * @return the txtUsername
	 */
	public String getTxtUsername() {
		return this.txtUsername;
	}

	/**
	 * @param txtUsername
	 *            the txtUsername to set
	 */
	public void setTxtUsername(final String txtUsername) {
		this.txtUsername = txtUsername;
	}

	/**
	 * @return the txtPasswd
	 */
	public String getTxtPasswd() {
		return this.txtPasswd;
	}

	/**
	 * @param txtPasswd
	 *            the txtPasswd to set
	 */
	public void setTxtPasswd(final String txtPasswd) {
		this.txtPasswd = txtPasswd;
	}

	public String get_txtLog() {
		return this._txtLog;
	}

	public void set_txtLog(final String _txtLog) {
		this._txtLog = _txtLog;
	}

}
