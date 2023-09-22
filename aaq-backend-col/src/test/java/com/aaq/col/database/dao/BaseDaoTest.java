package com.aaq.col.database.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.repositorios.interfase.EstadoDaoInterfase;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class BaseDaoTest {
	public Log log = LogFactory.getLog(BaseDaoTest.class);

	@Autowired
	public EstadoDaoInterfase estadoDao;
	
	@Test
	public void baseTest() {
		Base base = new Base();
		base.setEstado(estadoDao.objetoEstado("3"));
		base.setHabilitado(true);
		base.setHabilitadoEnMapa(true);
		base.setHabilitadoEnMapaCabina(true);
		base.setNombre("CENTRO");
		
		JMResultadoOperacion salida = base.guardarObjeto();
		Gson json = new Gson();
		log.info("Base: "+json.toJson(salida));
	}
	

}
