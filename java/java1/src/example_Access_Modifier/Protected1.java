/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Protected1;

/**
 *
 * @author nguyenducthao
 */
public class Protected1 {
    protected void msg(){
        System.out.println("Access Modifier: Protected");
    }
    public static void main(String[] args) {
        Protected1 test = new Protected1();
        test.msg();
    }
}
