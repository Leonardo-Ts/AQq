package com.aaq.col.database.dao;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class ConfiguracionDaoTest {

	public Log log = LogFactory.getLog(ConfiguracionDaoTest.class);

	@Test
	public void guardarCOnfiguracion() {
//
		Configuracion conf = new Configuracion();
		conf.setFecha(new Date());
		conf.setLlave("configuracion.aaq.aplicacion.notificaciones.permiso.correo");
		conf.setNombre("AAQ -> Aplicacion -> Notificaciones -> Permiso -> Correo");
		conf.setValor("true");
		JMResultadoOperacion salida = conf.guardarObjeto();
		Gson json = new Gson();
		log.info("resultado: "+json.toJson(salida));
	}
}
