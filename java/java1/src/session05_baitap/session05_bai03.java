/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//3. Hay yeu cau nguoi dung nhap vao 1 so le, neu khong dung yeu cau nhap lai.
package session05_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session05_bai03 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int soLe;
        do{
            System.out.print("Hap nhap 1 so le: ");
            soLe=nhap.nextInt();
        }while ((soLe%2)==0);
    }
}
