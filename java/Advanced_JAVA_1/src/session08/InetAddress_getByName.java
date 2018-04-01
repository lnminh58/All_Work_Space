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
public class InetAddress_getByName {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("nguyenducthao");
            System.out.println(address.getHostAddress());
            address = InetAddress.getByName("192.168.61.139");
            System.out.println(address.getHostName());
            
    }
}
