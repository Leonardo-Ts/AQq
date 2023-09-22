package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminal_;
import com.aaq.col.clases.database.entidades.pojo.EstadisticaMonitorDataModel;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TerminalDaoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;


@org.springframework.stereotype.Repository(value = "terminalDao")
public class TerminalDao extends SIICAServerGenericDaoJpaImpl<Terminal> implements TerminalDaoInterfase {

	private final Log4JLogger logTiempos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.tiempos");

	/** orden **/
	public static String ordenCatalogoTerminal = "ordenCatalogoTerminal";

	/** orden **/
	public static String ordenAlarma = "ordenAlarma";

	/** orden **/
	public static String ordenWS = "ordenWS";

	/** filtro **/
	public static String filtroAlarmaDisponible = "filtroAlarmaDisponible";

	/** filtro **/
	public static String filtroAlarmaOcupado = "filtroAlarmaOcupado";

	/** filtro **/
	public static String filtroAlarmaDesconectado = "filtroAlarmaDesconectado";

	/** filtro **/
	public static String filtroAlarmaSinArribo = "filtroAlarmaSinArribo";

	/** filtro **/
	public static String filtroAlarmaSinTermino = "filtroAlarmaSinTermino";

	/** filtro **/
	public static String filtroAlarmaProximidad = "filtroAlarmaProximidad";

	/** filtro **/
	public static String filtroAlarmaForaneo = "filtroAlarmaForaneo";
	
	/** filtro **/
	public static String filtroAvqReporte = "filtroAvqReporte";
	
	/** filtro **/
	public static String filtroSinPosicionActual = "filtroSinPosicionActual";
	
	@SuppressWarnings("unused")
	private Boolean reporteExiste = true;

	@Override
	public Terminal objetoTerminal(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Terminal.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminal", id);
		}
		return null;
	}

	@Override
	public Terminal objetoTerminalParaNumeroProveedor(final Estado estado, final String numeroProveedor) {
		return this.objetoTerminalParaParametros(estado, null, null, numeroProveedor, null, null, null, null);
	}

	@Override
	public Terminal objetoTerminalParaNumeroRadio(final Estado estado, final String numeroRadio) {
		return this.objetoTerminalParaParametros(estado, null, numeroRadio, null, null, null, null, null);
	}

	@Override
	public Terminal objetoTerminalParaNumeroReporte(final String numeroReporte) {
		return this.objetoTerminalParaParametros(null, null, null, null, null, numeroReporte, null, null);
	}

	@Override
	public Terminal objetoTerminalParaNumeroTelefono(final String numeroTelefono) {
		return this.objetoTerminalParaParametros(null, null, null, null, null, null, numeroTelefono, null);
	}

	@Override
	public Terminal objetoTerminalParaProveedorYPasswd(final String numeroProveedor, final String passwd) {
		return this.objetoTerminalParaParametros(null, null, null, numeroProveedor, passwd, null, null, null);
	}

	@Override
	public Terminal objetoTerminalParaDispositivoNombre(final String dispositivoNombre) {
		return this.objetoTerminalParaParametros(null, null, null, null, null, null, null, dispositivoNombre);
	}

	@Override
	public Terminal objetoTerminalParaParametros(final Estado estado, final String numeroTerminal,
			final String numeroRadio, final String numeroProveedor, final String passwd, final String numeroReporte,
			final String numeroTelefono, final String dispositivoNombre) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Terminal> query = builder.createQuery(Terminal.class);
			final Root<Terminal> root = query.from(Terminal.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminal_.habilitado), Boolean.TRUE));

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.estado), estado));
			}

			if (StringUtils.isNotBlank(dispositivoNombre)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.dispositivoNombre), dispositivoNombre));
			}

			if (StringUtils.isNotBlank(numeroTerminal)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.numeroproveedor), numeroTerminal));
			}

			if (StringUtils.isNotBlank(numeroRadio)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.numeroradio), numeroRadio));
			}

			if (StringUtils.isNotBlank(numeroProveedor)) {
				predicates.add(builder.or(
						builder.equal(root.get(AbstractTerminal_.numeroproveedor), numeroProveedor),
						builder.equal(root.get(AbstractTerminal_.numeroproveedor),
								JMUtileriaString.rellenarConCaracter(numeroProveedor, "0", 5))

				));
			}
			if (StringUtils.isNotBlank(passwd)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.passwd), passwd));
			}
			if (StringUtils.isNotBlank(numeroReporte)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.ultimoLocalizacionReporte), numeroReporte));
			}
			if (StringUtils.isNotBlank(numeroTelefono)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.telefono), numeroTelefono));
			}


			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractTerminal_.id)));
			final TypedQuery<Terminal> typedQ = this.getEntityManager().createQuery(query);
			final List<Terminal> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminal");
		}
		return null;
	}

//	@Override
//	public List<Terminal> listaDeTerminalParaCoordenadas(final String latitud, final String longitud) {
//		if (StringUtils.isBlank(latitud) || StringUtils.isBlank(longitud)) {
//			return null;
//		}
//
//		try {
//			final StrBuilder sql = new StrBuilder(
//					"SELECT * FROM terminal WHERE mostrar_en_cercania ='t' AND habilitado='t' AND LATITUD IS NOT NULL AND LONGITUD IS NOT NULL AND LATITUD<>'0' AND LONGITUD<>'0'");
//			sql.append(" AND (is_in_distance(CAST(longitud AS BINARY_DOUBLE),CAST(latitud AS BINARY_DOUBLE),CAST(" + latitud + " AS BINARY_DOUBLE),CAST("
//					+ longitud + " AS BINARY_DOUBLE) )< 200000) ");
//			sql.append(" ORDER BY (is_in_distance(CAST(longitud AS BINARY_DOUBLE),CAST(latitud AS BINARY_DOUBLE),CAST(" + latitud + " AS BINARY_DOUBLE),CAST(" + longitud
//					+ " AS BINARY_DOUBLE))) ASC");
//
//			final Query nat = this.getEntityManager().createNativeQuery(sql.toString(), Terminal.class);
//			return nat.getResultList();
//		} catch (final Exception e) {
//			this.documentarExcepcionParaMetodo(e, "listaDeTerminalParaCoordenadas", latitud, longitud);
//		}
//		return new Vector<>();
//
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Terminal> listaDeTerminalParaCoordenadas(final String latitud, final String longitud, final boolean soloDisponibles) {
		if (StringUtils.isBlank(latitud) || StringUtils.isBlank(longitud)) {
			return null;
		}
		try {
			final StrBuilder sql = new StrBuilder(
					"SELECT * FROM terminal WHERE mostrar_en_cercania ='t' AND habilitado='t' AND LATITUD IS NOT NULL AND LONGITUD IS NOT NULL AND LATITUD<>'0' AND LONGITUD<>'0'");
			if(soloDisponibles) {
				sql.append(" AND (estatus='DISPONIBLE' OR  estatus='Disponible') AND fecha_estatus_disponible IS NOT NULL ");
			}
			sql.append(" AND (is_in_distance(CAST(latitud AS BINARY_DOUBLE),CAST(longitud AS BINARY_DOUBLE),CAST(" + latitud + " AS BINARY_DOUBLE),CAST("
					+ longitud + " AS BINARY_DOUBLE) )< 200000) ");
			sql.append(" ORDER BY (is_in_distance(CAST(latitud AS BINARY_DOUBLE),CAST(longitud AS BINARY_DOUBLE),CAST(" + latitud + " AS BINARY_DOUBLE),CAST(" + longitud
					+ " AS BINARY_DOUBLE))) ASC");
			final Query nat = this.getEntityManager().createNativeQuery(sql.toString(), Terminal.class);
			return nat.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalParaCoordenadas", latitud, longitud);
		}
		return new Vector<>();
		

	}

	@Override
	public List<Terminal> listaDeTerminal() {
		return this.listaDeTerminal(null, null);
	}

	@Override
	public List<Terminal> listaDeTerminal(final Estado estado, final Base base) {
		return this.listaDeTerminal(estado, base, Boolean.FALSE);
	}

	@Override
	public List<Terminal> listaDeTerminal(final Estado estado, final Base base, final Boolean soloValidasEnPosicion) {
		return this.listaDeTerminal(estado, base, soloValidasEnPosicion, Boolean.FALSE);
	}

	@Override
	public List<Terminal> listaDeTerminal(final Estado estado, final Base base, final Boolean soloValidasEnPosicion,
			final Boolean soloValidasEnFecha) {
		return this.listaDeTerminal(estado, base, null, null, null, null, null, null, soloValidasEnPosicion,
				soloValidasEnFecha, null, null, null,null,null,null, null);
	}
	
	@Override
	public List<Terminal> listaDeTerminalSIICAWeb( String  fuente) {
		return this.listaDeTerminal(null, null, null, null, null, null, null, null, false,
				false, null, null, null,null,null,null, fuente);
	}

	@Override
	public List<Terminal> listaDeTerminal(final Estado estado, final Base base, final List<Base> bases,
			final String nombre, final String terminal, final String numeroradio, final String numeroproveedor,
			final String passwd, final Boolean soloValidasEnPosicion, final Boolean soloValidasEnFecha,
			final String orden, final String filtro, final String idPermitido, final String estatus, final Boolean coordenadasDesdeBase, final Boolean coordenadasDesdeServicioWeb, final String fuente) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Terminal> query = builder.createQuery(Terminal.class);
			final Root<Terminal> root = query.from(Terminal.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminal_.habilitado), Boolean.TRUE));

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.estado), estado));
			}

			if (StringUtils.isNotBlank(idPermitido)) {
				predicates.add(root.get(AbstractTerminal_.id).in(JMUtileriaString.listaDeInteger(idPermitido, ",")));
			}
			if ((base != null) && (base.getId().intValue() > 0)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.base), base));
			}
			if ((bases != null) && (bases.size() > 0)) {
				predicates.add(root.get(AbstractTerminal_.base).in(bases));
			}

			if (StringUtils.isNotBlank(nombre)){
				predicates.add(builder.like(builder.upper(root.get(AbstractTerminal_.nombre)),
						"%" + StringUtils.upperCase(nombre) + "%"));
			}

			if (StringUtils.isNotBlank(terminal)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.numeroproveedor), terminal));
			}

			if (StringUtils.isNotBlank(numeroradio)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.numeroradio), numeroradio));
			}

			if (StringUtils.isNotBlank(numeroproveedor)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.numeroproveedor), numeroproveedor));
			}

			if (StringUtils.isNotBlank(passwd)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.passwd), passwd));
			}
			
			if (StringUtils.isNotBlank(fuente)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.fuenteAsignacion), fuente));
			}

			if (BooleanUtils.isTrue(soloValidasEnPosicion)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.latitud)));
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.longitud)));
				predicates.add(builder.equal(root.get(AbstractTerminal_.base).get("habilitadoEnMapa"), Boolean.TRUE));

			}

			if (BooleanUtils.isTrue(soloValidasEnFecha)) {
				predicates.add(builder.greaterThan(root.get(AbstractTerminal_.ultimoLocalizacionFecha),
						new Date(System.currentTimeMillis() - JMUtileriaFecha.TIEMPO_7_DIAS)));
			}

			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaDisponible)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusDisponible)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaOcupado)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusOcupado)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaDesconectado)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusDesconectado)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaSinArribo)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusAsignado)));
				predicates.add(builder.isNull(root.get(AbstractTerminal_.fechaEstatusArribo)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaSinTermino)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusAsignado)));
				predicates.add(builder.isNull(root.get(AbstractTerminal_.fechaEstatusTermino)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaProximidad)) {
//				predicates.add(builder.equal(root.get(AbstractTerminal_.proximidad), Boolean.TRUE));
				predicates.add(builder.equal(root.get(AbstractTerminal_.sacNumeroReporte).get("proximidad"), Boolean.TRUE));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaForaneo)) {
				predicates.add(builder.not(root.get(AbstractTerminal_.base).get("id")
						.in(JMUtileriaString.listaDeInteger("9,14,15,19", ","))));
			}
			
			if (StringUtils.equals(filtro, TerminalDao.filtroAvqReporte)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.reporteSiicaAv), Boolean.TRUE));
			}
			
			if (StringUtils.equals(filtro, TerminalDao.filtroSinPosicionActual)) {
						
					//	(root.get(AbstractTerminal_.ultimoLocalizacionFecha),
					//	new Date(System.currentTimeMillis() - JMUtileriaFecha.TIEMPO_7_DIAS)));
				predicates.add(builder.equal(root.get(AbstractTerminal_.sinPosicionActual), "1"));		
		    }


			if (StringUtils.equals(orden, TerminalDao.ordenAlarma)) {
				query.orderBy(builder.asc(root.get(AbstractTerminal_.fechaEstatusDisponible)),
						builder.asc(root.get(AbstractTerminal_.fechaEstatusOcupado)),
						builder.asc(root.get(AbstractTerminal_.fechaEstatusDesconectado)));
			}
			if (StringUtils.equals(orden, TerminalDao.ordenCatalogoTerminal)) {
				query.orderBy(builder.asc(root.get(AbstractTerminal_.base).get("nombre")),
						builder.asc(root.get(AbstractTerminal_.nombre)));
			}
			if (StringUtils.equals(orden, TerminalDao.ordenWS)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusDisponible)));
				query.orderBy(builder.asc(root.get(AbstractTerminal_.fechaEstatusDisponible)));
			}

			if (BooleanUtils.isTrue(coordenadasDesdeBase)){
				predicates.add(builder.greaterThan(root.get(AbstractTerminal_.base).get("id")
						, 0));
				predicates.add(builder.equal(root.get(AbstractTerminal_.coordenadasDesdeBase),Boolean.TRUE));
			}
			if (BooleanUtils.isTrue(coordenadasDesdeServicioWeb)){
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.unidadSerie)));
				predicates.add(builder.equal(root.get(AbstractTerminal_.coordenadasDesdeServicioWeb),Boolean.TRUE));
			}
			if (StringUtils.isNotBlank(estatus)){
				predicates.add(builder.equal(root.get(AbstractTerminal_.estatus),estatus));
			}

			if (StringUtils.isBlank(orden)) {
				query.orderBy(builder.asc(root.get(AbstractTerminal_.numeroradio)),
						builder.asc(root.get(AbstractTerminal_.numeroproveedor)),
						builder.asc(root.get(AbstractTerminal_.nombre)));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			final TypedQuery<Terminal> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminal");
		}
		return new Vector<>();
	}


	
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatus(final Integer id, final String estatus,
			final String fuenteOperacion, final String fuente, final String numeroProveedor, final String fuenteEstatus) {
		

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Terminal Nulo"));
		}

		if (StringUtils.isBlank(estatus)) {
			return new JMResultadoOperacion(new Exception("Estatus Nulo"));
		}

		try {
//			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery("terminal_estatus1");
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery("TERMINAL_ESTATUS_NUEVO1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_estatus", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_estatus", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);
			nat.setParameter("in_estatus", estatus);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_fuente_estatus", fuenteEstatus);

			nat.execute();
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalEstatus", id, estatus, fuenteOperacion,
					fuente);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusTermino(final Date fecha, final String numeroProveedor,
			final String fuente, final String fuenteOperacion) {

		if (fecha == null) {
			return new JMResultadoOperacion(new Exception("Fecha Nulo"));
		}

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_estatus_termino1");

			nat.registerStoredProcedureParameter("in_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_fecha", fecha);
			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalEstatusTermino", fecha, numeroProveedor,
					fuente, fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusOtros(final String numeroProveedor, final String fuente,
			final String fuenteOperacion) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_estatus_otros1");

			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalEstatusOtros", numeroProveedor, fuente,
					fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusOcupado(final String numeroProveedor,
			final String fuente, final String fuenteOperacion) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_estatus_ocupado1");

			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalEstatusOcupado", numeroProveedor, fuente,
					fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusDisponible(final String numeroProveedor,
			final String fuente, final String fuenteOperacion) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_estatus_disponible1");

			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalEstatusDisponible", numeroProveedor, fuente,
					fuenteOperacion);
			return new JMResultadoOperacion(e.getMessage());
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalCancelarReporte(final Usuario usuario, final String numeroProveedor,
			final String numeroReporte, final String fuente, final String fuenteOperacion) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_cancelar_reporte1");

			nat.registerStoredProcedureParameter("in_id_usuario", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id_usuario", usuario != null ? usuario.getId() : null);
			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_numero_reporte", numeroReporte);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalCancelarReporte", numeroProveedor,
					numeroReporte, fuente, fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalCancelarReporteSac(final Usuario usuario, final String numeroProveedor,
			final String numeroReporte, final String fuente, final String fuenteOperacion) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_cancelar_reporte_sac1");

			nat.registerStoredProcedureParameter("in_id_usuario", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id_usuario", usuario != null ? usuario.getId() : null);
			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_numero_reporte", numeroReporte);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalCancelarReporte", numeroProveedor,
					numeroReporte, fuente, fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusDesconectado(final String numeroProveedor,
			final String fuente, final String fuenteOperacion, final String estatus) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_estatus_desconectado1");

			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_estatus", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);
			nat.setParameter("in_estatus", estatus);
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 
			
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalEstatusDesconectado", numeroProveedor,
					fuente, fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusArribo(final Date fecha, final String numeroProveedor,
			final String fuente, final String fuenteOperacion) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_estatus_arribo1");

			nat.registerStoredProcedureParameter("in_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_fecha", fecha);
			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalEstatusArribo", fecha, numeroProveedor,
					fuente, fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalAsignarReporte(final Usuario usuario, final String numeroProveedor,
			final String numeroReporte, final String fuente, final String fuenteOperacion, final Boolean proximidad) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_asignar_reporte1");
			
			nat.registerStoredProcedureParameter("in_id_usuario", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_proximidad", Boolean.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id_usuario", usuario != null ? usuario.getId() : null);
			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_numero_reporte", numeroReporte);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);
			nat.setParameter("in_proximidad", proximidad);
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalAsignarReporte",usuario, numeroProveedor,
					numeroReporte, fuente, fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalAsignarReporteSac(final Usuario usuario,final String numeroProveedor,
			final String numeroReporte, final String fuente, final String fuenteOperacion) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_asignar_reporte_sac1");
			
			nat.registerStoredProcedureParameter("in_id_usuario", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);
			
			nat.setParameter("in_id_usuario", usuario != null ? usuario.getId() : null);
			nat.setParameter("in_numero_proveedor", numeroProveedor);
			nat.setParameter("in_numero_reporte", numeroReporte);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalAsignarReporteSac", usuario, numeroProveedor,
					numeroReporte, fuente, fuenteOperacion);
			
			if(e.getMessage().contains("no está presente") || e.getMessage().contains("is not present in table")){
				reporteExiste = false;
				return new JMResultadoOperacion(e);
			}else{
				return new JMResultadoOperacion(e);
			}
		}
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalAsignarProximidad(final Integer id, final String fuente,
			final String fuenteOperacion) {

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_asignar_proximidad1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalAsignarProximidad", id, fuente,
					fuenteOperacion);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarCoordenadas(final Integer id,
			final Date ultimoLocalizacionFecha, final String ultimoLocalizacionVelocidad, final String latitud,
			final String longitud, final String direccion) {

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_insertar_coordenadas1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ultimo_localizacion_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ultimo_localizacion_vel", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_latitud", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_longitud", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_direccion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);
			nat.setParameter("in_ultimo_localizacion_fecha", ultimoLocalizacionFecha);
			nat.setParameter("in_ultimo_localizacion_vel", ultimoLocalizacionVelocidad);
			nat.setParameter("in_latitud", latitud);
			nat.setParameter("in_longitud", longitud);
			nat.setParameter("in_direccion", direccion);
			
			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("respuesta"))); 
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalInsertarCoordenadas", id,
					ultimoLocalizacionFecha, ultimoLocalizacionVelocidad, latitud, longitud, direccion);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarUltimoSiniestro(final Integer id, final String siniestro) {

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}
		if (StringUtils.isBlank(siniestro)) {
			return new JMResultadoOperacion(new Exception("Siniestro Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_insert_ult_siniestro1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ult_siniestro_ws", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);
			nat.setParameter("in_ult_siniestro_ws", siniestro);
			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalInsertarUltimoSiniestro", id, siniestro);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaLocalizacion(final Integer id) {

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"TERMINAL_INSERTAR_FECHA_LOCAL1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 
			
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalInsertarFechaLocalizacion", id);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaUltimoLoginDia(final Integer id) {

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_ins_fecha_ult_login1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalInsertarFechaUltimoLoginDia", id);
			return new JMResultadoOperacion(e);
		}

	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarUidAndroid(
			Integer id, String uid) {
		
		if (id == null) {
			return new JMResultadoOperacion(new Exception("Proveedor Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"terminal_insertar_uid_android1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_uid_android", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);
			
			nat.setParameter("in_id", id);
			nat.setParameter("in_uid_android", uid);
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion (String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalInsertarUidAndroid", id, uid);
			return new JMResultadoOperacion(e);
		}
	}
	
	@Override
	public List<Terminal> listaTodoDeTerminal(){
		return this.listaTodoDeTerminal(false);
	}
	
	@Override
	public List<Terminal> listaTodoDeTerminal(Boolean esReporteApartado) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Terminal> query = builder.createQuery(Terminal.class);
			final Root<Terminal> root = query.from(Terminal.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if(esReporteApartado){
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.reporteApartado)));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			final TypedQuery<Terminal> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaTodoDeTerminal");
		}
		return new Vector<>();
	}
	
	@Override
	public EstadisticaMonitorDataModel obtenerEstadisticas(Integer idEntidad,
			Integer idBase) {
		EstadisticaMonitorDataModel estadisticas = null;
		try {
			this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA obtenerEstadisticas");
			long startTime = System.currentTimeMillis();
			
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery("ESTADISTICAS_MONITOR");

			nat.registerStoredProcedureParameter("ID_ENTIDAD", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("ID_BASE", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("AJUS_DISPONIBLES", Integer.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("AJUS_OCUPADOS", Integer.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("AJUS_DESCONECTADOS", Integer.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("REPS_DIA", Integer.class, ParameterMode.OUT);
			
			nat.setParameter("ID_ENTIDAD", idEntidad);
			nat.setParameter("ID_BASE", idBase);
			nat.execute();

			estadisticas = new EstadisticaMonitorDataModel();
			estadisticas.setAjusDesconectados((Integer)(nat.getOutputParameterValue("AJUS_DESCONECTADOS")));
			estadisticas.setAjusDisponibles((Integer)(nat.getOutputParameterValue("AJUS_DISPONIBLES")));
			estadisticas.setAjusOcupados((Integer)(nat.getOutputParameterValue("AJUS_OCUPADOS")));
			estadisticas.setRepsDia((Integer)(nat.getOutputParameterValue("REPS_DIA")));
			
			long endTime = System.currentTimeMillis() - startTime;
			this.logTiempos.info("TERMINA TIEMPO EN CREAR Y CONSULTAR QUERY PARA obtenerEstadisticas--> Tiempo: "+endTime);
			 
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtenerEstadisticas", idEntidad, idBase);			
		}
		 
		  
		return estadisticas;
	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaPush(
			Integer id) {
		if (id == null) {
			return new JMResultadoOperacion(new Exception("ID Terminal Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"TERMINAL_INSERTAR_FECHA_PUSH");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);
			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 
			
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionTerminalInsertarFechaPush", id);
			return new JMResultadoOperacion(e);
		}
	}

	@Override
	public EstadisticaMonitorDataModel obtenerEstadisticasFrecuencia(Integer idEntidad, String idBases){
		EstadisticaMonitorDataModel estadisticas = null;
		try{
			this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA obtenerEstadisticasFrecuencia");
			long startTime = System.currentTimeMillis();
			
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery("ESTADISTICAS_FRECUENCIA");
			
			nat.registerStoredProcedureParameter("ID_ENTIDAD", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("ID_BASES", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("AJUS_DISPONIBLES", Integer.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("AJUS_OCUPADOS", Integer.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("AJUS_DESCONECTADOS", Integer.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("REPS_DIA", Integer.class, ParameterMode.OUT);
			
			nat.setParameter("ID_ENTIDAD", idEntidad);
			nat.setParameter("ID_BASES",	idBases);
			nat.execute();
			
			estadisticas = new EstadisticaMonitorDataModel();
			estadisticas.setAjusDesconectados((Integer)(nat.getOutputParameterValue("AJUS_DESCONECTADOS")));
			estadisticas.setAjusDisponibles((Integer)(nat.getOutputParameterValue("AJUS_DISPONIBLES")));
			estadisticas.setAjusOcupados((Integer)(nat.getOutputParameterValue("AJUS_OCUPADOS")));
			estadisticas.setRepsDia((Integer)(nat.getOutputParameterValue("REPS_DIA")));
			
	long endTime = System.currentTimeMillis() - startTime;
	this.logTiempos.info("TERMINA TIEMPO EN CREAR Y CONSULTAR QUERY PARA obtenerEstadisticasFrecuencia--> Tiempo: "+endTime);
			  
			
		}catch(final Exception e){
			this.documentarExcepcionParaMetodo(e, "obtenerEstadisticasFrecuencia", idEntidad, idBases);
		}
		
		return estadisticas;
	}

	@Override
	public List<Terminal> listarDeAjustadores(final Estado estado, final Base base,  final String estatus) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Terminal> query = builder.createQuery(Terminal.class);
			final Root<Terminal> root = query.from(Terminal.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminal_.habilitado), Boolean.TRUE));

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.estado), estado));
			}
			if ((base != null) && (base.getId().intValue() > 0)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.base), base));
			}

//			if (StringUtils.equals(estatus, TerminalDao.filtroAlarmaDisponible)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusDisponible)));
//			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			final TypedQuery<Terminal> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeAjustadores");
		}
		return new Vector<>();
	}
	
	@Override
	public Terminal obtenerTerminal(final String numeroProveedor, final String passwd ) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Terminal> query = builder.createQuery(Terminal.class);
			final Root<Terminal> root = query.from(Terminal.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminal_.habilitado), Boolean.TRUE));

			if (StringUtils.isNotBlank(numeroProveedor)) {
				predicates.add(builder.or(
						builder.equal(root.get(AbstractTerminal_.numeroproveedor), numeroProveedor),
						builder.equal(root.get(AbstractTerminal_.numeroproveedor),
								JMUtileriaString.rellenarConCaracter(numeroProveedor, "0", 5))

				));
			}
			if (StringUtils.isNotBlank(passwd)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.passwd), passwd));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<Terminal> typedQ = this.getEntityManager().createQuery(query);
			typedQ.setFirstResult(0);
			typedQ.setMaxResults(1);
			
			return typedQ.getSingleResult();
			
		} catch (IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "obtenerTerminal");
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtenerTerminal");
		}
		return null;
	}
	
	@Override
	public JMResultadoOperacion ejecutarIntercambioReporte(String numeroProveedorA, String numeroReporteA,
			String numeroProveedorB, String numeroReporteB, String fuente, String fuenteOperacion) {

		if (StringUtils.isBlank(numeroProveedorA)) {
			return new JMResultadoOperacion(new Exception("Proveedor A Nulo"));
		}
		if (StringUtils.isBlank(numeroProveedorB)) {
			return new JMResultadoOperacion(new Exception("Proveedor B Nulo"));
		}

		if (StringUtils.isBlank(numeroReporteA)) {
			return new JMResultadoOperacion(new Exception("Reporte A Nulo"));
		}
		if (StringUtils.isBlank(numeroReporteB)) {
			return new JMResultadoOperacion(new Exception("Reporte B Nulo"));
		}
		
		try {
			
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"TERMINAL_INTERCAMBIAR_REPORTE");
			
			nat.registerStoredProcedureParameter("in_numero_proveedorA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporteA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_proveedorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporteB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);
			
			nat.setParameter("in_numero_proveedorA", numeroProveedorA);
			nat.setParameter("in_numero_reporteA", numeroReporteA);
			nat.setParameter("in_numero_proveedorB", numeroProveedorB);
			nat.setParameter("in_numero_reporteB", numeroReporteB);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_fuente_operacion", fuenteOperacion);
			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarIntercambioReporte", null, numeroProveedorA,
					numeroReporteA, fuente, fuenteOperacion);
			if(e.getMessage().contains("no está presente") || e.getMessage().contains("is not present in table")){
				reporteExiste = false;
				return new JMResultadoOperacion(e);
			}else{
				return new JMResultadoOperacion(e);
			}
		}

	}
	
	@Override
	public List<Terminal> listaDeTerminalModulo(final Estado estado, final Base base, final List<Base> bases,
			final String nombre, final String terminal, final String numeroradio, final String numeroproveedor,
			final String passwd, final Boolean soloValidasEnPosicion, final Boolean soloValidasEnFecha,
			final String orden, final String filtro, final String idPermitido, final String estatus, final Boolean coordenadasDesdeBase, final Boolean coordenadasDesdeServicioWeb, final String fuente) {
		
		this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeTerminalModulo");
		long startTime = System.currentTimeMillis();
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Terminal> query = builder.createQuery(Terminal.class);
			final Root<Terminal> root = query.from(Terminal.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminal_.habilitado), Boolean.TRUE));

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.estado), estado));
			}

			if (StringUtils.isNotBlank(idPermitido)) {
				predicates.add(root.get(AbstractTerminal_.id).in(JMUtileriaString.listaDeInteger(idPermitido, ",")));
			}
			if ((base != null) && (base.getId().intValue() > 0)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.base), base));
			}
			if ((bases != null) && (bases.size() > 0)) {
				predicates.add(root.get(AbstractTerminal_.base).in(bases));
			}

			if (StringUtils.isNotBlank(nombre)){
				predicates.add(builder.like(builder.upper(root.get(AbstractTerminal_.nombre)),
						"%" + StringUtils.upperCase(nombre) + "%"));
			}

			if (StringUtils.isNotBlank(terminal)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.numeroproveedor), terminal));
			}

			if (StringUtils.isNotBlank(numeroradio)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.numeroradio), numeroradio));
			}

			if (StringUtils.isNotBlank(numeroproveedor)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.numeroproveedor), numeroproveedor));
			}

			if (StringUtils.isNotBlank(passwd)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.passwd), passwd));
			}
			
			if (StringUtils.isNotBlank(fuente)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.fuenteAsignacion), fuente));
			}

			if (BooleanUtils.isTrue(soloValidasEnPosicion)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.latitud)));
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.longitud)));
				predicates.add(builder.equal(root.get(AbstractTerminal_.base).get("habilitadoEnMapa"), Boolean.TRUE));

			}

			if (BooleanUtils.isTrue(soloValidasEnFecha)) {
				predicates.add(builder.greaterThan(root.get(AbstractTerminal_.ultimoLocalizacionFecha),
						new Date(System.currentTimeMillis() - JMUtileriaFecha.TIEMPO_7_DIAS)));
			}

			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaDisponible)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusDisponible)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaOcupado)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusOcupado)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaDesconectado)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusDesconectado)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaSinArribo)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusAsignado)));
				predicates.add(builder.isNull(root.get(AbstractTerminal_.fechaEstatusArribo)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaSinTermino)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusAsignado)));
				predicates.add(builder.isNull(root.get(AbstractTerminal_.fechaEstatusTermino)));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaProximidad)) {
//				predicates.add(builder.equal(root.get(AbstractTerminal_.proximidad), Boolean.TRUE));
				predicates.add(builder.equal(root.get(AbstractTerminal_.sacNumeroReporte).get("proximidad"), Boolean.TRUE));
			}
			if (StringUtils.equals(filtro, TerminalDao.filtroAlarmaForaneo)) {
				predicates.add(builder.not(root.get(AbstractTerminal_.base).get("id")
						.in(JMUtileriaString.listaDeInteger("9,14,15,19", ","))));
			}
			
			if (StringUtils.equals(filtro, TerminalDao.filtroAvqReporte)) {
				predicates.add(builder.equal(root.get(AbstractTerminal_.reporteSiicaAv), Boolean.TRUE));
			}
			
			if (StringUtils.equals(filtro, TerminalDao.filtroSinPosicionActual)) {
						
					//	(root.get(AbstractTerminal_.ultimoLocalizacionFecha),
					//	new Date(System.currentTimeMillis() - JMUtileriaFecha.TIEMPO_7_DIAS)));
				predicates.add(builder.equal(root.get(AbstractTerminal_.sinPosicionActual), "1"));		
		    }


			if (StringUtils.equals(orden, TerminalDao.ordenAlarma)) {
				query.orderBy(builder.asc(root.get(AbstractTerminal_.fechaEstatusDisponible)),
						builder.asc(root.get(AbstractTerminal_.fechaEstatusOcupado)),
						builder.asc(root.get(AbstractTerminal_.fechaEstatusDesconectado)));
			}
			if (StringUtils.equals(orden, TerminalDao.ordenCatalogoTerminal)) {
				query.orderBy(builder.asc(root.get(AbstractTerminal_.base).get("nombre")),
						builder.asc(root.get(AbstractTerminal_.nombre)));
			}
			if (StringUtils.equals(orden, TerminalDao.ordenWS)) {
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.fechaEstatusDisponible)));
				query.orderBy(builder.asc(root.get(AbstractTerminal_.fechaEstatusDisponible)));
			}

			if (BooleanUtils.isTrue(coordenadasDesdeBase)){
				predicates.add(builder.greaterThan(root.get(AbstractTerminal_.base).get("id")
						, 0));
				predicates.add(builder.equal(root.get(AbstractTerminal_.coordenadasDesdeBase),Boolean.TRUE));
			}
			if (BooleanUtils.isTrue(coordenadasDesdeServicioWeb)){
				predicates.add(builder.isNotNull(root.get(AbstractTerminal_.unidadSerie)));
				predicates.add(builder.equal(root.get(AbstractTerminal_.coordenadasDesdeServicioWeb),Boolean.TRUE));
			}
			if (StringUtils.isNotBlank(estatus)){
				predicates.add(builder.equal(root.get(AbstractTerminal_.estatus),estatus));
			}

			if (StringUtils.isBlank(orden)) {
				query.orderBy(builder.asc(root.get(AbstractTerminal_.numeroradio)),
						builder.asc(root.get(AbstractTerminal_.numeroproveedor)),
						builder.asc(root.get(AbstractTerminal_.nombre)));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			final TypedQuery<Terminal> typedQ = this.getEntityManager().createQuery(query);
		
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeTerminalModulo --> "+endTime);
			
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalModulo");
		}
		
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeTerminalModulo --> "+endTime);
		
		return new Vector<>();
	}


	
}