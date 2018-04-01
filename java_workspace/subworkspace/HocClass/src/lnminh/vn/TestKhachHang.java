package lnminh.vn;

public class TestKhachHang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KhachHang minh= new KhachHang();
		minh.setMa("NV1");
		minh.setTen("Lê Ngọc Minh");
		minh.setTuoi(23);
		minh.setDiaChi("08 Nguyễn Nghiêm");
		//System.out.println(minh.toString());
		KhachHang ki = new KhachHang("NV2","Lê Ki",24,"Tổ 31 Hòa Khê");
		System.out.println(minh.toString());
		System.out.println(ki.toString());
		minh=ki;
		System.out.println("====================");
		System.out.println(minh.toString());
		System.out.println(ki.toString());
		minh.setTen("Ô la la");
		System.out.println("====================");
		System.out.println(minh.toString());
		System.out.println(ki.toString());
		System.out.println("====================");
		System.out.println(minh);
		System.out.println(ki);
		
		System.out.println("=======================");
		System.out.println("x= " +minh.layThongTinCuaX());
		KhachHang me = new KhachHang();
		me.doiThongTinCuaX(100);
		System.out.println("x= " +minh.layThongTinCuaX());
		System.out.println("x= " +me.layThongTinCuaX());
		System.out.println("x= " +ki.layThongTinCuaX());

	}

}
