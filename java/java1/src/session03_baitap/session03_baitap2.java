/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//2. Khai báo biến instance, nhập giá trị cho biến instance từ bàn phím
//và in giá trị của biến instance ra output.
package session03_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session03_baitap2 {
    int bienInstance;
    public session03_baitap2(int i){
        bienInstance=i;
    }
    public static void main(String[] args) {
        
        System.out.print("Nhap gia tri cho bien instance: ");
        Scanner nhap = new Scanner(System.in);
        int i=nhap.nextInt();
        session03_baitap2 bien_instance = new session03_baitap2(i);
        System.out.println("Gia tri cua bien instance: "+ bien_instance.bienInstance);
    }
}
