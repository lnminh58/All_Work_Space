/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//8. Viết chương trình nhập vào số nguyên N và tính tổng bình phương các số lẻ từ 1 đến N.
package session05_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session05_bai08 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap so nguyen N: ");
        int n=nhap.nextInt();
        long tongbinhphuongsole=0;
        for(int i=1;i<=n;i++)
            if((i%2)!=0)
                tongbinhphuongsole=tongbinhphuongsole+(i*i);
        System.out.println("Tong binh phuong cac so le tu 1 den N la: "+tongbinhphuongsole);
    }
}
