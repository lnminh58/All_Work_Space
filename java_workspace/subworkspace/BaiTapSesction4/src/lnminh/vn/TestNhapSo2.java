package lnminh.vn;

import java.util.Scanner;

public class TestNhapSo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HaiSo hs = new HaiSo();
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào số thứ nhất: ");
		hs.setSoThuNhat(input.nextInt());
		System.out.println("Nhập vào số thứ hai: ");
		hs.setSoThuHai(input.nextInt());
		if(hs.getSoThuHai()==0) {
			System.out.println("không thể xét cho số 0");
		}else {
			if((hs.getSoThuNhat()%hs.getSoThuHai())==0) {
				System.out.println("Số thứ nhất chia hết cho số thứ 2");
			}else {
				System.out.println("Số thứ nhất không chia hết cho số thứ 2");
			}
		}
		
		
	}

}
