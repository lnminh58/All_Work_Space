package lnminh.vn;

public class ToiUuChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ten = "  Lê Ngọc   Minh";
		System.out.println(ten);
		ten=ten.trim();
		String	[]arr = ten.split(" ");
		String tenToiUu = "";
		for (String tu : arr) {
			if (tu.trim().length() != 0) 
				tenToiUu += tu+" ";
		}
		tenToiUu = tenToiUu.trim();
		System.out.println(tenToiUu);
	}

}
