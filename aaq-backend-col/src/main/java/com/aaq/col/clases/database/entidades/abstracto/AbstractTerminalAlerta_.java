package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.Terminal;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractTerminalAlerta.class)
public abstract class AbstractTerminalAlerta_ { 

    public static volatile SingularAttribute<AbstractTerminalAlerta, Date> horaTermino;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Integer> porTiempoDeParadoMayorMinutos;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Terminal> terminal;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Date> horaInicio;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Geocerca> geocercaByPorIdGeocercaSale;
    public static volatile SingularAttribute<AbstractTerminalAlerta, String> telefonoSms;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Integer> porVelocidadMayorKmh;
    public static volatile SingularAttribute<AbstractTerminalAlerta, PuntoInteres> puntoInteres;
    public static volatile SingularAttribute<AbstractTerminalAlerta, String> direccionCorreo;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Integer> id;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Boolean> habilitado;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Geocerca> geocercaByPorIdGeocercaEntra;
    public static volatile SingularAttribute<AbstractTerminalAlerta, Integer> porIdPuntoInteresDistanciaMetros;

}