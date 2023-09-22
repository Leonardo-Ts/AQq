 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.repositorios.impl.UsuarioDao;
import com.aaq.col.clases.database.servicios.interfase.UsuarioServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("usuarioService")
@Transactional
public class UsuarioService implements UsuarioServiceInterfase {
	
	@Autowired
	@Qualifier("usuarioDao")
	UsuarioDao usuarioDao;

	@Override
	public Usuario objetoUsuario(final String id) {
		return this.usuarioDao.objetoUsuario(id);
	}

	@Override
	public Usuario objetoUsuario(final String username, final String passwd) {
		return this.usuarioDao.objetoUsuario(username, passwd);
	}

	@Override
	public Usuario objetoUsuarioParaTelefono(final String telefono) {
		return this.usuarioDao.objetoUsuarioParaTelefono(telefono);
	}

	@Override
	public List<Usuario> listaDeUsuario(final Estado estado, final Base base, final Perfil perfil) {
		return this.usuarioDao.listaDeUsuario(estado, base, perfil);
	}

	@Override
	public List<Usuario> listaDeUsuario(final Estado estado, final Frecuencia frecuencia, final Base base,
			final Perfil perfil, final Boolean soloConPosicionValida, final String avq, final String nombre) {
		return this.usuarioDao.listaDeUsuario(estado, frecuencia, base, perfil, soloConPosicionValida, avq,nombre);
	}

	@Override
	public List<Usuario> listaDeUsuarioParaFrecuencia(final Frecuencia f) {
		return this.usuarioDao.listaDeUsuarioParaFrecuencia(f);
	}

	@Override
	public List<Usuario> listaDeUsuarioParaPerfil(final Perfil p) {
		return this.usuarioDao.listaDeUsuarioParaPerfil(p);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Usuario t) {
		return this.usuarioDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Usuario t) {
		return this.usuarioDao.guardarObjeto(t);
	}
}