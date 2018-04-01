/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lnmin
 */
public class Student {
    private String id;
    private String name;
    private boolean gender;
    private String classID;

    public Student() {
    }

    public Student(String id, String name, boolean gender, String classID) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classID = classID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
