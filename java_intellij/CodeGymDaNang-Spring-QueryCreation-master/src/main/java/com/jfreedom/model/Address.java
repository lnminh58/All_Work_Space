package com.jfreedom.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by PC-PC on 9/8/2016.
 */
@Entity
@Table(name ="address")
public class Address  implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    @Column(name = "streetName")
    private  String streetName;
    @Column(name = "streetNumber")
    private int streetNumber;
    @Column(name = "city")
    private String city;

    @OneToOne
    @JoinColumn(name = "cusId")
    private Custommer custommer;

    public Custommer getCustommer() {
        return custommer;
    }

    public void setCustommer(Custommer custommer) {
        this.custommer = custommer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
