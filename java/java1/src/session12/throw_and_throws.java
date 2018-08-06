/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session12;
/**
 *
 * @author nguyenducthao
 */
class MyException extends Exception{
    
}
public class throw_and_throws {
//    public void show(){
public void kiemtraloi() throws MyException{
//    throw new MyException();
    throw new MyException();
}
    public void phepchia(int a, int b){
        if(b==0)
            throw new ArithmeticException(" chia cho 0");
    }

    public static void main(String[] args) {
        throw_and_throws obj=new throw_and_throws();
        try{
        obj.phepchia(1, 0);
        }
        catch(ArithmeticException error){
            System.out.println("Xuat hien loi"+error.getMessage());
        }
    }
}
