package com.jfreedom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by PC-PC on 9/8/2016.
 */
@Entity
@Table(name ="custommer")
public class Custommer implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="cusName")
    private String cusName;
    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "shopId")
    Shop shop;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "custommer")
    private Address add;
    /*@ManyToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "custommerList")
    List<Product> productList;*/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cusandpro",
            joinColumns =         {@JoinColumn(name = "cusID")},
            inverseJoinColumns = {@JoinColumn(name = "proID")})
    private Set<Product> productSet;

  /* *//* public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }*/

public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    /*@ManyToOne
private CusAndPro cusAndPro;

    public void setAdd(Address add) {
        this.add = add;

    }*/

    public Address getAdd(){
        return add;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Custommer{" +
                "id=" + id +
                ", cusName='" + cusName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", shop=" + shop +
                '}';
    }
}
