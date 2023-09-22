package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.eclipse.persistence.exceptions.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.TransactionSystemException;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.ExpedienteEjecutivo;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractExpedienteEjecutivo_;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjetoQuinto;
import com.aaq.col.clases.database.entidades.pojo.ErrorFormatos;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ExpedienteEjecutivoDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.ReporteMovilSacDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@org.springframework.stereotype.Repository(value = "expedienteEjecutivoDao")
public class ExpedienteEjecutivoDao extends SIICAServerGenericDaoJpaImpl<ExpedienteEjecutivo> implements ExpedienteEjecutivoDaoInterfase{


	private final Log4JLogger logTiempos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.tiempos");

	@Autowired
	ReporteMovilSacDaoInterfase reporteMovilSacDao;
	
	@Override
	public ExpedienteEjecutivo objetoExpediente(String id, String nombreFormato, String reporte) {
		try {
			long startTime = System.currentTimeMillis();
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<ExpedienteEjecutivo> query = builder.createQuery(ExpedienteEjecutivo.class);
		final Root<ExpedienteEjecutivo> root = query.from(ExpedienteEjecutivo.class);
		query.select(root);
		final List<Predicate> predicates = new ArrayList<>();
		predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.id), id));
		if (StringUtils.isNotBlank(nombreFormato)) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.nombreExpediente), nombreFormato));	
		}
		if (StringUtils.isNotBlank(reporte)) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.reporte), reporte ));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.desc(root.get(AbstractExpedienteEjecutivo_.fecha)));
		final TypedQuery<ExpedienteEjecutivo> typedQ = this.getEntityManager().createQuery(query);
		final List<ExpedienteEjecutivo> l = typedQ.getResultList();
		
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TIEMPO EN CREAR Y CONSULTAR QUERY PARA funcionSeleccionaByIdFormato --> "+endTime+" ms.");
		this.logTiempos.info("listaDeExpedientesNoEnviado QUERY => "+typedQ.toString());
		
		if ((l != null) && (l.size() > 0)) {
			return l.get(0);
		}
		} catch (final NoResultException | ClassCastException | IllegalArgumentException | IllegalStateException
			| RollbackException | TransactionRequiredException	e) {
			this.documentarExcepcionParaMetodo(e, "objetoExpediente", id);
			return null;
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoExpediente", id);
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoExpediente", id);
		}
		return null;
	}

	@Override
	public List<ExpedienteEjecutivo> listaDeExpedientesNoEnviado(Estado edo, Integer base, Integer terminal, 
			Date fechaInicio, Date fechaFin, String reporte, String nombreFormato, Boolean noSftp, Boolean noEmail,
			Boolean sftp, Boolean email) {
		if ((fechaInicio == null) || (fechaFin == null)) {
			return new Vector<>();
		}
		this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeExpedientesNoEnviado");
		long startTime = System.currentTimeMillis();
		try {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<ExpedienteEjecutivo> query = builder.createQuery(ExpedienteEjecutivo.class);
		final Root<ExpedienteEjecutivo> root = query.from(ExpedienteEjecutivo.class);
		query.select(root);
		
		final List<Predicate> predicates = new ArrayList<>();

		 predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.esAjusteExpres), Boolean.FALSE));

		Date dateInicio = null;
		Date dateFin = null;
		
			HoraConsultaUtil utileria = new HoraConsultaUtil();
			try {
				dateInicio = utileria.formatInicial(fechaInicio);
				dateFin = utileria.formatFinal(fechaFin);
			} catch (Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeExpedientesNoEnviado");
			}
			
			
		predicates.add(builder.between(root.get(AbstractExpedienteEjecutivo_.fecha), dateInicio,
				DateUtils.ceiling(dateFin, Calendar.DATE)));
		
		if (edo != null) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.estado), edo));
		}
		
		if (base != null ) {
			if (base != -999 && base > 0) {
				predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.base), base));
			}
		}
		if (noSftp) {
			 predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.sftp), Boolean.FALSE));
		}
		if (noEmail) {
			 predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.correo), Boolean.FALSE));
		}
		if (sftp) {
			 predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.sftp), Boolean.TRUE));
		}
		if (email) {
			 predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.correo), Boolean.TRUE));
		}
		
		 if (reporte != null) {
			 if (StringUtils.isNotBlank(reporte)) {
			 try {
				 if (reporte.trim() != null && reporte.trim() != "") {
				 predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.reporte), reporte));
				 }
			 } catch (Exception e) {
				 this.documentarExcepcionParaMetodo(e, "listaDeExpedientesNoEnviado");
			}
			 }
		}
		
		if (terminal != null) {
			if (terminal != -999 && terminal > 0) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.terminal), terminal));
			}
		}
		if (nombreFormato != null) {
			 if ( !nombreFormato.contains("todos")) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.nombreExpediente), nombreFormato));
			 }
		}

		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.desc(root.get(AbstractExpedienteEjecutivo_.fecha)));
		final TypedQuery<ExpedienteEjecutivo> typedQ = this.getEntityManager().createQuery(query);
		 List<ExpedienteEjecutivo> resp = typedQ.getResultList();
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeExpedientesNoEnviado --> "+endTime+" ms.");
		this.logTiempos.info("listaDeExpedientesNoEnviado QUERY => "+typedQ.toString());
		return resp;
	} catch (final Exception e) {
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeExpedientesNoEnviado (EXCEPTION) --> "+endTime+" ms.");
		this.documentarExcepcionParaMetodo(e, "listaDeExpedientesNoEnviado");
	}
	
	return new Vector<>();
	}

	@Override
	public JMResultadoOperacion funcionExpedienteError(ErrorFormatos datos) {
		if (datos.getTerm() == null) {
			return new JMResultadoOperacion(new Exception("Terminal Nula"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"SP_EXPEDIENTE_EJECUTIVO_DIGITAL");

					 nat.registerStoredProcedureParameter("IN_REPORTE", String.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_CLAVE_PROVEEDOR", String.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_NOMBRE_EXPEDIENTE", String.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_SFTP", String.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_CORREO", String.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_RECLAMACION_PEND", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_ENCUESTA", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_ASISTENCIA_VIAL", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_NUEVO_VEH", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_PASE_MED", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_ASIG_ABOG", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_VALE_AMBUL", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_ORDEN_SERV", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_REPARACION_BIENES", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_GARANTIA_PRENDARIA", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_DECLARACION_U", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_INVENTARIO_AUTO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_CUESTIONARIO_ROBO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_ADMISION_AUTO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_ADMISION_MOTO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_ADMISION_PESADO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_INSPECCION_PESADO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_INSPECCION_MOTO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_RECIBO_ING_SINI", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_RECIBO_PAGO_DED", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_SOLICITUD_DIAG", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_MEMORIA_DESC", Integer.class, ParameterMode.IN);
                     nat.registerStoredProcedureParameter("IN_ID_F_CARGO_TARJETA", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_ESTADO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_BASE", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_CAUSA", String.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_RESPO_CIVIL_CONTRAC", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_ORDEN_BIENES_DIV", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_TERMINAL", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_FOLIO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_OBSERVACION_ASEG", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_INVENTARIO_UNICO_PESADO", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ID_F_RECLAM_SIN_COMPR_PEAJE", Integer.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_ES_AJUSTE_EXPRES", String.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_MENSAJE_SFTP", String.class, ParameterMode.IN);
					 nat.registerStoredProcedureParameter("IN_MENSAJE_MAIL", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("OUT_RESPUESTA", String.class, ParameterMode.OUT);

			 nat.setParameter("IN_REPORTE", datos.getReporte());
			 nat.setParameter("IN_CLAVE_PROVEEDOR", datos.getTerm().getNumeroproveedor());
			 nat.setParameter("IN_NOMBRE_EXPEDIENTE", datos.getNombreExpediente());
			 nat.setParameter("IN_SFTP", datos.isSftp() ? "t" : "f"); // booleano
			 nat.setParameter("IN_CORREO", datos.isCorreo() ? "t" : "f"); // booleano
			 nat.setParameter("IN_ID_F_RECLAMACION_PEND", datos.getIdFReclamacionPend() );
			 nat.setParameter("IN_ID_F_ENCUESTA", datos.getIdFEncuesta());
			 nat.setParameter("IN_ID_F_ASISTENCIA_VIAL", datos.getIdFAsistenciaVial() );
			 nat.setParameter("IN_ID_F_NUEVO_VEH", datos.getIdFNuevoVehi() );
			 nat.setParameter("IN_ID_F_PASE_MED", datos.getIdFPaseMedico() );
			 nat.setParameter("IN_ID_F_ASIG_ABOG",  datos.getIdFAsignacionAbog());
			 nat.setParameter("IN_ID_F_VALE_AMBUL", datos.getIdFValeAmbulancia());
			 nat.setParameter("IN_ID_F_ORDEN_SERV", datos.getIdFOrdenServicio());
			 nat.setParameter("IN_ID_F_REPARACION_BIENES", datos.getIdFReparacionBie() );
			 nat.setParameter("IN_ID_F_GARANTIA_PRENDARIA", datos.getIdFGarantiaPrend());
			 nat.setParameter("IN_ID_F_DECLARACION_U", datos.getIdFDeclaracionU());
			 nat.setParameter("IN_ID_F_INVENTARIO_AUTO", datos.getIdFInventarioAuto() );
			 nat.setParameter("IN_ID_F_CUESTIONARIO_ROBO", datos.getIdFCuestionarioRob() );
			 nat.setParameter("IN_ID_F_ADMISION_AUTO", datos.getIdFAdmisionAuto());
			 nat.setParameter("IN_ID_F_ADMISION_MOTO", datos.getIdFAdmisionMoto() );
			 nat.setParameter("IN_ID_F_ADMISION_PESADO", datos.getIdFAdmisionPesado() );
			 nat.setParameter("IN_ID_F_INSPECCION_PESADO", datos.getIdFInspeccionPes());
			 nat.setParameter("IN_ID_F_INSPECCION_MOTO", datos.getIdFInspeccionMoto() );
			 nat.setParameter("IN_ID_F_RECIBO_ING_SINI",datos.getIdFReciboIngSini() );
			 nat.setParameter("IN_ID_F_RECIBO_PAGO_DED", datos.getIdFReciboPagoDed());
			 nat.setParameter("IN_ID_F_SOLICITUD_DIAG", datos.getIdFSolicitudDiag() );
			 nat.setParameter("IN_ID_F_MEMORIA_DESC", datos.getIdFMemoriaDesc() );
             nat.setParameter("IN_ID_F_CARGO_TARJETA", datos.getIdFCargoTarjeta());
			 nat.setParameter("IN_ID_ESTADO", datos.getTerm().getEstado() != null ? datos.getTerm().getEstado().getId() : null );
			 nat.setParameter("IN_ID_BASE",  datos.getTerm().getBase() != null ? datos.getTerm().getBase().getId() : null);			
			 nat.setParameter("IN_CAUSA", this.obtenerCausa(datos.getReporte()));
			 nat.setParameter("IN_ID_F_RESPO_CIVIL_CONTRAC", datos.getIdFRespoCivilContract());
			 nat.setParameter("IN_ID_F_ORDEN_BIENES_DIV", datos.getIdFOrdenBienesDiv());
			 nat.setParameter("IN_ID_TERMINAL", datos.getTerm() != null ? datos.getTerm().getId() : null);
			 nat.setParameter("IN_FOLIO", datos.getFolio());
			 nat.setParameter("IN_ID_F_OBSERVACION_ASEG", datos.getIdFObservacionAseg());
			 nat.setParameter("IN_ID_F_INVENTARIO_UNICO_PESADO", datos.getIdFInventarioUnicPesado());
			 nat.setParameter("IN_ID_F_RECLAM_SIN_COMPR_PEAJE", datos.getIdFReclamacionComprobPeaje());
			 nat.setParameter("IN_ES_AJUSTE_EXPRES", datos.isEsAjusteExpres() ? "t" : "f"); // booleano
			 nat.setParameter("IN_MENSAJE_SFTP", datos.getMensajeErrorSftp());
			 nat.setParameter("IN_MENSAJE_MAIL", datos.getMensajeErrorMail());;
			 
			 
			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("OUT_RESPUESTA"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "funcionExpedienteError", datos.getTerm(), datos.getReporte(),
					datos.getNombreExpediente(), datos.getTerm().getNumeroproveedor());
			return new JMResultadoOperacion(e);
		}
	}
	
	@SuppressWarnings("unused")
	@Override
	public ExpedienteEjecutivo funcionSeleccionaByIdFormato(int id) {
		Integer value = new Integer(id);
		if (value == null) {
		return null;
		}
		try {
			long startTime = System.currentTimeMillis();
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<ExpedienteEjecutivo> query = builder.createQuery(ExpedienteEjecutivo.class);
		final Root<ExpedienteEjecutivo> root = query.from(ExpedienteEjecutivo.class);
		query.select(root);
		final List<Predicate> predicates = new ArrayList<>();
	
		predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.idFDeclaracionU), id));
	
		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.asc(root.get(AbstractExpedienteEjecutivo_.id)));
		final TypedQuery<ExpedienteEjecutivo> typedQ = this.getEntityManager().createQuery(query);
		final List<ExpedienteEjecutivo> l = typedQ.getResultList();
		
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TIEMPO EN CREAR Y CONSULTAR QUERY PARA funcionSeleccionaByIdFormato --> "+endTime+" ms.");
		this.logTiempos.info("listaDeExpedientesNoEnviado QUERY => "+typedQ.toString());
		
		if ((l != null) && (l.size() > 0)) {
			return l.get(0);
		}
		} catch (final NoResultException | ClassCastException | IllegalArgumentException | IllegalStateException
			| RollbackException | TransactionRequiredException	e) {
			this.documentarExcepcionParaMetodo(e, "funcionSeleccionaByIdFormato", id);
			return null;
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "funcionSeleccionaByIdFormato", id);
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "funcionSeleccionaByIdFormato", id);
		}
		return null;
	}

	private String obtenerCausa(String reporte) {
		ReporteMovilSac reporteMovilSac = null;
		try {
			if (reporte != null) {
			 reporteMovilSac = reporteMovilSacDao.objetoReporteMovilSac(reporte, null);
				 if (reporteMovilSac != null) {
					return reporteMovilSac.getAjusteCodigoCausa();
				}
			}
		} catch (DataAccessException | RollbackException | NoResultException |
				ClassCastException | NonUniqueResultException | IllegalStateException e ) {
			this.documentarExcepcionParaMetodo(e, "obtenerCausa", reporte);
		} catch (PersistenceException | IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "obtenerCausa", reporte);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public  List<EntidadObjeto> obtenerContador(String reporte) {
	
	try {
	
		final StringBuilder query = new StringBuilder(
				"SELECT SUM(CASE WHEN CORREO='f'  THEN 1 ELSE 0 END) AS CORREOCONT, ");
		query.append("SUM (CASE WHEN SFTP='f' THEN 1 ELSE 0 END) AS QCONTENTCONT  ");
		query.append("FROM EXPEDIENTE_EJECUTIVO WHERE REPORTE='"+reporte+"' AND ES_AJUSTE_EXPRES ='f' ");
		query.append(" GROUP BY 2 ");
		return procesarResultadoEntidadObjetoSIICA( this.getEntityManager().createNativeQuery(query.toString()).getResultList());
	} catch (final Exception e) {
		this.documentarExcepcionParaMetodo(e, "obtenerContador", reporte);
	}
	return null;
	}
	
	
	public List<EntidadObjeto> procesarResultadoEntidadObjetoSIICA(final List<Object[]> lista) {
        final List<EntidadObjeto> l = new Vector<EntidadObjeto>();
        if (lista != null && lista.size() > 0) {
            for (final Object obj : lista) {
                final Object[] o = (Object[])obj;
                l.add(new EntidadObjeto(o));
            }
        }
        return l;
    }

	@Override
	public JMResultadoOperacion ejecutarFuncionTableroEjecutivo(Terminal term, String nombreFormato, String claveProveedor,
			String reporte, Integer folio, boolean esAjusteExpres) {

		if (term == null) {
			return new JMResultadoOperacion(new Exception("Terminal Nula"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"SP_TABLERO_EXPEDIENTE_EJECUTIVO");

			nat.registerStoredProcedureParameter("IN_ID_TERMINAL", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_NOMBRE_FORMATO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_CLAVE_PROV", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_REPORTE", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_ID_ESTADO", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_ID_BASE", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_FOLIO", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_CAUSA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_ES_AJUSTE_EXPRES", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("OUT_RESPUESTA", String.class, ParameterMode.OUT);

			nat.setParameter("IN_ID_TERMINAL", term.getId());
			nat.setParameter("IN_NOMBRE_FORMATO", nombreFormato);
			nat.setParameter("IN_CLAVE_PROV", claveProveedor);
			nat.setParameter("IN_REPORTE", reporte);
			nat.setParameter("IN_ID_ESTADO",  term.getEstado() != null ? term.getEstado().getId() : null);
			nat.setParameter("IN_ID_BASE", term.getBase() != null ? term.getBase().getId() : null);
			nat.setParameter("IN_CAUSA", this.obtenerCausa(reporte));
			nat.setParameter("IN_FOLIO", folio);
			nat.setParameter("IN_ES_AJUSTE_EXPRES", esAjusteExpres ? "t" : "f");
			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("OUT_RESPUESTA"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTableroEjecutivo", term, reporte,
					nombreFormato, claveProveedor);
			return new JMResultadoOperacion(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadObjeto> listaDeFormatosParaGrafica(Date fechaInicial, Date fechaFinal, Integer limite, Integer edo, Integer  base,
			String claveAjustador, String nombreFormato, Integer terminal, String reporte) {
		if(fechaInicial == null && fechaFinal == null ) {
			return new Vector<>();
		}
		try { 
				final StringBuilder query = new StringBuilder(
						"select NOMBRE_EXPEDIENTE, count(*) from EXPEDIENTE_EJECUTIVO");
					query.append(" where NOMBRE_EXPEDIENTE is not NULL AND SFTP='t' AND ES_AJUSTE_EXPRES ='f' ");
					
						 if (edo != null ) {
								query.append(" AND ID_ESTADO = '"+edo+"'");
							 }
						 
						 if (base != null ) {
							 if (base != -999 && base > 0) {
							query.append(" AND ID_BASE = '"+base+"'");
							 }
						 }
						 
						 if (terminal != null) {
							 if (terminal != -999 && terminal > 0) {
							 query.append(" AND ID_TERMINAL = '"+terminal+"'");
							 }
						}
						 
						 if (nombreFormato != null) {
							 if ( !nombreFormato.contains("todos")) {
								 query.append(" AND NOMBRE_EXPEDIENTE = '"+nombreFormato+"'");
							}
						}
						 
						 if (StringUtils.isNotBlank(reporte)) {
							 try {
								 if (reporte.trim() != null && reporte.trim() != "") {
									 query.append(" AND REPORTE = '"+reporte+"'");
								 }
							 } catch (ClassCastException | IndexOutOfBoundsException | NoResultException | RollbackException e) {
								 this.documentarExcepcionParaMetodo(e, "listaDeExpedientesNoEnviado");
							}
							 }
						 
					query.append(" AND EXPEDIENTE_EJECUTIVO.FECHA  BETWEEN ");
					query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
					query.append(" AND ");
					query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
					query.append(" group by NOMBRE_EXPEDIENTE order by NOMBRE_EXPEDIENTE");
					return procesarResultadoEntidadObjetoSIICA(this.getEntityManager().createNativeQuery(query.toString()).getResultList());

		} catch (ClassCastException | IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException |
				RollbackException | NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatosParaGrafica");
		} catch (PersistenceException  e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatosParaGrafica");
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatosParaGrafica");
		}
		 return new Vector<>();
	}
	
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public  List<EntidadObjetoQuinto> obtenerContadorTotal(Date fechaInicial, Date fechaFinal, Integer edo, Integer  base,
			 String nombreFormato, Terminal terminal, String reporte) {
	try {
		final StringBuilder query = new StringBuilder("SELECT ");
		query.append("SUM(CASE WHEN CORREO='t' THEN 1 ELSE 0 END) AS CORREOCONTEXITO, ");
		query.append("SUM (CASE WHEN SFTP='t' THEN 1 ELSE 0 END) AS QCONTENTCONTEXITO,  ");
		query.append("SUM (CASE WHEN CORREO='f' THEN 1 ELSE 0 END) AS CORREOCONTERROR,  ");
		query.append("SUM (CASE WHEN SFTP='f' THEN 1 ELSE 0 END) AS QCONTENTCONTERROR, ");
		query.append("COUNT(DISTINCT reporte) AS TOTALREPORTES ");
		query.append("FROM EXPEDIENTE_EJECUTIVO WHERE NOMBRE_EXPEDIENTE IS NOT NULL AND  ES_AJUSTE_EXPRES='f'  ");
		 if (edo != null ) {
				query.append(" AND ID_ESTADO = '"+edo+"'");
			 }
		 if (base != null ) {
			query.append(" AND ID_BASE = '"+base+"'");
		 }
		 if (terminal != null) {
			 query.append(" AND ID_TERMINAL = '"+terminal.getId()+"'");
		}
		 if (nombreFormato != null) {
			 if ( !nombreFormato.contains("todos")) {
				 query.append(" AND NOMBRE_EXPEDIENTE = '"+nombreFormato+"'");
			}
		}
		if (StringUtils.isNotBlank(reporte)) {
			try {
			 if (reporte.trim() != null && reporte.trim() != "") {
				 query.append(" AND REPORTE = '"+reporte+"'");
			 }
		 } catch (ClassCastException | IndexOutOfBoundsException | NoResultException | RollbackException e) {
			 this.documentarExcepcionParaMetodo(e, "listaDeExpedientesNoEnviado");
		}
		 }
	query.append(" AND EXPEDIENTE_EJECUTIVO.FECHA  BETWEEN ");
	query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
	query.append(" AND ");
	query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
	query.append(" GROUP BY 4 ");
 return procesarResultadoQuinto( this.getEntityManager().createNativeQuery(query.toString()).getResultList());
	} catch (final Exception e) {
		this.documentarExcepcionParaMetodo(e, "obtenerContador", reporte);
	}
	return null;
	}
	
	public List<EntidadObjetoQuinto> procesarResultadoQuinto(final List<Object[]> lista) {
        final List<EntidadObjetoQuinto> l = new Vector<EntidadObjetoQuinto>();
        if (lista != null && lista.size() > 0) {
            for (final Object obj : lista) {
                final Object[] o = (Object[])obj;
                l.add(new EntidadObjetoQuinto(o));
            }
        }
        return l;
    }
	
	@Override
	public List<ExpedienteEjecutivo> listaDocumentos(String reporte, String claveAjustador) {
	  try {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<ExpedienteEjecutivo> query = builder.createQuery(ExpedienteEjecutivo.class);
		final Root<ExpedienteEjecutivo> root = query.from(ExpedienteEjecutivo.class);
		query.select(root);
		final List<Predicate> predicates = new ArrayList<>();
		
		if (reporte != null) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.reporte), reporte));
		}
		if (StringUtils.isNotBlank(claveAjustador)) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.claveProveedor), claveAjustador));
		}
		
		predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.correo), true));
		predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.sftp), true));
		predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.esAjusteExpres), false));

		
		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.desc(root.get(AbstractExpedienteEjecutivo_.id)));
		final TypedQuery<ExpedienteEjecutivo> typedQ = this.getEntityManager().createQuery(query);
		
			return typedQ.getResultList();
		} catch (final IllegalArgumentException | NoResultException | ClassCastException |
				DataAccessException | NonUniqueResultException | RollbackException | TransactionSystemException e) {
			this.documentarExcepcionParaMetodo(e, "listaDocumentos", reporte, claveAjustador);
		} catch (final PersistenceException | TransactionException e) {
			this.documentarExcepcionParaMetodo(e, "listaDocumentos", reporte, claveAjustador);
		}
		return new Vector<>();
	}
	

	@Override
	public List<ExpedienteEjecutivo> listaDeExpedientesExcel(Estado edo, Integer base, Integer terminal, 
			Date fechaInicio, Date fechaFin, String reporte, String nombreFormato) {
		
		if ((fechaInicio == null) || (fechaFin == null)) {
			return new Vector<>();
		}
		this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeExpedientesExcel");
		long startTime = System.currentTimeMillis();
		
		try {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<ExpedienteEjecutivo> query = builder.createQuery(ExpedienteEjecutivo.class);
		final Root<ExpedienteEjecutivo> root = query.from(ExpedienteEjecutivo.class);
		query.select(root);
		
		final List<Predicate> predicates = new ArrayList<>();

		predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.esAjusteExpres), false));

		Date dateInicio = null;
		Date dateFin = null;
		
			HoraConsultaUtil utileria = new HoraConsultaUtil();
			try {
				dateInicio = utileria.formatInicial(fechaInicio);
				dateFin = utileria.formatFinal(fechaFin);
			} catch (Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeExpedientesExcel");
			}
			
		predicates.add(builder.between(root.get(AbstractExpedienteEjecutivo_.fecha), dateInicio,
				DateUtils.ceiling(dateFin, Calendar.DATE)));
		
		if (edo != null) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.estado), edo));
		}
		
		if (base != null ) {
			if (base != -999 && base > 0) {
				predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.base), base));
			}
		}
		
		predicates.add(builder.or(builder.equal(root.get(AbstractExpedienteEjecutivo_.sftp), Boolean.FALSE),
				builder.equal(root.get(AbstractExpedienteEjecutivo_.correo), Boolean.FALSE)));
		
		 if (reporte != null) {
			 if (StringUtils.isNotBlank(reporte)) {
			 try {
				 if (reporte.trim() != null && reporte.trim() != "") {
				 predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.reporte), reporte));
				 }
			 } catch (Exception e) {
				 this.documentarExcepcionParaMetodo(e, "listaDeExpedientesExcel");
			}
			 }
		}
		
		if (terminal != null) {
			if (terminal != -999 && terminal > 0) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.terminal), terminal));
			}
		}
		if (nombreFormato != null) {
			 if ( !nombreFormato.contains("todos")) {
			predicates.add(builder.equal(root.get(AbstractExpedienteEjecutivo_.nombreExpediente), nombreFormato));
			 }
		}

		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.desc(root.get(AbstractExpedienteEjecutivo_.fecha)));
		final TypedQuery<ExpedienteEjecutivo> typedQ = this.getEntityManager().createQuery(query);
		
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeExpedientesExcel --> "+endTime);
		return typedQ.getResultList();
	} catch (final Exception e) {
		this.documentarExcepcionParaMetodo(e, "listaDeExpedientesExcel");
	}
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeExpedientesExcel --> "+endTime);
			
	return new Vector<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadObjeto> docEnviado(String nombreFormato, Terminal terminal, String reporte) {
		try { 
			final StringBuilder query = new StringBuilder(
					"select NOMBRE_EXPEDIENTE, count(*) from EXPEDIENTE_EJECUTIVO");
				query.append(" where NOMBRE_EXPEDIENTE is not NULL AND SFTP='t' and ES_AJUSTE_EXPRES='f' " );
				if (terminal != null) {
					query.append(" AND ID_TERMINAL = '"+terminal.getId()+"'");
				}
				if (nombreFormato != null) {
					 query.append(" AND NOMBRE_EXPEDIENTE = '"+nombreFormato+"'");
				}
				if (StringUtils.isNotBlank(reporte)) {
				 try {
					 if (reporte.trim() != null && reporte.trim() != "") {
						query.append(" AND REPORTE = '"+reporte+"'");
						 }
					} catch (ClassCastException | IndexOutOfBoundsException | NoResultException | RollbackException e) {
					 this.documentarExcepcionParaMetodo(e, "docEnviado");
			 	}
			}
			query.append(" group by NOMBRE_EXPEDIENTE order by NOMBRE_EXPEDIENTE");
		return procesarResultadoEntidadObjetoSIICA(this.getEntityManager().createNativeQuery(query.toString()).getResultList());
	} catch (ClassCastException | IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException |
			RollbackException | NoResultException e) {
		this.documentarExcepcionParaMetodo(e, "docEnviado");
	} catch (PersistenceException | DataAccessException  e) {
		this.documentarExcepcionParaMetodo(e, "docEnviado");
	} 
	 return new Vector<>();
	}

	
}
