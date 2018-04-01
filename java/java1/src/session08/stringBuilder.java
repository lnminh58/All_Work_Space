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
public class stringBuilder {

    public static void main(String[] args) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Hello");
        System.out.println("Gia tri cua stringBuilder1 la: " + stringBuilder1);
        System.out.println("Gia tri cua stringBuilder1 sau khi dung insert() la: "+stringBuilder1.insert(stringBuilder1.length(), " World"));
        stringBuilder1.append(" Hi");
        System.out.println(stringBuilder1);
        System.out.println("Gia tri cua stringBuilder1 sau khi dung delete()la: "+stringBuilder1.delete(5, 11));
        System.out.println("Gia tri cua stringBuilder1 sau khi dung reverse() la: "+stringBuilder1.reverse());
    }

}
//Lớp StringBuffer                                Lớp StringBuilder
//Lớp StringBuffer là đồng bộ (synchronized),     StringBuilder là không đồng bộ (non-synchronized),
//tức là an toàn luồng (thread safe).             tức là không an toàn luồng.
//Nghĩa là hai Thread không thể gọi đồng thời     Nghĩa là hai Thread có thể gọi đồng thời
//các phương thức của lớp StringBuffer            các phương thức của lớp StringBuilder
//StringBuffer là kém hiệu quả hơn StringBuilder	StringBuilder là hiệu quả hơn StringBuffer
