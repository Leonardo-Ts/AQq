package com.aaq.col.clases.database.entidades.abstracto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Estado;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractHorarios.class)
public abstract class AbstractHorarios_ { 

    public static volatile SingularAttribute<AbstractHorarios, Integer> id;
    public static volatile SingularAttribute<AbstractHorarios, String> clave_horario;
    public static volatile SingularAttribute<AbstractHorarios, Integer> dia_semana_num;
    public static volatile SingularAttribute<AbstractHorarios, String> hora_entrada;
    public static volatile SingularAttribute<AbstractHorarios, String> hora_salida;
    public static volatile SingularAttribute<AbstractHorarios, String> dia_semana;
    public static volatile SingularAttribute<AbstractHorarios, Boolean> descanso;
    public static volatile SingularAttribute<AbstractHorarios, Integer> identidad_;
    public static volatile SingularAttribute<AbstractHorarios, Estado> estado;


    

}