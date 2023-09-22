package com.aaq.col.clases.database.repositorios.interfase;

public interface HomologaEstadoMunDaoInterfase {

	public String getIdEstado(String estado);
	public String getIdMinucipio(String estado,String municipio);
	public void insertaLog(String log);
	public String getDiccionario(String valor);
	public String getNombreEstadoId(String idEstado);
	
}
