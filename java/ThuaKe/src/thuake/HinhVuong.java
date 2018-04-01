/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuake;

/**
 *
 * @author lnmin
 */
public class HinhVuong extends DoanThang{
    

    public HinhVuong() {
    }

    public HinhVuong(float doDaiDoan) {
        super(doDaiDoan);
    }


    public double tinhDienTich(){
        return Math.pow(getDoDaiDoan(), 2);
    }
    @Override
    public String toString() {
        return "Độ dài cạnh: "+getDoDaiDoan()+"\nHinhVuong{" + "dienTich=" + tinhDienTich() + '}';
    }
    
    
    
}
