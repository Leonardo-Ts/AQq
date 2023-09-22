package com.aaq.col.system.beans.reporte;

import java.util.List;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.system.beans.extensibles.JMBeanExtensibleMapa;
import com.aaq.col.system.database.entidades.modelo.ReporteSiseDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@ManagedBean(name = "beanReporteSise")
@ViewScoped
public class JMBeanReporteSise extends JMBeanExtensibleMapa<ReporteSise> {
	private static final long serialVersionUID = 1596239135829419582L;

	private String txtNumeroReporte;
	private String txtSiniestro;
	private String idEstado;
	private String idCodigoDeCausa;

	public JMBeanReporteSise() {
		super();
		this.setMostrarGeocercas(Boolean.TRUE);
		this.setMostrarObjetosActualizables(Boolean.FALSE);
		this.setMostrarPuntosInteres(Boolean.FALSE);
		this.setSoporteGeocerca(Boolean.TRUE);
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {

		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
			this.ponerMensajeAdvertencia("Los reportes estan limitados a 31 dias naturales de datos. Para obtener reportes de meses multiples, es necesario crear el reporte uno por uno del mes que se solicita.");
			return;
		}

		try {
			this.setListado(new ReporteSiseDataModel(this.getReporteSiseService().listaDeReporteSise(
					this.getEstadoService().objetoEstado(this.getIdEstado()),
					this.getTerminalService().objetoTerminal(this.getIdTerminal()),
					this.getCatalogoCodigoDeCausaService().objetoCatalogoCodigoDeCausa(this.getIdCodigoDeCausa()),
					this.getTxtFechaInicio(), this.getTxtFechaFin(), this.getTxtNumeroReporte(),
					this.getTxtSiniestro(), null, null, null)));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}

	}

	public String getImagenSatelital() {

		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
			return null;
		}

		final Vector<JMPuntoGeografico> lista = new Vector<>();

		List<ReporteSise> listaSISE = null;
		try {
			listaSISE = this.getReporteSiseService().listaDeReporteSise(
					this.getEstadoService().objetoEstado(this.getIdEstado()),
					this.getTerminalService().objetoTerminal(this.getIdTerminal()),
					this.getCatalogoCodigoDeCausaService().objetoCatalogoCodigoDeCausa(this.getIdCodigoDeCausa()),
					this.getTxtFechaInicio(), this.getTxtFechaFin(), this.getTxtNumeroReporte(),
					this.getTxtSiniestro(), Boolean.TRUE, null, new Integer(1000));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"getIMagenSatelital => ListaDeReporteSise");
		}

		if ((listaSISE != null) && (listaSISE.size() > 0)) {
			for (final ReporteSise rep : listaSISE) {
				lista.add(rep.toJMPuntoGeografico());
			}

		}

		return super.getImagenSatelital(lista, null);
	}

	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

	public String getTxtSiniestro() {
		return this.txtSiniestro;
	}

	public void setTxtSiniestro(final String txtSiniestro) {
		this.txtSiniestro = txtSiniestro;
	}

	public String getIdCodigoDeCausa() {
		return this.idCodigoDeCausa;
	}

	public void setIdCodigoDeCausa(final String idCodigoDeCausa) {
		this.idCodigoDeCausa = idCodigoDeCausa;
	}

	@Override
	public String getIdEstado() {
		return this.idEstado;
	}
	@Override
	public void setIdEstado(final String idEstado) {
		this.idEstado = idEstado;
	}

}
