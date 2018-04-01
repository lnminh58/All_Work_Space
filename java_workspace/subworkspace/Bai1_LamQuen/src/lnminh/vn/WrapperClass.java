package lnminh.vn;

public class WrapperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="11234";
		int i=Integer.valueOf(11234); // Integer.valueOf(str);
		int j=Integer.parseInt(str);
		System.out.println(i+"    "+j);
		System.out.println("=============================");
		int a=10;
		String str1="1B";
		int k=Integer.valueOf(str1,30);
		System.out.println(k);

	}

}
