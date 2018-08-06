package com.lnminh.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    private Integer id;
    private String name;
    private Batch batchByBatchId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @ManyToOne
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    public Batch getBatchByBatchId() {
        return batchByBatchId;
    }

    public void setBatchByBatchId(Batch batchByBatchId) {
        this.batchByBatchId = batchByBatchId;
    }
}
