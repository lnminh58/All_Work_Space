/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogam;

import java.util.Vector;

/**
 *
 * @author lnmin
 */
public class NewClass {
   
    static class He {
        private int a;

        public He(int a) {
            this.a = a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getA() {
            return this.a;
        }
    }
    public static void main(String[] args) {
        final He he = new He(1);

        he.setA(3);
        System.out.println(he.getA());
    }
}