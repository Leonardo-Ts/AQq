package com.aaq.col.database.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.dao.sise.SiseSPImpTelAjuCallableStatement;
import com.aaq.col.clases.database.repositorios.interfase.SiseSP_DaoInterfase;
import com.aaq.col.clases.pojo.edocta.EstadoCuenta;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring-configuracion.xml",
		"classpath:/config/spring/spring-data-data-source.xml",
	    "classpath:config/spring/spring-data-dao-service.xml"
		})
public class EdoCtaDaoTest {

	public Log log = LogFactory.getLog(EdoCtaDaoTest.class);

	@Autowired
	public SiseSP_DaoInterfase siseDao;
	@Autowired
	private JdbcTemplate siseJdbcTemplate;
	
	@Test
	public void obtenerEdoCta() {
		String poliza ="0000000010"; //4100003301 0100000004
		String inciso = "0001";	//0048
		String fecha = "31/05/2023";
		String reporteSAC = "";
		Terminal term = null;
		String ramo = null;
		EstadoCuenta salida = siseDao.obtenerEdoCta(poliza, inciso, fecha, term, reporteSAC, ramo);
		Gson json = new Gson();
		log.info("RESPUESTA: "+json.toJson(salida));
		
	}
	
	@Test
	public void telefonosSISE() {
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("clave", "19028");
		entry.put("telf", "2228034643");
		
		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));
		
		Map<String, Object> salida = siseJdbcTemplate.call(new SiseSPImpTelAjuCallableStatement(entry), sqlParams);
		Gson json = new Gson();
		log.info("RESPUESTA: "+json.toJson(salida));
		
	}
	
}
