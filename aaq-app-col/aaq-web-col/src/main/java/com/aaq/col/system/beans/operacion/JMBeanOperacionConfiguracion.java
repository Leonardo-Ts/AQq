package com.aaq.col.system.beans.operacion;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.ConfiguracionDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;

@ManagedBean(name = "beanOperacionConfiguracion")
@ViewScoped
public class JMBeanOperacionConfiguracion extends JMBeanExtensiblePrincipal<Configuracion> {
	private static final long serialVersionUID = 3796013955583657062L;

	public JMBeanOperacionConfiguracion() {
		super();
		this.actualizarListado();

	}


	@Override
	public void actualizarListado() {
		try {
			this.setListado(new ConfiguracionDataModel(this.getConfiguracionService().listaDeConfiguracion()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
	
	public ArrayList<JMColumna> getColumnas() {
		ArrayList<JMColumna> cols = new JMListadoColumna(new String[] { "Nombre,nombre", "Valor,valorString" }).getLista();
		return cols;
	}

	@Override
	public void doAccionRegistroGuardar(final ActionEvent e) {
		this.getObjetoABM().setUsuario(this.getUsuarioActual());
		this.getObjetoABM().setFecha(new Date());
		super.doAccionRegistroGuardar(e);
	}

	@Override
	public boolean getPermisoABM() {
		return true;
	}

	@Override
	public Configuracion getObjetoABM() {
		return super.getObjetoABM();
	}

}
