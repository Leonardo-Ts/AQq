package com.aaq.col.clases.database.repositorios.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.StoredProcedureQuery;

import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.dao.DataIntegrityViolationException;

import com.aaq.col.clases.database.entidades.FormatoDeclaracionUniversal;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ConclusionSiniestroDaoInterfase;


@org.springframework.stereotype.Repository(value = "conclusionSiniestroDao")
public class ConclusionSiniestroDao extends SIICAServerGenericDaoJpaImpl<FormatoDeclaracionUniversal> implements ConclusionSiniestroDaoInterfase  {
	
	
	@Override
	public Map<String, Object> obtenerInformacionDUA( String reporte) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		if (reporte  == null) {
			respuesta.put("respuesta","ERROR: ES requerido el número de reporte");
			return respuesta;
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"CONCLUSION_SINIESTRO_DUA");

			nat.registerStoredProcedureParameter("in_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("out_narracion", String.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("out_croquis", Clob.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("out_firma_conductor", Clob.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("out_conclusion", String.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("out_nombre_conductor", String.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("out_responsable", Integer.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("out_email_conductor", String.class,  ParameterMode.OUT);


			nat.setParameter("in_reporte", reporte);
			nat.execute();

			respuesta.put("respuesta", (String)(nat.getOutputParameterValue("out_respuesta"))); 
			respuesta.put("narracion",(String)(nat.getOutputParameterValue("out_narracion")));
			Clob clob1 = (Clob) nat.getOutputParameterValue("out_croquis");
			String croquisCadena = null;
			if(clob1 != null) {
				croquisCadena = this.ClobToString(clob1);
			}
			respuesta.put("croquis", croquisCadena); 
			
			Clob clobFirma = (Clob) nat.getOutputParameterValue("out_firma_conductor"); //out_firma_conductor
			String firmaCadena = null;
			if(clobFirma != null) {
				firmaCadena = this.ClobToString(clobFirma);
			}
			respuesta.put("firmaConductor", firmaCadena); 
			
			respuesta.put("conclusion",(String)(nat.getOutputParameterValue("out_conclusion")));
			respuesta.put("nombreConductor",(String)(nat.getOutputParameterValue("out_nombre_conductor")));
			respuesta.put("responsable", nat.getOutputParameterValue("out_responsable"));
			respuesta.put("email_conductor",(String)(nat.getOutputParameterValue("out_email_conductor")));
			
 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtenerInformacionDUA", reporte);
			respuesta.put("respuesta", "ERROR: "+e); 
		}
		
		return respuesta;
	}

	
	  private String ClobToString(Clob clob) throws SQLException, IOException {
		  
	        String reString = "";
	        Reader is = clob.getCharacterStream (); // Obtener la transmisión
	        BufferedReader br = new BufferedReader(is);
	        String s = br.readLine();
	        StringBuffer sb = new StringBuffer();
	                 while (s != null) {// Ejecuta el ciclo para sacar todas las cadenas y paga al StringBuffer para convertir de StringBuffer a STRING
	        sb.append(s);
	        s = br.readLine();
	        }
	        reString = sb.toString();
	        return reString;
	        }
	  
	  @Override
		public Map<String, Object> informacionFoliosDUA(String reporte) {
			Map<String, Object> respuesta = new HashMap<String, Object>();
			
			if (reporte  == null) {
				respuesta.put("respuesta","ERROR: ES requerido el número de reporte");
				return respuesta;
			}

			try {
				final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
						"INFORMACION_SINIESTRO_DUA");

				nat.registerStoredProcedureParameter("IN_REPORTE", String.class, ParameterMode.IN);
				nat.registerStoredProcedureParameter("OUT_RESPUESTA", String.class, ParameterMode.OUT);
				nat.registerStoredProcedureParameter("OUT_CONCLUSION", String.class, ParameterMode.OUT);
				nat.registerStoredProcedureParameter("OUT_DU_CODIGO_RESPONSABILIDAD", String.class, ParameterMode.OUT);


				nat.setParameter("IN_REPORTE", reporte);
				nat.execute();

				respuesta.put("respuesta", (String)(nat.getOutputParameterValue("OUT_RESPUESTA"))); 
				respuesta.put("conclusion",(String)(nat.getOutputParameterValue("OUT_CONCLUSION")));
				respuesta.put("codigoResponsabilidad",(String)(nat.getOutputParameterValue("OUT_DU_CODIGO_RESPONSABILIDAD")));
				
	 

			} catch (final ClassCastException | RollbackException | DatabaseException | DataIntegrityViolationException e) {
				this.documentarExcepcionParaMetodo(e, "informacionFoliosDUA", reporte);
				respuesta.put("respuesta", "ERROR: "+e); 
			} catch (final PersistenceException | IllegalArgumentException | IndexOutOfBoundsException e) {
				this.documentarExcepcionParaMetodo(e, "informacionFoliosDUA", reporte);
				respuesta.put("respuesta", "ERROR: "+e); 
			}
			
			return respuesta;
		}



	@Override
	public String actualizarSiniestro(String reporte, String poliza, String siniestro) {
		String respuesta = null;
		if (reporte  == null) {
			return "ERROR: Es requerido el número de reporte.";
		}
		if (poliza  == null) {
			return "ERROR: Es requerido el número de poliza.";
		}
		if (siniestro  == null) {
			return "ERROR: Es requerido el número de siniestro.";
		}
		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"FORMATOS_ADD_SINIESTRO");

			nat.registerStoredProcedureParameter("IN_REPORTE", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_POLIZA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_SINIESTRO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("OUT_RESPUESTA", String.class, ParameterMode.OUT);


			nat.setParameter("IN_REPORTE", reporte);
			nat.setParameter("IN_POLIZA", poliza);
			nat.setParameter("IN_SINIESTRO", siniestro);
			nat.execute();

			respuesta = (String) nat.getOutputParameterValue("OUT_RESPUESTA"); 
		} catch (final ClassCastException | RollbackException | DatabaseException | DataIntegrityViolationException e) {
			this.documentarExcepcionParaMetodo(e, "informacionFoliosDUA", reporte);
			respuesta = "ERROR: "+e; 
		} catch (final PersistenceException | IllegalArgumentException | IndexOutOfBoundsException e) {
			this.documentarExcepcionParaMetodo(e, "informacionFoliosDUA", reporte);
			respuesta = "ERROR: "+e; 
		}
		return respuesta;
	}
		
	  

}
