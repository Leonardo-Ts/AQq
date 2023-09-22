package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.InfoReconocimiento;
import com.aaq.col.clases.database.repositorios.impl.InfoReconocimientoDao;
import com.aaq.col.clases.database.servicios.interfase.InfoReconocimientoServiceInterface;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("infoReconocimientoService")
@Transactional
public class InfoReconocimientoService implements InfoReconocimientoServiceInterface {

	@Autowired
	@Qualifier("infoReconocimientoDao")
	InfoReconocimientoDao  infoReconocimientoDao;
	
	@Override
	public InfoReconocimiento objetoInfoReconocimiento(String id) {
		return this.infoReconocimientoDao.objetoInfoReconocimiento(id);
	}

	@Override
	public List<InfoReconocimiento> listaDeInfoReconocimienot(String reporte)  {
		return this.infoReconocimientoDao.listaDeInfoReconocimiento(reporte);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(InfoReconocimiento inf) {
		return this.infoReconocimientoDao.eliminarObjeto(inf);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final InfoReconocimiento info) {
		return this.infoReconocimientoDao.guardarObjeto(info);
	}

}
