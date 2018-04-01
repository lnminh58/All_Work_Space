package lnminh.vn;

public class TestNhanVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NhanVien minh= new NhanVienChinhThuc();
		minh.setTen("Lê Ngọc Minh");
		minh.setCmnd("201685928");
		System.out.println(minh);
		
		NhanVien ki = new NhanVienChinhThuc();
		ki.setTen("Lê ki");
		System.out.println(ki.toString());
		
		minh = new NhanVienThoiVu();
		minh.setTen(ki.getTen());
		System.out.println(minh.toString());
	}

}
