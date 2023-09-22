package com.aaq.col.system.beans.aplicacion.monitoreo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.ReporteSolicitadoDataModel;

@ManagedBean(name = "beanAplicacionServicioSolicitado")
@ViewScoped
public class JMBeanAplicacionServicioSolicitado extends JMBeanExtensiblePrincipal<ReporteSolicitado> {

	private static final long serialVersionUID = 1621547181197902480L;

	// recuadro de seleccion de filtros
	private String txtTipoServicio;
	private String txtClavePrestador;
	private String txtNumeroReporte;

	// **************************************************************//
	// Constructor
	// **************************************************************//

	/**
	 * bean para los servicios solicitados por medio de celular
	 */
	public JMBeanAplicacionServicioSolicitado() {
		super();
		this.actualizarListado();

	}

	// **************************************************************//
	// Listados
	// **************************************************************//

	/**
	 * Actualiza el Listado
	 */
	@Override
	public void actualizarListado() {
		try {
			this.setListado(new ReporteSolicitadoDataModel(this.getReporteSolicitadoService().listaDeReporteSolicitado(
					this.getTxtClavePrestador(), this.getTxtTipoServicio(), this.getTxtNumeroReporte(), null, null)));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

	@Override
	public ReporteSolicitado getObjetoABM() {
		return super.getObjetoABM();
	}

	public String getTxtTipoServicio() {
		return this.txtTipoServicio;
	}

	public void setTxtTipoServicio(final String txtTipoServicio) {
		this.txtTipoServicio = txtTipoServicio;
	}

	public String getTxtClavePrestador() {
		return this.txtClavePrestador;
	}

	public void setTxtClavePrestador(final String txtClavePrestador) {
		this.txtClavePrestador = txtClavePrestador;
	}

	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

}
