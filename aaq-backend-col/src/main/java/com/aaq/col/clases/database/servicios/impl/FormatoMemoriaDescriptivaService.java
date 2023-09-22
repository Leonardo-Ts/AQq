package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoMemoriaDescriptiva;
import com.aaq.col.clases.database.repositorios.impl.FormatoMemoriaDescriptivaDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoMemoriaDescriptivaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoMemoriaDescriptivaService")
@Transactional
public class FormatoMemoriaDescriptivaService implements FormatoMemoriaDescriptivaServiceInterfase {

	@Autowired
	@Qualifier("formatoMemoriaDescriptivaDao")
	FormatoMemoriaDescriptivaDao formatoMemoriaDescriptivaDao;

	@Override
	public FormatoMemoriaDescriptiva objetoFormatoMemoriaDescriptiva(String id) {
		return this.formatoMemoriaDescriptivaDao.objetoFormatoMemoriaDescriptiva(id);
	}

	@Override
	public String ejecutarFuncionInsertarMemoriaDescriptiva(

			Date fecha, String reporte, String siniestro, String folioElectro, Integer cobertura, String poliza,
			String endoso, String inciso, String nomSocial, Integer tipoAsegurado, String marca, String tipo,
			String modelo, String placas, String color, String duracionMan, Integer gruaLugar, Integer concesion,
			Integer estatalFede, String maniobras, String tipoGrua, Integer otraGrua, String otraGruaTexto,
			Integer cardan1, Integer cardan2, Integer cardan3, Integer cantidadGruas, Integer traspaleo,
			String tipoTraspaleo, String proveedor, String cantidadGruasTexto, String telefono, String domicilioProv,
			String ubicacionOrigen, String trasladoDestino, Integer camionToneladas, String horarioSolicitado,
			String horarioArribo, String horarioTraslado, String manEspeciales, Integer servicioDesacoplar,
			Integer servicioAbanderaM, Integer servicioAbanderaG, String manualHora, String gruaHora,
			Integer servicioEnganche, Integer servicioFueraC, Integer servicioSobreC, Integer servicioVolcadura,
			Integer servicioCarga, Integer servicioRescate, Integer servicioCustodia, Integer servicioManiobra,
			String firmaAsegurado, String nomEmpleado, String firmaEmpleado, String claveEmpleado,
			String nomOperadorGrua, String numEcoGrua, String firmaOperadorGrua, String croquis, String tipoGruaAbander,
			String correo, Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp

	) {
		return this.formatoMemoriaDescriptivaDao.ejecutarFuncionInsertarMemoriaDescriptiva(

				fecha, reporte, siniestro, folioElectro, cobertura, poliza, endoso, inciso, nomSocial, tipoAsegurado,
				marca, tipo, modelo, placas, color, duracionMan, gruaLugar, concesion, estatalFede, maniobras, tipoGrua,
				otraGrua, otraGruaTexto, cardan1, cardan2, cardan3, cantidadGruas, traspaleo, tipoTraspaleo, proveedor,
				cantidadGruasTexto, telefono, domicilioProv, ubicacionOrigen, trasladoDestino, camionToneladas,
				horarioSolicitado, horarioArribo, horarioTraslado, manEspeciales, servicioDesacoplar, servicioAbanderaM,
				servicioAbanderaG, manualHora, gruaHora, servicioEnganche, servicioFueraC, servicioSobreC,
				servicioVolcadura, servicioCarga, servicioRescate, servicioCustodia, servicioManiobra, firmaAsegurado,
				nomEmpleado, firmaEmpleado, claveEmpleado, nomOperadorGrua, numEcoGrua, firmaOperadorGrua, croquis,
				tipoGruaAbander, correo, enviadoEmail, mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp);
	}

	@Override
	public List<FormatoMemoriaDescriptiva> listaDeFormatoMemoriaDescriptiva() {
		return this.formatoMemoriaDescriptivaDao.listaDeFormatoMemoriaDescriptiva();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoMemoriaDescriptiva t) {

		return this.formatoMemoriaDescriptivaDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoMemoriaDescriptivaDao.obtenerConsecutivo(reporte);
	}

}