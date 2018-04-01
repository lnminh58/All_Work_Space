/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session08;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyenducthao
 */
public class arraylist {

    public static void main(String[] args) {
//        khai báo 1 ArrayList rỗng: dùng ArrayList()
        ArrayList arrayList1 = new ArrayList();
//        khai báo 1 ArrayList: dùng ArrayList(Collection c)
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList arrayList2 = new ArrayList(list);
        System.out.print("Cac phan tu cua arrayList2: ");
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.print(arrayList2.get(i) + " ");
        }
//        khai báo 1 ArrayList có số phân tử cố định: dùng ArrayList(int sophantu)
        ArrayList arrayList3 = new ArrayList(10);
//        các ví dụ về method của ArrayList
        ArrayList arrayList4 = new ArrayList();
        System.out.println("");
        System.out.println("So phan tu cua arrayList4 la: " + arrayList4.size());
        for (int i = 0; i < 5; i++) {
            arrayList4.add(i);  //boolean add(Ojbect o): thêm vào cuối ArrayList
        }
        System.out.println("So phan tu cua arrayList4 sau khi them 5 phan tu la: " + arrayList4.size());
        System.out.print("Gia tri cac phan tu cua arrayList4 la: ");
        for (int i = 0; i < arrayList4.size(); i++) {
            System.out.print(arrayList4.get(i) + " ");
        }
        System.out.println("");
        arrayList4.add(1, 5);    //void add(int index, Object o)
        System.out.print("Gia tri cac phan tu cua arrayList4 sau khi insert so 5 tai index=1 la: ");
        for (int i = 0; i < arrayList4.size(); i++) {
            System.out.print(arrayList4.get(i) + " ");
        }
//        arrayList4.clear(); //void clear(): xóa tất cả các phần tử của ArrayList
//        System.out.println("");
//        System.out.println("So phan tu cua arrayList4 sau khi clear la: " + arrayList4.size());
        ArrayList arrayList5 = (ArrayList) arrayList4.clone();  //Object clone(): sao chép một ArrayList
        System.out.println("");
        System.out.print("Gia tri cac phan tu cua arrayList5 sau khi clone tu arrayList4: ");
        for (int i = 0; i < arrayList5.size(); i++) {
            System.out.print(arrayList5.get(i) + " ");
        }
        System.out.println("");
        Object arrayList4Object = arrayList4.clone();  //sử dụng clone() cho một Object
//        System.out.println("");
//        System.out.print("Gia tri cua object arrayList4Object sau khi clone tu arrayList4 la: "+arrayList4Object);
//        System.out.println("");

        if (arrayList4.contains(1)) //boolean contains(Object o): kiểm tra Object o có tồn tại trong ArrayList hay ko
        {
            System.out.println("Trong arrayList4 ton tai phan tu co gia tri=1");
        } else {
            System.out.println("Trong arrayList4 khong ton tai phan tu co gia tri=1");
        }

//        int indexOf(Object o): trả về vị trí xuất hiện đầu tiên của object o
//        int lastIndexOf(Object o): trả về vị trí xuất hiện cuối cùng của object o
        ArrayList<Integer> arrayList6 = new ArrayList<>();
        arrayList6.add(0);
        arrayList6.add(1);
        arrayList6.add(1);
        arrayList6.add(2);
        arrayList6.add(3);
        arrayList6.add(3);
        System.out.println("Vi tri xuat hien dau tien cua so 1 trong arayList6 la: " + arrayList6.indexOf(1));
        System.out.println("Vi tri xuat hien cuoi cung cua so 3 trong arayList6 la: " + arrayList6.lastIndexOf(3));
        ArrayList<Integer> arrayList7 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList7.add(i + 1);
        }
        System.out.print("Gia tri cua arrayList7 truoc khi su dung method set la: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(arrayList7.get(i) + " ");
        }
        arrayList7.set(0, 10);
        System.out.println("");
        System.out.print("Gia tri cua arrayList7 sau khi su dung method set gia tri 10 tai vi tri index=0 la: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(arrayList7.get(i) + " ");
        }

        System.out.println("");
//        Object[] toArray(): chuyển ArrayList thành mảng Object
        Object[] obj = arrayList7.toArray();
        System.out.print("Gia tri cua mang obj la: ");
        for (int i = 0; i < obj.length; i++) {
            System.out.print(obj[i] + " ");
        }
        System.out.println("");
//        chuyển mảng object thành mảng 1 chiều,
//        vì ko thể lấy giá trị các phần tử của mảng object để tính toán khi mảng object được chuyển từ ArrayList
        int[] mang = new int[obj.length];
        for (int i = 0; i < mang.length; i++) {
            mang[i] = (int) obj[i];
        }
        System.out.print("Gia tri cac phan tu mang 1 chieu duoc lay tu mang object: ");
        for (int i = 0; i < mang.length; i++) {
            System.out.print(mang[i] + " ");
        }
    }
}
