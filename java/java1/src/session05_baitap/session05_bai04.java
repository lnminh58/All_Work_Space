/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//4. Yêu cầu người dùng nhập đúng yêu cầu: DIEM phải từ 0 đến 10 (dùng do ..while)
package session05_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session05_bai04 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int diem;
        do{
            System.out.print("Nhap diem (tu 0 den 10): ");
            diem=nhap.nextInt();
        }while((diem<0)||(diem>10));
    }
}
