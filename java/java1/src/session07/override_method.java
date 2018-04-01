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
class test1 {

    void display() {
        System.out.println("This is class test1");
    }
}

class test2 extends test1 {
@Override
    void display() {
        System.out.println("This is class test2");
    }
}

public class override_method {

    public static void main(String[] args) {
        test2 test22 = new test2();
        test22.display();
    }

}
