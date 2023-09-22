package com.aaq.col.system.beans.catalogo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.FrecuenciaDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;

@ManagedBean(name = "beanCatalogoFrecuencia")
@ViewScoped
public class JMBeanCatalogoFrecuencia extends JMBeanExtensiblePrincipal<Frecuencia> {
	private static final long serialVersionUID = -8267415766637489956L;

	private String idEstadoSeleccionadoDos;
	private String idBaseSeleccionadoDos;

	public JMBeanCatalogoFrecuencia() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new FrecuenciaDataModel(this.getFrecuenciaService().listaDeFrecuencia(
					this.getEstadoService().objetoEstado(this.getIdEstado()))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
	
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] { "Estado,estado", "Nombre,nombre", "Bases Que Incluye,basesIncluidas" }).getLista();

	}

	public List<FrecuenciaBase> getListaDeFrecuenciaBase() {
		if ((this.getObjetoABM() != null) && (this.getObjetoABM().getId() != null)) {
			try {
				return this.getFrecuenciaBaseService().listaDeFrecuenciaBase(this.getObjetoABM());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeFrecuenciaBase");
			}
		}
		return null;
	}


	@Override
	public List<Base> getListaDeBasesTodas() {
		try {
			
			return this.getBaseService().listaDeBase(this.getEstadoService().objetoEstado(this.getIdEstadoDos()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeBasesTodas");
		}
		return null;
	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new Frecuencia());
	}

	public void doAccionFrecuenciaAgregarBase(final ActionEvent e) {
		Base base = null;
		try {
			base = this.getBaseService().objetoBase(this.getIdBaseSeleccionadoDos());
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionFrecuenciaAgregarBase");
		}

		if (base != null) {
			final FrecuenciaBase frec = new FrecuenciaBase();
			frec.setFrecuencia(this.getObjetoABM());
			frec.setBase(base);
			this.ponerMensajeResultado(frec.guardarObjeto());
		}
	}

	public void doAccionFrecuenciaEliminarBase(final ActionEvent e) {
		FrecuenciaBase freqz = null;
		try {
			freqz = this.getFrecuenciaBaseService().objetoFrecuenciaBase(
					this.obtenerParametroDeRequest(JMConstantes.WEB_PARAMETRO_IDENTI));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionFrecuenciaEliminarBase");
		}

		if (freqz != null) {
			this.ponerMensajeResultado(freqz.eliminarObjeto());
		}

	}


	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/frecuenciaABM.siica");

	}

	@Override
	public Frecuencia getObjetoABM() {
		return super.getObjetoABM();
	}

	public String getIdEstadoDos() {
		return this.idEstadoSeleccionadoDos;
	}

	public void setIdEstadoDos(final String idEstadoSeleccionadoDos) {
		this.idEstadoSeleccionadoDos = idEstadoSeleccionadoDos;
	}

	public String getIdBaseSeleccionadoDos() {
		return this.idBaseSeleccionadoDos;
	}

	public void setIdBaseSeleccionadoDos(final String idBaseSeleccionadoDos) {
		this.idBaseSeleccionadoDos = idBaseSeleccionadoDos;
	}

}
