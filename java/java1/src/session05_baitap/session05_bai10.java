/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//10. Viết chương trình vẽ hình chữ nhật bằng các dấu *
//	**********
//	**********
//	**********
//	**********
package session05_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session05_bai10 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap chieu dai cua hinh chu nhat: ");
        int chieudai=nhap.nextInt();
        System.out.println("Nhap chieu cao cua hinh chu nhat: ");
        int chieucao=nhap.nextInt();
        for(int i=0;i<chieucao;i++){
            for(int j=0;j<chieudai;j++)
                System.out.print("*");
            System.out.println("");
        }
            
    }
}
