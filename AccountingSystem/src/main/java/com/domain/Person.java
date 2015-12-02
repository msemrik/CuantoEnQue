package com.domain;

import javax.persistence.*;

;import java.util.Date;


/**
 * Created by x217204 on 11/17/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(columnNames = {"currency_id"})})
public class Person extends Account {

    private String phoneNumber;

    public Person() {
    }

    public Person(String name, Currency currency, Date startDate, Date endDate, String nombre, String phoneNumber) {
        super(name, currency, startDate, endDate);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
