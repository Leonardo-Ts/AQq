package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioFrecuencia;
import com.aaq.col.clases.pojo.notificacion.EncuestaCorreo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface UsuarioFrecuenciaServiceInterfase extends JMServicioGenericoInterfase<UsuarioFrecuencia> {

	public abstract UsuarioFrecuencia objetoUsuarioFrecuencia(final String id);
	public abstract List<UsuarioFrecuencia> listaDeUsuarioFrecuencia(final Usuario usuario);
	public abstract JMResultadoOperacion eliminarObjeto(UsuarioFrecuencia t) ;
	public abstract JMResultadoOperacion guardarObjeto(UsuarioFrecuencia t) ;
	public abstract void envioDeCorreoEncuesta(Terminal terminal, EncuestaCorreo resultados, String reporte, int rol) ;
	public abstract List<UsuarioFrecuencia> usuarioEncuestaFrecuencia(Frecuencia frecuencia) ;
	public void envioDeCorreoSOS(Terminal terminal, int rol, int rol2) ;
	public abstract void envioDeCorreoCobFlex13(Terminal terminal, String siniestro, String reporte, int rol, int rol2) ;
	

}