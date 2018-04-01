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
public class label_in_loop {
    public static void main(String[] args) {
//        Khai báo label cho vòng lặp bằng bất kỳ string nào với dấu hai chấm theo sau
//        và liền trước vòng lặp,
//        Với cách sử dụng break ở dạng labeled thì break sẽ có tác dụng đối với tất cả các break
//        kể từ label đến vị trí đặt break label
        toiday:
        for(int i=0;i<10;i++){
            System.out.println("i="+i);
            if(i==5){
                break toiday;
            }
        }
        System.out.println("Label: toiday");
    }
}
