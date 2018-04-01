/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session08;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author nguyenducthao
 */
public class InetAddress_geAlltByName {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] address3 = InetAddress.getAllByName("nguyenducthao");
            for (int i = 0; i < address3.length; i++) {
 
                System.out.println(address3[i]);
            }
    }
}
