package com.domain;

import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Account {
    @Id
    @GeneratedValue(generator = "YOUR_ENTITY_SEQ2")
    @SequenceGenerator(name = "YOUR_ENTITY_SEQ2", sequenceName = "YOUR_ENTITY_SEQ2", allocationSize = 1)
    private Long id;

    private String name;

    private Long sadder;

    private String currency;

    private Date startDate;
    private Date endDate;

    protected Account(String name, Long sadder, String currency, Date startDate,Date endDate) {
        this.id = id;
        this.name = name;
        this.sadder = sadder;
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Account() {
    }


    public void extract(Long amount){
        this.sadder=this.sadder-amount;
    }

    public void deposit(Long amount){
        this.sadder=this.sadder+amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSadder() {
        return sadder;
    }

    public void setSadder(Long sadder) {
        this.sadder = sadder;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}