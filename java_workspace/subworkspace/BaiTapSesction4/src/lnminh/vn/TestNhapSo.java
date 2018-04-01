package lnminh.vn;

import java.util.Scanner;

public class TestNhapSo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NhapSo so1= new NhapSo();
		Scanner inp = new Scanner(System.in);
		so1.moiNhap();
		so1.setGiaTri(inp.nextInt());
		System.out.println(so1);
		so1.soSanh();
	}

}
