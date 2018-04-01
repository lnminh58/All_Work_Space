/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session09;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nguyenducthao
 */
/*Bước 2:Tạo lớp thực thi Implements cho Interface.
Lớp cài đặt không những cài đặt phần thực thi cho Interface Class 
mà còn phải thừa kế từ một lớp của Java là lớp UnicastRemoteObject.
*/
public class step2_CalculatorImpl extends UnicastRemoteObject implements step1_Calculator{
    public step2_CalculatorImpl() throws RemoteException {
    }

    public int addNum(int x,int y)throws RemoteException {
        System.out.println("Client request to Calculator!!");
      return (x+y);
    }
}
