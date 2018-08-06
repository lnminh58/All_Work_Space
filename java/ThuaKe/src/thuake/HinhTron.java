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
public class HinhTron extends DoanThang {
    private float hoanhDoTam;
    private float tungDoTam;

    public HinhTron() {
    }

    public HinhTron(float hoanhDoTam, float tungDoTam, float doDaiDoan) {
        super(doDaiDoan);
        this.hoanhDoTam = hoanhDoTam;
        this.tungDoTam = tungDoTam;
    }
    public HinhTron(float hoanhDoTam, float tungDoTam) {
        this.hoanhDoTam = hoanhDoTam;
        this.tungDoTam = tungDoTam;
    }
    

    public float getHoanhDoTam() {
        return hoanhDoTam;
    }

    public void setHoanhDoTam(float hoanhDoTam) {
        this.hoanhDoTam = hoanhDoTam;
    }

    public float getTungDoTam() {
        return tungDoTam;
    }

    public void setTungDoTam(float tungDoTam) {
        this.tungDoTam = tungDoTam;
    }
    public double tinhDienTich(){
        return Math.PI*Math.pow(getDoDaiDoan(), 2);
    }

    @Override
    public String toString() {
        return "HinhTron{" + "hoanhDoTam=" + hoanhDoTam + ", tungDoTam=" + tungDoTam +"\n\tDiện Tích:" + tinhDienTich()+"}";
    }
    
}
