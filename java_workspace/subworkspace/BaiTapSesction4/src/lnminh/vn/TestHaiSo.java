package lnminh.vn;

import java.util.Scanner;

public class TestHaiSo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HaiSo so = new HaiSo();
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào số thứ nhất: ");
		so.setSoThuNhat(input.nextInt());
		System.out.println("Nhập vào số thứ hai: ");
		so.setSoThuHai(input.nextInt());
		int x ;
		System.out.println("Chọn phép tính (số lớn hơn đứng trước): \n1. Tính tổng \n2. Tính hiệu \n3. Tính Tích \n4. Tính Thương");
		x=input.nextInt();
		
		switch(x) {
		case 1: so.tinhTong();
				break;
		case 2: so.tinhHieu();
				break;
		case 3: so.tinhTich();
				break;
		case 4: so.tinhThuong();
				break;
		}
		System.out.println(so);
		
	}

}
