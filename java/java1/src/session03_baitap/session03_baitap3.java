/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//3. Khai báo biến static, nhập giá trị cho biến static từ bàn phím
//và in giá trị của biến static ra output.
package session03_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session03_baitap3 {
    static int bienStatic;
    public static void main(String[] args) {
        System.out.print("Nhap gia tri cho bien Static: ");
        Scanner nhap = new Scanner(System.in);
        bienStatic=nhap.nextInt();
        System.out.println("Gia tri cua bien stactic: "+bienStatic);
        
    }
}
