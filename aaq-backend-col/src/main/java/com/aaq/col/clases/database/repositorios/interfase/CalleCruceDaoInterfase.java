package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CalleCruce;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CalleCruceDaoInterfase extends JMRepositorioGenericoInterfase<CalleCruce> {

	public abstract CalleCruce objetoCalleCruce(String id);
	public abstract List<CalleCruce> listaDeCalleCruce(Estado estado, String idmunicipio, String idcolonia,
			String nombrecalleUno, String nombrecalleDos);

}