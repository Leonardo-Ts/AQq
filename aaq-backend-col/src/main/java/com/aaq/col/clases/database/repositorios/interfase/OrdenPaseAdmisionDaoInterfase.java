package com.aaq.col.clases.database.repositorios.interfase;


import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.OrdenPaseAdmision;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface OrdenPaseAdmisionDaoInterfase extends JMRepositorioGenericoInterfase<OrdenPaseAdmision> {
	
	public abstract OrdenPaseAdmision objetoOrdenPaseAdmision(final String id);
	public abstract List<OrdenPaseAdmision> listaDeOrdenPaseAdmision();
	public abstract String ejecutarFuncionInsertarPaseAdmision(String usuario,String passwd,String reporte,Date fechaHora,
		    String tipoOrden,String tipoAfectado,String conductor,String telefonoConductor,String oficina,
		    String ubicacion,String tipoProveedor,String claveProveedor,String responsableTaller,String telefonoTaller,
		    String domicilioTaller,String cobertura,String marcaVehiculo,String tipoVehiculo,String modeloVehiculo,
		    String serieVehiculo,String colorVehiculo,String placasVehiculo,String danosPreexistentes,String danosSiniestro,
		    Boolean deducible,String tipoDeducible,String sumaAsegurada,String porcentajeDeducible,String monto,String observaciones,
		    Integer id_ajustador, String reportePolizaNumero);

}