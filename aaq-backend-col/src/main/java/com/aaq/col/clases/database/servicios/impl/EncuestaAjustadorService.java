package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.EncuestaAjustador;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.impl.EncuestaAjustadorDao;
import com.aaq.col.clases.database.servicios.interfase.EncuestaAjustadorServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("encuestaAjustadorService")
@Transactional
public class EncuestaAjustadorService implements EncuestaAjustadorServiceInterfase {
	
	@Autowired
	@Qualifier("encuestaAjustadorDao")
	EncuestaAjustadorDao encuestaAjustadorDao;
	
	
	@Override
	public EncuestaAjustador objetoeEncuestaAjustador(String id) {
		return  this.encuestaAjustadorDao.objetoEncuestaAjustador(id);
	}
	
	@Override
	public List<EncuestaAjustador> listaDeEncuestaAjustadorSftp(){
		
		return this.encuestaAjustadorDao.listaDeEncuestaAjustadorSftp();
	}
	
	@Override
	public List<EncuestaAjustador> listaDeEncuestaAjustador(
			Date fechaBusquedaInicial, Date fechaBusquedaFinal,
			Terminal claveA, String reporte,Estado estado,Base base, 
			String poliza,Integer limite)  {
		return this.encuestaAjustadorDao.listaDeEncuestaAjustador(
				fechaBusquedaInicial, fechaBusquedaFinal,
				claveA, reporte, estado, base, poliza, limite);
	}
	
	@Override
	public String ejecutarFuncioninsertarEncuestaAjustador(String usuario,
			String passwd, String numeroDeReporte, String nombreAsegurado,
			Integer atencionPersonalCabina, Integer llegadaAjustador,
			Integer presentacionAjustador, Integer tratoAjustador,
			Integer capacidadAjustador, Integer tratoAjustadorTercero,
			Integer servicioDeGrua, Integer seleccionDeTaller,
			boolean observoIrregularidadServicio, boolean recibioCopiaDA,
			String observaciones, String nombreConductor, String telefono,
			String correo,Integer idEstado,Integer idBase,String poliza) {
		
		return this.encuestaAjustadorDao
				.ejecutarFuncioninsertarEncuestaAjustador(usuario, passwd,
						numeroDeReporte, nombreAsegurado,
						atencionPersonalCabina, llegadaAjustador,
						presentacionAjustador, tratoAjustador,
						capacidadAjustador, tratoAjustadorTercero,
						servicioDeGrua, seleccionDeTaller,
						observoIrregularidadServicio, recibioCopiaDA,
						observaciones, nombreConductor, telefono,
						correo,idEstado,idBase,poliza);
	}
	
	@Override
	public JMResultadoOperacion guardarObjeto(EncuestaAjustador t) {
		return this.encuestaAjustadorDao.guardarObjeto(t);
	}

}