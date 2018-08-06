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
public class XeKia implements LoaiXe_Interface, NhaSanXuat_Interface {

    @Override
    public void hienthiLoaiXe() {
        System.out.println("Loai xe: Kia Morning");
    }

    @Override
    public void hienthiNhaSanXuat() {
        System.out.println("Nha san xuat: Kia");
    }

}
