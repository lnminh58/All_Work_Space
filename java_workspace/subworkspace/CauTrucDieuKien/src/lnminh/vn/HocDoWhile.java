package lnminh.vn;

import java.util.Scanner;

public class HocDoWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int so;
		System.out.println("Nhập vào số cần tính giai thừa: ");
		so= sc.nextInt();
		// TODO Auto-generated method stub
		long n=1;
		int i=1;
		
		while(i<=so)
			{
				n=n*i;
				i++;
			}
		System.out.println(so+ "!=" + n);
			
	}

}
