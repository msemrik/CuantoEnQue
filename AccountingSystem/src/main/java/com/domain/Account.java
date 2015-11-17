package com.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@MappedSuperclass
public abstract class Account {

    @Id
    @GeneratedValue
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