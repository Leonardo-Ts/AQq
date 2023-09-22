package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractGeocercaPunto;
import com.aaq.col.clases.database.servicios.interfase.GeocercaPuntoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "geocercaPunto")
@RequestScoped
@Entity(name = "GeocercaPunto")
@Access(AccessType.FIELD)
@Table(name = "geocerca_punto")
public class GeocercaPunto extends AbstractGeocercaPunto {

	private static final long serialVersionUID = 5008303574185266867L;

	public GeocercaPunto() {
		super();
	}

	private static GeocercaPuntoServiceInterfase geocercaPuntoService;

	public static GeocercaPuntoServiceInterfase getGeocercaPuntoService() {
		if (GeocercaPunto.geocercaPuntoService == null) {
			GeocercaPunto.geocercaPuntoService = JMSIICAServerServiceSingleton.getInstance().getGeocercaPuntoService();
		}
		return GeocercaPunto.geocercaPuntoService;
	}

	public JMPuntoGeografico toJMPuntoGeografico(){
		final JMPuntoGeografico pgeo = new JMPuntoGeografico();
		pgeo.setLatitud(this.getLatitud());
		pgeo.setLongitud(this.getLongitud());
		return pgeo;
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {

		try {
			return GeocercaPunto.getGeocercaPuntoService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return GeocercaPunto.getGeocercaPuntoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
