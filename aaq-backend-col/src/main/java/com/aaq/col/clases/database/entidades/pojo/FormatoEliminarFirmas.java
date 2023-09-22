package com.aaq.col.clases.database.entidades.pojo;

import com.aaq.col.clases.webservices.formatos.FormatoAdmisionAutomoviles;
import com.aaq.col.clases.webservices.formatos.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.webservices.formatos.FormatoAdmisionPesado;
import com.aaq.col.clases.webservices.formatos.FormatoAsignacionAbogado;
import com.aaq.col.clases.webservices.formatos.FormatoAsistenciaVial;
import com.aaq.col.clases.webservices.formatos.FormatoCargoTarjetaCredito;
import com.aaq.col.clases.webservices.formatos.FormatoCuestionarioRobo;
import com.aaq.col.clases.webservices.formatos.FormatoDeclaracionUniversal;
import com.aaq.col.clases.webservices.formatos.FormatoEncuestaServicio;
import com.aaq.col.clases.webservices.formatos.FormatoGarantiaPrendaria;
import com.aaq.col.clases.webservices.formatos.FormatoInspeccionMoto;
import com.aaq.col.clases.webservices.formatos.FormatoInspeccionPesado;
import com.aaq.col.clases.webservices.formatos.FormatoInventarioAutomoviles;
import com.aaq.col.clases.webservices.formatos.FormatoInventarioUnicoPesado;
import com.aaq.col.clases.webservices.formatos.FormatoMemoriaDescriptiva;
import com.aaq.col.clases.webservices.formatos.FormatoNuevosVehiculos;
import com.aaq.col.clases.webservices.formatos.FormatoObservacionesAsegurado;
import com.aaq.col.clases.webservices.formatos.FormatoOrdenServicio;
import com.aaq.col.clases.webservices.formatos.FormatoPaseMedico;
import com.aaq.col.clases.webservices.formatos.FormatoReciboIngresoSiniestro;
import com.aaq.col.clases.webservices.formatos.FormatoReciboPagoDeducible;
import com.aaq.col.clases.webservices.formatos.FormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.webservices.formatos.FormatoReclamacionPendiente;
import com.aaq.col.clases.webservices.formatos.FormatoReparacionBienes;
import com.aaq.col.clases.webservices.formatos.FormatoReparacionBienesDiversos;
import com.aaq.col.clases.webservices.formatos.FormatoResponsabilidadCivil;
import com.aaq.col.clases.webservices.formatos.FormatoSolicitudDiagnostico;
import com.aaq.col.clases.webservices.formatos.FormatoValeAmbulancia;

public class FormatoEliminarFirmas {
	
	public FormatoAsistenciaVial eliminaFormatoAsistenciaVial(FormatoAsistenciaVial datos) {
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		return datos;
	}
	
	public FormatoValeAmbulancia eliminaFormatoValeAmbulancia(FormatoValeAmbulancia datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		if(datos.getFirma_Conductor()==null || datos.getFirma_Conductor().equals("")) {
			datos.setFirma_Conductor(null);
		} else {
			datos.setFirma_Conductor("Ok");
		}
		if(datos.getFirma_Lesionado()==null || datos.getFirma_Lesionado().equals("")) {
			datos.setFirma_Lesionado(null);
		} else {
			datos.setFirma_Lesionado("Ok");
		}
		return datos;
	}
	
	public FormatoReclamacionPendiente eliminaFormatoReclamacionPendiente(FormatoReclamacionPendiente datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		return datos;
	}

	public FormatoEncuestaServicio eliminaFormatoEncuestaServicio(FormatoEncuestaServicio datos) {
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		return datos;
	}
	
	public FormatoOrdenServicio eliminaFormatoOrdenServicio(FormatoOrdenServicio datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		return datos;
	}
	
	public FormatoGarantiaPrendaria eliminaFormatoGarantiaPrendaria(FormatoGarantiaPrendaria datos) {
		if(datos.getFirma_Acreedor()==null || datos.getFirma_Acreedor().equals("")) {
			datos.setFirma_Acreedor(null);
		} else {
			datos.setFirma_Acreedor("Ok");
		}
		if(datos.getFirma_Deudor()==null || datos.getFirma_Deudor().equals("")) {
			datos.setFirma_Deudor(null);
		} else {
			datos.setFirma_Deudor("Ok");
		}
		return datos;
	}
	

	public FormatoNuevosVehiculos eliminaFormatoNuevosVehiculos(FormatoNuevosVehiculos datos) {
		if(datos.getFirma_Cliente()==null || datos.getFirma_Cliente().equals("")) {
			datos.setFirma_Cliente(null);
		} else {
			datos.setFirma_Cliente("Ok");
		}
		if(datos.getFirma_Agente()==null || datos.getFirma_Agente().equals("")) {
			datos.setFirma_Agente(null);
		} else {
			datos.setFirma_Agente("Ok");
		}
		return datos;
	}
	
	public FormatoReparacionBienes eliminaFormatoReparacionBienes(FormatoReparacionBienes datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		return datos;
	}
	

	public FormatoPaseMedico eliminaFormatoPaseMedico(FormatoPaseMedico datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		if(datos.getFirma_Lesionado()==null || datos.getFirma_Lesionado().equals("")) {
			datos.setFirma_Lesionado(null);
		} else {
			datos.setFirma_Lesionado("Ok");
		}
		return datos;
	}

	public FormatoInventarioAutomoviles eliminaFormatoInventarioAutomoviles(FormatoInventarioAutomoviles datos) {
		if(datos.getFirma_Ajus_Recibe()==null || datos.getFirma_Ajus_Recibe().equals("")) {
			datos.setFirma_Ajus_Recibe(null);
		} else {
			datos.setFirma_Ajus_Recibe("Ok");
		}
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		if(datos.getFirma_Oper_Recibe()==null || datos.getFirma_Oper_Recibe().equals("")) {
			datos.setFirma_Oper_Recibe(null);
		} else {
			datos.setFirma_Oper_Recibe("Ok");
		}
		return datos;
	}
	
	public FormatoInspeccionPesado eliminaFormatoInspeccionPesado(FormatoInspeccionPesado datos) {
		if(datos.getFirma_Cliente()==null || datos.getFirma_Cliente().equals("")) {
			datos.setFirma_Cliente(null);
		} else {
			datos.setFirma_Cliente("Ok");
		}
		if(datos.getFirma_Agente()==null || datos.getFirma_Agente().equals("")) {
			datos.setFirma_Agente(null);
		} else {
			datos.setFirma_Agente("Ok");
		}
		return datos;
	}

	public FormatoInspeccionMoto eliminaFormatoInspeccionMoto(FormatoInspeccionMoto datos) {
		if(datos.getFirma_Cliente()==null || datos.getFirma_Cliente().equals("")) {
			datos.setFirma_Cliente(null);
		} else {
			datos.setFirma_Cliente("Ok");
		}
		
		if(datos.getFirma_Agente()==null || datos.getFirma_Agente().equals("")) {
			datos.setFirma_Agente(null);
		} else {
			datos.setFirma_Agente("Ok");
		}
		return datos;
	}
	
	public FormatoAdmisionAutomoviles eliminaFormatoAdmisionAutomoviles(FormatoAdmisionAutomoviles datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		if(datos.getOa_codigo_qr()==null || datos.getOa_codigo_qr().equals("")) {
			datos.setOa_codigo_qr(null);
		} else {
			datos.setOa_codigo_qr("Ok");
		}
		return datos;
	}
	
	public FormatoAdmisionMotocicletas eliminaFormatoAdmisionMotocicletas(FormatoAdmisionMotocicletas datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		if(datos.getOa_codigo_qr()==null || datos.getOa_codigo_qr().equals("")) {
			datos.setOa_codigo_qr(null);
		} else {
			datos.setOa_codigo_qr("Ok");
		}
		return datos;
	}

	public FormatoAdmisionPesado eliminaFormatoAdmisionPesado(FormatoAdmisionPesado datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		if(datos.getOp_codigo_qr()==null || datos.getOp_codigo_qr().equals("")) {
			datos.setOp_codigo_qr(null);
		} else {
			datos.setOp_codigo_qr("Ok");
		}
		return datos;
	}
	
	public FormatoAsignacionAbogado eliminaFormatoAsignacionAbogado(FormatoAsignacionAbogado datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		if(datos.getFirma_Abogado()==null || datos.getFirma_Abogado().equals("")) {
			datos.setFirma_Abogado(null);
		} else {
			datos.setFirma_Abogado("Ok");
		}
		if(datos.getFirma_tercero()==null || datos.getFirma_tercero().equals("")) {
			datos.setFirma_tercero(null);
		} else {
			datos.setFirma_tercero("Ok");
		}
		
		return datos;
	}
	
	public FormatoCuestionarioRobo eliminaFormatoCuestionarioRobo(FormatoCuestionarioRobo datos) {
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		return datos;
	}
	
	public FormatoDeclaracionUniversal eliminaFormatoDeclaracionUniversal(FormatoDeclaracionUniversal datos) {
		if(datos.getFirma_Con_B()==null || datos.getFirma_Con_B().equals("")) {
			datos.setFirma_Con_B(null);
		} else {
			datos.setFirma_Con_B("Ok");
		}
		if(datos.getFirma_Responsable()==null || datos.getFirma_Responsable().equals("")) {
			datos.setFirma_Responsable(null);
		} else {
			datos.setFirma_Responsable("Ok");
		}
		
		if(datos.getFirma_Ajus_A()==null || datos.getFirma_Ajus_A().equals("")) {
			datos.setFirma_Ajus_A(null);
		} else {
			datos.setFirma_Ajus_A("Ok");
		}
		if(datos.getFirma_Ajus_B()==null || datos.getFirma_Ajus_B().equals("")) {
			datos.setFirma_Ajus_B(null);
		} else {
			datos.setFirma_Ajus_B("Ok");
		}
		if(datos.getFirma_Con_A()==null || datos.getFirma_Con_A().equals("")) {
			datos.setFirma_Con_A(null);
		} else {
			datos.setFirma_Con_A("Ok");
		}
		if(datos.getDu_Croquis()==null || datos.getDu_Croquis().equals("")) {
			datos.setDu_Croquis(null);
		} else {
			datos.setDu_Croquis("Ok");
		}
		if(datos.getDu_Calca_A()==null || datos.getDu_Calca_A().equals("")) {
			datos.setDu_Calca_A(null);
		} else {
			datos.setDu_Calca_A("Ok");
		}
		if(datos.getDu_Calca_B()==null || datos.getDu_Calca_B().equals("")) {
			datos.setDu_Calca_B(null);
		} else {
			datos.setDu_Calca_B("Ok");
		}
		if(datos.getFirma_Ajus_Qualitas()==null || datos.getFirma_Ajus_Qualitas().equals("")) {
			datos.setFirma_Ajus_Qualitas(null);
		} else {
			datos.setFirma_Ajus_Qualitas("Ok");
		}
		return datos;
	}
	
	public FormatoReciboIngresoSiniestro eliminaFormatoReciboIngresoSiniestro(FormatoReciboIngresoSiniestro datos) {
		if(datos.getRiFirmaAsegurado()==null || datos.getRiFirmaAsegurado().equals("")) {
			datos.setRiFirmaAsegurado(null);
		} else {
			datos.setRiFirmaAsegurado("Ok");
		}
		
		if(datos.getRiFirmaRecibido()==null || datos.getRiFirmaRecibido().equals("")) {
			datos.setRiFirmaRecibido(null);
		} else {
			datos.setRiFirmaRecibido("Ok");
		}
		
		if(datos.getRiFirmaAjustador()==null || datos.getRiFirmaAjustador().equals("")) {
			datos.setRiFirmaAjustador(null);
		} else {
			datos.setRiFirmaAjustador("Ok");
		}
		
		if(datos.getRiFirmaTercero()==null || datos.getRiFirmaTercero().equals("")) {
			datos.setRiFirmaTercero(null);
		} else {
			datos.setRiFirmaTercero("Ok");
		}
		
		return datos;
	}
	
	public FormatoReciboPagoDeducible eliminaFormatoReciboPagoDeducible(FormatoReciboPagoDeducible datos) {
		if(datos.getRdFirmaRecibido()==null || datos.getRdFirmaRecibido().equals("")) {
			datos.setRdFirmaRecibido(null);
		} else {
			datos.setRdFirmaRecibido("Ok");
		}
		return datos;
	}
	
	public FormatoSolicitudDiagnostico eliminaFormatoSolicitudDiagnostico(FormatoSolicitudDiagnostico datos) {
		if(datos.getFirma_Ajustador()==null || datos.getFirma_Ajustador().equals("")) {
			datos.setFirma_Ajustador(null);
		} else {
			datos.setFirma_Ajustador("Ok");
		}
		
		if(datos.getFirma_Asegurado()==null || datos.getFirma_Asegurado().equals("")) {
			datos.setFirma_Asegurado(null);
		} else {
			datos.setFirma_Asegurado("Ok");
		}
		return datos;
	}
	
	public FormatoMemoriaDescriptiva eliminaFormatoMemoriaDescriptiva(FormatoMemoriaDescriptiva datos) {
		if(datos.getCroquis()==null || datos.getCroquis().equals("")) {
			datos.setCroquis(null);
		} else {
			datos.setCroquis("Ok");
		}
		
		if(datos.getFirmaOperadorGrua()==null || datos.getFirmaOperadorGrua().equals("")) {
			datos.setFirmaOperadorGrua(null);
		} else {
			datos.setFirmaOperadorGrua("Ok");
		}
		
		if(datos.getFirmaEmpleado()==null || datos.getFirmaEmpleado().equals("")) {
			datos.setFirmaEmpleado(null);
		} else {
			datos.setFirmaEmpleado("Ok");
		}
		
		if(datos.getFirmaAsegurado()==null || datos.getFirmaAsegurado().equals("")) {
			datos.setFirmaAsegurado(null);
		} else {
			datos.setFirmaAsegurado("Ok");
		}
		return datos;
	}
	
	public FormatoCargoTarjetaCredito eliminaFormatoCargoTarjetaCredito(FormatoCargoTarjetaCredito datos) {
		if(datos.getFirma_tarjetahabiente()==null || datos.getFirma_tarjetahabiente().equals("")) {
			datos.setFirma_tarjetahabiente(null);
		} else {
			datos.setFirma_tarjetahabiente("Ok");
		}
		return datos;
	}
	
	public FormatoResponsabilidadCivil eliminaFormatoResponsabilidadCivil(FormatoResponsabilidadCivil datos) {
		if(datos.getCroquis()==null || datos.getCroquis().equals("")) {
			datos.setCroquis(null);
		} else {
			datos.setCroquis("Ok");
		}
		
		if(datos.getFirma_ajustador()==null || datos.getFirma_ajustador().equals("")) {
			datos.setFirma_ajustador(null);
		} else {
			datos.setFirma_ajustador("Ok");
		}
		
		if(datos.getFirma_asegurado()==null || datos.getFirma_asegurado().equals("")) {
			datos.setFirma_asegurado(null);
		} else {
			datos.setFirma_asegurado("Ok");
		}
		
		if(datos.getFirma_asegurado_tercero()==null || datos.getFirma_asegurado_tercero().equals("")) {
			datos.setFirma_asegurado_tercero(null);
		} else {
			datos.setFirma_asegurado_tercero("Ok");
		}
		return datos;
	}
	
	public FormatoReparacionBienesDiversos eliminaFormatoReparacionBienesDiversos(FormatoReparacionBienesDiversos datos) {
		if(datos.getFirma_ajustador()==null || datos.getFirma_ajustador().equals("")) {
			datos.setFirma_ajustador(null);
		} else {
			datos.setFirma_ajustador("Ok");
		}
		
		if(datos.getIlustracion()==null || datos.getIlustracion().equals("")) {
			datos.setIlustracion(null);
		} else {
			datos.setIlustracion("Ok");
		}
		
		if(datos.getFirma_asegurado_tercero()==null || datos.getFirma_asegurado_tercero().equals("")) {
			datos.setFirma_asegurado_tercero(null);
		} else {
			datos.setFirma_asegurado_tercero("Ok");
		}
		return datos;
	}
	
	public FormatoObservacionesAsegurado eliminaFormatoObservacionesAsegurado(FormatoObservacionesAsegurado datos) {

		if(datos.getFIRMA_CONDUCTOR()==null || datos.getFIRMA_CONDUCTOR().equals("")) {
			datos.setFIRMA_CONDUCTOR(null);
		} else {
			datos.setFIRMA_CONDUCTOR("Ok");
		}
		
		return datos;
	}
	
	public FormatoInventarioUnicoPesado eliminaFormatoInventarioUnicoPesado(FormatoInventarioUnicoPesado datos) {

		if(datos.getFirma_ajustador()==null || datos.getFirma_ajustador().equals("")) {
			datos.setFirma_ajustador(null);
		} else {
			datos.setFirma_ajustador("Ok");
		}
		
		

		if(datos.getFirma_conductor()==null || datos.getFirma_conductor().equals("")) {
			datos.setFirma_conductor(null);
		} else {
			datos.setFirma_conductor("Ok");
		}
		
		
		if(datos.getFirma_operador_grua()==null || datos.getFirma_operador_grua().equals("")) {
			datos.setFirma_operador_grua(null);
		} else {
			datos.setFirma_operador_grua("Ok");
		}
		
		
		if(datos.getFirma_caso1_entrega()==null || datos.getFirma_caso1_entrega().equals("")) {
			datos.setFirma_caso1_entrega(null);
		} else {
			datos.setFirma_caso1_entrega("Ok");
		}
		
		
		if(datos.getFirma_caso1_recibe()==null || datos.getFirma_caso1_recibe().equals("")) {
			datos.setFirma_caso1_recibe(null);
		} else {
			datos.setFirma_caso1_recibe("Ok");
		}
		
		
		//
		if(datos.getFirma_caso2_entrega()==null || datos.getFirma_caso2_entrega().equals("")) {
			datos.setFirma_caso2_entrega(null);
		} else {
			datos.setFirma_caso2_entrega("Ok");
		}
		
		
		if(datos.getFirma_caso2_recibe()==null || datos.getFirma_caso2_recibe().equals("")) {
			datos.setFirma_caso2_recibe(null);
		} else {
			datos.setFirma_caso2_recibe("Ok");
		}
		
		//
		if(datos.getFirma_caso3_entrega()==null || datos.getFirma_caso3_entrega().equals("")) {
			datos.setFirma_caso3_entrega(null);
		} else {
			datos.setFirma_caso3_entrega("Ok");
		}
		
		
		if(datos.getFirma_caso3_recibe()==null || datos.getFirma_caso3_recibe().equals("")) {
			datos.setFirma_caso3_recibe(null);
		} else {
			datos.setFirma_caso3_recibe("Ok");
		}
		
		
		
		
		if(datos.getFirma_recibe_gral()==null || datos.getFirma_recibe_gral().equals("")) {
			datos.setFirma_recibe_gral(null);
		} else {
			datos.setFirma_recibe_gral("Ok");
		}
		
		
		if(datos.getFirma_entrega_gral()==null || datos.getFirma_entrega_gral().equals("")) {
			datos.setFirma_entrega_gral(null);
		} else {
			datos.setFirma_entrega_gral("Ok");
		}
		
		
		return datos;
	}
	
	
	public FormatoReclamacionComprobantePeaje eliminaFormatoReclamacionComprobantePeaje(FormatoReclamacionComprobantePeaje datos) {
 
		if(datos.getFirma_ajustador()==null || datos.getFirma_ajustador().equals("")) {
			datos.setFirma_ajustador(null);
		} else {
			datos.setFirma_ajustador("Ok");
		}	

		if(datos.getFirma_administracion()==null || datos.getFirma_administracion().equals("")) {
			datos.setFirma_administracion(null);
		} else {
			datos.setFirma_administracion("Ok");
		}
		
		if(datos.getFirma_usuario()==null || datos.getFirma_usuario().equals("")) {
			datos.setFirma_usuario(null);
		} else {
			datos.setFirma_usuario("Ok");
		}
		
		
		if(datos.getFirma_testigo1()==null || datos.getFirma_testigo1().equals("")) {
			datos.setFirma_testigo1(null);
		} else {
			datos.setFirma_testigo1("Ok");
		}
		
		if(datos.getFirma_testigo2()==null || datos.getFirma_testigo2().equals("")) {
			datos.setFirma_testigo2(null);
		} else {
			datos.setFirma_testigo2("Ok");
		}
		
		
		return datos;
	}
	
	
	
	

}
