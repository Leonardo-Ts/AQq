package com.aaq.col.system.beans.reporte;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.ReporteMovilDataModel;

@ManagedBean(name = "beanReporteMovil")
@ViewScoped
public class JMBeanReporteMovil extends JMBeanExtensiblePrincipal<ReporteMovil> {
	private static final long serialVersionUID = 2819830683980238549L;

	public JMBeanReporteMovil() {
		super();
		this.actualizarListado();

	}


    @Override
	public void actualizarListado() {
		try {
			this.setListado(new ReporteMovilDataModel(this.getReporteMovilService().listaDeReporteMovil(
					this.getTxtFechaInicio(), this.getTxtFechaFin(), false)));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

    @Override
    public void doAccionRegistroNuevo (final ActionEvent arg0) {
        // nada
    }

}
