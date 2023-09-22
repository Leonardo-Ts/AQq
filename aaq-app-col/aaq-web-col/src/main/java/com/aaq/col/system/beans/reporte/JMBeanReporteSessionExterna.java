package com.aaq.col.system.beans.reporte;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.SessionExterna;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.SessionExternaDataModel;

@ManagedBean(name = "beanReporteSessionExterna")
@ViewScoped
public class JMBeanReporteSessionExterna extends JMBeanExtensiblePrincipal<SessionExterna> {
	private static final long serialVersionUID = -4053441479664538044L;

	private String estado;

	public JMBeanReporteSessionExterna() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {

		String baseBien = this.getIdBase();
		if (StringUtils.containsIgnoreCase(baseBien, "-")) {
			baseBien = null;
		}

		try {
			this.setListado(new SessionExternaDataModel(this.getSessionExternaService().listaDeSessionExterna(
					this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getIdEstado()),
							this.getBaseService().objetoBase(baseBien)), this.getTxtFechaInicio(),
					this.getTxtFechaFin())));
		} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}

	}

	@Override
	public List<Base> getListaDeBases() {
		return this.obtenerListaDeBasesParaEstado(this.getIdEstado(), false);
	}

	@Override
	public String getIdEstado() {
		return this.estado;
	}

	@Override
	public void setIdEstado(final String estado) {
		this.estado = estado;
	}
}
