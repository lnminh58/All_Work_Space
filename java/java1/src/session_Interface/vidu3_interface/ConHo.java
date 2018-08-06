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
public class ConHo implements DongVat_Interface{

    @Override
    public void an() {
        System.out.println("Con hổ chỉ ăn thịt");
    }

    @Override
    public void chay() {
        System.out.println("Con hổ chạy bằng bốn chân");
    }
    public static void main(String[] args) {
        ConHo conho=new ConHo();
        conho.an();
        conho.chay();
    }
}
