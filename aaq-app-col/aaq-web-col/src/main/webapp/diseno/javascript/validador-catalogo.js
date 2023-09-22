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

// Jose Miguel Fernandez / febrero 2011
// validador-catalogo.js version 1.0

function validarFormaConfiguracion() {
	if (document.getElementById("formaPanel:valor").value.length == 0) {
		alert('Error: Es requerido capturar el valor de la configuracion');
		document.getElementById("formaPanel:valor").focus();
		return false;
	}
	return true;
}

function validarFormaBase() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el nombre de la base');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	return true;
}
function validarFormaFrecuencia() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el nombre de la frecuencia');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	return true;
}

function validarFormaGruaProveedor() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el nombre del proveedor');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	if (document.getElementById("formaPanel:razon").value.length == 0) {
		alert('Error: Es requerido capturar la razon social del proveedor');
		document.getElementById("formaPanel:razon").focus();
		return false;
	}
	if (document.getElementById("formaPanel:np").value.length != 5) {
		alert('Error: Es requerido capturar el numero de proveedor de 5 digitos');
		document.getElementById("formaPanel:np").focus();
		return false;
	}
	if (document.getElementById("formaPanel:passwd").value.length == 0) {
		alert('Error: Es requerido capturar la contrasena del proveedor');
		document.getElementById("formaPanel:passwd").focus();
		return false;
	}

	return true;

}

function validarFormaObjeto() {
	var inputs = document.getElementsByTagName("input");

	for ( var i = 0; i < inputs.length; i++) {
		if (inputs[i].getAttribute('type') == 'text'
				&& inputs[i].getAttribute('name').indexOf("ABM") > 0) {
			if (inputs[i].value.length == 0) {
				alert("Error: todos  los campos son requeridos");
				inputs[i].focus();
				return false;
				break;
			}

		}
	}
	return true;

}

function validarFormaPerfil() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el nombre del perfil');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	return true;
}

function validarFormaProveedorAsistencia() {
	if (document.getElementById("formaPanel:razon").value.length == 0) {
		alert('Error: Es requerido capturar el campo Razon Social');
		document.getElementById("formaPanel:razon").focus();
		return false;
	}
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el campo Nombre Comercial');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	if (document.getElementById("formaPanel:cvepres").value.length == 0) {
		alert('Error: Es requerido capturar el campo Clave de Prestador de 5 digitos');
		document.getElementById("formaPanel:cvepres").focus();
		return false;
	}
	if (document.getElementById("formaPanel:usr").value.length == 0) {
		alert('Error: Es requerido capturar el campo Nombre de Usuario');
		document.getElementById("formaPanel:usr").focus();
		return false;
	}
	if (document.getElementById("formaPanel:pass").value.length == 0) {
		alert('Error: Es requerido capturar el campo Contrasena');
		document.getElementById("formaPanel:pass").focus();
		return false;
	}

	return true;
}
function validarFormaUsuario() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el campo Nombre');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}

	if (document.getElementById("formaPanel:usr").value.length == 0) {
		alert('Error: Es requerido capturar el campo Nombre de Usuario');
		document.getElementById("formaPanel:usr").focus();
		return false;
	}
	if (document.getElementById("formaPanel:passwd").value.length == 0
			&& document.getElementById("formaPanel:px").value.length == 0) {
		alert('Error: Es requerido capturar el campo Contrasena');
		document.getElementById("formaPanel:passwd").focus();
		return false;
	}

}

function validarFormaTerminal() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el campo Nombre');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	if (document.getElementById("formaPanel:radio").value.length == 0) {
		alert('Error: Es requerido capturar el campo Numero Radio');
		document.getElementById("formaPanel:radio").focus();
		return false;
	}
	if (document.getElementById("formaPanel:prov").value.length == 0) {
		alert('Error: Es requerido capturar el campo Numero Proveedor');
		document.getElementById("formaPanel:prov").focus();
		return false;
	}
	if (document.getElementById("formaPanel:idgps").value.length == 0) {
		alert('Error: Es requerido capturar el campo Identificador Unico GPS');
		document.getElementById("formaPanel:idgps").focus();
		return false;
	}
	if (document.getElementById("formaPanel:pool").value.length == 0) {
		alert('Error: Es requerido capturar el campo Intervalo de Pool en Minutos');
		document.getElementById("formaPanel:pool").focus();
		return false;
	}

}

function validarFormaCatalogoCapacidad() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el campo nombre');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	if (document.getElementById("formaPanel:descripcion").value.length == 0) {
		alert('Error: Es requerido capturar el campo descripcion');
		document.getElementById("formaPanel:descripcion").focus();
		return false;
	}
	return true;
}
function validarFormaAvqCatalogoServicio() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el campo nombre');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	if (document.getElementById("formaPanel:descripcion").value.length == 0) {
		alert('Error: Es requerido capturar el campo descripcion');
		document.getElementById("formaPanel:descripcion").focus();
		return false;
	}
	if (document.getElementById("formaPanel:limite").value.length == 0) {
		alert('Error: Es requerido capturar el campo limite');
		document.getElementById("formaPanel:limite").focus();
		return false;
	}
	if (document.getElementById("formaPanel:eventos").value.length == 0) {
		alert('Error: Es requerido capturar el campo eventos');
		document.getElementById("formaPanel:eventos").focus();
		return false;
	}
	if (document.getElementById("formaPanel:cobertura").value.length == 0) {
		alert('Error: Es requerido capturar el campo cobertura');
		document.getElementById("formaPanel:cobertura").focus();
		return false;
	}
	return true;
}



function validarFormaTerminalAlerta() {
	if (document.getElementById("formaAlerta:porPuntoInteres").value.length != 0) {
		if (document.getElementById("formaAlerta:metrosPuntoInteres").value.length == 0) {
			alert('Error: Si la alerta es por punto de interes es requerido capturar la distancia en metros a la cual desea la alerta');
			document.getElementById("formaAlerta:metrosPuntoInteres").focus();
			return false;
		}
		if (!esNumerico(document
				.getElementById("formaAlerta:metrosPuntoInteres").value)) {
			alert('Error: La distancia en metros del punto de interes debe de ser numerica');
			document.getElementById("formaAlerta:metrosPuntoInteres").focus();
			return false;
		}
	}

	if (document.getElementById("formaAlerta:velocidadKMH").value.length != 0) {
		if (!esNumerico(document.getElementById("formaAlerta:velocidadKMH").value)) {
			alert('Error: La velocidad definida para la alerta en KM/H debe de ser en formato numerico');
			document.getElementById("formaAlerta:velocidadKMH").focus();
			return false;
		}
	}

	if (document.getElementById("formaAlerta:minutosTiempoParado").value.length != 0) {
		if (!esNumerico(document
				.getElementById("formaAlerta:minutosTiempoParado").value)) {
			alert('Error: La velocidad definida para la alerta en Minutos Tiempo de Parado debe ser en formato numerico');
			document.getElementById("formaAlerta:minutosTiempoParado").focus();
			return false;
		}
	}

	if (document.getElementById("formaAlerta:mail").value.length == 0) {
		alert('Error: Es requerido capturar el campo Correo Electronico');
		document.getElementById("formaAlerta:mail").focus();
		return false;

	}
	if (document.getElementById("formaAlerta:telefonosms").value.length != 0) {
		if (!esNumerico(document.getElementById("formaAlerta:telefonosms").value)) {
			alert('Error: El numero telefonico SMS debe ser numerico de 10 digitos');
			document.getElementById("formaAlerta:telefonosms").focus();
			return false;
		}
		if (document.getElementById("formaAlerta:telefonosms").value.length != 10) {
			alert('Error: El numero telefonico SMS debe ser numerico de 10 digitos');
			document.getElementById("formaAlerta:telefonosms").focus();
			return false;
		}

	}

	if ((document.getElementById("formaAlerta:porPuntoInteres").value.length == 0)
			&& (document.getElementById("formaAlerta:geocercaEntra").value.length == 0)
			&& (document.getElementById("formaAlerta:geocercaSale").value.length == 0)
			&& (document.getElementById("formaAlerta:velocidadKMH").value.length == 0)
			&& (document.getElementById("formaAlerta:minutosTiempoParado").value.length == 0)) {
		alert('Error: Es requerido selecionar por lo menos un parametro para esta alerta (Punto Interes, Geocerca, Velocidad, etc)');
		return false;

	}

	return true;

}



function validarFormaAgenciaTaller() {
	if (document.getElementById("formaPanel:numero").value.length == 0) {
		alert('Error: Es requerido capturar el campo numero');
		document.getElementById("formaPanel:numero").focus();
		return false;
	}
	if (document.getElementById("formaPanel:nombre_comercial").value.length == 0) {
		alert('Error: Es requerido capturar el campo Nombre Comercial');
		document.getElementById("formaPanel:nombre_comercial").focus();
		return false;
	}
	if (document.getElementById("formaPanel:razon_social").value.length == 0) {
		alert('Error: Es requerido capturar el campo Razon Social');
		document.getElementById("formaPanel:razon_social").focus();
		return false;
	}
	if (document.getElementById("formaPanel:marca").value.length == 0) {
		alert('Error: Es requerido capturar el campo Marca');
		document.getElementById("formaPanel:marca").focus();
		return false;
	} 
	return true;
}


function validarFormaAvqPension() {
	if (document.getElementById("formaPanel:domicilio").value.length == 0) {
		alert('Error: Es requerido capturar el campo domicilio');
		document.getElementById("formaPanel:domicilio").focus();
		return false;
	}
	if (document.getElementById("formaPanel:proveedor").value.length == 0) {
		alert('Error: Es requerido capturar el campo Proveedor');
		document.getElementById("formaPanel:proveedor").focus();
		return false;
	}
	return true;
}

function validarFormaAvqArrastre() {
	if (document.getElementById("formaPanel:nombre").value.length == 0) {
		alert('Error: Es requerido capturar el campo nombre');
		document.getElementById("formaPanel:nombre").focus();
		return false;
	}
	return true;
}





function validarFormaAvqCatalogoServicioResumido() {
	if (document.getElementById("formaPanel:descripcion").value.length == 0) {
		alert('Error: Es requerido capturar el campo descripcion');
		document.getElementById("formaPanel:descripcion").focus();
		return false;
	}
	return true;
}




function validarFormaAvqCatalogoPolizaEspecial() {
	if (document.getElementById("formaPanel:poliza").value.length == 0) {
		alert('Error: Es requerido capturar el campo Poliza');
		document.getElementById("formaPanel:poliza").focus();
		return false;
	}
	return true;
}

function validarFormaComunicado() {
	if (document.getElementById("formaPanel:p_msg").value.length == 0) {
		alert('Error: Es requerido capturar el campo Mensaje');
		document.getElementById("formaPanel:p_msg").focus();
		return false;
	}
	return true;
}


// ]]>
