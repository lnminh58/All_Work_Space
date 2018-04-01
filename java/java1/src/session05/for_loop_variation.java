/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session05;

/**
 *
 * @author nguyenducthao
 */
public class for_loop_variation {
    public static void main(String[] args) {
        System.out.print("Hiển thị các số từ 1 đến 10 (sử dụng vòng lặp for có biến điều khiển): ");
        boolean exitForLoop=false;
        for(int i=1;!exitForLoop;++i){
            System.out.print(i+" ");
            if(i==10){
                exitForLoop=true;
            }
        }
        System.out.println("");
    }
}
