/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session08;

import java.util.ArrayList;

/**
 *
 * @author nguyenducthao
 */
public class arrayList_removeRange extends ArrayList<Integer>{
    public static void main(String[] args) {
        arrayList_removeRange arrayList_removeRange1=new arrayList_removeRange();
        for(int i=0;i<10;i++)
            arrayList_removeRange1.add(i+1);
        System.out.print("Gia tri cac phan tu cua arrayList_removeRange1 la: ");
        for(int i=0;i<arrayList_removeRange1.size();i++)
            System.out.print(arrayList_removeRange1.get(i)+" ");
            arrayList_removeRange1.removeRange(0, 2);
        System.out.println("");
        System.out.print("Gia tri cac phan tu cua arrayList_removeRange1 sau khi xoa 2 phan tu tu vi tri 0 la: ");
        for(int i=0;i<arrayList_removeRange1.size();i++)
            System.out.print(arrayList_removeRange1.get(i)+" ");
    }
}
