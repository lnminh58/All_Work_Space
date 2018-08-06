/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07;

/**
 *
 * @author nguyenducthao
 */
public class varargs {
    public void tinhtong(int...num){
        int tong=0;
        for(int i:num)
            tong+=i;
        System.out.println("Tong: "+ tong);
    }
    public void tinhtong1(int...intArrays){
        int tong=0;
        for(int i=0; i< intArrays.length; i++) {
         tong += intArrays[i];
      }
        System.out.println("Tong: "+ tong);
    }
    public static void main(String[] args) {
        varargs obj = new varargs();
        obj.tinhtong(1,2,3);
        obj.tinhtong(1,2,3,4);
        obj.tinhtong1(new int[] {1,2,3});
        obj.tinhtong1(new int[] {1,2,3,4});
    }
}
