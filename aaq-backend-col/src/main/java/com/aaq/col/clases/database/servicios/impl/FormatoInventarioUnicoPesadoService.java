package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoInventarioUnicoPesado;
import com.aaq.col.clases.database.repositorios.impl.FormatoInventarioUnicoPesadoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoInventarioUnicoPesadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoInventarioUnicoPesadoService")
@Transactional
public class FormatoInventarioUnicoPesadoService implements FormatoInventarioUnicoPesadoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoInventarioUnicoPesadoDao")
	FormatoInventarioUnicoPesadoDao formatoInventarioUnicoPesadoDao;

	@Override
	public FormatoInventarioUnicoPesado objetoFormatoInventarioUnicoPesado(String id) {
		return this.formatoInventarioUnicoPesadoDao.objetoFormatoInventarioUnicoPesado(id);
	}

	@Override
	public List<FormatoInventarioUnicoPesado> listaDeFormatoInventarioUnicoPesado() {
		return this.formatoInventarioUnicoPesadoDao.listaDeFormatoInventarioUnicoPesado();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoInventarioUnicoPesado t) {

		return this.formatoInventarioUnicoPesadoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoInventarioUnicoPesadoDao.obtenerConsecutivo(reporte);

	}
}