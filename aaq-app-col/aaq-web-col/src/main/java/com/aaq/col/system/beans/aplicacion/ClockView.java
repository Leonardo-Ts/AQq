package com.aaq.col.system.beans.aplicacion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
@ManagedBean(name = "clockView")
public class ClockView implements Serializable {
	
	private static final long serialVersionUID = -8605909793749569973L;
	private LocalDateTime dateTime;

    @PostConstruct
    public void init() {
//        dateTime = LocalDateTime.now().plusYears(37).plusMonths(3).plusHours(4);
    	dateTime = LocalDateTime.now(ZoneId.of("America/Bogota"));
    	
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}