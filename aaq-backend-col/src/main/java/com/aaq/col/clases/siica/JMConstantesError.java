/**
 * 
 */
package com.aaq.col.clases.siica;

import java.io.Serializable;

/**
 * @author Arturo de la Cruz
 * Clase para el la identificacion de errores generados.
 */
public class JMConstantesError implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6647312656935761871L;
	
	//------Errores de funciones
	//Llamado a funcion
	public static final String ERROR_CALL_FUNCION = "001FUNC";
	
	//respuesta de funcion
	public static final String ERROR_RESPUESTA_FUNCION = "002FUNC";
	
	//Error en transaccion base de datos
	public static final String ERROR_TRANSACTION = "003TRANS";
	
	
	//------Errores de codigo
	//nullPointer
	public static final String ERROR_NULL_POINTER = "001COD";

	//No definido
	public static final String ERROR_UNDEFINED = "000COD";
}
