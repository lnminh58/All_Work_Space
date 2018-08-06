package com.jfreedom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by PC-PC on 9/11/2016.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    Double price;
    @ManyToMany(mappedBy = "productSet")
    private Set<Custommer> custommerSet;

  /*  @ManyToMany
    List<Custommer> custommerList;*/
/*
    @ManyToOne
    private CusAndPro cusAndPro;
*/

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
