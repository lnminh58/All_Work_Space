package lnminh.vn;

import java.util.ArrayList;
import java.util.Collections;

public class TestNhanVien {

	public static void main(String[] args) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		ds.add(new NhanVien(4,"Tuan"));
		ds.add(new NhanVien(3,"Mai"));
		ds.add(new NhanVien(2,"Ngan"));
		ds.add(new NhanVien(5,"Ha"));
		ds.add(new NhanVien(1,"An"));
		ds.add(new NhanVien(6,"An"));
		
		System.out.println("Nhân viên của công ty");
		for(NhanVien nv : ds)
		{
			System.out.println(nv.getMa()+"\t"+nv.getTen());
		}
		
		Collections.sort(ds);
		System.out.println("Nhân viên của công ty sau khi sắp xếp");
		for(NhanVien nv:ds)
		{
			System.out.println(nv.getMa()+"\t"+nv.getTen());
		}
	}

}
