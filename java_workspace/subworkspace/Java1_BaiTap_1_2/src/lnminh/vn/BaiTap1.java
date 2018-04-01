package lnminh.vn;

import java.util.Scanner;

public class BaiTap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập số thứ nhất: ");
		float a = input.nextFloat();
		System.out.println("Nhập số thứ hai: ");
		float b = input.nextFloat();
		System.out.println("Tổng hai số vừa nhập là:"+ (a+b));
		System.out.println("Số lớn nhất là:");
		if(a>b) {
			System.out.println(a);
		}else {
			System.out.println(b);
		}
	}

}
