package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteSolicitado;
import com.aaq.col.clases.database.servicios.interfase.ReporteSolicitadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "reporteSolicitado")
@RequestScoped
@Entity(name = "ReporteSolicitado")
@Access(AccessType.FIELD)
@Table(name = "reporte_solicitado")
public class ReporteSolicitado extends AbstractReporteSolicitado {

	private static final long serialVersionUID = -965673496111333042L;

	/** default constructor */
	public ReporteSolicitado() {
		super();
	}

	private static ReporteSolicitadoServiceInterfase reporteSolicitadoService;

	public static ReporteSolicitadoServiceInterfase getReporteSolicitadoService() {
		if (ReporteSolicitado.reporteSolicitadoService == null) {
			ReporteSolicitado.reporteSolicitadoService = JMSIICAServerServiceSingleton.getInstance()
					.getReporteSolicitadoService();
		}
		return ReporteSolicitado.reporteSolicitadoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fechaInsertado,fecha", "Ajustador,terminal",
				"Clave Proveedor,claveProveedor", "Tipo de Servicio,tipoDeServicio", "Numero Reporte,numeroReporte",
				"Atencion A,atencionA", "Folio Talonario,folioValeTalonario", "Folio SISE,siseRespuestaFolio" })
				.getLista();
	}

	/*
	 * (non-Javadoc)
 	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return ReporteSolicitado.getReporteSolicitadoService().eliminarObjeto(this);
		} catch (ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		} catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final DataAccessException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return ReporteSolicitado.getReporteSolicitadoService().guardarObjeto(this);
		} catch (ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		} catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final DataAccessException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
