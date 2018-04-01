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
public class multi_dimensional_array {

    public static void main(String[] args) {
//        khai bao mang 2 chieu
//        cach 1
        int[][] mang2chieu1;
        mang2chieu1 = new int[2][3];
        for (int i = 0; i < 2; i++)
//        hoac su dung
//        for(int i=0;i<mang2chieu1.length;i++)
        {
            for (int j = 0; j < 3; j++)
//        hoac su dung
//        for(int j=0;j<mang2chieu1[i].length;j++)
            {
                mang2chieu1[i][j] = j;
            }
        }
        System.out.print("Gia tri cua mang2chieu1");
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                System.out.print(mang2chieu1[i][j] + " ");
            }
        }
//        cach 2
        System.out.println("");
        int[][] mang2chieu2 = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                mang2chieu2[i][j] = j;
            }
        }
        System.out.print("Gia tri cua mang2chieu2");
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                System.out.print(mang2chieu2[i][j] + " ");
            }
        }
//        khai bao mang 2 chieu va khoi tao gia tri cua mang ngay khi khai bao
        System.out.println("");
        int[][] mang2chieu3 = {{0, 1, 2}, {0, 1, 2}};
        System.out.print("Gia tri cua mang2chieu3");
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                System.out.print(mang2chieu3[i][j] + " ");
            }
        }
    }
}
