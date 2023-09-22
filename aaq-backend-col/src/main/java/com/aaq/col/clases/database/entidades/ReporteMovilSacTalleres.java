package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovilSacTalleres;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTalleresServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;


@ManagedBean(name = "reporteMovilSacTalleres")
@RequestScoped
@Entity(name = "ReporteMovilSacTalleres")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "reporte_movil_sac_talleres")
public class ReporteMovilSacTalleres extends AbstractReporteMovilSacTalleres {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7232113339690104966L;

	/** default constructor */
	public ReporteMovilSacTalleres() {
		super();

	}

	private static ReporteMovilSacTalleresServiceInterfase reporteMovilSacTalleresService;

	/**
	 *
	 * @return the reporteMovilSacTalleresService
	 */
	public static ReporteMovilSacTalleresServiceInterfase getReporteMovilSacTalleresService() {
		if (ReporteMovilSacTalleres.reporteMovilSacTalleresService == null) {
			ReporteMovilSacTalleres.reporteMovilSacTalleresService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilSacTalleresService();
		}
		return ReporteMovilSacTalleres.reporteMovilSacTalleresService;
	}

}
