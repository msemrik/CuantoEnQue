package com.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

;import java.util.Date;


/**
 * Created by x217204 on 11/17/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public class Person extends Account {

private String nombre;

private String numeroTel;


    public Person(String name, Long sadder, String currency, Date startDate,Date endDate, String nombre, String numeroTel) {
        super( name, sadder, currency, startDate,endDate);
        this.nombre = nombre;
        this.numeroTel = numeroTel;
    }

    public Person() {

    }
}
