package com.domain;



import javax.persistence.*;
import java.util.Date;


/**
 * Created by x217204 on 11/17/2015.
 */
@Entity
@Table(name="bankaccount",uniqueConstraints = {@UniqueConstraint(columnNames={"currency_id","type","bank"})})
public class BankAccount extends Account{

private String bank;

private String type;

private String accountNumber;


    public BankAccount(String name, Long sadder, Currency currency, String type, Date startDate, Date endDate, String bank, String accountNumber) {
        super(name, sadder, currency, startDate,endDate);
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.type = type;
    }

    public BankAccount() {

    }
}
