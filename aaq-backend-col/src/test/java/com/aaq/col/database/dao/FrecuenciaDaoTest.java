package com.aaq.col.database.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.database.repositorios.interfase.BaseDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.EstadoDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.FrecuenciaDaoInterfase;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class FrecuenciaDaoTest {

	public Log log = LogFactory.getLog(FrecuenciaDaoTest.class);
	
	@Autowired
	public EstadoDaoInterfase estadoDao;
	
	@Autowired
	public BaseDaoInterfase baseDao;
	
	@Autowired
	public FrecuenciaDaoInterfase frecDao;
	
	@Test
	public void frecuenciaTest() {
		Frecuencia frec = new Frecuencia();
		frec.setEstado(estadoDao.objetoEstado("3"));
		frec.setHabilitado(true);
		frec.setNombre("CENTRAL 1");
		JMResultadoOperacion salida = frec.guardarObjeto();
		Gson json = new Gson();
		log.info("RESPUESTA: "+json.toJson(salida));
	}
	

	@Test
	public void frecuenciaBaseTest() {
		FrecuenciaBase frec = new FrecuenciaBase();
		frec.setBase(baseDao.objetoBase("1"));
		frec.setFrecuencia(frecDao.objetoFrecuencia("1"));
		JMResultadoOperacion salida = frec.guardarObjeto();
		Gson json = new Gson();
		log.info("RESPUESTA: "+json.toJson(salida));
	}
	
}
