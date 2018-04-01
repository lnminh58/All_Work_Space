/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.UnsupportedEncodingException;
import java.util.zip.Deflater;

/**
 *
 * @author nguyenducthao
 */
public class NewClass {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "Chuỗi cần nén";
        System.out.println("Chuỗi trước khi nén: " + str);
        // Mã hóa một chuỗi thành các byte
        byte[] inputDeflater = str.getBytes("UTF-8");
        
        // Nén các byte
        byte[] outputDeflater = new byte[100];
        Deflater myDeflater = new Deflater();
        myDeflater.setInput(inputDeflater);
        myDeflater.finish();
        myDeflater.deflate(outputDeflater);
        System.out.print("Chuỗi sau khi nén: ");
        for (int i = 0; i < outputDeflater.length; i++) {
            if (outputDeflater[i] != 0) {
                System.out.print(outputDeflater[i]);
            }
        }
        System.out.println("");
    }
}
