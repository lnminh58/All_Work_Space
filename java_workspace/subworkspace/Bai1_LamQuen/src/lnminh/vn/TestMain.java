package lnminh.vn;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class TestMain {
	
	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		int a;
 		Scanner input= new Scanner(System.in);
 		System.out.println("nhập vào số thứ nhất");
		a= input.nextInt();
		System.out.println("nhập vào một dòng");
		input= new Scanner(System.in);
		String ten= input.nextLine();
		System.out.println("tên là "+ ten);
 	}
}
