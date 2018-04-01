package lnminh.vn;

public class StringAndArray {

	public static void main(String[] args) {
		String s="Lê Ngọc Minh 581994";
		System.out.println("chiều dài chuỗi = " + s.length());
		char []arr=s.toCharArray();
		int soInHoa=0;
		int soInThuong=0;
		int soChuSo=0;
		for (int i=0;i<arr.length;i++) {
			char ch=arr[i];
			if(Character.isUpperCase(ch)){
				soInHoa++;
			}else if(Character.isLowerCase(ch)) {
				soInThuong++;
			}else if(Character.isDigit(ch)) {
				soChuSo++;
			}
		}
		System.out.println("chuoi co " + soInHoa+" ky tu hoa");
		System.out.println("chuoi co " + soInThuong+" ky tu thuong");
		System.out.println("chuoi co " + soChuSo+" chu so");
		
		String bh1 ="d:/music/nhactrinh/riengmotgoctroi.mp3";
//		String bh2 ="d:\\music\\nhactrinh\\riengmotgoctroi.mp3";
		int vtCuoi= bh1.lastIndexOf("/");
		int vtDauCham= bh1.indexOf(".");
		String tenBaiHat=bh1.substring(vtCuoi+1, vtDauCham);
		
		System.out.println("tenBaiHat: "+tenBaiHat.trim());
		
	} 
}
