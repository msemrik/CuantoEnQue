package com.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;


/**
 * Created by x217204 on 11/17/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public class BankAccount extends Account {

private String bank;

private String accountNumber;


    public BankAccount(String name, Long sadder, String currency, Date startDate, Date endDate, String bank, String accountNumber) {
        super(name, sadder, currency, startDate,endDate);
        this.bank = bank;
        this.accountNumber = accountNumber;
    }
}
