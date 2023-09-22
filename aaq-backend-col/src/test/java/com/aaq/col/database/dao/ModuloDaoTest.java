package com.aaq.col.database.dao;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.Modulo;
import com.aaq.col.clases.database.repositorios.interfase.ModuloPadreDaoInterfase;
import com.google.common.base.CaseFormat;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class ModuloDaoTest {

	public Log log = LogFactory.getLog(ModuloDaoTest.class);
	
	@Autowired
	public ModuloPadreDaoInterfase modPadreDao;
	
	@Test
	public void moduloTest() {
		Modulo mod = new Modulo();
		 mod.setAccion("/SIICAGlobal/todosLosEstados");
		 mod.setDescripcion(null);
		 mod.setHabilitado(true);
		 mod.setModuloPadre(modPadreDao.objetoModuloPadre("0"));
		 mod.setNombre("AAQ Global -> Permiso Todos los Estados");
		 mod.setNombrecorto(null);
		 mod.setNombresiicav3("com.jmfg.siicaserver.modulos.global.estados.todos");
		 mod.setPagina("/SIICAGlobal/todosLosEstados.siica");
		 JMResultadoOperacion salida = mod.guardarObjeto();
		 Gson json = new Gson();
			log.info("RESPUESTA: "+json.toJson(salida));
	}
	
	@Test
	public void modulo2Test() {
		Modulo mod = new Modulo();
		 mod.setAccion("/Catalogacion/municipios");
		 mod.setDescripcion("Catalogo para visualizar, editar catalogo de municipios.");
		 mod.setHabilitado(true);
		 mod.setModuloPadre(modPadreDao.objetoModuloPadre("8"));
		 mod.setNombre("Catalogacion -> Municipios");
		 mod.setNombrecorto("Catalogo Municipios");
		 mod.setNombresiicav3("com.jmfg.siicaserver.modulos.catalogacion.municipios");
		 mod.setPagina("/Catalogacion/municipios.siica");
		 JMResultadoOperacion salida = mod.guardarObjeto();
		 Gson json = new Gson();
			log.info("RESPUESTA: "+json.toJson(salida));
	}
	
	@Test
	public void cadenaTest() {
		String accion = "/Catalogacion/recuperaciones";
		 String salida = "menu_"
				+ CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
						StringUtils.substring(accion, StringUtils.lastIndexOf(accion, "/") + 1));
		 log.info("SALIDA: "+salida);
	
	}
	
}
