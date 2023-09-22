/**
 * 
 */
package com.aaq.col.database.dao;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.interfase.BaseDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.EstadoDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.TerminalDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.UsuarioDaoInterfase;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class TerminalDaoTest {
	public Log log = LogFactory.getLog(TerminalDaoTest.class);

	@Autowired
	public BaseDaoInterfase baseDao;
	
	@Autowired
	public EstadoDaoInterfase estadoDao;
	
	@Autowired
	public UsuarioDaoInterfase usuarioDao;
	
	@Autowired
	public TerminalDaoInterfase terminalDao;
	
	@Test
	public void TerminalTest() {
		Terminal term = new Terminal();
		term.setBase(baseDao.objetoBase("1"));
		term.setAsistenciaVial(true);
		term.setCoordenadasDesdeBase(true);
		term.setCorreoElectronico("jpestrategica6@qualitas.com.mx");
		term.setEstado(estadoDao.objetoEstado("1"));
		term.setHabilitado(true);
		term.setMostrarEnCercania(true);
		term.setNombre("DAVID HERRERA CASTILLO");
		term.setNumeroproveedor("14253");
		term.setPasswd("12345");
		term.setUsuario(usuarioDao.objetoUsuario("1"));
		JMResultadoOperacion salida = term.guardarObjeto();
		Gson json = new Gson();
		log.info("RESPUESTA: "+json.toJson(salida));
	}
	
	@Test
	public void insertarCoordenadas() {
		 JMResultadoOperacion salida = terminalDao.ejecutarFuncionTerminalInsertarCoordenadas(1, new Date(), "0.0", "6.228120", "", null);
		 Gson json = new Gson();
			log.info("RESPUESTA: "+json.toJson(salida));
	}
}
