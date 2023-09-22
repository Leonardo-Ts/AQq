package com.aaq.col.system.beans.aplicacion.siica;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Comunicado;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.ComunicadoDataModel;

@ManagedBean(name = "beanAplicacionComunicado")
@ViewScoped
public class JMBeanAplicacionComunicado extends JMBeanExtensiblePrincipal<Comunicado> {

	private static final long serialVersionUID = 3359799941790036859L;
	private String _idEstado;
	private String _idBase;
	private String _idTerminal;

	public JMBeanAplicacionComunicado() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new ComunicadoDataModel(this.getComunicadoService().listaDeComunicado(
					this.getEstadoService().objetoEstado(this.get_idEstado()),
					this.getBaseService().objetoBase(this.get_idBase()),
					this.getTerminalService().objetoTerminal(this.get_idTerminal()), null)));
		} catch (final ClassCastException |  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		} catch (final PersistenceException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new Comunicado());
		this.getObjetoABM().setUsuario(this.getUsuarioActual());
	}

	// **************************************************************//
	// Permisos
	// **************************************************************//
	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Aplicacion/comunicadoABM.siica");
	}

	public String get_idEstado() {
		return _idEstado;
	}

	public void set_idEstado(String _idEstado) {
		this._idEstado = _idEstado;
	}

	public String get_idBase() {
		return _idBase;
	}

	public void set_idBase(String _idBase) {
		this._idBase = _idBase;
	}

	public String get_idTerminal() {
		return _idTerminal;
	}

	public void set_idTerminal(String _idTerminal) {
		this._idTerminal = _idTerminal;
	}

	
}
