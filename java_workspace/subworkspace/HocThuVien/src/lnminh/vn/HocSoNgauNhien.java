package lnminh.vn;

import java.util.Random;

public class HocSoNgauNhien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[]=new int[10];
		Random rd= new Random();
		System.out.println("Mảng ngẩu nhiên là: ");
		for(int i=0; i<M.length;i++)
		{
			M[i]=rd.nextInt(151)+(-100);
			System.out.print(M[i]+"\t");
		}
	}

}
