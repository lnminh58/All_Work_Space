/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;
import util.myUtil;

/**
 *
 * @author nguyenducthao
 */
public class modelBatch {

    private String batchCode;
    private String batchName;

    public modelBatch() {
    }

    public modelBatch(String batchCode, String batchName) {
        this.batchCode = batchCode;
        this.batchName = batchName;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void inputNewBatch() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Input batch code: ");
            this.batchCode = input.nextLine();
            if (this.batchCode.length() <= 10) {
                if (myUtil.checkValid(this.batchCode, "batch\\d{5}")) {
                    break;
                } else {
                    System.out.println("Student code form: \"batch\" and following after 5 digits");
                }
                break;
            } else {
                System.out.println("Batch code maximum of 10 characters!");
            }
        } while (true);
        do {
            System.out.print("Input batch name: ");
            this.batchName = input.nextLine();
            if (this.batchName.length() <= 50) {
                break;
            } else {
                System.out.println("Batch name maximum of 50 characters!");
            }
        } while (true);
    }
}
