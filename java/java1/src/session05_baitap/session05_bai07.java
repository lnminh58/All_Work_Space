/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//7. Viết chương trình tính tổng nghịch đảo của N số nguyên đầu tiên theo công thức
//S = 1 + 1/2 + 1/3 + … + 1/N
package session05_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session05_bai07 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap so nguyen N: ");
        int n = nhap.nextInt();
        float tongnghichdao=0;
        for(int i=1;i<=n;i++)
            tongnghichdao=tongnghichdao+(1/(float)i);
        System.out.println("Tong nghich dao cua N so nguyen la: "+tongnghichdao);
    }
}
