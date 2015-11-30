package com.domain;

import javax.persistence.*;

/**
 * Created by M-Sem on 28/11/2015.
 */
@Entity
@Table(name = "currency",uniqueConstraints = {@UniqueConstraint(columnNames={"name"})})
public class Currency implements DBObject {

    @Id
    @GeneratedValue(generator = "CURRENCY_SEQ")
    @SequenceGenerator(name = "CURRENCY_SEQ", sequenceName = "CURRENCY_SEQ", allocationSize = 1)
    private Long id;

    private String name;
    private String symbol;
    private long precio;

    public Currency() {
    }

    public Currency(String name, String symbol, long precio) {
        this.name = name;
        this.symbol = symbol;
        this.precio = precio;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }
}
