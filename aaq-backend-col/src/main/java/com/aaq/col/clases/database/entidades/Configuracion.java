package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractConfiguracion;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "configuracion")
@RequestScoped
@Entity(name = "Configuracion")
@Access(AccessType.FIELD)
@Table(name = "configuracion")
public class Configuracion extends AbstractConfiguracion {

	private static final long serialVersionUID = -3618363246302129706L;

	public Configuracion() {
		super();
	}

	private static ConfiguracionServiceInterfase configuracionService;

	public static ConfiguracionServiceInterfase getConfiguracionService() {
		if (Configuracion.configuracionService == null) {
			Configuracion.configuracionService = JMSIICAServerServiceSingleton.getInstance().getConfiguracionService();
		}
		return Configuracion.configuracionService;
	}

	public String getDescripcion() {
		return this.getNombre();
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Nombre,nombre", "Valor,valorString" }).getLista();
	}
	
	public String getValorString() {
		final StringBuilder retorno = new StringBuilder();
		String correos[];
		int contador=0;
		if (this.getValor() != null && this.getValor().contains("@")) {
			correos=this.getValor().split("/");
			for (String string : correos) {
				retorno.append(string+"/");
				contador++;
				if (contador==5) {
					retorno.append("\n");
					contador=0;
				}
			}
			return Objects.toString(retorno, "");
		}
		retorno.append(this.getValor());
		return Objects.toString(retorno, "");
	}
	

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		return new JMResultadoOperacion(new Exception("No se puede Eliminar. Catalogo de Sistema"));
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return Configuracion.getConfiguracionService().guardarObjeto(this);
		}  catch (IndexOutOfBoundsException  | ClassCastException | RollbackException e) {
			return new JMResultadoOperacion(e);
		}catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final DataAccessException ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
