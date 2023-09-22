package com.aaq.col.system.beans.catalogo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.GeocercaPunto;
import com.aaq.col.system.beans.extensibles.JMBeanExtensibleMapa;
import com.aaq.col.system.database.entidades.modelo.GeocercaDataModel;

@ManagedBean(name = "beanCatalogoGeocerca")
@SessionScoped
public class JMBeanCatalogoGeocerca extends JMBeanExtensibleMapa<Geocerca> {
	private static final long serialVersionUID = -2871198569541325034L;

	private ArrayList<GeocercaPunto> listaDeGeocercaPunto = new ArrayList<>();
	private String txtLatitud;
	private String txtLongitud;

	public JMBeanCatalogoGeocerca() {
		super();
		this.setSoporteGeocerca(Boolean.TRUE);
		this.setMostrarGeocercas(Boolean.TRUE);
		this.doAccionLimpiarBusqueda();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new GeocercaDataModel(this.getGeocercaService().listaDeGeocerca(
					this.getEstadoService().objetoEstado(this.getIdEstado()))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.doAccionLimpiarBusqueda();

		this.setObjetoABM(new Geocerca());
		this.getObjetoABM().setUsuario(this.getUsuarioActual());

		this.setListaDeGeocercaPunto(new ArrayList<GeocercaPunto>());
	}

	/**
	 * @param e  es el evento de Ajax que dispara este metodo desde la interfaz web
	 */
	@Override
	public void doAccionRegistroEditar(final ActionEvent e) {
		super.doAccionRegistroEditar(e);

		this.setListaDeGeocercaPunto(new ArrayList<GeocercaPunto>());
	}

	/**
	 * @return editar
	 */
	public String doAccionRegistroEditarMapa() {
		this.doAccionRegistroEditar(null);
		return "/Catalogo/geocercaABM";
	}

	@Override
	public void doAccionRegistroGuardar(final ActionEvent e) {
		try {
			this.getObjetoABM().setEstado(this.getEstadoService().objetoEstado(this.getIdEstado()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion()
					.manejarExcepcion(ex, this.getClass(), "doAccionRegistroGuardar => objetoEstado");
		}
		super.doAccionRegistroGuardar(e);

		if (!StringUtils.containsIgnoreCase(this.getObjetoABM().getColor(), "#")) {
			this.getObjetoABM().setColor("#" + this.getObjetoABM().getColor());
		}
		if ((this.getListaDeGeocercaPunto() != null) && (this.getListaDeGeocercaPunto().size() > 0)) {

			List<GeocercaPunto> l = null;
			try {
				l = this.getGeocercaPuntoService().listaDeGeocercaPunto(this.getObjetoABM());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"doAccionRegistroGuardar => listaDeGeocercaPunto");
			}

			if ((l != null) && (l.size() > 0)) {
				for (final GeocercaPunto p : l) {
					p.eliminarObjeto();
				}
			}
			for (final GeocercaPunto punto : this.getListaDeGeocercaPunto()) {
				punto.setGeocerca(this.getObjetoABM());
				punto.guardarObjeto();
			}
		}

		super.doAccionRegistroGuardar(e);

	}

	/**
	 * @return guardar
	 */
	public String doAccionRegistroGuardar() {
		this.doAccionRegistroGuardar(null);
		return "geocerca";
	}

	// **************************************************************//
	// Imagen Satelital
	// **************************************************************//

	/**
	 * Obtiene la imagen satelital Jan 30, 2008 2:36:12 AM
	 * 
	 * @return String
	 */
	public String getImagenSatelital() {

		if ((this.getObjetoABM() != null)
				&& (this.getObjetoABM().toPoligonoGeografico() != null)
				&& (this.getObjetoABM().toPoligonoGeografico().getListaDePuntos() != null)
				&& (this.getObjetoABM().toPoligonoGeografico().getListaDePuntos().size() > 0)
				&& (this.getObjetoABM().toPoligonoGeografico().getListaDePuntos().get(0) != null)
				&& StringUtils.isNotBlank(this.getObjetoABM().toPoligonoGeografico().getListaDePuntos().get(0)
						.getLatitud())
				&& StringUtils.isNotBlank(this.getObjetoABM().toPoligonoGeografico().getListaDePuntos().get(0)
						.getLongitud())) {

			this.acercarMapa(this.getObjetoABM().toPoligonoGeografico().getListaDePuntos().get(0).getLatitud(), this
					.getObjetoABM().toPoligonoGeografico().getListaDePuntos().get(0).getLongitud());
		}

		return this.getImagenSatelital(null, null);
	}

	// **************************************************************//
	// Acciones
	// **************************************************************//

	private void doAccionLimpiarBusqueda() {

		this.setListaDeCalles(null);
		this.setListaDeCruces(null);
		this.setListaDeGeocercaPunto(new ArrayList<GeocercaPunto>());
	}

	/**
	 * @param e  es el evento de Ajax que dispara este metodo desde la interfaz web
	 */
	public void doAccionAgregarPunto(final ActionEvent e) {
		if (StringUtils.isNotBlank(this.getTxtLatitud()) && StringUtils.isNotBlank(this.getTxtLongitud())) {
			final GeocercaPunto punto = new GeocercaPunto();
			punto.setLatitud(this.getTxtLatitud());
			punto.setLongitud(this.getTxtLongitud());
			this.getListaDeGeocercaPunto().add(punto);
		}
	}

	// **************************************************************//
	// Permisos
	// **************************************************************//

	/**
	 * @return el permiso
	 */
	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/geocercaABM.siica");
	}

	// **************************************************************//
	// Getter y Setter
	// **************************************************************//

	/**
	 * Mar 15, 2011 10:12:16 AM
	 * 
	 * @return the geocercaDao
	 */
	@Override
	public Geocerca getObjetoABM() {
		return super.getObjetoABM();
	}

	/**
	 * Mar 15, 2011 11:26:25 AM
	 * 
	 * @return the txtLatitud
	 */
	public String getTxtLatitud() {
		return this.txtLatitud;
	}

	/**
	 * Mar 15, 2011 11:26:25 AM
	 * 
	 * @param txtLatitud
	 *            the txtLatitud to set
	 */
	public void setTxtLatitud(final String txtLatitud) {
		this.txtLatitud = txtLatitud;
	}

	/**
	 * Mar 15, 2011 11:26:25 AM
	 * 
	 * @return the txtLongitud
	 */
	public String getTxtLongitud() {
		return this.txtLongitud;
	}

	/**
	 * Mar 15, 2011 11:26:25 AM
	 * 
	 * @param txtLongitud
	 *            the txtLongitud to set
	 */
	public void setTxtLongitud(final String txtLongitud) {
		this.txtLongitud = txtLongitud;
	}

	/**
	 * Mar 15, 2011 11:27:16 AM
	 * 
	 * @return the listaDeGeocercaPunto
	 */
	public ArrayList<GeocercaPunto> getListaDeGeocercaPunto() {
		return this.listaDeGeocercaPunto;
	}

	/**
	 * Mar 15, 2011 11:27:16 AM
	 * 
	 * @param listaDeGeocercaPunto
	 *            the listaDeGeocercaPunto to set
	 */
	public void setListaDeGeocercaPunto(final ArrayList<GeocercaPunto> listaDeGeocercaPunto) {
		this.listaDeGeocercaPunto = listaDeGeocercaPunto;
	}

}
