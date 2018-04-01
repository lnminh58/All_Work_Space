/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session06;

/**
 *
 * @author nguyenducthao
 */
class batch {
    // khai bao instance variable
    String batchID;
    String batchName;
    static String schoolName;
    
    // khai bao instance method
    public void displayInformation(){
        System.out.println("Information of a batch:");
        System.out.println("Batch ID: "+batchID);
        System.out.println("Batch name: "+batchName);
        System.out.println("School name: "+schoolName);
    }
}

public class instance_variable_and_method {
    public static void main(String[] args) {
        // cach su dung instance variable
        batch batch130=new batch();
        batch130.batchID="batch130";
        batch130.batchName="Batch 130";
        batch.schoolName="Aptech";
        
        // cach su dung instance method
        batch130.displayInformation();
    }
}
