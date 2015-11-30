package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "reason",uniqueConstraints = {@UniqueConstraint(columnNames={"name"})})
public class Reason implements DBObject{

    @Id
    @GeneratedValue(generator = "REASON_SEQ")
    @SequenceGenerator(name = "REASON_SEQ", sequenceName = "REASON_SEQ", allocationSize = 1)

    private Long id;

    private String name;

    public Reason(String name) {
        this.name = name;
    }

    public Reason() {
    }

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




}
