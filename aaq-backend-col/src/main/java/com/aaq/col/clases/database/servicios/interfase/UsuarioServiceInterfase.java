package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface UsuarioServiceInterfase extends JMServicioGenericoInterfase<Usuario> {

	public abstract Usuario objetoUsuario(final String id) ;
	public abstract Usuario objetoUsuario(final String username, final String passwd);
	public abstract Usuario objetoUsuarioParaTelefono(final String telefono) ;
	public abstract List<Usuario> listaDeUsuario(final Estado estado, final Base base, final Perfil perfil);
	public abstract List<Usuario> listaDeUsuario(final Estado estado, final Frecuencia frecuencia, final Base base,
			final Perfil perfil, final Boolean soloConPosicionValida, final String avq, final String nombre) ;
	public abstract List<Usuario> listaDeUsuarioParaFrecuencia(final Frecuencia f) ;
	public abstract List<Usuario> listaDeUsuarioParaPerfil(final Perfil p);
	public abstract JMResultadoOperacion eliminarObjeto(Usuario t);
	public abstract JMResultadoOperacion guardarObjeto(Usuario t);
}