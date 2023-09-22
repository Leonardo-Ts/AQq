package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractInfoReconocimiento;
import com.aaq.col.clases.database.servicios.interfase.InfoReconocimientoServiceInterface;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name="infoReconocimiento")
@RequestScoped
@Entity(name="infoReconocimiento")
@Access(AccessType.FIELD)
@Table(name="INFO_RECONOCIMIENTO")
public class InfoReconocimiento extends AbstractInfoReconocimiento {

	private static final long serialVersionUID = -1274649012589320474L;

	private static InfoReconocimientoServiceInterface infoReconocimientoService;
	
	public static InfoReconocimientoServiceInterface getInfoReconocimientoService() {
		if(InfoReconocimiento.infoReconocimientoService == null) {
			InfoReconocimiento.infoReconocimientoService = JMSIICAServerServiceSingleton.getInstance()
					.getInfoReconocimientoService();
		}
		return InfoReconocimiento.infoReconocimientoService;
		
	}
	
	
	public JMResultadoOperacion editarObjeto() {
		return null;
	}
	
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return InfoReconocimiento.getInfoReconocimientoService().eliminarObjeto(this);
		} catch (Exception e) {
			return new JMResultadoOperacion(e);
		}
	}
	
	 @Override
	 public JMResultadoOperacion guardarObjeto() {
	 	try {
	 		return InfoReconocimiento.getInfoReconocimientoService().guardarObjeto(this);
	 	} catch (Exception e) {
			return new JMResultadoOperacion(e);
		}
	 		
	 	}
	
	
}
