package lnminh.vn.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import lnminh.vn.io.SerializeFileFactory;
import lnminh.vn.model.KhachHang;

public class TestKhachHang {
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	public static void menu(){
		System.out.println("1.Nhập khách hàng");
		System.out.println("2.Xuất khách hàng");
		System.out.println("3.Tìm kiếm khách hàng");
		System.out.println("4.Sắp xếp khách hàng");
		System.out.println("5.Lưu khách hàng");
		System.out.println("6.Đọc khách hàng");
		System.out.println("7.Thống kê theo nhà mạng");
		System.out.println("8.Thoát");
		int chon = 0;
		System.out.println("Mời bạn chọn chức năng[1...8]: ");
		chon= new Scanner(System.in).nextInt();
		switch (chon){
		case 1:
			xuLyNhap();
			break;
		case 2:
			xuLyXuat();
			break;
		case 3: 
			xuLyTim();
			break;
		case 4:
			xuLySapXep();
			break;
		case 5:
			xuLyLuu();
			break;
		case 6:
			xuLyDoc();
			break;
		case 7:
			xuLyThongKe();
			break;
		case 8:
			xuLyThoat();
			break;
		default:
			break;
		}
	}
	private static void xuLyThoat() {
		System.out.println("Cảm ơn bạn đã dùng phần mềm. BYE BYE!!!");
		System.exit(0);
	}
	private static void xuLyThongKe() {
		// TODO Auto-generated method stub
		int n=0;
		for(KhachHang kh : dsKH){
			if(kh.getPhone().startsWith("099")){
				n++;
			}
		}
		System.out.println("Số lượng khách hàng có đầu số 099: "+n);
	}
	private static void xuLyDoc() {
		dsKH=SerializeFileFactory.docFile("E:\\workspace\\File hệ thống\\dulieu.txt");
		System.out.println("Đã đọc File thành công1");
	}
	private static void xuLyLuu() {
		boolean kt= SerializeFileFactory.luuFile(dsKH, "E:\\workspace\\File hệ thống\\dulieu.txt");
		if(kt=true){
			System.out.println("Đã lưu File thành công");
		}
		else{
			System.out.println("Đã lưu File thất bại");

		}
	}
	private static void xuLySapXep() {
		// TODO Auto-generated method stub
		Collections.sort(dsKH);
		System.out.println("Đã sắp xếp theo sdt");
	}
	private static void xuLyTim() {
		System.out.println("Mời bạn nhập đầu số cần tìm: ");
		String phone=new Scanner(System.in).nextLine();
		ArrayList<KhachHang> dsTK = new ArrayList<KhachHang>();
		for(KhachHang kh : dsKH){
			if(kh.getPhone().startsWith(phone)){
				dsTK.add(kh);
			}
		}
		if(dsTK.size()!=0){			
			System.out.println("=========================");
			System.out.println("Mã\tTên\tPhone");
			for (KhachHang kh : dsTK) {
				System.out.println(kh);
			}
		}
		else{
			System.out.println("Không có khách hàng cần tìm.");
		}
		
		
	}
	private static void xuLyXuat() {
		System.out.println("=========================");
		System.out.println("Mã\tTên\tPhone");
		for (KhachHang kh : dsKH) {
			System.out.println(kh.toString());
		}
		System.out.println("=========================");
		
	}

	private static void xuLyNhap() {
		KhachHang kh=new KhachHang();
		System.out.println("Mời bạn nhập mã: ");
		int ma=new Scanner(System.in).nextInt();
		System.out.println("Mời bạn nhập tên: ");
		String ten=new Scanner(System.in).nextLine();
		System.out.println("Mời bạn nhập số Phone:");
		String phone=new Scanner(System.in).nextLine();
		kh.setMa(ma);
		kh.setTen(ten);
		kh.setPhone(phone);
		dsKH.add(kh);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			menu();
		}
	}

}
