package com.aaq.col.system.beans.catalogo;

import java.util.List;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioAlertas;
import com.aaq.col.clases.database.entidades.UsuarioEstado;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.UsuarioDataModel;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaSHA1;

@ManagedBean(name = "beanCatalogoUsuario")
@ViewScoped
public class JMBeanCatalogoUsuario extends JMBeanExtensiblePrincipal<Usuario> {
	private static final long serialVersionUID = -5207102216660492855L;

	private String txtPasswd;
	private String _txtFiltroPerfil;
	private String _txtFiltroNombre;
	private UsuarioAlertas objetoABMUsuarioAltertas;
	private boolean editarUsuarioAlertas = false;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


	public JMBeanCatalogoUsuario() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new UsuarioDataModel(this.getUsuarioService().listaDeUsuario(
					this.getEstadoService().objetoEstado(this.getIdEstado()),
					null,
					this.getBaseService().objetoBase(this.getIdBase()), getPerfilService().objetoPerfil(get_txtFiltroPerfil()),null,null,get_txtFiltroNombre())));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

	public List<Perfil> getListaDePerfil() {
		try {
			return this.getPerfilService().listaDePerfil();
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDePerfil");
			return null;
		}
	}

	public List<Frecuencia> getListaDeFrecuencia() {
		try {
			return this.getFrecuenciaService().listaDeFrecuencia(
					this.getEstadoService().objetoEstado(this.getIdEstado()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeFrecuencia");
			return null;
		}
	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {

		this.setObjetoABM(new Usuario());
		this.getObjetoABM().setNombre("");
		this.getObjetoABM().setUsername("");
		this.getObjetoABM().setPasswd(null);
		this.getObjetoABM().setHabilitado(Boolean.TRUE);

	}

	@Override
	public void doAccionRegistroGuardar(final ActionEvent e) {

		if (this.getObjetoABM() == null) {
			this.ponerMensajeError("ERROR: El usuario actual es NULO. Fecha: " + this.getFechaHoraActual());
			return;
		}
		if (StringUtils.isBlank(this.txtPasswd) && StringUtils.isBlank(this.getObjetoABM().getPasswd())) {
			this.ponerMensajeError("ERROR: Es requerido especificar una contrasena. Fecha: "
					+ this.getFechaHoraActual());
			return;
		}
		if (StringUtils.isBlank(this.getObjetoABM().getNombre())) {
			this.ponerMensajeError("ERROR: Es requerido capturar el nombre. Fecha: " + this.getFechaHoraActual());
			return;
		}
		if (StringUtils.isBlank(this.getObjetoABM().getUsername())) {
			this.ponerMensajeError("ERROR: Es requerido capturar el nombre de usuario. Fecha: "
					+ this.getFechaHoraActual());
			return;
		}
		// Validacion de mail
		if(StringUtils.isNotBlank(this.getObjetoABM().getMail())) {
			if(!VALID_EMAIL_ADDRESS_REGEX.matcher(this.getObjetoABM().getMail()).find()) {
				this.ponerMensajeError("ERROR: El correo electrónico es incorrecto. Fecha: "
						+ this.getFechaHoraActual());
				return;
			}
		}
		
		if (StringUtils.isNotBlank(this.getTxtPasswd())) {
			this.getObjetoABM().setPasswd(JMUtileriaSHA1.returnMD5(this.getTxtPasswd()));
		}				

		super.doAccionRegistroGuardar(e);
	}

	public void doAccionAgregarFrecuenciaAV(final ActionEvent ev) {
		if ((this.getObjetoABM() != null) && StringUtils.isNotBlank(this.getObjetoABM().get_idEstadoFrecuenciaAV())) {

			try {
				this.getObjetoABM()
						.getUsuarioEstadoUsuarioViaIdUsuario()
						.add(new UsuarioEstado(this.getEstadoService().objetoEstado(
								this.getObjetoABM().get_idEstadoFrecuenciaAV()), this.getObjetoABM()));
				this.getObjetoABM().guardarObjeto();
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionAgregarFrecuenciaAV");
			}

		}

	}

	public void doAccionEliminarFrecuenciAV(final UsuarioEstado obj) {

		if ((this.getObjetoABM() != null) && (obj != null)
				&& this.getObjetoABM().getUsuarioEstadoUsuarioViaIdUsuario().contains(obj)) {

			this.getObjetoABM().getUsuarioEstadoUsuarioViaIdUsuario().remove(obj);
			this.getObjetoABM().guardarObjeto();
		}

	}
	
	public void doAccionRegistroAgregarAlerta(final ActionEvent e) {
		 
		this.setObjetoABM(this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		if (this.getObjetoABM() == null) {
			this.ponerMensajeError("No se encontro registro para agregar alertas.");
            return;
		}
		else {
			UsuarioAlertas usuarioAlertas = this.getUsuarioAlertasService().objetoUsuarioAlertasParaUsuario(this.getObjetoABM());
			if(usuarioAlertas == null) {
				this.editarUsuarioAlertas = false;
				this.setObjetoABMUsuarioAltertas(new UsuarioAlertas());
				this.getObjetoABMUsuarioAltertas().setUsuario(this.getObjetoABM());
			}
			else {
				this.editarUsuarioAlertas = true;
				this.setObjetoABMUsuarioAltertas(usuarioAlertas);
				this.getObjetoABMUsuarioAltertas().setUsuario(this.getObjetoABM());
			}
		}
		
	}
	
	public void doAccionRegistroUsuarioAlertas(final ActionEvent e) {

		if(this.editarUsuarioAlertas) this.ponerMensajeResultado(this.getObjetoABMUsuarioAltertas().editarObjeto());
		else this.ponerMensajeResultado(this.getObjetoABMUsuarioAltertas().guardarObjeto());
		this.setObjetoABMUsuarioAltertas(null);
	}

	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/usuariosABM.siica");

	}
	
	public boolean getPermisoAgregarAlertasUsuarios() {
		return this.getTienePermisoParaPagina("/Catalogo/usuariosABM/agregarAlertas.siica");

	}

	@Override
	public Usuario getObjetoABM() {
		return super.getObjetoABM();
	}

	public String getTxtPasswd() {
		return this.txtPasswd;
	}

	public void setTxtPasswd(final String txtPasswd) {
		this.txtPasswd = txtPasswd;
	}

	public String get_txtFiltroPerfil() {
		return _txtFiltroPerfil;
	}

	public void set_txtFiltroPerfil(final String _txtFiltroPerfil) {
		this._txtFiltroPerfil = _txtFiltroPerfil;
	}

	public String get_txtFiltroNombre() {
		return _txtFiltroNombre;
	}

	public void set_txtFiltroNombre(final String _txtFiltroNombre) {
		this._txtFiltroNombre = _txtFiltroNombre;
	}

	public UsuarioAlertas getObjetoABMUsuarioAltertas() {
		return objetoABMUsuarioAltertas;
	}

	public void setObjetoABMUsuarioAltertas(UsuarioAlertas objetoABMUsuarioAltertas) {
		this.objetoABMUsuarioAltertas = objetoABMUsuarioAltertas;
	}
}
