package com.aaq.col.system.beans.reporte;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMEntidadObjetoDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.fabricas.graficos.JMGraficaFlash;

@ManagedBean(name = "beanReporteKilometrajeDia")
@ViewScoped
public class JMBeanReporteKilometrajeDia extends JMBeanExtensiblePrincipal<JMEntidadObjeto> {
	private static final long serialVersionUID = -2001557979633866324L;

	public JMBeanReporteKilometrajeDia() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new JMEntidadObjetoDataModel(this.getTerminalLogService()
					.listaDeTerminalLogParaGraficaKMDia(this.getTxtFechaInicio(), this.getTxtFechaFin(),
							this.getIdTerminal())));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
    @Override
    public void doAccionRegistroNuevo (final ActionEvent arg0) {
        // nada
    }

	public String getGrafica() {
		try {
			return JMGraficaFlash.obtenerGraficaFlashFusion(
					this.getTerminalLogService().listaDeTerminalLogParaGraficaKMDia(this.getTxtFechaInicio(),
							this.getTxtFechaFin(), this.getIdTerminal()), "../diseno/graficos/FusionCharts.js",
					"../diseno/graficos/Column3D.swf", "forma_grafica_barras:grafica", "forma_grafica_barras:grafica",
					"100%", "300", "Grafica Kilometros Por Dia", "Dia", "Kilometros", "");
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getGrafica");
			return null;
		}
	}

}
