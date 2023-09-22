package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.HorarioGrupo;
import com.aaq.col.clases.database.entidades.abstracto.AbstractHorarioGrupo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.HorarioGrupoDaoInterfase;

@org.springframework.stereotype.Repository(value = "horarioGrupoDao")
public  class HorarioGrupoDao extends SIICAServerGenericDaoJpaImpl<HorarioGrupo> implements
	HorarioGrupoDaoInterfase {

	private final Log4JLogger logTiempos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.tiempos");

	
	@Override
	public HorarioGrupo objetoHorarioGrupo(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(HorarioGrupo.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoHorarioGrupol", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoHorarioGrupol", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoHorarioGrupol", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoHorarioGrupol", id);
		}
		return null;
	}

	@Override
	public List<HorarioGrupo> listaDeHorarioGrupo(final Grupo grupo) {
		return this.listaDeHorarioGrupo(grupo, null);
	}

	@Override
	public List<HorarioGrupo> listaDeHorarioGrupo(final String claveHorario) {
		return this.listaDeHorarioGrupo(null, claveHorario);
	}
	
	@Override
	public List<HorarioGrupo> listaDeHorarioGrupo() {
		return this.listaDeHorarioGrupo(null, null);
	}
	
	@Override
	public List<HorarioGrupo> listaDeHorarioGrupo(Grupo grupo, String claveHorario){
		if(grupo != null || StringUtils.isNotBlank(claveHorario) ){
			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<HorarioGrupo> query = builder.createQuery(HorarioGrupo.class);
				final Root<HorarioGrupo> root = query.from(HorarioGrupo.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				if (grupo != null) {
					predicates.add(builder.equal(root.get(AbstractHorarioGrupo_.grupo), grupo));
				}
				
				if (StringUtils.isNotBlank(claveHorario)) {
					predicates.add(builder.equal(root.get(AbstractHorarioGrupo_.claveHorario), claveHorario));
				}
				
				// predicates.add(builder.equal(root.get(AbstractHorarioGrupo_.terminal).get("habilitado"), Boolean.TRUE));
				
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.asc(root.get(AbstractHorarioGrupo_.claveHorario)));
				final TypedQuery<HorarioGrupo> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			} catch (final NoResultException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			} catch (final IllegalArgumentException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			} catch (final IllegalStateException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			} catch (final PersistenceException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			}
		}
		else{
			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<HorarioGrupo> query = builder.createQuery(HorarioGrupo.class);
				final Root<HorarioGrupo> root = query.from(HorarioGrupo.class);
				query.select(root);
				query.orderBy(builder.asc(root.get(AbstractHorarioGrupo_.claveHorario)));
				final TypedQuery<HorarioGrupo> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			} catch (final NoResultException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			} catch (final IllegalArgumentException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			} catch (final IllegalStateException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			} catch (final PersistenceException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			}
		}
		return new Vector<>();
	}
	
	@Override
	public HorarioGrupo horarioGrupoFecha (final Grupo grupo, final Date fecha) {
		
		try {
			
			this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA horarioGrupoFecha");
			long startTime = System.currentTimeMillis();
			
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<HorarioGrupo> query = builder.createQuery(HorarioGrupo.class);
			final Root<HorarioGrupo> root = query.from(HorarioGrupo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			predicates.add(builder.equal(root.get(AbstractHorarioGrupo_.grupo), grupo ));
			if (fecha != null) {
				predicates.add(builder.lessThanOrEqualTo(root.get(AbstractHorarioGrupo_.fechaInicio), fecha));
				predicates.add(builder.greaterThanOrEqualTo(root.get(AbstractHorarioGrupo_.fechaFin), fecha));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			
				
			final TypedQuery<HorarioGrupo> typedQ = this.getEntityManager().createQuery(query);
			
			long endTime = System.currentTimeMillis() - startTime;
			this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA horarioGrupoFecha --> "+endTime);
				
			return typedQ.getSingleResult();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			return null;
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			return null;
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			return null;
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupo", grupo);
			return null;
		}
		
	}
	
	@Override
	public HorarioGrupo horarioEncontrado(Grupo idgrupo) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<HorarioGrupo> query = builder.createQuery(HorarioGrupo.class);
			final Root<HorarioGrupo> root = query.from(HorarioGrupo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractHorarioGrupo_.grupo), idgrupo));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<HorarioGrupo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getSingleResult();
		} catch (NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objeto HorarioGrupo buscado por idGrupo");
		} catch (IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objeto HorarioGrupo buscado por idGrupo");
		} catch (IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objeto HorarioGrupo buscado por idGrupo");
		} catch (PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objeto HorarioGrupo buscado por idGrupo");
		}
		return null;
	}
	
	@Override
	public List<HorarioGrupo> listaDeHorarioGrupoFechaAsc(Grupo grupo) {
		if(grupo != null ){
			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<HorarioGrupo> query = builder.createQuery(HorarioGrupo.class);
				final Root<HorarioGrupo> root = query.from(HorarioGrupo.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				if (grupo != null) {
					predicates.add(builder.equal(root.get(AbstractHorarioGrupo_.grupo), grupo));
				}
				
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.desc(root.get(AbstractHorarioGrupo_.fechaFin)));
				final TypedQuery<HorarioGrupo> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			} catch (final NoResultException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupoFechaAsc", grupo);
			} catch (final IllegalArgumentException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupoFechaAsc", grupo);
			} catch (final IllegalStateException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupoFechaAsc", grupo);
			} catch (final PersistenceException e) {
				this.documentarExcepcionParaMetodo(e, "listaDeHorarioGrupoFechaAsc", grupo);
			}
		}
		return new Vector<>();
	}

	
}