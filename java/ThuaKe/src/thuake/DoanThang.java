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
public class DoanThang {
    private float doDaiDoan;

    public float getDoDaiDoan() {
        return doDaiDoan;
    }

    public void setDoDaiDoan(float doDaiDoan) {
        this.doDaiDoan = doDaiDoan;
    }

    public DoanThang() {
    }

    public DoanThang(float doDaiDoan) {
        this.doDaiDoan = doDaiDoan;
    }

    @Override
    public String toString() {
        return "DoanThang{" + "doDaiDoan=" + doDaiDoan + '}';
    }
    
    
}
