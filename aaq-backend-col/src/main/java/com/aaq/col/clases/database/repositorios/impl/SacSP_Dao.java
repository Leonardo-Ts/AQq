package com.aaq.col.clases.database.repositorios.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.sisesac.SegundasAtencion;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSP2daAtencionCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPArriboCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPCierreCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPConfirmarGruaCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPCuentasEspecialesCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPDispositivoMovilVistoCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPExamenToxCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPFolioHospitalAmbulanciaCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPGestionCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPGestionRecuperosCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPMovilFolio2CallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPMovilFolioCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPSolicitarTicketCondCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPSolicitudAbogadoCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sac.SacSPTerminoCallableStatement;
import com.aaq.col.clases.database.repositorios.interfase.SacSP_DaoInterfase;
import com.aaq.col.clases.pojo.aaq.ExamenTEP;
import com.aaq.col.clases.sac.model.ConfirmarGruaSac;
import com.aaq.col.clases.sac.model.DatosArriboSac;
import com.aaq.col.clases.sac.model.DatosDispositivoMovilFolio;
import com.aaq.col.clases.sac.model.DatosFolioHospitalAmbulancia;
import com.aaq.col.clases.sac.model.DatosGestionRecuperoSac;
import com.aaq.col.clases.sac.model.DatosGestionSac;
import com.aaq.col.clases.sac.model.DatosGestionTerceroSac;
import com.aaq.col.clases.sac.model.DatosSolicitudAbogado;
import com.aaq.col.clases.sac.model.DatosTerminoSac;
import com.aaq.col.clases.webservices.wscabina.reporte.RequestArca;
import com.aaq.col.clases.webservices.wscabina.reporte.RequestPemex;
import com.aaq.col.clases.webservices.wscabina.siniestro.AperturaEstimacion;
import com.aaq.col.clases.webservices.wscabina.siniestro.AperturaReserva;
import com.aaq.col.clases.xml.webservices.JMWSDatosCFE;
import com.aaq.col.clases.xml.webservices.JMWSDatosCapufe;
import com.aaq.col.clases.xml.webservices.JMWSDatosCartaCob;


@Repository("SacSPDao")
public class SacSP_Dao implements SacSP_DaoInterfase {

	public Log log = LogFactory.getLog(SacSP_Dao.class);

	@Autowired
	private JdbcTemplate sacJdbcTemplate;

	 @Override
		public String arriboSac(DatosArriboSac entradas) {

			Map<String, Object> entry = new HashMap<String, Object>();
			entry.put("fechaArribo", entradas.getFechaArribo());
			entry.put("horaArribo", entradas.getHoraArribo());
			entry.put("placas", entradas.getPlacas());
			entry.put("serie", entradas.getSerie());
			entry.put("reporte", entradas.getReporte());
			entry.put("quienLlego", entradas.getQuienLlegoPrimero());
			entry.put("tramoCar", entradas.getTramoCarretero());
			entry.put("Latitud", entradas.getLatitud());
			entry.put("Longitud", entradas.getLongitud());
			entry.put("usuario", entradas.getUsuario());
			entry.put("proximidad", entradas.getProximidad());
			entry.put("ubicacionCorrecta", entradas.getUbicacionCorrecta());

			ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR)); //UbicacionCorrecta
			sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

			Map<String, Object> result = sacJdbcTemplate.call(new SacSPArriboCallableStatement(entry), sqlParams);

			return result.get("salida").toString();
		}

	@Override
	public Map<String, String>  terminoSac(DatosTerminoSac entradas, Terminal term) {
		// Enviar S o N si tiene datos de Danios
		String danosInsp;
		if (StringUtils.isEmpty(entradas.getDescripcionDanosPrexistentes())) {
			danosInsp = "S";
		} else {
			danosInsp = "N";
		}

		Map<String, Object> entry = new HashMap<>();
		entry.put("reporte", entradas.getReporte());
		entry.put("fechaTermino", entradas.getFechaTermino());
		entry.put("horaTermino", entradas.getHoraTermino());
		entry.put("correo", entradas.getAseguradoCorreo());
		entry.put("observaciones", entradas.getObservaciones());
		entry.put("preaveriguacion", entradas.getAveriguacionPrevia());
		entry.put("averiguacion", entradas.getAveriguacion());
		entry.put("entidad", entradas.getEntidad());
		entry.put("municipio", entradas.getMunicipio());
		entry.put("numeroAveriguacion", entradas.getNumAveriguacion());
		entry.put("localizadoEn", entradas.getRoboLocalizadoEn());
		entry.put("dependencia", entradas.getRoboDependencia());
		entry.put("localizado", entradas.getRoboLocalizado());
		entry.put("fechaRobo", entradas.getRoboFecha());
		entry.put("telRobo", entradas.getRoboTel());
		entry.put("Latitud", entradas.getLatitud());
		entry.put("Longitud", entradas.getLongitud());
		entry.put("placasRobo", entradas.getPlacas());
		entry.put("serieInsp", entradas.getSerieAsegurado());
		entry.put("danosInsp", danosInsp);
		entry.put("descInsp", entradas.getDescripcionDanosPrexistentes());
		entry.put("roboColor", (entradas.getColorAsegurado() == 0 ? "" : String.valueOf(entradas.getColorAsegurado())));
		entry.put("noMotor", entradas.getMotorAsegurado());
		entry.put("codigoResponsabilidad", entradas.getCodigoResponsabilidad());
		entry.put("estadoUnidad", entradas.getEstadoUnidad());
		entry.put("motivoNoInsp", entradas.getMotivoNoInsp());
		entry.put("claveAccidente", entradas.getCvAccidente()); // Clave Accidente
		//Poliza Turista
		entry.put("polizaTurista", entradas.getPolizaTurista());
		entry.put("numeroPolizaTurista", entradas.getNumeroPolizaTurista());
		entry.put("incisoPolizaTurista", entradas.getIncisoPolizaTurista());
		entry.put("codigoResponsabilidadDUA", entradas.getCodigoResponsabilidadDUA());
		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
            sqlParams.add(new SqlParameter(Types.VARCHAR));
    		sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR)); // Clave Accidente
			sqlParams.add(new SqlParameter(Types.VARCHAR)); // Poliza Turista
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR)); // Codigo Responsabilidad DUA
			sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));
			sqlParams.add(new SqlOutParameter("reporteEncolado", Types.VARCHAR));

		
            entry.put("terminal", term);
    		
    		Map<String, String> resultado = new HashMap<String, String>();
    		Map<String, Object> result = sacJdbcTemplate.call(new SacSPTerminoCallableStatement(entry), sqlParams);
    		
    		resultado.put("salida", result.get("salida").toString());
    		if (result.get("reporteEncolado") != null) {
    			try {
    				resultado.put("reporteEncolado",  result.get("reporteEncolado").toString());
    			} catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException e) {
    			}
    		}
    		
    		return  resultado;
	}

	@Override
	public Map<String, String> gestionSac(DatosGestionSac entradas, Terminal term) {

		// Datos de Tercero
		final StringBuilder dmMarca = new StringBuilder();
		final StringBuilder dmTipoVeh = new StringBuilder();
		final StringBuilder dmModeloTer = new StringBuilder();
		final StringBuilder dmPlacas = new StringBuilder();
		final StringBuilder dmColor = new StringBuilder();
		final StringBuilder dmClaveVeh = new StringBuilder();
		final StringBuilder dmTipoTerc = new StringBuilder();
		final StringBuilder dmDescTerc = new StringBuilder();
		final StringBuilder dmCondTerc = new StringBuilder();
		final StringBuilder dmSerie = new StringBuilder();
		final StringBuilder dmTelefTer = new StringBuilder();
		final StringBuilder dmNombreTer = new StringBuilder();
		final StringBuilder dmCorreoTer = new StringBuilder();
		final StringBuilder dmClaseVeh = new StringBuilder();
		final StringBuilder dmIdObjeto = new StringBuilder();
		final StringBuilder dmNombreAjustadorTercero = new StringBuilder();
		final StringBuilder dmPolizaTercero = new StringBuilder();
		final StringBuilder dmIncisoPolizaTercero = new StringBuilder();


		// Datos de Recupero
		final StringBuilder dmIdRecuperacion = new StringBuilder();
		final StringBuilder dmIdInvr = new StringBuilder();
		final StringBuilder dmCodAseguradora = new StringBuilder();
		final StringBuilder dmNumSiniestro = new StringBuilder();
		final StringBuilder dmNumFolio = new StringBuilder();
		final StringBuilder dmDeducible = new StringBuilder();
		final StringBuilder dmEfectivo = new StringBuilder();
		final StringBuilder dmRecibo = new StringBuilder();

		String _suffix = "";
		int count;
		if (entradas.getTerceros().size() > 1) {
			count = 1;
			for (DatosGestionTerceroSac tercero : entradas.getTerceros()) {
				_suffix = (count != entradas.getTerceros().size()) ? "|" : "";
				dmMarca.append(tercero.getMarcaVehiculo() + _suffix);
				dmTipoVeh.append(tercero.getTipoVehiculo() + _suffix);
				dmModeloTer.append(tercero.getModeloVehiculo() + _suffix);
				dmPlacas.append(tercero.getPlacasVehiculo() + _suffix);
				dmColor.append(tercero.getColorVehiculo() + _suffix);
				dmClaveVeh.append(tercero.getNumero() + _suffix);
				dmTipoTerc.append(tercero.getTipoTercero() + _suffix);
				dmDescTerc.append(tercero.getDescripcionTercero() + _suffix);
				dmCondTerc.append(tercero.getConductorTercero() + _suffix);
				dmSerie.append(tercero.getSerieTercero() + _suffix);
				dmTelefTer.append(tercero.getTelefonoTercero() + _suffix);
				dmNombreTer.append(tercero.getNombreTercero() + _suffix);
				dmCorreoTer.append(tercero.getCorreoTercero() + _suffix);
				dmClaseVeh.append(tercero.getClaveVehiculo() + _suffix);
				dmIdObjeto.append(tercero.getIdObjeto() + _suffix);
				dmNombreAjustadorTercero.append(tercero.getNombreAjustadorTercero() + _suffix);
				dmPolizaTercero.append(tercero.getPolizaTercero() + _suffix);
				dmIncisoPolizaTercero.append(tercero.getIncisoPolizaTercero() + _suffix);
				count++;
			}
		} else {
			for (DatosGestionTerceroSac tercero : entradas.getTerceros()) {
				dmMarca.append(tercero.getMarcaVehiculo());
				dmTipoVeh.append(tercero.getTipoVehiculo());
				dmModeloTer.append(tercero.getModeloVehiculo());
				dmPlacas.append(tercero.getPlacasVehiculo());
				dmColor.append(tercero.getColorVehiculo());
				dmClaveVeh.append(tercero.getNumero());
				dmTipoTerc.append(tercero.getTipoTercero());
				dmDescTerc.append(tercero.getDescripcionTercero());
				dmCondTerc.append(tercero.getConductorTercero());
				dmSerie.append(tercero.getSerieTercero());
				dmTelefTer.append(tercero.getTelefonoTercero());
				dmNombreTer.append(tercero.getNombreTercero());
				dmCorreoTer.append(tercero.getCorreoTercero());
				dmClaseVeh.append(tercero.getClaveVehiculo());
				dmIdObjeto.append(tercero.getIdObjeto());
				dmNombreAjustadorTercero.append(tercero.getNombreAjustadorTercero() + _suffix);
				dmPolizaTercero.append(tercero.getPolizaTercero() + _suffix);
				dmIncisoPolizaTercero.append(tercero.getIncisoPolizaTercero() + _suffix);
			}
		}

		if (entradas.getRecuperos().size() > 1) {
			count = 1;
			for (DatosGestionRecuperoSac recupero : entradas.getRecuperos()) {
				_suffix = (count != entradas.getRecuperos().size()) ? "|" : "";
				dmIdRecuperacion.append(recupero.getTipoRecupero() + _suffix);
				dmIdInvr.append(recupero.getConsecutivoTercero() + _suffix);
				dmCodAseguradora.append(recupero.getCiaAseguradora() + _suffix);
				dmNumSiniestro.append(recupero.getNumeroSiniestro() + _suffix);
				dmNumFolio.append(recupero.getFolioVale() + _suffix);
				dmDeducible.append("" + _suffix);
				dmEfectivo.append(recupero.getMonto() + _suffix);
				dmRecibo.append(recupero.getDescripcionDeMonto() + _suffix);

				count++;
			}
		} else if (entradas.getRecuperos().size() == 1) {
			for (DatosGestionRecuperoSac recupero : entradas.getRecuperos()) {
				dmIdRecuperacion.append(recupero.getTipoRecupero());
				dmIdInvr.append(recupero.getConsecutivoTercero());
				dmCodAseguradora.append(recupero.getCiaAseguradora());
				dmNumSiniestro.append(recupero.getNumeroSiniestro());
				dmNumFolio.append(recupero.getFolioVale());
				dmDeducible.append("");
				dmEfectivo.append(recupero.getMonto());
				dmRecibo.append(recupero.getDescripcionDeMonto());
			}
		}

		// Terceros
		Map<String, Object> entry = new HashMap<>();

		// Recuperos
		Map<String, Object> entryRecupero = new HashMap<>();

		/*-------------------------------------------
		 *-------------------------------------------
		 *-----------------TERCEROS------------------
		 *-------------------------------------------
		 *-------------------------------------------
		 */

		// Reporte
		entry.put("dmReporte", entradas.getReporte());

		// Datos del Asegurado
		entry.put("dmEdadAseg", entradas.getEdad());
		entry.put("dmSexoAseg", entradas.getSexo());
		entry.put("dmNombreAseg", entradas.getNombreAsegurado());
		entry.put("dmCorreoAseg", entradas.getCorreoAsegurado());
		entry.put("dmTelefonoAseg", entradas.getTelefonoAsegurado());
		//*** Folio de AMIS para SAC
		entry.put("dmFolioAMIS", entradas.getFolioAMIS());
		

		// Datos Terceros
		entry.put("dmMarca", Objects.toString(dmMarca, ""));
		entry.put("dmTipoVeh", Objects.toString(dmTipoVeh, ""));
		entry.put("dmModeloTer", Objects.toString(dmModeloTer, ""));
		entry.put("dmPlacas", Objects.toString(dmPlacas, ""));
		entry.put("dmColor", Objects.toString(dmColor, ""));
		entry.put("dmClaveVeh", Objects.toString(dmClaveVeh, ""));
		entry.put("dmTipoTerc", Objects.toString(dmTipoTerc, ""));
		entry.put("dmDescTerc", Objects.toString(dmDescTerc, ""));
		entry.put("dmCondTerc", Objects.toString(dmCondTerc, ""));
		entry.put("dmSerie", Objects.toString(dmSerie, ""));
		entry.put("dmTelefTer", Objects.toString(dmTelefTer, ""));
		entry.put("dmNombreTer", Objects.toString(dmNombreTer, ""));
		entry.put("dmCorreoTer", Objects.toString(dmCorreoTer, ""));
		entry.put("dmClaseVeh", Objects.toString(dmClaseVeh, ""));

		// Adicionales
		entry.put("dmUsuario", term.getNumeroproveedor());
		entry.put("dmProveedor", "");

		//Se añade idObjeto
		entry.put("dmIdObjeto", Objects.toString(dmIdObjeto, ""));
		
		// Ajustador Terceros
		entry.put("dmNombreAjustadorTercero", Objects.toString(dmNombreAjustadorTercero, ""));
		entry.put("dmPolizaTercero", Objects.toString(dmPolizaTercero, ""));
		entry.put("dmIncisoPolizaTercero", Objects.toString(dmIncisoPolizaTercero, ""));
		
		
		/*-------------------------------------------
		 *-------------------------------------------
		 *-----------------RECUPEROS------------------
		 *-------------------------------------------
		 *-------------------------------------------
		 */
		// Reporte
		entryRecupero.put("dmReporte", entradas.getReporte());
		entryRecupero.put("dmIdRecuperacion", Objects.toString(dmIdRecuperacion, ""));
		entryRecupero.put("dmIdInvr", Objects.toString(dmIdInvr, ""));
		entryRecupero.put("dmIdProveedor", Objects.toString(dmCodAseguradora, ""));
		entryRecupero.put("dmNumSiniestro", Objects.toString(dmNumSiniestro, ""));
		entryRecupero.put("dmNumFolio", Objects.toString(dmNumFolio, ""));
		entryRecupero.put("dmDeducible", Objects.toString(dmDeducible, ""));
		entryRecupero.put("dmEfectivo", Objects.toString(dmEfectivo, ""));
		entryRecupero.put("dmRecibo", Objects.toString(dmRecibo, ""));
		entryRecupero.put("dmUsuario", term.getNumeroproveedor());

		/*-------------------------------------------
		 *-------------------------------------------
		 *-----------------TERCEROS------------------
		 *-------------------------------------------
		 *-------------------------------------------
		 */

		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // Campo id Objeto
		sqlParams.add(new SqlParameter(Types.VARCHAR)); //Folio AMIS
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // Nombre Ajustador Tercerp
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // Poliza Tercero
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // Inciso Poliza Tercero
		sqlParams.add(new SqlOutParameter("folio", Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

		/*-------------------------------------------
		 *-------------------------------------------
		 *-----------------RECUPEROS------------------
		 *-------------------------------------------
		 *-------------------------------------------
		 */

		ArrayList<SqlParameter> sqlParamsRecupero = new ArrayList<SqlParameter>();
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlParameter(Types.VARCHAR));
		sqlParamsRecupero.add(new SqlOutParameter("salida", Types.VARCHAR));

		Map<String, String> resultado = new HashMap<String, String>();
		// Terceros
		Map<String, Object> result;
		entry.put("terminal", term);
		result = sacJdbcTemplate.call(new SacSPGestionCallableStatement(entry), sqlParams);
		resultado.put("TERCEROS", result.get("salida").toString());

		// Recuperos
		Map<String, Object> resultRecupero;
		if (entradas.getRecuperos().size() > 0) {
			entryRecupero.put("terminal", term);
			resultRecupero = sacJdbcTemplate.call(new SacSPGestionRecuperosCallableStatement(entryRecupero), sqlParamsRecupero);
			resultado.put("RECUPEROS", resultRecupero.get("salida").toString());
		}

		return resultado;
	}

	@Override
	public Map<String, Object> dispositivoMovilFolio(DatosDispositivoMovilFolio entradas, Terminal term) {

		Map<String, Object> entry = new HashMap<>();
		entry.put("dmProveedor", entradas.getNumProveedor());
		entry.put("dmTipoProveedor", entradas.getTipoProveedor());
		entry.put("dmRamo", entradas.getRamo());
		entry.put("dmEjercicio", entradas.getEjercicio());
		entry.put("dmReporte", entradas.getNumReporte());
		entry.put("dmTencionA", entradas.getAtencion());
		entry.put("dmUsuario", entradas.getNumProveedor());
		entry.put("dmVFolio", entradas.getFolioVale());
		entry.put("dmCodigoME", entradas.getCodigoME());
		entry.put("dmCobertura", entradas.getCobertura());
		entry.put("dmMontoMedico", entradas.getMontoMedico());
		entry.put("dmPolizaTerceroQualitas", entradas.getPolizaTerceroQualitas());
		entry.put("dmIncisoTerceroQualitas", entradas.getIncisoTerceroQualitas());
		entry.put("dmEndosoTerceroQualitas", entradas.getEndosoTerceroQualitas());
		entry.put("dmCarrilExpress", entradas.getCarrilExpress());
		entry.put("dmIdObjeto", entradas.getIdObjeto());
		entry.put("dmDanioMenor", entradas.getDanioMenor());
		entry.put("dmPtEvidente", entradas.getPtEvidente());
		entry.put("dmAbandonoEvidente", entradas.getAbadonoEvidente());

		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // danio menor
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // PT Evidente
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // Abandono Evidente
		sqlParams.add(new SqlOutParameter("folio", Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));		
		

		entry.put("terminal", term);
		Map<String, Object> result = sacJdbcTemplate.call(new SacSPMovilFolioCallableStatement(entry), sqlParams);

		return result;
	}

	@Override
	public Map<String, Object> dispositivoMovilFolioHospitalAmbulancia(DatosFolioHospitalAmbulancia entradas, String claveProveedor, Terminal term, Boolean persona) {

		Map<String, Object> entry = new HashMap<>();
		entry.put("reporteSac", entradas.getReporte());

		entry.put("edadAseg", entradas.getMovilDatosAsegurado().getEdad());
		entry.put("sexoAseg", entradas.getMovilDatosAsegurado().getSexo());
		entry.put("nombreAseg", entradas.getMovilDatosAsegurado().getAseguradoNombre());
		entry.put("correoAseg", entradas.getMovilDatosAsegurado().getAseguradoCorreo());
		entry.put("telefonoAseg", entradas.getMovilDatosAsegurado().getAseguradoTelefono());

		entry.put("edadTercero", entradas.getEdadTercero());
		entry.put("numeroTercero", entradas.getAtencion());
		
		if (persona) {
			entry.put("tipoTercero", "P");
		} else {
			entry.put("tipoTercero", entradas.getTipoTercero());
		}
//		entry.put("tipoTercero", entradas.getTipoTercero());
		
		entry.put("sexoTercero", entradas.getSexoTercero());
		entry.put("lesionadoTercero", entradas.getLesionadoTercero().getNombreLesionado());
		entry.put("telefonoTercero", entradas.getTelefonoTercero());
		entry.put("atencionA", entradas.getAtencion());
		entry.put("correoTercero", entradas.getCorreoTercero());

		entry.put("codigoAjustador", term.getNumeroproveedor());
		entry.put("claveProveedor", claveProveedor);
		
		entry.put("cobertura", entradas.getCobertura());
		entry.put("montoMedico", entradas.getMontoMedico());
		entry.put("idObjeto", entradas.getIdObjeto());

		//*** Folio de AMIS para SAC
		entry.put("dmFolioAMIS", entradas.getFolioAMIS());
		// Ajustador Terceros
		entry.put("dmNombreAjustadorTercero", entradas.getNombreAjustadorTercero());
		entry.put("dmPolizaTercero", entradas.getPolizaTercero());
		entry.put("dmIncisoPolizaTercero", entradas.getIncisoPolizaTercero());


		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR)); //idObjeto
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // Folio AMIS
		sqlParams.add(new SqlParameter(Types.VARCHAR)); //nombreAjustadorTercero
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // polizaTercero
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // incisoPolizaTercero
		sqlParams.add(new SqlOutParameter("folio", Types.VARCHAR)); 
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

		entry.put("terminal", term);
		Map<String, Object> result = sacJdbcTemplate.call(new SacSPFolioHospitalAmbulanciaCallableStatement(entry), sqlParams);

		return result;
	}

	@Override
	public Map<String, Object> insertarCoberturaEstimacion(AperturaEstimacion entradas, String numeroSiniestro) {
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("dmReporte", entradas.getReporte());

		final StringBuilder dmCobertura = new StringBuilder();
		final StringBuilder dmMonto = new StringBuilder();
		final StringBuilder dmCoberturaFlexible = new StringBuilder();

		int count;
		String _suffix = "";

		if (entradas.getEstimaciones().size() > 1) {
			count = 1;
			for (AperturaReserva cobertura : entradas.getEstimaciones()) {
				_suffix = (count != entradas.getEstimaciones().size()) ? "|" : "";
				dmCobertura.append(cobertura.getCveCobertura() + _suffix);
				dmMonto.append(cobertura.getMontoEstimacion() + _suffix);
				dmCoberturaFlexible.append(cobertura.getCveCoberturaFlexible() +_suffix);
				count++;
			}
		} else if (entradas.getEstimaciones().size() == 1) {
			for (AperturaReserva cobertura : entradas.getEstimaciones()) {
				dmCobertura.append(cobertura.getCveCobertura());
				dmMonto.append(cobertura.getMontoEstimacion());
				dmCoberturaFlexible.append(cobertura.getCveCoberturaFlexible() +_suffix);

			}
		}

		entry.put("dmSiniestro", Objects.toString(numeroSiniestro, ""));
		entry.put("dmCobertura", Objects.toString(dmCobertura, ""));
		entry.put("dmMonto", Objects.toString(dmMonto, ""));
		entry.put("dmCoberturaFlexible", Objects.toString(dmCoberturaFlexible, ""));


		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

		Map<String, Object> result = sacJdbcTemplate.call(new SacSPCierreCallableStatement(entry), sqlParams);

		return result;
	}

	@Override
	public String insertarCuentasEspecialesArca(RequestArca entradas, String tipo, String usuario, String password) {
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("dmReporte", entradas.getReporte());
		entry.put("dmType", tipo);
		entry.put("dm1", entradas.getDescripcionHechos());
		if(tipo.equals("HEINEKEN")) {
			entry.put("dm2", entradas.getFallecidos());
			entry.put("dm3",Integer.toString(entradas.getNumFallecidos()));
		} else {
		entry.put("dm2", entradas.getExisteDPA());
		entry.put("dm3", entradas.getLesionados().getLesionados()); 
			}
		entry.put("dm4", entradas.getPresenciaMedios());
		entry.put("dm5", Objects.toString(entradas.getMontoAproxDanos(), ""));
		entry.put("dm6", Objects.toString(entradas.getLesionados().getNumero(), ""));
		entry.put("dm7", entradas.getObra());
		entry.put("dm8", password);
		entry.put("dm9", entradas.getReporte());
		entry.put("dm10", entradas.getTurnadoLegal());
		entry.put("dm11", usuario);
		entry.put("dm12", Objects.toString(entradas.getVehiculosImplicados(), ""));
		entry.put("dm13", entradas.getFallecidos());
		entry.put("dm14", Integer.toString(entradas.getNumFallecidos()));
		
		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

		Map<String, Object> result = sacJdbcTemplate.call(new SacSPCuentasEspecialesCallableStatement(entry), sqlParams);

		String resultado = "";

		resultado = result.get("salida").toString();

		return resultado;
	}

	@Override
	public String insertarCuentasEspecialesCapufe(JMWSDatosCapufe entradas, String tipo, String usuario, String password) {
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("dmReporte", entradas.getReporte());
		entry.put("dmType", tipo);
		entry.put("dm1", entradas.getCausaAccidente());
		entry.put("dm2", entradas.getComoOcurrio());
		entry.put("dm3", entradas.getCuerpo());
		entry.put("dm4", entradas.getDanos());
		entry.put("dm5", entradas.getNumKm());
		entry.put("dm6", password);
		entry.put("dm7", entradas.getResponsable());
		entry.put("dm8", usuario);

		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

		Map<String, Object> result = sacJdbcTemplate.call(new SacSPCuentasEspecialesCallableStatement(entry), sqlParams);

		String resultado = "";

		resultado = result.get("salida").toString();

		return resultado;
	}

	@Override
	public String insertarCuentasEspecialesCFE(JMWSDatosCFE entradas, String tipo, String usuario, String password) {
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("dmReporte", entradas.getReporte());
		entry.put("dmType", tipo);
		entry.put("dm1", entradas.getMarca());
		entry.put("dm2", entradas.getModelo());
		entry.put("dm3", entradas.getNumEconomico());
		entry.put("dm4", entradas.getNumEmpleado());
		entry.put("dm5", entradas.getOrganismo());
		entry.put("dm6", password);
		entry.put("dm7", entradas.getPlacas());
		entry.put("dm8", entradas.getSerie());
		entry.put("dm9", entradas.getTipo());
		entry.put("dm10", usuario);

		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

		Map<String, Object> result = sacJdbcTemplate.call(new SacSPCuentasEspecialesCallableStatement(entry), sqlParams);

		String resultado = "";

		resultado = result.get("salida").toString();

		return resultado;
	}

	@Override
	public String insertarCuentasEspecialesPemex(RequestPemex entradas, String tipo, String usuario, String password) {
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("dmReporte", entradas.getReporte());
		entry.put("dmType", tipo);
		entry.put("dm1", entradas.getClaseVehiculo());
		entry.put("dm2", entradas.getConductor());
		entry.put("dm3", entradas.getFicha());
		entry.put("dm4", entradas.getMarca());
		entry.put("dm5", entradas.getModelo());
		entry.put("dm6", entradas.getInventario());
		entry.put("dm7", entradas.getSerie());
//		entry.put("dm8", Objects.toString(entradas.getOrganismo(), ""));
		entry.put("dm8", entradas.getOrganismo());
		entry.put("dm9", password);
		entry.put("dm10", entradas.getPlaca());
		entry.put("dm11", entradas.getReporte());
		entry.put("dm12", entradas.getSerie());
		entry.put("dm13", entradas.getTipo());
		entry.put("dm14", entradas.getTipoUnidad());
		entry.put("dm15", usuario);

		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

		Map<String, Object> result = sacJdbcTemplate.call(new SacSPCuentasEspecialesCallableStatement(entry), sqlParams);

		String resultado = "";

		resultado = result.get("salida").toString();

		return resultado;
	}

	@Override
	public String dispositivoMovilVisto(String numeroReporte) {
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("numeroReporte", numeroReporte);

		ArrayList<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
		sqlParameters.add(new SqlParameter(Types.VARCHAR));
		sqlParameters.add(new SqlOutParameter("salida", Types.VARCHAR));

		Map<String, Object> result = sacJdbcTemplate.call(new SacSPDispositivoMovilVistoCallableStatement(entry), sqlParameters);

		String resultado = result.get("salida").toString();

		return resultado;
	}

	@Override
	public Map<String, Object> solicitudAbogado(DatosSolicitudAbogado entradas, Terminal term) {
		String parametrosSolicitud = entradas.getMotivoAsignacion() + "|" + entradas.getApreciacionResponsabilidad()
				+ "|" + entradas.getIdEntidad() + "|" + entradas.getLugarPresentarse() + "|"
				+ (entradas.getVehiculoDetenido() == true ? "SI" : "NO") + "|" + entradas.getNumLesa() + "|" + entradas.getNumHoma() + "|"
				+ entradas.getNumLest() + "|" + entradas.getNumHomt() + "|" + (entradas.getConductorDetenido() == true ? "SI" : "NO");

		Map<String, Object> entry = new HashMap<>();
		entry.put("dmReporte", entradas.getNumeroReporte());
		entry.put("dmCodigoAjustador", entradas.getCodigoAjustador());
		entry.put("dmParametrosSolicitud", parametrosSolicitud);
		entry.put("dmPerdidaTotal", entradas.getPt());

		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));
		
		entry.put("terminal", term);

		Map<String, Object> result = sacJdbcTemplate.call(new SacSPSolicitudAbogadoCallableStatement(entry), sqlParams);


		return result;
	}
	

	//Coberturas Especiales
	@Override
	public String insertarCuentasEspecialesCartaCob(JMWSDatosCartaCob  entradas, String usuario, String password) {
		
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("dmReporte", entradas.getReporte());
		entry.put("dmType", entradas.getTipoPoliza()); //DIDI, ALLIANZ o SEPOMEX
		entry.put("dm1", entradas.getMarca());
		entry.put("dm2", entradas.getTipoVehiculo());
		entry.put("dm3", entradas.getModelo());
		entry.put("dm4", entradas.getPlacas());
		entry.put("dm5", entradas.getSerie());
		entry.put("dm6", entradas.getColor());
		entry.put("dm7", entradas.getIdDriver());
		entry.put("dm8", entradas.getNumCelular());
		
		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

		Map<String, Object> result = sacJdbcTemplate.call(new SacSPCuentasEspecialesCallableStatement(entry), sqlParams);

		String resultado = "";

		resultado = result.get("salida").toString();

		return resultado;
	}

	@Override
	public String insertarIdealease(String licencia, String reporte, String tipo) {
			Map<String, String> entry = new HashMap<String, String>();
			entry.put("dmReporte", reporte);
			entry.put("dmType", tipo);
			entry.put("dm1", licencia);

			
			ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

			Map<String, Object> result = sacJdbcTemplate.call(new SacSPCuentasEspecialesCallableStatement(entry), sqlParams);

			String resultado = "";

			resultado = result.get("salida").toString();

			return resultado;
		
	}
	
	@Override
	public String confirmarGrua(ConfirmarGruaSac entrada) {
		String resultado = "";
		
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("reporte", entrada.getReporte());	
		entry.put("involucrado", entrada.getInvolucrado());
		entry.put("proveedor", entrada.getProveedor());
		entry.put("status", entrada.getStatus());
		entry.put("comentario", entrada.getComentario());
		
		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));
		
		Map<String, Object> result = sacJdbcTemplate.call(new SacSPConfirmarGruaCallableStatement(entry), sqlParams);
		
		resultado = result.get("salida").toString();
		return resultado;
	}
	

	@Override
	public String segundaAtencion(SegundasAtencion entrada) {
//		Gson json = new Gson();
			Map<String, String> entry = new HashMap<String, String>();
			entry.put("dmReporte", entrada.getReporte());
			entry.put("dmAjustador",entrada.getAjustador());
			entry.put("dmUsuarioAlta", entrada.getUsuarioAlta());
			entry.put("dmObservacion", entrada.getObservacion());
			entry.put("dmEdoPob", entrada.getEdoPob());
			entry.put("dmColonia", entrada.getColonia());
			entry.put("dmCalle", entrada.getCalle());
			entry.put("dmEntre", entrada.getEntre());
			entry.put("dmRefer", entrada.getRefer());
			
			ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));

			Map<String, Object> result = sacJdbcTemplate.call(new SacSP2daAtencionCallableStatement(entry), sqlParams);

			String resultado = "";

			resultado = result.get("salida").toString();
			return resultado;
		
	}
	
	@Override
	public String solicitarTicketCondi(Terminal terminal, String reporte, String claveCondicion)  {
		Map<String, Object> result = null;
		String resultado = null;
		try {
			Map<String, Object> entry = new HashMap<String, Object>();
			entry.put("dmReporte", reporte);
			entry.put("dmClaveCondicion", claveCondicion);
			entry.put("terminal", terminal);
	
			ArrayList<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlOutParameter("salida", Types.VARCHAR));
			
			result = sacJdbcTemplate.call(new SacSPSolicitarTicketCondCallableStatement(entry), sqlParameters);
			if (result != null) {
				 resultado = result.get("salida").toString();
				return resultado;
			}
		} catch (ClassCastException | IllegalArgumentException | RollbackException e) { 
		}
		return resultado;
	}
	
	@Override
	public String examenToxicologicoSAC(Terminal terminal, ExamenTEP entrada)  {
		Map<String, Object> result = null;
		String resultado = null;
		String tercero = "";
		try {
			Map<String, Object> entry = new HashMap<String, Object>();
			entry.put("DMREPORTE", entrada.getNumeroReporte());
			entry.put("DMUSER", entrada.getUsuario());
			entry.put("DMHORA_REC", entrada.getHoraRecepcion());
			entry.put("DMSIPAC", entrada.getSipac());
			if (entrada.getTercero() != null) {
				if (entrada.getTercero().size() > 0) {
					for (int i = 0; i < entrada.getTercero().size(); i++) {
						tercero = tercero+ entrada.getTercero().get(i).getConSeguro()+"||"+entrada.getTercero().get(i).getCobertura()+",";
					}
				}
			}
			entry.put("DMTERCERO", StringUtils.removeEnd(tercero, ","));
			entry.put("DMEXA_TOX", entrada.getExamenTox());
			entry.put("DMEXA_TOX_CON", entrada.getExamenToxCon());
			entry.put("DMEXA_TOX_BEB", entrada.getExamenToxBeb());
			entry.put("DMEXA_TOX_DRO", entrada.getExamenToxDro());
			entry.put("DMEXA_TOX_AUT", entrada.getExamenToxAut());
			entry.put("DMEXA_TOX_MOT", entrada.getExamenToxMot());
			entry.put("DMQPRIMERO", entrada.getArriboPrimero());
			entry.put("terminal", terminal);
	
			ArrayList<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR));
			sqlParameters.add(new SqlParameter(Types.VARCHAR)); // Quien llego primero
			sqlParameters.add(new SqlOutParameter("salida", Types.VARCHAR));
			
			
			result = sacJdbcTemplate.call(new SacSPExamenToxCallableStatement(entry), sqlParameters);
			if (result != null) {
				 resultado = result.get("salida").toString();
				return resultado;
			}
		} catch (IndexOutOfBoundsException | ClassCastException  e) {
			return "ERROR: "+e.getMessage();
		}catch (CannotGetJdbcConnectionException | DataIntegrityViolationException | 
				NoResultException| RollbackException ex) {
			return  "ERROR: "+ex.getMessage();
		} catch (PersistenceException e) {
			return  "ERROR: "+e.getMessage();
		}
		return resultado;
	}
	@Override
	public Map<String, Object> dispositivoMovilFolio2(DatosDispositivoMovilFolio entradas) {

		Map<String, Object> entry = new HashMap<>();
		entry.put("dmProveedor", entradas.getNumProveedor());
		entry.put("dmTipoProveedor", entradas.getTipoProveedor());
		entry.put("dmRamo", entradas.getRamo());
		entry.put("dmEjercicio", entradas.getEjercicio());
		entry.put("dmReporte", entradas.getNumReporte());
		entry.put("dmTencionA", entradas.getAtencion());
		entry.put("dmUsuario", entradas.getNumProveedor());
		entry.put("dmVFolio", entradas.getFolioVale());
		entry.put("dmCodigoME", entradas.getCodigoME());
		entry.put("dmCobertura", entradas.getCobertura());
		entry.put("dmMontoMedico", entradas.getMontoMedico());
		entry.put("dmPolizaTerceroQualitas", entradas.getPolizaTerceroQualitas());
		entry.put("dmIncisoTerceroQualitas", entradas.getIncisoTerceroQualitas());
		entry.put("dmEndosoTerceroQualitas", entradas.getEndosoTerceroQualitas());
		entry.put("dmCarrilExpress", entradas.getCarrilExpress());
		entry.put("dmIdObjeto", entradas.getIdObjeto());
		entry.put("dmDanioMenor", entradas.getDanioMenor());
		entry.put("dmPtEvidente", entradas.getPtEvidente());
		entry.put("dmAbandonoEvidente", entradas.getAbadonoEvidente());

		ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR));
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // danio menor
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // PT Evidente
		sqlParams.add(new SqlParameter(Types.VARCHAR)); // Abandono Evidente
		sqlParams.add(new SqlOutParameter("folio", Types.VARCHAR));
		sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));		
		Map<String, Object> result = sacJdbcTemplate.call(new SacSPMovilFolio2CallableStatement(entry), sqlParams);

		return result;
	}


}
