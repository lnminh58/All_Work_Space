package lnminh.vn;

import java.text.DecimalFormat;

public class HocXuLyToanHoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 25;
		System.out.println("Căn bậc 2 của 25 : "+Math.sqrt(n));
		
		int x=8;
		int y=2;
		System.out.println(x+"^"+y+"= "+Math.pow(x, y));
		int k=-23;
		System.out.println("|" +k+"|="+ Math.abs(k));
		double bankinh= 7.5;
		double dientich= Math.PI*Math.pow(bankinh, 2);
		
		DecimalFormat dcf = new DecimalFormat("#.##");
		System.out.println("diện tích đường tròn có bán kính " + bankinh+ " là: "+dcf.format(dientich));
		int goc=30;
		//double radian=Math.PI*goc/180;
		System.out.println("Sin("+goc+")="+Math.sin(Math.toRadians(goc)));
		System.out.println("Cos("+goc+")="+Math.cos(Math.toRadians(goc)));
		System.out.println("Tan("+goc+")="+Math.tan(Math.toRadians(goc)));
		System.out.println("Cotan("+goc+")="+1/Math.tan(Math.toRadians(goc)));
		
		
		
	}

}
