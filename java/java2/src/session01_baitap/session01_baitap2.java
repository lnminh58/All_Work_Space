/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01_baitap;

/**
 *
 * @author nguyenducthao
 */
class LoiChiaChoKhong extends Exception {

    LoiChiaChoKhong() {
        System.out.println("Lỗi chia cho 0");
    }

}

public class session01_baitap2 {

    void Chia2So(int num1, int num2) throws LoiChiaChoKhong {
        try {
            System.out.println("num1/num2=" + num1 / num2);
        } catch (ArithmeticException e) {
            throw new LoiChiaChoKhong();
        }
    }

    public static void main(String[] args) {
        int num1, num2;
        num1 = 10;
        num2 = 0;
        try {
            session01_baitap2 obj = new session01_baitap2();
            obj.Chia2So(10, 0);
        } catch (LoiChiaChoKhong e) {
        }
    }
}
