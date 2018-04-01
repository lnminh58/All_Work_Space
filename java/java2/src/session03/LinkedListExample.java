/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

import java.util.LinkedList;

/**
 *
 * @author nguyenducthao
 */
public class LinkedListExample {
    public static void main(String[] args) {
        // Tạo một đối tượng tập hợp - LinkedList
       LinkedList<String> list = new LinkedList<>();
 
       // Thêm một số phần tử vào danh sách
       list.add("F");
       list.add("B");
       list.add("D");
       list.add("E");
       list.add("C");
       // Thêm phần tử vào cuối danh sách.
       list.addLast("Z");
       // Thêm phần tử vào đầu danh sách
       list.addFirst("A");
       // Thêm phần tử vào ví trí có chỉ số 1.
       list.add(1, "A2");
        
       // Ghi ra danh sách:
       System.out.println("Original contents of list: " + list);
 
 
       // Xóa phần tử khỏi danh sách
       list.remove("F");
       // Xóa phần tử tại vị trí có chỉ số 2.
       list.remove(2);
        
       // In ra danh sách sau khi đã xóa 2 phần tử.
       System.out.println("Contents of list after deletion: " + list);
 
 
       // Xóa phần tử đầu tiên và cuối cùng trong danh sách.
       list.removeFirst();
       list.removeLast();
        
       // In ra danh sách sau khi đã xóa
       System.out.println("List after deleting first and last: " + list);
 
    
       Object val = list.get(2);
       // Sét đặt lại phần tử tại vị trí có chỉ số 2.
       list.set(2, (String) val + " Changed");
       System.out.println("List after change: " + list);
    }
}
