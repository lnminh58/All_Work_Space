/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogam;

/**
 *
 * @author lnmin
 */
public class TestStudent {
    public static void main(String[] args) {
        Student st1 = new Student("Minh");
        Student st2 = new Student("Nhân");
        Student st3 = new Student();
        st3.setName("Thiệm");
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);
    }
}
