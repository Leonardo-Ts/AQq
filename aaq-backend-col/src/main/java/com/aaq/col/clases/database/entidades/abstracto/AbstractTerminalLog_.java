package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractTerminalLog.class)
public abstract class AbstractTerminalLog_ { 

    public static volatile SingularAttribute<AbstractTerminalLog, String> latitud;
    public static volatile SingularAttribute<AbstractTerminalLog, Integer> reporteEstatus;
    public static volatile SingularAttribute<AbstractTerminalLog, Integer> longitudMensaje;
    public static volatile SingularAttribute<AbstractTerminalLog, String> reporteNumero;
    public static volatile SingularAttribute<AbstractTerminalLog, Terminal> terminal;
    public static volatile SingularAttribute<AbstractTerminalLog, Double> metrosRecorridos;
    public static volatile SingularAttribute<AbstractTerminalLog, Date> fecha;
    public static volatile SingularAttribute<AbstractTerminalLog, String> longitud;
    public static volatile SingularAttribute<AbstractTerminalLog, String> posicionDireccion;
    public static volatile SingularAttribute<AbstractTerminalLog, String> posicionTexto;
    public static volatile SingularAttribute<AbstractTerminalLog, Boolean> posicionValida;
    public static volatile SingularAttribute<AbstractTerminalLog, Integer> id;
    public static volatile SingularAttribute<AbstractTerminalLog, String> velocidad;
    public static volatile SingularAttribute<AbstractTerminalLog, Double> segundosTranscurridos;

}