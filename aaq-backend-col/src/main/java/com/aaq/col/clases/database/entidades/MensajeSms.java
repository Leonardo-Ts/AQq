package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractMensajeSms;
import com.aaq.col.clases.database.servicios.interfase.MensajeSmsServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "mensajeSms")
@RequestScoped
@Entity(name = "MensajeSms")
@Access(AccessType.FIELD)
@Table(name = "mensaje_sms")
public class MensajeSms extends AbstractMensajeSms {

	// Constructors

	private static final long serialVersionUID = -4349561069665501254L;

	/** default constructor */
	public MensajeSms() {
		super();
	}

	private static MensajeSmsServiceInterfase mensajeSmsService;

	public static MensajeSmsServiceInterfase getMensajeSmsService() {
		if (MensajeSms.mensajeSmsService == null) {
			MensajeSms.mensajeSmsService = JMSIICAServerServiceSingleton.getInstance().getMensajeSmsService();
		}
		return MensajeSms.mensajeSmsService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Ajustador,terminal",
				"Texto,texto", "Destino,telefonodestino", "Usuario,usuario", "Direccion IP,direccionIp","uid_android,uid_android"}).getLista();
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
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return MensajeSms.getMensajeSmsService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return MensajeSms.getMensajeSmsService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
