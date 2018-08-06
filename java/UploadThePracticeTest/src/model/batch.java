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
public class batch {

    private String batchID;
    private String batchName;

    public batch() {
    }

    public batch(String batchID, String batchName) {
        this.batchID = batchID;
        this.batchName = batchName;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

}
