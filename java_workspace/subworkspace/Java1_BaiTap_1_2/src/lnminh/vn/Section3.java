package lnminh.vn;

import java.util.Scanner;

public class Section3 {
	int a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// câu 1
		/*
		int a;
		System.out.println("Nhập vào một số");
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		System.out.println("Số vừa nhập là: " + a);
	}
	*/
		// câu 2
		Section3 ss1=new Section3();
		System.out.println("Nhập vào một số");
		ss1.a=input.nextInt();
		
		System.out.println("Số vừa nhập là:"+ ss1.a);
	}
	
	
}
