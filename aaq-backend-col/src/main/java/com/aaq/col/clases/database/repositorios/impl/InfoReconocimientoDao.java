package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.InfoReconocimiento;
import com.aaq.col.clases.database.entidades.abstracto.AbstractInfoReconocimiento_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.InfoReconocimientoDaoInterfase;


@org.springframework.stereotype.Repository(value = "infoReconocimientoDao")
public class InfoReconocimientoDao extends SIICAServerGenericDaoJpaImpl<InfoReconocimiento>
			implements InfoReconocimientoDaoInterfase {

	@Override
	public InfoReconocimiento objetoInfoReconocimiento(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(InfoReconocimiento.class, 
					new Integer(id)) : null;
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoInfoReconocimiento", id );
		}
		return null;
	}

	@Override
	public List<InfoReconocimiento> listaDeInfoReconocimiento(String reporte) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<InfoReconocimiento> query = builder.createQuery(InfoReconocimiento.class);
			final Root<InfoReconocimiento> root = query.from(InfoReconocimiento.class);
			query.select(root);
			
			final List<Predicate> predicates = new ArrayList<>();
			
			if(StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractInfoReconocimiento_.reporte), reporte));
			}
			
			query.where(predicates.toArray( new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractInfoReconocimiento_.nombre)));
			final TypedQuery<InfoReconocimiento> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeInfoReconocimiento", reporte);
		}
		return new Vector<>();
	}

	
}
