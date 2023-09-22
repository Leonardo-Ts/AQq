package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlerta;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractTerminalAlertaLog.class)
public abstract class AbstractTerminalAlertaLog_ { 

    public static volatile SingularAttribute<AbstractTerminalAlertaLog, String> descripcion;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, Date> fecha;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, String> latitud;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, String> longitud;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, String> tipo;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, TerminalAlerta> terminalAlerta;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, Boolean> enviadaEmail;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, Boolean> enviadaSms;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, Integer> id;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, Terminal> terminal;
    public static volatile SingularAttribute<AbstractTerminalAlertaLog, Boolean> enviadaWeb;

}