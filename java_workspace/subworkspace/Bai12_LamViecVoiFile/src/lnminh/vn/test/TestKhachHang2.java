package lnminh.vn.test;

import java.util.ArrayList;

import lnminh.vn.io.SerializeFileFactory;
import lnminh.vn.io.TextFileFactory;
import lnminh.vn.model.KhachHang;

public class TestKhachHang2 {
	public static void testLuuFile(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		dsKH.add(new KhachHang("KH01","Nguyễn Thị An"));
		dsKH.add(new KhachHang("KH02","Trần Văn Kha"));
		dsKH.add(new KhachHang("KH02","Trần kiều Giang"));
		dsKH.add(new KhachHang("KH04","Nguyễn Trần Bảo Quyên"));
		boolean kt= SerializeFileFactory.luuFile(dsKH, "E:\\workspace\\File hệ thống\\dulieu2.txt" );
		if (kt==true){
			System.out.println("Đã lưu File thành công");
		}
		else{
			System.out.println("Đã lưu File thất bại");
		}
	}
	
	public static void testDocFile()
	{
		ArrayList<KhachHang> dsKH=SerializeFileFactory.docFile("E:\\workspace\\File hệ thống\\dulieu2.txt" );
		System.out.println("Danh sách khách hàng đã nạp vào máy tính: ");
		System.out.println("Mã\tTên");
		for (KhachHang kh : dsKH) {
			System.out.println(kh);
		}		
	}
	public static void main(String[] args) {
		
	testDocFile();
	}

}
