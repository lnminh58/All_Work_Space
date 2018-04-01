/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//6. Viết chương trình nhập vào N số nguyên và tính tổng bậc 3 N số nguyên.
package session05_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session05_bai06 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen N: ");
        int n=nhap.nextInt();
        long tong=0;
        for(int i=1;i<=n;i++)
            tong=tong+(i*i*i);
        System.out.println("Tong bac 3 cua N so nguyen la: "+tong);
    }
}
