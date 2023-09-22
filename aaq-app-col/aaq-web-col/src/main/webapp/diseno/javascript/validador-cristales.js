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

function validarFormaCristalesSeguimiento(boton) {
	if (document
			.getElementById("forma_pagina_seguimiento:seg_informacion_desde").value.length == 0) {
		alert("ERROR: Es requerido el campo Vigencia Desde");
		document.getElementById(
				"forma_pagina_seguimiento:seg_informacion_desde").focus();
		return false;
	}
	if (document
			.getElementById("forma_pagina_seguimiento:seg_informacion_hasta").value.length == 0) {
		alert("ERROR: Es requerido el campo Vigencia Hasta");
		document.getElementById(
				"forma_pagina_seguimiento:seg_informacion_hasta").focus();
		return false;
	}
	if (document
			.getElementById("forma_pagina_seguimiento:seg_informacion_auth")) {
		if (document
				.getElementById("forma_pagina_seguimiento:seg_informacion_auth").value.length == 0) {
			alert("ERROR: Es requerido el campo Autorizaci\xf3n para generar un reporte si la p\xf3liza no est\xe1 pagada.");
			document.getElementById(
					"forma_pagina_seguimiento:seg_informacion_auth").focus();
			return false;
		}
	}
	ocuparBoton(boton);
	return true;
}
function validarFormaCristalesPoliza(boton) {
	if (document.getElementById("forma_pagina_captura:rep_in").value.length == 0) {
		alert("ERROR: Es requerido el campo Inciso de la P\xf3liza");
		document.getElementById("forma_pagina_captura:rep_in").focus();
		return false;
	}
	if (document.getElementById("forma_pagina_captura:rep_pol").value.length == 0) {
		alert("ERROR: Es requerido el campo N\xfamero de la P\xf3liza");
		document.getElementById("forma_pagina_captura:rep_pol").focus();
		return false;
	}
	ocuparBoton(boton);
	return true;
}
function validarFormaCristalesCaptura(boton) {

	// validar que se escriba un telefono o un email
	if (document
			.getElementById("forma_pagina_captura:reporte_cliente_telefono_uno").value.length == 0
			&& document
					.getElementById("forma_pagina_captura:reporte_cliente_email").value.length == 0) {
		alert("ERROR: Es requerido capturar minimo uno de los siguientes datos de Cliente: Telefono m\xf3vil, Correo Electr\xf3nico.");
		document.getElementById(
				"forma_pagina_captura:reporte_cliente_telefono_uno").focus();
		return false;
	}

	// validar el telefono movil
	if (document
			.getElementById("forma_pagina_captura:reporte_cliente_telefono_uno").value.length != 0) {
		if (document
				.getElementById("forma_pagina_captura:reporte_cliente_telefono_uno").value.length != 10) {
			alert("ERROR: Es requerido capturar el n\xfamero de tel\xe9fono m\xf3vil del cliente en formato de 10 d\xedgitos sin 044");
			document.getElementById(
					"forma_pagina_captura:reporte_cliente_telefono_uno")
					.focus();
			return false;
		}
	}

	// validar quien reporta
	if (document.getElementById("forma_pagina_captura:rep_nombre_quien").value.length == 0) {
		alert("ERROR: Es requerido el campo Nombre de Qui\xe9n Reporta");
		document.getElementById("forma_pagina_captura:rep_nombre_quien")
				.focus();
		return false;
	}

	// validar la validacion del cliente
	if (document
			.getElementById("forma_pagina_captura:campo_validacion_cliente").value.length == 0) {
		alert("ERROR: Es requerido el campo de validaci\xf3n de datos de Cliente. Puede ser su tel\xe9fono o correo electr\xf3nico.");
		document
				.getElementById("forma_pagina_captura:campo_validacion_cliente")
				.focus();
		return false;
	}
	if (document
			.getElementById("forma_pagina_captura:campo_validacion_cliente").value != document
			.getElementById("forma_pagina_captura:reporte_cliente_telefono_uno").value
			&& document
					.getElementById("forma_pagina_captura:campo_validacion_cliente").value != document
					.getElementById("forma_pagina_captura:reporte_cliente_email").value) {
		document
				.getElementById("forma_pagina_captura:campo_validacion_cliente")
				.focus();
		alert("ERROR: El campo de confirmaci\xf3n del Dato Cliente debe ser id\xe9ntico al Tel\xe9fono M\xf3vil o al Correo Electr\xf3nico");
		return false;
	}

	// Validar si el cliente esta en la cristalera
	if (document
			.getElementById("forma_pagina_captura:combo_sugestioncomboboxField")) {
		// validar seleccion de un proveedor
		if (document
				.getElementById("forma_pagina_captura:combo_sugestioncomboboxField").value == "Buscar una direccion de correo electronico") {
			alert("ERROR: Es requerido seleccionar una cristalera de la lista si el cliente ya se encuentra ah\xed");
			document.getElementById(
					"forma_pagina_captura:combo_sugestioncomboboxField")
					.focus();
			return false;
		}

		// validar clave nags
		if (document.getElementById("forma_pagina_captura:rep_cristalera_nags").value.length == 0) {
			alert("ERROR: Es requerido el campo Clave Nags si el cliente est\xe1 en la cristalera");
			document.getElementById("forma_pagina_captura:rep_cristalera_nags")
					.focus();
			return false;
		}

		// validar el precio
		if (document
				.getElementById("forma_pagina_captura:rep_cristalera_precio").value.length == 0) {
			alert("ERROR: Es requerido el campo Precio de la Precio si el ciente est\xe1 en la cristalera");
			document.getElementById(
					"forma_pagina_captura:rep_cristalera_precio").focus();
			return false;
		}

		// validar la confirmacion
		if (document
				.getElementById("forma_pagina_captura:combo_sugestioncomboboxField").value != document
				.getElementById("forma_pagina_captura:campo_validacion_cristalera").value) {
			alert("ERROR: El campo de validaci\xf3n no es id\xe9ntico al campo de correo electr\xf3nico de la cristalera");
			document.getElementById(
					"forma_pagina_captura:combo_sugestioncomboboxField")
					.focus();
			return false;
		}
	}

	// validar las placas
	if (document.getElementById("forma_pagina_captura:veh_pla").value.length == 0) {
		alert("ERROR: Es requerido el campo Placas del Veh\xedculo");
		document.getElementById("forma_pagina_captura:veh_pla").focus();
		return false;
	}
	// validar las serie
	if (document.getElementById("forma_pagina_captura:veh_ser").value.length == 0) {
		alert("ERROR: Es requerido el campo Serie del Veh\xedculo");
		document.getElementById("forma_pagina_captura:veh_ser").focus();
		return false;
	}
	// validar las clave de entidad
	if (document.getElementById("forma_pagina_captura:eve_entidad").value.length == 0) {
		alert("ERROR: Es requerido el campo Clave de Entidad");
		document.getElementById("forma_pagina_captura:busqueda_entidad")
				.focus();
		return false;
	}
	ocuparBoton(boton);
	return true;
}
