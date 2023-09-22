package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.OrdenPaseMedico;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface OrdenPaseMedicoDaoInterfase extends JMRepositorioGenericoInterfase<OrdenPaseMedico> {

	public abstract OrdenPaseMedico objetoOrdenPaseMedico(final String id);
	public abstract List<OrdenPaseMedico> listaDeOrdenPaseMedico();
	public abstract String ejecutarFuncionInsertarPaseMedico(String usuario, String passwd, Date fechaHora,
			String reporte, String tipoAtencion, String numeroOcupantes, String numeroLesionados, String cobertura,
			String causasLesion, String identificacion, String nombreLesionado, String telefonoLesionado,
			String sexoLesionado, String edadLesionado, String tipoAtencionMedica, String lesionesAparentes,
			String tipoProveedor, String claveProveedor, String hospital, String telefonoHospital,
			String domicilioHospital, Integer id_ajustador, String reporteNumeroPoliza);
}