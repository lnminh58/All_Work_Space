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
public class swap_two_number {
    int num1=1,num2=2;
    // PassByValue
    static public void swap1(int i, int j){
        int temp;
        temp=i;
        i=j;
        j=temp;
    }
    // PassByReference
    public void swap2(swap_two_number obj){
        int temp;
        temp=obj.num1;
        obj.num1=obj.num2;
        obj.num2=temp;
    }
    public static void main(String[] args) {
        // invoke PassByValue
        int num3=3,num4=4;
        System.out.println("Value of num3 and num4 after swap (PassByValue): ");
        System.out.println("num3="+num3);
        System.out.println("num4="+num4);
        swap1(num3, num4);
        System.out.println("Value of num3 and num4 after swap (PassByValue): ");
        System.out.println("num3="+num3);
        System.out.println("num4="+num4);
        
        // invoke PassByReference
        swap_two_number swapObj=new swap_two_number();
        System.out.println("Value of num1 and num2 after swap (PassByReference): ");
        System.out.println("num1="+swapObj.num1);
        System.out.println("num2="+swapObj.num2);
        swapObj.swap2(swapObj);
        System.out.println("Value of num3 and num4 after swap (PassByReference): ");
        System.out.println("num1="+swapObj.num1);
        System.out.println("num2="+swapObj.num2);
    }
}
