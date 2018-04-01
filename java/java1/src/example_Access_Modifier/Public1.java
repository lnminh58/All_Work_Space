/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public1;

/**
 *
 * @author nguyenducthao
 */
public class Public1 {
    public void msg(){
        System.out.println("Access Modifier: Public");
    }
    public static void main(String[] args) {
        Public1 test = new Public1();
        test.msg();
    }
}
