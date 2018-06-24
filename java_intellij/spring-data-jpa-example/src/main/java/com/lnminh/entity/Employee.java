package com.lnminh.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="full_name")
    private String fullName;

    public Employee() {
    }

    public Employee(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
