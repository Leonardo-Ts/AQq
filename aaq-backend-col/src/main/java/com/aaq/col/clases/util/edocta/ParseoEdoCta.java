package com.aaq.col.clases.util.edocta;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import com.aaq.col.clases.pojo.edocta.AdaptacionEdoCta;
import com.aaq.col.clases.pojo.edocta.AgenteEdoCta;
import com.aaq.col.clases.pojo.edocta.AseguradoEdoCta;
import com.aaq.col.clases.pojo.edocta.CoberturasEdoCta;
import com.aaq.col.clases.pojo.edocta.CondicionEspecialEdoCta;
import com.aaq.col.clases.pojo.edocta.EquipoEspecialEdoCta;
import com.aaq.col.clases.pojo.edocta.EstadoCuenta;
import com.aaq.col.clases.pojo.edocta.EstimacionEdoCta;
import com.aaq.col.clases.pojo.edocta.GeneralEdoCta;
import com.aaq.col.clases.pojo.edocta.PolizaEdoCta;
import com.aaq.col.clases.pojo.edocta.PolizaExtraEdoCta;
import com.aaq.col.clases.pojo.edocta.ReciboEdoCta;
import com.aaq.col.clases.pojo.edocta.ReporteEdoCta;
import com.aaq.col.clases.pojo.edocta.Serie6EdoCta;
import com.aaq.col.clases.pojo.edocta.SerieEdoCta;
import com.aaq.col.clases.pojo.edocta.SiniestroEdoCta;
import com.aaq.col.clases.pojo.edocta.VehiculoEdoCta;
import com.aaq.col.clases.siica.JMConstantes;

import asjava.uniclientlibs.UniDynArray;

public class ParseoEdoCta {

	private final Log4JLogger loggerSISE = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.sise");
		
	public EstadoCuenta parseData(String input, String poliza){
			EstadoCuenta estadoCuenta = new EstadoCuenta();
			String data[] = input.split("\\"+JMConstantes.CHAR_PARSE1);
			if(data.length < 163){
				this.loggerSISE.error("Inconcistencia de datos: la cadena de respuesta tiene menos de 163 registros. ["+poliza+"]");
				this.loggerSISE.info("La póliza ["+poliza+"] no existe.");
				return null;
			}
			// Se obtienen los datos generales
			GeneralEdoCta general = new GeneralEdoCta();
			try  {
			general.setPoliza(data[0].trim());
			general.setInciso(data[1].trim());
			general.setEndoso(data[22].trim());
			general.setAsegurado(data[5].trim());
			general.setStatus(data[17].trim() + " - " + data[143].trim());
			general.setTipoStatus(data[143].trim().trim());
			general.setRiesgo(data[30].trim());
			general.setVigencia(data[9] + " al " + data[10]);
			general.setFechaInicioVigencia(data[9].trim());
			general.setFechaFinVigencia(data[10]);
			general.setPlazo1Recibo(data[63]);
			general.setPolrenovada(data[61]);
			general.setRenuevaa(data[62]);
			general.setCobertura(data[11]);
			general.setStatusCorto(data[143].trim());
			general.setStatusLargo(data[17].trim());
			general.setProveedorAv(data[158].trim());
			} catch (ClassCastException | IllegalAccessError|IllegalArgumentException | IndexOutOfBoundsException | NoClassDefFoundError e) {
				this.loggerSISE.error("Exception => parseData.GeneralEdoCta EdoCta ["+poliza+"]",e);
			}
			estadoCuenta.setGeneral(general);		
			
			// Datos del asegurado
			AseguradoEdoCta asegurado = new AseguradoEdoCta();
			try  {
			if (data[4] != null && (StringUtils.isNotBlank(data[4]))) {
			asegurado.setClave(data[4].trim());
			}
			if (data[5] != null && (StringUtils.isNotBlank(data[5]))) {
			asegurado.setNombre(data[5].trim());
			}
			if (data[48] != null && (StringUtils.isNotBlank(data[48]))) {
			asegurado.setDireccion(data[48].trim());
			}
			if (data[60] != null && (StringUtils.isNotBlank(data[60]))) {
			asegurado.setTelefono(data[60].trim());
			}
			} catch (ClassCastException | IllegalAccessError|IllegalArgumentException | IndexOutOfBoundsException | NoClassDefFoundError  e) {
				this.loggerSISE.error("Exception => parseData.AseguradoEdoCta EdoCta ["+poliza+"]",e);
			}
			estadoCuenta.setAsegurado(asegurado);
			
			// Datos de la poliza
			PolizaEdoCta polizaEdoCta = new PolizaEdoCta();
			try {
			if (data[135] != null && (StringUtils.isNotBlank(data[135]))) {
			polizaEdoCta.setCondVigencia(data[135].trim());
			}
			if (data[152] != null && (StringUtils.isNotBlank(data[152]))) {
			polizaEdoCta.setDeduAdmin(data[152].trim());
			}
			if (data[73] != null && (StringUtils.isNotBlank(data[73]))) {
			polizaEdoCta.setDiasDeRc(data[73].trim());
			}
			if (data[77] != null && (StringUtils.isNotBlank(data[77]))) {
			polizaEdoCta.setDomiciliacion(data[77].trim());
			}
			if (data[76] != null && (StringUtils.isNotBlank(data[76]))) {
			polizaEdoCta.setEncontrack((data[76].trim().equals("0"))?"NO":"SI");
			}
			if (data[8] != null && (StringUtils.isNotBlank(data[8]))) {
			polizaEdoCta.setFemision(data[8].trim());
			}
			if (data[139] != null && (StringUtils.isNotBlank(data[139]))) {
			polizaEdoCta.setMarcaPT(data[139].trim());
			}
			if (data[41] != null && (StringUtils.isNotBlank(data[40]))) {
			polizaEdoCta.setMoneda(data[41] + ":" + data[40]);
			}
			if (data[22] != null && (StringUtils.isNotBlank(data[22]))) {
			polizaEdoCta.setUltEndoso(data[22].trim());
			}
			if (data[17] != null && (StringUtils.isNotBlank(data[143]))) {
			polizaEdoCta.setStatus(data[17] + " " + data[143]);
			}
			} catch (ClassCastException | IllegalAccessError|IllegalArgumentException | IndexOutOfBoundsException | NoClassDefFoundError  e) {
				this.loggerSISE.error("Exception => parseData.PolizaEdoCta EdoCta ["+poliza+"]",e);
			}
			
			//Datos extras de la poliza
			PolizaExtraEdoCta extra = new PolizaExtraEdoCta();
			try {
			if (data[146] != null && (StringUtils.isNotBlank(data[146]))) {
			extra.settEndoso(data[146].trim());
			}
			if (data[147] != null && (StringUtils.isNotBlank(data[147]))) {
			extra.settInc(data[147].trim());
			}
			if (data[148] != null && (StringUtils.isNotBlank(data[148]))) {
			extra.setIncEli(data[148].trim());
			}
			if (data[149] != null && (StringUtils.isNotBlank(data[149]))) {
			extra.setIncEliAnt(data[149].trim());
			}
			if (data[150] != null && (StringUtils.isNotBlank(data[150]))) {
			extra.setEndMond(data[150].trim());
			}
			if (data[151] != null && (StringUtils.isNotBlank(data[151]))) {
			extra.setEmitio(data[151].trim());
			}
			} catch (ClassCastException | IllegalAccessError|IllegalArgumentException | IndexOutOfBoundsException | NoClassDefFoundError  e) {
				this.loggerSISE.error("Exception => parseData.PolizaExtraEdoCta EdoCta ["+poliza+"]",e);
			}
				polizaEdoCta.setExtra(extra);
			estadoCuenta.setPoliza(polizaEdoCta);
			if (data[152] != null && (StringUtils.isNotBlank(data[152]))) {
			estadoCuenta.setDeducibleAdm(data[152].trim());
			}
			if (data[160] != null && (StringUtils.isNotBlank(data[160]))) {
			estadoCuenta.setMsjAgente(data[160].trim());
			}
			
			// Datos de agente
			AgenteEdoCta agente = new AgenteEdoCta();
			try {
			if (data[6] != null && (StringUtils.isNotBlank(data[6]))) {
			agente.setClave(data[6].trim());
			}
			if (data[3] != null && (StringUtils.isNotBlank(data[3]))) {
			agente.setGerente(data[3].trim());
			}
			if (data[7] != null && (StringUtils.isNotBlank(data[7]))) {
			agente.setNombre(data[7].trim());
			}
			if (data[74] != null && (StringUtils.isNotBlank(data[74]))) {
			estadoCuenta.setAgente(agente);
			}
			} catch (ClassCastException | IllegalAccessError|IllegalArgumentException | IndexOutOfBoundsException | NoClassDefFoundError  e) {
				this.loggerSISE.error("Exception => parseData.AgenteEdoCta EdoCta ["+poliza+"]",e);
			}
			
			// Recibos
			// Fecha vencimiento
			String arr1[] = data[49].split("\\"+JMConstantes.CHAR_PARSE2);
			// Importe recibo
			String arr2[] = data[50].split("\\"+JMConstantes.CHAR_PARSE2);
			// remesa recibo
			String arr3[] = data[51].split("\\"+JMConstantes.CHAR_PARSE2);
			// fecha pago recibo
			String arr4[] = data[52].split("\\"+JMConstantes.CHAR_PARSE2);
			// Numero de recibo
			String arr5[] = data[20].split("\\"+JMConstantes.CHAR_PARSE2);
			// Estado del recibo
			String arr6[] = data[21].split("\\"+JMConstantes.CHAR_PARSE2);
			// Tipo movimiento
			String arr7[] = data[80].split("\\"+JMConstantes.CHAR_PARSE2);
			// Numero endoso
			String arr8[] = data[140].split("\\"+JMConstantes.CHAR_PARSE2);
			// Endoso
			String arr9[] = data[78].split("\\"+JMConstantes.CHAR_PARSE2);
			
			List<ReciboEdoCta> recibos = new ArrayList<ReciboEdoCta>();
			if(arr5.length > 0 && !arr5[0].isEmpty() && StringUtils.isNotBlank(arr5[0])){	
				ReciboEdoCta recibo = null;
				// Solo obtener el ultimo recibo 
					recibo = new ReciboEdoCta();
					recibo.setPoliza(general.getPoliza());
					recibo.setInciso(general.getInciso());
					recibo.setEndoso((arr9.length>arr5.length - 1)?arr9[arr5.length - 1].trim():"");
					recibo.setEstado((arr6.length>arr5.length - 1)?arr6[arr5.length - 1].trim():"");
					recibo.setFechaPago((arr4.length>arr5.length - 1)?arr4[arr5.length - 1].trim():"");
					recibo.setFechaVencimiento((arr1.length>arr5.length - 1)?arr1[arr5.length - 1].trim():"");
					recibo.setImporte((arr2.length>arr5.length - 1)?arr2[arr5.length - 1].trim():"");
					recibo.setNumero((arr8.length>arr5.length - 1)?arr8[arr5.length - 1].trim():"");
					recibo.setNumRecibo((arr5.length>arr5.length - 1)?arr5[arr5.length - 1].trim():"");
					recibo.setRemesa((arr5.length>arr5.length - 1)?arr3[arr5.length - 1].trim():"");
					recibo.setTipoMovim((arr7.length>arr5.length - 1)?arr7[arr5.length - 1].trim():"");
				recibos.add(recibo);
				
			}
			estadoCuenta.setRecibos(recibos);
			
			VehiculoEdoCta vehiculo = new VehiculoEdoCta();
			try {
			if (data[138] != null && (StringUtils.isNotBlank(data[138]))) {
			vehiculo.setCarroceria(data[138].trim());
			}
			if (data[35] != null && (StringUtils.isNotBlank(data[35]))) {
			vehiculo.setColor(data[35].trim());
			}
			if (data[34] != null && (StringUtils.isNotBlank(data[34]))) {
			vehiculo.setConductor(data[34].trim());
			}
			if (data[29] != null && (StringUtils.isNotBlank(data[29]))) {
			vehiculo.setMarca(data[29].trim());
			}
			if (data[33] != null && (StringUtils.isNotBlank(data[33]))) {
			vehiculo.setModelo(data[33].trim());
			}
			if (data[19] != null && (StringUtils.isNotBlank(data[19]))) {
			vehiculo.setMotor(data[19].trim());
			}
			if (data[45] != null && (StringUtils.isNotBlank(data[45]))) {
			vehiculo.setOcupantes(data[45].trim());
			}
			if (data[31] != null && (StringUtils.isNotBlank(data[31]))) {
			vehiculo.setPlacas(data[31].trim());
			}
			if (data[32] != null && (StringUtils.isNotBlank(data[32]))) {
			vehiculo.setSerie(data[32].trim());
			}
			if (data[79] != null && (StringUtils.isNotBlank(data[79]))) {
			vehiculo.setServicio(data[79].trim());
			}
			if (data[39] != null && (StringUtils.isNotBlank(data[39]))) {
			vehiculo.setSubRamo(data[39].trim());
			}
			if (data[137] != null && (StringUtils.isNotBlank(data[137]))) {
			vehiculo.setTipo(data[137].trim());
			}
			if (data[136] != null && (StringUtils.isNotBlank(data[136]))) {
			vehiculo.setUso(data[136].trim());
			}
			if (data[30] != null && (StringUtils.isNotBlank(data[30]))) {
			vehiculo.setVehiculo(data[30].trim());
			}
			if (data[64] != null && (StringUtils.isNotBlank(data[64]))) {
			vehiculo.setTipoVehiculo(data[64].trim());
			}
			} catch (ClassCastException | IllegalAccessError|IllegalArgumentException | IndexOutOfBoundsException | NoClassDefFoundError  e) {
				this.loggerSISE.error("Exception => parseData.VehiculoEdoCta EdoCta ["+poliza+"]",e);
			}
			estadoCuenta.setVehiculo(vehiculo);
			
			// Coberturas
			// Clave cobertura
			arr1 = data[12].split("\\"+JMConstantes.CHAR_PARSE2);
			// Nombre cobertura
			arr3 = data[13].split("\\"+JMConstantes.CHAR_PARSE2);
			// Suma asegurada
			arr4 = data[14].split("\\"+JMConstantes.CHAR_PARSE2);
			String arr4sa[] = data[144].split("\\"+JMConstantes.CHAR_PARSE2);
			// Deducible cobertura
			arr5 = data[15].split("\\"+JMConstantes.CHAR_PARSE2);
			// importe del deducible
			arr2 = data[16].split("\\"+JMConstantes.CHAR_PARSE2);
			
			List<CoberturasEdoCta> coberturas = new ArrayList<CoberturasEdoCta>();
			String tmpDedu = null;
			if(arr1.length > 0 && !arr1[0].isEmpty()){
				CoberturasEdoCta cobertura = null;
				for (int i = 0; i < arr1.length; i++) {
					cobertura = new CoberturasEdoCta();
					cobertura.setClave((arr1.length>i)?arr1[i].trim():"");
					if(arr5.length>i){
						if(arr5[i].trim().contains("DSMGVDF") ||
								arr5[i].trim().contains("dsmg") ||
								arr5[i].trim().contains("Ded.Dias")){
							tmpDedu = arr5[i].trim();
						} else if(!arr5[i].trim().isEmpty()){
							tmpDedu = arr5[i].trim() + " %";
						} else{
							tmpDedu = arr5[i].trim();
						}
					}
					else{
						tmpDedu = "";
					}
					
					cobertura.setDeducible(tmpDedu);
					cobertura.setImporteDedu((arr2.length>i)?arr2[i].trim():"");
					cobertura.setNombre((arr3.length>i)?arr3[i].trim():"");
					cobertura.setSumAseg((arr4sa.length>i)?arr4sa[i].trim():"");
				coberturas.add(cobertura);
				}
			}
			estadoCuenta.setCoberturas(coberturas);
			
			if (data[74] != null && (StringUtils.isNotBlank(data[74])) && data[74].trim() != null) {
				estadoCuenta.setTextPoliza(data[74].trim());
			}
			if (data[75] != null && (StringUtils.isNotBlank(data[75]))) {
				estadoCuenta.setTextInciso(data[75].trim());
			}
			if (data[128] != null && (StringUtils.isNotBlank(data[128]))) {
				estadoCuenta.setTextEndoso(data[128].trim());
			}
			
			try  {
				if (data[75] != null && StringUtils.isNotBlank(data[75]) && data[75] != "  " && data[75] != " ") {
					estadoCuenta.setComentario(data[75].trim());
				}
			} catch (ClassCastException | IllegalAccessError|IllegalArgumentException | IndexOutOfBoundsException | NoClassDefFoundError  e) {
				this.loggerSISE.error("Exception => parseData.Comentario EdoCta ["+poliza+"]",e);
			}
			
			// Siniestros
			// numero de siniestro
			arr1 = data[54].split("\\"+JMConstantes.CHAR_PARSE2);
			// fecha de siniestro
			arr2 = data[55].split("\\"+JMConstantes.CHAR_PARSE2);
			// ejercicio
			arr3 = data[53].split("\\"+JMConstantes.CHAR_PARSE2);
			
			List<SiniestroEdoCta> siniestros = new ArrayList<SiniestroEdoCta>();
			if(arr1.length > 0 && !arr1[0].isEmpty()){			
				
				SiniestroEdoCta siniestro = null;
				for (int i = 0; i < arr1.length; i++) {
					siniestro = new SiniestroEdoCta();
					siniestro.setEjercicio((arr3.length>i)?arr3[i]:"");
					siniestro.setFecha((arr2.length>i)?arr2[i]:"");
					siniestro.setMoneda(polizaEdoCta.getMoneda());
					siniestro.setSiniestro((arr1.length>i)?arr1[i]:"");
					
					siniestros.add(siniestro);
				}
			}
			estadoCuenta.setSiniestros(siniestros);
			
			// Reportes
			// Numero de reporte
			arr1 = data[66].split("\\"+JMConstantes.CHAR_PARSE2);
			// Fecha reporte
			arr2 = data[69].split("\\"+JMConstantes.CHAR_PARSE2);
			// Hora del reporte
			arr3 = data[85].split("\\"+JMConstantes.CHAR_PARSE2);
			// Causa
			arr4 = data[70].split("\\"+JMConstantes.CHAR_PARSE2);
			// Como ocurrio
			arr5 = data[71].split("\\"+JMConstantes.CHAR_PARSE2);
			// Ajustador
			arr6 = data[82].split("\\"+JMConstantes.CHAR_PARSE2);
			// Fecha ocurrido
			arr7 = data[83].split("\\"+JMConstantes.CHAR_PARSE2);
			// Hora ocurrido
			arr8 = data[84].split("\\"+JMConstantes.CHAR_PARSE2);
			
			List<ReporteEdoCta> reportes = new ArrayList<ReporteEdoCta>();
			if(arr1.length > 0 && !arr1[0].isEmpty()){			
				ReporteEdoCta reporte = null;
				for (int i = 0; i < arr1.length; i++) {
					reporte = new ReporteEdoCta();
					reporte.setAjustador((arr6.length>i)?arr6[i]:"");
					reporte.setCausa((arr4.length>i)?arr4[i]:"");
					reporte.setComoOcurrio((arr5.length>i)?arr5[i]:"");
					reporte.setFechaOcurrido((arr7.length>i)?arr7[i]:"");
					reporte.setFechaReporte((arr2.length>i)?arr2[i]:"");
					reporte.setHoraOcurrido((arr8.length>i)?arr8[i]:"");
					reporte.setHoraReporte((arr3.length>i)?arr3[i]:"");
					reporte.setNumero((arr1.length>i)?arr1[i]:"");
					
					reportes.add(reporte);
				}
			}
			estadoCuenta.setReportes(reportes);
			
			// Estimaciones
			// Descripcion o Clave 56 
			arr1 = data[56].split("\\"+JMConstantes.CHAR_PARSE2);
			// ejercicio
			arr5 = data[53].split("\\"+JMConstantes.CHAR_PARSE2);
			// Siniestro
			arr6 = data[54].split("\\"+JMConstantes.CHAR_PARSE2);
			// Fecha 57
			arr2 = data[57].split("\\"+JMConstantes.CHAR_PARSE2);
			// Monto 59
			arr3 = data[59].split("\\"+JMConstantes.CHAR_PARSE2);
			// Codigo moneda 58
			arr4 = data[58].split("\\"+JMConstantes.CHAR_PARSE2);
			
			List<EstimacionEdoCta> estimaciones = new ArrayList<EstimacionEdoCta>();
			if(arr1.length > 0 && !arr1[0].isEmpty()){			
				EstimacionEdoCta estimacion = null;
				for (int i = 0; i < arr1.length; i++) {
					estimacion = new EstimacionEdoCta();
					estimacion.setClave((arr1.length>i)?arr1[i]:"");
					estimacion.setEjercicio((arr5.length>i)?arr5[i]:"");
					estimacion.setSiniestro((arr6.length>i)?arr6[i]:"");
					estimacion.setFecha((arr2.length>i)?arr2[i]:"");
					estimacion.setMonto((arr3.length>i)?arr3[i]:"");
					estimacion.setMoneda((arr4.length>i)?arr4[i]:"");
					
					estimaciones.add(estimacion);
				}
			}
			estadoCuenta.setEstimaciones(estimaciones);
			
			// Equipo Especial
			// Descripcion
			arr1 = data[131].split("\\"+JMConstantes.CHAR_PARSE2);
			// Suma asegurada
			arr2 = data[132].split("\\"+JMConstantes.CHAR_PARSE2);
			if (arr1 != null && StringUtils.isNotBlank(data[131]) && arr2 != null && StringUtils.isNotBlank(data[132])) {
			List<EquipoEspecialEdoCta> equipos = new ArrayList<EquipoEspecialEdoCta>();
			if(arr2.length > 0 && !arr2[0].isEmpty()){			
				EquipoEspecialEdoCta equipoEspecial = null;
				for (int i = 0; i < arr2.length; i++) {
					equipoEspecial = new EquipoEspecialEdoCta();
					equipoEspecial.setDescripcion((arr1.length>i)?arr1[i].trim():"");
					equipoEspecial.setSumaAseg((arr2.length>i)?arr2[i].trim():"");
					
					equipos.add(equipoEspecial);
				}
			}
			estadoCuenta.setEquiposEspeciales(equipos);
			}
			
			// Adaptaciones
			// Descripcion
			arr1 = data[133].split("\\"+JMConstantes.CHAR_PARSE2);
			// Suma asegurada
			arr2 = data[134].split("\\"+JMConstantes.CHAR_PARSE2);
			if (arr1 != null && StringUtils.isNotBlank(data[133]) && arr2 != null &&
					StringUtils.isNotBlank(data[134])) {
			List<AdaptacionEdoCta> adaptaciones = new ArrayList<AdaptacionEdoCta>();
			if(arr2.length > 0 && !arr2[0].isEmpty()){			
				
				AdaptacionEdoCta adaptacion = null;
				for (int i = 0; i < arr2.length; i++) {
					adaptacion = new AdaptacionEdoCta();
					adaptacion.setDescripcion((arr1.length>i)?arr1[i]:"");
					adaptacion.setSumaAseg((arr2.length>i)?arr2[i]:"");
				adaptaciones.add(adaptacion);
				}
			}
			estadoCuenta.setAdaptaciones(adaptaciones);
			}
			// Condiciones especiales
			// Tipo
			arr1 = data[90].split("\\"+JMConstantes.CHAR_PARSE2);
			// Condicion
			arr2 = data[91].split("\\"+JMConstantes.CHAR_PARSE2);
			// descripcion de condicion
			arr3 = data[92].split("\\"+JMConstantes.CHAR_PARSE2);
			// observaciones
			arr4 = data[93].split("\\"+JMConstantes.CHAR_PARSE2);
			// Valor
			arr5 = data[94].split("\\"+JMConstantes.CHAR_PARSE2);
			// Desc Valor
			arr6 = data[95].split("\\"+JMConstantes.CHAR_PARSE2);
			// Fecha inicio
			arr7 = data[96].split("\\"+JMConstantes.CHAR_PARSE2);
			// Fecha fin
			arr8 = data[97].split("\\"+JMConstantes.CHAR_PARSE2);
			// MKR
			arr9 = data[98].split("\\"+JMConstantes.CHAR_PARSE2);
			// fecha alta
			String arr10[] = data[129].split("\\"+JMConstantes.CHAR_PARSE2);
			// hora alta
			String arr11[] = data[130].split("\\"+JMConstantes.CHAR_PARSE2);
			// Nombre afectado
			String arr12[] = data[142].split("\\"+JMConstantes.CHAR_PARSE2);
			// Autoriza
			String arr13[] = data[141].split("\\"+JMConstantes.CHAR_PARSE2);
			
			if (arr2 != null && StringUtils.isNotBlank(data[91]) ) {
			List<CondicionEspecialEdoCta> condicionesEspeciales = new ArrayList<CondicionEspecialEdoCta>();
			if(arr2.length > 0 && !arr2[0].isEmpty()){			
				CondicionEspecialEdoCta condicionEspecial = null;
				for (int i = 0; i < arr2.length; i++) {
					condicionEspecial = new CondicionEspecialEdoCta();
					condicionEspecial.setCondicion((arr2.length>i)?arr2[i]:"");
					condicionEspecial.setDescCondicion((arr3.length>i)?arr3[i]:"");
					condicionEspecial.setDescValor((arr6.length>i)?arr6[i]:"");
					condicionEspecial.setEjecutivoAut((arr13.length>i)?arr13[i]:"");
					condicionEspecial.setFechaAlta((arr10.length>i)?arr10[i]:"");
					condicionEspecial.setFechaFin((arr8.length>i)?arr8[i]:"");
					condicionEspecial.setFechaInicio((arr7.length>i)?arr7[i]:"");
					condicionEspecial.setHoraAlta((arr11.length>i)?arr11[i]:"");
					condicionEspecial.setMkr((arr9.length>i)?arr9[i]:"");
					condicionEspecial.setNomAfectado((arr12.length>i)?arr12[i]:"");
					condicionEspecial.setObservaciones((arr4.length>i)?arr4[i]:"");
					condicionEspecial.setTipo((arr1.length>i)?arr1[i]:"");
					condicionEspecial.setValor((arr5.length>i)?arr5[i]:"");
					
					condicionesEspeciales.add(condicionEspecial);
				}
			}
			estadoCuenta.setCondicionesEspeciales(condicionesEspeciales);
			}
			//Daños pre existentes
			try {
				if (data[169] != null && StringUtils.isNotBlank(data[169])) {
					String danioPreExistente = data[169].trim();
					if (danioPreExistente.contains("S")) {
						estadoCuenta.setDaniosPreexistentes("SI");
						List<String> listaDanioPreExis = new ArrayList<>();
						String arrDPre[] = data[170].split("\\"+JMConstantes.CHAR_PARSE2);
						if(arrDPre.length > 0 && !data[170].isEmpty()){			
							for (int i = 0; i < arrDPre.length; i++) {
								listaDanioPreExis.add(arrDPre[i]);
							}
							estadoCuenta.setListaDaniosPreExis(listaDanioPreExis);
							}

					} else {
						estadoCuenta.setDaniosPreexistentes("NO");
					}
				}
			
			} catch (ClassCastException | IndexOutOfBoundsException | IllegalAccessError | IllegalStateException e) {
				this.loggerSISE.error("Exception => parseData.DaniosPreexistentesEdoCta EdoCta ["+poliza+"]",e);
			}
			if (data[167] != null && StringUtils.isNotBlank(data[167])) {
				estadoCuenta.setCodigoTarifa(data[167]);
			}
			if (data[170] != null && StringUtils.isNotBlank(data[170])) {
				estadoCuenta.setInspeccionVeh(data[170]);
			}
			if (data[171] != null && StringUtils.isNotBlank(data[171])) {
				estadoCuenta.setFechaInspeccion(data[171].trim());
			}
			return estadoCuenta;
		}
	

	public List<SerieEdoCta> parseSerieEdoCta(String input, String serie){
		List<SerieEdoCta> salida = new ArrayList<SerieEdoCta>();
		String data[] = input.split("\\"+JMConstantes.CHAR_PARSE1);
		if(data.length < 2){
			this.loggerSISE.error("Inconcistencia de datos: la cadena de respuesta tiene información incompleta. Serie ["+serie+"]");
			this.loggerSISE.info("La serie ["+serie+"] no existe.");
			return null;
		}
		String siniestro[] = null;
		String fechaSiniestro[] = null;
		String ramo[] = null;
		String terminoVig[] = null;
		String inicioVig[] = null;
		String codAgente[] = null;
		String inciso[]= null;
		String endoso[] = null;
		String poliza[] = null; 
		//Polizas
		try {
		poliza = data[0].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Exception parseSerieEdoCta.poliza =>",e); 
		}
		// Importe recibo
		try {
		endoso = data[1].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.endoso =>",e); 
		}
		// remesa recibo
		try {
		inciso = data[2].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.inciso =>",e); 
		}
		// fecha pago recibo
		try {
		codAgente = data[3].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.codAgente =>",e); 
		}
		// Numero de recibo
		try {
		inicioVig = data[4].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.inicioVig =>",e); 
		}
		// Estado del recibo
		try {
		terminoVig = data[5].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.terminoVig =>",e); 
		}
		// Tipo movimiento
		try {
		ramo = data[6].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.ramo =>",e); 
		}
		// Numero endoso
		try { 
			siniestro = data[7].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.siniestro =>",e); 
		}
		// Endoso
		try {
			 fechaSiniestro = data[8].split("\\"+JMConstantes.CHAR_PARSE2);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.fechaSiniestro =>",e); 
		}
		try {
		if(poliza.length > 0 && !poliza[0].isEmpty() && StringUtils.isNotBlank(poliza[0])){
			SerieEdoCta seriesData = null;
			for (int i = 0; i < poliza.length; i++) {
			seriesData = new SerieEdoCta();
			try {
				if (poliza != null) {
				seriesData.setPoliza((poliza.length>i)?poliza[i].trim():"");
				}
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.poliza for",e);
			}
			try {
				if (endoso != null) {
				seriesData.setEndoso((endoso.length>i)?endoso[i].trim():"");
				}
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.endoso for",e);
			}
			try {
				if (inciso != null) {
				seriesData.setInciso((inciso.length>i)?inciso[i].trim():"");
				}
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.inciso for",e);
			}
			try {
				if (codAgente != null) {
				seriesData.setCodAgente((codAgente.length>i)?codAgente[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.codAgente for",e);
			}
			try {
				if (inicioVig != null) {
				seriesData.setInicioVigencia((inicioVig.length>i)?inicioVig[i].trim():"");
				}
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.inicioVig for",e);
			}
			try {
				if (terminoVig != null) {
				seriesData.setTerminoVigencia((terminoVig.length>i)?terminoVig[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception parseSerieEdoCta.terminoVig for",e);
			}
			try {
				if (ramo != null && ramo.length>i && StringUtils.isNotBlank(ramo[i])) {
					seriesData.setRamo((ramo.length>i)?ramo[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception parseSerieEdoCta.ramo for",e);
			}
				try {
					if (siniestro != null  && siniestro.length>i && StringUtils.isNotBlank(siniestro[i])) {
						seriesData.setNumSiniestro((siniestro.length>i)?siniestro[i].trim():"");
					}
				} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
					this.loggerSISE.error("Try exception  parseSerieEdoCta.siniestro for",e);
				}
				try {
					if (fechaSiniestro != null && fechaSiniestro.length>i && StringUtils.isNotBlank(fechaSiniestro[i])) {
						seriesData.setFechaSiniestro((fechaSiniestro.length>i)?fechaSiniestro[i].trim():"");
					}
				} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
					this.loggerSISE.error("Try exception  parseSerieEdoCta.fechaSiniestro for",e);
				}
			salida.add(seriesData);
			}
		}
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("ERROR parseSerieEdoCta() =>",e);
		}
		return salida;
	}
	
	
	public List<Serie6EdoCta> parseSerie6EdoCta(String input, String serie){
		List<Serie6EdoCta> salida = new ArrayList<Serie6EdoCta>();
		String marca[] = null;
		String fechaSiniestro[] = null;
		String ramo[] = null;
		String terminoVig[] = null;
		String inicioVig[] = null;
		String inciso[]= null;
		String endoso[] = null;
		String placa[] = null;
		String regFedVeh[] = null;
		String motor[] = null;
		String numSerie[] = null;
		String numSiniestro[] = null;
		String poliza[] = null;
		UniDynArray uniSalida = new UniDynArray(input);
		this.loggerSISE.info("TAMAÑO: "+uniSalida.dcount());
		if (uniSalida.dcount() < 1) {
			this.loggerSISE.error("Inconcistencia de datos: la cadena de respuesta tiene información incompleta. Serie ["+serie+"]");
			this.loggerSISE.info("La serie ["+serie+"] no existe.");
			return null;
		}
		String data[] = new String[uniSalida.dcount()+1] ;
		this.loggerSISE.info("****************************************************");
		for (int i = 1; i <= uniSalida.dcount(); i++) {
			this.loggerSISE.info(" => "+uniSalida.extract(i).toString());
			data[i] = uniSalida.extract(i).toString();
		}
		//Polizas
		try {
		poliza = data[1].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Exception parseSerieEdoCta.poliza =>",e); 
		}
		// Importe recibo
		try {
		endoso = data[2].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.endoso =>",e); 
		}
		// remesa recibo
		try {
		inciso = data[3].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.inciso =>",e); 
		}
		// fecha pago recibo
		try {
		marca = data[4].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.codAgente =>",e); 
		}
		// Numero de recibo
		try {
		inicioVig = data[5].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.inicioVig =>",e); 
		}
		// Estado del recibo
		try {
		terminoVig = data[6].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.terminoVig =>",e); 
		}
		try {
			placa = data[7].split("\\"+(char)JMConstantes.CHAR_Y);
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Excepcion parseSerieEdoCta.terminoVig =>",e); 
			}	
		// Tipo movimiento
		try {
		regFedVeh = data[8].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.ramo =>",e); 
		}
		// Numero endoso
		try { 
			motor = data[9].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.siniestro =>",e); 
		}
		try {
			numSerie = data[10].split("\\"+(char)JMConstantes.CHAR_Y);
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Excepcion parseSerieEdoCta.terminoVig =>",e); 
			}
		try {
			numSiniestro = data[11].split("\\"+(char)JMConstantes.CHAR_Y);
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Excepcion parseSerieEdoCta.terminoVig =>",e); 
			}
		try {
			 fechaSiniestro = data[12].split("\\"+(char)JMConstantes.CHAR_Y);
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("Excepcion parseSerieEdoCta.fechaSiniestro =>",e); 
		}
		try {
			ramo = data[13].split("\\"+(char)JMConstantes.CHAR_Y);
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Excepcion parseSerieEdoCta.terminoVig =>",e); 
			}
		try {
		if(poliza.length > 0 && !poliza[0].isEmpty() && StringUtils.isNotBlank(poliza[0])){
			Serie6EdoCta seriesData = null;
			for (int i = 0; i < poliza.length; i++) {
			seriesData = new Serie6EdoCta();
			try {
				if (poliza != null && poliza.length>i && StringUtils.isNotBlank(poliza[i])) {
				seriesData.setPoliza((poliza.length>i)?poliza[i].trim():"");
				}
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.poliza for",e);
			}
			try {
				if (endoso != null && endoso.length>i && StringUtils.isNotBlank(endoso[i])) {
				seriesData.setEndoso((endoso.length>i)?endoso[i].trim():"");
				}
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.endoso for",e);
			}
			try {
				if (inciso != null && inciso.length>i && StringUtils.isNotBlank(inciso[i])) {
				seriesData.setInciso((inciso.length>i)?inciso[i].trim():"");
				}
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.inciso for",e);
			}
			try {
				if (marca != null && marca.length>i && StringUtils.isNotBlank(marca[i])) {
				seriesData.setMarca((marca.length>i)?marca[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.codAgente for",e);
			}
			try {
				if (inicioVig != null && inicioVig.length>i && StringUtils.isNotBlank(inicioVig[i])) {
				seriesData.setInicioVig((inicioVig.length>i)?inicioVig[i].trim():"");
				}
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception  parseSerieEdoCta.inicioVig for",e);
			}
			try {
				if (terminoVig != null && terminoVig.length>i && StringUtils.isNotBlank(terminoVig[i]) ) {
				seriesData.setFinVig((terminoVig.length>i)?terminoVig[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception parseSerieEdoCta.terminoVig for",e);
			}
			try {
				if (placa != null && placa.length>i && StringUtils.isNotBlank(placa[i])) {
				seriesData.setPlacas((placa.length>i)?placa[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception parseSerieEdoCta.placa for",e);
			}
			try {
				if (regFedVeh != null && regFedVeh.length>i && StringUtils.isNotBlank(regFedVeh[i])) {
				seriesData.setRegFedVeh((regFedVeh.length>i)?regFedVeh[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception parseSerieEdoCta.regFedVeh for",e);
			}
			try {
				if (motor != null && motor.length>i && StringUtils.isNotBlank(motor[i])) {
				seriesData.setMotor((motor.length>i)?motor[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception parseSerieEdoCta.motor for",e);
			}
			try {
				if (numSerie != null && numSerie.length>i && StringUtils.isNotBlank(numSerie[i])) {
				seriesData.setNumSiniestro((numSerie.length>i)?numSerie[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception parseSerieEdoCta.regFedVeh for",e);
			}
			try {
				if (ramo != null && ramo.length>i && StringUtils.isNotBlank(ramo[i])) {
					seriesData.setRamo((ramo.length>i)?ramo[i].trim():"");
				} 
			} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
				this.loggerSISE.error("Try exception parseSerieEdoCta.ramo for",e);
			}
				try {
					if (numSiniestro != null  && numSiniestro.length>i && StringUtils.isNotBlank(numSiniestro[i])) {
						seriesData.setNumSiniestro((numSiniestro.length>i)?numSiniestro[i].trim():"");
					}
				} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
					this.loggerSISE.error("Try exception  parseSerieEdoCta.siniestro for",e);
				}
				try {
					if (fechaSiniestro != null && fechaSiniestro.length>i && StringUtils.isNotBlank(fechaSiniestro[i])) {
						seriesData.setFechaSiniestro((fechaSiniestro.length>i)?fechaSiniestro[i].trim():"");
					}
				} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
					this.loggerSISE.error("Try exception  parseSerieEdoCta.fechaSiniestro for",e);
				}
				try {
					if (ramo != null && ramo.length>i && StringUtils.isNotBlank(ramo[i])) {
						seriesData.setRamo((ramo.length>i)?ramo[i].trim():"");
					}
				} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
					this.loggerSISE.error("Try exception  parseSerieEdoCta.ramo for",e);
				}
			salida.add(seriesData);
			}
		}
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerSISE.error("ERROR parseSerieEdoCta() =>",e);
		}
		return salida;
	}
	
}
