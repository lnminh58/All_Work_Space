/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session02_baitap;

/**
 *
 * @author nguyenducthao
 */
public class session02_baitap1 {

    String name;

    public session02_baitap1(String name) {
        this.name = name;
    }

    static void sosanh1(session02_baitap1 obj1, session02_baitap1 obj2) {
        if (obj1.name.equalsIgnoreCase(obj2.name)) {
            System.out.println("Giá trị thuộc tính của 2 đối tượng bằng nhau");
        } else {
            System.out.println("Giá trị thuộc tính của 2 đối tượng không bằng nhau");
        }
    }

    public static void main(String[] args) {
        session02_baitap1 obj1 = new session02_baitap1("object1");
        session02_baitap1 obj2 = new session02_baitap1("object2");
        sosanh1(obj1, obj2);

    }
}
