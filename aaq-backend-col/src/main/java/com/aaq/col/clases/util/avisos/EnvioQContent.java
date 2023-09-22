package com.aaq.col.clases.util.avisos;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.util.ConectarSFTP;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

public class EnvioQContent {
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");

	private static String FUENTE = "EnvioQContent => ";
	private ConectarSFTP conectarSFTP = new ConectarSFTP();

	@SuppressWarnings("unused")
	public void envioToContent(String notacion, String numeroReporte, byte[] pdf, String numeroPoliza) {
		String nombreCompleto = "FR05___"+numeroReporte+"_0000000001__1_1_1";
		try {
			int abrirConexion = 0;
			ByteArrayInputStream input = new ByteArrayInputStream(pdf);
			conectarSFTP.abrirConexion();
			abrirConexion = 1;
			conectarSFTP.ubicarRuta();
			abrirConexion = 2;
			ChannelSftp channelSftp = conectarSFTP.getChannelSftp();
			try {
				channelSftp.put(input, nombreCompleto+".pdf");
			}  catch (SftpException e) {
				this.loggerAvisos.error(FUENTE+"Error al cargar elementos: ",e);
			}  catch (Exception e) {
				this.loggerAvisos.error(FUENTE+"Error al cargar elementos: ",e);
			}
			
			input.close();
			esperarXsegundos(1);
			String contenidoLista = armarContenidoArchivoLst("FR05",numeroReporte, nombreCompleto+".pdf", numeroPoliza);
			ByteArrayInputStream bisLst = new ByteArrayInputStream(contenidoLista.getBytes());
			String nombreLst = numeroReporte + "D" + obtenerFecha() + ".lst";
			ChannelSftp channelLST = conectarSFTP.getChannelSftp();
			try {
				channelLST.put(bisLst, nombreLst);
			} catch (Exception e) {
				this.loggerAvisos.error(FUENTE+"Ocurrio un error en channelLST=>",e);
			}
			bisLst.close();
			conectarSFTP.salirChannel();
			conectarSFTP.desconectarSession();
			abrirConexion = 0;
		} catch (Exception e) {
			this.loggerAvisos.error(FUENTE+"AvisoConclusion => SFTP=> " + numeroReporte, e);
			conectarSFTP.salirChannel();
			conectarSFTP.desconectarSession();
			}

		}

	
	private String armarContenidoArchivoLst(String notacion, String numeroReporte, String nombreCompleto, String numeroPoliza) {
		String contenido = "";
		String separadorContenido = "|";
		String poliza="";
		poliza=numeroPoliza;
		try {
			String cadenaDestino = Configuracion.getConfiguracionService().obtenerCadena("configuracion.siica.sistema.orden.pases.usuario.ftp.ruta");
			contenido = cadenaDestino + nombreCompleto + separadorContenido + notacion + separadorContenido
					+ separadorContenido + separadorContenido + numeroReporte + separadorContenido
					+ poliza + "||" + 1;
//			E:\ECfolders\movil\FR05___04223328983_0000000001__1_1_1.pdf|FR05|||04223328983|0003806602||1
		} catch (Exception ex) {
			this.loggerAvisos.error(FUENTE+"ERROR=> armarContenidoArchivoLst() " + nombreCompleto  + " =>"
				+" =>" + numeroReporte , ex);
		}
		return contenido;
	}
	
	
	private String obtenerFecha() {
		DateFormat date = new SimpleDateFormat("yyyMMdd");
		DateFormat time = new SimpleDateFormat("HHmmss");
		Date currentDate = new Date();

		String fecha = date.format(currentDate) + time.format(currentDate);

		return fecha;
	}

	private static void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
}
