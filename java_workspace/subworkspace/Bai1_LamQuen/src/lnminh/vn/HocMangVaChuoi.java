package lnminh.vn;

import java.util.Iterator;
import java.util.Scanner;
class Chuoi {
	private String giatri;

	public String getGiatri() {
		return giatri;
	}

	public void setGiatri(String giatri) {
		this.giatri = giatri;
	}
	

	public Chuoi() {
		super();
	}

	public Chuoi(String giatri) {
		super();
		this.giatri = giatri;
	}

	@Override
	public String toString() {
		return "Chuoi [giatri=" + giatri + "]";
	}
	
}
public class HocMangVaChuoi {

	public static void main(String[] args) {
		int[] m = new int[5];
		float[] m1 = {1, 3, 5.6f};
		/*
		 * for (float f : m1) { System.out.println(f); }
		 */
		/*System.out.println("============================");
		int[][] m2 = {{1, 2}, {3, 10}, {11, -2}};// 0 0, 0 1, 1 0, 1 1, 2 0, 2 1
		System.out.println(m2.length);
		for (int[] is : m2) {
			for (int i : is) {
				System.out.print(i + "\t");
			}
			System.out.println("");
		}
		System.out.println("=========================");
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2[i].length; j++) {
				System.out.print(m2[i][j] + "\t");
			}
			System.out.println("");
			
		}*/
		System.out.println("============================");
		
		Chuoi[] arrChuoi = new Chuoi[3];
		for (int i = 0; i < arrChuoi.length; i++) {
			System.out.println("nhap vao");
			Scanner input  = new Scanner(System.in);
			String str= input.nextLine();
			arrChuoi[i]=new Chuoi(str);
		}
		for (Chuoi chuoi : arrChuoi) {
			System.out.println(chuoi);
		}
		
	}

}
