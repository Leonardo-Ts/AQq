package com.aaq.col.clases.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JMUtileriaTask {
	
	public Log log = LogFactory.getLog(JMUtileriaTask.class);

	
	@Scheduled(cron = "0 */1 * * * ?")
	private void taskReporteApartado(){
		TerminalServiceInterfase terminalDao = Terminal.getTerminalService();
		List<Terminal> lstTerminalReporteApartado = new ArrayList<>();
		JsonObject json = null;
		JsonParser parser = new JsonParser();
		
		Date fechaApartado;
		
		try{
			lstTerminalReporteApartado = terminalDao.listaTodoDeTerminal(true);
			
			for (Terminal terminal : lstTerminalReporteApartado) {
				json = (JsonObject) parser.parse(terminal.getReporteApartado());
				
				fechaApartado = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(json.get("fechaApartado").getAsString());
				
				long tiempoTranscurrido = (((new Date().getTime() - fechaApartado.getTime()) / 1000) / 60);
				
				if(tiempoTranscurrido >= 5){
					terminal.setReporteApartado(null);
					terminal.guardarObjeto();
				}
			}
		}catch(Exception ex){
		}
	}
	
	
}
