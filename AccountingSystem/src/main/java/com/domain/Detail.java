package com.domain;

/**
 * Created by M-Sem on 01/12/2015.
 */

import javax.persistence.*;

@Entity
@Table(name = "detail")
public class Detail implements DBObject {

    @Id
    @GeneratedValue(generator = "DETAIL_SEQ")
    @SequenceGenerator(name = "DETAIL_SEQ", sequenceName = "DETAIL_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    Category category;

    String name;

    public Detail() {
    }

    public Detail(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    @Override
    public Long getId() {
        return null;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                '}';
    }
}
