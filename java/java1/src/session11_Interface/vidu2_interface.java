/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session11_Interface;

/**
 *
 * @author nguyenducthao
 */
interface DongVat {
    public abstract void An();

    public abstract void Chay();
}

class ConNguoi1 implements DongVat {

    @Override
    public void An() {
        System.out.println("Con người ăn được nhiều loại thức ăn");
    }

    @Override
    public void Chay() {
        System.out.println("Con người chạy bằng hai chân");
    }

}

class ConHo implements DongVat {

    @Override
    public void An() {
        System.out.println("Con hổ chỉ ăn thịt");
    }

    @Override
    public void Chay() {
        System.out.println("Con hổ chạy bằng bốn chân");
    }

}

public class vidu2_interface {

    public static void main(String[] args) {
        ConNguoi1 connguoi = new ConNguoi1();
        connguoi.An();;
        connguoi.Chay();
        ConHo conho = new ConHo();
        conho.An();
        conho.Chay();
    }
}
