package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioAlertas;
import com.aaq.col.clases.database.entidades.pojo.TipoAlertas;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface UsuarioAlertasServiceInterfase extends JMServicioGenericoInterfase<UsuarioAlertas> {

	public abstract UsuarioAlertas objetoUsuarioAlertas(final String id);
	public abstract UsuarioAlertas objetoUsuarioAlertasParaUsuario(final Usuario usuario);
	public abstract JMResultadoOperacion eliminarObjeto(UsuarioAlertas t) ;
	public abstract JMResultadoOperacion guardarObjeto(UsuarioAlertas t) ;
	public abstract List<UsuarioAlertas> usuarioAlertaParaFrecuencia(final Frecuencia frecuencia, String filtroAlerta) ;
	public void envioAlertas(Terminal terminal, int tiempo, String tipoAlerta, TipoAlertas tipoAlertas, String rol, String complemento);
	void envioAlertasNoDisponible(Estado estado, String tipoAlerta, TipoAlertas tipoAlertas);
}
