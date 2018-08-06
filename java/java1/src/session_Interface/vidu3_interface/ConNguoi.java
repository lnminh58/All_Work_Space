/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_Interface.vidu3_interface;

/**
 *
 * @author nguyenducthao
 */
public class ConNguoi implements DongVat_Interface {

    @Override
    public void an() {
        System.out.println("Con người ăn được nhiều loại thức ăn");
    }

    @Override
    public void chay() {
        System.out.println("Con người chạy bằng hai chân");
    }

    public static void main(String[] args) {
        ConNguoi connguoi = new ConNguoi();
        connguoi.an();
        connguoi.chay();
    }
}
