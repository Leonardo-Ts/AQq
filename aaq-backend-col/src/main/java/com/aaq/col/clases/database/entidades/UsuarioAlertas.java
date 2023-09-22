package com.aaq.col.clases.database.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuarioAlertas;
import com.aaq.col.clases.database.servicios.interfase.UsuarioAlertasServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Entity(name = "UsuarioAlertas")
@Access(AccessType.FIELD)
@Table(name = "usuario_alertas")
public class UsuarioAlertas extends AbstractUsuarioAlertas {

	private static final long serialVersionUID = 5735748108755683913L;
	
	private static UsuarioAlertasServiceInterfase usuarioAlertasService;
	
	/** default constructor */
	public UsuarioAlertas() {
		super();
	}
	
	public static UsuarioAlertasServiceInterfase getUsuarioAlertasService() {
		if (UsuarioAlertas.usuarioAlertasService == null) {
			UsuarioAlertas.usuarioAlertasService = JMSIICAServerServiceSingleton.getInstance().getUsuarioAlertasService();
		}
		return UsuarioAlertas.usuarioAlertasService;
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		try {
			return UsuarioAlertas.getUsuarioAlertasService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return UsuarioAlertas.getUsuarioAlertasService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return UsuarioAlertas.getUsuarioAlertasService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
	
}
