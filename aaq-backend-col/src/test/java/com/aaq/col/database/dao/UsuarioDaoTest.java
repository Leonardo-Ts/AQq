package com.aaq.col.database.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.repositorios.interfase.BaseDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.EstadoDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.FrecuenciaDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.PerfilDaoInterfase;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class UsuarioDaoTest {

	public Log log = LogFactory.getLog(UsuarioDaoTest.class);
	
	@Autowired
	public BaseDaoInterfase baseDao;
	
	@Autowired
	public EstadoDaoInterfase estadoDao;
	
	@Autowired
	public PerfilDaoInterfase perfilDao;
	
	@Autowired
	public FrecuenciaDaoInterfase frecDao;
	
	@Test
	public void usuarioTest() {
		Usuario usu = new Usuario();
		usu.setBase(baseDao.objetoBase("1"));
		usu.setEstado(estadoDao.objetoEstado("3"));
		usu.setPerfil(perfilDao.objetoPerfil("1"));
		usu.setFrecuencia(frecDao.objetoFrecuencia("1"));
		usu.setUsername("fadiaz");
		usu.setPasswd("fadiaz_7#");
		usu.setNombre("Fanny Diaz");
		usu.setHabilitado(true);
		JMResultadoOperacion salida = usu.guardarObjeto();
		Gson json = new Gson();
		log.info("RESPUESTA: "+json.toJson(salida));
	}
	
}
