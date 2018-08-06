/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session08;

/**
 *
 * @author nguyenducthao
 */
public class single_dimensional_array {

    public static void main(String[] args) {
//        khai bao mang1 chieu
//        cách 1:        
        int[] mang1chieu1;
        mang1chieu1 = new int[10];
        for (int i = 0; i < mang1chieu1.length; i++) {
            mang1chieu1[i] = i;
        }
        System.out.print("Gia tri cac phan tu mang1chieu1: ");
        for (int i = 0; i < mang1chieu1.length; i++) {
            System.out.print(mang1chieu1[i] + " ");
        }
        System.out.println("");
//        cách 2
        int[] mang1chieu2 = new int[10];
        for (int i = 0; i < mang1chieu2.length; i++) {
            mang1chieu2[i] = i;
        }
        System.out.print("Gia tri cac phan tu mang1chieu2: ");
        for (int i = 0; i < mang1chieu2.length; i++) {
            System.out.print(mang1chieu2[i] + " ");
        }
//        khai bao mang 1 chieu va khoi tao gia tri cua mang ngay khi khai bao
        int[] mang1chieu3 = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("");
        System.out.print("Gia tri cac phan tu mang1chieu3: ");
        for (int i = 0; i < mang1chieu3.length; i++) {
            System.out.print(mang1chieu3[i] + " ");
        }
    }
}
