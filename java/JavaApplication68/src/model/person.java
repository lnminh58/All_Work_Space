/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nguyenducthao
 */
public class person {

    int personID;
    String first_name;
    String last_name;

    public person() {
    }

    public person(int personID, String first_name, String last_name) {
	this.personID = personID;
	this.first_name = first_name;
	this.last_name = last_name;
    }

    public int getPersonID() {
	return personID;
    }

    public void setPersonID(int personID) {
	this.personID = personID;
    }

    public String getFirst_name() {
	return first_name;
    }

    public void setFirst_name(String first_name) {
	this.first_name = first_name;
    }

    public String getLast_name() {
	return last_name;
    }

    public void setLast_name(String last_name) {
	this.last_name = last_name;
    }

}
