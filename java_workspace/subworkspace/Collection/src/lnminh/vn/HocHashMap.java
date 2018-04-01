package lnminh.vn;

import java.util.HashMap;

public class HocHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer , String> ds = new HashMap<Integer, String>();
		ds.put(001, "Nguyễn Văn A");
		ds.put(002, "Trần Văn Thanh");
		ds.put(003, "Lê Ngọc Minh");
//		
//		String nv = ds.get(002);
//		System.out.println(nv);
		ds.remove(003);
		System.out.println("Danh sách nhân viên: ");
		for(String ten : ds.values())
		{
			System.out.println(ten);
		}
	}

}
