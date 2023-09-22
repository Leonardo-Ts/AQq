package com.aaq.col.database.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.CatalogoRoles;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoRolesDaoInterfase;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class CatalogoRolesDaoTest {
	
	public Log log = LogFactory.getLog(CatalogoRolesDaoTest.class);

	@Autowired
	private CatalogoRolesDaoInterfase catalogoRolesDao;
	
	@Test
	public void listaCatalogoRolesTest() {
		List<CatalogoRoles> salida = this.catalogoRolesDao.listaDeRoles();
		Gson json = new Gson();
		log.info("SALIDA => "+json.toJson(salida));
	}
}
