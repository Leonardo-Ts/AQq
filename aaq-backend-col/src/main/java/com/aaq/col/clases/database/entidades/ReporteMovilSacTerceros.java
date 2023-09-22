package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovilSacTerceros;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTercerosServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "reporteMovilSacTerceros")
@RequestScoped
@Entity(name = "ReporteMovilSacTerceros")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "reporte_movil_sac_terceros")
public class ReporteMovilSacTerceros extends AbstractReporteMovilSacTerceros {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3128459577940914421L;
	

	/** default constructor */
	public ReporteMovilSacTerceros() {
		super();

	}

	private static ReporteMovilSacTercerosServiceInterfase reporteMovilSacTercerosService;

	/**
	 *
	 * @return the reporteMovilSacTercerosService
	 */
	public static ReporteMovilSacTercerosServiceInterfase getReporteMovilSacTercerosService() {
		if (ReporteMovilSacTerceros.reporteMovilSacTercerosService == null) {
			ReporteMovilSacTerceros.reporteMovilSacTercerosService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilSacTercerosService();
		}
		return ReporteMovilSacTerceros.reporteMovilSacTercerosService;
	}
	
	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return ReporteMovilSacTerceros.getReporteMovilSacTercerosService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
