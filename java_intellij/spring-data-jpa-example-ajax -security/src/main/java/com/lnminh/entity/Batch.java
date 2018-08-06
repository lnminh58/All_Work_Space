package com.lnminh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "batch_name",columnDefinition = "NVARCHAR")
    private String batchName;


//    ,
//            cascade = {CascadeType.DETACH,CascadeType.MERGE,
//                CascadeType.PERSIST,CascadeType.REFRESH}

    @JsonIgnore
    @OneToMany(mappedBy = "batch")
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchName='" + batchName +
                '}';
    }
}
