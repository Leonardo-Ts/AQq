package com.aaq.col.system.beans.catalogo;

import java.util.List;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.aaq.col.system.beans.extensibles.JMBeanExtensibleMapa;
import com.aaq.col.system.database.entidades.modelo.PuntoInteresDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;

@ManagedBean(name = "beanCatalogoPuntoInteres")
@SessionScoped
public class JMBeanCatalogoPuntoInteres extends JMBeanExtensibleMapa<PuntoInteres> {
	private static final long serialVersionUID = -8396133668886144213L;

	private String idTipoPuntoInteresSeleccionado;

	public JMBeanCatalogoPuntoInteres() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new PuntoInteresDataModel(this.getPuntoInteresService().listaDePuntoInteres(
					this.getEstadoService().objetoEstado(this.getIdEstado()),
					this.getPuntoInteresTipoService().listaDePuntoInteresTipo(this.getIdTipoPuntoInteresSeleccionado(),
							null))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}

	}

	public List<PuntoInteresTipo> getListaDePuntoInteresTipo() {
		try {
			return this.getPuntoInteresTipoService().listaDePuntoInteresTipo();
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDePuntoInteresTipo");

			return null;
		}
	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new PuntoInteres());

	}

	public String doAccionRegistroEditarMapa() {
		this.doAccionRegistroEditar(null);

		return "/Catalogo/puntoInteresABM";
	}

	public String doAccionRegistroGuardar() {
		this.doAccionRegistroGuardar(null);
		return "/Catalogo/puntoInteres";
	}

	public String getUrlImagenTipoPunto() {
		if (StringUtils.isNotBlank(this.getIdTipoPuntoInteresSeleccionado())) {
			PuntoInteresTipo tipo = null;
			try {
				tipo = this.getPuntoInteresTipoService().objetoPuntoInteresTipo(
						this.getIdTipoPuntoInteresSeleccionado());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"getUrlImagenTipoPunto => objetoPuntoInteresTipo");
			}

			if (tipo != null) {
				try {
					return this.getConfiguracionService().obtenerCadena(
							JMConstantesComunes.CONFIGURACION_MAPAS_HTML_PATH_IMAGENES)
							+ tipo.getIcono();
				} catch (final Exception ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"getUrlImagenTipoPunto => ObtenerCadena");

				}
			}
		}
		return null;
	}

	public PuntoInteresTipo getActualTipoPuntoInteres() {
		PuntoInteresTipo tipo = null;
		try {
			tipo = this.getPuntoInteresTipoService().objetoPuntoInteresTipo(this.getIdTipoPuntoInteresSeleccionado());
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getActualTipoPuntoInteres");
		}
		return tipo;
	}

	public boolean getPuntoInteresValido() {

		if (this.getObjetoABM() != null) {
			if (StringUtils.isNotBlank(this.getObjetoABM().getLatitud())
					&& StringUtils.isNotBlank(this.getObjetoABM().getLongitud())) {
				return true;
			}
		}

		return false;
	}

	public String getImagenSatelital() {

		// --> Inicia actual punto de interes
		final JMPuntoGeografico punto = new JMPuntoGeografico();
		punto.setEsArrastable(true);
		punto.setIconoArchivo(this.getObjetoABM().getPuntoInteresTipo().getIcono());
		punto.setIconoNombre(this.getObjetoABM().getPuntoInteresTipo().getNombre());
		punto.setDescripcionHTML(punto.getDescripcionHTML());
		punto.setIdentificadorUnico("objetoArrastrable");
		punto.setEtiqueta(this.getObjetoABM().getDescripcion());

		final Vector<JMPuntoGeografico> lista = new Vector<>();
		if (this.getPuntoInteresValido()) {
			punto.setLatitud(this.getObjetoABM().getLatitud());
			punto.setLongitud(this.getObjetoABM().getLongitud());
			this.acercarMapa(punto.getLatitud(), punto.getLongitud());
		} else {
			punto.setLatitud(this.getMapaSatelitalX());
			punto.setLongitud(this.getMapaSatelitalY());

		}

		lista.add(punto);
		return this.getImagenSatelital(lista, null);

	}

	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/puntoInteresABM.siica");

	}

	public String getIdTipoPuntoInteresSeleccionado() {
		return this.idTipoPuntoInteresSeleccionado;
	}

	public void setIdTipoPuntoInteresSeleccionado(final String idTipoPuntoInteresSeleccionado) {
		this.idTipoPuntoInteresSeleccionado = idTipoPuntoInteresSeleccionado;
	}

	@Override
	public PuntoInteres getObjetoABM() {
		return super.getObjetoABM();
	}

}
