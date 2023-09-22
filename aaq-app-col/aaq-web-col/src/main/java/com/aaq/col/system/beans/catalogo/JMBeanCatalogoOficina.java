package com.aaq.col.system.beans.catalogo;

import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CatalogoOficina;
import com.aaq.col.system.beans.extensibles.JMBeanExtensibleMapa;
import com.aaq.col.system.database.entidades.modelo.CatalogoOficinaDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;

@ManagedBean(name = "beanCatalogoOficina")
@SessionScoped
public class JMBeanCatalogoOficina extends JMBeanExtensibleMapa<CatalogoOficina> {
	private static final long serialVersionUID = -2871198569541325034L;

	
	public JMBeanCatalogoOficina() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new CatalogoOficinaDataModel(this.getCatalogoOficinaService().listaDeCatalogoOficina(
					this.getEstadoService().objetoEstado(this.getIdEstado()))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

	public String getImagenSatelital() {

		// --> Inicia actual punto de interes
		final JMPuntoGeografico punto = new JMPuntoGeografico();
		punto.setEsArrastable(true);
		final String descripcion = "<b>" + this.getObjetoABM().getDescripcion() + "</b>";
		punto.setIconoArchivo("punto_arrastrable.png");
		punto.setIconoNombre("punto_arrastrable");
		punto.setDescripcionHTML(descripcion);
		punto.setIdentificadorUnico("objetoArrastrable");
		punto.setEtiqueta(this.getObjetoABM().getDescripcion());
		punto.setEsArrastable(true);

		final Vector<JMPuntoGeografico> lista = new Vector<>();
		if (StringUtils.isNotBlank(this.getObjetoABM().getLatitud())
				&& StringUtils.isNotBlank(this.getObjetoABM().getLongitud())) {

			this.alejarMapa(this.getObjetoABM().getLatitud(), this.getObjetoABM().getLongitud());
			punto.setLatitud(this.getObjetoABM().getLatitud());
			punto.setLongitud(this.getObjetoABM().getLongitud());
		} else {
			punto.setLatitud(this.getMapaSatelitalX());
			punto.setLongitud(this.getMapaSatelitalY());

		}

		lista.add(punto);
		return super.getImagenSatelital(lista, null);
	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new CatalogoOficina());
	}

	/**
	 * @return la accion
	 */
	public String doAccionRegistroGuardar() {
		this.doAccionRegistroGuardar(null);
		return "/Catalogo/oficina";

	}

	/**
	 * @return editar
	 */
	public String doAccionRegistroMapa() {
		this.doAccionRegistroEditar(null);
		return "/Catalogo/oficinaABM";
	}

	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/oficinaABM.siica");

	}

	@Override
	public CatalogoOficina getObjetoABM() {
		return super.getObjetoABM();
	}

}
