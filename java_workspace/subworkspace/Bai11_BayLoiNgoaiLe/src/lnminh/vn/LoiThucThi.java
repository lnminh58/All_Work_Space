package lnminh.vn;

public class LoiThucThi {

	public static void main(String[] args) {
		
		try {
			
			int x=1/0;
			System.out.println("Bên trên có lỗi thực thi");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Tạm Biệt");
	}
}
