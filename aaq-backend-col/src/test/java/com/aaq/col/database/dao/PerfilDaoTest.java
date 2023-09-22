package com.aaq.col.database.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Permiso;
import com.aaq.col.clases.database.repositorios.interfase.ModuloDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.PerfilDaoInterfase;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class PerfilDaoTest {
	public Log log = LogFactory.getLog(PerfilDaoTest.class);

	@Autowired
	public PerfilDaoInterfase perfilDao;
	
	@Autowired
	public ModuloDaoInterfase moduloDao;
	
	
	@Test
	public void consultarPerfilTest() {
	Perfil perfil = perfilDao.objetoPerfil("1");	
	Gson json = new Gson();
	log.info("perfil: "+json.toJson(perfil));
	}
	
	@Test
	public void permisosTest() {
	Permiso permiso = new Permiso();
	permiso.setModulo(moduloDao.objetoModulo("73"));
	permiso.setPerfil(perfilDao.objetoPerfil("1"));
	JMResultadoOperacion salida = permiso.guardarObjeto();
	
	Gson json = new Gson();
	log.info("perfil: "+json.toJson(salida));
	}
}
