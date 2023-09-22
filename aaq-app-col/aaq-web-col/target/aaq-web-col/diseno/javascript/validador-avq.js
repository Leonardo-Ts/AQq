/*
 * Propietario y confidencial.
 *
 * Copyright (C) Integracion de Sistemas de Avanzada Tecnologia, SA de CV - Todos los Derechos Reservados.
 * La copia no autorizada de este archivo, por cualquier medio, esta estrictamente prohibida
 * Los contenidos de este archivo estan sujetos a cambio en cualquier momento sin aviso previo.
 * Este documento no confiere al receptor el derecho o licencia de hacer, usar, vender o practicar cualquier
 * tecnologia o metodos descritos en el mismo.
 * Ninguno de los contenidos, en su totalidad o en partes, pueden ser copiados o distribidos por cualquier
 * medio fisico o electronico sin el consentimiento previo, expreso y escrito de
 * Integracion de  Sistemas de Avanzada Tecnologia
 *
 * Proprietary and confidential
 *
 * Copyright (C) Controltrack, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * All information contained herein is, and remains
 * the property of Controltrack Inc and its suppliers, if any.
 * The intellectual and technical concepts contained herein are proprietary to Controltrack Inc.
 *
 *
 * Desarrolloado por Jose Miguel Fernandez <mfernandez@controltrack.net>, Octubre 2005 - Marzo 2015
 *
 *
 */

//<![CDATA[

// Jose Miguel Fernandez / abril 2011
// validador-avq.js version 1.0
function validaNuevoReporte() {
	if ($('#formaNuevoReporte\\:repo_pn').val().length == 0) {
		alert('Error: Es requerido capturar el numero de poliza');
		return false;
	}
	if ($('#formaNuevoReporte\\:repo_pi').val().length == 0) {
		alert('Error: Es requerido capturar el inciso de poliza');
		return false;
	}
	if ($('#formaNuevoReporte\\:repo_tipo_serv').val().length == 0) {
		alert('Error: Es requerido capturar el campo tipo de servicio');
		return false;
	}

	return true;
}

function validarFormaReporte() {
	if ($("#formaABM\\:nombre").val().length == 0) {
		alert('Error: Es requerido capturar el nombre de la base');
		$("#formaABM\\:nombre").focus();
		return false;
	}
	return true;
}

function validarFormaReporteAVQ() {
	if ($("#formaAVQ\\:rep_mun_serv")   && $("#formaAVQ\\:rep_mun_serv").val().length == 0) {
		alert('Error: Es requerido capturar la Entidad donde se solicita el Servicio');
		$("#formaAVQ\\:rep_mun_serv").focus();
		return false;
	}
	if ($("#formaAVQ\\:repo_tipo_serv")   && $("#formaAVQ\\:repo_tipo_serv").val().length == 0) {
		alert('Error: Es requerido capturar el campo Beneficio Solicitado');
		$("#formaAVQ\\:repo_tipo_serv").focus();
		return false;
	}
	return true;

}

function validarFormaAdminEliminarTicket() {
	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}

	return confirm('Esta seguro de que desea eliminar el Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ ". Esta accion es final y NO se puede deshacer.");
}

function validarFormaAdminAsignarReporte() {

	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}
	if ($("#formaAdministracion\\:adm_num_repo").val().length == 0) {
		alert('Error: Es requerido capturar numero de Reporte. ');
		$("#formaAdministracion\\:adm_num_repo").focus();
		return false;
	}

	return confirm('Esta seguro de que desea asignar al Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ " el numero de reporte "
			+ $("#formaAdministracion\\:adm_num_repo").val()
			+ "?");
}

function validarFormaAdminAsignarProveedor() {

	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}
	if ($("#formaAdministracion\\:adm_clav_prov").val().length == 0) {
		alert('Error: Es requerido capturar la clave del proveedor. ');
		$("#formaAdministracion\\:adm_clav_prov").focus();
		return false;
	}

	return confirm('Esta seguro de que desea asignar al Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ " el proveedor con clave "
			+ $("#formaAdministracion\\:adm_clav_prov").val()
			+ "?");
}

function validarFormaAdminReasignarTicket() {
	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}

	return confirm('Esta seguro de que desea reasignar el Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ "?");
}

function validarFormaAdminAsignarFolio() {

	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}
	if ($("#formaAdministracion\\:adm_folio").val().length == 0) {
		alert('Error: Es requerido capturar el folio electronico. ');
		$("#formaAdministracion\\:adm_folio").focus();
		return false;
	}

	return confirm('Esta seguro de que desea asignar al Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ " el folio "
			+ $("#formaAdministracion\\:adm_folio").val()
			+ "?");
}

function validarFormaAdminArribarTicket() {
	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}

	return confirm('Esta seguro de que desea reasignar el Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ "?");
}


function validarFormaAdminAsignarPoliza() {
	if ($("#formaAdministracion\\:adm_poliza").val().length == 0) {
		alert('Error: Es requerido capturar numero de Poliza ');
		$("#formaAdministracion\\:adm_poliza").focus();
		return false;
	}

	return confirm('Esta seguro de que desea asignar el numero de poliza capturado al Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ "?");
}


function validarFormaAdminAsignarInciso() {
	if ($("#formaAdministracion\\:adm_inciso").val().length == 0) {
		alert('Error: Es requerido capturar numero de Inciso');
		$("#formaAdministracion\\:adm_inciso").focus();
		return false;
	}

	return confirm('Esta seguro de que desea asignar el numero de inciso capturado al Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ "?");
}


function validarFormaAdminAsignarSiniestro() {

	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}
	if ($("#formaAdministracion\\:adm_siniestro").val().length == 0) {
		alert('Error: Es requerido capturar el numero de siniestro. ');
		$("#formaAdministracion\\:adm_siniestro").focus();
		return false;
	}

	return confirm('Esta seguro de que desea asignar al Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ " el numero de siniestro "
			+ $("#formaAdministracion\\:adm_siniestro").val()
			+ "?");
}


function validarFormaAdminCierreReporte() {

	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}
	if ($("#formaAdministracion\\:adm_costo").val().length == 0) {
		alert('Error: Es requerido capturar el costo de cierre de este reporte. ');
		$("#formaAdministracion\\:adm_costo").focus();
		return false;
	}

	return confirm('Esta seguro de que desea cerrar el Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ " poniendo como costo\\: "
			+ $("#formaAdministracion\\:adm_costo").val()
			+ "?");
}


function validarFormaAdminRevivirSiniestro() {

	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}
	return confirm('Esta seguro de que desea reabrir el Ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ "?");
}


function validarFormaAdminEnviarSMS() {

	if ($("#formaAdministracion\\:adm_ticket").val().length == 0) {
		alert('Error: Es requerido capturar numero de Ticket. ');
		$("#formaAdministracion\\:adm_ticket").focus();
		return false;
	}
	if ($("#formaAdministracion\\:adm_sms").val().length == 0) {
		alert('Error: Es requerido capturar el tiempo estimado de arribo. ');
		$("#formaAdministracion\\:adm_sms").focus();
		return false;
	}
	return confirm('Esta seguro de que desea enviar el SMS para el ticket '
			+ $("#formaAdministracion\\:adm_ticket").val()
			+ "?");
}

function validarFormaCita(){
	if ($("#formaAVQ\\:fecha_cita").val().length == 0) {
		alert('Error: Es requerido capturar la fecha de la cita');
		$("#formaAVQ\\:fecha_cita").focus();
		return false;
	}
	return true;
}

function validarFormaOficina(){
	return true;
}

function validarFormaGeocerca(){
	return true;
}

function validarFormaPuntoInteres(){
	return true;
}
// ]]>
