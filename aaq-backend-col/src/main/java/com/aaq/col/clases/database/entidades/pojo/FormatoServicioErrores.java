package com.aaq.col.clases.database.entidades.pojo;

public class FormatoServicioErrores {

	public String errorAsistenciaVial(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"AV_NUM_REPORTE\"") ? "Número de reporte"
				: resultado.contains("\"AV_NUM_POLIZA\"") ? "Número de póliza"
						: resultado.contains("\"AV_NUM_INCISO\"") ? "Número de inciso"
								: resultado.contains("\"AV_COMENTARIOS\"") ? "Comentarios"
										: resultado.contains("\"AV_NOM_ASEGURADO\"") ? "Nombre del asegurado"
												: resultado.contains("\"AV_EMAIL\"") ? "Email"
														: resultado.contains("\"AV_CLAVE_AJUSTADOR\"")
																? "Clave del ajustador"
																		: resultado.contains("\"CORREO_OCULTO\"")
																		? "Correo oculto"
																: null;

		return descripcion_campo;
	}

	public String errorValeAmbulancia(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
						resultado.contains("\"VA_NUM_REPORTE\"") ? "Número de Reporte"
				: resultado.contains("\"VA_NUM_SINIESTRO\"") ? "Número de Siniestro"
						: resultado.contains("\"VA_FOLIO_ELECTRO\"") ? "Folio Electrónico"
								: resultado.contains("\"VA_ASEGURADO\"") ? "Número asegurado/tercero"
										: resultado.contains("\"VA_NUM_POLIZA\"") ? "Número de Póliza"
												: resultado.contains("\"VA_NUM_ENDOSO\"") ? "Número de Endoso"
														: resultado.contains("\"VA_NUM_INCISO\"") ? "Número de Inciso"
																: resultado.contains("\"VA_NOM_RAZON\"")
																		? "Nombre y Apellidos o Denominación Social"
																		: resultado.contains("\"VA_HOSPITAL\"")
																				? "Hospital a donde se traslada"
																				: resultado
																						.contains("\"VA_NOM_PACIENTE\"")
																								? "Nombre del Paciente"
																								: resultado.contains(
																										"\"VA_TEL_PACIENTE\"")
																												? "Teléfono del Paciente"
																												: resultado
																														.contains(
																																"\"VA_DIR_PACIENTE\"")
																																		? "Dirección del Paciente"
																																		: resultado
																																				.contains(
																																						"\"VA_EDAD_PACIENTE\"")
																																								? "Edad del Paciente"
																																								: resultado
																																										.contains(
																																												"\"VA_DIAGNOSTICO\"")
																																														? "Diagnóstico Preliminar"
																																														: resultado
																																																.contains(
																																																		"\"VA_LUGAR\"")
																																																				? "Lugar"
																																																				: resultado
																																																						.contains(
																																																								"\"VA_NOM_AJUSTADOR\"")
																																																										? "Nombre del Ajustador"
																																																										: resultado
																																																												.contains(
																																																														"\"VA_DATOS_CONDUCTOR\"")
																																																																? "Nombre del Conductor"
																																																																: resultado
																																																																		.contains(
																																																																				"\"VA_DATOS_LESIONADO\"")
																																																																						? "Nombre del Lesionado"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"VA_EMAIL_DEFAULT\"")
																																																																												? "Email"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"VA_CLAVE_AJUSTADOR\"")
																																																																																		? "Clave del Ajustador"
																																																																																		: null;

		return descripcion_campo;
	}

	public String errorReclamacionPendiente(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"RP_DATOS_OFICINA\"") ? "Datos de la oficina"
			:resultado.contains("\"RP_NOM_AJUSTADOR\"") ? "Nombre del Ajustador"
				: resultado.contains("\"RP_NUM_RECLAMACION\"") ? "Número de Reclamación"
						: resultado.contains("\"RP_NUM_POLIZA\"") ? "Número de Póliza"
								: resultado.contains("\"RP_OBS_ENDOSO_ACLARA\"") ? "Endoso aclaratorio"
										: resultado.contains("\"RP_OBSERVACIONES\"") ? "Observaciones"
												: resultado.contains("\"RP_NOM_CONDUCTOR\"") ? "Nombre del conductor"
														: resultado.contains("\"RP_NUM_REPORTE\"") ? "Número de Reporte"
																: resultado.contains("\"RP_NUM_INCISO\"")
																		? "Número de inciso"
																		: resultado.contains("\"EMAIL_DEFAULT\"")
																				? "Email"
																				: resultado.contains(
																						"\"RP_NOMBRE_CONDUCTOR\"")
																								? "Nombre del conductor"
																								: resultado.contains(
																										"\"RP_CLAVE_AJUSTADOR\"")
																												? "Clave del ajustador"
																												: null;

		return descripcion_campo;
	}

	public String errorEncuestaServicio(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"ES_NUM_REPORTE\"") ? "Número de Reporte"
				: resultado.contains("\"ES_NUM_SINIESTRO\"") ? "Número de Siniestro"
						: resultado.contains("\"ES_NOM_ASEGURADO\"") ? "Nombre del Asegurado"
								: resultado.contains("\"ES_OBSERVACIONES\"") ? "Observaciones"
										: resultado.contains("\"ES_NOM_CONDUCTOR\"") ? "Nombre del Conductor"
												: resultado.contains("\"ES_TEL_CONDUCTOR\"") ? "Teléfono del Conductor"
														: resultado.contains("\"ES_EMAIL_CONDUCTOR\"")
																? "Email del Conductor"
																: resultado.contains("\"ES_LUGAR\"") ? "Lugar"
																		: resultado.contains("\"ES_NUM_POLIZA\"")
																				? "Número de Pólia"
																				: resultado
																						.contains("\"ES_NUM_INCISO\"")
																								? "Número de Inciso"
																								: resultado.contains(
																										"\"ES_CLAVE_AJUSTADOR\"")
																												? "Clave del Ajustador"
																												: null;

		return descripcion_campo;
	}

	public String errorOrdenServicio(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"OS_POLIZA\"") ? "Número de Póliza"
				: resultado.contains("\"OS_NUM_REPORTE\"") ? "Número de Reporte"
						: resultado.contains("\"OS_NUM_SINIESTRO\"") ? "Número de Siniestro"
								: resultado.contains("\"OS_NOM_CONDUCTOR\"") ? "Nombre del conductor"
										: resultado.contains("\"OS_LUGAR_SERVICIO\"") ? "Lugar de servicio"
												: resultado.contains("\"OS_TEL_CONDUCTOR\"") ? "Teléfono del conductor"
														: resultado.contains("\"OS_SEXO_CONDUCTOR\"")
																? "Sexo del conductor"
																: resultado.contains("\"OS_EMAIL_CONDUCTOR\"")
																		? "Email del conductor"
																		: resultado.contains("\"OS_MARCA_AUTO\"")
																				? "Marca del auto"
																				: resultado.contains("\"OS_TIPO_AUTO\"")
																						? "Tipo de auto"
																						: resultado.contains(
																								"\"OS_ANIO_AUTO\"")
																										? "Anio de auto"
																										: resultado
																												.contains(
																														"\"OS_MODELO_AUTO\"")
																																? "Modelo del auto"
																																: resultado
																																		.contains(
																																				"\"OS_PLACAS_AUTO\"")
																																						? "Placas del auto"
																																						: resultado
																																								.contains(
																																										"\"OS_NUM_SERIE_AUTO\"")
																																												? "Número de serie del auto"
																																												: resultado
																																														.contains(
																																																"\"OS_INFORME_AJUSTADOR\"")
																																																		? "Informe del Ajustador"
																																																		: resultado
																																																				.contains(
																																																						"\"OS_NOM_AJUSTADOR\"")
																																																								? "Nombre del Ajustador"
																																																								: resultado
																																																										.contains(
																																																												"\"OS_CLAVE\"")
																																																														? "Clave del Ajustador"
																																																														: resultado
																																																																.contains(
																																																																		"\"OS_NUM_INCISO\"")
																																																																				? "Número de Inciso"
																																																																				: null;

		return descripcion_campo;
	}

	public String errorGarantiaPrendaria(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"GP_SR\"") ? "Nombre sr/sra"
				: resultado.contains("\"GP_SR_CALLE\"") ? "Calle"
						: resultado.contains("\"GP_SR_COLONIA\"") ? "Colonia"
								: resultado.contains("\"GP_SR_MUNICIPIO\"") ? "Municipio"
										: resultado.contains("\"GP_SR_CP\"") ? "Código postal"
												: resultado.contains("\"GP_SR_CIUDAD\"") ? "Ciudad"
														: resultado.contains("\"GP_SR_IDENTIFICACION\"")
																? "Identificación"
																: resultado.contains("\"GP_CANTIDAD\"")
																		? "Cantidad número"
																		: resultado.contains("\"GP_CANTIDAD_LETRA\"")
																				? "Cantidad letra"
																				: resultado
																						.contains("\"GP_MARCA_AUTO\"")
																								? "Marca del auto"
																								: resultado.contains(
																										"\"GP_TIPO_AUTO\"")
																												? "Tipo de auto"
																												: resultado
																														.contains(
																																"\"GP_MODELO_AUTO\"")
																																		? "Modelo del auto"
																																		: resultado
																																				.contains(
																																						"\"GP_PLACAS_AUTO\"")
																																								? "Placas del auto"
																																								: resultado
																																										.contains(
																																												"\"GP_COLOR_AUTO\"")
																																														? "Color del auto"
																																														: resultado
																																																.contains(
																																																		"\"GP_NUM_POLIZA\"")
																																																				? "Número de Póliza"
																																																				: resultado
																																																						.contains(
																																																								"\"GP_BIENES\"")
																																																										? "Bienes"
																																																										: resultado
																																																												.contains(
																																																														"\"GP_FACTURA\"")
																																																																? "Factura"
																																																																: resultado
																																																																		.contains(
																																																																				"\"GP_FACTURA_EXPEDIDA\"")
																																																																						? "Factura expedida"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"GP_DIAS\"")
																																																																												? "Días"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"GP_NOM_DEUDOR\"")
																																																																																		? "Nombre del Deudor"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"GP_NOM_ACREEDOR\"")
																																																																																								? "Nombre del Acreedor"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"GP_NUM_REPORTE\"")
																																																																																														? "Número de Reporte"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"GP_NUM_INCISO\"")
																																																																																																				? "Número de Inciso"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"EMAIL_DEFAULT\"")
																																																																																																										? "Email"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"GP_ASEGURADO\"")
																																																																																																																? "Nombre del Asegurado"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"GP_CLAVE_AJUSTADOR\"")
																																																																																																																						? "Clave del Ajustador"
																																																																																																																						: null;

		return descripcion_campo;
	}

	public String errorNuevosVehiculos(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"NV_SOLICITANTE\"") ? "Solicitante"
				: resultado.contains("\"NV_OFICNA\"") ? "Oficina"
						: resultado.contains("\"NV_UBICACION\"") ? "Ubicación"
								: resultado.contains("\"NV_EMAIL\"") ? "Email"
										: resultado.contains("\"NV_UNIDAD_AUTO\"") ? "Datos de la unidad: unidad"
												: resultado.contains("\"NV_TIPO_AUTO\"") ? "Datos de la unidad: tipo"
														: resultado.contains("\"NV_MODELO_AUTO\"")
																? "Datos de la unidad: modelo"
																: resultado.contains("\"NV_MOTOR_AUTO\"")
																		? "Datos de la unidad: motor"
																		: resultado.contains("\"NV_NUM_SERIE_AUTO\"")
																				? "Datos de la unidad: número de serie"
																				: resultado.contains(
																						"\"NV_KILOMETROS_AUTO\"")
																								? "Datos de la unidad: kilometraje"
																								: resultado.contains(
																										"\"NV_PUERTAS_AUTO\"")
																												? "Datos de la unidad: número de puertas"
																												: resultado
																														.contains(
																																"\"NV_TRANSMISION_AUTO\"")
																																		? "Datos de la unidad: transmisión"
																																		: resultado
																																				.contains(
																																						"\"NV_OBSERVACIONES_AUTO\"")
																																								? "Datos de la unidad: observaciones"
																																								: resultado
																																										.contains(
																																												"\"NV_PROCEDENCIA_AUTO\"")
																																														? "Datos de la unidad: procedencia"
																																														: resultado
																																																.contains(
																																																		"\"NV_DERIVADA_AUTO\"")
																																																				? "Datos de la unidad: unidad derivada"
																																																				: resultado
																																																						.contains(
																																																								"\"NV_FOTO_SERIE\"")
																																																										? "Fotografia en número de serie"
																																																										: resultado
																																																												.contains(
																																																														"\"NV_FOTO_MOTOR\"")
																																																																? "Fotografia en número de motor"
																																																																: resultado
																																																																		.contains(
																																																																				"\"NV_TOTAL_FOTOS\"")
																																																																						? "Total de fotografias"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"NV_TIPO_EMPLEADO\"")
																																																																												? "Tipo de empleado"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"NV_NOMBRE_CLIENTE\"")
																																																																																		? "Nombre del cliente"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"NV_NOMBRE_AJUSTADOR\"")
																																																																																								? "Nombre del Ajustador"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"NV_TEL_SOLICITANTE\"")
																																																																																														? "Teléfono del solicitante"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"NV_CLAVE_AJUSTADOR\"")
																																																																																																				? "Clave del Ajustador"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"NV_NUM_REPORTE\"")
																																																																																																										? "Número de Reporte"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"NV_NUM_POLIZA\"")
																																																																																																																? "Número de Póliza"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"NV_NUM_INCISO\"")
																																																																																																																						? "Número de Inciso"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"NV_ASEGURADO\"")
																																																																																																																												? "Nombre del Asegurado"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"NV_PLACAS\"")
																																																																																																																																		? "Placas"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"NV_DANIOS_PRE\"")
																																																																																																																																								? "Danios Preexistentes"
																																																																																																																																								: null;

		return descripcion_campo;
	}

	public String errorReparacionBienes(String resultado) {
		String descripcion_campo = null;
		descripcion_campo =resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"RB_NUM_REPORTE\"") ? "Número del Reporte"
				: resultado.contains("\"RB_NUM_SINIESTRO\"") ? "Número de Siniestro"
						: resultado.contains("\"RB_FOLIO_ELECTRO\"") ? "Folio Electrónico"
								: resultado.contains("\"RB_NUM_POLIZA\"") ? "Número de Póliza"
										: resultado.contains("\"RB_NUM_ENDOSO\"") ? "Número de Endoso"
												: resultado.contains("\"RB_NUM_INCISO\"") ? "Número de Inciso"
														: resultado.contains("\"RB_NOM_REPARA\"")
																? "Nombre/razón social (Repara)"
																: resultado.contains("\"RB_EMAIL_REPARA\"") ? "Correo"
																		: resultado.contains("\"RB_TEL_REPARA\"")
																				? "Teléfono"
																				: resultado
																						.contains("\"RB_NOM_AFECTADO\"")
																								? "Nombre del afectado"
																								: resultado.contains(
																										"\"RB_REPRE_AFECTADO\"")
																												? "Representante"
																												: resultado
																														.contains(
																																"\"RB_TEL_AFECTADO\"")
																																		? "Teléfono del afectado"
																																		: resultado
																																				.contains(
																																						"\"RB_DOM_AFECTADO\"")
																																								? "Domicilio del afectado"
																																								: resultado
																																										.contains(
																																												"\"RB_MED_LONG\"")
																																														? "Medida: longitud"
																																														: resultado
																																																.contains(
																																																		"\"RB_MED_ALTO\"")
																																																				? "Medida: alto"
																																																				: resultado
																																																						.contains(
																																																								"\"RB_MED_ANCHO\"")
																																																										? "Medida: ancho"
																																																										: resultado
																																																												.contains(
																																																														"\"RB_CAR_MARCA\"")
																																																																? "Características: marca"
																																																																: resultado
																																																																		.contains(
																																																																				"\"RB_CAR_MODELO\"")
																																																																						? "Características: modelo"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"RB_TRAMO\"")
																																																																												? "Tramo"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"RB_KM\"")
																																																																																		? "Kilometro"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"RB_OBSERVACIONES\"")
																																																																																								? "Observaciones"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"RB_DES_DANIOS\"")
																																																																																														? "Descripción de Danios"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"RB_NUM_FOTOS\"")
																																																																																																				? "Número de fotos"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"RB_OTROS\"")
																																																																																																										? "Otros"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"RB_NOM_AJUSTADOR\"")
																																																																																																																? "Nombre del Ajustador"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"RB_CLAVE_AJUSTADOR\"")
																																																																																																																						? "Clave del Ajustador"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"RB_ASEGURADO\"")
																																																																																																																												? "Nombre del asegurado/tercero"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"RB_MUNICIPIO\"")
																																																																																																																																		? "Colonia/Municipio"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"RB_ESTADO\"")
																																																																																																																																								? "Estado"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"RB_NOM_ASEGURADO\"")
																																																																																																																																														? "Nombre del asegurado"
																																																																																																																																														: resultado
																																																																																																																																																.contains(
																																																																																																																																																		"\"RB_EMAIL_AFECTADO\"")
																																																																																																																																																				? "Correo afectado"
																																																																																																																																																				: null;

		return descripcion_campo;
	}

	public String errorPaseMedico(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"PM_FOLIO_ELECTRO\"") ? "Folio Electrónico"
				: resultado.contains("\"PM_NUM_REPORTE\"") ? "Número de Reporte"
						: resultado.contains("\"PM_NUM_SINIESTRO\"") ? "Número de Siniestro"
								: resultado.contains("\"PM_NUM_POLIZA\"") ? "Número de Poliza"
										: resultado.contains("\"PM_NUM_INCISO\"") ? "Número de Inciso"
												: resultado.contains("\"PM_NUM_ENDOSO\"") ? "Número de Endoso"
														: resultado.contains("\"PM_NOM_ASEGURADO\"")
																? "Nombre del asegurado"
																: resultado.contains("\"PM_EMAIL_ASEGURADO\"")
																		? "Email del asegurado"
																		: resultado.contains("\"PM_LUGAR_EMISION\"")
																				? "Lugar de emision"
																				: resultado
																						.contains("\"PM_LUGAR_ESTADO\"")
																								? "Población y estado de emisión"
																								: resultado.contains(
																										"\"PM_NUM_OCUPANTES\"")
																												? "Número de ocupantes"
																												: resultado
																														.contains(
																																"\"PM_TIPO_VEHICULO\"")
																																		? "Tipo de vehículo"
																																		: resultado
																																				.contains(
																																						"\"PM_OTRO_VEHICULO\"")
																																								? "Otro vehículo"
																																								: resultado
																																										.contains(
																																												"\"PM_CAUSA_LESION\"")
																																														? "Causas de lesión"
																																														: resultado
																																																.contains(
																																																		"\"PM_OTRA_LESION\"")
																																																				? "Otra lesión"
																																																				: resultado
																																																						.contains(
																																																								"\"PM_COBERTURA_AFEC\"")
																																																										? "Cobertura afectada"
																																																										: resultado
																																																												.contains(
																																																														"\"PM_OTRA_COBERTURA\"")
																																																																? "Otra cobertura afectada"
																																																																: resultado
																																																																		.contains(
																																																																				"\"PM_NOM_LESIONADO\"")
																																																																						? "Nombre del lesionado"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"PM_EDAD_LESIONADO\"")
																																																																												? "Edad del lesionado"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"PM_TEL_LESIONADO\"")
																																																																																		? "Teléfono del lesionado"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"PM_NUM_LESIONADO\"")
																																																																																								? "Número del lesionado"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"PM_AMBULATORIA\"")
																																																																																														? "Tipo de atención"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"PM_IDE_LESIONADO\"")
																																																																																																				? "Identificación del lesionado"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"PM_LESIONES_APARENTES\"")
																																																																																																										? "Lesiones aparentes"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"PM_TIPO_CLINICA\"")
																																																																																																																? "Tipo de clínica"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"PM_CONVENIO\"")
																																																																																																																						? "En convenio"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"PM_CLAVE_CLINICA\"")
																																																																																																																												? "Clave de clínica"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"PM_NOM_CLINICA\"")
																																																																																																																																		? "Nombre de la clínica"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"PM_DOM_CLINICA\"")
																																																																																																																																								? "Domicilio de la clínica"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"PM_TEL_CLINICA\"")
																																																																																																																																														? "Teléfono de la clínica"
																																																																																																																																														: resultado
																																																																																																																																																.contains(
																																																																																																																																																		"\"PM_MEDICO_RED\"")
																																																																																																																																																				? "Médico de red"
																																																																																																																																																				: resultado
																																																																																																																																																						.contains(
																																																																																																																																																								"\"PM_CLAVE_MEDICO\"")
																																																																																																																																																										? "Clave del médico"
																																																																																																																																																										: resultado
																																																																																																																																																												.contains(
																																																																																																																																																														"\"PM_NOM_MEDICO\"")
																																																																																																																																																																? "Nombre del médico"
																																																																																																																																																																: resultado
																																																																																																																																																																		.contains(
																																																																																																																																																																				"\"PM_TEL_MEDICO\"")
																																																																																																																																																																						? "Teléfono del médico"
																																																																																																																																																																						: resultado
																																																																																																																																																																								.contains(
																																																																																																																																																																										"\"PM_NOM_AJUSTADOR\"")
																																																																																																																																																																												? "Nombre del Ajustador"
																																																																																																																																																																												: resultado
																																																																																																																																																																														.contains(
																																																																																																																																																																																"\"PM_CLAVE_AJUSTADOR\"")
																																																																																																																																																																																		? "Clave del Ajustador"
																																																																																																																																																																																		: resultado
																																																																																																																																																																																				.contains(
																																																																																																																																																																																						"\"PM_ASEGURADO\"")
																																																																																																																																																																																								? "Asegurado"
																																																																																																																																																																																								: resultado
																																																																																																																																																																																										.contains(
																																																																																																																																																																																												"\"PM_EMAIL_LESIONADO\"")
																																																																																																																																																																																														? "Email lesionado"
																																																																																																																																																																																														: null;

		return descripcion_campo;
	}

	public String errorInventarioAutomoviles(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"IA_NUM_REPORTE\"") ? "Número de Reporte"
				: resultado.contains("\"IA_NUM_SINIESTRO\"") ? "Número de Siniestro"
						: resultado.contains("\"IA_NOM_RAZON\"") ? "Nombre o Denominación o Razón Social"
								: resultado.contains("\"IA_ASEGURADO\"") ? "Asegurado/Tercero"
										: resultado.contains("\"IA_CANTIDAD\"") ? "Cantidad"
												: resultado.contains("\"IA_NUM_POLIZA\"") ? "Número de Póliza"
														: resultado.contains("\"IA_DESTINO\"") ? "Destino"
																: resultado.contains("\"IA_NOM_DESTINO\"")
																		? "Nombre del Destino"
																		: resultado.contains("\"IA_DIR_DESTINO\"")
																				? "Dirección del Destino"
																				: resultado
																						.contains("\"IA_MARCA_AUTO\"")
																								? "Marca del auto"
																								: resultado.contains(
																										"\"IA_TIPO_AUTO\"")
																												? "Tipo de auto"
																												: resultado
																														.contains(
																																"\"IA_PUERTAS_AUTO\"")
																																		? "Puertas de auto"
																																		: resultado
																																				.contains(
																																						"\"IA_ANIO_AUTO\"")
																																								? "Anio del auto"
																																								: resultado
																																										.contains(
																																												"\"IA_NUM_MOTOR\"")
																																														? "Número del Motor"
																																														: resultado
																																																.contains(
																																																		"\"IA_NUM_SERIE\"")
																																																				? "Número de Serie"
																																																				: resultado
																																																						.contains(
																																																								"\"IA_COLOR_AUTO\"")
																																																										? "Color de Auto"
																																																										: resultado
																																																												.contains(
																																																														"\"IA_PLACAS_AUTO\"")
																																																																? "Placas del Auto"
																																																																: resultado
																																																																		.contains(
																																																																				"\"IA_KILOMETRAJE\"")
																																																																						? "Kilometraje"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"IA_VIDA_LLANTAS\"")
																																																																												? "Vida de llantas"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"IA_OBSERVACION\"")
																																																																																		? "Observación"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"IA_NOM_OPERADOR\"")
																																																																																								? "Nombre del Operador"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"EMAIL_DEFAULT\"")
																																																																																														? "Email default"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"IA_NOM_ASEGURADO\"")
																																																																																																				? "Nombre del asegurado"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"IA_INVENTARIO_1\"")
																																																																																																										? "Inventario Vehículo 1"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"IA_INVENTARIO_2\"")
																																																																																																																? "Inventario Vehículo 2"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"IA_INVENTARIO_3\"")
																																																																																																																						? "Inventario Vehículo 3"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"IA_INVENTARIO_4\"")
																																																																																																																												? "Inventario Vehículo 4"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"IA_INVENTARIO_5\"")
																																																																																																																																		? "Inventario Vehículo 5"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"IA_NUM_INCISO\"")
																																																																																																																																								? "Número de Inciso"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"IA_NOM_AJUSTADOR\"")
																																																																																																																																														? "Nombre del Ajustador"
																																																																																																																																														: resultado
																																																																																																																																																.contains(
																																																																																																																																																		"\"IA_CLAVE_AJUSTADOR\"")
																																																																																																																																																				? "Clave del Ajustador"
																																																																																																																																																				: resultado
																																																																																																																																																						.contains(
																																																																																																																																																								"\"IA_OBJETOS_PER\"")
																																																																																																																																																										? "Objetos personales"
																																																																																																																																																										: resultado
																																																																																																																																																												.contains(
																																																																																																																																																														"\"IA_CORREO_GRUA\"")
																																																																																																																																																																? "Correo de la grúa"
																																																																																																																																																																: resultado
																																																																																																																																																																		.contains(
																																																																																																																																																																				"\"IA_CORREO_TALLER\"")
																																																																																																																																																																						? "Correo del taller"
																																																																																																																																																																						: null;

		return descripcion_campo;
	}

	public String errorInspecciónPesado(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"IP_SOLICITANTE\"") ? "Solicitante"
				: resultado.contains("\"IP_OFICINA\"") ? "Oficina"
						: resultado.contains("\"IP_TELEFONO\"") ? "Teléfono"
								: resultado.contains("\"IP_ATENCION\"") ? "Datos del cliente: se atenderá a"
										: resultado.contains("\"IP_UBICACION\"") ? "Datos del cliente: ubicación"
												: resultado.contains("\"IP_EMAIL\"")
														? "Datos del cliente: correo electrónico"
														: resultado.contains("\"IP_TIPO\"") ? "Datos de la unidad: tipo"
																: resultado.contains("\"IP_MODELO\"")
																		? "Datos de la unidad: modelo"
																		: resultado.contains("\"IP_PLACAS\"")
																				? "Datos de la unidad: placas"
																				: resultado.contains("\"IP_COLOR\"")
																						? "Datos de la unidad: color"
																						: resultado.contains(
																								"\"IP_NUM_SERIE\"")
																										? "Datos de la unidad: número de serie"
																										: resultado
																												.contains(
																														"\"IP_KILOMETRAJE\"")
																																? "Datos de la unidad: kilometraje"
																																: resultado
																																		.contains(
																																				"\"IP_OBSERVACIONES\"")
																																						? "Daños preexistentes: observaciones"
																																						: resultado
																																								.contains(
																																										"\"IP_TOTAL_FOTOS\"")
																																												? "Total de fotografias"
																																												: resultado
																																														.contains(
																																																"\"IP_TIPO_ENCARGADO\"")
																																																		? "Tipo de encargado"
																																																		: resultado
																																																				.contains(
																																																						"\"IP_NOM_CLIENTE\"")
																																																								? "Nombre del cliente"
																																																								: resultado
																																																										.contains(
																																																												"\"IP_NOM_AJUSTADOR\"")
																																																														? "Nombre del Ajustador"
																																																														: resultado
																																																																.contains(
																																																																		"\"IP_NUM_POLIZA\"")
																																																																				? "Número de Póliza"
																																																																				: resultado
																																																																						.contains(
																																																																								"\"IP_COMPANIA\"")
																																																																										? "Compania"
																																																																										: resultado
																																																																												.contains(
																																																																														"\"IP_CLAVE_AJUSTADOR\"")
																																																																																? "Clave del Ajustador"
																																																																																: resultado
																																																																																		.contains(
																																																																																				"\"IP_ASEGURADO\"")
																																																																																						? "Asegurado"
																																																																																						: resultado
																																																																																								.contains(
																																																																																										"\"IP_NUM_REPORTE\"")
																																																																																												? "Número de Reporte"
																																																																																												: resultado
																																																																																														.contains(
																																																																																																"\"IP_NUM_SINIESTRO\"")
																																																																																																		? "Número de Siniestro"
																																																																																																		: resultado
																																																																																																				.contains(
																																																																																																						"\"IP_NUM_INCISO\"")
																																																																																																								? "Número de Inciso"
																																																																																																								: resultado
																																																																																																										.contains(
																																																																																																												"\"IP_MARCA\"")
																																																																																																														? "Datos de la unidad: marca"
																																																																																																														: null;

		return descripcion_campo;
	}

	public String errorInspeccionMotocicletas(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"IM_SOLICITANTE\"") ? "Solicitante"
				: resultado.contains("\"IM_OFICINA\"") ? "Oficina"
						: resultado.contains("\"IM_TELEFONO\"") ? "Teléfono"
								: resultado.contains("\"IM_ATENCION\"") ? "Datos del cliente: se atenderá a"
										: resultado.contains("\"IM_UBICACION\"") ? "Datos del cliente: ubicación"
												: resultado.contains("\"IM_EMAIL\"") ? "Datos del cliente: email"
														: resultado.contains("\"IM_MARCA\"")
																? "Datos de la unidad: marca "
																: resultado.contains("\"IM_TIPO\"")
																		? "Datos del cliente: tipo"
																		: resultado.contains("\"IM_MODELO\"")
																				? "Datos del cliente: modelo"
																				: resultado.contains("\"IM_PLACAS\"")
																						? "Datos del cliente: placas"
																						: resultado.contains(
																								"\"IM_COLOR\"")
																										? "Datos del cliente: color"
																										: resultado
																												.contains(
																														"\"IM_NUM_SERIE\"")
																																? "Datos del cliente: número de serie"
																																: resultado
																																		.contains(
																																				"\"IM_KILOMETRAJE\"")
																																						? "Datos del cliente: kilometraje"
																																						: resultado
																																								.contains(
																																										"\"IM_OBSERVACIONES\"")
																																												? "Observaciones"
																																												: resultado
																																														.contains(
																																																"\"IM_TOTAL_FOTOS\"")
																																																		? "Origen de la unidad: total de fotografias"
																																																		: resultado
																																																				.contains(
																																																						"\"IM_NOM_CLIENTE\"")
																																																								? "Nombre del cliente"
																																																								: resultado
																																																										.contains(
																																																												"\"IM_NOM_AJUSTADOR\"")
																																																														? "Nombre del Ajustador"
																																																														: resultado
																																																																.contains(
																																																																		"\"IM_NUM_POLIZA\"")
																																																																				? "Origen de la unidad: Número de Póliza"
																																																																				: resultado
																																																																						.contains(
																																																																								"\"IM_COMPANIA\"")
																																																																										? "Origen de la unidad: compania"
																																																																										: resultado
																																																																												.contains(
																																																																														"\"IM_CLAVE_AJUSTADOR\"")
																																																																																? "Clave del Ajustador"
																																																																																: resultado
																																																																																		.contains(
																																																																																				"\"IM_ASEGURADO\"")
																																																																																						? "Asegurado"
																																																																																						: resultado
																																																																																								.contains(
																																																																																										"\"IM_NUM_REPORTE\"")
																																																																																												? "Número de Reporte"
																																																																																												: resultado
																																																																																														.contains(
																																																																																																"\"IM_NUM_INCISO\"")
																																																																																																		? "Número de Inciso"
																																																																																																		: resultado
																																																																																																				.contains(
																																																																																																						"\"IM_NUM_SINIESTRO\"")
																																																																																																								? "Número de Siniestro"
																																																																																																								: null;

		return descripcion_campo;
	}

	public String errorAdmisionAuto(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"OA_FOLIO_ELECTRO\"") ? "Folio electrónico"
				: resultado.contains("\"OA_NUM_REPORTE\"") ? "Número de Reporte"
						: resultado.contains("\"OA_NUM_SINIESTRO\"") ? "Número de Siniestro"
								: resultado.contains("\"OA_ASEGURADO\"") ? "Asegurado"
										: resultado.contains("\"OA_NUM_POLIZA\"") ? "Número de Póliza"
												: resultado.contains("\"OA_NUM_ENDOSO\"") ? "Número de Endoso"
														: resultado.contains("\"OA_NUM_INCISO\"") ? "Número de Inciso"
																: resultado.contains("\"OA_NOM_CLIENTE\"")
																		? "Nombre o Razón Social del Cliente"
																		: resultado.contains("\"OA_EMAIL_CLIENTE\"")
																				? "Email"
																				: resultado
																						.contains("\"OA_TEL_CLIENTE\"")
																								? "Teléfono del cliente"
																								: resultado.contains(
																										"\"OA_RAZON_ENVIO\"")
																												? "Razón Social del CDR"
																												: resultado
																														.contains(
																																"\"OA_RAZON_RESPONSABLE\"")
																																		? "Responsable CDR"
																																		: resultado
																																				.contains(
																																						"\"OA_RAZON_TELEFONO\"")
																																								? "Teléfono de CDR"
																																								: resultado
																																										.contains(
																																												"\"OA_RAZON_DOMICILIO\"")
																																														? "Domicilio CDR"
																																														: resultado
																																																.contains(
																																																		"\"OA_RAZON_COBERTURA\"")
																																																				? "Cobertua"
																																																				: resultado
																																																						.contains(
																																																								"\"OA_MARCA_AUTO\"")
																																																										? "Marca del auto"
																																																										: resultado
																																																												.contains(
																																																														"\"OA_TIPO_AUTO\"")
																																																																? "Tipo del auto"
																																																																: resultado
																																																																		.contains(
																																																																				"\"OA_KILOMETRAJE\"")
																																																																						? "kilometraje del auto"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"OA_NUM_SERIE\"")
																																																																												? "Número de Serie del auto"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"OA_COLOR_AUTO\"")
																																																																																		? "Color del auto"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"OA_PLACA_AUTO\"")
																																																																																								? "Placa del auto"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"OA_SUMA_ASEGURADA\"")
																																																																																														? "Cláusula deducible: suma asegurada"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"OA_PORCENTAJE_DED\"")
																																																																																																				? "Cláusula deducible: porcentaje deducible"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"OA_CANTIDAD\"")
																																																																																																										? "Cláusula deducible: cantidad"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"OA_DESC_DANIOS\"")
																																																																																																																? "Descripción de Danios a Reparar"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"OA_DANIOS_PRE\"")
																																																																																																																						? "Danios preexistentes"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"OA_NOM_AJUSTADOR\"")
																																																																																																																												? "Nombre del Ajustador"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"OA_CLAVE_AJUSTADOR\"")
																																																																																																																																		? "Clave del Ajustador"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"OA_MODELO_AUTO\"")
																																																																																																																																								? "Modelo del auto"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"OA_AGRAVAMIENTO\"")
																																																																																																																																														? "Posible agravamiento"
																																																																																																																																														: null;

		return descripcion_campo;
	}

	public String errorAdmisionMotocicleta(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"OA_FOLIO_ELECTRO\"") ? "Folio Electrónico"
				: resultado.contains("\"OA_NUM_REPORTE\"") ? "Número de Reporte"
						: resultado.contains("\"OA_NUM_SINIESTRO\"") ? "Número de Siniestro"
								: resultado.contains("\"OA_ASEGURADO\"") ? "Asegurado"
										: resultado.contains("\"OA_NUM_POLIZA\"") ? "Número de Póliza"
												: resultado.contains("\"OA_NUM_ENDOSO\"") ? "Número de Endoso"
														: resultado.contains("\"OA_NUM_INCISO\"") ? "Número de Inciso"
																: resultado.contains("\"OA_NOM_CLIENTE\"")
																		? "Nombre o Razón Social del Cliente"
																		: resultado.contains("\"OA_EMAIL_CLIENTE\"")
																				? "Email del cliente"
																				: resultado
																						.contains("\"OA_TEL_CLIENTE\"")
																								? "Teléfono del cliente"
																								: resultado.contains(
																										"\"OA_RAZON_ENVIO\"")
																												? "Razón Social del CDR"
																												: resultado
																														.contains(
																																"\"OA_RAZON_RESPONSABLE\"")
																																		? "Responsable del CDR"
																																		: resultado
																																				.contains(
																																						"\"OA_RAZON_TELEFONO\"")
																																								? "Teléfono del CDR"
																																								: resultado
																																										.contains(
																																												"\"OA_RAZON_DOMICILIO\"")
																																														? "Domicilio del CDR"
																																														: resultado
																																																.contains(
																																																		"\"OA_RAZON_COBERTURA\"")
																																																				? "Cobertura"
																																																				: resultado
																																																						.contains(
																																																								"\"OA_MARCA_AUTO\"")
																																																										? "Marca del auto"
																																																										: resultado
																																																												.contains(
																																																														"\"OA_TIPO_AUTO\"")
																																																																? "Tipo de auto"
																																																																: resultado
																																																																		.contains(
																																																																				"\"OA_KILOMETRAJE\"")
																																																																						? "kilometraje del auto"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"OA_NUM_SERIE\"")
																																																																												? "Número de Serie del auto"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"OA_COLOR_AUTO\"")
																																																																																		? "Color del auto"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"OA_PLACA_AUTO\"")
																																																																																								? "Placa del auto"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"OA_SUMA_ASEGURADA\"")
																																																																																														? "Claúsula de Deducible: suma asegurada"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"OA_PORCENTAJE_DED\"")
																																																																																																				? "Claúsula de Deducible: porcentaje deducible"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"OA_CANTIDAD\"")
																																																																																																										? "Claúsula de Deducible: cantidad"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"OA_DESC_DANIOS\"")
																																																																																																																? "Descripción de Danios a Reparar"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"OA_DANIOS_PRE\"")
																																																																																																																						? "Danios Preexistentes"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"OA_NOM_AJUSTADOR\"")
																																																																																																																												? "Nombre del Ajustador"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"OA_CLAVE_AJUSTADOR\"")
																																																																																																																																		? "Clave del Ajustador"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"OA_MODELO_AUTO\"")
																																																																																																																																								? "Modelo del auto"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"OA_AGRAVAMIENTO\"")
																																																																																																																																														? "Posible agravamiento"
																																																																																																																																														: null;

		return descripcion_campo;
	}

	public String errorAdmisionPesado(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"OP_FOLIO_ELECTRO\"") ? "Folio Electrónico"
				: resultado.contains("\"OP_NUM_REPORTE\"") ? "Número de Reporte"
						: resultado.contains("\"OP_NUM_SINIESTRO\"") ? "Número de Siniestro"
								: resultado.contains("\"OP_NUM_POLIZA\"") ? "Número de Póliza"
										: resultado.contains("\"OP_NUM_INCISO\"") ? "Número de Inciso"
												: resultado.contains("\"OP_NUM_ENDOSO\"") ? "Número de Endoso"
														: resultado.contains("\"OP_NOM_ASEGURADO\"")
																? "Nombre del Asegurado"
																: resultado.contains("\"OP_TEL_ASEGURADO\"")
																		? "Teléfono del asegurado"
																		: resultado.contains("\"OP_CONDUCTOR_ASE\"")
																				? "Conductor del asegurado"
																				: resultado.contains(
																						"\"OP_TEL_CON_ASE\"")
																								? "Teléfono del conductor asegurado"
																								: resultado.contains(
																										"\"OP_MARCA_AUTO_ASE\"")
																												? "Marca del auto asegurado"
																												: resultado
																														.contains(
																																"\"OP_TIPO_AUTO_ASE\"")
																																		? "Tipo del auto asegurado"
																																		: resultado
																																				.contains(
																																						"\"OP_COLOR_AUTO_ASE\"")
																																								? "Color del auto asegurado"
																																								: resultado
																																										.contains(
																																												"\"OP_PLACAS_AUTO_ASE\"")
																																														? "Placas del auto asegurado"
																																														: resultado
																																																.contains(
																																																		"\"OP_MOTOR_AUTO_ASE\"")
																																																				? "Motor del auto asegurado"
																																																				: resultado
																																																						.contains(
																																																								"\"OP_SERIE_AUTO_ASE\"")
																																																										? "Serie de auto asegurado"
																																																										: resultado
																																																												.contains(
																																																														"\"OP_SUMA_ASEGURADO\"")
																																																																? "Suma asegurada"
																																																																: resultado
																																																																		.contains(
																																																																				"\"OP_NOM_AFE\"")
																																																																						? "Nombre del afectado"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"OP_TEL_AFE\"")
																																																																												? "Teléfono del afectado"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"OP_CONDUCTOR_AFE\"")
																																																																																		? "Conductor afectado"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"OP_TEL_CON_AFE\"")
																																																																																								? "Teléfono del conductor afectado"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"OP_MARCA_AUTO_AFE\"")
																																																																																														? "Marca del auto afectado"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"OP_TIPO_AUTO_AFE\"")
																																																																																																				? "Tipo del auto afectado"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"OP_COLOR_AUTO_AFE\"")
																																																																																																										? "Color del auto afectado"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"OP_PLACAS_AUTO_AFE\"")
																																																																																																																? "Placas del auto afectado"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"OP_MOTOR_AUTO_AFE\"")
																																																																																																																						? "Motor del auto afectado"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"OP_SERIE_AUTO_AFE\"")
																																																																																																																												? "Serie del auto afectado"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"OP_DEFINICION\"")
																																																																																																																																		? "Cláusula de Deducible: definición"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"OP_CANTIDAD\"")
																																																																																																																																								? "Cláusula de Deducible: cantidad"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"OP_DED_DIAS\"")
																																																																																																																																														? "Cláusula de Deducible: deducible RC"
																																																																																																																																														: resultado
																																																																																																																																																.contains(
																																																																																																																																																		"\"OP_DANIOS_CAMION\"")
																																																																																																																																																				? "Danios Preexistentes Camión"
																																																																																																																																																				: resultado
																																																																																																																																																						.contains(
																																																																																																																																																								"\"OP_DANIOS_CAJA\"")
																																																																																																																																																										? "Danios Preexistentes Caja"
																																																																																																																																																										: resultado
																																																																																																																																																												.contains(
																																																																																																																																																														"\"OP_DANIOS_TANQUE\"")
																																																																																																																																																																? "Danios Preexistentes Tanque"
																																																																																																																																																																: resultado
																																																																																																																																																																		.contains(
																																																																																																																																																																				"\"OP_NOM_TALLER\"")
																																																																																																																																																																						? "Nombre del taller"
																																																																																																																																																																						: resultado
																																																																																																																																																																								.contains(
																																																																																																																																																																										"\"OP_TEL_TALLER\"")
																																																																																																																																																																												? "Teléfono del taller"
																																																																																																																																																																												: resultado
																																																																																																																																																																														.contains(
																																																																																																																																																																																"\"OP_DIR_TALLER\"")
																																																																																																																																																																																		? "Dirección del taller"
																																																																																																																																																																																		: resultado
																																																																																																																																																																																				.contains(
																																																																																																																																																																																						"\"OP_ATENCION_TALLER\"")
																																																																																																																																																																																								? "Atención taller"
																																																																																																																																																																																								: resultado
																																																																																																																																																																																										.contains(
																																																																																																																																																																																												"\"OP_SINIESTRO_CAMION\"")
																																																																																																																																																																																														? "Siniestro camión"
																																																																																																																																																																																														: resultado
																																																																																																																																																																																																.contains(
																																																																																																																																																																																																		"\"OP_SINIESTRO_CAJA\"")
																																																																																																																																																																																																				? "Siniestro caja"
																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																								"\"OP_SINIESTRO_TANQUE\"")
																																																																																																																																																																																																										? "Siniestro tanque"
																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																														"\"OP_NOM_AJUSTADOR\"")
																																																																																																																																																																																																																? "Nombre del Ajustador"
																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																				"\"EMAIL_DEFAULT\"")
																																																																																																																																																																																																																						? "Email"
																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																										"\"OP_ASEGURADO\"")
																																																																																																																																																																																																																												? "Asegurado"
																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																"\"OP_MODELO_ASE\"")
																																																																																																																																																																																																																																		? "Modelo auto asegurado"
																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																						"\"OP_MODELO_TER\"")
																																																																																																																																																																																																																																								? "Modelo auto tercero"
																																																																																																																																																																																																																																								: resultado
																																																																																																																																																																																																																																										.contains(
																																																																																																																																																																																																																																												"\"OP_CLAVE_AJUSTADOR\"")
																																																																																																																																																																																																																																														? "Clave del Ajustador"
																																																																																																																																																																																																																																														: resultado
																																																																																																																																																																																																																																																.contains(
																																																																																																																																																																																																																																																		"\"OP_EMAIL_TERCERO\"")
																																																																																																																																																																																																																																																				? "Email de tercero"
																																																																																																																																																																																																																																																				: null;

		return descripcion_campo;
	}

	public String errorAsignacionAbogado(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"AA_NUM_SINIESTRO\"") ? "Número de Siniestro"
				: resultado.contains("\"AA_NUM_REPORTE\"") ? "Número de Reporte"
						: resultado.contains("\"AA_NUM_POLIZA\"") ? "Número de Póliza"
								: resultado.contains("\"AA_MARCA_AUTO\"") ? "Marca vehículo"
										: resultado.contains("\"AA_TIPO_AUTO\"") ? "Tipo vehículo"
												: resultado.contains("\"AA_COLOR_AUTO\"") ? "Color del vehículo"
														: resultado.contains("\"AA_PLACA_AUTO\"")
																? "Placas del vehículo"
																: resultado.contains("\"AA_DANIOS_NA\"")
																		? "Danios estimados de N/A"
																		: resultado.contains("\"AA_MONTO_CRUCERO\"")
																				? "Monto aceptado al 3° en crucero"
																				: resultado.contains(
																						"\"AA_MONTO_DEDUCIBLE\"")
																								? "Monto deducible en RC"
																								: resultado.contains(
																										"\"AA_NOM_ASEGURADO\"")
																												? "Datos del asegurado: Nombre del asegurado"
																												: resultado
																														.contains(
																																"\"AA_NOM_CONDUCTOR\"")
																																		? "Datos del asegurado: Nombre del conductor"
																																		: resultado
																																				.contains(
																																						"\"AA_TEL_OFICINA\"")
																																								? "Datos del asegurado: Teléfono de oficina"
																																								: resultado
																																										.contains(
																																												"\"AA_UBICACION_ACTUAL\"")
																																														? "Datos del asegurado: actualmente se encuentra en"
																																														: resultado
																																																.contains(
																																																		"\"AA_DESCRIPCION_DANIOS\"")
																																																				? "Datos del asegurado: Descripción de danios N/A"
																																																				: resultado
																																																						.contains(
																																																								"\"AA_TEL_CASA\"")
																																																										? "Datos del asegurado: teléfono de casa"
																																																										: resultado
																																																												.contains(
																																																														"\"AA_EMAIL\"")
																																																																? "Datos del asegurado: correo electrónico"
																																																																: resultado
																																																																		.contains(
																																																																				"\"AA_LUGAR_SINIESTRO\"")
																																																																						? "Datos del asegurado: lugar del siniestro"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"AA_AUTORIDAD\"")
																																																																												? "Datos del asegurado: autoridadq que tomó conocimiento"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"AA_NUM_ACCIDENTE\"")
																																																																																		? "Datos del asegurado: número de parte de accidente"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"AA_NOM_TERCERO\"")
																																																																																								? "Datos del tercero: nombre del tercero"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"AA_TEL_CASA_TERCERO\"")
																																																																																														? "Datos del tercero: teléfono de casa"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"AA_TEL_OFICINA_TERCERO\"")
																																																																																																				? "Datos del tercero: teléfono de oficina"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"AA_DANIOS_ESTIMADOS\"")
																																																																																																										? "Datos del tercero: danios estimados"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"AA_COMENTARIOS\"")
																																																																																																																? "Datos del tercero: comentarios del ajustador"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"AA_DES_DANIOS_TER\"")
																																																																																																																						? "Datos del tercero: descripción de danios a tercero"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"AA_NOM_LESIONADOS\"")
																																																																																																																												? "Datos del tercero: nombres de lesionados"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"AA_INFORME\"")
																																																																																																																																		? "Datos del tercero: Para su debido seguimiento es importante informarle"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"AA_OTROS\"")
																																																																																																																																								? "Datos del tercero: otros"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"AA_CLAVE_AJUSTADOR\"")
																																																																																																																																														? "Clave del Ajustador"
																																																																																																																																														: resultado
																																																																																																																																																.contains(
																																																																																																																																																		"\"AA_NOM_AJUSTADOR\"")
																																																																																																																																																				? "Nombre del Ajustador"
																																																																																																																																																				: resultado
																																																																																																																																																						.contains(
																																																																																																																																																								"\"AA_CLAVE_ABOGADO\"")
																																																																																																																																																										? "Clave del abogado"
																																																																																																																																																										: resultado
																																																																																																																																																												.contains(
																																																																																																																																																														"\"AA_NOM_ABOGADO\"")
																																																																																																																																																																? "Nombre del abogado"
																																																																																																																																																																: resultado
																																																																																																																																																																		.contains(
																																																																																																																																																																				"\"AA_NUM_INCISO\"")
																																																																																																																																																																						? "Número de Inciso"
																																																																																																																																																																						: resultado
																																																																																																																																																																								.contains(
																																																																																																																																																																										"\"AA_ASEGURADO\"")
																																																																																																																																																																												? "Asegurado/tercero"
																																																																																																																																																																												: null;

		return descripcion_campo;
	}

	public String errorCuestionarioRobo(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"CR_NUM_REPORTE\"") ? "Número de Reporte"
				: resultado.contains("\"CR_NUM_POLIZA\"") ? "Número de Póliza"
						: resultado.contains("\"CR_NUM_SINIESTRO\"") ? "Número de Siniestro"
								: resultado.contains("\"CR_INC_ASEGURADO\"") ? "Asegurado"
										: resultado.contains("\"CR_PREGUNTA_1\"") ? "Pregunta 1"
												: resultado.contains("\"CR_PREGUNTA_2\"") ? "Pregunta 2"
														: resultado.contains("\"CR_PREGUNTA_3\"") ? "Pregunta 3"
																: resultado.contains("\"CR_PREGUNTA_4\"") ? "Pregunta 4"
																		: resultado.contains("\"CR_PREGUNTA_5\"")
																				? "Pregunta 5"
																				: resultado.contains(
																						"\"CR_PREGUNTA_6\"")
																								? "Pregunta 6"
																								: resultado.contains(
																										"\"CR_PREGUNTA_7\"")
																												? "Pregunta 7"
																												: resultado
																														.contains(
																																"\"CR_PREGUNTA_8_1\"")
																																		? "Pregunta 8A"
																																		: resultado
																																				.contains(
																																						"\"CR_PREGUNTA_8_2\"")
																																								? "Pregunta 8B"
																																								: resultado
																																										.contains(
																																												"\"CR_PREGUNTA_8_3\"")
																																														? "Pregunta 8C"
																																														: resultado
																																																.contains(
																																																		"\"CR_PREGUNTA_9\"")
																																																				? "Pregunta 9"
																																																				: resultado
																																																						.contains(
																																																								"\"CR_PREGUNTA_10_1\"")
																																																										? "Pregunta 10A"
																																																										: resultado
																																																												.contains(
																																																														"\"CR_PREGUNTA_10_2\"")
																																																																? "Pregunta 10B"
																																																																: resultado
																																																																		.contains(
																																																																				"\"CR_PREGUNTA_11\"")
																																																																						? "Pregunta 11"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"CR_PREGUNTA_12\"")
																																																																												? "Pregunta 12"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"CR_PREGUNTA_13\"")
																																																																																		? "Pregunta 13"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"CR_PREGUNTA_14\"")
																																																																																								? "Pregunta 14"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"CR_PREGUNTA_15\"")
																																																																																														? "Pregunta 15"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"CR_OTROS\"")
																																																																																																				? "Pregunta 16: otros"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"CR_PREGUNTA_17\"")
																																																																																																										? "Pregunta 17"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"CR_PREGUNTA_18\"")
																																																																																																																? "Pregunta 18"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"CR_PREGUNTA_19\"")
																																																																																																																						? "Pregunta 19"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"CR_PREGUNTA_21\"")
																																																																																																																												? "Pregunta 21"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"CR_PREGUNTA_22\"")
																																																																																																																																		? "Pregunta 22"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"CR_PREGUNTA_23\"")
																																																																																																																																								? "Pregunta 23"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"CR_PREGUNTA_24\"")
																																																																																																																																														? "Pregunta 24"
																																																																																																																																														: resultado
																																																																																																																																																.contains(
																																																																																																																																																		"\"CR_PREGUNTA_25\"")
																																																																																																																																																				? "Pregunta 25"
																																																																																																																																																				: resultado
																																																																																																																																																						.contains(
																																																																																																																																																								"\"CR_PREGUNTA_26\"")
																																																																																																																																																										? "Pregunta 26"
																																																																																																																																																										: resultado
																																																																																																																																																												.contains(
																																																																																																																																																														"\"CR_PREGUNTA_27\"")
																																																																																																																																																																? "Pregunta 27"
																																																																																																																																																																: resultado
																																																																																																																																																																		.contains(
																																																																																																																																																																				"\"CR_PREGUNTA_28_1\"")
																																																																																																																																																																						? "Pregunta 28A"
																																																																																																																																																																						: resultado
																																																																																																																																																																								.contains(
																																																																																																																																																																										"\"CR_PREGUNTA_28_2\"")
																																																																																																																																																																												? "Pregunta 28B"
																																																																																																																																																																												: resultado
																																																																																																																																																																														.contains(
																																																																																																																																																																																"\"CR_PREGUNTA_28_3\"")
																																																																																																																																																																																		? "Pregunta 28C"
																																																																																																																																																																																		: resultado
																																																																																																																																																																																				.contains(
																																																																																																																																																																																						"\"CR_PREGUNTA_29\"")
																																																																																																																																																																																								? "Pregunta 29"
																																																																																																																																																																																								: resultado
																																																																																																																																																																																										.contains(
																																																																																																																																																																																												"\"CR_PREGUNTA_30\"")
																																																																																																																																																																																														? "Pregunta 30"
																																																																																																																																																																																														: resultado
																																																																																																																																																																																																.contains(
																																																																																																																																																																																																		"\"CR_PREGUNTA_31\"")
																																																																																																																																																																																																				? "Pregunta 31"
																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																								"\"CR_PREGUNTA_32\"")
																																																																																																																																																																																																										? "Pregunta 32"
																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																														"\"CR_NOM_ASEGURADO\"")
																																																																																																																																																																																																																? "Nombre del asegurado"
																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																				"\"CR_DIR_ASEGURADO\"")
																																																																																																																																																																																																																						? "Dirección del asegurado"
																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																										"\"CR_TEL_CASA_ASEGURADO\"")
																																																																																																																																																																																																																												? "Teléfono de casa del asegurado"
																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																"\"CR_TEL_OFI_ASEGURADO\"")
																																																																																																																																																																																																																																		? "Teléfono de oficina del asegurado"
																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																						"\"CR_TEL_CELULAR_ASEGURADO\"")
																																																																																																																																																																																																																																								? "Teléfono de celular del asegurado"
																																																																																																																																																																																																																																								: resultado
																																																																																																																																																																																																																																										.contains(
																																																																																																																																																																																																																																												"\"CR_OCU_ASEGURADO\"")
																																																																																																																																																																																																																																														? "Ocupación del asegurado"
																																																																																																																																																																																																																																														: resultado
																																																																																																																																																																																																																																																.contains(
																																																																																																																																																																																																																																																		"\"CR_EMAIL_ASEGURADO\"")
																																																																																																																																																																																																																																																				? "Email del asegurado"
																																																																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																																																																								"\"CR_NUM_INCISO\"")
																																																																																																																																																																																																																																																										? "Número de Inciso"
																																																																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																																																																														"\"CR_CLAVE_AJUSTADOR\"")
																																																																																																																																																																																																																																																																? "Clave del Ajustador"
																																																																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																																																																				"\"CR_ASEGURADO\"")
																																																																																																																																																																																																																																																																						? "Asegurado"
																																																																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																																																																										"\"CR_NUM_ENDOSO\"")
																																																																																																																																																																																																																																																																												? "Número de Endoso"
																																																																																																																																																																																																																																																																												: null;

		return descripcion_campo;
	}

	public String errorDeclaracionUniversal(String resultado) {
		String descripcion_campo = null;
		descripcion_campo =resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"DU_LUGAR\"") ? "Lugar de vehículo A"
				: resultado.contains("\"DU_CODIGO_RESPONSABILIDAD\"") ? "Código de responsabilidad"
				: resultado.contains("\"DU_NOM_CIA\"") ? "Nombre CIA A"
						: resultado.contains("\"DU_NUM_POLIZA\"") ? "Número de póliza A"
								: resultado.contains("\"DU_INC\"") ? "Inc A"
										: resultado.contains("\"DU_NUM_SINIESTRO\"") ? "Número siniestro A"
												: resultado.contains("\"DU_NUM_REPORTE\"") ? "Número reporte A"
														: resultado.contains("\"DU_COBERTURA\"") ? "Cobertura A"
																: resultado.contains("\"DU_COBRANZA\"") ? "Cobranza A"
																		: resultado.contains("\"DU_NOM_ASEGURADO\"")
																				? "Nombre asegurado A"
																				: resultado.contains(
																						"\"DU_TEL_ASEGURADO\"")
																								? "Teléfono asegurado A"
																								: resultado.contains(
																										"\"DU_NOM_CONDUCTOR\"")
																												? "Nombre conductor A"
																												: resultado
																														.contains(
																																"\"DU_EDAD_CONDUCTOR\"")
																																		? "Edad conductor A"
																																		: resultado
																																				.contains(
																																						"\"DU_TEL_CONDUCTOR\"")
																																								? "Teléfono conductor A"
																																								: resultado
																																										.contains(
																																												"\"DU_DIR_CONDUCTOR\"")
																																														? "Dirección conductor A"
																																														: resultado
																																																.contains(
																																																		"\"DU_EMAIL_CONDUCTOR\"")
																																																				? "Email conductor A"
																																																				: resultado
																																																						.contains(
																																																								"\"DU_LICENCIA_NUM\"")
																																																										? "Número licencia A"
																																																										: resultado
																																																												.contains(
																																																														"\"DU_LICENCIA_ESTADO\"")
																																																																? "Estado licencia A"
																																																																: resultado
																																																																		.contains(
																																																																				"\"DU_TIPO_LICENCIA\"")
																																																																						? "Tipo licencia A"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"DU_MARCA_AUTO\"")
																																																																												? "Marca auto A"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"DU_TIPO_AUTO\"")
																																																																																		? "Tipo auto A"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"DU_COLOR_AUTO\"")
																																																																																								? "Color auto A"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"DU_PLACAS_AUTO\"")
																																																																																														? "Placas auto A"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"DU_SERIE\"")
																																																																																																				? "Serie auto A"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"DU_NARRACION\"")
																																																																																																										? "Narración A"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"DU_DANIOS_APRE\"")
																																																																																																																? "Danios apreciables A"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"DU_DANIOS_PRE\"")
																																																																																																																						? "Danios preexistentes A"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"DU_LUGAR_B\"")
																																																																																																																												? "Lugar de vehículo B"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"DU_NOM_CIA_B\"")
																																																																																																																																		? "Nombre CIA B"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"DU_NUM_POLIZA_B\"")
																																																																																																																																								? "Número de póliza B"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"DU_INC_B\"")
																																																																																																																																														? "Inc B"
																																																																																																																																														: resultado
																																																																																																																																																.contains(
																																																																																																																																																		"\"DU_NUM_SINIESTRO_B\"")
																																																																																																																																																				? "Número siniestro B"
																																																																																																																																																				: resultado
																																																																																																																																																						.contains(
																																																																																																																																																								"\"DU_NUM_REPORTE_B\"")
																																																																																																																																																										? "Número reporte B"
																																																																																																																																																										: resultado
																																																																																																																																																												.contains(
																																																																																																																																																														"\"DU_COBERTURA_B\"")
																																																																																																																																																																? "Cobertura B"
																																																																																																																																																																: resultado
																																																																																																																																																																		.contains(
																																																																																																																																																																				"\"DU_COBRANZA_B\"")
																																																																																																																																																																						? "Cobranza B"
																																																																																																																																																																						: resultado
																																																																																																																																																																								.contains(
																																																																																																																																																																										"\"DU_NOM_ASEGURADO_B\"")
																																																																																																																																																																												? "Nombre asegurado B"
																																																																																																																																																																												: resultado
																																																																																																																																																																														.contains(
																																																																																																																																																																																"\"DU_NOM_CONDUCTOR_B\"")
																																																																																																																																																																																		? "Nombre conductor B"
																																																																																																																																																																																		: resultado
																																																																																																																																																																																				.contains(
																																																																																																																																																																																						"\"DU_EDAD_CONDUCTOR_B\"")
																																																																																																																																																																																								? "Edad conductor B"
																																																																																																																																																																																								: resultado
																																																																																																																																																																																										.contains(
																																																																																																																																																																																												"\"DU_TEL_CONDUCTOR_B\"")
																																																																																																																																																																																														? "Teléfono conductor B"
																																																																																																																																																																																														: resultado
																																																																																																																																																																																																.contains(
																																																																																																																																																																																																		"\"DU_DIR_CONDUCTOR_B\"")
																																																																																																																																																																																																				? "Dirección conductor B"
																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																								"\"DU_EMAIL_CONDUCTOR_B\"")
																																																																																																																																																																																																										? "Email conductor B"
																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																														"\"DU_LICENCIA_NUM_B\"")
																																																																																																																																																																																																																? "Licencia B"
																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																				"\"DU_LICENCIA_ESTADO_B\"")
																																																																																																																																																																																																																						? "Estado Licencia B"
																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																										"\"DU_TIPO_LICENCIA_B\"")
																																																																																																																																																																																																																												? "Tipo licencia B"
																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																"\"DU_MARCA_AUTO_B\"")
																																																																																																																																																																																																																																		? "Marca auto B"
																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																						"\"DU_TIPO_AUTO_B\"")
																																																																																																																																																																																																																																								? "TIpo auto B"
																																																																																																																																																																																																																																								: resultado
																																																																																																																																																																																																																																										.contains(
																																																																																																																																																																																																																																												"\"DU_COLOR_AUTO_B\"")
																																																																																																																																																																																																																																														? "Color auto B"
																																																																																																																																																																																																																																														: resultado
																																																																																																																																																																																																																																																.contains(
																																																																																																																																																																																																																																																		"\"DU_PLACAS_AUTO_B\"")
																																																																																																																																																																																																																																																				? "Placas auto B"
																																																																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																																																																								"\"DU_SERIE_B\"")
																																																																																																																																																																																																																																																										? "Serie auto B"
																																																																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																																																																														"\"DU_NARRACION_B\"")
																																																																																																																																																																																																																																																																? "Narración B"
																																																																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																																																																				"\"DU_DANIOS_APRE_B\"")
																																																																																																																																																																																																																																																																						? "Danios apreciables B"
																																																																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																																																																										"\"DU_DANIOS_PRE_B\"")
																																																																																																																																																																																																																																																																												? "Danios preexistentes B"
																																																																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																																																																"\"DU_TEL_ASEGURADO_B\"")
																																																																																																																																																																																																																																																																																		? "Teléfono asegurado B"
																																																																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																																																																						"\"DU_NOM_AJUSTADOR\"")
																																																																																																																																																																																																																																																																																								? "Nombre ajustador A"
																																																																																																																																																																																																																																																																																								: resultado
																																																																																																																																																																																																																																																																																										.contains(
																																																																																																																																																																																																																																																																																												"\"DU_CLAVE_AJUSTADOR\"")
																																																																																																																																																																																																																																																																																														? "Clave ajustador A"
																																																																																																																																																																																																																																																																																														: resultado
																																																																																																																																																																																																																																																																																																.contains(
																																																																																																																																																																																																																																																																																																		"\"DU_NOM_AJUSTADOR_B\"")
																																																																																																																																																																																																																																																																																																				? "Nombre ajustador B"
																																																																																																																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																																																																																																																								"\"DU_CLAVE_AJUSTADOR_B\"")
																																																																																																																																																																																																																																																																																																										? "Clave ajustador B"
																																																																																																																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																																																																																																																														"\"DU_OTROS\"")
																																																																																																																																																																																																																																																																																																																? "Informe de ajustador (Otros)"
																																																																																																																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																																																																																																																				"\"DU_RECUPERACION\"")
																																																																																																																																																																																																																																																																																																																						? "Informe de ajustador (Recuperación y/o garantía)"
																																																																																																																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																																																																																																																										"\"DU_AUTORIDAD\"")
																																																																																																																																																																																																																																																																																																																												? "Autoridad"
																																																																																																																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																																																																																																																"\"DU_NUM_ACTA\"")
																																																																																																																																																																																																																																																																																																																																		? "Número acta"
																																																																																																																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																																																																																																																						"\"DU_NUM_REPORTE_AUT\"")
																																																																																																																																																																																																																																																																																																																																								? "Número reporte"
																																																																																																																																																																																																																																																																																																																																								: resultado
																																																																																																																																																																																																																																																																																																																																										.contains(
																																																																																																																																																																																																																																																																																																																																												"\"DU_NOM_ABOGADO\"")
																																																																																																																																																																																																																																																																																																																																														? "Abogado asignado"
																																																																																																																																																																																																																																																																																																																																														: resultado
																																																																																																																																																																																																																																																																																																																																																.contains(
																																																																																																																																																																																																																																																																																																																																																		"\"DU_DANIOS_MATERIALES\"")
																																																																																																																																																																																																																																																																																																																																																				? "Registro de estimaciones (Importe danios materiales)"
																																																																																																																																																																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																																																																																																																																																																								"\"DU_EQUIPO_ESPECIAL\"")
																																																																																																																																																																																																																																																																																																																																																										? "Registro de estimaciones (Importe equipo especial)"
																																																																																																																																																																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																																																																																																																																																																														"\"DU_ROBO_TOTAL\"")
																																																																																																																																																																																																																																																																																																																																																																? "Registro de estimaciones (Importe robo total)"
																																																																																																																																																																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																																																																																																																																																																				"\"DU_RES_BIENES\"")
																																																																																																																																																																																																																																																																																																																																																																						? "Registro de estimaciones (Responsabilidad Civil de Bienes)"
																																																																																																																																																																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																																																																																																																																																																										"\"DU_RES_PERSONAS\"")
																																																																																																																																																																																																																																																																																																																																																																												? "Registro de estimaciones (Importe RC)"
																																																																																																																																																																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																																																																																																																																																																"\"DU_NUM_PERSONAS\"")
																																																																																																																																																																																																																																																																																																																																																																																		? "Registro de estimaciones (Número lesionados RC)"
																																																																																																																																																																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																																																																																																																																																																						"\"DU_GASTOS_MEDICOS\"")
																																																																																																																																																																																																																																																																																																																																																																																								? "Registro de estimaciones (Importe Gastos médicos)"
																																																																																																																																																																																																																																																																																																																																																																																								: resultado
																																																																																																																																																																																																																																																																																																																																																																																										.contains(
																																																																																																																																																																																																																																																																																																																																																																																												"\"DU_NUM_OCUPANTES\"")
																																																																																																																																																																																																																																																																																																																																																																																														? "Registro de estimaciones (Gastos médicos Ocupantes)"
																																																																																																																																																																																																																																																																																																																																																																																														: resultado
																																																																																																																																																																																																																																																																																																																																																																																																.contains(
																																																																																																																																																																																																																																																																																																																																																																																																		"\"DU_GASTOS_LEGALES\"")
																																																																																																																																																																																																																																																																																																																																																																																																				? "Registro de estimaciones (Importe Gastos Legales)"
																																																																																																																																																																																																																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																																																																																																																																																																																																																								"\"DU_ACCI_PERSONALES\"")
																																																																																																																																																																																																																																																																																																																																																																																																										? "Registro de estimaciones (Importe Accidentes Personales)"
																																																																																																																																																																																																																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																																																																																																																																																																																																																														"\"DU_NUM_PERSONALES\"")
																																																																																																																																																																																																																																																																																																																																																																																																																? "Registro de estimaciones (Lesionados Accidentes Personales)"
																																																																																																																																																																																																																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																				"\"DU_RC_VIAJERO\"")
																																																																																																																																																																																																																																																																																																																																																																																																																						? "Registro de estimaciones (Importe R.C viajero)"
																																																																																																																																																																																																																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																										"\"DU_NUM_RC\"")
																																																																																																																																																																																																																																																																																																																																																																																																																												? "Registro de estimaciones (Num. Lesionados RC viajero)"
																																																																																																																																																																																																																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																"\"DU_CRISTALES\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																		? "Registro de estimaciones (Cristales)"
																																																																																																																																																																																																																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																						"\"DU_OTRO\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																								? "Registro de estimaciones (Otro Importe)"
																																																																																																																																																																																																																																																																																																																																																																																																																																								: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																										.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																												"\"DU_OTRO_ESPECIFICAR\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																														? "Registro de estimaciones (Otro)"
																																																																																																																																																																																																																																																																																																																																																																																																																																														: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																		"\"DU_NOM_SUPERVISOR\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																				? "Supervisor asignado"
																																																																																																																																																																																																																																																																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																								"\"DU_CONDICIONADO_A\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																										? "Condicionado a"
																																																																																																																																																																																																																																																																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																														"\"DU_CONCLUSIONES\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																? "Conclusión del ajustador"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																				"\"DU_PREGUNTA_A\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																						? "Circunstancias (Otro)"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																										"\"DU_FOLIO\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																												? "Folio"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																"\"DU_NUM_INCISO\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		? "Inciso"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						"\"DU_NUM_ENDOSO\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								? "Número endoso"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												"\"DU_NOM_AJUSTADOR_GRAL\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														? "Nombre ajustador (conclusiones)"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		"\"DU_CLAVE_AJUSTADOR_GRAL\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				? "Clave ajustador (conclusiones)"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								"\"DU_MODELO_AUTO_A\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										? "Modelo auto  A"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														"\"DU_MODELO_AUTO_B\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																? "Modelo auto B"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				"\"DU_USO_AUTO_A\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						? "Uso auto  A"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										"\"DU_USO_AUTO_B\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												? "Uso auto B"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																"\"DU_FOLIO_INFORME\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		? "Folio informe"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		: resultado
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				.contains(
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						"\"DU_DESCRIPCION_CROQUIS\"")
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								? "Descripción de croquis"
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								: null;

		return descripcion_campo;
	}

	public String errorReciboIngreso(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"RI_NUM_SINIESTRO\"") ? "Número de Siniestro"
				: resultado.contains("\"RI_FOLIO\"") ? "Folio"
						: resultado.contains("\"RI_NUM_POLIZA\"") ? "Número de Póliza"
								: resultado.contains("\"RI_NUM_INCISO\"") ? "Número de Inciso"
										: resultado.contains("\"RI_CLAVE_PROV\"") ? "Clave del Ajustador"
												: resultado.contains("\"RI_COBERTURA\"") ? "Cobertura"
														: resultado.contains("\"RI_AJUSTADOR\"")
																? "Nombre del Ajustador"
																: resultado.contains("\"RI_RECIBIMOS_DE\"")
																		? "Recibimos de"
																		: resultado.contains("\"RI_RFC\"") ? "RFC"
																				: resultado.contains("\"RI_EMAIL\"")
																						? "Email"
																						: resultado.contains(
																								"\"RI_TELEFONO\"")
																										? "Teléfono"
																										: resultado
																												.contains(
																														"\"RI_DOMICILIO\"")
																																? "Con domicilio"
																																: resultado
																																		.contains(
																																				"\"RI_CANTIDAD\"")
																																						? "La cantidad de"
																																						: resultado
																																								.contains(
																																										"\"RI_IMPORTELETRA\"")
																																												? "Importe con letra"
																																												: resultado
																																														.contains(
																																																"\"RI_CONCEPTODE\"")
																																																		? "Por concepto de"
																																																		: resultado
																																																				.contains(
																																																						"\"RI_BANCO1\"")
																																																								? "Banco 1"
																																																								: resultado
																																																										.contains(
																																																												"\"RI_BANCO2\"")
																																																														? "Banco 2"
																																																														: resultado
																																																																.contains(
																																																																		"\"RI_BANCO3\"")
																																																																				? "Banco 3"
																																																																				: resultado
																																																																						.contains(
																																																																								"\"RI_IMPORTE1\"")
																																																																										? "Importe 1"
																																																																										: resultado
																																																																												.contains(
																																																																														"\"RI_IMPORTE2\"")
																																																																																? "Importe 2"
																																																																																: resultado
																																																																																		.contains(
																																																																																				"\"RI_IMPORTE3\"")
																																																																																						? "Importe 3"
																																																																																						: resultado
																																																																																								.contains(
																																																																																										"\"RI_AUTORIZACION1\"")
																																																																																												? "Autorización 1"
																																																																																												: resultado
																																																																																														.contains(
																																																																																																"\"RI_AUTORIZACION2\"")
																																																																																																		? "Autorización 2"
																																																																																																		: resultado
																																																																																																				.contains(
																																																																																																						"\"RI_AUTORIZACION3\"")
																																																																																																								? "Autorización 3"
																																																																																																								: resultado
																																																																																																										.contains(
																																																																																																												"\"RI_NUM_TARJETA1\"")
																																																																																																														? "Número de tarjeta 1"
																																																																																																														: resultado
																																																																																																																.contains(
																																																																																																																		"\"RI_NUM_TARJETA2\"")
																																																																																																																				? "Número de tarjeta 2"
																																																																																																																				: resultado
																																																																																																																						.contains(
																																																																																																																								"\"RI_NUM_TARJETA3\"")
																																																																																																																										? "Número de tarjeta 3"
																																																																																																																										: resultado
																																																																																																																												.contains(
																																																																																																																														"\"RI_IMPORTE_TOTAL\"")
																																																																																																																																? "Importe total"
																																																																																																																																: resultado
																																																																																																																																		.contains(
																																																																																																																																				"\"RI_LUGAR_EXP\"")
																																																																																																																																						? "Lugar de expedición"
																																																																																																																																						: resultado
																																																																																																																																								.contains(
																																																																																																																																										"\"RI_NOM_TERCERO\"")
																																																																																																																																												? "Nombre del tercero"
																																																																																																																																												: resultado
																																																																																																																																														.contains(
																																																																																																																																																"\"RI_NOM_ASEGURADO\"")
																																																																																																																																																		? "Nombre del asegurado"
																																																																																																																																																		: resultado
																																																																																																																																																				.contains(
																																																																																																																																																						"\"RI_NUM_REPORTE\"")
																																																																																																																																																								? "Número de Reporte"
																																																																																																																																																								: null;

		return descripcion_campo;
	}

	public String errorReciboDeducible(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"RD_NUM_SINIESTRO\"") ? "Número de Siniestro"
				: resultado.contains("\"RD_NUM_REPORTE\"") ? "Número de Reporte"
						: resultado.contains("\"RD_FOLIO\"") ? "Folio"
								: resultado.contains("\"RD_NUM_POLIZA\"") ? "Número de Póliza"
										: resultado.contains("\"RD_NUM_INCISO\"") ? "Número de Inciso"
												: resultado.contains("\"RD_CLAVE\"") ? "Clave del Ajustador"
														: resultado.contains("\"RD_AJUSTADOR\"")
																? "Nombre del Ajustador"
																: resultado.contains("\"RD_RECIBIMOS_DE\"")
																		? "Recibimos de"
																		: resultado.contains("\"RD_RFC\"") ? "RFC"
																				: resultado.contains("\"RD_EMAIL\"")
																						? "Email"
																						: resultado.contains(
																								"\"RD_TELEFONO\"")
																										? "Teléfono"
																										: resultado
																												.contains(
																														"\"RD_DOMICILIO\"")
																																? "Con domicilio"
																																: resultado
																																		.contains(
																																				"\"RD_CANTIDAD\"")
																																						? "La cantidad de"
																																						: resultado
																																								.contains(
																																										"\"RD_IMPORTE_LETRA\"")
																																												? "Importe con letra"
																																												: resultado
																																														.contains(
																																																"\"RD_CONCEPTO_DE\"")
																																																		? "Por concepto de"
																																																		: resultado
																																																				.contains(
																																																						"\"RD_NUM_CUENTA1\"")
																																																								? "Número de cuenta 1"
																																																								: resultado
																																																										.contains(
																																																												"\"RD_NUM_CUENTA2\"")
																																																														? "Número de cuenta 2"
																																																														: resultado
																																																																.contains(
																																																																		"\"RD_BANCO1\"")
																																																																				? "Banco 1"
																																																																				: resultado
																																																																						.contains(
																																																																								"\"RD_BANCO2\"")
																																																																										? "Banco 2"
																																																																										: resultado
																																																																												.contains(
																																																																														"\"RD_IMPORTE1\"")
																																																																																? "Importe 1"
																																																																																: resultado
																																																																																		.contains(
																																																																																				"\"RD_IMPORTE2\"")
																																																																																						? "Importe 2"
																																																																																						: resultado
																																																																																								.contains(
																																																																																										"\"RD_AUTORIZACION1\"")
																																																																																												? "Autorización 1"
																																																																																												: resultado
																																																																																														.contains(
																																																																																																"\"RD_AUTORIZACION2\"")
																																																																																																		? "Autorización 2"
																																																																																																		: resultado
																																																																																																				.contains(
																																																																																																						"\"RD_NUM_TARJETA1\"")
																																																																																																								? "Número de Tarjeta 1"
																																																																																																								: resultado
																																																																																																										.contains(
																																																																																																												"\"RD_NUM_TARJETA2\"")
																																																																																																														? "Número de Tarjeta 2"
																																																																																																														: resultado
																																																																																																																.contains(
																																																																																																																		"\"RD_BANCO1B\"")
																																																																																																																				? "Banco 1"
																																																																																																																				: resultado
																																																																																																																						.contains(
																																																																																																																								"\"RD_BANCO2B\"")
																																																																																																																										? "Banco 2"
																																																																																																																										: resultado
																																																																																																																												.contains(
																																																																																																																														"\"RD_IMPORTE1B\"")
																																																																																																																																? "Importe 1"
																																																																																																																																: resultado
																																																																																																																																		.contains(
																																																																																																																																				"\"RD_IMPORTE2B\"")
																																																																																																																																						? "Importe 2"
																																																																																																																																						: resultado
																																																																																																																																								.contains(
																																																																																																																																										"\"RD_IMPORTE_TOTAL\"")
																																																																																																																																												? "Importe total"
																																																																																																																																												: resultado
																																																																																																																																														.contains(
																																																																																																																																																"\"RD_LUGAR_EXP\"")
																																																																																																																																																		? "Lugar de expedición"

																																																																																																																																																		: null;

		return descripcion_campo;
	}

	public String errorSolicitudDiagnostico(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"SD_NUM_REPORTE\"") ? "Número del Reporte"
				: resultado.contains("\"SD_NUM_POLIZA\"") ? "Número del Póliza"
						: resultado.contains("\"SD_NUM_ENDOSO\"") ? "Número del Endoso"
								: resultado.contains("\"SD_NUM_INCISO\"") ? "Número del Inciso"
										: resultado.contains("\"SD_NUM_SINIESTRO\"") ? "Número del Siniestro"
												: resultado.contains("\"SD_NOM_CLIENTE\"") ? "Nombre del cliente"
														: resultado.contains("\"SD_EMAIL_CLIENTE\"")
																? "Email del cliente"
																: resultado.contains("\"SD_TEL_CLIENTE\"")
																		? "Teléfono del cliente"
																		: resultado.contains("\"SD_RAZON_ENVIO\"")
																				? "Razón Social del CDR"
																				: resultado.contains(
																						"\"SD_RAZON_RESPONSABLE\"")
																								? "Responsable"
																								: resultado.contains(
																										"\"SD_RAZON_TELEFONO\"")
																												? "Teléfono CDR"
																												: resultado
																														.contains(
																																"\"SD_RAZON_DOMICILIO\"")
																																		? "Domicilio"
																																		: resultado
																																				.contains(
																																						"\"SD_RAZON_COBERTURA\"")
																																								? "Cobertura"
																																								: resultado
																																										.contains(
																																												"\"SD_MARCA_AUTO\"")
																																														? "Marca del auto"
																																														: resultado
																																																.contains(
																																																		"\"SD_TIPO_AUTO\"")
																																																				? "Tipo de auto"
																																																				: resultado
																																																						.contains(
																																																								"\"SD_MODELO_AUTO\"")
																																																										? "Modelo del auto"
																																																										: resultado
																																																												.contains(
																																																														"\"SD_KILOMETRAJE_AUTO\"")
																																																																? "Kilometraj"
																																																																: resultado
																																																																		.contains(
																																																																				"\"SD_NUM_SERIE\"")
																																																																						? "Número de Serie del auto"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"SD_COLOR_AUTO\"")
																																																																												? "Color del auto"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"SD_PLACA_AUTO\"")
																																																																																		? "Placa del auto"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"SD_DANIOS_UNIDAD\"")
																																																																																								? "Danios de la Unidad"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"SD_DESCRIPCION_DANIOS\"")
																																																																																														? "Descripción de Danios"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"SD_DANIOS_PRE\"")
																																																																																																				? "Danios Preexistentes"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"SD_NOM_AJUSTADOR\"")
																																																																																																										? "Nombre del Ajustador"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"SD_CLAVE_AJUSTADOR\"")
																																																																																																																? "Clave del Ajustador"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"SD_OTRO\"")
																																																																																																																						? "Otro"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"SD_DESCRIPCION_DANIOS_PRE\"")
																																																																																																																												? "Descripción de Danios Preexistentes"

																																																																																																																												: null;

		return descripcion_campo;
	}

	public String errorMemoriaDescriptiva(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"SG_FOLIO_ELECTRO\"") ? "Folio Electrónico"
				: resultado.contains("\"SG_NUM_REPORTE\"") ? "Número de Reporte"
						: resultado.contains("\"SG_NUM_SINIESTRO\"") ? "Número de Siniestro"
								: resultado.contains("\"SG_NUM_POLIZA\"") ? "Número de Póliza"
										: resultado.contains("\"SG_NUM_ENDOSO\"") ? "Número de Endoso"
												: resultado.contains("\"SG_NUM_INCISO\"") ? "Número de Inciso"
														: resultado.contains("\"SG_NOM_ASEGURADO\"")
																? "Nombre del asegurado"
																: resultado.contains("\"SG_MARCA_AUTO\"")
																		? "Marca de auto"
																		: resultado.contains("\"SG_TIPO_AUTO\"")
																				? "Tipo del auto"
																				: resultado
																						.contains("\"SG_MODELO_AUTO\"")
																								? "Modelo del auto"
																								: resultado.contains(
																										"\"SG_PLACAS_AUTO\"")
																												? "Placas del auto"
																												: resultado
																														.contains(
																																"\"SG_COLOR_AUTO\"")
																																		? "Color del auto"
																																		: resultado
																																				.contains(
																																						"\"SG_DURACION_MANIOBRA\"")
																																								? "Duración de maniobras"
																																								: resultado
																																										.contains(
																																												"\"SG_TIPO_MANIOBRA \"")
																																														? "Tipo de maniobra/suelo"
																																														: resultado
																																																.contains(
																																																		"\"SG_OTRA \"")
																																																				? "Otra grúa"
																																																				: resultado
																																																						.contains(
																																																								"\"SG_PROVEEDOR \"")
																																																										? "Proveedor que presta el servicio"
																																																										: resultado
																																																												.contains(
																																																														"\"SG_UBI_ORIGEN \"")
																																																																? "Ubicación exacta de origen"
																																																																: resultado
																																																																		.contains(
																																																																				"\"SG_UBI_DESTINO \"")
																																																																						? "Ubicación excata del destino"
																																																																						: resultado
																																																																								.contains(
																																																																										"\"SG_MANIO_ESPECIALES \"")
																																																																												? "Maniobras especiales detallar"
																																																																												: resultado
																																																																														.contains(
																																																																																"\"SG_NOM_EMPLEADO \"")
																																																																																		? "Nombre del empleado"
																																																																																		: resultado
																																																																																				.contains(
																																																																																						"\"SG_CLAVE_EMPLEADO \"")
																																																																																								? "Clave del empleado"
																																																																																								: resultado
																																																																																										.contains(
																																																																																												"\"SG_NOM_OPERADOR \"")
																																																																																														? "Nombre del operador"
																																																																																														: resultado
																																																																																																.contains(
																																																																																																		"\"EMAIL_DEFAULT \"")
																																																																																																				? "Email"
																																																																																																				: resultado
																																																																																																						.contains(
																																																																																																								"\"TIPOTRASPALEO\"")
																																																																																																										? "Tipo traspalo"
																																																																																																										: resultado
																																																																																																												.contains(
																																																																																																														"\"CANTIDADGRUASTEXTO\"")
																																																																																																																? "Cantidad grúas que se utilizarón"
																																																																																																																: resultado
																																																																																																																		.contains(
																																																																																																																				"\"TELEFONO\"")
																																																																																																																						? "Teléfono"
																																																																																																																						: resultado
																																																																																																																								.contains(
																																																																																																																										"\"DOMICILIOPROVEEDOR\"")
																																																																																																																												? "Domicilio del proveedor"
																																																																																																																												: resultado
																																																																																																																														.contains(
																																																																																																																																"\"HORARIOSOLICITADO\"")
																																																																																																																																		? "Horario solicitado"
																																																																																																																																		: resultado
																																																																																																																																				.contains(
																																																																																																																																						"\"HORARIOARRIBO\"")
																																																																																																																																								? "Horario arribo"
																																																																																																																																								: resultado
																																																																																																																																										.contains(
																																																																																																																																												"\"HORARIOTRASLADO\"")
																																																																																																																																														? "Horario traslado"
																																																																																																																																														: resultado
																																																																																																																																																.contains(
																																																																																																																																																		"\"NUMECOGRUA\"")
																																																																																																																																																				? "Número Eco Grúa"
																																																																																																																																																				: resultado
																																																																																																																																																						.contains(
																																																																																																																																																								"\"MANUALHORA\"")
																																																																																																																																																										? "Tipo de servicio: Hora manual"
																																																																																																																																																										: resultado
																																																																																																																																																												.contains(
																																																																																																																																																														"\"GRUAHORA\"")
																																																																																																																																																																? "Tipo de servicio: Hora grúa"
																																																																																																																																																																: null;

		return descripcion_campo;
	}

//formato cargo tarjeta credito
	public String errorCargoTarjetCredito(String resultado) {
		String descripcion_campo = null;
		descripcion_campo = resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"TC_NUM_REPORTE\"") ? "Número de reporte"
				: resultado.contains("\"TC_NUM_SINIESTRO\"") ? "Número de siniestro"
						: resultado.contains("\"TC_NUM_ASEGURADO\"") ? "Número de asegurado"
								: resultado.contains("\"TC_NUM_AUTORIZACION\"") ? "Número de autorización"
										: resultado.contains("\"TC_NOMBRE\"") ? "Nombre"
												: resultado.contains("\"TC_DIRECCION\"") ? "Dirección"
														: resultado.contains("\"TC_ESTADO\"")? "Estado"
																: resultado.contains("\"TC_CP\"")? "Código postal"
																: resultado.contains("\"TC_TELEFONO\"")? "Teléfono"	
																: resultado.contains("\"TC_CANTIDAD_AUTORIZADA\"")? "Cantidad autorizada"
																: resultado.contains("\"TC_NUM_TARJETA\"")? "Número de tarjeta"
																
															    : resultado.contains("\"TC_VENCIMIENTO_TARJETA\"")? "ID de tarjeta"
															    : resultado.contains("\"TC_CLAVE_AJUSTADOR\"")? "Clave del ajustador"
															    		 : resultado.contains("\"TC_NUM_POLIZA\"")? "Número de póliza"
															    				 : resultado.contains("\"TC_CORREO\"")? "correo"
																		: null;
		
		
	
		return descripcion_campo;
	}
	
	public String errorResponsabilidadCivil(String resultado) {
		String descripcion_campo = null;
		descripcion_campo =   resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"RC_NUM_REPORTE\"") ? "Número de reporte"
				  : resultado.contains("\"RC_NUM_SINIESTRO\"") ? "Número de siniestro" 
				  : resultado.contains("\"RC_NUM_POLIZA\"") ? "Número de poliza"
				  : resultado.contains("\"RC_FOLIO_DUA\"") ? "Número de DUA" 
				  : resultado.contains("\"RC_COMPANIA_TRANS_MER\"") ? "COMPAÑÍA DE SEGUROS DEL VEHÍCULO QUE TRANSPORTA"
				  : resultado.contains("\"RC_REPORTE_VEHICULO\"") ? "NUMERO REPORTE DEL VEHÍCULO QUE TRANSPORTA"
				  : resultado.contains("\"RC_NOM_PROPIETARIO\"") ? "RAZÓN SOCIAL PROPIETARIO CARGA / MERCANCÍA"
				  : resultado.contains("\"RC_TEL_PROPIETARIO\"") ? "TELÉFONO PROPIETARIO"
				  : resultado.contains("\"RC_CORREO_PROPIETARIO\"") ? "CORREO PROPIETARIO"  
				  : resultado.contains("\"RC_NOM_TRANSPORTISTA\"") ? "RAZÓN SOCIAL TRANSPORTISTA" 
				  : resultado.contains("\"RC_TEL_TRANSPORTISTA\"") ? "TELÉFONO TRANSPORTISTA"
				  : resultado.contains("\"RC_CORREO_TRANSPORTISTA\"") ? "CORREO TRANSPORTISTA" 
				  : resultado.contains("\"RC_DIR_SINIESTRO\"") ? "DIRECCIÓN SINIESTRO"
				  : resultado.contains("\"RC_ENTIDAD_SINIESTRO\"") ? "ENTIDAD SINIESTRO" 
				  : resultado.contains("\"RC_DIR_RESGUARDO\"") ? "DIRECCIÓN DE RESGUARDO"
				  : resultado.contains("\"RC_ENTIDAD_RESGUARDO\"") ? "ENTIDAD DE RESGUARDO"
				  : resultado.contains("\"RC_RESPONSABLE\"") ? "RESPONSABLE" 
				  : resultado.contains("\"RC_ENTIDAD_RESP\"") ? "ENTIDAD DEL RESPONSABLE" 
				  : resultado.contains("\"RC_TEL_RESPONSABLE\"") ? "TELÉFONO DEL RESPONSABLE" 
				  : resultado.contains("\"RC_NUM_ACTA\"") ? "Número de acta/carpeta" 
				  : resultado.contains("\"RC_DESCRIPCION_VEH\"") ? "DESCRIPCIÓN DE VEHÍCULO" 
				  : resultado.contains("\"RC_NOM_OPERADOR\"") ? "NOMBRE Y APELLIDOS OPERADOR" 
				  : resultado.contains("\"RC_DICTAMEN\"") ? "DICTAMEN Y/O CERTIFICADO MÉDICO"
				  : resultado.contains("\"RC_DESCRIPCION_MERC\"") ? "DESCRIPCIÓN DE MERCANCÍA / CARGA"
				  : resultado.contains("\"RC_PORCENTAJE_APROX\"") ? "% APROX."				 
				  : resultado.contains("\"RC_NOM_ASEGURADORA\"") ? "NOMBRE DE ASEGURADORA"
				  : resultado.contains("\"RC_FOLIO_CARTA\"") ? "FOLIO CARTA PORTE"
				  : resultado.contains("\"RC_FOLIO_FACTURA\"") ? "FOLIO FACTURA"  
				  : resultado.contains("\"RC_FOLIO_REMISION\"") ? "FOLIO REMISION" 
				  : resultado.contains("\"RC_FOLIO_GUIA\"") ? "FOLIO GUÍA DE EMBARQUE"
				  : resultado.contains("\"RC_FOLIO_MAPA\"") ? "FOLIO MAPA DE CARGA"
				  : resultado.contains("\"RC_INFORME_AJUSTADOR\"") ? "INFORME DEL AJUSTADOR"
				  : resultado.contains("\"RC_NOM_AJUSTADOR\"") ? "NOMBRE DEL AJUSTADOR"
				  : resultado.contains("\"RC_CLAVE_AJUSTADOR\"") ? "CLAVE DEL AJUSTADOR" 
				  : resultado.contains("\"RC_NOM_ASEGURADO_TERCERO\"") ? "NOMBRE DEL ASEGURADO/TERCERO" 
				  : resultado.contains("\"RC_NOM_ASEGURADO\"") ? "NOMBRE DEL ASEGURADO" 
																: null;

		return descripcion_campo;
	}
	
	
	//nuevo formato
	public String errorBienesDiversos(String resultado) {
		String descripcion_campo = null;
		descripcion_campo =    resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"BD_NUM_REPORTE\"") ? "Número de reporte" 
				: resultado.contains("\"BD_NUM_SINIESTRO\"") ? "Número de siniestro"
				: resultado.contains("\"BD_NUM_POLIZA\"") ? "Número de poliza"
				: resultado.contains("\"BD_NOMBRE_AFECTADO\"") ? "Nombre del afectado"
				: resultado.contains("\"BD_TEL_AFECTADO\"") ? " Teléfono del afectado"
				: resultado.contains("\"BD_UBICACION_SINIESTRO\"") ? "Ubicación del siniestro"
				: resultado.contains("\"BD_DOMICILIO_SINIESTRO\"") ? "Domicilio de siniestro"
				: resultado.contains("\"BD_TELEFONO_SINIESTRO\"") ? "Teléfono del siniestro"
				: resultado.contains("\"BD_UBICACION_RESGUARDO\"") ? "Ubucación de resguardo"
				: resultado.contains("\"BD_DOMICILIO_RESGUARDO\"") ? "Domicilio de resguardo"
				: resultado.contains("\"BD_TELEFONO_RESGUARDO\"") ? "Teléfono de resguardo"
				: resultado.contains("\"BD_DANIOS_DIVERSOS\"") ? "Danios diversos"
				: resultado.contains("\"BD_RESPONSABLE\"") ? "Responsable"
				: resultado.contains("\"BD_OBSERVACIONES\"") ? "Observaciones"
				: resultado.contains("\"BD_LONG\"") ? "Longitud"
				: resultado.contains("\"BD_ALTO\"") ? "Alto"
				: resultado.contains("\"BD_ANCHO\"") ? "Ancho"
				: resultado.contains("\"BD_TIPO\"") ? "Tipo" 
				: resultado.contains("\"BD_SERIE\"") ? "Serie" 
				: resultado.contains("\"BD_TRAMO\"") ? "Tramo" 
				: resultado.contains("\"BD_KM\"") ? "KM" 
				: resultado.contains("\"BD_DESCRIPCION_DANIOS_CAN\"") ? "Descripcion de danios-cantidad"
				: resultado.contains("\"BD_DES_DANIOS_PRE\"") ? "Descripción de danios preexistentes" 
				: resultado.contains("\"BD_MOTIVO_NO_DANIOS\"") ? "Motivo de no funcionamiento" 
				: resultado.contains("\"BD_CORREO\"") ? "correo" 
				: resultado.contains("\"BD_NOM_AJUSTADOR\"") ? "Nombre del ajustador" 
				: resultado.contains("\"BD_CLAVE_AJUSTADOR\"") ? "Clave del ajustador" 
				: resultado.contains("\"BD_NOM_ASEGURADO_TERCERO\"") ? "Nombre del asegurado o tercero" 
				
																: null;

		return descripcion_campo;
	}

//formato observaciones
	public String errorObservacionesAsegurado(String resultado) {
		String descripcion_campo = null;
		descripcion_campo =    resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
			resultado.contains("\"FOA_NUM_REPORTE\"") ? "Número de reporte" 
							: resultado.contains("\"FOA_NUM_SINIESTRO\"") ? "Número de siniestro"						
				            : resultado.contains("\"FOA_NUM_POLIZA\"") ? "Número de póliza" 
				            : resultado.contains("\"FOA_NOM_AJUSTADOR\"") ? "Nombre del ajustador" 
				            : resultado.contains("\"FOA_OBSERVACIONES\"") ? "Observaciones " 
				            : resultado.contains("\"FOA_NOM_CONDUCTOR\"") ? "Nombre del conductor" 
				            : resultado.contains("\"FOA_TELEFONO\"") ? "Teléfono" 
				            : resultado.contains("\"FOA_CORREO_CONDUCTOR\"") ? "Correo" 
				            : resultado.contains("\"FOA_CLAVE_AJUSTADOR\"") ? "Clave del ajustador" 				          
				            : resultado.contains("\"FOA_LUGAR\"") ? "Lugar" 
				
																: null;

		return descripcion_campo;
	}
	
	
	//formato inventario
		///// 
		
		public String errorInventarioUnicoPesado(String resultado) {
			String descripcion_campo = null;
			descripcion_campo =    
					resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
					resultado.contains("\"INP_FOLIO_E\"") ? "Folio"
							: resultado.contains("\"INP_SERIE\"") ? "Serie"
									:resultado.contains("\"INP_COLOR\"") ? "Color"
											: resultado.contains("\"INP_PLACA\"") ? "Placa"
					
							:resultado.contains("\"INP_NUM_REPORTE\"") ? "Número de reporte"
							: resultado.contains("\"INP_NUM_SINIESTRO\"") ? "Número de siniestro"
							: resultado.contains("\"INP_NUM_POLIZA\"") ? "Número de póliza"
						
							: resultado.contains("\"INP_NOMBRE_AFECTADO\"") ? "Nombre del afectado"
							: resultado.contains("\"INP_NUM_ENDOSO\"") ? "Número de endoso"
							: resultado.contains("\"INP_NUM_INCISO\"") ? "Número de inciso"
							: resultado.contains("\"INP_MARCA\"") ? "Marca"
							: resultado.contains("\"INP_TIPO\"") ? "Tipo auto"
							: resultado.contains("\"INP_PUERTAS\"") ? "Puertas de auto"
							: resultado.contains("\"INP_MODELO\"") ? "Modelo de auto"
							: resultado.contains("\"INP_NUM_MOTOR\"") ? "Número de motor"
							: resultado.contains("\"INP_KILOMETRAJE\"") ? "Kilometraje"
							: resultado.contains("\"INP_CORREO\"") ? "Correo"
							: resultado.contains("\"INP_TRACTOCAMION_PIEZA\"") ? "Tractocamión o camión"
							: resultado.contains("\"INP_ORIGINALES_CAMION\"") ? "Originales camión"
							: resultado.contains("\"INP_RENOVADAS_CAMION\"") ? "Renovadas camión"
							: resultado.contains("\"INP_DANIADAS_CAMION\"") ? "Daniadas camión"
							: resultado.contains("\"INP_FALTANTES_CAMION\"") ? "Faltantes camión"
							: resultado.contains("\"INP_DANIADAS_REMOLQUE\"") ? "Daniadas remolque"
							: resultado.contains("\"INP_FALTANTES_REMOLQUE\"") ? "Faltantes remolque"
							: resultado.contains("\"INP_NOMBRE_CONDUCTOR\"") ? "Nombre del conductor"
							: resultado.contains("\"INP_NOMBRE_OPERADOR_GRUA\"") ? "Nombre del operador de grúa"
									
							: resultado.contains("\"INP_CASO1_LUGAR\"") ? "Lugar caso 1"
							: resultado.contains("\"INP_CASO1_OBSERVACIONES\"") ? "Observaciones caso 1"
							: resultado.contains("\"INP_CASO1_NOM_ENTREGA\"") ? "Nombre de quien entrega, caso 1"
							: resultado.contains("\"INP_CASO1_NOM_RECIBE\"") ? "Nombre de quien recibe, caso 1"
					
							: resultado.contains("\"INP_CASO2_LUGAR\"") ? "Lugar caso 2"
							: resultado.contains("\"INP_CASO2_OBSERVACIONES\"") ? "Observaciones caso 2"
							: resultado.contains("\"INP_CASO2_NOM_ENTREGA\"") ? "Nombre de quien entrega, caso 2"
							: resultado.contains("\"INP_CASO2_NOM_RECIBE\"") ? "Nombre de quien recibe, caso 2"
									
							: resultado.contains("\"INP_CASO3_LUGAR\"") ? "\"Lugar caso 3"
							: resultado.contains("\"INP_CASO3_OBSERVACIONES\"") ? "Observaciones caso 3"
							: resultado.contains("\"INP_CASO3_NOM_ENTREGA\"") ? "Nombre de quien entrega, caso 3"
							: resultado.contains("\"INP_CASO3_NOM_RECIBE\"") ? "Nombre de quien recibe, caso 3"
									
							: resultado.contains("\"INP_NOM_AJUSTADOR\"") ? "Nombre del ajustador"
							: resultado.contains("\"INP_CLAVE_AJUSTADOR\"") ? "Clave del ajustador"
									
									
									: resultado.contains("\"INP_CORREO_GRUA\"") ? "Correo de grua"
									: resultado.contains("\"INP_CORREO_TALLER\"") ? "Correo de taller"
								
									: resultado.contains("\"INP_CASO_1_A_LUGAR\"") ? "caso 1: a lugar"
									: resultado.contains("\"INP_CASO_1_PRESTADOR\"") ? "caso 1: prestador"
									: resultado.contains("\"INP_CASO_1_DANIOS_FALTANTES\"") ? "caso 1: daños faltantes"
									: resultado.contains("\"INP_CASO_1_CRUCERO\"") ? "caso 1: crucero"
									: resultado.contains("\"INP_CASO_1_TALLER\"") ? "caso 1: taller"
									: resultado.contains("\"INP_CASO_1_MP\"") ? "caso 1: MP"
									: resultado.contains("\"INP_CASO_1_AJUSTADOR\"") ? "caso 1: ajustador"
											
													: resultado.contains("\"INP_CASO_2_A_LUGAR\"") ? "caso 2: a lugar"
													: resultado.contains("\"INP_CASO_2_PRESTADOR\"") ? "caso 2: prestador"
													: resultado.contains("\"INP_CASO_2_DANIOS_FALTANTES\"") ? "caso 2: daños faltantes"
													: resultado.contains("\"INP_CASO_2_CRUCERO\"") ? "caso 2: crucero"
													: resultado.contains("\"INP_CASO_2_TALLER\"") ? "caso 2: taller"
													: resultado.contains("\"INP_CASO_2_MP\"") ? "caso 2: MP"
													: resultado.contains("\"INP_CASO_2_AJUSTADOR\"") ? "caso 2: ajustador"
															
													: resultado.contains("\"INP_CASO_3_A_LUGAR\"") ? "caso 3: a lugar"
													: resultado.contains("\"INP_CASO_3_PRESTADOR\"") ? "caso 3: prestador"
													: resultado.contains("\"INP_CASO_3_DANIOS_FALTANTES\"") ? "caso 3: daños faltantes"
													: resultado.contains("\"INP_CASO_3_CRUCERO\"") ? "caso 3: crucero"
													: resultado.contains("\"INP_CASO_3_TALLER\"") ? "caso 3: taller"
													: resultado.contains("\"INP_CASO_3_MP\"") ? "caso 3: MP"
													: resultado.contains("\"INP_CASO_3_AJUSTADOR\"") ? "caso 3: ajustador"
													: resultado.contains("\"INP_NOM_ENTREGA_GRAL\"") ? "Nombre de quien entrega"
													: resultado.contains("\"INP_NOM_RECIBE_GRAL\"") ? "Nombre de quien recibe"
					
																	: null;

			return descripcion_campo;
		}
		
		public String errorReclamacionComprobantePeaje(String resultado) {
			String descripcion_campo = null;
			descripcion_campo = 
					resultado.contains("\"CORREO_OCULTO\"")? "Correo oculto": 
							  resultado.contains("\"RCP_NUM_REPORTE\"") ? "Número de reporte"
							: resultado.contains("\"RCP_NUM_SINIESTRO\"") ? "Número de siniestro"
							: resultado.contains("\"RCP_NUM_POLIZA\"") ? "Número de póliza"
							: resultado.contains("\"RCP_NOM_USUARIO\"") ? "Nombre de usuario"
							: resultado.contains("\"RCP_SEXO_USUARIO\"") ? "Sexo de usuario"
							: resultado.contains("\"RCP_EDAD_USUARIO\"") ? "Edad del usuario"
							: resultado.contains("\"RCP_ESTADO_CIVIL_USUARIO\"") ? "Estado civil del usuario"
							: resultado.contains("\"RCP_OCUPACION_USUARIO\"") ? "Ocupación del usuario"
							: resultado.contains("\"RCP_TELEFONO_USUARIO\"") ? "Teléfono del usuario"
							: resultado.contains("\"RCP_CORREO_USUARIO\"") ? "Correo del usuario"
							: resultado.contains("\"RCP_CALLE_USUARIO\"") ? "Calle del usuario"
							: resultado.contains("\"RCP_COLONIA_USUARIO\"") ? "Colonia del usuario"
							: resultado.contains("\"RCP_CP_USUARIO\"") ? "CP del usuario"
							: resultado.contains("\"RCP_ESTADO_USUARIO\"") ? "Estado del usuario"
							: resultado.contains("\"RCP_POBLACION_USUARIO\"") ? "Pablación del usuario"
							: resultado.contains("\"RCP_DELEGACION_USUARIO\"") ? "Delegación del usuario"
							: resultado.contains("\"RCP_CALLE_OFICINA\"") ? "Calle de la oficina"
							: resultado.contains("\"RCP_COLONIA_OFICINA\"") ? "Colonia de la oficina"
							: resultado.contains("\"RCP_CP_OFICINA\"") ? "CP de la oficina"
							: resultado.contains("\"RCP_ESTADO_OFICINA\"") ? "Estado de la oficina"
							: resultado.contains("\"RCP_POBLACION_OFICINA\"") ? "Población de la oficina"
							: resultado.contains("\"RCP_DELEGACION_OFICINA\"") ? "Delegación de la oficina"
									
							: resultado.contains("\"RCP_MARCA_VEHICULO\"") ? "Marca del vehícilo"
							: resultado.contains("\"RCP_LICENCIA\"") ? "Licencia"
							: resultado.contains("\"RCP_ORIGEN_VIAJE\"") ? "Origen del viaje"
							: resultado.contains("\"RCP_DESTINO_VIAJE\"") ? "Destino del viaje"
							: resultado.contains("\"RCP_MOTIVO_NO_COMPROB\"") ? "Motivo de no contar con comprobante"
							: resultado.contains("\"RCP_NOM_AJUSTADOR\"") ? "Nombre del ajustador"
							: resultado.contains("\"RCP_CLAVE_AJUSTADOR\"") ? "Clave del ajustador"
							: resultado.contains("\"RCP_NOM_ADMINISTRACION\"") ? "Administración de la plaza"
							: resultado.contains("\"RCP_TESTIGO_1\"") ? "Testigo 1"
							: resultado.contains("\"RCP_TESTIGO_2\"") ? "Testigo 2"
							
							: resultado.contains("\"RCP_NOM_PLAZA_1\"") ? "Nombre de la plaza de cobro 1"
							: resultado.contains("\"RCP_NOM_PLAZA_2\"") ? "Nombre de la plaza de cobro 1"
							: resultado.contains("\"RCP_CANTIDAD_PLAZA_1\"") ? "Cantidad pagada en la plaza 1"
							: resultado.contains("\"RCP_CANTIDAD_PLAZA_2\"") ? "Cantidad pagada en la plaza 1"
							: resultado.contains("\"RCP_FRECUENCIA_CIRCULA\"") ? "Frecuencia en que circula"
									
							: resultado.contains("\"RCP_PAGO_TARJETA_CREDITO\"") ? "Pago con tarjeta de crédito"
							: resultado.contains("\"RCP_VIA_INGRESO\"") ? "Vía de ingreso al tramo carretero"
							: resultado.contains("\"RCP_MOTIVO_DANIO\"") ? "Motivo por el cual sufrio el daño"
							
							: resultado.contains("\"RCP_VEHICULO_ASEGURADO_POLIZA\"") ? "Póliza de vehículo asegurado"
							: resultado.contains("\"RCP_VEHICULO_ASEGURADO_COMPANIA\"") ? "Compañia de vehículo asegurado"
							: resultado.contains("\"RCP_ANEXO_IDENTIFICACION\"") ? "Anexo: Tipo de indentificación: otro"
							: resultado.contains("\"RCP_ANEXO_LICENCIA\"") ? "Anexo: licencia de conducir y vigencia"
							: resultado.contains("\"RCP_ANEXO_NARRACION\"") ? "Anexo: narración"
							: resultado.contains("\"RCP_NOM_TESTIGO\"") ? "Nombre del testigo"
							: resultado.contains("\"RCP_RELACION_TESTIGO\"") ? "Testigo: relación/parentesco"
							: resultado.contains("\"RCP_TELEFONO_TESTIGO\"") ? "Testigo: teléfono"
							: resultado.contains("\"RCP_CALLE_TESTIGO\"") ? "Testigo: calle"
							: resultado.contains("\"RCP_COLONIA_TESTIGO\"") ? "Testigo: colonia"
							: resultado.contains("\"RCP_CP_TESTIGO\"") ? "Testigo: CP"
							: resultado.contains("\"RCP_ESTADO_TESTIGO\"") ? "Testigo: estado"
							: resultado.contains("\"RCP_POBLACION_TESTIGO\"") ? "Testigo: población"
							: resultado.contains("\"RCP_DELEGACION_TESTIGO\"") ? "Testigo: delegación"
							: resultado.contains("\"RCP_DECLARACION_TESTIGO\"") ? "Testigo: declaración"
					
																	: null;

			return descripcion_campo;
		}
}
