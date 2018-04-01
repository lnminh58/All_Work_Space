package lnminh.vn;

import java.util.Scanner;

public class HocSwitch {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int thang;
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập tháng:");
		thang=sc.nextInt();
		switch(thang){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("tháng "+thang+ " có 31 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("tháng "+thang+ " có 30 ngày");
			break;
		case 2:
			System.out.println("tháng "+thang+" có 28 ngày");
			break;
		default:
			System.out.println("Bạn nhập sai");
		}
	}

}
