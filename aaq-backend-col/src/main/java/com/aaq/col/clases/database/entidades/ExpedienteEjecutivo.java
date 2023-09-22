package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractExpedienteEjecutivo;
import com.aaq.col.clases.database.servicios.interfase.ExpedienteEjecutivoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "expedienteEjecutivo")
@RequestScoped
@Entity(name = "ExpedienteEjecutivo")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "expediente_ejecutivo")
public class ExpedienteEjecutivo  extends AbstractExpedienteEjecutivo{

	private static final long serialVersionUID = 5465850855399149680L;

	public ExpedienteEjecutivo() {
		super();
	}

	private static ExpedienteEjecutivoServiceInterfase expedienteEjecutivoService;
	
	public static ExpedienteEjecutivoServiceInterfase getExpedienteEjecutivoService() {
		if (ExpedienteEjecutivo.expedienteEjecutivoService == null) {
			ExpedienteEjecutivo.expedienteEjecutivoService = JMSIICAServerServiceSingleton.getInstance().getExpedienteEjecutivoService();
		}
		return ExpedienteEjecutivo.expedienteEjecutivoService;
	}
	
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		return new JMResultadoOperacion(new Exception("No se puede Eliminar. Expediente Digital"));
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return ExpedienteEjecutivo.getExpedienteEjecutivoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Num. Folio,folio","Fecha,fecha,fecha","Evento,causa","Ajustador,terminal",
				"Reporte,reporte","Estado/Base,edoBase","Expediente,nombreExpediente" }).getLista();
	}
	
	
	public String getEdoBase() {
		try {
		        return this.getEstado().getNombre()+"/"+this.getBase().getNombre();
		}catch (Exception e) {
			return "";
		}
	}
	
	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

}
