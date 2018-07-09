package com.lnminh.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@NamedQuery(name = "Student.findByOverGender", query = "select s from Student s where s.gender = ?1")
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "full_name",columnDefinition = "NVARCHAR")
    private String fullName;

    @Column(name = "age",columnDefinition = "int")
    private Integer age;

    @Column(name = "gender",columnDefinition = "BIT")
    private boolean gender;

    @Column(name = "birthday")
    private Date birthday;

    //,cascade = {CascadeType.DETACH,CascadeType.MERGE,
    //            CascadeType.PERSIST,CascadeType.REFRESH}


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Student() {
    }

    public Student(String fullName, Integer age, boolean gender, Date birthday) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", batch=" + batch +
                '}';
    }
}
