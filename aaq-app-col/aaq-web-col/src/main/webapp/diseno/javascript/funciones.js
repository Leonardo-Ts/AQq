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

// Jose Miguel Fernandez / enero 2008
// funciones.js version 1.0
//function abrirVentanaDeMapa() {
//	var ventana = window.open("../SIICAMapa/ventana.siica", "ventana",
//			"height=500,width=600,toolbar=no,scrollbars=no");
//}  
function abrirVentanaDeMapa() {
	 window.open("../SIICAMapa/ventana.siica", '_self',
			"height=500,width=600,toolbar=no,scrollbars=no");
}  

function textCounter(field, countfield, maxlimit) {
	var txtCountfield = document.getElementById(countfield);
	if (field.value.length > maxlimit) {
		field.value = field.value.substring(0, maxlimit);
	} else {
		txtCountfield.value = maxlimit - field.value.length;
	}
} 

function esNumerico(x) {
	return (x - 0) == x && x.length > 0;
}
function moverEnCuatroDigitos(field) {
	if (field.value.length == 4) {
		getNextElement(field).focus();
	}
}


function fieldOnEnter(field, evt, nextField) {
	if (evt.keyCode === 13) {
		if (evt.preventDefault) {
			evt.preventDefault();
		} else if (evt.stopPropagation) {
			evt.stopPropagation();
		} else {
			evt.returnValue = false;
		}
		nextField.focus();
		return false;
	} else {
		return true;
	}
}
 

function getNextElement(field) {
	var form = field.form;
	for ( var e = 0; e < form.elements.length; e++) {
		if (field == form.elements[e]) {
			break;
		}
	}
	return form.elements[++e % form.elements.length];
}

function permitirSoloNumeros(f){
	if (!/^\d*$/.test(f.value)) {
		f.value = f.value.replace(/[^0-9\.]+/g,"");
	}

}


function valorAsterisco(f){
	f.value = f.value.replace(/./g,"*");
}

function validarMaximo(f,max){
	if (parseFloat(f.value) > max){
		alert("Este campo  excede el maximo de: " + max);
		f.value = max;
	}

}

//pads left
String.prototype.lpad = function(padString, length) {
	var str = this;
    while (str.length < length)
        str = padString + str;
    return str;
}


//function createUUID() {
//    // http://www.ietf.org/rfc/rfc4122.txt
//    var s = [];
//    var hexDigits = "0123456789abcdef";
//    for (var i = 0; i < 36; i++) {
//        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
//    }
//    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
//    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
//    s[8] = s[13] = s[18] = s[23] = "-";
//
//    var uuid = s.join("");
//    return uuid;
//}
// ]]>

function isAsistenciaVial(x){
	var tipoAv = PF('tipoAv').getJQ();
	console.log(tipoAv);
	if(x.checked){
		tipoAv.css('display','block')
	}else{
		tipoAv.css('display','none')
	}
}

function isExtraLunes(x){
	var entradaL = PF('entradaL').getJQ();
	var salidaL = PF('salidaL').getJQ();
	if(x.checked){
		entradaL.css('display','block');
		salidaL.css('display','block');
	}else{
		entradaL.css('display','none');
		salidaL.css('display','none');
	}	
}

function isExtraMartes(x){
	var entradaM = PF('entradaM').getJQ();
	var salidaM = PF('salidaM').getJQ();
	if(x.checked){
		entradaM.css('display','block');
		salidaM.css('display','block');
	}else{
		entradaM.css('display','none');
		salidaM.css('display','none');
	}
	
}

function isExtraMiercoles(x){
	var entradaMi = PF('entradaMi').getJQ();
	var salidaMi = PF('salidaMi').getJQ();
	if(x.checked){
		entradaMi.css('display','block');
		salidaMi.css('display','block');
	}else{
		entradaMi.css('display','none');
		salidaMi.css('display','none');
	}
	
}

function isExtraJueves(x){
	var entradaJ = PF('entradaJ').getJQ();
	var salidaJ = PF('salidaJ').getJQ();
	if(x.checked){
		entradaJ.css('display','block');
		salidaJ.css('display','block');
	}else{
		entradaJ.css('display','none');
		salidaJ.css('display','none');
	}
	
}

function isExtraViernes(x){
	var entradaV = PF('entradaV').getJQ();
	var salidaV = PF('salidaV').getJQ();
	if(x.checked){
		entradaV.css('display','block');
		salidaV.css('display','block');
	}else{
		entradaV.css('display','none');
		salidaV.css('display','none');
	}
	
}

function isExtraSabado(x){
	var entradaS = PF('entradaS').getJQ();
	var salidaS = PF('salidaS').getJQ();
	if(x.checked){
		entradaS.css('display','block');
		salidaS.css('display','block');
	}else{
		entradaS.css('display','none');
		salidaS.css('display','none');
	}
	
}

function isExtraDomingo(x){
	var entradaD = PF('entradaD').getJQ();
	var salidaD = PF('salidaD').getJQ();
	if(x.checked){
		entradaD.css('display','block');
		salidaD.css('display','block');
	}else{
		entradaD.css('display','none');
		salidaD.css('display','none');
	}
	
}

function mostrarTipoAV(){
	if(typeof PF('tipoAv') != 'undefined'){
		var tipoAv = PF('tipoAv').getJQ();
//		var asiVial = PF('asiVial').getJQ();
		
		if(PF('asiVial').getJQ().text() === 'Si'){
			tipoAv.css('display','block');
		}else{
			tipoAv.css('display','none');
		}

	}
	
	if(typeof PF('entradaL') != 'undefined'){
		var entradaL = PF('entradaL').getJQ();
		var salidaL = PF('salidaL').getJQ();
		
		if(PF('extraL').getJQ().text() === '-'){
			entradaL.css('display','block');
			salidaL.css('display','block');
		}else{
			entradaL.css('display','none');
			salidaL.css('display','none');
		}
	}
	
	if(typeof PF('entradaM') != 'undefined'){
		var entradaM = PF('entradaM').getJQ();
		var salidaM = PF('salidaM').getJQ();
		
		if(PF('extraM').getJQ().text() == '-'){
			entradaM.css('display','block');
			salidaM.css('display','block');
		}else{
			entradaM.css('display','none');
			salidaM.css('display','none');
		}
	}
	
	if(typeof PF('entradaMi') != 'undefined'){
		var entradaMi = PF('entradaMi').getJQ();
		var salidaMi = PF('salidaMi').getJQ();
		
		if(PF('extraMi').getJQ().text() === '-'){
			entradaMi.css('display','block');
			salidaMi.css('display','block');
		}else{
			entradaMi.css('display','none');
			salidaMi.css('display','none');
		}
	}
	
	if(typeof PF('entradaJ') != 'undefined'){
		var entradaJ = PF('entradaJ').getJQ();
		var salidaJ = PF('salidaJ').getJQ();
		if(PF('extraJ').getJQ().text() === '-'){
			entradaJ.css('display','block');
			salidaJ.css('display','block');
		}else{
			entradaJ.css('display','none');
			salidaJ.css('display','none');
		}
	}
	
	if(typeof PF('entradaV') != 'undefined'){
		var entradaV = PF('entradaV').getJQ();
		var salidaV = PF('salidaV').getJQ();
		if(PF('extraV').getJQ().text() === '-'){
			entradaV.css('display','block');
			salidaV.css('display','block');
		}else{
			entradaV.css('display','none');
			salidaV.css('display','none');
		}
	}

	if (typeof PF('entradaS') != 'undefined') {
		var entradaS = PF('entradaS').getJQ();
		var salidaS = PF('salidaS').getJQ();
		if(PF('extraS').getJQ().text() === '-'){
			entradaS.css('display','block');
			salidaS.css('display','block');
		}else{
			entradaS.css('display','none');
			salidaS.css('display','none');
		}
	}
	
	if (typeof PF('entradaD') != 'undefined') {
		var entradaD = PF('entradaD').getJQ();
		var salidaD = PF('salidaD').getJQ();
		if(PF('extraD').getJQ().text() === '-'){
			entradaD.css('display','block');
			salidaD.css('display','block');
		}else{
			entradaD.css('display','none');
			salidaD.css('display','none');
		}
	}
}

function doSelect(index){
		PF('accordionPanel').select(index);
}

function doUnSelect(index){
	PF('accordionPanel').unselect(index);
}

function estatusInactivo(element) {
    var val = $(element).find('option:selected').text();
    if(val == 'NO DISPONIBLE' || val == 'INACTIVO') {
    	 PF('dlg').show()
    } 
    }

function isReporteValido(x){
	var report = PF('reporteVal').getJQ();
	if(x.checked){
		report.css('display','block')
	}else{
		report.css('display','none')
	}
}

function citas(element) {
    var val = $(element).find('option:selected').text();
    console.log(val);
    if(val == 'Cita' || val == 'C') {
    	 PF('dlgCitas').show()
    } 
    }

function permisos(element){
	 var val = $(element).find('option:selected').text();
	    if(val == 'Incapacidad' || val == 'incapacidad') {
	    	 PF('dlgIncapacidad').show()
	    } 
	    if(val == 'Vacaciones' || val == 'vacaciones') {
	    	 PF('dlgVacaciones').show()
	    } 
	}

//function isIncapacidad(x){
//	var incapacidadias = PF('incapacidadias').getJQ();
//	if(x.checked){
//		incapacidadias.css('display','block')
//	}else{
//		incapacidadias.css('display','none')
//	}
//}
//
//function isVacaciones(x){
//	var diasVacaciones = PF('diasVacaciones').getJQ();
//	if(x.checked){
//		diasVacaciones.css('display','block')
//	}else{
//		diasVacaciones.css('display','none')
//	}
//}

function isIncapacidad(x){
//	var incapacidadias = PF('incapacidadias').getJQ();
	if(x.checked){
		 PF('dlgIncapacidad').show()
	}
}

function isVacaciones(x){
//	var diasVacaciones = PF('diasVacaciones').getJQ();
	if(x.checked){
		 PF('diasVacaciones').show()
	}
}
