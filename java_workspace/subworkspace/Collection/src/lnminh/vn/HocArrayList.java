package lnminh.vn;

import java.util.ArrayList;
import java.util.Random;

public class HocArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	ArrayList ds= new ArrayList();
		ds.add("re");
		ds.add(9.3);*/
		ArrayList ds= new ArrayList();
		ds.add("Lê");
		ds.add("Ngọc");
		ds.add("Minh");
		ds.add("của");
		ds.add(3, "chèn");
		String s;
		/*for(int i=0;i<ds.size();i++)
		{
			s=(String)ds.get(i);
			System.out.println(s);
		}*/
		System.out.println("=======================");
		
		for(Object data : ds){
			System.out.println(data);
		}
		/*ArrayList<Double> ds1= new ArrayList<Double>();
		for (int i = 0; i < 100; i++) {
			ds1.add(i*2.0);
		}
		for(double x : ds1)
		{
			System.out.println(x);
		}*/
		ArrayList<Float> ds2 = new ArrayList<Float>();
		ds2.add(3.24F);
		ds2.add(1.5f);
		ds2.add(43.11f);
		//ds2.remove(1.5f);
		for (float x : ds2)
		{
			System.out.println(x);
		}
		ds2.set(0, 6.24f);
		for (float x : ds2)
		{
			System.out.println(x);
		}
	}

}
