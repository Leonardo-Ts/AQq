package com.aaq.col.system.beans.catalogos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;


import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.CatFormatosDataModel;

@ManagedBean(name = "beanCatFormatos")
@ViewScoped
public class BeanCatFormatos extends JMBeanExtensiblePrincipal<FormatoCatalogos>{

	private static final long serialVersionUID = 5351275645843531081L;

	private String txtClave;
	private String txtDescripcion;
	private String txtNombre;
	
	public BeanCatFormatos() {
		super();
		this.actualizarListado();
	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new CatFormatosDataModel(this.getFormatoCatalogosService().listaDeFormatoCatalogos(this.getTxtNombre())));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
	
	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new FormatoCatalogos());
	}

	@Override
	public void doAccionRegistroGuardar(final ActionEvent e) {

		if (this.getObjetoABM() == null) {
			this.ponerMensajeError("ERROR: El objeto actual es NULO. Fecha: " + this.getFechaHoraActual());
			return;
		}
		super.doAccionRegistroGuardar(e);
	}
	
	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogacion/catalogosABM.siica");

	}

	public String getTxtClave() {
		return txtClave;
	}

	public void setTxtClave(String txtClave) {
		this.txtClave = txtClave;
	}

	public String getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(String txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public String getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre = txtNombre;
	}
	
	
}
