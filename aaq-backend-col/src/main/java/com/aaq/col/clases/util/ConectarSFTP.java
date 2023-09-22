package com.aaq.col.clases.util;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ConectarSFTP {
	
	private final Log4JLogger log = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.expediente");

	private static final ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();

	private static final String ftpUsuario = JMConstantes.CONFIGURACION_OP_FTP_USUARIO;
	private static final String ftpPassword = JMConstantes.CONFIGURACION_OP_FTP_PASSWD;
	private static final String ftpHost = JMConstantes.CONFIGURACION_OP_FTP_HOST;
	private static final String ftpPuerto = JMConstantes.CONFIGURACION_OP_FTP_PUERTO;
	private static final String ftpPath = JMConstantes.CONFIGURACION_OP_FTP_PATH;

	private JSch jsch = new JSch();
	private ChannelSftp channelSftp;
	private Session session;

	public Session abrirConexion() throws NumberFormatException, JSchException, Exception {
		session = jsch.getSession(ConectarSFTP.configuracionDao.obtenerCadena(ftpUsuario), ConectarSFTP.configuracionDao.obtenerCadena(ftpHost),
				Integer.parseInt(ConectarSFTP.configuracionDao.obtenerCadena(ftpPuerto)));
		session.setPassword(ConectarSFTP.configuracionDao.obtenerCadena(ftpPassword));
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect(); 
		
		return session;
	}

	public void ubicarRuta() {
		try {
			channelSftp = (ChannelSftp) this.session.openChannel("sftp");
			channelSftp.connect();
			channelSftp.cd(ConectarSFTP.configuracionDao.obtenerCadena(ftpPath));
		} catch (Exception ex) {
			log.error("Formatos Error=> crearArchivoPaseOrden()=> ConectarSFTP => ubicarRuta: " + ex.getMessage());
		}
	}

	public void salirChannel() {
		channelSftp.exit();
		channelSftp.disconnect();
	}

	public void desconectarSession() {
		session.disconnect();
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * @param channelSftp
	 *            the channelSftp to set
	 */
	public ChannelSftp getChannelSftp() {
		return channelSftp;
	}

	/**
	 * @param channelSftp
	 *            the channelSftp to set
	 */
	public void setChannelSftp(ChannelSftp channelSftp) {
		this.channelSftp = channelSftp;
	}
}
