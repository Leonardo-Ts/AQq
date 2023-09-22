package com.aaq.col.system.beans.aplicacion.monitoreo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.ReporteAbogadoDataModel;

@ManagedBean(name = "beanAplicacionLegal")
@ViewScoped
public class JMBeanAplicacionLegal extends JMBeanExtensiblePrincipal<ReporteAbogado> {
	private static final long serialVersionUID = -5495972600299654946L;

	public JMBeanAplicacionLegal() {
		super();
		this.actualizarListado();
	}
	
	@Override
	public void actualizarListado() {
		try {
			this.setListado(new ReporteAbogadoDataModel(this.getReporteAbogadoService().listaDeReporteAbogado(
					new Integer(1000))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

    @Override
    public void doAccionRegistroNuevo (final ActionEvent arg0) {
    }

}
