package com.aaq.col.system.beans.operacion;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;

@ManagedBean(name = "beanOperacionSockets")
@ViewScoped
public class JMBeanOperacionSockets extends JMBeanExtensiblePrincipal<Terminal> {
	private static final long serialVersionUID = 3796013955583657062L;

	public JMBeanOperacionSockets() {
		super();
	}

	@Override
	public void actualizarListado() {

	}
//
//	public void doAccionConectarConSMS(final ActionEvent e) {
//		if ((JMBeanExtensiblePrincipal.getSpringSocketSMS() != null)) {
//
//			JMBeanExtensiblePrincipal.getSpringSocketSMS().iniciarConexion();
//			this.ponerMensajeInfo("Conexion con servicio SMS inicializada");
//		}
//	}
//
//	public void doAccionDesconectarConSMS(final ActionEvent e) {
//		if ((JMBeanExtensiblePrincipal.getSpringSocketSMS() != null)) {
//			JMBeanExtensiblePrincipal.getSpringSocketSMS().iniciarDesconexion();
//			this.ponerMensajeInfo("Desconexion con servicio SMS inicializada");
//		}
//	}
//
//	public void doAccionEncenderServidorTCP(final ActionEvent e) {
//		JMBeanExtensiblePrincipal.getSpringServidorTCP().iniciarServidor();
//		this.ponerMensajeInfo("Conexion con servicio TCP inicializada");
//	}
//
//	/**
//	 * Inicia o detiene el servicio
//	 * 
//	 * @param e  es el evento de Ajax que dispara este metodo desde la interfaz web
//	 */
//	public void doAccionDetenerServidorTCP(final ActionEvent e) {
//		JMBeanExtensiblePrincipal.getSpringServidorTCP().detenerServidor();
//		this.ponerMensajeInfo("Desconexion con servicio TCP inicializada");
//	}
//
//	/**
//	 * Inicia o detiene el servicio
//	 * 
//	 * @param e  es el evento de Ajax que dispara este metodo desde la interfaz web
//	 */
//	public void doAccionEncenderServidorUDP(final ActionEvent e) {
//		JMBeanExtensiblePrincipal.getSpringServidorUDP().iniciarServidor();
//		this.ponerMensajeInfo("Conexion con servicio UDP inicializada");
//
//	}
//
//	/**
//	 * Inicia o detiene el servicio
//	 * 
//	 * @param e  es el evento de Ajax que dispara este metodo desde la interfaz web
//	 */
//	public void doAccionDetenerServidorUDP(final ActionEvent e) {
//		JMBeanExtensiblePrincipal.getSpringServidorUDP().detenerServidor();
//		this.ponerMensajeInfo("Desconexion con servicio UDP inicializada");
//	}
//
//	// **************************************************************//
//	// Propiedades de los servidores
//	// **************************************************************//
//
//	/**
//	 * 07/08/2008 10:53:31
//	 * 
//	 * @return si el server tcp esta encendido
//	 */
//	public String getEstatusServidorTCP() {
//		return JMBeanExtensiblePrincipal.getSpringServidorTCP().getEstaElServidorEncendido() ? "Servidor Iniciado"
//				: "Servidor Detenido";
//	}
//
//	/**
//	 * 07/08/2008 10:53:29
//	 * 
//	 * @return si el server udp esta encendido
//	 */
//	public String getEstatusServidorUDP() {
//		return JMBeanExtensiblePrincipal.getSpringServidorUDP().getEstaElServidorEncendido() ? "Servidor Iniciado"
//				: "Servidor Detenido";
//	}
//
//	/**
//	 * getEstatusSMS Apr 9, 2008 3:49:48 AM
//	 * 
//	 * @return estatus
//	 */
//	public String getEstatusSMS() {
//		if ((JMBeanExtensiblePrincipal.getSpringSocketSMS() != null)) {
//			return JMBeanExtensiblePrincipal.getSpringSocketSMS().getEstaConectado() ? "Conectado" : "Desconectado";
//		}
//		return "Bean SMS Nulo";
//	}

	/**
	 * getUltimoFechaSMS Apr 9, 2008 3:49:51 AM
	 * 
	 * @return fecha
	 */
	public String getUltimoFechaSMS() {
		return null;
	}

	/**
	 * getUltimoRegistroSMS Apr 9, 2008 3:49:54 AM
	 * 
	 * @return texto
	 */
	public String getUltimoRegistroSMS() {
		return null;
	}

}
