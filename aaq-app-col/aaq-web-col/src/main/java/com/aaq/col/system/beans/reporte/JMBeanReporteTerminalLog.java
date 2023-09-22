package com.aaq.col.system.beans.reporte;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalLog;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.TerminalLogDataModel;
import com.jmfg.jmlib.sistema.fabricas.graficos.JMGraficaFlash;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@ManagedBean(name = "beanReporteTerminalLog")
@ViewScoped
public class JMBeanReporteTerminalLog extends JMBeanExtensiblePrincipal<TerminalLog> {

	private static final long serialVersionUID = -2709030166429505966L;

	private String txtNumeroReporte;

	public JMBeanReporteTerminalLog() {
		super();
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

		if (StringUtils.isNotBlank(this.getIdTerminal())) {
			final ArrayList<Terminal> lista = new ArrayList<>();

			try {
				lista.add(this.getTerminalService().objetoTerminal(this.getIdTerminal()));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"actualizarListado => Objeto Terminal");
			}

			try {
				this.setListado(new TerminalLogDataModel(this.getTerminalLogService().listaDeTerminalLog(lista,
						this.getTxtFechaInicio(), this.getTxtFechaFin(), false, false, new Integer(10000))));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
			}

		}

	}

	public String getGrafica() {
		try {
			return JMGraficaFlash.obtenerGraficaFlashFusion(
					this.getTerminalLogService().listaDeTerminalLogParaGrafica(this.getTxtFechaInicio(),
							this.getTxtFechaFin(), this.getIdTerminal(), this.getTxtNumeroReporte()),
					"../diseno/graficos/FusionCharts.js", "../diseno/graficos/Column3D.swf",
					"forma_grafica_barras:grafica", "forma_grafica_barras:grafica", "100%", "300", "Grafica Ajustador",
					"Mensajes", "Cantidad", "");
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getGrafica");
			return null;

		}
	}

	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

}
