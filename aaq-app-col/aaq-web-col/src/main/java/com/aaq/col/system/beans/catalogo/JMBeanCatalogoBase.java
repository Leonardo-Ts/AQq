package com.aaq.col.system.beans.catalogo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.BaseDataModel;

import java.util.Date;

@ManagedBean(name = "beanCatalogoBase")
@ViewScoped
public class JMBeanCatalogoBase extends JMBeanExtensiblePrincipal<Base> {
	private static final long serialVersionUID = 2007072384683499009L;
	private Boolean _filtroConLatitud = Boolean.FALSE;
	private Boolean _filtroHabilitadoEnMapa = Boolean.TRUE;

	public JMBeanCatalogoBase() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new BaseDataModel(this.getBaseService()
					.listaDeBase(
							StringUtils.isNotBlank(this.getIdEstado()) ? this
									.getEstadoService().objetoEstado(
											this.getIdEstado()) : null, null,
							false, false, _filtroConLatitud,
							_filtroHabilitadoEnMapa

					)));
		} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"actualizarListado");
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"actualizarListado");
		}
	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new Base());
	}

	@Override
	public void doAccionRegistroGuardar(final ActionEvent e) {
		if (getObjetoABM() != null
				&& StringUtils.isNotBlank(getObjetoABM().getLatitud())
				&& StringUtils.isNotBlank(getObjetoABM().getLongitud())) {
			if (!StringUtils.containsIgnoreCase(getObjetoABM().getLatitud(),
					"-")) {
				ponerMensajeError("Las latitudes y longitudes en SIICA son invertidas. Por favor capture la latitud con el simbolo negativo");
				return;
			}

			// Lista de Terminales
			try {
				for (Terminal t : getTerminalService().listaDeTerminal(null,
						getObjetoABM(), null, null, null, null, null, null,
						null, null, null, null, null, null, Boolean.TRUE, null)) {
					double latitud = NumberUtils.toDouble(getObjetoABM()
							.getLatitud())
							+ RandomUtils.nextDouble(0.0001, 0.001);
					double longitud = NumberUtils.toDouble(getObjetoABM()
							.getLongitud());
					t.setLatitud(Double.toString(latitud));
					t.setLongitud(Double.toString(longitud));
					t.guardarObjeto();
				}
			} catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionRegistroGuardar => Terminal");
			} catch (Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionRegistroGuardar => Terminal");
			}
		}
		if (getObjetoABM() != null) {
			getObjetoABM().setUsuario(getUsuarioActual());
			getObjetoABM().setFechaModificacion(new Date());
			
        //********* Habilita y Deshabilita Posicion en http://servproarcgis.mapdata.com.mx/*************
		try {
				for (Terminal t : getTerminalService().listaDeTerminal(null,
						getObjetoABM(), null, null, null, null, null, null,
						null, null, null, null, null, null, null, null)) {
					t.setMostrarEnCercania(getObjetoABM().getHabilitadoEnMapaCabina());//Habilita o Deshabilta El Mapa en Cabina

					t.guardarObjeto();
				}
			} catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex2) {
				this.getUtileriaExcepcion().manejarExcepcion(ex2, this.getClass(), "constructor => Obtener Booleano");
			} catch (Exception ex2) {
				this.getUtileriaExcepcion().manejarExcepcion(ex2, this.getClass(), "constructor => Obtener Booleano");
			}
		
		//************************************************************************************************

		}
		super.doAccionRegistroGuardar(e);
	}

	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/basesABM.siica");

	}

	@Override
	public Base getObjetoABM() {
		return super.getObjetoABM();
	}

	public Boolean get_filtroConLatitud() {
		return _filtroConLatitud;
	}

	public void set_filtroConLatitud(final Boolean _filtroConLatitud) {
		this._filtroConLatitud = _filtroConLatitud;
	}

	public Boolean get_filtroHabilitadoEnMapa() {
		return _filtroHabilitadoEnMapa;
	}

	public void set_filtroHabilitadoEnMapa(final Boolean _filtroHabilitadoEnMapa) {
		this._filtroHabilitadoEnMapa = _filtroHabilitadoEnMapa;
	}
}
