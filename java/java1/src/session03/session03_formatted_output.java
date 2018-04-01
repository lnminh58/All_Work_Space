/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

/**
 *
 * @author ndt
 */
//import java.util.Formatter;
//import java.util.Locale;
import java.util.*;
public class session03_formatted_output {
    
    public static void main(String[] args) {
        int a=1,b=2,c=3;
        float tbc;
        tbc=((float)b+(float)c)/2;

        System.out.println("Tong cua a="+a+" + b="+b+" + c="+c+" la: "+ (a+b+c));
        System.out.printf("Tong cua a=%d + b=%d + c=%d la: %d %n",a,b,c,(a+b+c));
        System.out.printf("Trung binh cong cua b=%d va c=%d la %f %n",b,c,tbc);
        System.out.format("Trung binh cong cua b=%d va c=%d la %f %n",b,c,tbc);
//        %arg_index:
        System.out.format("%4$2s %3$2s %2$2s %1$2s%n", "a", "b", "c", "d");
//        Locale:
//        System.out.format(Locale.FRANCE, "e = %10.4f %n", Math.PI);
//        "-": Left justiify
        System.out.format("TBC with - = %-10.4f %n", tbc);
//        "+": include a sign (+ or -)
        tbc=123;
        System.out.format("TBC with + = %+10.4f %n", tbc);
        tbc=123;
//        "0": pad with zeros
        System.out.format("TBC with 0 = %010.4f %n", tbc);
//        ",": use locale-specific grouping separators
        tbc=123456789;
        System.out.format("TBC with , = %,.4f %n", tbc);
//        "(": enclose negative number
        tbc=-tbc;
        System.out.format("TBC with ( = %(,.4f %n", tbc);
//        Sự khác nhau giữa prinf và format:
//        các phương thức printf() và format() để in output với các số được định dạng.
//        Lớp String có một phương thức lớp tương đương, là format(), 
//        mà trả về một đối tượng String chứ không là một đối tượng PrintStream.
//        Sử dụng phương thức format() của đối tượng String cho phép bạn tạo một chuỗi đã được định dạng
//        để bạn có thể tái sử dụng, trái ngược với lệnh in một lần
        String str;
        int temp;
        temp=1;
        str=String.format("Temp=%d", temp);
        System.out.println(str);
        temp=10;
        str=String.format("Temp=%d", temp);
        System.out.println(str);
    }
}
