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
$(document).ready(function() {
	 
	
	$('input[type=text],select').keydown(function(event) { // event==Keyevent
		if (event.which == 13) {
			var inputs = $(this).closest('form').find(':input:visible');
			inputs.eq(inputs.index(this) + 1).focus();
			event.preventDefault(); // Disable standard Enterkey action
		}
	});

});



// ]]>

