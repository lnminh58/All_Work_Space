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
public class continue_loop {

    public static void main(String[] args) {
        System.out.print("Hiển thị các số từ 1 đến 5 và từ 7 đến 10 (sử dụng 1 vòng lặp for với câu lệnh continue): ");
        for (int i = 1; i <= 10; ++i) {
            if (i == 6) {
                continue;
            }
            System.out.print(i + " ");
        }

        System.out.println("");
    }
}
