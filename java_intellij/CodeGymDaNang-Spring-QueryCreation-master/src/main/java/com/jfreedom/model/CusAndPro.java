/*
package com.jfreedom.model;

import javax.persistence.*;
import java.util.List;

*/
/**
 * Created by PC-PC on 9/11/2016.
 *//*

@Entity
@Table(name = "cusandpro")
@IdClass(value = CompositeCusAndPro.class)

public class CusAndPro {
    @Id
    private int cusID;
    @Id
    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "cusAndPro")
    private List<Custommer> custommerList;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "cusAndPro")
    private List<Product> productList;

    public List<Custommer> getCustommerList() {
        return custommerList;
    }

    public void setCustommerList(List<Custommer> custommerList) {
        this.custommerList = custommerList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private int proID;

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }
}
*/
