package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCodigoResponsabilidadEstad;
import com.aaq.col.clases.database.servicios.interfase.CodigoResponsabilidadEstadServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "codigoResponsabilidadEstadistica")
@RequestScoped
@Entity(name = "CodigoResponsabilidadEstadistica")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "CODIGO_RESPONSABILIDAD_ESTADISTICA")
public class CodigoResponsabilidadEstad extends AbstractCodigoResponsabilidadEstad {

	
	private static final long serialVersionUID = 1644665924568704089L;

	public CodigoResponsabilidadEstad() {
		super();
	}
	
	private static CodigoResponsabilidadEstadServiceInterfase codigoResponsabilidadEstadService;

	public static CodigoResponsabilidadEstadServiceInterfase getCodigoResponsabilidadEstadService() {
		if (CodigoResponsabilidadEstad.codigoResponsabilidadEstadService == null) {
			CodigoResponsabilidadEstad.codigoResponsabilidadEstadService = JMSIICAServerServiceSingleton.getInstance().getCodigoResponsabilidadEstadService(); 
		}
		return CodigoResponsabilidadEstad.codigoResponsabilidadEstadService;
	}

	
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}
	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Numero Reporte,numeroReporte",
				"Poliza,numeroPoliza", "Inciso,numeroInciso", "Fecha Ocurrido,fechaOcurrido",
				"Codigo-Causa,codigoCausa","Estado,estado","Municipio,municipio",
				"Clave Ajustador,claveAjustador","Nombre Ajustador,nombreAjustador",
				"Codigo Responsabilidad,codigoResponsabilidad","Codigo Matriz,codigoMatriz",
				"Codigo Responsabilidad DUA,codigoResponsabilidadDUA","Folio Orden EDUA,folioEDUA"}).getLista();
	}


//	@Override
//	public JMResultadoOperacion eliminarObjeto() {
//		try {
//			return CodigoResponsabilidadEstad.codigoResponsabilidadEstadService.e
//		}  catch (NoResultException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
//			return new JMResultadoOperacion(e);
//		} catch ( PersistenceException | DatabaseException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
//			return new JMResultadoOperacion(e);
//		} catch ( DataAccessException e) {
//			return new JMResultadoOperacion(e);
//		} 
//	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad#guardarObjeto
	 * ()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CodigoResponsabilidadEstad.codigoResponsabilidadEstadService.guardarObjeto(this);
		}catch (NoResultException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
			return new JMResultadoOperacion(e);
		} catch ( PersistenceException | DatabaseException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
			return new JMResultadoOperacion(e);
		} catch ( DataAccessException e) {
			return new JMResultadoOperacion(e);
		} 
	}

}
