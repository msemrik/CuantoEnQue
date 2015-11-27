package com.domain;

import javax.persistence.*;

@Entity
public class Reason {

    @Id
    @GeneratedValue(generator = "YOUR_ENTITY_SEQ")
    @SequenceGenerator(name = "YOUR_ENTITY_SEQ", sequenceName = "YOUR_ENTITY_SEQ", allocationSize = 1)
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
