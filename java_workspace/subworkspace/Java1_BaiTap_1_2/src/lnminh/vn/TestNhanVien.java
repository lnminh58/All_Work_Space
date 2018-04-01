package lnminh.vn;

public class TestNhanVien {
	public static void main(String[] args){
		NhanVien nv01= new NhanVien();
		nv01.setTen("Minh");
		nv01.setTuoi(23);
		System.out.println(nv01.getTen()+"    "+nv01.getTuoi());
		
	}
}
