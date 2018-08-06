/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07;

/**
 *
 * @author nguyenducthao
 */
public class this_resolve_naming_conflicts {

    int diemtoan, diemly;

    public this_resolve_naming_conflicts(int diemtoan, int diemly) {
        this.diemtoan = diemtoan;
        this.diemly = diemly;
    }

    public static void main(String[] args) {
        this_resolve_naming_conflicts obj = new this_resolve_naming_conflicts(5, 7);
        System.out.println("Diem toan: " + obj.diemtoan + ", diem ly: " + obj.diemly);
    }
}
