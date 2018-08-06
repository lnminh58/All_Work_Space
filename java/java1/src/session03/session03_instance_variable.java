/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

/**
 *
 * @author nguyenducthao
 */
public class session03_instance_variable {
    public int i;
    public static int j;
    public session03_instance_variable (int x){
      i = x;
   }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("Welcome to the world of Java");
        session03_instance_variable var1 = new session03_instance_variable(1);
        System.out.println("Gia tri bien i: "+var1.i);
        j=2;
        System.out.println("Gia tri bien j: "+j);
        {
            int local_variable;
            local_variable=10;
            System.out.println("Gia tri bien local_variable: "+local_variable);
        }
//        System.out.println("Gia tri bien local_variable: "+local_variable);
//            session03_instance_variable var2=null;
//            var2=new session03_instance_variable(20);
//            System.out.println("Gia tri bien i: "+var2.i);
    }
}
