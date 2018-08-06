/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Private;

/**
 *
 * @author nguyenducthao
 */
class test{
    int i;
    void msg(){
//        private void msg(){
        System.out.println("Access Modifier: Private");
    }
}
public class Private {
    
    public static void main(String[] args) {
        test test1 = new test();
        test1.msg();        
    }
}
